/**
 * SoapUpdateApplyRequestMain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public class SoapUpdateApplyRequestMain  implements java.io.Serializable {
    private String apply_status;

    private String approved_funding_amount;

    private String approved_funding_period;

    private String complete_rate;

    private String repay_amount;

    private String remaining_amount;

    private String overdue_amount;

    public SoapUpdateApplyRequestMain() {
    }

    public SoapUpdateApplyRequestMain(
           String apply_status,
           String approved_funding_amount,
           String approved_funding_period,
           String complete_rate,
           String repay_amount,
           String remaining_amount,
           String overdue_amount) {
           this.apply_status = apply_status;
           this.approved_funding_amount = approved_funding_amount;
           this.approved_funding_period = approved_funding_period;
           this.complete_rate = complete_rate;
           this.repay_amount = repay_amount;
           this.remaining_amount = remaining_amount;
           this.overdue_amount = overdue_amount;
    }


    /**
     * Gets the apply_status value for this SoapUpdateApplyRequestMain.
     *
     * @return apply_status
     */
    public String getApply_status() {
        return apply_status;
    }


    /**
     * Sets the apply_status value for this SoapUpdateApplyRequestMain.
     *
     * @param apply_status
     */
    public void setApply_status(String apply_status) {
        this.apply_status = apply_status;
    }


    /**
     * Gets the approved_funding_amount value for this SoapUpdateApplyRequestMain.
     *
     * @return approved_funding_amount
     */
    public String getApproved_funding_amount() {
        return approved_funding_amount;
    }


    /**
     * Sets the approved_funding_amount value for this SoapUpdateApplyRequestMain.
     *
     * @param approved_funding_amount
     */
    public void setApproved_funding_amount(String approved_funding_amount) {
        this.approved_funding_amount = approved_funding_amount;
    }


    /**
     * Gets the approved_funding_period value for this SoapUpdateApplyRequestMain.
     *
     * @return approved_funding_period
     */
    public String getApproved_funding_period() {
        return approved_funding_period;
    }


    /**
     * Sets the approved_funding_period value for this SoapUpdateApplyRequestMain.
     *
     * @param approved_funding_period
     */
    public void setApproved_funding_period(String approved_funding_period) {
        this.approved_funding_period = approved_funding_period;
    }


    /**
     * Gets the complete_rate value for this SoapUpdateApplyRequestMain.
     *
     * @return complete_rate
     */
    public String getComplete_rate() {
        return complete_rate;
    }


    /**
     * Sets the complete_rate value for this SoapUpdateApplyRequestMain.
     *
     * @param complete_rate
     */
    public void setComplete_rate(String complete_rate) {
        this.complete_rate = complete_rate;
    }


    /**
     * Gets the repay_amount value for this SoapUpdateApplyRequestMain.
     *
     * @return repay_amount
     */
    public String getRepay_amount() {
        return repay_amount;
    }


    /**
     * Sets the repay_amount value for this SoapUpdateApplyRequestMain.
     *
     * @param repay_amount
     */
    public void setRepay_amount(String repay_amount) {
        this.repay_amount = repay_amount;
    }


    /**
     * Gets the remaining_amount value for this SoapUpdateApplyRequestMain.
     *
     * @return remaining_amount
     */
    public String getRemaining_amount() {
        return remaining_amount;
    }


    /**
     * Sets the remaining_amount value for this SoapUpdateApplyRequestMain.
     *
     * @param remaining_amount
     */
    public void setRemaining_amount(String remaining_amount) {
        this.remaining_amount = remaining_amount;
    }


    /**
     * Gets the overdue_amount value for this SoapUpdateApplyRequestMain.
     *
     * @return overdue_amount
     */
    public String getOverdue_amount() {
        return overdue_amount;
    }


    /**
     * Sets the overdue_amount value for this SoapUpdateApplyRequestMain.
     *
     * @param overdue_amount
     */
    public void setOverdue_amount(String overdue_amount) {
        this.overdue_amount = overdue_amount;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapUpdateApplyRequestMain)) return false;
        SoapUpdateApplyRequestMain other = (SoapUpdateApplyRequestMain) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.apply_status==null && other.getApply_status()==null) ||
             (this.apply_status!=null &&
              this.apply_status.equals(other.getApply_status()))) &&
            ((this.approved_funding_amount==null && other.getApproved_funding_amount()==null) ||
             (this.approved_funding_amount!=null &&
              this.approved_funding_amount.equals(other.getApproved_funding_amount()))) &&
            ((this.approved_funding_period==null && other.getApproved_funding_period()==null) ||
             (this.approved_funding_period!=null &&
              this.approved_funding_period.equals(other.getApproved_funding_period()))) &&
            ((this.complete_rate==null && other.getComplete_rate()==null) ||
             (this.complete_rate!=null &&
              this.complete_rate.equals(other.getComplete_rate()))) &&
            ((this.repay_amount==null && other.getRepay_amount()==null) ||
             (this.repay_amount!=null &&
              this.repay_amount.equals(other.getRepay_amount()))) &&
            ((this.remaining_amount==null && other.getRemaining_amount()==null) ||
             (this.remaining_amount!=null &&
              this.remaining_amount.equals(other.getRemaining_amount()))) &&
            ((this.overdue_amount==null && other.getOverdue_amount()==null) ||
             (this.overdue_amount!=null &&
              this.overdue_amount.equals(other.getOverdue_amount())));
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
        if (getApply_status() != null) {
            _hashCode += getApply_status().hashCode();
        }
        if (getApproved_funding_amount() != null) {
            _hashCode += getApproved_funding_amount().hashCode();
        }
        if (getApproved_funding_period() != null) {
            _hashCode += getApproved_funding_period().hashCode();
        }
        if (getComplete_rate() != null) {
            _hashCode += getComplete_rate().hashCode();
        }
        if (getRepay_amount() != null) {
            _hashCode += getRepay_amount().hashCode();
        }
        if (getRemaining_amount() != null) {
            _hashCode += getRemaining_amount().hashCode();
        }
        if (getOverdue_amount() != null) {
            _hashCode += getOverdue_amount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapUpdateApplyRequestMain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.cvbaoli.cn", "soapUpdateApplyRequestMain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apply_status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apply_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approved_funding_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approved_funding_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approved_funding_period");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approved_funding_period"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complete_rate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "complete_rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repay_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "repay_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remaining_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remaining_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("overdue_amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "overdue_amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
