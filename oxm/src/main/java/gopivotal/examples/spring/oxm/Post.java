/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.oxm;

import gopivotal.examples.spring.oxm.xstream.JodaDateTimeConverter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * A post on our social networking, short post service
 * @author cdelashmutt
 *
 */
@XStreamAlias("post")
@XmlRootElement
public class Post
{
	@XStreamConverter(value=JodaDateTimeConverter.class)
	DateTime date;
	
	String text;
	
	/**
	 * 
	 */
	public Post()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param date
	 * @param text
	 */
	public Post(DateTime date, String text)
	{
		super();
		this.date = date;
		this.text = text;
	}


	/**
	 * @return the date
	 */
	@XmlJavaTypeAdapter(JodaDateTimeConverter.class)
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
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text)
	{
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Post [date=" + date + ", text=" + text + "]";
	}
}
