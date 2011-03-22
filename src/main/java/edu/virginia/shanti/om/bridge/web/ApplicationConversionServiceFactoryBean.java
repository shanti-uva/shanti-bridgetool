package edu.virginia.shanti.om.bridge.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
        
/**
 * A central place to register application Converters and Formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	Logger logger = LoggerFactory.getLogger(ApplicationConversionServiceFactoryBean.class);	
	
	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters		
		registry.addConverter(getRemoteContextEncoder());
		registry.addConverter(getRemoteContextConverter());
	}
	
    Converter<RemoteContext, String> getRemoteContextConverter() {
        return new Converter<RemoteContext, String>() {

			@Override
			public String convert(RemoteContext source) {
				return new JSONSerializer().serialize(source.getRemoteContextChoice());
			}
			
        };
    }
    
   Converter<String, RemoteContext> getRemoteContextEncoder() {
        return new Converter<String, RemoteContext>() {

			@Override
			public RemoteContext convert(String source) {
				logger.warn("XXXXXXX: Converting: " + source);
				RemoteContextChoice choice = new JSONDeserializer<RemoteContextChoice>().deserialize( (String) source );
				RemoteContext rc = new RemoteContext();
				rc.populate(choice);
				return rc;		
			}
			
        };
   }
    
    
    
}
