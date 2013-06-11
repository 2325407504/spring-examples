/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdatarest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * TODO: Describe SpringDataRESTInitializer
 * 
 * @author cdelashmutt
 * 
 */
public class SpringDataRESTInitializer
	implements WebApplicationInitializer
{

	@Override
	public void onStartup(ServletContext servletContext)
		throws ServletException
	{
		XmlWebApplicationContext rootCtx = new XmlWebApplicationContext();
		rootCtx.setConfigLocation("classpath:META-INF/spring/*-context.xml");
		servletContext.addListener(new ContextLoaderListener(rootCtx));

		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(SpringDataRESTConfiguration.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);
		ServletRegistration.Dynamic reg = servletContext.addServlet(
				"rest-exporter", dispatcherServlet);
		reg.setLoadOnStartup(1);
		reg.addMapping("/*");
	}

}