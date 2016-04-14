/**
 * MidMonthStatistic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class MidMonthStatistic  implements java.io.Serializable {
    private String month;

    private String tranDay;

    private String tranDays;

    private String tranCount;

    private String tranAmount;

    private String debitCardCount;

    private String debitCardAmount;

    private String creditCardCount;

    private String creditCardAmount;

    private String invalidCount;

    private String invalidAmount;

    private String cashCount;

    private String cashAmount;

    private String largeIntCount;

    private String largeIntAmount;

    public MidMonthStatistic() {
    }

    public MidMonthStatistic(
           String month,
           String tranDay,
           String tranDays,
           String tranCount,
           String tranAmount,
           String debitCardCount,
           String debitCardAmount,
           String creditCardCount,
           String creditCardAmount,
           String invalidCount,
           String invalidAmount,
           String cashCount,
           String cashAmount,
           String largeIntCount,
           String largeIntAmount) {
           this.month = month;
           this.tranDay = tranDay;
           this.tranDays = tranDays;
           this.tranCount = tranCount;
           this.tranAmount = tranAmount;
           this.debitCardCount = debitCardCount;
           this.debitCardAmount = debitCardAmount;
           this.creditCardCount = creditCardCount;
           this.creditCardAmount = creditCardAmount;
           this.invalidCount = invalidCount;
           this.invalidAmount = invalidAmount;
           this.cashCount = cashCount;
           this.cashAmount = cashAmount;
           this.largeIntCount = largeIntCount;
           this.largeIntAmount = largeIntAmount;
    }


    /**
     * Gets the month value for this MidMonthStatistic.
     *
     * @return month
     */
    public String getMonth() {
        return month;
    }


    /**
     * Sets the month value for this MidMonthStatistic.
     *
     * @param month
     */
    public void setMonth(String month) {
        this.month = month;
    }


    /**
     * Gets the tranDay value for this MidMonthStatistic.
     *
     * @return tranDay
     */
    public String getTranDay() {
        return tranDay;
    }


    /**
     * Sets the tranDay value for this MidMonthStatistic.
     *
     * @param tranDay
     */
    public void setTranDay(String tranDay) {
        this.tranDay = tranDay;
    }


    /**
     * Gets the tranDays value for this MidMonthStatistic.
     *
     * @return tranDays
     */
    public String getTranDays() {
        return tranDays;
    }


    /**
     * Sets the tranDays value for this MidMonthStatistic.
     *
     * @param tranDays
     */
    public void setTranDays(String tranDays) {
        this.tranDays = tranDays;
    }


    /**
     * Gets the tranCount value for this MidMonthStatistic.
     *
     * @return tranCount
     */
    public String getTranCount() {
        return tranCount;
    }


    /**
     * Sets the tranCount value for this MidMonthStatistic.
     *
     * @param tranCount
     */
    public void setTranCount(String tranCount) {
        this.tranCount = tranCount;
    }


    /**
     * Gets the tranAmount value for this MidMonthStatistic.
     *
     * @return tranAmount
     */
    public String getTranAmount() {
        return tranAmount;
    }


    /**
     * Sets the tranAmount value for this MidMonthStatistic.
     *
     * @param tranAmount
     */
    public void setTranAmount(String tranAmount) {
        this.tranAmount = tranAmount;
    }


    /**
     * Gets the debitCardCount value for this MidMonthStatistic.
     *
     * @return debitCardCount
     */
    public String getDebitCardCount() {
        return debitCardCount;
    }


    /**
     * Sets the debitCardCount value for this MidMonthStatistic.
     *
     * @param debitCardCount
     */
    public void setDebitCardCount(String debitCardCount) {
        this.debitCardCount = debitCardCount;
    }


    /**
     * Gets the debitCardAmount value for this MidMonthStatistic.
     *
     * @return debitCardAmount
     */
    public String getDebitCardAmount() {
        return debitCardAmount;
    }


    /**
     * Sets the debitCardAmount value for this MidMonthStatistic.
     *
     * @param debitCardAmount
     */
    public void setDebitCardAmount(String debitCardAmount) {
        this.debitCardAmount = debitCardAmount;
    }


    /**
     * Gets the creditCardCount value for this MidMonthStatistic.
     *
     * @return creditCardCount
     */
    public String getCreditCardCount() {
        return creditCardCount;
    }


    /**
     * Sets the creditCardCount value for this MidMonthStatistic.
     *
     * @param creditCardCount
     */
    public void setCreditCardCount(String creditCardCount) {
        this.creditCardCount = creditCardCount;
    }


    /**
     * Gets the creditCardAmount value for this MidMonthStatistic.
     *
     * @return creditCardAmount
     */
    public String getCreditCardAmount() {
        return creditCardAmount;
    }


    /**
     * Sets the creditCardAmount value for this MidMonthStatistic.
     *
     * @param creditCardAmount
     */
    public void setCreditCardAmount(String creditCardAmount) {
        this.creditCardAmount = creditCardAmount;
    }


    /**
     * Gets the invalidCount value for this MidMonthStatistic.
     *
     * @return invalidCount
     */
    public String getInvalidCount() {
        return invalidCount;
    }


    /**
     * Sets the invalidCount value for this MidMonthStatistic.
     *
     * @param invalidCount
     */
    public void setInvalidCount(String invalidCount) {
        this.invalidCount = invalidCount;
    }


    /**
     * Gets the invalidAmount value for this MidMonthStatistic.
     *
     * @return invalidAmount
     */
    public String getInvalidAmount() {
        return invalidAmount;
    }


    /**
     * Sets the invalidAmount value for this MidMonthStatistic.
     *
     * @param invalidAmount
     */
    public void setInvalidAmount(String invalidAmount) {
        this.invalidAmount = invalidAmount;
    }


    /**
     * Gets the cashCount value for this MidMonthStatistic.
     *
     * @return cashCount
     */
    public String getCashCount() {
        return cashCount;
    }


    /**
     * Sets the cashCount value for this MidMonthStatistic.
     *
     * @param cashCount
     */
    public void setCashCount(String cashCount) {
        this.cashCount = cashCount;
    }


    /**
     * Gets the cashAmount value for this MidMonthStatistic.
     *
     * @return cashAmount
     */
    public String getCashAmount() {
        return cashAmount;
    }


    /**
     * Sets the cashAmount value for this MidMonthStatistic.
     *
     * @param cashAmount
     */
    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
    }


    /**
     * Gets the largeIntCount value for this MidMonthStatistic.
     *
     * @return largeIntCount
     */
    public String getLargeIntCount() {
        return largeIntCount;
    }


    /**
     * Sets the largeIntCount value for this MidMonthStatistic.
     *
     * @param largeIntCount
     */
    public void setLargeIntCount(String largeIntCount) {
        this.largeIntCount = largeIntCount;
    }


    /**
     * Gets the largeIntAmount value for this MidMonthStatistic.
     *
     * @return largeIntAmount
     */
    public String getLargeIntAmount() {
        return largeIntAmount;
    }


    /**
     * Sets the largeIntAmount value for this MidMonthStatistic.
     *
     * @param largeIntAmount
     */
    public void setLargeIntAmount(String largeIntAmount) {
        this.largeIntAmount = largeIntAmount;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MidMonthStatistic)) return false;
        MidMonthStatistic other = (MidMonthStatistic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.month==null && other.getMonth()==null) ||
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.tranDay==null && other.getTranDay()==null) ||
             (this.tranDay!=null &&
              this.tranDay.equals(other.getTranDay()))) &&
            ((this.tranDays==null && other.getTranDays()==null) ||
             (this.tranDays!=null &&
              this.tranDays.equals(other.getTranDays()))) &&
            ((this.tranCount==null && other.getTranCount()==null) ||
             (this.tranCount!=null &&
              this.tranCount.equals(other.getTranCount()))) &&
            ((this.tranAmount==null && other.getTranAmount()==null) ||
             (this.tranAmount!=null &&
              this.tranAmount.equals(other.getTranAmount()))) &&
            ((this.debitCardCount==null && other.getDebitCardCount()==null) ||
             (this.debitCardCount!=null &&
              this.debitCardCount.equals(other.getDebitCardCount()))) &&
            ((this.debitCardAmount==null && other.getDebitCardAmount()==null) ||
             (this.debitCardAmount!=null &&
              this.debitCardAmount.equals(other.getDebitCardAmount()))) &&
            ((this.creditCardCount==null && other.getCreditCardCount()==null) ||
             (this.creditCardCount!=null &&
              this.creditCardCount.equals(other.getCreditCardCount()))) &&
            ((this.creditCardAmount==null && other.getCreditCardAmount()==null) ||
             (this.creditCardAmount!=null &&
              this.creditCardAmount.equals(other.getCreditCardAmount()))) &&
            ((this.invalidCount==null && other.getInvalidCount()==null) ||
             (this.invalidCount!=null &&
              this.invalidCount.equals(other.getInvalidCount()))) &&
            ((this.invalidAmount==null && other.getInvalidAmount()==null) ||
             (this.invalidAmount!=null &&
              this.invalidAmount.equals(other.getInvalidAmount()))) &&
            ((this.cashCount==null && other.getCashCount()==null) ||
             (this.cashCount!=null &&
              this.cashCount.equals(other.getCashCount()))) &&
            ((this.cashAmount==null && other.getCashAmount()==null) ||
             (this.cashAmount!=null &&
              this.cashAmount.equals(other.getCashAmount()))) &&
            ((this.largeIntCount==null && other.getLargeIntCount()==null) ||
             (this.largeIntCount!=null &&
              this.largeIntCount.equals(other.getLargeIntCount()))) &&
            ((this.largeIntAmount==null && other.getLargeIntAmount()==null) ||
             (this.largeIntAmount!=null &&
              this.largeIntAmount.equals(other.getLargeIntAmount())));
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
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getTranDay() != null) {
            _hashCode += getTranDay().hashCode();
        }
        if (getTranDays() != null) {
            _hashCode += getTranDays().hashCode();
        }
        if (getTranCount() != null) {
            _hashCode += getTranCount().hashCode();
        }
        if (getTranAmount() != null) {
            _hashCode += getTranAmount().hashCode();
        }
        if (getDebitCardCount() != null) {
            _hashCode += getDebitCardCount().hashCode();
        }
        if (getDebitCardAmount() != null) {
            _hashCode += getDebitCardAmount().hashCode();
        }
        if (getCreditCardCount() != null) {
            _hashCode += getCreditCardCount().hashCode();
        }
        if (getCreditCardAmount() != null) {
            _hashCode += getCreditCardAmount().hashCode();
        }
        if (getInvalidCount() != null) {
            _hashCode += getInvalidCount().hashCode();
        }
        if (getInvalidAmount() != null) {
            _hashCode += getInvalidAmount().hashCode();
        }
        if (getCashCount() != null) {
            _hashCode += getCashCount().hashCode();
        }
        if (getCashAmount() != null) {
            _hashCode += getCashAmount().hashCode();
        }
        if (getLargeIntCount() != null) {
            _hashCode += getLargeIntCount().hashCode();
        }
        if (getLargeIntAmount() != null) {
            _hashCode += getLargeIntAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MidMonthStatistic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "midMonthStatistic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranDays"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitCardCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitCardCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitCardAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitCardAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditCardCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditCardCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditCardAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditCardAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invalidCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invalidCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invalidAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "invalidAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("largeIntCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "largeIntCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("largeIntAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "largeIntAmount"));
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
