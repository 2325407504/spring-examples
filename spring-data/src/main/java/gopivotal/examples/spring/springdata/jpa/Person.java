/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A simple human.
 * 
 * @author cdelashmutt
 */
@Entity
public class Person
{
	@Id
	int id;
	boolean active;
	String firstName;
	String lastName;

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	/**
	 * @return the active
	 */
	public boolean isActive()
	{
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", active=" + active + "]";
	}
}
