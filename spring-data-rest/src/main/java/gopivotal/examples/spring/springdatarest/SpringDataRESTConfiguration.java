/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdatarest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * A simple configuration class for the web application.
 * 
 * @author cdelashmutt
 *
 */
@Configuration
public class SpringDataRESTConfiguration
extends RepositoryRestMvcConfiguration
{
	/* (non-Javadoc)
	 * @see org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration#configureJacksonObjectMapper(com.fasterxml.jackson.databind.ObjectMapper)
	 */
	@Override
	protected void configureJacksonObjectMapper(ObjectMapper objectMapper)
	{
		// TODO Auto-generated method stub
		super.configureJacksonObjectMapper(objectMapper);
		objectMapper.registerModule(new JodaModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
}
