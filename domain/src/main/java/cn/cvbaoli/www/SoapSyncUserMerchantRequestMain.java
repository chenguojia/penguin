/**
 * SoapSyncUserMerchantRequestMain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public class SoapSyncUserMerchantRequestMain  implements java.io.Serializable {
    private String username;

    private String mobile;

    private String main_mid;

    private String province_id;

    private String corporate_name;

    private String corporate_address;

    private String processor_id;

    public SoapSyncUserMerchantRequestMain() {
    }

    public SoapSyncUserMerchantRequestMain(
           String username,
           String mobile,
           String main_mid,
           String province_id,
           String corporate_name,
           String corporate_address,
           String processor_id) {
           this.username = username;
           this.mobile = mobile;
           this.main_mid = main_mid;
           this.province_id = province_id;
           this.corporate_name = corporate_name;
           this.corporate_address = corporate_address;
           this.processor_id = processor_id;
    }


    /**
     * Gets the username value for this SoapSyncUserMerchantRequestMain.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this SoapSyncUserMerchantRequestMain.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the mobile value for this SoapSyncUserMerchantRequestMain.
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this SoapSyncUserMerchantRequestMain.
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the main_mid value for this SoapSyncUserMerchantRequestMain.
     *
     * @return main_mid
     */
    public String getMain_mid() {
        return main_mid;
    }


    /**
     * Sets the main_mid value for this SoapSyncUserMerchantRequestMain.
     *
     * @param main_mid
     */
    public void setMain_mid(String main_mid) {
        this.main_mid = main_mid;
    }


    /**
     * Gets the province_id value for this SoapSyncUserMerchantRequestMain.
     *
     * @return province_id
     */
    public String getProvince_id() {
        return province_id;
    }


    /**
     * Sets the province_id value for this SoapSyncUserMerchantRequestMain.
     *
     * @param province_id
     */
    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }


    /**
     * Gets the corporate_name value for this SoapSyncUserMerchantRequestMain.
     *
     * @return corporate_name
     */
    public String getCorporate_name() {
        return corporate_name;
    }


    /**
     * Sets the corporate_name value for this SoapSyncUserMerchantRequestMain.
     *
     * @param corporate_name
     */
    public void setCorporate_name(String corporate_name) {
        this.corporate_name = corporate_name;
    }


    /**
     * Gets the corporate_address value for this SoapSyncUserMerchantRequestMain.
     *
     * @return corporate_address
     */
    public String getCorporate_address() {
        return corporate_address;
    }


    /**
     * Sets the corporate_address value for this SoapSyncUserMerchantRequestMain.
     *
     * @param corporate_address
     */
    public void setCorporate_address(String corporate_address) {
        this.corporate_address = corporate_address;
    }


    /**
     * Gets the processor_id value for this SoapSyncUserMerchantRequestMain.
     *
     * @return processor_id
     */
    public String getProcessor_id() {
        return processor_id;
    }


    /**
     * Sets the processor_id value for this SoapSyncUserMerchantRequestMain.
     *
     * @param processor_id
     */
    public void setProcessor_id(String processor_id) {
        this.processor_id = processor_id;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapSyncUserMerchantRequestMain)) return false;
        SoapSyncUserMerchantRequestMain other = (SoapSyncUserMerchantRequestMain) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.username==null && other.getUsername()==null) ||
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            ((this.mobile==null && other.getMobile()==null) ||
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.main_mid==null && other.getMain_mid()==null) ||
             (this.main_mid!=null &&
              this.main_mid.equals(other.getMain_mid()))) &&
            ((this.province_id==null && other.getProvince_id()==null) ||
             (this.province_id!=null &&
              this.province_id.equals(other.getProvince_id()))) &&
            ((this.corporate_name==null && other.getCorporate_name()==null) ||
             (this.corporate_name!=null &&
              this.corporate_name.equals(other.getCorporate_name()))) &&
            ((this.corporate_address==null && other.getCorporate_address()==null) ||
             (this.corporate_address!=null &&
              this.corporate_address.equals(other.getCorporate_address()))) &&
            ((this.processor_id==null && other.getProcessor_id()==null) ||
             (this.processor_id!=null &&
              this.processor_id.equals(other.getProcessor_id())));
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
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getMain_mid() != null) {
            _hashCode += getMain_mid().hashCode();
        }
        if (getProvince_id() != null) {
            _hashCode += getProvince_id().hashCode();
        }
        if (getCorporate_name() != null) {
            _hashCode += getCorporate_name().hashCode();
        }
        if (getCorporate_address() != null) {
            _hashCode += getCorporate_address().hashCode();
        }
        if (getProcessor_id() != null) {
            _hashCode += getProcessor_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapSyncUserMerchantRequestMain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.cvbaoli.cn", "soapSyncUserMerchantRequestMain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("main_mid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "main_mid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("province_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "province_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporate_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corporate_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporate_address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corporate_address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processor_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processor_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
