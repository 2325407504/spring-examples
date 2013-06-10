/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A simple human.
 * 
 * @author cdelashmutt
 */
@Entity
public class Person
extends AuditableEntity
{
	private static final long serialVersionUID = -6601051885360838467L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	boolean active;
	String firstName;
	String lastName;

	public Person()
	{
		super();
	}
	
	/**
	 * @param id
	 * @param active
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName, boolean active)
	{
		super();
		this.active = active;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * @return the id
	 */
	public Integer getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id)
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
		return "Person [id=" + id + ", active=" + active + ", firstName="
				+ firstName + ", lastName=" + lastName + ", createdBy="
				+ getCreatedBy() + ", createdDate=" + getCreatedDate()
				+ ", lastModifiedBy=" + getLastModifiedBy()
				+ ", lastModifiedDate=" + getLastModifiedDate() + "]";
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.domain.Persistable#isNew()
	 */
	@Override
	public boolean isNew()
	{
		return getId() == null;
	}
}
