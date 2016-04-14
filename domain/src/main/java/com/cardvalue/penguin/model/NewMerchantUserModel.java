package com.cardvalue.penguin.model;

import java.util.*;

/**
 * Created by guojia.chen on 2015-12-29 15:47.
 *
 * @Description: 商户描述字段
 *                  用户信息
 */

public class NewMerchantUserModel {

    private String mobilePhone;
    private String idNumber;
    private String applicationId;
    private String businessName;
    private String createdAt;
    private String updatedAt;
    private String objectId;
    private String numLocations;//门店数
    private String opratorIsLocal;
    private String opratorAcdQua;
    private String businessContactPhone;
    private String sicCategory;
    private String merchantBusinessYears;
    private String surveySquareFootage;
    private String hasBusinessLicense;
    private String cityId;
    private String industryCategoryId;
    private String installPosTime;
    private String[] mids;
    private String openId;
    private String agreeToLicense; //是否同意授权 1同意 0还未同意
    private String isRenewable;//是否可续贷
    private List<Map> progress;

    //基础字段
    private String loanAmount; //意向融资金额|拟融资金额
    private String planFundTerm;//意向融资期限|拟融资期限(月)
    private String planFundTermName;//拟融资期限名称
    private String purposeFactor;//用途|资金用途 1:开立分店; 2:店铺装修; 3:添置设备; 4:购买库存; 5:工资账单; 6:广告宣传; 7:其他;
    private String ownerSSN;//身份证号码|法人身份证号
    private String ownerPhone;//固定电话
    private String ownerResidenceYears;//现址居住年限|法人现居住地年限; 数字1至99;
    private String ownerEmail;//邮箱|法人邮箱
    private String ownerAddress;//地址|法人所住地址
    private String ownerPercentage2;//股权百分比|股份比例
    private String apartmentType;//住宅类别  自置:自置; 按揭:按揭; 租借:租借; 父母住宅:父母住宅; 其它:其它;
    private String opratorMaritalStatus;//婚姻状况 已婚:已婚; 未婚:未婚;
    private String owner2NearestRelativeName;//非同住亲友姓名
    private String owner2RelativePhone;//非同住亲友手机

    private String ownerName;//账户名
    private String paybackPeriod;
    private String tenementNature;
    private String bizStartDate;
    private String industryPId;//二级行业
    private String provinceId;

    private String longitude;//经度
    private String latitude;//维度

    private String isJxlValid;//聚信立是否验证
    private String qrcodeContent;
    private String qrcodeUrl;
    private String merchantNature;//店铺性质
    private String industryPName;//二级行业名称

    private String landlordPhone;//房东手机号码
    private String emergencyName;//紧急联系人
    private String emergencyPhone;//紧急联系人手机号
    private String directType;//直系亲属类型	父母：父母，子女：子女
    private String directPhone;//直系亲属手机号
    private String bizAddrLonlat;
    private String bizRegisterNo;
    private String businessAddress;
    private String isPosCreditValid;
    private String isBasicCreditValid;
    private String isEmailVerified;
    private String couponCount;
    private String inviteCount;

    private String industryCName;//三级行业名称

    private String bizResigterNo;//公司注册账号
    private String secondaryBankDDA;//放款账户号
    private String secondaryBankName;//放款账户银行

    private String industryCId;//三级级行业
    private String industryGId;//一级行业
    private String industryGName;//一级行业名称
    private String hasLeaseContract;//是否有租赁合同，1：有，0：无
    private String noLeaseContractReason;//无租赁合同原因，1：自有房产，2：无偿使用，3：合同丢失
    private String proprietorName;//业主姓名
    private String proprietorPhone;//业主电话号码
    private String leaseContractStartTime;//合同开始日期
    private String leaseContractEndTime;//合同结束日期
    private String leaseYearAmt;//年租金
    private String proposerName;//申请人
    private List<Map<String,String>> selHasLeaseContract;//是否有租赁合同数据字典
    private List<Map<String,String>> selNoLeaseContractReason;//无租赁合同原因数据字典
    private List<Map<String,String>>selPlanFundTerm;

    private String directName;//直系亲属姓名
    private String corporateName;

    private String yearTurnover;

    public String getYearTurnover() {
        return yearTurnover;
    }

    public void setYearTurnover(String yearTurnover) {
        this.yearTurnover = yearTurnover;
    }

