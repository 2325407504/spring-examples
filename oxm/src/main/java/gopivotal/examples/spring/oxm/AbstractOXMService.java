/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.oxm;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

/**
 * Base class for marshalling example
 * 
 * @author cdelashmutt
 */
public class AbstractOXMService
implements OXMService
{

	private Marshaller marshaller;
	
	private Unmarshaller unmarshaller;

	public AbstractOXMService()
	{
		super();
	}

	@Override
	public String serialize(User user)
	{
		StringWriter result = new StringWriter();
		try
		{
			marshaller.marshal(user, new StreamResult(result));	
			return result.toString();
		}
		catch(IOException e)
		{
			throw new RuntimeException("I don't know how you get an IOException on a String, but...", e);
		}
	}

	@Override
	public User deserialize(String xml)
	{
		try
		{
			return (User)unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
		}
		catch(IOException e)
		{
			throw new RuntimeException("I don't know how you get an IOException on a String, but...", e);
		}
	}

	/**
	 * @param marshaller
	 */
	protected void internalSetMarshaller(Marshaller marshaller)
	{
		this.marshaller = marshaller;
	}

	/**
	 * @param unmarshaller
	 */
	protected void internalSetUnmarshaller(Unmarshaller unmarshaller)
	{
		this.unmarshaller = unmarshaller;
	}

}