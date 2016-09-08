package edu.virginia.shanti.om.bridge.service;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import edu.virginia.shanti.om.bridge.domain.LocalContextType;
import edu.virginia.shanti.om.bridge.domain.LocalGroupType;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.PermissionSet;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;

/**
 * Utility class to load default RemoteServer entities at startup if they don't
 * exist. The entities are currently hardcoded and that'll probably suffice for
 * development.
 * 
 * @author ys2n
 * 
 */
@Service
@RooToString
public class DbLoaderListener implements
		ApplicationListener<ContextRefreshedEvent> {

	Log log = LogFactory.getLog(DbLoaderListener.class);

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		// Whenever the Context is Refreshed, check to see if the data needs to
		// be initialized.

		// it would be nice develop a file-based serialization of the data (xml
		// or json), so that its a bit more flexible. Using a spring bean xml
		// file
		// might work.

		RemoteServer remoteServer = new RemoteServer();
		remoteServer.setImplementationName("confluenceConnector");
		remoteServer.setRemoteName("shanti-wiki");
		remoteServer.setRemoteUrl("https://shanti-app-qa01.shanti.virginia.edu");

		assureRemoteServer(remoteServer);

		remoteServer = new RemoteServer();
		remoteServer.setImplementationName("nowCommentConnector");
		remoteServer.setRemoteName("nowCommentStaging");
		remoteServer.setRemoteUrl("http://staging.nowcomment.com");

		assureRemoteServer(remoteServer);
		
		
		remoteServer = new RemoteServer();
		remoteServer.setImplementationName("nowCommentConnector");
		remoteServer.setRemoteName("nowComment");
		remoteServer.setRemoteUrl("http://nowcomment.com");
		
		assureRemoteServer(remoteServer);

		List<PermissionMap> collaborationResults = PermissionMap.findPermissionMapsByLocalContextType(
				LocalContextType.COLLABORATION).getResultList();
		
		PermissionMap collaborationPermissionMap;
		if (collaborationResults.isEmpty()) {
			collaborationPermissionMap = new PermissionMap();
		} else {
			collaborationPermissionMap = collaborationResults.get(0);
			Set<PermissionSet> permissionSets = collaborationPermissionMap.getPermissionSets();
			for (PermissionSet permissionSet : permissionSets) {
				permissionSet.remove();
			}
			collaborationPermissionMap.getPermissionSets().clear();
		}
		
		populateCollaborationPermissions(collaborationPermissionMap);

		List<PermissionMap> courseResults = PermissionMap.findPermissionMapsByLocalContextType(
				LocalContextType.COURSE).getResultList();
		
		PermissionMap coursePermissionMap;
		if (courseResults.isEmpty()) {
			coursePermissionMap = new PermissionMap();
		} else {
			coursePermissionMap = courseResults.get(0);
			Set<PermissionSet> permissionSets = coursePermissionMap.getPermissionSets();
			for (PermissionSet permissionSet : permissionSets) {
				permissionSet.remove();
			}
			coursePermissionMap.getPermissionSets().clear();
		}	
		
		populateCoursePermissions(coursePermissionMap);

	}

	private void populateCoursePermissions(PermissionMap pm2) {
		ConfluencePermissionSet p5 = new ConfluencePermissionSet();
		p5.setGroupName("Instructor");
		p5.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p5.setComment(true);
		p5.setCreateAttachment(true);
		p5.setEditBlog(true);
		p5.setEditSpace(true);
		p5.setExportPage(true);
		p5.setExportSpace(true);
		p5.setRemoveAttachment(true);
		p5.setRemoveBlog(true);
		p5.setRemoveComment(true);
		p5.setRemoveMail(true);
		p5.setRemovePage(true);
		p5.setSetPagePermissions(true);
		p5.setSetSpacePermissions(true);
		p5.setViewSpace(true);
		p5.persist();

		ConfluencePermissionSet p6 = new ConfluencePermissionSet();
		p6.setGroupName("Secondary Instructor");
		p6.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p6.setComment(true);
		p6.setCreateAttachment(true);
		p6.setEditBlog(true);
		p6.setEditSpace(true);
		p6.setExportPage(true);
		p6.setExportSpace(true);
		p6.setRemoveAttachment(true);
		p6.setRemoveBlog(true);
		p6.setRemoveComment(true);
		p6.setRemoveMail(true);
		p6.setRemovePage(true);
		p6.setSetPagePermissions(true);
		p6.setSetSpacePermissions(true);
		p6.setViewSpace(true);
		p6.persist();


		ConfluencePermissionSet p7 = new ConfluencePermissionSet();
		p7.setGroupName("Teaching Assistant");
		p7.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p7.setComment(true);
		p7.setCreateAttachment(true);
		p7.setEditBlog(true);
		p7.setEditSpace(true);
		p7.setExportPage(true);
		p7.setExportSpace(false);
		p7.setRemoveAttachment(false);
		p7.setRemoveBlog(false);
		p7.setRemoveComment(false);
		p7.setRemoveMail(false);
		p7.setRemovePage(true);
		p7.setSetPagePermissions(true);
		p7.setSetSpacePermissions(false);
		p7.setViewSpace(true);
		p7.persist();

		ConfluencePermissionSet p8 = new ConfluencePermissionSet();
		p8.setGroupName("Former Student");
		p8.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p8.setComment(false);
		p8.setCreateAttachment(false);
		p8.setEditBlog(false);
		p8.setEditSpace(false);
		p8.setExportPage(false);
		p8.setExportSpace(false);
		p8.setRemoveAttachment(false);
		p8.setRemoveBlog(false);
		p8.setRemoveComment(false);
		p8.setRemoveMail(false);
		p8.setRemovePage(false);
		p8.setSetPagePermissions(false);
		p8.setSetSpacePermissions(false);
		p8.setViewSpace(true);
		p8.persist();

		ConfluencePermissionSet p4 = new ConfluencePermissionSet();
		p4.setGroupName("Student");
		p4.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p4.setComment(true);
		p4.setCreateAttachment(true);
		p4.setEditBlog(true);
		p4.setEditSpace(true);
		p4.setExportPage(false);
		p4.setExportSpace(false);
		p4.setRemoveAttachment(false);
		p4.setRemoveBlog(false);
		p4.setRemoveComment(false);
		p4.setRemoveMail(false);
		p4.setRemovePage(false);
		p4.setSetPagePermissions(true);
		p4.setSetSpacePermissions(false);
		p4.setViewSpace(true);
		p4.persist();

		pm2.setLocalContextMask("*");
		pm2.setLocalContextType(LocalContextType.COURSE);
		pm2.setName("generic course");
		pm2.setService("shanti-wiki");
		pm2.addPermissionSet(p4);
		pm2.addPermissionSet(p5);
		pm2.addPermissionSet(p6);
		pm2.addPermissionSet(p7);
		pm2.addPermissionSet(p8);
		pm2.persist();
		
		log.info("populated " + pm2);
	}

	private void populateCollaborationPermissions(PermissionMap pm) {
		ConfluencePermissionSet p0 = new ConfluencePermissionSet();
		p0.setGroupName("Owner");
		p0.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p0.setComment(true);
		p0.setCreateAttachment(true);
		p0.setEditBlog(true);
		p0.setEditSpace(true);
		p0.setExportPage(true);
		p0.setExportSpace(true);
		p0.setRemoveAttachment(true);
		p0.setRemoveBlog(true);
		p0.setRemoveComment(true);
		p0.setRemoveMail(true);
		p0.setRemovePage(true);
		p0.setSetPagePermissions(true);
		p0.setSetSpacePermissions(true);
		p0.setViewSpace(true);
		p0.persist();

		ConfluencePermissionSet p1 = new ConfluencePermissionSet();
		p1.setGroupName("Administrator");
		p1.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p1.setComment(true);
		p1.setCreateAttachment(true);
		p1.setEditBlog(true);
		p1.setEditSpace(true);
		p1.setExportPage(true);
		p1.setExportSpace(true);
		p1.setRemoveAttachment(true);
		p1.setRemoveBlog(true);
		p1.setRemoveComment(true);
		p1.setRemoveMail(true);
		p1.setRemovePage(true);
		p1.setSetPagePermissions(true);
		p1.setSetSpacePermissions(true);
		p1.setViewSpace(true);
		p1.persist();

		ConfluencePermissionSet p2 = new ConfluencePermissionSet();
		p2.setGroupName("Member");
		p2.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p2.setComment(true);
		p2.setCreateAttachment(true);
		p2.setEditBlog(true);
		p2.setEditSpace(true);
		p2.setExportPage(true);
		p2.setExportSpace(true);
		p2.setRemoveAttachment(false);
		p2.setRemoveBlog(false);
		p2.setRemoveComment(false);
		p2.setRemoveMail(false);
		p2.setRemovePage(false);
		p2.setSetPagePermissions(true);
		p2.setSetSpacePermissions(false);
		p2.setViewSpace(true);
		p2.persist();

		ConfluencePermissionSet p3 = new ConfluencePermissionSet();
		p3.setGroupName("Observer");
		p3.setLocalGroupType(LocalGroupType.SAKAIROLE);
		p3.setComment(false);
		p3.setCreateAttachment(false);
		p3.setEditBlog(false);
		p3.setEditSpace(false);
		p3.setExportPage(false);
		p3.setExportSpace(false);
		p3.setRemoveAttachment(false);
		p3.setRemoveBlog(false);
		p3.setRemoveComment(false);
		p3.setRemoveMail(false);
		p3.setRemovePage(false);
		p3.setSetPagePermissions(false);
		p3.setSetSpacePermissions(false);
		p3.setViewSpace(true);
		p3.persist();

		// PermissionMap pm = new PermissionMap();
		pm.setLocalContextMask("*");
		pm.setLocalContextType(LocalContextType.COLLABORATION);
		pm.setName("generic collaboration");
		pm.setService("shanti-wiki");
		pm.addPermissionSet(p0);
		pm.addPermissionSet(p1);
		pm.addPermissionSet(p2);
		pm.addPermissionSet(p3);
		pm.persist();
		
		log.info("populated " + pm);
	}

	private void assureRemoteServer(RemoteServer remoteServer) {
		if (RemoteServer
				.findRemoteServersByRemoteName(remoteServer.getRemoteName())
				.getResultList().size() == 0) {
			log.info("Loading " + remoteServer.getRemoteName() + ": "
					+ remoteServer);
			remoteServer.persist();
			remoteServer.flush();
			log.info("Loaded " + remoteServer);
		}
	}
}
