/**
 * CreditResultReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class CreditResultReturn  implements java.io.Serializable {
    private String channel;

    private com.cardvalue.cas.service.impl.CreditMidResult[] cmrList;

    private com.cardvalue.cas.service.impl.CreditOpenResult cor;

    private String corpName;

    private String creditEffDate;

    private String creditExpDate;

    private String creditRating;

    private String creditScore;

    private String ddCredit;

    private String ddDays;

    private String feeRate;

    private String instantCredit;

    private String instantDays;

    private String mcc;

    private String mccNo;

    private String midAverageA;

    private String midBusiMonths;

    private String midContMonths;

    private String midCredit;

    private String midFrequencyF;

    private String midGrowthG;

    private String midLastMonVolumeL;

    private String midMonetaryM;

    private String midPerMonVolumeP;

    private String midRecencyR;

    private String midRecencyRdays;

    private String midStableS;

    private String midStandardCredit;

    private String midStandardJointCredit;

    private com.cardvalue.cas.service.impl.MerMidMonthStatistic[] mmmsList;

    private com.cardvalue.cas.service.impl.MerProductCredit[] mpcList;

    private String noLineReason;

    private String passFlag;

    private String plannedAmt;

    private String plannedDays;

    private String posCredit;

    private String posDays;

    private String province;

    private String resCode;

    private String resMsg;

    private String status;

    private String statusInfo;

    private String totalCredit;

    public CreditResultReturn() {
    }

    public CreditResultReturn(
           String channel,
           com.cardvalue.cas.service.impl.CreditMidResult[] cmrList,
           com.cardvalue.cas.service.impl.CreditOpenResult cor,
           String corpName,
           String creditEffDate,
           String creditExpDate,
           String creditRating,
           String creditScore,
           String ddCredit,
           String ddDays,
           String feeRate,
           String instantCredit,
           String instantDays,
           String mcc,
           String mccNo,
           String midAverageA,
           String midBusiMonths,
           String midContMonths,
           String midCredit,
           String midFrequencyF,
           String midGrowthG,
           String midLastMonVolumeL,
           String midMonetaryM,
           String midPerMonVolumeP,
           String midRecencyR,
           String midRecencyRdays,
           String midStableS,
           String midStandardCredit,
           String midStandardJointCredit,
           com.cardvalue.cas.service.impl.MerMidMonthStatistic[] mmmsList,
           com.cardvalue.cas.service.impl.MerProductCredit[] mpcList,
           String noLineReason,
           String passFlag,
           String plannedAmt,
           String plannedDays,
           String posCredit,
           String posDays,
           String province,
           String resCode,
           String resMsg,
           String status,
           String statusInfo,
           String totalCredit) {
           this.channel = channel;
           this.cmrList = cmrList;
           this.cor = cor;
           this.corpName = corpName;
           this.creditEffDate = creditEffDate;
           this.creditExpDate = creditExpDate;
           this.creditRating = creditRating;
           this.creditScore = creditScore;
           this.ddCredit = ddCredit;
           this.ddDays = ddDays;
           this.feeRate = feeRate;
           this.instantCredit = instantCredit;
           this.instantDays = instantDays;
           this.mcc = mcc;
           this.mccNo = mccNo;
           this.midAverageA = midAverageA;
           this.midBusiMonths = midBusiMonths;
           this.midContMonths = midContMonths;
           this.midCredit = midCredit;
           this.midFrequencyF = midFrequencyF;
           this.midGrowthG = midGrowthG;
           this.midLastMonVolumeL = midLastMonVolumeL;
           this.midMonetaryM = midMonetaryM;
           this.midPerMonVolumeP = midPerMonVolumeP;
           this.midRecencyR = midRecencyR;
           this.midRecencyRdays = midRecencyRdays;
           this.midStableS = midStableS;
           this.midStandardCredit = midStandardCredit;
           this.midStandardJointCredit = midStandardJointCredit;
           this.mmmsList = mmmsList;
           this.mpcList = mpcList;
           this.noLineReason = noLineReason;
           this.passFlag = passFlag;
           this.plannedAmt = plannedAmt;
           this.plannedDays = plannedDays;
           this.posCredit = posCredit;
           this.posDays = posDays;
           this.province = province;
           this.resCode = resCode;
           this.resMsg = resMsg;
           this.status = status;
           this.statusInfo = statusInfo;
           this.totalCredit = totalCredit;
    }


    /**
     * Gets the channel value for this CreditResultReturn.
     *
     * @return channel
     */
    public String getChannel() {
        return channel;
    }


    /**
     * Sets the channel value for this CreditResultReturn.
     *
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }


    /**
     * Gets the cmrList value for this CreditResultReturn.
     *
     * @return cmrList
     */
    public com.cardvalue.cas.service.impl.CreditMidResult[] getCmrList() {
        return cmrList;
    }


    /**
     * Sets the cmrList value for this CreditResultReturn.
     *
     * @param cmrList
     */
    public void setCmrList(com.cardvalue.cas.service.impl.CreditMidResult[] cmrList) {
        this.cmrList = cmrList;
    }

    public com.cardvalue.cas.service.impl.CreditMidResult getCmrList(int i) {
        return this.cmrList[i];
    }

    public void setCmrList(int i, com.cardvalue.cas.service.impl.CreditMidResult _value) {
        this.cmrList[i] = _value;
    }


    /**
     * Gets the cor value for this CreditResultReturn.
     *
     * @return cor
     */
    public com.cardvalue.cas.service.impl.CreditOpenResult getCor() {
        return cor;
    }


    /**
     * Sets the cor value for this CreditResultReturn.
     *
     * @param cor
     */
    public void setCor(com.cardvalue.cas.service.impl.CreditOpenResult cor) {
        this.cor = cor;
    }


    /**
     * Gets the corpName value for this CreditResultReturn.
     *
     * @return corpName
     */
    public String getCorpName() {
        return corpName;
    }


    /**
     * Sets the corpName value for this CreditResultReturn.
     *
     * @param corpName
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }


    /**
     * Gets the creditEffDate value for this CreditResultReturn.
     *
     * @return creditEffDate
     */
    public String getCreditEffDate() {
        return creditEffDate;
    }


    /**
     * Sets the creditEffDate value for this CreditResultReturn.
     *
     * @param creditEffDate
     */
    public void setCreditEffDate(String creditEffDate) {
        this.creditEffDate = creditEffDate;
    }


    /**
     * Gets the creditExpDate value for this CreditResultReturn.
     *
     * @return creditExpDate
     */
    public String getCreditExpDate() {
        return creditExpDate;
    }


    /**
     * Sets the creditExpDate value for this CreditResultReturn.
     *
     * @param creditExpDate
     */
    public void setCreditExpDate(String creditExpDate) {
        this.creditExpDate = creditExpDate;
    }


    /**
     * Gets the creditRating value for this CreditResultReturn.
     *
     * @return creditRating
     */
    public String getCreditRating() {
        return creditRating;
    }


    /**
     * Sets the creditRating value for this CreditResultReturn.
     *
     * @param creditRating
     */
    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }


    /**
     * Gets the creditScore value for this CreditResultReturn.
     *
     * @return creditScore
     */
    public String getCreditScore() {
        return creditScore;
    }


    /**
     * Sets the creditScore value for this CreditResultReturn.
     *
     * @param creditScore
     */
    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }


    /**
     * Gets the ddCredit value for this CreditResultReturn.
     *
     * @return ddCredit
     */
    public String getDdCredit() {
        return ddCredit;
    }


    /**
     * Sets the ddCredit value for this CreditResultReturn.
     *
     * @param ddCredit
     */
    public void setDdCredit(String ddCredit) {
        this.ddCredit = ddCredit;
    }


    /**
     * Gets the ddDays value for this CreditResultReturn.
     *
     * @return ddDays
     */
    public String getDdDays() {
        return ddDays;
    }


    /**
     * Sets the ddDays value for this CreditResultReturn.
     *
     * @param ddDays
     */
    public void setDdDays(String ddDays) {
        this.ddDays = ddDays;
    }


    /**
     * Gets the feeRate value for this CreditResultReturn.
     *
     * @return feeRate
     */
    public String getFeeRate() {
        return feeRate;
    }


    /**
     * Sets the feeRate value for this CreditResultReturn.
     *
     * @param feeRate
     */
    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate;
    }


    /**
     * Gets the instantCredit value for this CreditResultReturn.
     *
     * @return instantCredit
     */
    public String getInstantCredit() {
        return instantCredit;
    }


    /**
     * Sets the instantCredit value for this CreditResultReturn.
     *
     * @param instantCredit
     */
    public void setInstantCredit(String instantCredit) {
        this.instantCredit = instantCredit;
    }


    /**
     * Gets the instantDays value for this CreditResultReturn.
     *
     * @return instantDays
     */
    public String getInstantDays() {
        return instantDays;
    }


    /**
     * Sets the instantDays value for this CreditResultReturn.
     *
     * @param instantDays
     */
    public void setInstantDays(String instantDays) {
        this.instantDays = instantDays;
    }


    /**
     * Gets the mcc value for this CreditResultReturn.
     *
     * @return mcc
     */
    public String getMcc() {
        return mcc;
    }


    /**
     * Sets the mcc value for this CreditResultReturn.
     *
     * @param mcc
     */
    public void setMcc(String mcc) {
        this.mcc = mcc;
    }


    /**
     * Gets the mccNo value for this CreditResultReturn.
     *
     * @return mccNo
     */
    public String getMccNo() {
        return mccNo;
    }


    /**
     * Sets the mccNo value for this CreditResultReturn.
     *
     * @param mccNo
     */
    public void setMccNo(String mccNo) {
        this.mccNo = mccNo;
    }


    /**
     * Gets the midAverageA value for this CreditResultReturn.
     *
     * @return midAverageA
     */
    public String getMidAverageA() {
        return midAverageA;
    }


    /**
     * Sets the midAverageA value for this CreditResultReturn.
     *
     * @param midAverageA
     */
    public void setMidAverageA(String midAverageA) {
        this.midAverageA = midAverageA;
    }


    /**
     * Gets the midBusiMonths value for this CreditResultReturn.
     *
     * @return midBusiMonths
     */
    public String getMidBusiMonths() {
        return midBusiMonths;
    }


    /**
     * Sets the midBusiMonths value for this CreditResultReturn.
     *
     * @param midBusiMonths
     */
    public void setMidBusiMonths(String midBusiMonths) {
        this.midBusiMonths = midBusiMonths;
    }


    /**
     * Gets the midContMonths value for this CreditResultReturn.
     *
     * @return midContMonths
     */
    public String getMidContMonths() {
        return midContMonths;
    }


    /**
     * Sets the midContMonths value for this CreditResultReturn.
     *
     * @param midContMonths
     */
    public void setMidContMonths(String midContMonths) {
        this.midContMonths = midContMonths;
    }


    /**
     * Gets the midCredit value for this CreditResultReturn.
     *
     * @return midCredit
     */
    public String getMidCredit() {
        return midCredit;
    }


    /**
     * Sets the midCredit value for this CreditResultReturn.
     *
     * @param midCredit
     */
    public void setMidCredit(String midCredit) {
        this.midCredit = midCredit;
    }


    /**
     * Gets the midFrequencyF value for this CreditResultReturn.
     *
     * @return midFrequencyF
     */
    public String getMidFrequencyF() {
        return midFrequencyF;
    }


    /**
     * Sets the midFrequencyF value for this CreditResultReturn.
     *
     * @param midFrequencyF
     */
    public void setMidFrequencyF(String midFrequencyF) {
        this.midFrequencyF = midFrequencyF;
    }


    /**
     * Gets the midGrowthG value for this CreditResultReturn.
     *
     * @return midGrowthG
     */
    public String getMidGrowthG() {
        return midGrowthG;
    }


    /**
     * Sets the midGrowthG value for this CreditResultReturn.
     *
     * @param midGrowthG
     */
    public void setMidGrowthG(String midGrowthG) {
        this.midGrowthG = midGrowthG;
    }


    /**
     * Gets the midLastMonVolumeL value for this CreditResultReturn.
     *
     * @return midLastMonVolumeL
     */
    public String getMidLastMonVolumeL() {
        return midLastMonVolumeL;
    }


    /**
     * Sets the midLastMonVolumeL value for this CreditResultReturn.
     *
     * @param midLastMonVolumeL
     */
    public void setMidLastMonVolumeL(String midLastMonVolumeL) {
        this.midLastMonVolumeL = midLastMonVolumeL;
    }


    /**
     * Gets the midMonetaryM value for this CreditResultReturn.
     *
     * @return midMonetaryM
     */
    public String getMidMonetaryM() {
        return midMonetaryM;
    }


    /**
     * Sets the midMonetaryM value for this CreditResultReturn.
     *
     * @param midMonetaryM
     */
    public void setMidMonetaryM(String midMonetaryM) {
        this.midMonetaryM = midMonetaryM;
    }


    /**
     * Gets the midPerMonVolumeP value for this CreditResultReturn.
     *
     * @return midPerMonVolumeP
     */
    public String getMidPerMonVolumeP() {
        return midPerMonVolumeP;
    }


    /**
     * Sets the midPerMonVolumeP value for this CreditResultReturn.
     *
     * @param midPerMonVolumeP
     */
    public void setMidPerMonVolumeP(String midPerMonVolumeP) {
        this.midPerMonVolumeP = midPerMonVolumeP;
    }


    /**
     * Gets the midRecencyR value for this CreditResultReturn.
     *
     * @return midRecencyR
     */
    public String getMidRecencyR() {
        return midRecencyR;
    }


    /**
     * Sets the midRecencyR value for this CreditResultReturn.
     *
     * @param midRecencyR
     */
    public void setMidRecencyR(String midRecencyR) {
        this.midRecencyR = midRecencyR;
    }


    /**
     * Gets the midRecencyRdays value for this CreditResultReturn.
     *
     * @return midRecencyRdays
     */
    public String getMidRecencyRdays() {
        return midRecencyRdays;
    }


    /**
     * Sets the midRecencyRdays value for this CreditResultReturn.
     *
     * @param midRecencyRdays
     */
    public void setMidRecencyRdays(String midRecencyRdays) {
        this.midRecencyRdays = midRecencyRdays;
    }


    /**
     * Gets the midStableS value for this CreditResultReturn.
     *
     * @return midStableS
     */
    public String getMidStableS() {
        return midStableS;
    }


    /**
     * Sets the midStableS value for this CreditResultReturn.
     *
     * @param midStableS
     */
    public void setMidStableS(String midStableS) {
        this.midStableS = midStableS;
    }


    /**
     * Gets the midStandardCredit value for this CreditResultReturn.
     *
     * @return midStandardCredit
     */
    public String getMidStandardCredit() {
        return midStandardCredit;
    }


    /**
     * Sets the midStandardCredit value for this CreditResultReturn.
     *
     * @param midStandardCredit
     */
    public void setMidStandardCredit(String midStandardCredit) {
        this.midStandardCredit = midStandardCredit;
    }


    /**
     * Gets the midStandardJointCredit value for this CreditResultReturn.
     *
     * @return midStandardJointCredit
     */
    public String getMidStandardJointCredit() {
        return midStandardJointCredit;
    }


    /**
     * Sets the midStandardJointCredit value for this CreditResultReturn.
     *
     * @param midStandardJointCredit
     */
    public void setMidStandardJointCredit(String midStandardJointCredit) {
        this.midStandardJointCredit = midStandardJointCredit;
    }


    /**
     * Gets the mmmsList value for this CreditResultReturn.
     *
     * @return mmmsList
     */
    public com.cardvalue.cas.service.impl.MerMidMonthStatistic[] getMmmsList() {
        return mmmsList;
    }


    /**
     * Sets the mmmsList value for this CreditResultReturn.
     *
     * @param mmmsList
     */
    public void setMmmsList(com.cardvalue.cas.service.impl.MerMidMonthStatistic[] mmmsList) {
        this.mmmsList = mmmsList;
    }

    public com.cardvalue.cas.service.impl.MerMidMonthStatistic getMmmsList(int i) {
        return this.mmmsList[i];
    }

    public void setMmmsList(int i, com.cardvalue.cas.service.impl.MerMidMonthStatistic _value) {
        this.mmmsList[i] = _value;
    }


    /**
     * Gets the mpcList value for this CreditResultReturn.
     *
     * @return mpcList
     */
    public com.cardvalue.cas.service.impl.MerProductCredit[] getMpcList() {
        return mpcList;
    }


    /**
     * Sets the mpcList value for this CreditResultReturn.
     *
     * @param mpcList
     */
    public void setMpcList(com.cardvalue.cas.service.impl.MerProductCredit[] mpcList) {
        this.mpcList = mpcList;
    }

    public com.cardvalue.cas.service.impl.MerProductCredit getMpcList(int i) {
        return this.mpcList[i];
    }

    public void setMpcList(int i, com.cardvalue.cas.service.impl.MerProductCredit _value) {
        this.mpcList[i] = _value;
    }


    /**
     * Gets the noLineReason value for this CreditResultReturn.
     *
     * @return noLineReason
     */
    public String getNoLineReason() {
        return noLineReason;
    }


    /**
     * Sets the noLineReason value for this CreditResultReturn.
     *
     * @param noLineReason
     */
    public void setNoLineReason(String noLineReason) {
        this.noLineReason = noLineReason;
    }


    /**
     * Gets the passFlag value for this CreditResultReturn.
     *
     * @return passFlag
     */
    public String getPassFlag() {
        return passFlag;
    }


    /**
     * Sets the passFlag value for this CreditResultReturn.
     *
     * @param passFlag
     */
    public void setPassFlag(String passFlag) {
        this.passFlag = passFlag;
    }


    /**
     * Gets the plannedAmt value for this CreditResultReturn.
     *
     * @return plannedAmt
     */
    public String getPlannedAmt() {
        return plannedAmt;
    }


    /**
     * Sets the plannedAmt value for this CreditResultReturn.
     *
     * @param plannedAmt
     */
    public void setPlannedAmt(String plannedAmt) {
        this.plannedAmt = plannedAmt;
    }


    /**
     * Gets the plannedDays value for this CreditResultReturn.
     *
     * @return plannedDays
     */
    public String getPlannedDays() {
        return plannedDays;
    }


    /**
     * Sets the plannedDays value for this CreditResultReturn.
     *
     * @param plannedDays
     */
    public void setPlannedDays(String plannedDays) {
        this.plannedDays = plannedDays;
    }


    /**
     * Gets the posCredit value for this CreditResultReturn.
     *
     * @return posCredit
     */
    public String getPosCredit() {
        return posCredit;
    }


    /**
     * Sets the posCredit value for this CreditResultReturn.
     *
     * @param posCredit
     */
    public void setPosCredit(String posCredit) {
        this.posCredit = posCredit;
    }


    /**
     * Gets the posDays value for this CreditResultReturn.
     *
     * @return posDays
     */
    public String getPosDays() {
        return posDays;
    }


    /**
     * Sets the posDays value for this CreditResultReturn.
     *
     * @param posDays
     */
    public void setPosDays(String posDays) {
        this.posDays = posDays;
    }


    /**
     * Gets the province value for this CreditResultReturn.
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }


    /**
     * Sets the province value for this CreditResultReturn.
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }


    /**
     * Gets the resCode value for this CreditResultReturn.
     *
     * @return resCode
     */
    public String getResCode() {
        return resCode;
    }


    /**
     * Sets the resCode value for this CreditResultReturn.
     *
     * @param resCode
     */
    public void setResCode(String resCode) {
        this.resCode = resCode;
    }


    /**
     * Gets the resMsg value for this CreditResultReturn.
     *
     * @return resMsg
     */
    public String getResMsg() {
        return resMsg;
    }


    /**
     * Sets the resMsg value for this CreditResultReturn.
     *
     * @param resMsg
     */
    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }


    /**
     * Gets the status value for this CreditResultReturn.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CreditResultReturn.
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Gets the statusInfo value for this CreditResultReturn.
     *
     * @return statusInfo
     */
    public String getStatusInfo() {
        return statusInfo;
    }


    /**
     * Sets the statusInfo value for this CreditResultReturn.
     *
     * @param statusInfo
     */
    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }


    /**
     * Gets the totalCredit value for this CreditResultReturn.
     *
     * @return totalCredit
     */
    public String getTotalCredit() {
        return totalCredit;
    }


    /**
     * Sets the totalCredit value for this CreditResultReturn.
     *
     * @param totalCredit
     */
    public void setTotalCredit(String totalCredit) {
        this.totalCredit = totalCredit;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CreditResultReturn)) return false;
        CreditResultReturn other = (CreditResultReturn) obj;
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
            ((this.cmrList==null && other.getCmrList()==null) ||
             (this.cmrList!=null &&
              java.util.Arrays.equals(this.cmrList, other.getCmrList()))) &&
            ((this.cor==null && other.getCor()==null) ||
             (this.cor!=null &&
              this.cor.equals(other.getCor()))) &&
            ((this.corpName==null && other.getCorpName()==null) ||
             (this.corpName!=null &&
              this.corpName.equals(other.getCorpName()))) &&
            ((this.creditEffDate==null && other.getCreditEffDate()==null) ||
             (this.creditEffDate!=null &&
              this.creditEffDate.equals(other.getCreditEffDate()))) &&
            ((this.creditExpDate==null && other.getCreditExpDate()==null) ||
             (this.creditExpDate!=null &&
              this.creditExpDate.equals(other.getCreditExpDate()))) &&
            ((this.creditRating==null && other.getCreditRating()==null) ||
             (this.creditRating!=null &&
              this.creditRating.equals(other.getCreditRating()))) &&
            ((this.creditScore==null && other.getCreditScore()==null) ||
             (this.creditScore!=null &&
              this.creditScore.equals(other.getCreditScore()))) &&
            ((this.ddCredit==null && other.getDdCredit()==null) ||
             (this.ddCredit!=null &&
              this.ddCredit.equals(other.getDdCredit()))) &&
            ((this.ddDays==null && other.getDdDays()==null) ||
             (this.ddDays!=null &&
              this.ddDays.equals(other.getDdDays()))) &&
            ((this.feeRate==null && other.getFeeRate()==null) ||
             (this.feeRate!=null &&
              this.feeRate.equals(other.getFeeRate()))) &&
            ((this.instantCredit==null && other.getInstantCredit()==null) ||
             (this.instantCredit!=null &&
              this.instantCredit.equals(other.getInstantCredit()))) &&
            ((this.instantDays==null && other.getInstantDays()==null) ||
             (this.instantDays!=null &&
              this.instantDays.equals(other.getInstantDays()))) &&
            ((this.mcc==null && other.getMcc()==null) ||
             (this.mcc!=null &&
              this.mcc.equals(other.getMcc()))) &&
            ((this.mccNo==null && other.getMccNo()==null) ||
             (this.mccNo!=null &&
              this.mccNo.equals(other.getMccNo()))) &&
            ((this.midAverageA==null && other.getMidAverageA()==null) ||
             (this.midAverageA!=null &&
              this.midAverageA.equals(other.getMidAverageA()))) &&
            ((this.midBusiMonths==null && other.getMidBusiMonths()==null) ||
             (this.midBusiMonths!=null &&
              this.midBusiMonths.equals(other.getMidBusiMonths()))) &&
            ((this.midContMonths==null && other.getMidContMonths()==null) ||
             (this.midContMonths!=null &&
              this.midContMonths.equals(other.getMidContMonths()))) &&
            ((this.midCredit==null && other.getMidCredit()==null) ||
             (this.midCredit!=null &&
              this.midCredit.equals(other.getMidCredit()))) &&
            ((this.midFrequencyF==null && other.getMidFrequencyF()==null) ||
             (this.midFrequencyF!=null &&
              this.midFrequencyF.equals(other.getMidFrequencyF()))) &&
            ((this.midGrowthG==null && other.getMidGrowthG()==null) ||
             (this.midGrowthG!=null &&
              this.midGrowthG.equals(other.getMidGrowthG()))) &&
            ((this.midLastMonVolumeL==null && other.getMidLastMonVolumeL()==null) ||
             (this.midLastMonVolumeL!=null &&
              this.midLastMonVolumeL.equals(other.getMidLastMonVolumeL()))) &&
            ((this.midMonetaryM==null && other.getMidMonetaryM()==null) ||
             (this.midMonetaryM!=null &&
              this.midMonetaryM.equals(other.getMidMonetaryM()))) &&
            ((this.midPerMonVolumeP==null && other.getMidPerMonVolumeP()==null) ||
             (this.midPerMonVolumeP!=null &&
              this.midPerMonVolumeP.equals(other.getMidPerMonVolumeP()))) &&
            ((this.midRecencyR==null && other.getMidRecencyR()==null) ||
             (this.midRecencyR!=null &&
              this.midRecencyR.equals(other.getMidRecencyR()))) &&
            ((this.midRecencyRdays==null && other.getMidRecencyRdays()==null) ||
             (this.midRecencyRdays!=null &&
              this.midRecencyRdays.equals(other.getMidRecencyRdays()))) &&
            ((this.midStableS==null && other.getMidStableS()==null) ||
             (this.midStableS!=null &&
              this.midStableS.equals(other.getMidStableS()))) &&
            ((this.midStandardCredit==null && other.getMidStandardCredit()==null) ||
             (this.midStandardCredit!=null &&
              this.midStandardCredit.equals(other.getMidStandardCredit()))) &&
            ((this.midStandardJointCredit==null && other.getMidStandardJointCredit()==null) ||
             (this.midStandardJointCredit!=null &&
              this.midStandardJointCredit.equals(other.getMidStandardJointCredit()))) &&
            ((this.mmmsList==null && other.getMmmsList()==null) ||
             (this.mmmsList!=null &&
              java.util.Arrays.equals(this.mmmsList, other.getMmmsList()))) &&
            ((this.mpcList==null && other.getMpcList()==null) ||
             (this.mpcList!=null &&
              java.util.Arrays.equals(this.mpcList, other.getMpcList()))) &&
            ((this.noLineReason==null && other.getNoLineReason()==null) ||
             (this.noLineReason!=null &&
              this.noLineReason.equals(other.getNoLineReason()))) &&
            ((this.passFlag==null && other.getPassFlag()==null) ||
             (this.passFlag!=null &&
              this.passFlag.equals(other.getPassFlag()))) &&
            ((this.plannedAmt==null && other.getPlannedAmt()==null) ||
             (this.plannedAmt!=null &&
              this.plannedAmt.equals(other.getPlannedAmt()))) &&
            ((this.plannedDays==null && other.getPlannedDays()==null) ||
             (this.plannedDays!=null &&
              this.plannedDays.equals(other.getPlannedDays()))) &&
            ((this.posCredit==null && other.getPosCredit()==null) ||
             (this.posCredit!=null &&
              this.posCredit.equals(other.getPosCredit()))) &&
            ((this.posDays==null && other.getPosDays()==null) ||
             (this.posDays!=null &&
              this.posDays.equals(other.getPosDays()))) &&
            ((this.province==null && other.getProvince()==null) ||
             (this.province!=null &&
              this.province.equals(other.getProvince()))) &&
            ((this.resCode==null && other.getResCode()==null) ||
             (this.resCode!=null &&
              this.resCode.equals(other.getResCode()))) &&
            ((this.resMsg==null && other.getResMsg()==null) ||
             (this.resMsg!=null &&
              this.resMsg.equals(other.getResMsg()))) &&
            ((this.status==null && other.getStatus()==null) ||
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.statusInfo==null && other.getStatusInfo()==null) ||
             (this.statusInfo!=null &&
              this.statusInfo.equals(other.getStatusInfo()))) &&
            ((this.totalCredit==null && other.getTotalCredit()==null) ||
             (this.totalCredit!=null &&
              this.totalCredit.equals(other.getTotalCredit())));
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
        if (getCmrList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCmrList());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCmrList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCor() != null) {
            _hashCode += getCor().hashCode();
        }
        if (getCorpName() != null) {
            _hashCode += getCorpName().hashCode();
        }
        if (getCreditEffDate() != null) {
            _hashCode += getCreditEffDate().hashCode();
        }
        if (getCreditExpDate() != null) {
            _hashCode += getCreditExpDate().hashCode();
        }
        if (getCreditRating() != null) {
            _hashCode += getCreditRating().hashCode();
        }
        if (getCreditScore() != null) {
            _hashCode += getCreditScore().hashCode();
        }
        if (getDdCredit() != null) {
            _hashCode += getDdCredit().hashCode();
        }
        if (getDdDays() != null) {
            _hashCode += getDdDays().hashCode();
        }
        if (getFeeRate() != null) {
            _hashCode += getFeeRate().hashCode();
        }
        if (getInstantCredit() != null) {
            _hashCode += getInstantCredit().hashCode();
        }
        if (getInstantDays() != null) {
            _hashCode += getInstantDays().hashCode();
        }
        if (getMcc() != null) {
            _hashCode += getMcc().hashCode();
        }
        if (getMccNo() != null) {
            _hashCode += getMccNo().hashCode();
        }
        if (getMidAverageA() != null) {
            _hashCode += getMidAverageA().hashCode();
        }
        if (getMidBusiMonths() != null) {
            _hashCode += getMidBusiMonths().hashCode();
        }
        if (getMidContMonths() != null) {
            _hashCode += getMidContMonths().hashCode();
        }
        if (getMidCredit() != null) {
            _hashCode += getMidCredit().hashCode();
        }
        if (getMidFrequencyF() != null) {
            _hashCode += getMidFrequencyF().hashCode();
        }
        if (getMidGrowthG() != null) {
            _hashCode += getMidGrowthG().hashCode();
        }
        if (getMidLastMonVolumeL() != null) {
            _hashCode += getMidLastMonVolumeL().hashCode();
        }
        if (getMidMonetaryM() != null) {
            _hashCode += getMidMonetaryM().hashCode();
        }
        if (getMidPerMonVolumeP() != null) {
            _hashCode += getMidPerMonVolumeP().hashCode();
        }
        if (getMidRecencyR() != null) {
            _hashCode += getMidRecencyR().hashCode();
        }
        if (getMidRecencyRdays() != null) {
            _hashCode += getMidRecencyRdays().hashCode();
        }
        if (getMidStableS() != null) {
            _hashCode += getMidStableS().hashCode();
        }
        if (getMidStandardCredit() != null) {
            _hashCode += getMidStandardCredit().hashCode();
        }
        if (getMidStandardJointCredit() != null) {
            _hashCode += getMidStandardJointCredit().hashCode();
        }
        if (getMmmsList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMmmsList());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getMmmsList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMpcList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMpcList());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getMpcList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNoLineReason() != null) {
            _hashCode += getNoLineReason().hashCode();
        }
        if (getPassFlag() != null) {
            _hashCode += getPassFlag().hashCode();
        }
        if (getPlannedAmt() != null) {
            _hashCode += getPlannedAmt().hashCode();
        }
        if (getPlannedDays() != null) {
            _hashCode += getPlannedDays().hashCode();
        }
        if (getPosCredit() != null) {
            _hashCode += getPosCredit().hashCode();
        }
        if (getPosDays() != null) {
            _hashCode += getPosDays().hashCode();
        }
        if (getProvince() != null) {
            _hashCode += getProvince().hashCode();
        }
        if (getResCode() != null) {
            _hashCode += getResCode().hashCode();
        }
        if (getResMsg() != null) {
            _hashCode += getResMsg().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatusInfo() != null) {
            _hashCode += getStatusInfo().hashCode();
        }
        if (getTotalCredit() != null) {
            _hashCode += getTotalCredit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreditResultReturn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "creditResultReturn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "channel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cmrList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cmrList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "creditMidResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "creditOpenResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditEffDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditEffDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditExpDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditExpDate"));
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
        elemField.setFieldName("creditScore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ddCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ddCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ddDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ddDays"));
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
        elemField.setFieldName("instantCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instantCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instantDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instantDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mcc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mcc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mccNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mccNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midAverageA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midAverageA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midBusiMonths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midBusiMonths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midContMonths");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midContMonths"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midFrequencyF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midFrequencyF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midGrowthG");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midGrowthG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midLastMonVolumeL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midLastMonVolumeL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midMonetaryM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midMonetaryM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midPerMonVolumeP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midPerMonVolumeP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midRecencyR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midRecencyR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midRecencyRdays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midRecencyRdays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midStableS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midStableS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midStandardCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midStandardCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midStandardJointCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "midStandardJointCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mmmsList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mmmsList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "merMidMonthStatistic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mpcList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mpcList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "merProductCredit"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noLineReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noLineReason"));
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
        elemField.setFieldName("plannedAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plannedAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plannedDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plannedDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posCredit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("province");
        elemField.setXmlName(new javax.xml.namespace.QName("", "province"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resMsg"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCredit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalCredit"));
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
