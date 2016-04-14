/**
 * AladinServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladin.forweixin;

public class AladinServiceLocator extends org.apache.axis.client.Service implements com.aladin.forweixin.AladinService {

    public AladinServiceLocator() {
    }


    public AladinServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AladinServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AladinPort
    private String AladinPort_address = "http://192.168.0.165:8880/AladinForWeixin/AladinPort";

    public String getAladinPortAddress() {
        return AladinPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String AladinPortWSDDServiceName = "AladinPort";

    public String getAladinPortWSDDServiceName() {
        return AladinPortWSDDServiceName;
    }

    public void setAladinPortWSDDServiceName(String name) {
        AladinPortWSDDServiceName = name;
    }

    public com.aladin.forweixin.AladinDelegate getAladinPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AladinPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAladinPort(endpoint);
    }

    public com.aladin.forweixin.AladinDelegate getAladinPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aladin.forweixin.AladinPortBindingStub _stub = new com.aladin.forweixin.AladinPortBindingStub(portAddress, this);
            _stub.setPortName(getAladinPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAladinPortEndpointAddress(String address) {
        AladinPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.aladin.forweixin.AladinDelegate.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aladin.forweixin.AladinPortBindingStub _stub = new com.aladin.forweixin.AladinPortBindingStub(new java.net.URL(AladinPort_address), this);
                _stub.setPortName(getAladinPortWSDDServiceName());
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
        if ("AladinPort".equals(inputPortName)) {
            return getAladinPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://forweixin.aladin.com/", "AladinService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://forweixin.aladin.com/", "AladinPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("AladinPort".equals(portName)) {
            setAladinPortEndpointAddress(address);
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
