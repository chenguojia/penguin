/**
 * MidCardsStatistic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class MidCardsStatistic  implements java.io.Serializable {
    private String cardNo;

    private String cardKind;

    private String tranCount;

    private String tranAmount;

    public MidCardsStatistic() {
    }

    public MidCardsStatistic(
           String cardNo,
           String cardKind,
           String tranCount,
           String tranAmount) {
           this.cardNo = cardNo;
           this.cardKind = cardKind;
           this.tranCount = tranCount;
           this.tranAmount = tranAmount;
    }


    /**
     * Gets the cardNo value for this MidCardsStatistic.
     *
     * @return cardNo
     */
    public String getCardNo() {
        return cardNo;
    }


    /**
     * Sets the cardNo value for this MidCardsStatistic.
     *
     * @param cardNo
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }


    /**
     * Gets the cardKind value for this MidCardsStatistic.
     *
     * @return cardKind
     */
    public String getCardKind() {
        return cardKind;
    }


    /**
     * Sets the cardKind value for this MidCardsStatistic.
     *
     * @param cardKind
     */
    public void setCardKind(String cardKind) {
        this.cardKind = cardKind;
    }


    /**
     * Gets the tranCount value for this MidCardsStatistic.
     *
     * @return tranCount
     */
    public String getTranCount() {
        return tranCount;
    }


    /**
     * Sets the tranCount value for this MidCardsStatistic.
     *
     * @param tranCount
     */
    public void setTranCount(String tranCount) {
        this.tranCount = tranCount;
    }


    /**
     * Gets the tranAmount value for this MidCardsStatistic.
     *
     * @return tranAmount
     */
    public String getTranAmount() {
        return tranAmount;
    }


    /**
     * Sets the tranAmount value for this MidCardsStatistic.
     *
     * @param tranAmount
     */
    public void setTranAmount(String tranAmount) {
        this.tranAmount = tranAmount;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MidCardsStatistic)) return false;
        MidCardsStatistic other = (MidCardsStatistic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.cardNo==null && other.getCardNo()==null) ||
             (this.cardNo!=null &&
              this.cardNo.equals(other.getCardNo()))) &&
            ((this.cardKind==null && other.getCardKind()==null) ||
             (this.cardKind!=null &&
              this.cardKind.equals(other.getCardKind()))) &&
            ((this.tranCount==null && other.getTranCount()==null) ||
             (this.tranCount!=null &&
              this.tranCount.equals(other.getTranCount()))) &&
            ((this.tranAmount==null && other.getTranAmount()==null) ||
             (this.tranAmount!=null &&
              this.tranAmount.equals(other.getTranAmount())));
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
        if (getCardNo() != null) {
            _hashCode += getCardNo().hashCode();
        }
        if (getCardKind() != null) {
            _hashCode += getCardKind().hashCode();
        }
        if (getTranCount() != null) {
            _hashCode += getTranCount().hashCode();
        }
        if (getTranAmount() != null) {
            _hashCode += getTranAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MidCardsStatistic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "midCardsStatistic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardKind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranAmount"));
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
