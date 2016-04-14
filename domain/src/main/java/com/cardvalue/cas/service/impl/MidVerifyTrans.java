/**
 * MidVerifyTrans.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class MidVerifyTrans  implements java.io.Serializable {
    private String tranTime;

    private String mid;

    private String tid;

    private String cardNo;

    private String currency;

    private String tranAmount;

    public MidVerifyTrans() {
    }

    public MidVerifyTrans(
           String tranTime,
           String mid,
           String tid,
           String cardNo,
           String currency,
           String tranAmount) {
           this.tranTime = tranTime;
           this.mid = mid;
           this.tid = tid;
           this.cardNo = cardNo;
           this.currency = currency;
           this.tranAmount = tranAmount;
    }


    /**
     * Gets the tranTime value for this MidVerifyTrans.
     *
     * @return tranTime
     */
    public String getTranTime() {
        return tranTime;
    }


    /**
     * Sets the tranTime value for this MidVerifyTrans.
     *
     * @param tranTime
     */
    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }


    /**
     * Gets the mid value for this MidVerifyTrans.
     *
     * @return mid
     */
    public String getMid() {
        return mid;
    }


    /**
     * Sets the mid value for this MidVerifyTrans.
     *
     * @param mid
     */
    public void setMid(String mid) {
        this.mid = mid;
    }


    /**
     * Gets the tid value for this MidVerifyTrans.
     *
     * @return tid
     */
    public String getTid() {
        return tid;
    }


    /**
     * Sets the tid value for this MidVerifyTrans.
     *
     * @param tid
     */
    public void setTid(String tid) {
        this.tid = tid;
    }


    /**
     * Gets the cardNo value for this MidVerifyTrans.
     *
     * @return cardNo
     */
    public String getCardNo() {
        return cardNo;
    }


    /**
     * Sets the cardNo value for this MidVerifyTrans.
     *
     * @param cardNo
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }


    /**
     * Gets the currency value for this MidVerifyTrans.
     *
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this MidVerifyTrans.
     *
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }


    /**
     * Gets the tranAmount value for this MidVerifyTrans.
     *
     * @return tranAmount
     */
    public String getTranAmount() {
        return tranAmount;
    }


    /**
     * Sets the tranAmount value for this MidVerifyTrans.
     *
     * @param tranAmount
     */
    public void setTranAmount(String tranAmount) {
        this.tranAmount = tranAmount;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MidVerifyTrans)) return false;
        MidVerifyTrans other = (MidVerifyTrans) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.tranTime==null && other.getTranTime()==null) ||
             (this.tranTime!=null &&
              this.tranTime.equals(other.getTranTime()))) &&
            ((this.mid==null && other.getMid()==null) ||
             (this.mid!=null &&
              this.mid.equals(other.getMid()))) &&
            ((this.tid==null && other.getTid()==null) ||
             (this.tid!=null &&
              this.tid.equals(other.getTid()))) &&
            ((this.cardNo==null && other.getCardNo()==null) ||
             (this.cardNo!=null &&
              this.cardNo.equals(other.getCardNo()))) &&
            ((this.currency==null && other.getCurrency()==null) ||
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
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
        if (getTranTime() != null) {
            _hashCode += getTranTime().hashCode();
        }
        if (getMid() != null) {
            _hashCode += getMid().hashCode();
        }
        if (getTid() != null) {
            _hashCode += getTid().hashCode();
        }
        if (getCardNo() != null) {
            _hashCode += getCardNo().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getTranAmount() != null) {
            _hashCode += getTranAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MidVerifyTrans.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "midVerifyTrans"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currency"));
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
