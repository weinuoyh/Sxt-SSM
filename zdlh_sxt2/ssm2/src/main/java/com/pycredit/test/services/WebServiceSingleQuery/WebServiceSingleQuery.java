/**
 * WebServiceSingleQuery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.pycredit.test.services.WebServiceSingleQuery;

public interface WebServiceSingleQuery extends java.rmi.Remote {
    public String testConnection() throws java.rmi.RemoteException;
    public String queryReport(String userID, String password, String queryCondition) throws java.rmi.RemoteException;
    public String queryReport(String userID, String password, String queryCondition, String outputStyle) throws java.rmi.RemoteException;
    public String batOfflineDownload(String userID, String password, String batNo) throws java.rmi.RemoteException;
    public String batOfflineDownload(String userID, String password, String batNo, String outputStyle) throws java.rmi.RemoteException;
    public String download(String userID, String password, String batNo) throws java.rmi.RemoteException;
    public String download(String userID, String password, String batNo, String outputStyle) throws java.rmi.RemoteException;
    public String changePassword(String userID, String oldPasswowd, String newPassword) throws java.rmi.RemoteException;
    public String confirmCallback(String userID, String password, String batNo, String accessMethod) throws java.rmi.RemoteException;
    public String telAndNameCheck(String userID, String password, String queryCondition) throws java.rmi.RemoteException;
}
