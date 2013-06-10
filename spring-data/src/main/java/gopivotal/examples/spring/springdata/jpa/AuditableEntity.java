/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.jpa;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

/**
 * An audit enabled entity.
 * 
 * @author cdelashmutt
 */
@MappedSuperclass
public abstract class AuditableEntity
implements Auditable<String, Integer>
{

	private static final long serialVersionUID = -1456267688965554035L;

	private String createdBy;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdDate;
	
	private String lastModifiedBy;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime lastModifiedDate;

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public DateTime getCreatedDate()
	{
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(DateTime createdDate)
	{
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy()
	{
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy)
	{
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public DateTime getLastModifiedDate()
	{
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(DateTime lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	
}
