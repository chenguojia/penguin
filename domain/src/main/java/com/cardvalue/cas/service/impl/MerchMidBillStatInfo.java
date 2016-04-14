/**
 * MerchMidBillStatInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class MerchMidBillStatInfo  implements java.io.Serializable {
    private String firstTransDate;

    private String lastTransDate;

    private long totalExpense;

    private int totalMidCount;

    private int totalPosCount;

    private long totalReceipt;

    private int totalTransCount;

    public MerchMidBillStatInfo() {
    }

    public MerchMidBillStatInfo(
           String firstTransDate,
           String lastTransDate,
           long totalExpense,
           int totalMidCount,
           int totalPosCount,
           long totalReceipt,
           int totalTransCount) {
           this.firstTransDate = firstTransDate;
           this.lastTransDate = lastTransDate;
           this.totalExpense = totalExpense;
           this.totalMidCount = totalMidCount;
           this.totalPosCount = totalPosCount;
           this.totalReceipt = totalReceipt;
           this.totalTransCount = totalTransCount;
    }


    /**
     * Gets the firstTransDate value for this MerchMidBillStatInfo.
     *
     * @return firstTransDate
     */
    public String getFirstTransDate() {
        return firstTransDate;
    }


    /**
     * Sets the firstTransDate value for this MerchMidBillStatInfo.
     *
     * @param firstTransDate
     */
    public void setFirstTransDate(String firstTransDate) {
        this.firstTransDate = firstTransDate;
    }


    /**
     * Gets the lastTransDate value for this MerchMidBillStatInfo.
     *
     * @return lastTransDate
     */
    public String getLastTransDate() {
        return lastTransDate;
    }


    /**
     * Sets the lastTransDate value for this MerchMidBillStatInfo.
     *
     * @param lastTransDate
     */
    public void setLastTransDate(String lastTransDate) {
        this.lastTransDate = lastTransDate;
    }


    /**
     * Gets the totalExpense value for this MerchMidBillStatInfo.
     *
     * @return totalExpense
     */
    public long getTotalExpense() {
        return totalExpense;
    }


    /**
     * Sets the totalExpense value for this MerchMidBillStatInfo.
     *
     * @param totalExpense
     */
    public void setTotalExpense(long totalExpense) {
        this.totalExpense = totalExpense;
    }


    /**
     * Gets the totalMidCount value for this MerchMidBillStatInfo.
     *
     * @return totalMidCount
     */
    public int getTotalMidCount() {
        return totalMidCount;
    }


    /**
     * Sets the totalMidCount value for this MerchMidBillStatInfo.
     *
     * @param totalMidCount
     */
    public void setTotalMidCount(int totalMidCount) {
        this.totalMidCount = totalMidCount;
    }


    /**
     * Gets the totalPosCount value for this MerchMidBillStatInfo.
     *
     * @return totalPosCount
     */
    public int getTotalPosCount() {
        return totalPosCount;
    }


    /**
     * Sets the totalPosCount value for this MerchMidBillStatInfo.
     *
     * @param totalPosCount
     */
    public void setTotalPosCount(int totalPosCount) {
        this.totalPosCount = totalPosCount;
    }


    /**
     * Gets the totalReceipt value for this MerchMidBillStatInfo.
     *
     * @return totalReceipt
     */
    public long getTotalReceipt() {
        return totalReceipt;
    }


    /**
     * Sets the totalReceipt value for this MerchMidBillStatInfo.
     *
     * @param totalReceipt
     */
    public void setTotalReceipt(long totalReceipt) {
        this.totalReceipt = totalReceipt;
    }


    /**
     * Gets the totalTransCount value for this MerchMidBillStatInfo.
     *
     * @return totalTransCount
     */
    public int getTotalTransCount() {
        return totalTransCount;
    }


    /**
     * Sets the totalTransCount value for this MerchMidBillStatInfo.
     *
     * @param totalTransCount
     */
    public void setTotalTransCount(int totalTransCount) {
        this.totalTransCount = totalTransCount;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MerchMidBillStatInfo)) return false;
        MerchMidBillStatInfo other = (MerchMidBillStatInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.firstTransDate==null && other.getFirstTransDate()==null) ||
             (this.firstTransDate!=null &&
              this.firstTransDate.equals(other.getFirstTransDate()))) &&
            ((this.lastTransDate==null && other.getLastTransDate()==null) ||
             (this.lastTransDate!=null &&
              this.lastTransDate.equals(other.getLastTransDate()))) &&
            this.totalExpense == other.getTotalExpense() &&
            this.totalMidCount == other.getTotalMidCount() &&
            this.totalPosCount == other.getTotalPosCount() &&
            this.totalReceipt == other.getTotalReceipt() &&
            this.totalTransCount == other.getTotalTransCount();
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
        if (getFirstTransDate() != null) {
            _hashCode += getFirstTransDate().hashCode();
        }
        if (getLastTransDate() != null) {
            _hashCode += getLastTransDate().hashCode();
        }
        _hashCode += new Long(getTotalExpense()).hashCode();
        _hashCode += getTotalMidCount();
        _hashCode += getTotalPosCount();
        _hashCode += new Long(getTotalReceipt()).hashCode();
        _hashCode += getTotalTransCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MerchMidBillStatInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "merchMidBillStatInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstTransDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstTransDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastTransDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastTransDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalExpense"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalMidCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalMidCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPosCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalPosCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalReceipt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalReceipt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalTransCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalTransCount"));
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
