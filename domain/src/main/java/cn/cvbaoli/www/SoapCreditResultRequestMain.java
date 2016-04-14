/**
 * SoapCreditResultRequestMain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public class SoapCreditResultRequestMain  implements java.io.Serializable {
    private String channel;

    private String corpName;

    private String midList;

    private String checkName;

    private String plannedAmt;

    private String plannedDays;

    private String province;

    private String mobile;

    public SoapCreditResultRequestMain() {
    }

    public SoapCreditResultRequestMain(
           String channel,
           String corpName,
           String midList,
           String checkName,
           String plannedAmt,
           String plannedDays,
           String province,
           String mobile) {
           this.channel = channel;
           this.corpName = corpName;
           this.midList = midList;
           this.checkName = checkName;
           this.plannedAmt = plannedAmt;
           this.plannedDays = plannedDays;
           this.province = province;
           this.mobile = mobile;
    }


    /**
     * Gets the channel value for this SoapCreditResultRequestMain.
     *
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this SoapCreditResultRequestMain.
     *
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }


    /**
     * Gets the corpName value for this SoapCreditResultRequestMain.
     *
     * @return corpName
     */
    public String getCorpName() {
        return corpName;
    }


    /**
     * Sets the corpName value for this SoapCreditResultRequestMain.
     *
     * @param corpName
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }


    /**
     * Gets the midList value for this SoapCreditResultRequestMain.
     *
     * @return midList
     */
    public String getMidList() {
        return midList;
    }


    /**
     * Sets the midList value for this SoapCreditResultRequestMain.
     *
     * @param midList
     */
    public void setMidList(String midList) {
        this.midList = midList;
    }


    /**
     * Gets the checkName value for this SoapCreditResultRequestMain.
     *
     * @return checkName
     */
    public String getCheckName() {
        return checkName;
    }


    /**
     * Sets the checkName value for this SoapCreditResultRequestMain.
     *
     * @param checkName
     */
    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }


    /**
     * Gets the plannedAmt value for this SoapCreditResultRequestMain.
     *
     * @return plannedAmt
     */
    public String getPlannedAmt() {
        return plannedAmt;
    }


    /**
     * Sets the plannedAmt value for this SoapCreditResultRequestMain.
     *
     * @param plannedAmt
     */
    public void setPlannedAmt(String plannedAmt) {
        this.plannedAmt = plannedAmt;
    }


    /**
     * Gets the plannedDays value for this SoapCreditResultRequestMain.
     *
     * @return plannedDays
     */
    public String getPlannedDays() {
        return plannedDays;
    }


    /**
     * Sets the plannedDays value for this SoapCreditResultRequestMain.
     *
     * @param plannedDays
     */
    public void setPlannedDays(String plannedDays) {
        this.plannedDays = plannedDays;
    }


    /**
     * Gets the province value for this SoapCreditResultRequestMain.
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }


    /**
     * Sets the province value for this SoapCreditResultRequestMain.
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }


    /**
     * Gets the mobile value for this SoapCreditResultRequestMain.
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this SoapCreditResultRequestMain.
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapCreditResultRequestMain)) return false;
        SoapCreditResultRequestMain other = (SoapCreditResultRequestMain) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.channel==null && other.getChannel()==null) ||
             (this.channel!=null &&
              this.channel.equals(other.getChannel()))) &&
            ((this.corpName==null && other.getCorpName()==null) ||
             (this.corpName!=null &&
              this.corpName.equals(other.getCorpName()))) &&
            ((this.midList==null && other.getMidList()==null) ||
             (this.midList!=null &&
              this.midList.equals(other.getMidList()))) &&
            ((this.checkName==null && other.getCheckName()==null) ||
             (this.checkName!=null &&
              this.checkName.equals(other.getCheckName()))) &&
            ((this.plannedAmt==null && other.getPlannedAmt()==null) ||
             (this.plannedAmt!=null &&
              this.plannedAmt.equals(other.getPlannedAmt()))) &&
            ((this.plannedDays==null && other.getPlannedDays()==null) ||
             (this.plannedDays!=null &&
              this.plannedDays.equals(other.getPlannedDays()))) &&
            ((this.province==null && other.getProvince()==null) ||
             (this.province!=null &&
              this.province.equals(other.getProvince()))) &&
            ((this.mobile==null && other.getMobile()==null) ||
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile())));
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
        if (getChannel() != null) {
            _hashCode += getChannel().hashCode();
        }
        if (getCorpName() != null) {
            _hashCode += getCorpName().hashCode();
        }
        if (getMidList() != null) {
            _hashCode += getMidList().hashCode();
        }
        if (getCheckName() != null) {
            _hashCode += getCheckName().hashCode();
        }
        if (getPlannedAmt() != null) {
            _hashCode += getPlannedAmt().hashCode();
        }
        if (getPlannedDays() != null) {
            _hashCode += getPlannedDays().hashCode();
        }
        if (getProvince() != null) {
            _hashCode += getProvince().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapCreditResultRequestMain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.cvbaoli.cn", "soapCreditResultRequestMain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "checkName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plannedAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plannedAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plannedDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plannedDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("province");
        elemField.setXmlName(new javax.xml.namespace.QName("", "province"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobile"));
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
