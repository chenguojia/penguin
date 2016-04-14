/**
 * AddServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public class AddServiceBindingStub extends org.apache.axis.client.Stub implements AddServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateApply");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "auths"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths"), SoapRequestAuths.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "main"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapUpdateApplyRequestMain"), cn.cvbaoli.www.SoapUpdateApplyRequestMain.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.cvbaoli.cn", "arrResponse"));
        oper.setReturnClass(ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateCreditFilePassStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "auths"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths"), SoapRequestAuths.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "main"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapUpdateCreditFilePassStatusRequestMain"), cn.cvbaoli.www.SoapUpdateCreditFilePassStatusRequestMain.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.cvbaoli.cn", "arrResponse"));
        oper.setReturnClass(ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "auths"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths"), SoapRequestAuths.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "main"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapGetUserRequestMain"), cn.cvbaoli.www.SoapGetUserRequestMain.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.cvbaoli.cn", "arrResponse"));
        oper.setReturnClass(ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("syncUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "auths"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths"), SoapRequestAuths.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "main"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapSyncUserRequestMain"), cn.cvbaoli.www.SoapSyncUserRequestMain.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.cvbaoli.cn", "arrResponse"));
        oper.setReturnClass(ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("syncUserMerchant");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "auths"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths"), SoapRequestAuths.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "main"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapSyncUserMerchantRequestMain"), cn.cvbaoli.www.SoapSyncUserMerchantRequestMain.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.cvbaoli.cn", "arrResponse"));
        oper.setReturnClass(ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("creditResult");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "auths"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths"), SoapRequestAuths.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "main"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("www.cvbaoli.cn", "soapCreditResultRequestMain"), cn.cvbaoli.www.SoapCreditResultRequestMain.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("www.cvbaoli.cn", "arrResponse"));
        oper.setReturnClass(ArrResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "parameters"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

    }

    public AddServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AddServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AddServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "arrResponse");
            cachedSerQNames.add(qName);
            cls = ArrResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "soapCreditResultRequestMain");
            cachedSerQNames.add(qName);
            cls = cn.cvbaoli.www.SoapCreditResultRequestMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "soapGetUserRequestMain");
            cachedSerQNames.add(qName);
            cls = cn.cvbaoli.www.SoapGetUserRequestMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "soapRequestAuths");
            cachedSerQNames.add(qName);
            cls = SoapRequestAuths.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "soapSyncUserMerchantRequestMain");
            cachedSerQNames.add(qName);
            cls = cn.cvbaoli.www.SoapSyncUserMerchantRequestMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "soapSyncUserRequestMain");
            cachedSerQNames.add(qName);
            cls = cn.cvbaoli.www.SoapSyncUserRequestMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "soapUpdateApplyRequestMain");
            cachedSerQNames.add(qName);
            cls = cn.cvbaoli.www.SoapUpdateApplyRequestMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("www.cvbaoli.cn", "soapUpdateCreditFilePassStatusRequestMain");
            cachedSerQNames.add(qName);
            cls = cn.cvbaoli.www.SoapUpdateCreditFilePassStatusRequestMain.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public ArrResponse updateApply(SoapRequestAuths auths, cn.cvbaoli.www.SoapUpdateApplyRequestMain main) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.7.238/ws_server.php/updateApply");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.cvbaoli.cn", "updateApply"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {auths, main});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ArrResponse) _resp;
            } catch (Exception _exception) {
                return (ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ArrResponse updateCreditFilePassStatus(SoapRequestAuths auths, cn.cvbaoli.www.SoapUpdateCreditFilePassStatusRequestMain main) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.7.238/ws_server.php/updateCreditFilePassStatus");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.cvbaoli.cn", "updateCreditFilePassStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {auths, main});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ArrResponse) _resp;
            } catch (Exception _exception) {
                return (ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ArrResponse getUser(SoapRequestAuths auths, cn.cvbaoli.www.SoapGetUserRequestMain main) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.7.238/ws_server.php/getUser");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.cvbaoli.cn", "getUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {auths, main});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ArrResponse) _resp;
            } catch (Exception _exception) {
                return (ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ArrResponse syncUser(SoapRequestAuths auths, cn.cvbaoli.www.SoapSyncUserRequestMain main) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.7.238/ws_server.php/syncUser");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.cvbaoli.cn", "syncUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {auths, main});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ArrResponse) _resp;
            } catch (Exception _exception) {
                return (ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ArrResponse syncUserMerchant(SoapRequestAuths auths, cn.cvbaoli.www.SoapSyncUserMerchantRequestMain main) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.7.238/ws_server.php/syncUserMerchant");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.cvbaoli.cn", "syncUserMerchant"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {auths, main});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ArrResponse) _resp;
            } catch (Exception _exception) {
                return (ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ArrResponse creditResult(SoapRequestAuths auths, cn.cvbaoli.www.SoapCreditResultRequestMain main) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://192.168.7.238/ws_server.php/creditResult");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("www.cvbaoli.cn", "creditResult"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {auths, main});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ArrResponse) _resp;
            } catch (Exception _exception) {
                return (ArrResponse) org.apache.axis.utils.JavaUtils.convert(_resp, ArrResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
