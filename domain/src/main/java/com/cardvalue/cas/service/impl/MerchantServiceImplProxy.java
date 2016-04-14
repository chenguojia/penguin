package com.cardvalue.cas.service.impl;

public class MerchantServiceImplProxy implements com.cardvalue.cas.service.impl.MerchantServiceImpl {
  private String _endpoint = null;
  private com.cardvalue.cas.service.impl.MerchantServiceImpl merchantServiceImpl = null;

  public MerchantServiceImplProxy() {
    _initMerchantServiceImplProxy();
  }

  public MerchantServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initMerchantServiceImplProxy();
  }

  private void _initMerchantServiceImplProxy() {
    try {
      merchantServiceImpl = (new com.cardvalue.cas.service.impl.MerchantServiceLocator()).getMerchantServiceImplPort();
      if (merchantServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)merchantServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)merchantServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }

    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }

  public String getEndpoint() {
    return _endpoint;
  }

  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (merchantServiceImpl != null)
      ((javax.xml.rpc.Stub)merchantServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

  }

  public com.cardvalue.cas.service.impl.MerchantServiceImpl getMerchantServiceImpl() {
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl;
  }

  public com.cardvalue.cas.service.impl.AddMidReturn addMidRequest(String applicantId, String midList) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.addMidRequest(applicantId, midList);
  }

  public com.cardvalue.cas.service.impl.CreateApplicantReturn createApplicant(String channel, String creditWay, String corpName, Boolean checkName, String province, String plannedAmt, String plannedDays) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.createApplicant(channel, creditWay, corpName, checkName, province, plannedAmt, plannedDays);
  }

  public com.cardvalue.cas.service.impl.UpdateApplicantReturn updateApplicant(String applicantId, String channel, String creditWay, String corpName, Boolean checkName, String province, String plannedAmt, String plannedDays) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.updateApplicant(applicantId, channel, creditWay, corpName, checkName, province, plannedAmt, plannedDays);
  }

  public com.cardvalue.cas.service.impl.DeleteMidReturn deleteMidRequest(String applicantId, String midList) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.deleteMidRequest(applicantId, midList);
  }

  public com.cardvalue.cas.service.impl.AddOpenReturn addOpenRequest(String applicantId, String businessType, String cityName, String businessAreaClass, String addressType, String staffNumClass, String educationClass, String maritalStatus, String hasChildren, String localResidence, String mccCode, String storeProp, String regName, String bizName, String bizScope) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.addOpenRequest(applicantId, businessType, cityName, businessAreaClass, addressType, staffNumClass, educationClass, maritalStatus, hasChildren, localResidence, mccCode, storeProp, regName, bizName, bizScope);
  }

  public com.cardvalue.cas.service.impl.DeleteOpenReturn deleteOpenRequest(String applicantId) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.deleteOpenRequest(applicantId);
  }

  public com.cardvalue.cas.service.impl.DeleteBusinessReturn deleteBusiness(String businessType, String businessId) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.deleteBusiness(businessType, businessId);
  }

  public com.cardvalue.cas.service.impl.PosCreditCalculateReturn posCreditCalculate(String mcc_code, String pro_code, String recencyR, String averageA, String frequencyF, String monetaryM, String perMonVolumeP, String lastMonVolumeL, String stableS, String growthG, String monthOfBiz, String contMonth) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.posCreditCalculate(mcc_code, pro_code, recencyR, averageA, frequencyF, monetaryM, perMonVolumeP, lastMonVolumeL, stableS, growthG, monthOfBiz, contMonth);
  }

  public com.cardvalue.cas.service.impl.CreditResultReturn creditResult(String applicantId) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.creditResult(applicantId);
  }
  
  
}