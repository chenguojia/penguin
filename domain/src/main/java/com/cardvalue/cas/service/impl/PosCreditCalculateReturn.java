/**
 * PosCreditCalculateReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class PosCreditCalculateReturn  implements java.io.Serializable {
    private String creditLineIn90Days;

    private String creditRating;

    private String credit_scoring;

    private String failedReason;

    private String fee;

    private String feeRate;

    private String fixedPaymentAmont;

    private String fixedPaymentRatio;

    private String maxPaymentPeriod;

    private String passFlag;

    private String result;

    public PosCreditCalculateReturn() {
    }

    public PosCreditCalculateReturn(
           String creditLineIn90Days,
           String creditRating,
           String credit_scoring,
           String failedReason,
           String fee,
           String feeRate,
           String fixedPaymentAmont,
           String fixedPaymentRatio,
           String maxPaymentPeriod,
           String passFlag,
           String result) {
           this.creditLineIn90Days = creditLineIn90Days;
           this.creditRating = creditRating;
           this.credit_scoring = credit_scoring;
           this.failedReason = failedReason;
           this.fee = fee;
           this.feeRate = feeRate;
           this.fixedPaymentAmont = fixedPaymentAmont;
           this.fixedPaymentRatio = fixedPaymentRatio;
           this.maxPaymentPeriod = maxPaymentPeriod;
           this.passFlag = passFlag;
           this.result = result;
    }


    /**
     * Gets the creditLineIn90Days value for this PosCreditCalculateReturn.
     *
     * @return creditLineIn90Days
     */
    public String getCreditLineIn90Days() {
        return creditLineIn90Days;
    }


    /**
     * Sets the creditLineIn90Days value for this PosCreditCalculateReturn.
     *
     * @param creditLineIn90Days
     */
    public void setCreditLineIn90Days(String creditLineIn90Days) {
        this.creditLineIn90Days = creditLineIn90Days;
    }


    /**
     * Gets the creditRating value for this PosCreditCalculateReturn.
     *
     * @return creditRating
     */
    public String getCreditRating() {
        return creditRating;
    }


    /**
     * Sets the creditRating value for this PosCreditCalculateReturn.
     *
     * @param creditRating
     */
    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }


    /**
     * Gets the credit_scoring value for this PosCreditCalculateReturn.
     *
     * @return credit_scoring
     */
    public String getCredit_scoring() {
        return credit_scoring;
    }


    /**
     * Sets the credit_scoring value for this PosCreditCalculateReturn.
     *
     * @param credit_scoring
     */
    public void setCredit_scoring(String credit_scoring) {
        this.credit_scoring = credit_scoring;
    }


    /**
     * Gets the failedReason value for this PosCreditCalculateReturn.
     *
     * @return failedReason
     */
    public String getFailedReason() {
        return failedReason;
    }


    /**
     * Sets the failedReason value for this PosCreditCalculateReturn.
     *
     * @param failedReason
     */
    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }


    /**
     * Gets the fee value for this PosCreditCalculateReturn.
     *
     * @return fee
     */
    public String getFee() {
        return fee;
    }


    /**
     * Sets the fee value for this PosCreditCalculateReturn.
     *
     * @param fee
     */
    public void setFee(String fee) {
        this.fee = fee;
    }


    /**
     * Gets the feeRate value for this PosCreditCalculateReturn.
     *
     * @return feeRate
     */
    public String getFeeRate() {
        return feeRate;
    }


    /**
     * Sets the feeRate value for this PosCreditCalculateReturn.
     *
     * @param feeRate
     */
    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate;
    }


    /**
     * Gets the fixedPaymentAmont value for this PosCreditCalculateReturn.
     *
     * @return fixedPaymentAmont
     */
    public String getFixedPaymentAmont() {
        return fixedPaymentAmont;
    }


    /**
     * Sets the fixedPaymentAmont value for this PosCreditCalculateReturn.
     *
     * @param fixedPaymentAmont
     */
    public void setFixedPaymentAmont(String fixedPaymentAmont) {
        this.fixedPaymentAmont = fixedPaymentAmont;
    }


    /**
     * Gets the fixedPaymentRatio value for this PosCreditCalculateReturn.
     *
     * @return fixedPaymentRatio
     */
    public String getFixedPaymentRatio() {
        return fixedPaymentRatio;
    }


    /**
     * Sets the fixedPaymentRatio value for this PosCreditCalculateReturn.
     *
     * @param fixedPaymentRatio
     */
    public void setFixedPaymentRatio(String fixedPaymentRatio) {
        this.fixedPaymentRatio = fixedPaymentRatio;
    }


    /**
     * Gets the maxPaymentPeriod value for this PosCreditCalculateReturn.
     *
     * @return maxPaymentPeriod
     */
    public String getMaxPaymentPeriod() {
        return maxPaymentPeriod;
    }


    /**
     * Sets the maxPaymentPeriod value for this PosCreditCalculateReturn.
     *
     * @param maxPaymentPeriod
     */
    public void setMaxPaymentPeriod(String maxPaymentPeriod) {
        this.maxPaymentPeriod = maxPaymentPeriod;
    }


    /**
     * Gets the passFlag value for this PosCreditCalculateReturn.
     *
     * @return passFlag
     */
    public String getPassFlag() {
        return passFlag;
    }


    /**
     * Sets the passFlag value for this PosCreditCalculateReturn.
     *
     * @param passFlag
     */
    public void setPassFlag(String passFlag) {
        this.passFlag = passFlag;
    }


    /**
     * Gets the result value for this PosCreditCalculateReturn.
     *
     * @return result
     */
    public String getResult() {
        return result;
    }


    /**
     * Sets the result value for this PosCreditCalculateReturn.
     *
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PosCreditCalculateReturn)) return false;
        PosCreditCalculateReturn other = (PosCreditCalculateReturn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.creditLineIn90Days==null && other.getCreditLineIn90Days()==null) ||
             (this.creditLineIn90Days!=null &&
              this.creditLineIn90Days.equals(other.getCreditLineIn90Days()))) &&
            ((this.creditRating==null && other.getCreditRating()==null) ||
             (this.creditRating!=null &&
              this.creditRating.equals(other.getCreditRating()))) &&
            ((this.credit_scoring==null && other.getCredit_scoring()==null) ||
             (this.credit_scoring!=null &&
              this.credit_scoring.equals(other.getCredit_scoring()))) &&
            ((this.failedReason==null && other.getFailedReason()==null) ||
             (this.failedReason!=null &&
              this.failedReason.equals(other.getFailedReason()))) &&
            ((this.fee==null && other.getFee()==null) ||
             (this.fee!=null &&
              this.fee.equals(other.getFee()))) &&
            ((this.feeRate==null && other.getFeeRate()==null) ||
             (this.feeRate!=null &&
              this.feeRate.equals(other.getFeeRate()))) &&
            ((this.fixedPaymentAmont==null && other.getFixedPaymentAmont()==null) ||
             (this.fixedPaymentAmont!=null &&
              this.fixedPaymentAmont.equals(other.getFixedPaymentAmont()))) &&
            ((this.fixedPaymentRatio==null && other.getFixedPaymentRatio()==null) ||
             (this.fixedPaymentRatio!=null &&
              this.fixedPaymentRatio.equals(other.getFixedPaymentRatio()))) &&
            ((this.maxPaymentPeriod==null && other.getMaxPaymentPeriod()==null) ||
             (this.maxPaymentPeriod!=null &&
              this.maxPaymentPeriod.equals(other.getMaxPaymentPeriod()))) &&
            ((this.passFlag==null && other.getPassFlag()==null) ||
             (this.passFlag!=null &&
              this.passFlag.equals(other.getPassFlag()))) &&
            ((this.result==null && other.getResult()==null) ||
             (this.result!=null &&
              this.result.equals(other.getResult())));
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
        if (getCreditLineIn90Days() != null) {
            _hashCode += getCreditLineIn90Days().hashCode();
        }
        if (getCreditRating() != null) {
            _hashCode += getCreditRating().hashCode();
        }
        if (getCredit_scoring() != null) {
            _hashCode += getCredit_scoring().hashCode();
        }
        if (getFailedReason() != null) {
            _hashCode += getFailedReason().hashCode();
        }
        if (getFee() != null) {
            _hashCode += getFee().hashCode();
        }
        if (getFeeRate() != null) {
            _hashCode += getFeeRate().hashCode();
        }
        if (getFixedPaymentAmont() != null) {
            _hashCode += getFixedPaymentAmont().hashCode();
        }
        if (getFixedPaymentRatio() != null) {
            _hashCode += getFixedPaymentRatio().hashCode();
        }
        if (getMaxPaymentPeriod() != null) {
            _hashCode += getMaxPaymentPeriod().hashCode();
        }
        if (getPassFlag() != null) {
            _hashCode += getPassFlag().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PosCreditCalculateReturn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "posCreditCalculateReturn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditLineIn90Days");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditLineIn90Days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditRating");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditRating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credit_scoring");
        elemField.setXmlName(new javax.xml.namespace.QName("", "credit_scoring"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failedReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "failedReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fee");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feeRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feeRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fixedPaymentAmont");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fixedPaymentAmont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fixedPaymentRatio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fixedPaymentRatio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxPaymentPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxPaymentPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "result"));
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
