// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.PermissionSet;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import java.lang.String;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(new BridgeConverter());
        registry.addConverter(new ConfluencePermissionSetConverter());
        registry.addConverter(new PermissionMapConverter());
        registry.addConverter(new PermissionSetConverter());
        registry.addConverter(new RemoteContextConverter());
        registry.addConverter(new RemoteServerConverter());
        registry.addConverter(new SiteAliasConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
    static class edu.virginia.shanti.om.bridge.web.ApplicationConversionServiceFactoryBean.BridgeConverter implements Converter<Bridge, String>  {
        public String convert(Bridge bridge) {
        return new StringBuilder().append(bridge.getRemoteName()).append(" ").append(bridge.getLocalContext()).append(" ").append(bridge.getLocalSubContext()).toString();
        }
        
    }
    
    static class edu.virginia.shanti.om.bridge.web.ApplicationConversionServiceFactoryBean.ConfluencePermissionSetConverter implements org.springframework.core.convert.converter.Converter<edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet, java.lang.String>  {
        public String convert(ConfluencePermissionSet confluencePermissionSet) {
        return new StringBuilder().append(confluencePermissionSet.getGroupName()).toString();
        }
        
    }
    
    static class edu.virginia.shanti.om.bridge.web.ApplicationConversionServiceFactoryBean.PermissionMapConverter implements org.springframework.core.convert.converter.Converter<edu.virginia.shanti.om.bridge.domain.PermissionMap, java.lang.String>  {
        public String convert(PermissionMap permissionMap) {
        return new StringBuilder().append(permissionMap.getName()).append(" ").append(permissionMap.getLocalContextMask()).append(" ").append(permissionMap.getService()).toString();
        }
        
    }
    
    static class edu.virginia.shanti.om.bridge.web.ApplicationConversionServiceFactoryBean.PermissionSetConverter implements org.springframework.core.convert.converter.Converter<edu.virginia.shanti.om.bridge.domain.PermissionSet, java.lang.String>  {
        public String convert(PermissionSet permissionSet) {
        return new StringBuilder().append(permissionSet.getGroupName()).toString();
        }
        
    }
    
    static class edu.virginia.shanti.om.bridge.web.ApplicationConversionServiceFactoryBean.RemoteContextConverter implements org.springframework.core.convert.converter.Converter<edu.virginia.shanti.om.bridge.domain.RemoteContext, java.lang.String>  {
        public String convert(RemoteContext remoteContext) {
        return new StringBuilder().append(remoteContext.getContextLabel()).append(" ").append(remoteContext.getContextId()).append(" ").append(remoteContext.getUrl()).append(" ").append(remoteContext.getRemoteName()).toString();
        }
        
    }
    
    static class edu.virginia.shanti.om.bridge.web.ApplicationConversionServiceFactoryBean.RemoteServerConverter implements org.springframework.core.convert.converter.Converter<edu.virginia.shanti.om.bridge.domain.RemoteServer, java.lang.String>  {
        public String convert(RemoteServer remoteServer) {
        return new StringBuilder().append(remoteServer.getImplementationName()).append(" ").append(remoteServer.getRemoteUrl()).append(" ").append(remoteServer.getRemoteName()).toString();
        }
        
    }
    
    static class edu.virginia.shanti.om.bridge.web.ApplicationConversionServiceFactoryBean.SiteAliasConverter implements org.springframework.core.convert.converter.Converter<edu.virginia.shanti.om.bridge.domain.SiteAlias, java.lang.String>  {
        public String convert(SiteAlias siteAlias) {
        return new StringBuilder().append(siteAlias.getAlias()).append(" ").append(siteAlias.getSiteId()).toString();
        }
        
    }
    
}
