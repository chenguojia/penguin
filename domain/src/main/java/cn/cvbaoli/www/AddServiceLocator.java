/**
 * AddServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cvbaoli.www;

public class AddServiceLocator extends org.apache.axis.client.Service implements AddService {

    public AddServiceLocator() {
    }


    public AddServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AddServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AddServicePort
    private String AddServicePort_address = "http://192.168.7.238/ws_server.php";

    public String getAddServicePortAddress() {
        return AddServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private String AddServicePortWSDDServiceName = "AddServicePort";

    public String getAddServicePortWSDDServiceName() {
        return AddServicePortWSDDServiceName;
    }

    public void setAddServicePortWSDDServiceName(String name) {
        AddServicePortWSDDServiceName = name;
    }

    public cn.cvbaoli.www.AddServicePortType getAddServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AddServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAddServicePort(endpoint);
    }

    public cn.cvbaoli.www.AddServicePortType getAddServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.cvbaoli.www.AddServiceBindingStub _stub = new cn.cvbaoli.www.AddServiceBindingStub(portAddress, this);
            _stub.setPortName(getAddServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAddServicePortEndpointAddress(String address) {
        AddServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.cvbaoli.www.AddServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.cvbaoli.www.AddServiceBindingStub _stub = new cn.cvbaoli.www.AddServiceBindingStub(new java.net.URL(AddServicePort_address), this);
                _stub.setPortName(getAddServicePortWSDDServiceName());
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
        if ("AddServicePort".equals(inputPortName)) {
            return getAddServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("www.cvbaoli.cn", "AddService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("www.cvbaoli.cn", "AddServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("AddServicePort".equals(portName)) {
            setAddServicePortEndpointAddress(address);
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
