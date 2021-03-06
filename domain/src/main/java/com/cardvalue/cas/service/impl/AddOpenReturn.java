/**
 * AddOpenReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class AddOpenReturn  implements java.io.Serializable {
    private String resCode;

    private String resMsg;

    private int resType;

    public AddOpenReturn() {
    }

    public AddOpenReturn(
           String resCode,
           String resMsg,
           int resType) {
           this.resCode = resCode;
           this.resMsg = resMsg;
           this.resType = resType;
    }


    /**
     * Gets the resCode value for this AddOpenReturn.
     *
     * @return resCode
     */
    public String getResCode() {
        return resCode;
    }


    /**
     * Sets the resCode value for this AddOpenReturn.
     *
     * @param resCode
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;
    }


    /**
     * Gets the resMsg value for this AddOpenReturn.
     *
     * @return resMsg
     */
    public String getResMsg() {
        return resMsg;
    }


    /**
     * Sets the resMsg value for this AddOpenReturn.
     *
     * @param resMsg
     */
    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }


    /**
     * Gets the resType value for this AddOpenReturn.
     *
     * @return resType
     */
    public int getResType() {
        return resType;
    }


    /**
     * Sets the resType value for this AddOpenReturn.
     *
     * @param resType
     */
    public void setResType(int resType) {
        this.resType = resType;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AddOpenReturn)) return false;
        AddOpenReturn other = (AddOpenReturn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.resCode==null && other.getResCode()==null) ||
             (this.resCode!=null &&
              this.resCode.equals(other.getResCode()))) &&
            ((this.resMsg==null && other.getResMsg()==null) ||
             (this.resMsg!=null &&
              this.resMsg.equals(other.getResMsg()))) &&
            this.resType == other.getResType();
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
        if (getResCode() != null) {
            _hashCode += getResCode().hashCode();
        }
        if (getResMsg() != null) {
            _hashCode += getResMsg().hashCode();
        }
        _hashCode += getResType();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddOpenReturn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "addOpenReturn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
