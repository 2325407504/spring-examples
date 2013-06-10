/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.jpa;

import org.springframework.data.domain.AuditorAware;

/**
 * A simple bean to retrieve the current user based on a system property.
 * 
 * This is a completely ineffective means to determine user identity in real
 * application. It is used for example purposes, only.
 * 
 * Refer to the Spring Data JPA reference for an example to collect user
 * credentials in a more reliable manner.
 * 
 * @author cdelashmutt
 */
public class SystemPropertyAuditorAware
	implements AuditorAware<String>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
	 */
	@Override
	public String getCurrentAuditor()
	{
		return System.getProperty("user.name");
	}

}
