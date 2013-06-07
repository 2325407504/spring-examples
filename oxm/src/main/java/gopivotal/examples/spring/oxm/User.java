/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.oxm;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * A user for our social networking, short post service
 * @author cdelashmutt
 *
 */
@XStreamAlias("user")
@XmlRootElement
public class User
{
	@XStreamAsAttribute
	String firstName;
	@XStreamAsAttribute
	String lastName;

	@XStreamImplicit(itemFieldName="post")
	List<Post> posts = new ArrayList<Post>();

	public User()
	{
		
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param posts
	 */
	public User(String firstName, String lastName, List<Post> posts)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.posts = posts;
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

	/**
	 * @return the posts
	 */
	@XmlElementWrapper(name="posts")
	@XmlElement(name="post")
	public List<Post> getPosts()
	{
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts)
	{
		this.posts = posts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "User [firstName=" + firstName + ", lastName=" + lastName
				+ ", posts=" + posts + "]";
	}
}
