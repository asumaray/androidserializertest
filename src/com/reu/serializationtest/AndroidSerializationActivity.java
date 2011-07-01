package com.reu.serializationtest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileWriter;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.reu.serializationtest.Book.Type;
import com.reu.serializationtest.BookProtos.BookProto;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class AndroidSerializationActivity extends Activity {
	private TextView lblResult;
	private Button btnXML, btnJSON, btnProtoBuf, btnThrift;
	private RadioButton radSerialize, radDeserialize;
	private CheckBox chkTest;
	ProgressDialog progressDialog;
	
	private static Book book;
	
	Serializer serializer;
	private static byte[] serialized;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // define view widgets
        lblResult = (TextView) findViewById(R.id.lblResult);
        btnXML = (Button) findViewById(R.id.btnXML);
        btnXML.setOnClickListener(myClickListener);
        btnJSON = (Button) findViewById(R.id.btnJSON);
        btnJSON.setOnClickListener(myClickListener);
        btnProtoBuf = (Button) findViewById(R.id.btnProtoBuf);
        btnProtoBuf.setOnClickListener(myClickListener);
        btnThrift = (Button) findViewById(R.id.btnThrift);
        btnThrift.setOnClickListener(myClickListener);
        radSerialize = (RadioButton) findViewById(R.id.radSerialize);
        radDeserialize = (RadioButton) findViewById(R.id.radDeserialize);
        chkTest = (CheckBox) findViewById(R.id.chkTest);
        
        // create instance of Book class
        createAGoT();
    }
    
    // OnClickListener that controls everything.
    public OnClickListener myClickListener = new OnClickListener() {
		public void onClick(View v) {	
			if(radSerialize.isChecked()){
				if(v == btnXML) {
					serializeXML();
				} else if (v == btnJSON) {
					serializeJSON();
				} else if (v == btnProtoBuf) {
					serializeProtoBuf();
				} else if (v == btnThrift) {
					serializeThrift();
				}
			} else if(radDeserialize.isChecked()){
				if(v == btnXML) {
					deserializeXML();
				} else if (v == btnJSON) {
					deserializeJSON();
				} else if (v == btnProtoBuf) {
					deserializeProtoBuf();
				} else if (v == btnThrift) {
					deserializeThrift();
				}
			}
		}
    };
    
    // Creates instance of Book class
    public void createAGoT() {
    	book = new Book();
        book.setTitle("A Game of Thrones");
        book.setAuthor("George RR. Martin");
        book.setDescription("A Game of Thrones is a contemporary masterpiece of fantasy. " +
        		"The cold is returning to Winterfell, where summers can last decades and winters " +
        		"a lifetime. A time of conflict has arisen in the Stark family, as they are " +
        		"pulled from the safety of their home into a whirlpool of tragedy, betrayal, " +
        		"assassination, plots and counterplots. Each decision and action carries with it " +
        		"the potential for conflict as several prominent families, comprised of lords, ladies, " +
        		"soldiers, sorcerers, assassins and bastards, are pulled together in the most deadly game " +
        		"of all--the game of thrones.");
        book.setImage("http://photo.goodreads.com/books/1239039164l/13496.jpg");
        book.setPrice(5.99);
        book.setSale(true);
        book.setType(Type.PAPERBACK);
        book.setNumInStock(2930);
    }
    
    // Initialize progress dialog.
    public void createProgressDialog() {
    	progressDialog = new ProgressDialog(AndroidSerializationActivity.this);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setMessage("Computing...");
		progressDialog.setCancelable(true);
		progressDialog.setProgress(1);
		progressDialog.setMax(1000);
		progressDialog.show();
    }
    
    // Progress handler for progress dialog
    Handler progressHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (progressDialog.getProgress() == progressDialog.getMax()-1) {
				progressDialog.incrementProgressBy(1);
				progressDialog.dismiss();
			} else {
				progressDialog.incrementProgressBy(1);
			}
		}
	};
	
	// Serialize as XML
	public void serializeXML() {
		if (sdAvailable()) {
			serializer = new Persister();
			// create file for XML output
			File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			path.mkdirs();
			final File xmlFile = new File(path, "xmlTest.xml");
			if (chkTest.isChecked()) {
				createProgressDialog();
				
				// thread to iterate through test serializations, has to run in it's own thread
				// so that the progress dialog works correctly
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000]; // to keep track of the time each iteration takes
						for (int i = 0; i < 1000; i++) {
							long time1 = System.nanoTime();
							try {
								serializer.write(book, xmlFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
							// calculate time spent serializing
							long time2 = System.nanoTime();
							long timeDiff = time2 - time1;
							double milliseconds = (double) timeDiff / 1000000.0;
							time[i] = milliseconds;
							// increment progress dialog
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							// document serialization times
							writeLog("xmlSerializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
			} else {
				try {
					serializer.write(book, xmlFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// Deserialize XML
	public void deserializeXML() {
		if (sdAvailable()) {
			serializer = new Persister();
			File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			final File xmlFile = new File(path, "xmlTest.xml");
			if (chkTest.isChecked()) {
				createProgressDialog();
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000];
						for (int i = 0; i < 1000; i++) {
							long time1 = System.nanoTime();
							try {
								Book testBook = serializer.read(Book.class, xmlFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
							long time2 = System.nanoTime();
							long timeDiff = time2 - time1;
							double milliseconds = (double) timeDiff / 1000000.0;
							time[i] = milliseconds;
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							writeLog("xmlDeserializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
			} else {
				try {
					Book testBook = serializer.read(Book.class, xmlFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
    // Serialize book as JSON
	public void serializeJSON() {
		if (sdAvailable()) {
			File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			path.mkdirs();
			final File jsonFile = new File(path, "jsonTest.json");
			if (chkTest.isChecked()) {
				createProgressDialog();
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000];
						for (int i = 0; i < 1000; i++) {
								long time1 = System.nanoTime();
								JsonFactory f = new JsonFactory();
								JsonGenerator g;
								try {
									// used streaming JSON serializer, more coding but gives speed boost
									g = f.createJsonGenerator(jsonFile, JsonEncoding.UTF8);
									g.writeStartObject();
									g.writeStringField("title", book.getTitle());
									g.writeStringField("author", book.getAuthor());
									g.writeStringField("description", book.getDescription());
									g.writeStringField("imageURI", book.getImage());
									g.writeNumberField("price", book.getPrice());
									g.writeBooleanField("onSale", book.getSale());
									g.writeStringField("type", book.getType().toString());
									g.writeNumberField("numInStock", book.getNumInStock());
									g.writeEndObject();
									g.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
								long time2 = System.nanoTime();
								long timeDiff = time2 - time1;
								double milliseconds = (double) timeDiff / 1000000.0;
								time[i] = milliseconds;
								progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							writeLog("jsonSerializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
			} else {
				try {
					JsonFactory f = new JsonFactory();
					JsonGenerator g = f.createJsonGenerator(jsonFile, JsonEncoding.UTF8);
					g.writeStartObject();
					g.writeStringField("title", book.getTitle());
					g.writeStringField("author", book.getAuthor());
					g.writeStringField("description", book.getDescription());
					g.writeStringField("imageURI", book.getImage());
					g.writeNumberField("price", book.getPrice());
					g.writeBooleanField("onSale", book.getSale());
					g.writeStringField("type", book.getType().toString());
					g.writeNumberField("numInStock", book.getNumInStock());
					g.writeEndObject();
					g.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.print("SD card not available");
		}
	}
    
	// Deserialize JSON
    public void deserializeJSON() {
    	if (sdAvailable()) {
    		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			final File jsonFile = new File(path, "jsonTest.json");
			if (chkTest.isChecked()) {
				createProgressDialog();
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000];
						for (int i = 0; i < 1000; i++) {
							long time1 = System.nanoTime();
					    	JsonFactory f = new JsonFactory();
					    	JsonParser jp;
							try {
								jp = f.createJsonParser(jsonFile);
								Book testBook = new Book();
						    	jp.nextToken();
						    	
						    	// parse that JSON
						    	while (jp.nextToken() != JsonToken.END_OBJECT){
						    		String fieldname = jp.getCurrentName();
						    		jp.nextToken();
						    		if ("title".equals(fieldname)){
						    			testBook.setTitle(jp.getText());
						    		} else if ("author".equals(fieldname)){
						    			testBook.setAuthor(jp.getText());
						    		} else if ("description".equals(fieldname)){
						    			testBook.setDescription(jp.getText());
						    		} else if ("imageURI".equals(fieldname)){
						    			testBook.setImage(jp.getText());
						    		} else if ("price".equals(fieldname)){
						    			testBook.setPrice(jp.getValueAsDouble());
						    		} else if ("onSale".equals(fieldname)){
						    			testBook.setSale(jp.getBooleanValue());
						    		} else if ("type".equals(fieldname)){
						    			testBook.setType(Type.valueOf(jp.getText()));
						    		} else if ("numInStock".equals(fieldname)){
						    			testBook.setNumInStock(jp.getIntValue());
						    		} else {
						    			System.out.println("Unrecognized field " + fieldname);
						    		}
						    	}
						    	jp.close();
							} catch (JsonParseException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							long time2 = System.nanoTime();
							long timeDiff = time2 - time1;
							double milliseconds = (double) timeDiff / 1000000.0;
							time[i] = milliseconds;
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							writeLog("jsonDeserializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
			} else {
		    	try {
		    		JsonFactory f = new JsonFactory();
		    		JsonParser jp = f.createJsonParser(jsonFile);
					Book testBook = new Book();
			    	jp.nextToken();
			    	while (jp.nextToken() != JsonToken.END_OBJECT){
			    		String fieldname = jp.getCurrentName();
			    		jp.nextToken();
			    		if ("title".equals(fieldname)){
			    			testBook.setTitle(jp.getText());
			    		} else if ("author".equals(fieldname)){
			    			testBook.setAuthor(jp.getText());
			    		} else if ("description".equals(fieldname)){
			    			testBook.setDescription(jp.getText());
			    		} else if ("imageURI".equals(fieldname)){
			    			testBook.setImage(jp.getText());
			    		} else if ("price".equals(fieldname)){
			    			testBook.setPrice(jp.getValueAsDouble());
			    		} else if ("onSale".equals(fieldname)){
			    			testBook.setSale(jp.getBooleanValue());
			    		} else if ("type".equals(fieldname)){
			    			testBook.setType(Type.valueOf(jp.getText()));
			    		} else if ("numInStock".equals(fieldname)){
			    			testBook.setNumInStock(jp.getIntValue());
			    		} else {
			    			System.out.println("Unrecognized field " + fieldname);
			    		}
			    	}
			    	jp.close();
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
    	}
    }
    
    // Serialize as Protocol Buffers
    public void serializeProtoBuf() {
    	if(sdAvailable()) {
    		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			path.mkdirs();
			final File protoBufFile = new File(path, "protoBufTest");
    		if (chkTest.isChecked()) {
				createProgressDialog();
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000];
						for (int i = 0; i < 1000; i++) {
							long time1 = System.nanoTime();
							BookProto.Builder protobook = BookProto.newBuilder();
					    	protobook.setTitle(book.getTitle());
					    	protobook.setAuthor(book.getAuthor());
					    	protobook.setDescription(book.getDescription());
					    	protobook.setImage(book.getImage());
					    	protobook.setNumInStock(book.getNumInStock());
					    	protobook.setOnSale(book.getSale());
					    	protobook.setPrice(book.getPrice());
					    	protobook.setType(BookProto.BookType.PAPERBACK);
					    	serialized = protobook.build().toByteArray();
					    	/*
					    	try {
								FileOutputStream fileOut = new FileOutputStream(protoBufFile);
								protobook.build().writeTo(fileOut);
								fileOut.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							*/
							long time2 = System.nanoTime();
							long timeDiff = time2 - time1;
							double milliseconds = (double) timeDiff / 1000000.0;
							time[i] = milliseconds;
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							writeLog("protoBufSerializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
    		} else {
    			BookProto.Builder protobook = BookProto.newBuilder();
		    	protobook.setTitle(book.getTitle());
		    	protobook.setAuthor(book.getAuthor());
		    	protobook.setDescription(book.getDescription());
		    	protobook.setImage(book.getImage());
		    	protobook.setNumInStock(book.getNumInStock());
		    	protobook.setOnSale(book.getSale());
		    	protobook.setPrice(book.getPrice());
		    	protobook.setType(BookProto.BookType.PAPERBACK);
		    	serialized = protobook.build().toByteArray();
		    	/*
		    	try {
					FileOutputStream fileOut = new FileOutputStream(protoBufFile);
					protobook.build().writeTo(fileOut);
					fileOut.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				*/
    		}
    	}
    }
    
    // Deserialize Protocol Buffers
    public void deserializeProtoBuf() {
    	if(sdAvailable()) {
    		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			path.mkdirs();
			final File protoBufFile = new File(path, "protoBufTest");
			if (chkTest.isChecked()) {
				createProgressDialog();
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000];
						for (int i = 0; i < 1000; i++) {
							long time1 = System.nanoTime();
							try {
								//FileInputStream fileIn = new FileInputStream(protoBufFile);
								BookProto testBook = BookProto.parseFrom(serialized);
								//fileIn.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							long time2 = System.nanoTime();
							long timeDiff = time2 - time1;
							double milliseconds = (double) timeDiff / 1000000.0;
							time[i] = milliseconds;
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							writeLog("protoBufDeserializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
			} else {
				try {
					BookProto testBook = BookProto.parseFrom(serialized);
					/*
					FileInputStream fileIn = new FileInputStream(protoBufFile);
					BookProto protoBook = BookProto.parseFrom(fileIn);
					Book testBook = new Book();
					testBook.setTitle(protoBook.getTitle());
					testBook.setAuthor(protoBook.getAuthor());
					testBook.setNumInStock(protoBook.getNumInStock());
					testBook.setPrice(protoBook.getPrice());
					testBook.setSale(protoBook.getOnSale());
					testBook.setDescription(protoBook.getDescription());
					testBook.setImage(protoBook.getImage());
					switch (protoBook.getType()) {
					case PAPERBACK:
						testBook.setType(Book.Type.PAPERBACK);
					case HARDCOVER:
						testBook.setType(Book.Type.HARDCOVER);
					case DIGITAL:
						testBook.setType(Book.Type.DIGITAL);
					}
					fileIn.close();
					*/
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
    	}
    }
    
    // Serialize as Thrift
    public void serializeThrift() {
    	if (sdAvailable()){
    		File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			path.mkdirs();
			final File thriftFile = new File(path, "thriftTest");
			if (chkTest.isChecked()) {
				createProgressDialog();
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000];
						for (int i = 0; i < 1000; i++) {
							long time1 = System.nanoTime();
							ThriftBook thriftBook = new ThriftBook();
				    		thriftBook.setTitle(book.getTitle());
				    		thriftBook.setAuthor(book.getAuthor());
				    		thriftBook.setDescription(book.getDescription());
				    		thriftBook.setImage(book.getImage());
				    		thriftBook.setNumInStock(book.getNumInStock());
				    		thriftBook.setOnSale(book.getSale());
				    		thriftBook.setPrice(book.getPrice());
				    		thriftBook.setType(BookType.DIGITAL);
				    		TSerializer serializer = new TSerializer (new TBinaryProtocol.Factory());
				    		try {
								serialized = serializer.serialize(thriftBook);
							} catch (TException e) {
								e.printStackTrace();
							}
				    		/*
				    		FileOutputStream fileOut;
							try {
								fileOut = new FileOutputStream(thriftFile);
								TSerializer serializer = new TSerializer (new TBinaryProtocol.Factory());
								fileOut.write(serializer.serialize(thriftBook));
								fileOut.close();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							} catch (TException e) {
								e.printStackTrace();
							}
							*/
							long time2 = System.nanoTime();
							long timeDiff = time2 - time1;
							double milliseconds = (double) timeDiff / 1000000.0;
							time[i] = milliseconds;
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							writeLog("thriftSerializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
			} else {
				ThriftBook thriftBook = new ThriftBook();
	    		thriftBook.setTitle(book.getTitle());
	    		thriftBook.setAuthor(book.getAuthor());
	    		thriftBook.setDescription(book.getDescription());
	    		thriftBook.setImage(book.getImage());
	    		thriftBook.setNumInStock(book.getNumInStock());
	    		thriftBook.setOnSale(book.getSale());
	    		thriftBook.setPrice(book.getPrice());
	    		thriftBook.setType(BookType.DIGITAL);
	    		TSerializer serializer = new TSerializer (new TBinaryProtocol.Factory());
	    		try {
					serialized = serializer.serialize(thriftBook);
				} catch (TException e) {
					e.printStackTrace();
				}
	    		/*
	    		try {
					FileOutputStream fileOut = new FileOutputStream(thriftFile);
					TSerializer serializer = new TSerializer (new TBinaryProtocol.Factory());
					fileOut.write(serializer.serialize(thriftBook));
					fileOut.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (TException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				*/
			}
    	}
    }
    
    // Deserialize Thrift
    public void deserializeThrift() {
    	File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		path.mkdirs();
		final File thriftFile = new File(path, "thriftTest");
    	if(sdAvailable()) {
    		if (chkTest.isChecked()) {
				createProgressDialog();
				Thread background = new Thread(new Runnable() {
					public void run() {
						double[] time = new double[1000];
						for (int i = 0; i < 1000; i++) {
							long time1 = System.nanoTime();
							try {
								//FileInputStream fileIn = new FileInputStream(thriftFile);
								//byte[] temp = new byte[(int) thriftFile.length()];
								//fileIn.read(temp);
								TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
								ThriftBook testBook = new ThriftBook();
								deserializer.deserialize(testBook, serialized);
								//fileIn.close();
							} catch (TException e) {
								e.printStackTrace();
							}
							long time2 = System.nanoTime();
							long timeDiff = time2 - time1;
							double milliseconds = (double) timeDiff / 1000000.0;
							time[i] = milliseconds;
							progressHandler.sendMessage(progressHandler.obtainMessage());
						}
						try {
							writeLog("thriftDeserializeTime", time);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				background.start();
    		} else {
    			try {
    				//FileInputStream fileIn = new FileInputStream(thriftFile);
					//byte[] temp = new byte[(int) thriftFile.length()];
					//fileIn.read(temp);
					TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
					ThriftBook testBook = new ThriftBook();
					deserializer.deserialize(testBook, serialized);
					//fileIn.close();
    			} catch (TException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    
    // Check to see if there is external storage available
    public boolean sdAvailable() {
    	boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			mExternalStorageAvailable = mExternalStorageWriteable = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			mExternalStorageAvailable = true;
			mExternalStorageWriteable = false;
		} else {
			mExternalStorageAvailable = mExternalStorageWriteable = false;
		}
		return (mExternalStorageAvailable && mExternalStorageWriteable) ? true: false;
    }
    
	// Write output to SD card
	public void writeLog(String fn, double[] time) throws IOException{
		// Log the average time
		double temp = 0.0;
		for(int i = 0; i < time.length; i++){
			temp += time[i];
		}
		Log.i("TIME", Double.toString(temp/time.length));
		
		if(sdAvailable()){
			// append the time down to the seconds to end of the file name so that
			// multiple tests can be run and none will get overwritten
			Date date;
			String dateOutput;
			SimpleDateFormat formatter;
			formatter = new SimpleDateFormat("H-mm-ss");
			date = new Date();
			dateOutput = formatter.format(date);
			File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			File file = new File(path, fn + " " + dateOutput + ".txt");
			FileWriter writer = new FileWriter(file);
			for (int i = 0; i < time.length; i++) {
				writer.write(time[i] + "\r\n");
			}
			writer.close();
		}
	}
}