package com.cardvalue.penguin.dto;

import java.util.Date;

/**
 * Created by Mr tao on 2015/6/16.
 */
public class UpdateUserDTO {
    private String loanAmount; //意向融资金额|拟融资金额
    private String planFundTerm;//意向融资期限|拟融资期限(月)
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

    private String landlordPhone;//房东手机号码
    private String secondaryBankName;//放款银行名称
    private String secondaryBankDDA;//放款银行卡号
    private String directType;//直系亲属
    private String emergencyName;//紧急联系人姓名
    private String directPhone;//直系亲属手机号码
    private String emergencyPhone;//紧急联络人手机号码

    private String hasLeaseContract;//是否有租赁合同：1 有，0 无
    private String noLeaseContractReason;//无租赁合同原因 1：自有房产，2：无偿使用，3：合同丢失
    private String proprietorName;//业主姓名
    private String proprietorPhone;//业主电话
    private String leaseContractStartTime;//合同开始日期
    private String leaseContractEndTime;//合同结束日期
    private String leaseYearAmt;//年租金
    private String directName;//直系亲属姓名
    private String couponIds;//红包id

    public String getCouponIds() {
        return couponIds;
    }

    public void setCouponIds(String couponIds) {
        this.couponIds = couponIds;
    }

    public String getDirectName() {
        return directName;
    }

    public void setDirectName(String directName) {
        this.directName = directName;
    }

    public String getLeaseYearAmt() {
        return leaseYearAmt;
    }

    public void setLeaseYearAmt(String leaseYearAmt) {
        this.leaseYearAmt = leaseYearAmt;
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

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public void setLandlordPhone(String landlordPhone) {
        this.landlordPhone = landlordPhone;
    }

    public String getSecondaryBankName() {
        return secondaryBankName;
    }

    public void setSecondaryBankName(String secondaryBankName) {
        this.secondaryBankName = secondaryBankName;
    }

    public String getSecondaryBankDDA() {
        return secondaryBankDDA;
    }

    public void setSecondaryBankDDA(String secondaryBankDDA) {
        this.secondaryBankDDA = secondaryBankDDA;
    }

    public String getDirectType() {
        return directType;
    }

    public void setDirectType(String directType) {
        this.directType = directType;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getDirectPhone() {
        return directPhone;
    }

    public void setDirectPhone(String directPhone) {
        this.directPhone = directPhone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
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

    public String getPurposeFactor() {
        return purposeFactor;
    }

    public void setPurposeFactor(String purposeFactor) {
        this.purposeFactor = purposeFactor;
    }

    public String getOwnerSSN() {
        return ownerSSN;
    }

    public void setOwnerSSN(String ownerSSN) {
        this.ownerSSN = ownerSSN;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerResidenceYears() {
        return ownerResidenceYears;
    }

    public void setOwnerResidenceYears(String ownerResidenceYears) {
        this.ownerResidenceYears = ownerResidenceYears;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPercentage2() {
        return ownerPercentage2;
    }

    public void setOwnerPercentage2(String ownerPercentage2) {
        this.ownerPercentage2 = ownerPercentage2;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    public String getOpratorMaritalStatus() {
        return opratorMaritalStatus;
    }

    public void setOpratorMaritalStatus(String opratorMaritalStatus) {
        this.opratorMaritalStatus = opratorMaritalStatus;
    }

    public String getOwner2NearestRelativeName() {
        return owner2NearestRelativeName;
    }

    public void setOwner2NearestRelativeName(String owner2NearestRelativeName) {
        this.owner2NearestRelativeName = owner2NearestRelativeName;
    }

    public String getOwner2RelativePhone() {
        return owner2RelativePhone;
    }

    public void setOwner2RelativePhone(String owner2RelativePhone) {
        this.owner2RelativePhone = owner2RelativePhone;
    }
}
