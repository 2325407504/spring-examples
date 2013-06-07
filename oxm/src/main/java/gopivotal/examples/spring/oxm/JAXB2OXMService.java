/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.oxm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

/**
 * A JAXB2 OXM Service
 * @author cdelashmutt
 *
 */
@Service("jaxb2Service")
public class JAXB2OXMService
extends AbstractOXMService
{
	@Autowired
	public void setMarshaller(Jaxb2Marshaller marshaller)
	{
		internalSetMarshaller(marshaller);
		internalSetUnmarshaller(marshaller);
	}

}
