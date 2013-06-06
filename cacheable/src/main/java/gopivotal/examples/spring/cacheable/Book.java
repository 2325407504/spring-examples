/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.cacheable;

/**
 * TODO: Describe Book
 * @author cdelashmutt
 *
 */
public class Book
{
	int id;
	String title;
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
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Book [id=" + id + ", title=" + title + "]";
	}
	
}
