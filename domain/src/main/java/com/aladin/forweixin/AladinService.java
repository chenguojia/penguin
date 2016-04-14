/**
 * AladinService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aladin.forweixin;

public interface AladinService extends javax.xml.rpc.Service {
    public String getAladinPortAddress();

    public com.aladin.forweixin.AladinDelegate getAladinPort() throws javax.xml.rpc.ServiceException;

    public com.aladin.forweixin.AladinDelegate getAladinPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
