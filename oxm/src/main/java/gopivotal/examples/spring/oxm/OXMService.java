/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.oxm;

/**
 * TODO: Describe OXMService
 * @author cdelashmutt
 *
 */
public interface OXMService
{
	String serialize(User user);
	
	User deserialize(String xml);
}
