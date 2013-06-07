/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.gemfire;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

/**
 * A short post for a massive online short message posting service.
 * 
 * @author cdelashmutt
 */
@Region("posts")
public class Post
implements Serializable
{
	private static final long serialVersionUID = -6370320330331903912L;

	@Id
	int id;
	int userId;
	DateTime date;
	String post;

	/**
	 * 
	 */
	public Post()
	{
		super();
	}

	/**
	 * @param id
	 * @param userId
	 * @param post
	 */
	public Post(int id, int userId, String post)
	{
		this(id, userId, new DateTime(), post);
	}

	/**
	 * @param id
	 * @param userId
	 * @param date
	 * @param post
	 */
	public Post(int id, int userId, DateTime date, String post)
	{
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.post = post;
	}

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
	 * @return the userId
	 */
	public int getUserId()
	{
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	/**
	 * @return the date
	 */
	public DateTime getDate()
	{
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(DateTime date)
	{
		this.date = date;
	}
	/**
	 * @return the post
	 */
	public String getPost()
	{
		return post;
	}
	/**
	 * @param post the post to set
	 */
	public void setPost(String post)
	{
		this.post = post;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Post [id=" + id + ", userId=" + userId + ", date=" + date
				+ ", post=" + post + "]";
	}
}
