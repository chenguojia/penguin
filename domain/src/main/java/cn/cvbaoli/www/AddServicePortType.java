/**
 * AddServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public interface AddServicePortType extends java.rmi.Remote {
    public ArrResponse updateApply(SoapRequestAuths auths, cn.cvbaoli.www.SoapUpdateApplyRequestMain main) throws java.rmi.RemoteException;
    public ArrResponse updateCreditFilePassStatus(SoapRequestAuths auths, cn.cvbaoli.www.SoapUpdateCreditFilePassStatusRequestMain main) throws java.rmi.RemoteException;
    public ArrResponse getUser(SoapRequestAuths auths, cn.cvbaoli.www.SoapGetUserRequestMain main) throws java.rmi.RemoteException;
    public ArrResponse syncUser(SoapRequestAuths auths, cn.cvbaoli.www.SoapSyncUserRequestMain main) throws java.rmi.RemoteException;
    public ArrResponse syncUserMerchant(SoapRequestAuths auths, cn.cvbaoli.www.SoapSyncUserMerchantRequestMain main) throws java.rmi.RemoteException;
    public ArrResponse creditResult(SoapRequestAuths auths, cn.cvbaoli.www.SoapCreditResultRequestMain main) throws java.rmi.RemoteException;
}
