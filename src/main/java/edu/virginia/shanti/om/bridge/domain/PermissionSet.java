package edu.virginia.shanti.om.bridge.domain;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.Enumerated;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import edu.virginia.shanti.om.bridge.remote.RemotePermissions;

@RooJavaBean
@RooToString
@RooEntity
@RooSerializable
public class PermissionSet implements RemotePermissions {
	
	private static final long serialVersionUID = -2157472313077361757L;

	private String groupName;

	@Enumerated
    private LocalGroupType localGroupType;
	
	
	// Base implementation to access bean properties
	
	protected static final Map<String, String> propMap = new HashMap<String, String>();

	static {
		PropertyDescriptor[] propertyDescriptors = BeanUtils
				.getPropertyDescriptors(ConfluencePermissionSet.class);
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor propertyDescriptor = propertyDescriptors[i];

			if (propertyDescriptor.getPropertyType().isAssignableFrom(
					Boolean.class)) {
				String propName = propertyDescriptor.getName();
				String capName = propName.toUpperCase();

				System.err.println(propName + "=" + capName);

				propMap.put(capName, propName);
			}
		}
	}
	
	
	@Override
	public boolean hasPermission(String perm) {

		String propName = propMap.get(perm.toUpperCase());

		// short-circuit if property doesn't exist (or isn't a Boolean)
		if (propName == null) {
			// should this be an error?
			return false;
		}

		try {

			Boolean value = (Boolean) PropertyUtils.getProperty(this, propName);
			if (value == null) {
				return false;
			} else {
				return value.booleanValue();
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String[] getPermissions() {

		Set<String> values = new HashSet<String>(propMap.size());

		Set<String> perms = propMap.keySet();
		for (Iterator<String> iterator = perms.iterator(); iterator.hasNext();) {
			String perm = iterator.next();

			if (hasPermission(perm)) {
				values.add(perm);
			}

		}

		return values.toArray(new String[values.size()]);

	}

	@Override
	public String[] possiblePermissions() {
		return propMap.keySet().toArray(new String[propMap.size()]);
	}

	@Override
	public void setPermission(String perm, boolean bool) {

		String propName = propMap.get(perm);
		
		if (propName == null) {
			throw new RuntimeException(new NoSuchMethodException("No property of name " + perm + " found in bean. Must be one of " + Arrays.toString(propMap.values().toArray())));
		}
		
		try {
			PropertyUtils.setSimpleProperty(this, propName, bool);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unable to set property! " + e.getMessage(), e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException("Unable to set property! " + e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("Unable to set property! " + e.getMessage(), e);
		}
	}	
}
