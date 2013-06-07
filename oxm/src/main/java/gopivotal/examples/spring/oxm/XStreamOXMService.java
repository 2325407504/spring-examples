/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.oxm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Service;

/**
 * An XStream based service
 * 
 * @author cdelashmutt
 * 
 */
@Service("xstreamService")
public class XStreamOXMService
	extends AbstractOXMService
{
	/**
	 * @param marshaller
	 *            the marshaller to set
	 */
	@Autowired
	public void setMarshaller(XStreamMarshaller marshaller)
	{
		internalSetMarshaller(marshaller);
		internalSetUnmarshaller(marshaller);
	}

}
