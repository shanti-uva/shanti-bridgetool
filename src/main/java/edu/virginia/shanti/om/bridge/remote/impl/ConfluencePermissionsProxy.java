package edu.virginia.shanti.om.bridge.remote.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.KeyGenerator;
import com.googlecode.ehcache.annotations.PartialCacheKey;

import edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapService;
import edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteException;

@Service
@Component
public class ConfluencePermissionsProxy {
	
	private Log log = LogFactory.getLog(ConfluencePermissionsProxy.class);

	@Cacheable(cacheName = "confluenceSpacePermissions", keyGenerator=@KeyGenerator(name="StringCacheKeyGenerator"))
	public String[] getPermissions(ConfluenceSoapService conf, String sess,
			@PartialCacheKey String user, @PartialCacheKey String key) throws InvalidSessionException, RemoteException, java.rmi.RemoteException {

				
				log.debug("REMOTE CALL to getPermission using " + sess + ", " + user + " and " + key);
				return conf.getPermissionsForUser(sess,
						key,user);
				
	}

}
