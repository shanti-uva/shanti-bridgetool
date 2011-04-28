package edu.virginia.shanti.om.bridge.web;

import java.util.List;

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
public class ApplicationConversionServiceFactoryBean extends
		FormattingConversionServiceFactoryBean {

	Logger logger = LoggerFactory
			.getLogger(ApplicationConversionServiceFactoryBean.class);

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
		registry.addConverter(getRemoteContextEncoder());
		registry.addConverter(getRemoteContextConverter());
		registry.addConverter(getRemoteChoiceToContextConverter());
	}

	Converter<RemoteContext, String> getRemoteContextConverter() {
		return new Converter<RemoteContext, String>() {

			@Override
			public String convert(RemoteContext source) {
				logger.warn("XXXXXX: Converting to string: " + source);
				return new JSONSerializer().serialize(source
						.getRemoteContextChoice());
			}

		};
	}

	Converter<String, RemoteContext> getRemoteContextEncoder() {
		return new Converter<String, RemoteContext>() {

			@Override
			public RemoteContext convert(String source) {
				logger.warn("XXXXXXX: Converting from String: " + source);
				RemoteContextChoice choice = new JSONDeserializer<RemoteContextChoice>()
						.deserialize((String) source);
				RemoteContext rc = new RemoteContext();
				rc.populate(choice);
				return rc;
			}

		};
	}

	Converter<RemoteContextChoice, RemoteContext> getRemoteChoiceToContextConverter() {
		return new Converter<RemoteContextChoice, RemoteContext>() {
			@Override
			public RemoteContext convert(RemoteContextChoice rcc) {
				logger.warn("XXXXXXX: Converting from Choice: " + rcc);
				List<RemoteContext> list = RemoteContext
						.findRemoteContextsByRemoteNameAndContextId(
								rcc.getRemoteName(), rcc.getContextId())
						.getResultList();

				RemoteContext rc;
				if (list.size() == 1) {
					rc = list.get(0);

				} else if (list.size() == 2) {
					rc = new RemoteContext();
					rc.populate(rcc);
				} else {
					throw new RuntimeException(
							"Too many RemoteContexts returned for remoteName="
									+ rcc.getRemoteName() + " contextId="
									+ rcc.getContextId());
				}
				return rc;

			}
		};
	}
}