    public List<Map<String, String>> getSelPlanFundTerm() {
        return selPlanFundTerm;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public void setSelPlanFundTerm(List<Map<String, String>> selPlanFundTerm) {
        this.selPlanFundTerm = selPlanFundTerm;
    }

    public String getDirectName() {
        return directName;
    }

    public void setDirectName(String directName) {
        this.directName = directName;
    }

    public List<Map<String, String>> getSelHasLeaseContract() {
        return selHasLeaseContract;
    }

    public void setSelHasLeaseContract(List<Map<String, String>> selHasLeaseContract) {
        this.selHasLeaseContract = selHasLeaseContract;
    }

    public List<Map<String, String>> getSelNoLeaseContractReason() {
        return selNoLeaseContractReason;
    }

    public void setSelNoLeaseContractReason(List<Map<String, String>> selNoLeaseContractReason) {
        this.selNoLeaseContractReason = selNoLeaseContractReason;
    }

    public String getIndustryGName() {
        return industryGName;
    }

    public void setIndustryGName(String industryGName) {
        this.industryGName = industryGName;
    }

    public String getPlanFundTermName() {
        return planFundTermName;
    }

    public void setPlanFundTermName(String planFundTermName) {
        this.planFundTermName = planFundTermName;
    }

    public String getProprietorName() {
        return proprietorName;
    }

    public void setProprietorName(String proprietorName) {
        this.proprietorName = proprietorName;
    }

    public String getProprietorPhone() {
        return proprietorPhone;
    }

    public void setProprietorPhone(String proprietorPhone) {
        this.proprietorPhone = proprietorPhone;
    }

    public String getLeaseContractStartTime() {
        return leaseContractStartTime;
    }

    public void setLeaseContractStartTime(String leaseContractStartTime) {
        this.leaseContractStartTime = leaseContractStartTime;
    }

    public String getLeaseContractEndTime() {
        return leaseContractEndTime;
    }

    public void setLeaseContractEndTime(String leaseContractEndTime) {
        this.leaseContractEndTime = leaseContractEndTime;
    }

    public String getLeaseYearAmt() {
        return leaseYearAmt;
    }

    public void setLeaseYearAmt(String leaseYearAmt) {
        this.leaseYearAmt = leaseYearAmt;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getHasLeaseContract() {
        return hasLeaseContract;
    }

    public void setHasLeaseContract(String hasLeaseContract) {
        this.hasLeaseContract = hasLeaseContract;
    }

    public String getNoLeaseContractReason() {
        return noLeaseContractReason;
    }

    public void setNoLeaseContractReason(String noLeaseContractReason) {
        this.noLeaseContractReason = noLeaseContractReason;
    }

    public String getIndustryCName() {
        return industryCName;
    }

    public String getBizResigterNo() {
        return bizResigterNo;
    }

    public void setBizResigterNo(String bizResigterNo) {
        this.bizResigterNo = bizResigterNo;
    }

    public void setIndustryCName(String industryCName) {
        this.industryCName = industryCName;
    }

    public String getIndustryPName() {
        return industryPName;
    }

    public void setIndustryPName(String industryPName) {
        this.industryPName = industryPName;
    }

    public String getMerchantNature() {
        return merchantNature;
    }

    public void setMerchantNature(String merchantNature) {
        this.merchantNature = merchantNature;
    }

    public String getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(String couponCount) {
        this.couponCount = couponCount;
    }

    public String getInviteCount() {
        return inviteCount;
    }

    public void setInviteCount(String inviteCount) {
        this.inviteCount = inviteCount;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getQrcodeContent() {
        return qrcodeContent;
    }

    public void setQrcodeContent(String qrcodeContent) {
        this.qrcodeContent = qrcodeContent;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getSecondaryBankDDA() {
        return secondaryBankDDA;
    }

    public void setSecondaryBankDDA(String secondaryBankDDA) {
        this.secondaryBankDDA = secondaryBankDDA;
    }

    public String getSecondaryBankName() {
        return secondaryBankName;
    }

    public void setSecondaryBankName(String secondaryBankName) {
        this.secondaryBankName = secondaryBankName;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getIndustryGId() {
        return industryGId;
    }

    public void setIndustryGId(String industryGId) {
        this.industryGId = industryGId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getNumLocations() {
        return numLocations;
    }

    public void setNumLocations(String numLocations) {
        this.numLocations = numLocations;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPercentage2() {
        return ownerPercentage2;
    }

    public void setOwnerPercentage2(String ownerPercentage2) {
        this.ownerPercentage2 = ownerPercentage2;
    }

    public String getOpratorIsLocal() {
        return opratorIsLocal;
    }

    public void setOpratorIsLocal(String opratorIsLocal) {
        this.opratorIsLocal = opratorIsLocal;
    }

    public String getOpratorMaritalStatus() {
        return opratorMaritalStatus;
    }

    public void setOpratorMaritalStatus(String opratorMaritalStatus) {
        this.opratorMaritalStatus = opratorMaritalStatus;
    }

    public String getOpratorAcdQua() {
        return opratorAcdQua;
    }

    public void setOpratorAcdQua(String opratorAcdQua) {
        this.opratorAcdQua = opratorAcdQua;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getBusinessContactPhone() {
        return businessContactPhone;
    }

    public void setBusinessContactPhone(String businessContactPhone) {
        this.businessContactPhone = businessContactPhone;
    }

    public String getSicCategory() {
        return sicCategory;
    }

    public void setSicCategory(String sicCategory) {
        this.sicCategory = sicCategory;
    }

    public String getMerchantBusinessYears() {
        return merchantBusinessYears;
    }

    public void setMerchantBusinessYears(String merchantBusinessYears) {
        this.merchantBusinessYears = merchantBusinessYears;
    }

    public String getSurveySquareFootage() {
        return surveySquareFootage;
    }

    public void setSurveySquareFootage(String surveySquareFootage) {
        this.surveySquareFootage = surveySquareFootage;
    }

    public String getHasBusinessLicense() {
        return hasBusinessLicense;
    }

    public void setHasBusinessLicense(String hasBusinessLicense) {
        this.hasBusinessLicense = hasBusinessLicense;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getIndustryCategoryId() {
        return industryCategoryId;
    }

    public void setIndustryCategoryId(String industryCategoryId) {
        this.industryCategoryId = industryCategoryId;
    }

    public String getInstallPosTime() {
        return installPosTime;
    }

    public void setInstallPosTime(String installPosTime) {
        this.installPosTime = installPosTime;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPlanFundTerm() {
        return planFundTerm;
    }

    public void setPlanFundTerm(String planFundTerm) {
        this.planFundTerm = planFundTerm;
    }

    public String getOwner2NearestRelativeName() {
        return owner2NearestRelativeName;
    }

    public void setOwner2NearestRelativeName(String owner2NearestRelativeName) {
        this.owner2NearestRelativeName = owner2NearestRelativeName;
    }

    public String getPurposeFactor() {
        return purposeFactor;
    }

    public void setPurposeFactor(String purposeFactor) {
        this.purposeFactor = purposeFactor;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getOwnerResidenceYears() {
        return ownerResidenceYears;
    }

    public void setOwnerResidenceYears(String ownerResidenceYears) {
        this.ownerResidenceYears = ownerResidenceYears;
    }

    public String[] getMids() {
        return mids;
    }

    public void setMids(String[] mids) {
        this.mids = mids;
    }

    public String getAgreeToLicense() {
        return agreeToLicense;
    }

    public void setAgreeToLicense(String agreeToLicense) {
        this.agreeToLicense = agreeToLicense;
    }

    public String getIsRenewable() {
        return isRenewable;
    }

    public void setIsRenewable(String isRenewable) {
        this.isRenewable = isRenewable;
    }

    public String getOwnerSSN() {
        return ownerSSN;
    }

    public void setOwnerSSN(String ownerSSN) {
        this.ownerSSN = ownerSSN;
    }

    public String getOwner2RelativePhone() {
        return owner2RelativePhone;
    }

    public void setOwner2RelativePhone(String owner2RelativePhone) {
        this.owner2RelativePhone = owner2RelativePhone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(String paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }

    public String getTenementNature() {
        return tenementNature;
    }

    public void setTenementNature(String tenementNature) {
        this.tenementNature = tenementNature;
    }

    public String getBizStartDate() {
        return bizStartDate;
    }

    public void setBizStartDate(String bizStartDate) {
        this.bizStartDate = bizStartDate;
    }

    public String getIndustryPId() {
        return industryPId;
    }

    public void setIndustryPId(String industryPId) {
        this.industryPId = industryPId;
    }

    public String getIndustryCId() {
        return industryCId;
    }

    public void setIndustryCId(String industryCId) {
        this.industryCId = industryCId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIsJxlValid() {
        return isJxlValid;
    }

    public void setIsJxlValid(String isJxlValid) {
        this.isJxlValid = isJxlValid;
    }

    public List<Map> getProgress() {
        return progress;
    }

    public void setProgress(List<Map> progress) {
        this.progress = progress;
    }

    public String getIsBasicCreditValid() {
        return isBasicCreditValid;
    }

    public void setIsBasicCreditValid(String isBasicCreditValid) {
        this.isBasicCreditValid = isBasicCreditValid;
    }

    public String getIsPosCreditValid() {
        return isPosCreditValid;
    }

    public void setIsPosCreditValid(String isPosCreditValid) {
        this.isPosCreditValid = isPosCreditValid;
    }

    public String getIsEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(String isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public void setLandlordPhone(String landlordPhone) {
        this.landlordPhone = landlordPhone;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getDirectType() {
        return directType;
    }

    public void setDirectType(String directType) {
        this.directType = directType;
    }

    public String getDirectPhone() {
        return directPhone;
    }

    public void setDirectPhone(String directPhone) {
        this.directPhone = directPhone;
    }

    public String getBizAddrLonlat() {
        return bizAddrLonlat;
    }

    public void setBizAddrLonlat(String bizAddrLonlat) {
        this.bizAddrLonlat = bizAddrLonlat;
    }

    public String getBizRegisterNo() {
        return bizRegisterNo;
    }

    public void setBizRegisterNo(String bizRegisterNo) {
        this.bizRegisterNo = bizRegisterNo;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    @Override
    public String toString() {
        return "NewMerchantUserModel{" +
                "mobilePhone='" + mobilePhone + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", businessName='" + businessName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", objectId='" + objectId + '\'' +
                ", numLocations='" + numLocations + '\'' +
                ", opratorIsLocal='" + opratorIsLocal + '\'' +
                ", opratorAcdQua='" + opratorAcdQua + '\'' +
                ", businessContactPhone='" + businessContactPhone + '\'' +
                ", sicCategory='" + sicCategory + '\'' +
                ", merchantBusinessYears='" + merchantBusinessYears + '\'' +
                ", surveySquareFootage='" + surveySquareFootage + '\'' +
                ", hasBusinessLicense='" + hasBusinessLicense + '\'' +
                ", cityId='" + cityId + '\'' +
                ", industryCategoryId='" + industryCategoryId + '\'' +
                ", installPosTime='" + installPosTime + '\'' +
                ", mids=" + Arrays.toString(mids) +
                ", openId='" + openId + '\'' +
                ", agreeToLicense='" + agreeToLicense + '\'' +
                ", isRenewable='" + isRenewable + '\'' +
                ", progress=" + progress +
                ", loanAmount='" + loanAmount + '\'' +
                ", planFundTerm='" + planFundTerm + '\'' +
                ", planFundTermName='" + planFundTermName + '\'' +
                ", purposeFactor='" + purposeFactor + '\'' +
                ", ownerSSN='" + ownerSSN + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", ownerResidenceYears='" + ownerResidenceYears + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", ownerPercentage2='" + ownerPercentage2 + '\'' +
                ", apartmentType='" + apartmentType + '\'' +
                ", opratorMaritalStatus='" + opratorMaritalStatus + '\'' +
                ", owner2NearestRelativeName='" + owner2NearestRelativeName + '\'' +
                ", owner2RelativePhone='" + owner2RelativePhone + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", paybackPeriod='" + paybackPeriod + '\'' +
                ", tenementNature='" + tenementNature + '\'' +
                ", bizStartDate='" + bizStartDate + '\'' +
                ", industryPId='" + industryPId + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", isJxlValid='" + isJxlValid + '\'' +
                ", qrcodeContent='" + qrcodeContent + '\'' +
                ", qrcodeUrl='" + qrcodeUrl + '\'' +
                ", merchantNature='" + merchantNature + '\'' +
                ", industryPName='" + industryPName + '\'' +
                ", landlordPhone='" + landlordPhone + '\'' +
                ", emergencyName='" + emergencyName + '\'' +
                ", emergencyPhone='" + emergencyPhone + '\'' +
                ", directType='" + directType + '\'' +
                ", directPhone='" + directPhone + '\'' +
                ", bizAddrLonlat='" + bizAddrLonlat + '\'' +
                ", bizRegisterNo='" + bizRegisterNo + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", isPosCreditValid='" + isPosCreditValid + '\'' +
                ", isBasicCreditValid='" + isBasicCreditValid + '\'' +
                ", isEmailVerified='" + isEmailVerified + '\'' +
                ", couponCount='" + couponCount + '\'' +
                ", inviteCount='" + inviteCount + '\'' +
                ", industryCName='" + industryCName + '\'' +
                ", bizResigterNo='" + bizResigterNo + '\'' +
                ", secondaryBankDDA='" + secondaryBankDDA + '\'' +
                ", secondaryBankName='" + secondaryBankName + '\'' +
                ", industryCId='" + industryCId + '\'' +
                ", industryGId='" + industryGId + '\'' +
                ", industryGName='" + industryGName + '\'' +
                ", hasLeaseContract='" + hasLeaseContract + '\'' +
                ", noLeaseContractReason='" + noLeaseContractReason + '\'' +
                ", proprietorName='" + proprietorName + '\'' +
                ", proprietorPhone='" + proprietorPhone + '\'' +
                ", leaseContractStartTime='" + leaseContractStartTime + '\'' +
                ", leaseContractEndTime='" + leaseContractEndTime + '\'' +
                ", leaseYearAmt='" + leaseYearAmt + '\'' +
                ", proposerName='" + proposerName + '\'' +
                ", selHasLeaseContract=" + selHasLeaseContract +
                ", selNoLeaseContractReason=" + selNoLeaseContractReason +
                ", selPlanFundTerm=" + selPlanFundTerm +
                '}';
    }
}
