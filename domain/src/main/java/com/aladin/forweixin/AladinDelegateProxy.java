package com.aladin.forweixin;

public class AladinDelegateProxy implements com.aladin.forweixin.AladinDelegate {
  private String _endpoint = null;
  private com.aladin.forweixin.AladinDelegate aladinDelegate = null;
  
  public AladinDelegateProxy() {
    _initAladinDelegateProxy();
  }
  
  public AladinDelegateProxy(String endpoint) {
    _endpoint = endpoint;
    _initAladinDelegateProxy();
  }
  
  private void _initAladinDelegateProxy() {
    try {
      aladinDelegate = (new com.aladin.forweixin.AladinServiceLocator()).getAladinPort();
      if (aladinDelegate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aladinDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aladinDelegate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aladinDelegate != null)
      ((javax.xml.rpc.Stub)aladinDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.aladin.forweixin.AladinDelegate getAladinDelegate() {
    if (aladinDelegate == null)
      _initAladinDelegateProxy();
    return aladinDelegate;
  }
  
  public String addWenxinDataToAladin(com.aladin.forweixin.WeixinData arg0) throws java.rmi.RemoteException{
    if (aladinDelegate == null)
      _initAladinDelegateProxy();
    return aladinDelegate.addWenxinDataToAladin(arg0);
  }
  
  
}