/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.oxm.xstream;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Converts a Joda DateTime to an ISO 8601 string and back
 * @author cdelashmutt
 *
 */
public class JodaDateTimeConverter
extends XmlAdapter<String, DateTime>
implements Converter
{

	DateTimeFormatter formatter;

	public JodaDateTimeConverter()
	{
		this(ISODateTimeFormat.dateTime());
	}
	
	public JodaDateTimeConverter(DateTimeFormatter formatter)
	{
		this.formatter = formatter;
	}

	/* XStream Support */
	
	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.converters.ConverterMatcher#canConvert(java.lang.Class)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean canConvert(Class clazz)
	{
		return clazz.isAssignableFrom(DateTime.class);
	}

	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext)
	 */
	@Override
	public void marshal(Object obj, HierarchicalStreamWriter writer,
			MarshallingContext context)
	{
		DateTime dateTime = (DateTime) obj;
		writer.setValue(marshal(dateTime));
	}
	
	/* (non-Javadoc)
	 * @see com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext)
	 */
	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context)
	{
		return unmarshal(reader.getValue());
	}

	
	/* JAXB2 Support */

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(DateTime dateTime)
	{
		return formatter.print(dateTime);
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public DateTime unmarshal(String string)
	{
		// TODO Auto-generated method stub
		return formatter.parseDateTime(string);
	}
}
