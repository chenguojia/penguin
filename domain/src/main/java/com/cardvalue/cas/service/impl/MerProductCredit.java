/**
 * MerProductCredit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class MerProductCredit  implements java.io.Serializable {
    private String productName;

    private String days;

    private String credit;

    public MerProductCredit() {
    }

    public MerProductCredit(
           String productName,
           String days,
           String credit) {
           this.productName = productName;
           this.days = days;
           this.credit = credit;
    }


    /**
     * Gets the productName value for this MerProductCredit.
     *
     * @return productName
     */
    public String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this MerProductCredit.
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }


    /**
     * Gets the days value for this MerProductCredit.
     *
     * @return days
     */
    public String getDays() {
        return days;
    }


    /**
     * Sets the days value for this MerProductCredit.
     *
     * @param days
     */
    public void setDays(String days) {
        this.days = days;
    }


    /**
     * Gets the credit value for this MerProductCredit.
     *
     * @return credit
     */
    public String getCredit() {
        return credit;
    }


    /**
     * Sets the credit value for this MerProductCredit.
     *
     * @param credit
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MerProductCredit)) return false;
        MerProductCredit other = (MerProductCredit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.productName==null && other.getProductName()==null) ||
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.days==null && other.getDays()==null) ||
             (this.days!=null &&
              this.days.equals(other.getDays()))) &&
            ((this.credit==null && other.getCredit()==null) ||
             (this.credit!=null &&
              this.credit.equals(other.getCredit())));
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
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getDays() != null) {
            _hashCode += getDays().hashCode();
        }
        if (getCredit() != null) {
            _hashCode += getCredit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MerProductCredit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "merProductCredit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("days");
        elemField.setXmlName(new javax.xml.namespace.QName("", "days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "credit"));
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
