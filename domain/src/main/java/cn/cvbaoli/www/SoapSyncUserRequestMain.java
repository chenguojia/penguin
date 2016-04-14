/**
 * SoapSyncUserRequestMain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public class SoapSyncUserRequestMain  implements java.io.Serializable {
    private String username;

    private String password;

    private String real_name;

    private String mobile;

    private String email;

    private String province_id;

    private String city_id;

    private String enabled;

    public SoapSyncUserRequestMain() {
    }

    public SoapSyncUserRequestMain(
           String username,
           String password,
           String real_name,
           String mobile,
           String email,
           String province_id,
           String city_id,
           String enabled) {
           this.username = username;
           this.password = password;
           this.real_name = real_name;
           this.mobile = mobile;
           this.email = email;
           this.province_id = province_id;
           this.city_id = city_id;
           this.enabled = enabled;
    }


    /**
     * Gets the username value for this SoapSyncUserRequestMain.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this SoapSyncUserRequestMain.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the password value for this SoapSyncUserRequestMain.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SoapSyncUserRequestMain.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Gets the real_name value for this SoapSyncUserRequestMain.
     *
     * @return real_name
     */
    public String getReal_name() {
        return real_name;
    }


    /**
     * Sets the real_name value for this SoapSyncUserRequestMain.
     *
     * @param real_name
     */
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }


    /**
     * Gets the mobile value for this SoapSyncUserRequestMain.
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this SoapSyncUserRequestMain.
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the email value for this SoapSyncUserRequestMain.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this SoapSyncUserRequestMain.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the province_id value for this SoapSyncUserRequestMain.
     *
     * @return province_id
     */
    public String getProvince_id() {
        return province_id;
    }


    /**
     * Sets the province_id value for this SoapSyncUserRequestMain.
     *
     * @param province_id
     */
    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }


    /**
     * Gets the city_id value for this SoapSyncUserRequestMain.
     *
     * @return city_id
     */
    public String getCity_id() {
        return city_id;
    }


    /**
     * Sets the city_id value for this SoapSyncUserRequestMain.
     *
     * @param city_id
     */
    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }


    /**
     * Gets the enabled value for this SoapSyncUserRequestMain.
     *
     * @return enabled
     */
    public String getEnabled() {
        return enabled;
    }


    /**
     * Sets the enabled value for this SoapSyncUserRequestMain.
     *
     * @param enabled
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapSyncUserRequestMain)) return false;
        SoapSyncUserRequestMain other = (SoapSyncUserRequestMain) obj;
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
            ((this.password==null && other.getPassword()==null) ||
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.real_name==null && other.getReal_name()==null) ||
             (this.real_name!=null &&
              this.real_name.equals(other.getReal_name()))) &&
            ((this.mobile==null && other.getMobile()==null) ||
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.email==null && other.getEmail()==null) ||
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.province_id==null && other.getProvince_id()==null) ||
             (this.province_id!=null &&
              this.province_id.equals(other.getProvince_id()))) &&
            ((this.city_id==null && other.getCity_id()==null) ||
             (this.city_id!=null &&
              this.city_id.equals(other.getCity_id()))) &&
            ((this.enabled==null && other.getEnabled()==null) ||
             (this.enabled!=null &&
              this.enabled.equals(other.getEnabled())));
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
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getReal_name() != null) {
            _hashCode += getReal_name().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getProvince_id() != null) {
            _hashCode += getProvince_id().hashCode();
        }
        if (getCity_id() != null) {
            _hashCode += getCity_id().hashCode();
        }
        if (getEnabled() != null) {
            _hashCode += getEnabled().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapSyncUserRequestMain.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.cvbaoli.cn", "soapSyncUserRequestMain"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("real_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "real_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("province_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "province_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "city_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enabled");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enabled"));
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
