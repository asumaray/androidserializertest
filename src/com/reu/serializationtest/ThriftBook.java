/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.reu.serializationtest;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftBook implements org.apache.thrift.TBase<ThriftBook, ThriftBook._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftBook");

  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField AUTHOR_FIELD_DESC = new org.apache.thrift.protocol.TField("author", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("description", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField IMAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("image", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField NUM_IN_STOCK_FIELD_DESC = new org.apache.thrift.protocol.TField("numInStock", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("price", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField ON_SALE_FIELD_DESC = new org.apache.thrift.protocol.TField("onSale", org.apache.thrift.protocol.TType.BOOL, (short)7);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)8);

  public String title;
  public String author;
  public String description;
  public String image;
  public int numInStock;
  public double price;
  public boolean onSale;
  /**
   * 
   * @see BookType
   */
  public BookType type;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TITLE((short)1, "title"),
    AUTHOR((short)2, "author"),
    DESCRIPTION((short)3, "description"),
    IMAGE((short)4, "image"),
    NUM_IN_STOCK((short)5, "numInStock"),
    PRICE((short)6, "price"),
    ON_SALE((short)7, "onSale"),
    /**
     * 
     * @see BookType
     */
    TYPE((short)8, "type");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TITLE
          return TITLE;
        case 2: // AUTHOR
          return AUTHOR;
        case 3: // DESCRIPTION
          return DESCRIPTION;
        case 4: // IMAGE
          return IMAGE;
        case 5: // NUM_IN_STOCK
          return NUM_IN_STOCK;
        case 6: // PRICE
          return PRICE;
        case 7: // ON_SALE
          return ON_SALE;
        case 8: // TYPE
          return TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __NUMINSTOCK_ISSET_ID = 0;
  private static final int __PRICE_ISSET_ID = 1;
  private static final int __ONSALE_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AUTHOR, new org.apache.thrift.meta_data.FieldMetaData("author", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("description", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IMAGE, new org.apache.thrift.meta_data.FieldMetaData("image", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NUM_IN_STOCK, new org.apache.thrift.meta_data.FieldMetaData("numInStock", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PRICE, new org.apache.thrift.meta_data.FieldMetaData("price", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.ON_SALE, new org.apache.thrift.meta_data.FieldMetaData("onSale", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, BookType.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftBook.class, metaDataMap);
  }

  public ThriftBook() {
  }

  public ThriftBook(
    String title,
    String author,
    int numInStock,
    double price,
    boolean onSale,
    BookType type)
  {
    this();
    this.title = title;
    this.author = author;
    this.numInStock = numInStock;
    setNumInStockIsSet(true);
    this.price = price;
    setPriceIsSet(true);
    this.onSale = onSale;
    setOnSaleIsSet(true);
    this.type = type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftBook(ThriftBook other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetAuthor()) {
      this.author = other.author;
    }
    if (other.isSetDescription()) {
      this.description = other.description;
    }
    if (other.isSetImage()) {
      this.image = other.image;
    }
    this.numInStock = other.numInStock;
    this.price = other.price;
    this.onSale = other.onSale;
    if (other.isSetType()) {
      this.type = other.type;
    }
  }

  public ThriftBook deepCopy() {
    return new ThriftBook(this);
  }

  public void clear() {
    this.title = null;
    this.author = null;
    this.description = null;
    this.image = null;
    setNumInStockIsSet(false);
    this.numInStock = 0;
    setPriceIsSet(false);
    this.price = 0.0;
    setOnSaleIsSet(false);
    this.onSale = false;
    this.type = null;
  }

  public String getTitle() {
    return this.title;
  }

  public ThriftBook setTitle(String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public String getAuthor() {
    return this.author;
  }

  public ThriftBook setAuthor(String author) {
    this.author = author;
    return this;
  }

  public void unsetAuthor() {
    this.author = null;
  }

  /** Returns true if field author is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthor() {
    return this.author != null;
  }

  public void setAuthorIsSet(boolean value) {
    if (!value) {
      this.author = null;
    }
  }

  public String getDescription() {
    return this.description;
  }

  public ThriftBook setDescription(String description) {
    this.description = description;
    return this;
  }

  public void unsetDescription() {
    this.description = null;
  }

  /** Returns true if field description is set (has been assigned a value) and false otherwise */
  public boolean isSetDescription() {
    return this.description != null;
  }

  public void setDescriptionIsSet(boolean value) {
    if (!value) {
      this.description = null;
    }
  }

  public String getImage() {
    return this.image;
  }

  public ThriftBook setImage(String image) {
    this.image = image;
    return this;
  }

  public void unsetImage() {
    this.image = null;
  }

  /** Returns true if field image is set (has been assigned a value) and false otherwise */
  public boolean isSetImage() {
    return this.image != null;
  }

  public void setImageIsSet(boolean value) {
    if (!value) {
      this.image = null;
    }
  }

  public int getNumInStock() {
    return this.numInStock;
  }

  public ThriftBook setNumInStock(int numInStock) {
    this.numInStock = numInStock;
    setNumInStockIsSet(true);
    return this;
  }

  public void unsetNumInStock() {
    __isset_bit_vector.clear(__NUMINSTOCK_ISSET_ID);
  }

  /** Returns true if field numInStock is set (has been assigned a value) and false otherwise */
  public boolean isSetNumInStock() {
    return __isset_bit_vector.get(__NUMINSTOCK_ISSET_ID);
  }

  public void setNumInStockIsSet(boolean value) {
    __isset_bit_vector.set(__NUMINSTOCK_ISSET_ID, value);
  }

  public double getPrice() {
    return this.price;
  }

  public ThriftBook setPrice(double price) {
    this.price = price;
    setPriceIsSet(true);
    return this;
  }

  public void unsetPrice() {
    __isset_bit_vector.clear(__PRICE_ISSET_ID);
  }

  /** Returns true if field price is set (has been assigned a value) and false otherwise */
  public boolean isSetPrice() {
    return __isset_bit_vector.get(__PRICE_ISSET_ID);
  }

  public void setPriceIsSet(boolean value) {
    __isset_bit_vector.set(__PRICE_ISSET_ID, value);
  }

  public boolean isOnSale() {
    return this.onSale;
  }

  public ThriftBook setOnSale(boolean onSale) {
    this.onSale = onSale;
    setOnSaleIsSet(true);
    return this;
  }

  public void unsetOnSale() {
    __isset_bit_vector.clear(__ONSALE_ISSET_ID);
  }

  /** Returns true if field onSale is set (has been assigned a value) and false otherwise */
  public boolean isSetOnSale() {
    return __isset_bit_vector.get(__ONSALE_ISSET_ID);
  }

  public void setOnSaleIsSet(boolean value) {
    __isset_bit_vector.set(__ONSALE_ISSET_ID, value);
  }

  /**
   * 
   * @see BookType
   */
  public BookType getType() {
    return this.type;
  }

  /**
   * 
   * @see BookType
   */
  public ThriftBook setType(BookType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case AUTHOR:
      if (value == null) {
        unsetAuthor();
      } else {
        setAuthor((String)value);
      }
      break;

    case DESCRIPTION:
      if (value == null) {
        unsetDescription();
      } else {
        setDescription((String)value);
      }
      break;

    case IMAGE:
      if (value == null) {
        unsetImage();
      } else {
        setImage((String)value);
      }
      break;

    case NUM_IN_STOCK:
      if (value == null) {
        unsetNumInStock();
      } else {
        setNumInStock((Integer)value);
      }
      break;

    case PRICE:
      if (value == null) {
        unsetPrice();
      } else {
        setPrice((Double)value);
      }
      break;

    case ON_SALE:
      if (value == null) {
        unsetOnSale();
      } else {
        setOnSale((Boolean)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((BookType)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TITLE:
      return getTitle();

    case AUTHOR:
      return getAuthor();

    case DESCRIPTION:
      return getDescription();

    case IMAGE:
      return getImage();

    case NUM_IN_STOCK:
      return new Integer(getNumInStock());

    case PRICE:
      return new Double(getPrice());

    case ON_SALE:
      return new Boolean(isOnSale());

    case TYPE:
      return getType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TITLE:
      return isSetTitle();
    case AUTHOR:
      return isSetAuthor();
    case DESCRIPTION:
      return isSetDescription();
    case IMAGE:
      return isSetImage();
    case NUM_IN_STOCK:
      return isSetNumInStock();
    case PRICE:
      return isSetPrice();
    case ON_SALE:
      return isSetOnSale();
    case TYPE:
      return isSetType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftBook)
      return this.equals((ThriftBook)that);
    return false;
  }

  public boolean equals(ThriftBook that) {
    if (that == null)
      return false;

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_author = true && this.isSetAuthor();
    boolean that_present_author = true && that.isSetAuthor();
    if (this_present_author || that_present_author) {
      if (!(this_present_author && that_present_author))
        return false;
      if (!this.author.equals(that.author))
        return false;
    }

    boolean this_present_description = true && this.isSetDescription();
    boolean that_present_description = true && that.isSetDescription();
    if (this_present_description || that_present_description) {
      if (!(this_present_description && that_present_description))
        return false;
      if (!this.description.equals(that.description))
        return false;
    }

    boolean this_present_image = true && this.isSetImage();
    boolean that_present_image = true && that.isSetImage();
    if (this_present_image || that_present_image) {
      if (!(this_present_image && that_present_image))
        return false;
      if (!this.image.equals(that.image))
        return false;
    }

    boolean this_present_numInStock = true;
    boolean that_present_numInStock = true;
    if (this_present_numInStock || that_present_numInStock) {
      if (!(this_present_numInStock && that_present_numInStock))
        return false;
      if (this.numInStock != that.numInStock)
        return false;
    }

    boolean this_present_price = true;
    boolean that_present_price = true;
    if (this_present_price || that_present_price) {
      if (!(this_present_price && that_present_price))
        return false;
      if (this.price != that.price)
        return false;
    }

    boolean this_present_onSale = true;
    boolean that_present_onSale = true;
    if (this_present_onSale || that_present_onSale) {
      if (!(this_present_onSale && that_present_onSale))
        return false;
      if (this.onSale != that.onSale)
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ThriftBook other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftBook typedOther = (ThriftBook)other;

    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(typedOther.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, typedOther.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAuthor()).compareTo(typedOther.isSetAuthor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.author, typedOther.author);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDescription()).compareTo(typedOther.isSetDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.description, typedOther.description);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetImage()).compareTo(typedOther.isSetImage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.image, typedOther.image);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNumInStock()).compareTo(typedOther.isSetNumInStock());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumInStock()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numInStock, typedOther.numInStock);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrice()).compareTo(typedOther.isSetPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.price, typedOther.price);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOnSale()).compareTo(typedOther.isSetOnSale());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOnSale()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.onSale, typedOther.onSale);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(typedOther.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, typedOther.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // TITLE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.title = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // AUTHOR
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.author = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // DESCRIPTION
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.description = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // IMAGE
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.image = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // NUM_IN_STOCK
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.numInStock = iprot.readI32();
            setNumInStockIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // PRICE
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.price = iprot.readDouble();
            setPriceIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // ON_SALE
          if (field.type == org.apache.thrift.protocol.TType.BOOL) {
            this.onSale = iprot.readBool();
            setOnSaleIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // TYPE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.type = BookType.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    if (!isSetNumInStock()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'numInStock' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetPrice()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'price' was not found in serialized data! Struct: " + toString());
    }
    if (!isSetOnSale()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'onSale' was not found in serialized data! Struct: " + toString());
    }
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.title != null) {
      oprot.writeFieldBegin(TITLE_FIELD_DESC);
      oprot.writeString(this.title);
      oprot.writeFieldEnd();
    }
    if (this.author != null) {
      oprot.writeFieldBegin(AUTHOR_FIELD_DESC);
      oprot.writeString(this.author);
      oprot.writeFieldEnd();
    }
    if (this.description != null) {
      if (isSetDescription()) {
        oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
        oprot.writeString(this.description);
        oprot.writeFieldEnd();
      }
    }
    if (this.image != null) {
      if (isSetImage()) {
        oprot.writeFieldBegin(IMAGE_FIELD_DESC);
        oprot.writeString(this.image);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldBegin(NUM_IN_STOCK_FIELD_DESC);
    oprot.writeI32(this.numInStock);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(PRICE_FIELD_DESC);
    oprot.writeDouble(this.price);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(ON_SALE_FIELD_DESC);
    oprot.writeBool(this.onSale);
    oprot.writeFieldEnd();
    if (this.type != null) {
      oprot.writeFieldBegin(TYPE_FIELD_DESC);
      oprot.writeI32(this.type.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftBook(");
    boolean first = true;

    sb.append("title:");
    if (this.title == null) {
      sb.append("null");
    } else {
      sb.append(this.title);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("author:");
    if (this.author == null) {
      sb.append("null");
    } else {
      sb.append(this.author);
    }
    first = false;
    if (isSetDescription()) {
      if (!first) sb.append(", ");
      sb.append("description:");
      if (this.description == null) {
        sb.append("null");
      } else {
        sb.append(this.description);
      }
      first = false;
    }
    if (isSetImage()) {
      if (!first) sb.append(", ");
      sb.append("image:");
      if (this.image == null) {
        sb.append("null");
      } else {
        sb.append(this.image);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("numInStock:");
    sb.append(this.numInStock);
    first = false;
    if (!first) sb.append(", ");
    sb.append("price:");
    sb.append(this.price);
    first = false;
    if (!first) sb.append(", ");
    sb.append("onSale:");
    sb.append(this.onSale);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (title == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'title' was not present! Struct: " + toString());
    }
    if (author == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'author' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'numInStock' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'price' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'onSale' because it's a primitive and you chose the non-beans generator.
    if (type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'type' was not present! Struct: " + toString());
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}
