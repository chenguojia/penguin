/**
 * MerchantServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cardvalue.cas.service.impl;

public class MerchantServiceLocator extends org.apache.axis.client.Service implements com.cardvalue.cas.service.impl.MerchantService {

    public MerchantServiceLocator() {
    }


    public MerchantServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MerchantServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MerchantServiceImplPort
    private String MerchantServiceImplPort_address = "http://192.168.0.249:80/CreditAnalysisSystem/MerchantService";

    public String getMerchantServiceImplPortAddress() {
        return MerchantServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String MerchantServiceImplPortWSDDServiceName = "MerchantServiceImplPort";

    public String getMerchantServiceImplPortWSDDServiceName() {
        return MerchantServiceImplPortWSDDServiceName;
    }

    public void setMerchantServiceImplPortWSDDServiceName(String name) {
        MerchantServiceImplPortWSDDServiceName = name;
    }

    public com.cardvalue.cas.service.impl.MerchantServiceImpl getMerchantServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MerchantServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMerchantServiceImplPort(endpoint);
    }

    public com.cardvalue.cas.service.impl.MerchantServiceImpl getMerchantServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cardvalue.cas.service.impl.MerchantServiceImplPortBindingStub _stub = new com.cardvalue.cas.service.impl.MerchantServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getMerchantServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMerchantServiceImplPortEndpointAddress(String address) {
        MerchantServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cardvalue.cas.service.impl.MerchantServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cardvalue.cas.service.impl.MerchantServiceImplPortBindingStub _stub = new com.cardvalue.cas.service.impl.MerchantServiceImplPortBindingStub(new java.net.URL(MerchantServiceImplPort_address), this);
                _stub.setPortName(getMerchantServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("MerchantServiceImplPort".equals(inputPortName)) {
            return getMerchantServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "MerchantService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.cas.cardvalue.com/", "MerchantServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("MerchantServiceImplPort".equals(portName)) {
            setMerchantServiceImplPortEndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
