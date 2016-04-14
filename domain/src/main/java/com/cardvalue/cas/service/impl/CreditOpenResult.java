/**
 * CreditOpenResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class CreditOpenResult  implements java.io.Serializable {
    private String addressType;

    private String applicantId;

    private String businessAreaClass;

    private String businessId;

    private String businessType;

    private String cityClass;

    private String cityName;

    private String educationClass;

    private String hasChildren;

    private String localResidence;

    private String maritalStatus;

    private Integer monthFrequency;

    private Integer openCredit;

    private String openLevel;

    private com.cardvalue.cas.service.impl.MerchMidBillStatInfo openMerchStat;

    private java.math.BigDecimal openScore;

    private String staffNumClass;

    private String status;

    private String statusInfo;

    public CreditOpenResult() {
    }

    public CreditOpenResult(
           String addressType,
           String applicantId,
           String businessAreaClass,
           String businessId,
           String businessType,
           String cityClass,
           String cityName,
           String educationClass,
           String hasChildren,
           String localResidence,
           String maritalStatus,
           Integer monthFrequency,
           Integer openCredit,
           String openLevel,
           com.cardvalue.cas.service.impl.MerchMidBillStatInfo openMerchStat,
           java.math.BigDecimal openScore,
           String staffNumClass,
           String status,
           String statusInfo) {
           this.addressType = addressType;
           this.applicantId = applicantId;
           this.businessAreaClass = businessAreaClass;
           this.businessId = businessId;
           this.businessType = businessType;
           this.cityClass = cityClass;
           this.cityName = cityName;
           this.educationClass = educationClass;
           this.hasChildren = hasChildren;
           this.localResidence = localResidence;
           this.maritalStatus = maritalStatus;
           this.monthFrequency = monthFrequency;
           this.openCredit = openCredit;
           this.openLevel = openLevel;
           this.openMerchStat = openMerchStat;
           this.openScore = openScore;
           this.staffNumClass = staffNumClass;
           this.status = status;
           this.statusInfo = statusInfo;
    }


    /**
     * Gets the addressType value for this CreditOpenResult.
     *
     * @return addressType
     */
    public String getAddressType() {
        return addressType;
    }


    /**
     * Sets the addressType value for this CreditOpenResult.
     *
     * @param addressType
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }


    /**
     * Gets the applicantId value for this CreditOpenResult.
     *
     * @return applicantId
     */
    public String getApplicantId() {
        return applicantId;
    }


    /**
     * Sets the applicantId value for this CreditOpenResult.
     *
     * @param applicantId
     */
    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }


    /**
     * Gets the businessAreaClass value for this CreditOpenResult.
     *
     * @return businessAreaClass
     */
    public String getBusinessAreaClass() {
        return businessAreaClass;
    }


    /**
     * Sets the businessAreaClass value for this CreditOpenResult.
     *
     * @param businessAreaClass
     */
    public void setBusinessAreaClass(String businessAreaClass) {
        this.businessAreaClass = businessAreaClass;
    }


    /**
     * Gets the businessId value for this CreditOpenResult.
     *
     * @return businessId
     */
    public String getBusinessId() {
        return businessId;
    }


    /**
     * Sets the businessId value for this CreditOpenResult.
     *
     * @param businessId
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }


    /**
     * Gets the businessType value for this CreditOpenResult.
     *
     * @return businessType
     */
    public String getBusinessType() {
        return businessType;
    }


    /**
     * Sets the businessType value for this CreditOpenResult.
     *
     * @param businessType
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }


    /**
     * Gets the cityClass value for this CreditOpenResult.
     *
     * @return cityClass
     */
    public String getCityClass() {
        return cityClass;
    }


    /**
     * Sets the cityClass value for this CreditOpenResult.
     *
     * @param cityClass
     */
    public void setCityClass(String cityClass) {
        this.cityClass = cityClass;
    }


    /**
     * Gets the cityName value for this CreditOpenResult.
     *
     * @return cityName
     */
    public String getCityName() {
        return cityName;
    }


    /**
     * Sets the cityName value for this CreditOpenResult.
     *
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    /**
     * Gets the educationClass value for this CreditOpenResult.
     *
     * @return educationClass
     */
    public String getEducationClass() {
        return educationClass;
    }


    /**
     * Sets the educationClass value for this CreditOpenResult.
     *
     * @param educationClass
     */
    public void setEducationClass(String educationClass) {
        this.educationClass = educationClass;
    }


    /**
     * Gets the hasChildren value for this CreditOpenResult.
     *
     * @return hasChildren
     */
    public String getHasChildren() {
        return hasChildren;
    }


    /**
     * Sets the hasChildren value for this CreditOpenResult.
     *
     * @param hasChildren
     */
    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }


    /**
     * Gets the localResidence value for this CreditOpenResult.
     *
     * @return localResidence
     */
    public String getLocalResidence() {
        return localResidence;
    }


    /**
     * Sets the localResidence value for this CreditOpenResult.
     *
     * @param localResidence
     */
    public void setLocalResidence(String localResidence) {
        this.localResidence = localResidence;
    }


    /**
     * Gets the maritalStatus value for this CreditOpenResult.
     *
     * @return maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }


    /**
     * Sets the maritalStatus value for this CreditOpenResult.
     *
     * @param maritalStatus
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }


    /**
     * Gets the monthFrequency value for this CreditOpenResult.
     *
     * @return monthFrequency
     */
    public Integer getMonthFrequency() {
        return monthFrequency;
    }


    /**
     * Sets the monthFrequency value for this CreditOpenResult.
     *
     * @param monthFrequency
     */
    public void setMonthFrequency(Integer monthFrequency) {
        this.monthFrequency = monthFrequency;
    }


    /**
     * Gets the openCredit value for this CreditOpenResult.
     *
     * @return openCredit
     */
    public Integer getOpenCredit() {
        return openCredit;
    }


    /**
     * Sets the openCredit value for this CreditOpenResult.
     *
     * @param openCredit
     */
    public void setOpenCredit(Integer openCredit) {
        this.openCredit = openCredit;
    }


    /**
     * Gets the openLevel value for this CreditOpenResult.
     *
     * @return openLevel
     */
    public String getOpenLevel() {
        return openLevel;
    }


    /**
     * Sets the openLevel value for this CreditOpenResult.
     *
     * @param openLevel
     */
    public void setOpenLevel(String openLevel) {
        this.openLevel = openLevel;
    }


    /**
     * Gets the openMerchStat value for this CreditOpenResult.
     *
     * @return openMerchStat
     */
    public com.cardvalue.cas.service.impl.MerchMidBillStatInfo getOpenMerchStat() {
        return openMerchStat;
    }


    /**
     * Sets the openMerchStat value for this CreditOpenResult.
     *
     * @param openMerchStat
     */
    public void setOpenMerchStat(com.cardvalue.cas.service.impl.MerchMidBillStatInfo openMerchStat) {
        this.openMerchStat = openMerchStat;
    }


    /**
     * Gets the openScore value for this CreditOpenResult.
     *
     * @return openScore
     */
    public java.math.BigDecimal getOpenScore() {
        return openScore;
    }


    /**
     * Sets the openScore value for this CreditOpenResult.
     *
     * @param openScore
     */
    public void setOpenScore(java.math.BigDecimal openScore) {
        this.openScore = openScore;
    }


    /**
     * Gets the staffNumClass value for this CreditOpenResult.
     *
     * @return staffNumClass
     */
    public String getStaffNumClass() {
        return staffNumClass;
    }


    /**
     * Sets the staffNumClass value for this CreditOpenResult.
     *
     * @param staffNumClass
     */
    public void setStaffNumClass(String staffNumClass) {
        this.staffNumClass = staffNumClass;
    }


    /**
     * Gets the status value for this CreditOpenResult.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CreditOpenResult.
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Gets the statusInfo value for this CreditOpenResult.
     *
     * @return statusInfo
     */
    public String getStatusInfo() {
        return statusInfo;
    }


    /**
     * Sets the statusInfo value for this CreditOpenResult.
     *
     * @param statusInfo
     */
    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CreditOpenResult)) return false;
        CreditOpenResult other = (CreditOpenResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.addressType==null && other.getAddressType()==null) ||
             (this.addressType!=null &&
              this.addressType.equals(other.getAddressType()))) &&
            ((this.applicantId==null && other.getApplicantId()==null) ||
             (this.applicantId!=null &&
              this.applicantId.equals(other.getApplicantId()))) &&
            ((this.businessAreaClass==null && other.getBusinessAreaClass()==null) ||
             (this.businessAreaClass!=null &&
              this.businessAreaClass.equals(other.getBusinessAreaClass()))) &&
            ((this.businessId==null && other.getBusinessId()==null) ||
             (this.businessId!=null &&
              this.businessId.equals(other.getBusinessId()))) &&
            ((this.businessType==null && other.getBusinessType()==null) ||
             (this.businessType!=null &&
              this.businessType.equals(other.getBusinessType()))) &&
            ((this.cityClass==null && other.getCityClass()==null) ||
             (this.cityClass!=null &&
              this.cityClass.equals(other.getCityClass()))) &&
            ((this.cityName==null && other.getCityName()==null) ||
             (this.cityName!=null &&
              this.cityName.equals(other.getCityName()))) &&
            ((this.educationClass==null && other.getEducationClass()==null) ||
             (this.educationClass!=null &&
              this.educationClass.equals(other.getEducationClass()))) &&
            ((this.hasChildren==null && other.getHasChildren()==null) ||
             (this.hasChildren!=null &&
              this.hasChildren.equals(other.getHasChildren()))) &&
            ((this.localResidence==null && other.getLocalResidence()==null) ||
             (this.localResidence!=null &&
              this.localResidence.equals(other.getLocalResidence()))) &&
            ((this.maritalStatus==null && other.getMaritalStatus()==null) ||
             (this.maritalStatus!=null &&
              this.maritalStatus.equals(other.getMaritalStatus()))) &&
            ((this.monthFrequency==null && other.getMonthFrequency()==null) ||
             (this.monthFrequency!=null &&
              this.monthFrequency.equals(other.getMonthFrequency()))) &&
            ((this.openCredit==null && other.getOpenCredit()==null) ||
             (this.openCredit!=null &&
              this.openCredit.equals(other.getOpenCredit()))) &&
            ((this.openLevel==null && other.getOpenLevel()==null) ||
             (this.openLevel!=null &&
              this.openLevel.equals(other.getOpenLevel()))) &&
            ((this.openMerchStat==null && other.getOpenMerchStat()==null) ||
             (this.openMerchStat!=null &&
              this.openMerchStat.equals(other.getOpenMerchStat()))) &&
            ((this.openScore==null && other.getOpenScore()==null) ||
             (this.openScore!=null &&
              this.openScore.equals(other.getOpenScore()))) &&
            ((this.staffNumClass==null && other.getStaffNumClass()==null) ||
             (this.staffNumClass!=null &&
              this.staffNumClass.equals(other.getStaffNumClass()))) &&
            ((this.status==null && other.getStatus()==null) ||
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.statusInfo==null && other.getStatusInfo()==null) ||
             (this.statusInfo!=null &&
              this.statusInfo.equals(other.getStatusInfo())));
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
        if (getAddressType() != null) {
            _hashCode += getAddressType().hashCode();
        }
        if (getApplicantId() != null) {
            _hashCode += getApplicantId().hashCode();
        }
        if (getBusinessAreaClass() != null) {
            _hashCode += getBusinessAreaClass().hashCode();
        }
        if (getBusinessId() != null) {
            _hashCode += getBusinessId().hashCode();
        }
        if (getBusinessType() != null) {
            _hashCode += getBusinessType().hashCode();
        }
        if (getCityClass() != null) {
            _hashCode += getCityClass().hashCode();
        }
        if (getCityName() != null) {
            _hashCode += getCityName().hashCode();
        }
        if (getEducationClass() != null) {
            _hashCode += getEducationClass().hashCode();
        }
        if (getHasChildren() != null) {
            _hashCode += getHasChildren().hashCode();
        }
        if (getLocalResidence() != null) {
            _hashCode += getLocalResidence().hashCode();
        }
        if (getMaritalStatus() != null) {
            _hashCode += getMaritalStatus().hashCode();
        }
        if (getMonthFrequency() != null) {
            _hashCode += getMonthFrequency().hashCode();
        }
        if (getOpenCredit() != null) {
            _hashCode += getOpenCredit().hashCode();
        }
        if (getOpenLevel() != null) {
            _hashCode += getOpenLevel().hashCode();
        }
        if (getOpenMerchStat() != null) {
            _hashCode += getOpenMerchStat().hashCode();
        }
        if (getOpenScore() != null) {
            _hashCode += getOpenScore().hashCode();
        }
        if (getStaffNumClass() != null) {
            _hashCode += getStaffNumClass().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatusInfo() != null) {
            _hashCode += getStatusInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreditOpenResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "creditOpenResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessAreaClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessAreaClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("educationClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "educationClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasChildren");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hasChildren"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localResidence");
        elemField.setXmlName(new javax.xml.namespace.QName("", "localResidence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maritalStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maritalStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthFrequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monthFrequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "openCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "openLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openMerchStat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "openMerchStat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "merchMidBillStatInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openScore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "openScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staffNumClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "staffNumClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusInfo"));
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
