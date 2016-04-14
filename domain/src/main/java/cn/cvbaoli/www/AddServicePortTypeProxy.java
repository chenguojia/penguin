package cn.cvbaoli.www;

public class AddServicePortTypeProxy implements AddServicePortType {
  private String _endpoint = null;
  private AddServicePortType addServicePortType = null;
  
  public AddServicePortTypeProxy() {
    _initAddServicePortTypeProxy();
  }
  
  public AddServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAddServicePortTypeProxy();
  }
  
  private void _initAddServicePortTypeProxy() {
    try {
      addServicePortType = (new AddServiceLocator()).getAddServicePort();
      if (addServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)addServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)addServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (addServicePortType != null)
      ((javax.xml.rpc.Stub)addServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public AddServicePortType getAddServicePortType() {
    if (addServicePortType == null)
      _initAddServicePortTypeProxy();
    return addServicePortType;
  }
  
  public ArrResponse updateApply(SoapRequestAuths auths, cn.cvbaoli.www.SoapUpdateApplyRequestMain main) throws java.rmi.RemoteException{
    if (addServicePortType == null)
      _initAddServicePortTypeProxy();
    return addServicePortType.updateApply(auths, main);
  }
  
  public ArrResponse updateCreditFilePassStatus(SoapRequestAuths auths, cn.cvbaoli.www.SoapUpdateCreditFilePassStatusRequestMain main) throws java.rmi.RemoteException{
    if (addServicePortType == null)
      _initAddServicePortTypeProxy();
    return addServicePortType.updateCreditFilePassStatus(auths, main);
  }
  
  public ArrResponse getUser(SoapRequestAuths auths, SoapGetUserRequestMain main) throws java.rmi.RemoteException{
    if (addServicePortType == null)
      _initAddServicePortTypeProxy();
    return addServicePortType.getUser(auths, main);
  }
  
  public ArrResponse syncUser(SoapRequestAuths auths, cn.cvbaoli.www.SoapSyncUserRequestMain main) throws java.rmi.RemoteException{
    if (addServicePortType == null)
      _initAddServicePortTypeProxy();
    return addServicePortType.syncUser(auths, main);
  }
  
  public ArrResponse syncUserMerchant(SoapRequestAuths auths, cn.cvbaoli.www.SoapSyncUserMerchantRequestMain main) throws java.rmi.RemoteException{
    if (addServicePortType == null)
      _initAddServicePortTypeProxy();
    return addServicePortType.syncUserMerchant(auths, main);
  }
  
  public ArrResponse creditResult(SoapRequestAuths auths, cn.cvbaoli.www.SoapCreditResultRequestMain main) throws java.rmi.RemoteException{
    if (addServicePortType == null)
      _initAddServicePortTypeProxy();
    return addServicePortType.creditResult(auths, main);
  }
  
  
}