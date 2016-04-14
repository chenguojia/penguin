/**
 * MerchantServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public interface MerchantServiceImpl extends java.rmi.Remote {
    public com.cardvalue.cas.service.impl.AddMidReturn addMidRequest(String applicantId, String midList) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.CreateApplicantReturn createApplicant(String channel, String creditWay, String corpName, Boolean checkName, String province, String plannedAmt, String plannedDays) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.UpdateApplicantReturn updateApplicant(String applicantId, String channel, String creditWay, String corpName, Boolean checkName, String province, String plannedAmt, String plannedDays) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.DeleteMidReturn deleteMidRequest(String applicantId, String midList) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.AddOpenReturn addOpenRequest(String applicantId, String businessType, String cityName, String businessAreaClass, String addressType, String staffNumClass, String educationClass, String maritalStatus, String hasChildren, String localResidence, String mccCode, String storeProp, String regName, String bizName, String bizScope) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.DeleteOpenReturn deleteOpenRequest(String applicantId) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.DeleteBusinessReturn deleteBusiness(String businessType, String businessId) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.PosCreditCalculateReturn posCreditCalculate(String mcc_code, String pro_code, String recencyR, String averageA, String frequencyF, String monetaryM, String perMonVolumeP, String lastMonVolumeL, String stableS, String growthG, String monthOfBiz, String contMonth) throws java.rmi.RemoteException;
    public com.cardvalue.cas.service.impl.CreditResultReturn creditResult(String applicantId) throws java.rmi.RemoteException;
}
