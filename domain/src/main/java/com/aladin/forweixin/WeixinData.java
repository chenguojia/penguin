/**
 * WeixinData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladin.forweixin;

public class WeixinData  implements java.io.Serializable {
    private String mid;

    private String businessName;

    private String mobile;

    private String uq;

    private String id;

    private boolean insertStatus;

    private String name;

    private String stringField19;

    private String stringField26;

    private String stringField37;

    public WeixinData() {
    }

    public WeixinData(
           String mid,
           String businessName,
           String mobile,
           String uq,
           String id,
           boolean insertStatus,
           String name,
           String stringField19,
           String stringField26,
           String stringField37) {
           this.mid = mid;
           this.businessName = businessName;
           this.mobile = mobile;
           this.uq = uq;
           this.id = id;
           this.insertStatus = insertStatus;
           this.name = name;
           this.stringField19 = stringField19;
           this.stringField26 = stringField26;
           this.stringField37 = stringField37;
    }


    /**
     * Gets the mid value for this WeixinData.
     *
     * @return mid
     */
    public String getMid() {
        return mid;
    }


    /**
     * Sets the mid value for this WeixinData.
     *
     * @param mid
     */
    public void setMid(String mid) {
        this.mid = mid;
    }


    /**
     * Gets the businessName value for this WeixinData.
     *
     * @return businessName
     */
    public String getBusinessName() {
        return businessName;
    }


    /**
     * Sets the businessName value for this WeixinData.
     *
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


    /**
     * Gets the mobile value for this WeixinData.
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this WeixinData.
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the uq value for this WeixinData.
     *
     * @return uq
     */
    public String getUq() {
        return uq;
    }


    /**
     * Sets the uq value for this WeixinData.
     *
     * @param uq
     */
    public void setUq(String uq) {
        this.uq = uq;
    }


    /**
     * Gets the id value for this WeixinData.
     *
     * @return id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets the id value for this WeixinData.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * Gets the insertStatus value for this WeixinData.
     *
     * @return insertStatus
     */
    public boolean isInsertStatus() {
        return insertStatus;
    }


    /**
     * Sets the insertStatus value for this WeixinData.
     *
     * @param insertStatus
     */
    public void setInsertStatus(boolean insertStatus) {
        this.insertStatus = insertStatus;
    }


    /**
     * Gets the name value for this WeixinData.
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this WeixinData.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the stringField19 value for this WeixinData.
     *
     * @return stringField19
     */
    public String getStringField19() {
        return stringField19;
    }


    /**
     * Sets the stringField19 value for this WeixinData.
     *
     * @param stringField19
     */
    public void setStringField19(String stringField19) {
        this.stringField19 = stringField19;
    }


    /**
     * Gets the stringField26 value for this WeixinData.
     *
     * @return stringField26
     */
    public String getStringField26() {
        return stringField26;
    }


    /**
     * Sets the stringField26 value for this WeixinData.
     *
     * @param stringField26
     */
    public void setStringField26(String stringField26) {
        this.stringField26 = stringField26;
    }


    /**
     * Gets the stringField37 value for this WeixinData.
     *
     * @return stringField37
     */
    public String getStringField37() {
        return stringField37;
    }


    /**
     * Sets the stringField37 value for this WeixinData.
     *
     * @param stringField37
     */
    public void setStringField37(String stringField37) {
        this.stringField37 = stringField37;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof WeixinData)) return false;
        WeixinData other = (WeixinData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.mid==null && other.getMid()==null) ||
             (this.mid!=null &&
              this.mid.equals(other.getMid()))) &&
            ((this.businessName==null && other.getBusinessName()==null) ||
             (this.businessName!=null &&
              this.businessName.equals(other.getBusinessName()))) &&
            ((this.mobile==null && other.getMobile()==null) ||
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.uq==null && other.getUq()==null) ||
             (this.uq!=null &&
              this.uq.equals(other.getUq()))) &&
            ((this.id==null && other.getId()==null) ||
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            this.insertStatus == other.isInsertStatus() &&
            ((this.name==null && other.getName()==null) ||
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.stringField19==null && other.getStringField19()==null) ||
             (this.stringField19!=null &&
              this.stringField19.equals(other.getStringField19()))) &&
            ((this.stringField26==null && other.getStringField26()==null) ||
             (this.stringField26!=null &&
              this.stringField26.equals(other.getStringField26()))) &&
            ((this.stringField37==null && other.getStringField37()==null) ||
             (this.stringField37!=null &&
              this.stringField37.equals(other.getStringField37())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMid() != null) {
            _hashCode += getMid().hashCode();
        }
        if (getBusinessName() != null) {
            _hashCode += getBusinessName().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getUq() != null) {
            _hashCode += getUq().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        _hashCode += (isInsertStatus() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getStringField19() != null) {
            _hashCode += getStringField19().hashCode();
        }
        if (getStringField26() != null) {
            _hashCode += getStringField26().hashCode();
        }
        if (getStringField37() != null) {
            _hashCode += getStringField37().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WeixinData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://forweixin.aladin.com/", "weixinData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insertStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insertStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringField19");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stringField19"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringField26");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stringField26"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stringField37");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stringField37"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
