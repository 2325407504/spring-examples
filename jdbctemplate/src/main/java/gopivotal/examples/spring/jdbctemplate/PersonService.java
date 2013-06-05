/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.jdbctemplate;

import java.util.List;

/**
 * A simple service interface to get people
 * 
 * @author cdelashmutt
 */
public interface PersonService
{

	Person getPerson(int id);
	
	List<Person> getPeople(boolean active);
}
