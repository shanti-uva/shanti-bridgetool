/**
 * SakaiScript_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

public interface SakaiScript_PortType extends java.rmi.Remote {
    public java.lang.String removeUser(java.lang.String sessionid, java.lang.String eid) throws java.rmi.RemoteException;
    public java.lang.String getUserId(java.lang.String sessionid, java.lang.String eid) throws java.rmi.RemoteException;
    public java.lang.String getUserType(java.lang.String sessionid, java.lang.String userid) throws java.rmi.RemoteException;
    public java.lang.String getSiteTitle(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public java.lang.String removeAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid) throws java.rmi.RemoteException;
    public java.lang.String getSiteDescription(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public java.lang.String getUserDisplayName(java.lang.String sessionid) throws java.rmi.RemoteException;
    public java.lang.String getUserDisplayName(java.lang.String sessionid, java.lang.String userid) throws java.rmi.RemoteException;
    public java.lang.String getUserEmail(java.lang.String sessionid) throws java.rmi.RemoteException;
    public java.lang.String getUserEmail(java.lang.String sessionid, java.lang.String userid) throws java.rmi.RemoteException;
    public boolean checkForUser(java.lang.String sessionid, java.lang.String eid) throws java.rmi.RemoteException;
    public java.lang.String removeSite(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public java.lang.String getSiteSkin(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public boolean addMemberToGroup(java.lang.String sessionid, java.lang.String siteid, java.lang.String groupid, java.lang.String userid) throws java.rmi.RemoteException;
    public java.lang.String addNewUser(java.lang.String sessionid, java.lang.String eid, java.lang.String firstname, java.lang.String lastname, java.lang.String email, java.lang.String type, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String addNewUser(java.lang.String sessionid, java.lang.String id, java.lang.String eid, java.lang.String firstname, java.lang.String lastname, java.lang.String email, java.lang.String type, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getSiteProperty(java.lang.String sessionid, java.lang.String siteid, java.lang.String propname) throws java.rmi.RemoteException;
    public java.lang.String addNewSite(java.lang.String sessionid, java.lang.String siteid, java.lang.String title, java.lang.String description, java.lang.String shortdesc, java.lang.String iconurl, java.lang.String infourl, boolean joinable, java.lang.String joinerrole, boolean published, boolean publicview, java.lang.String skin, java.lang.String type) throws java.rmi.RemoteException;
    public java.lang.String checkSession(java.lang.String sessionid) throws java.rmi.RemoteException;
    public java.lang.String changeUserInfo(java.lang.String sessionid, java.lang.String eid, java.lang.String firstname, java.lang.String lastname, java.lang.String email, java.lang.String type, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String changeUserName(java.lang.String sessionid, java.lang.String eid, java.lang.String firstname, java.lang.String lastname) throws java.rmi.RemoteException;
    public java.lang.String changeUserEmail(java.lang.String sessionid, java.lang.String eid, java.lang.String email) throws java.rmi.RemoteException;
    public java.lang.String changeUserType(java.lang.String sessionid, java.lang.String eid, java.lang.String type) throws java.rmi.RemoteException;
    public java.lang.String changeUserPassword(java.lang.String sessionid, java.lang.String eid, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String addGroupToSite(java.lang.String sessionid, java.lang.String siteid, java.lang.String grouptitle, java.lang.String groupdesc) throws java.rmi.RemoteException;
    public java.lang.String getGroupsInSite(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public java.lang.String addNewAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid) throws java.rmi.RemoteException;
    public java.lang.String addNewRoleToAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid, java.lang.String description) throws java.rmi.RemoteException;
    public java.lang.String removeAllRolesFromAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid) throws java.rmi.RemoteException;
    public java.lang.String removeRoleFromAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid) throws java.rmi.RemoteException;
    public java.lang.String allowFunctionForRole(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid, java.lang.String functionname) throws java.rmi.RemoteException;
    public java.lang.String disallowAllFunctionsForRole(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid) throws java.rmi.RemoteException;
    public java.lang.String disallowFunctionForRole(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid, java.lang.String functionname) throws java.rmi.RemoteException;
    public java.lang.String setRoleDescription(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid, java.lang.String description) throws java.rmi.RemoteException;
    public java.lang.String addMemberToAuthzGroupWithRole(java.lang.String sessionid, java.lang.String eid, java.lang.String authzgroupid, java.lang.String roleid) throws java.rmi.RemoteException;
    public java.lang.String removeMemberFromAuthzGroup(java.lang.String sessionid, java.lang.String eid, java.lang.String authzgroupid) throws java.rmi.RemoteException;
    public java.lang.String removeAllMembersFromAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid) throws java.rmi.RemoteException;
    public java.lang.String setRoleForAuthzGroupMaintenance(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid) throws java.rmi.RemoteException;
    public java.lang.String addMemberToSiteWithRole(java.lang.String sessionid, java.lang.String siteid, java.lang.String eid, java.lang.String roleid) throws java.rmi.RemoteException;
    public java.lang.String copySite(java.lang.String sessionid, java.lang.String siteidtocopy, java.lang.String newsiteid, java.lang.String title, java.lang.String description, java.lang.String shortdesc, java.lang.String iconurl, java.lang.String infourl, boolean joinable, java.lang.String joinerrole, boolean published, boolean publicview, java.lang.String skin, java.lang.String type) throws java.rmi.RemoteException;
    public java.lang.String addNewPageToSite(java.lang.String sessionid, java.lang.String siteid, java.lang.String pagetitle, int pagelayout) throws java.rmi.RemoteException;
    public java.lang.String addNewPageToSite(java.lang.String sessionid, java.lang.String siteid, java.lang.String pagetitle, int pagelayout, int position, boolean popup) throws java.rmi.RemoteException;
    public java.lang.String removePageFromSite(java.lang.String sessionid, java.lang.String siteid, java.lang.String pagetitle) throws java.rmi.RemoteException;
    public java.lang.String addNewToolToPage(java.lang.String sessionid, java.lang.String siteid, java.lang.String pagetitle, java.lang.String tooltitle, java.lang.String toolid, java.lang.String layouthints) throws java.rmi.RemoteException;
    public java.lang.String addConfigPropertyToTool(java.lang.String sessionid, java.lang.String siteid, java.lang.String pagetitle, java.lang.String tooltitle, java.lang.String propname, java.lang.String propvalue) throws java.rmi.RemoteException;
    public boolean checkForSite(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public boolean checkForMemberInAuthzGroupWithRole(java.lang.String sessionid, java.lang.String eid, java.lang.String authzgroupid, java.lang.String role) throws java.rmi.RemoteException;
    public java.lang.String getSitesUserCanAccess(java.lang.String sessionid) throws java.rmi.RemoteException;
    public boolean isSiteJoinable(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public java.lang.String changeSiteTitle(java.lang.String sessionid, java.lang.String siteid, java.lang.String title) throws java.rmi.RemoteException;
    public java.lang.String changeSiteSkin(java.lang.String sessionid, java.lang.String siteid, java.lang.String skin) throws java.rmi.RemoteException;
    public java.lang.String changeSiteJoinable(java.lang.String sessionid, java.lang.String siteid, boolean joinable, java.lang.String joinerrole, boolean publicview) throws java.rmi.RemoteException;
    public java.lang.String changeSiteIconUrl(java.lang.String sessionid, java.lang.String siteid, java.lang.String iconurl) throws java.rmi.RemoteException;
    public java.lang.String changeSiteDescription(java.lang.String sessionid, java.lang.String siteid, java.lang.String description) throws java.rmi.RemoteException;
    public java.lang.String setSiteProperty(java.lang.String sessionid, java.lang.String siteid, java.lang.String propname, java.lang.String propvalue) throws java.rmi.RemoteException;
    public java.lang.String setSitePropertyAlt(java.lang.String sessionid, java.lang.String secret, java.lang.String siteid, java.lang.String propname, java.lang.String propvalue) throws java.rmi.RemoteException;
    public java.lang.String removeSiteProperty(java.lang.String sessionid, java.lang.String siteid, java.lang.String propname) throws java.rmi.RemoteException;
    public boolean checkForRoleInAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String roleid) throws java.rmi.RemoteException;
    public java.lang.String searchForUsers(java.lang.String sessionid, java.lang.String criteria, int first, int last) throws java.rmi.RemoteException;
    public boolean checkForAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid) throws java.rmi.RemoteException;
    public java.lang.String removeMemberFromSite(java.lang.String sessionid, java.lang.String siteid, java.lang.String eid) throws java.rmi.RemoteException;
    public boolean checkForUserInAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String eid) throws java.rmi.RemoteException;
    public java.lang.String getUsersInAuthzGroupWithRole(java.lang.String sessionid, java.lang.String authzgroupid, java.lang.String authzgrouproles) throws java.rmi.RemoteException;
    public java.lang.String getUsersInAuthzGroup(java.lang.String sessionid, java.lang.String authzgroupid) throws java.rmi.RemoteException;
    public java.lang.String copyCalendarEvents(java.lang.String sessionid, java.lang.String sourceSiteId, java.lang.String targetSiteId) throws java.rmi.RemoteException;
    public java.lang.String addNewToolToAllWorkspaces(java.lang.String sessionid, java.lang.String toolid, java.lang.String pagetitle, java.lang.String tooltitle, int pagelayout, int position, boolean popup) throws java.rmi.RemoteException;
    public java.lang.String copyRole(java.lang.String sessionid, java.lang.String authzgroupid1, java.lang.String authzgroupid2, java.lang.String roleid, java.lang.String description, boolean removeBeforeSync) throws java.rmi.RemoteException;
    public java.lang.String copyRole(java.lang.String sessionid, java.lang.String authzgroupid1, java.lang.String authzgroupid2, java.lang.String roleid, java.lang.String description) throws java.rmi.RemoteException;
    public java.lang.String getAllUsers(java.lang.String sessionid) throws java.rmi.RemoteException;
    public java.lang.String getSessionForUser(java.lang.String sessionid, java.lang.String userid) throws java.rmi.RemoteException;
    public java.lang.String getPagesAndToolsForSite(java.lang.String sessionid, java.lang.String siteid) throws java.rmi.RemoteException;
    public java.lang.String getPagesAndToolsForSite(java.lang.String sessionid, java.lang.String userid, java.lang.String siteid) throws java.rmi.RemoteException;
}
