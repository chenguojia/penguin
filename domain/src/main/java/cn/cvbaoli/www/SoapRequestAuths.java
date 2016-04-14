/**
 * SoapRequestAuths.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public class SoapRequestAuths  implements java.io.Serializable {
    private String auth_name;

    private String auth_psw;

    public SoapRequestAuths() {
    }

    public SoapRequestAuths(
           String auth_name,
           String auth_psw) {
           this.auth_name = auth_name;
           this.auth_psw = auth_psw;
    }


    /**
     * Gets the auth_name value for this SoapRequestAuths.
     *
     * @return auth_name
     */
    public String getAuth_name() {
        return auth_name;
    }


    /**
     * Sets the auth_name value for this SoapRequestAuths.
     *
     * @param auth_name
     */
    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }


    /**
     * Gets the auth_psw value for this SoapRequestAuths.
     *
     * @return auth_psw
     */
    public String getAuth_psw() {
        return auth_psw;
    }


    /**
     * Sets the auth_psw value for this SoapRequestAuths.
     *
     * @param auth_psw
     */
    public void setAuth_psw(String auth_psw) {
        this.auth_psw = auth_psw;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SoapRequestAuths)) return false;
        SoapRequestAuths other = (SoapRequestAuths) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.auth_name==null && other.getAuth_name()==null) ||
             (this.auth_name!=null &&
              this.auth_name.equals(other.getAuth_name()))) &&
            ((this.auth_psw==null && other.getAuth_psw()==null) ||
             (this.auth_psw!=null &&
              this.auth_psw.equals(other.getAuth_psw())));
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
        if (getAuth_name() != null) {
            _hashCode += getAuth_name().hashCode();
        }
        if (getAuth_psw() != null) {
            _hashCode += getAuth_psw().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoapRequestAuths.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auth_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_psw");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auth_psw"));
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
