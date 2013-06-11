package gopivotal.examples.spring.oxm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
	private static Logger log = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args)
		throws IOException
	{
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/*-context.xml");

		context.registerShutdownHook();

		OXMService xstreamService = context.getBean("xstreamService", OXMService.class);
		OXMService jaxb2Service = context.getBean("jaxb2Service", OXMService.class);
		
		System.out.println("----------------------------");
		System.out.println("---- O/X Mapping Example ---");
		System.out.println("----------------------------\n");

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		boolean keepGoing = true;
		while (keepGoing)
		{
			System.out.println("----------------------------");
			System.out.println("1. Serialize User to XML with XStream");
			System.out.println("2. Deserialize User from XML with XStream");
			System.out.println("3. Serialize User to XML with JAXB2");
			System.out.println("4. Deserialize User from XML with JAXB2");
			System.out.println("99. Quit");
			
			System.out.println("----------------------------");
			System.out.print(">");

			String command = input.readLine();

			if (command.equals("99"))
			{
				keepGoing = false;
			}
			else if (command.equals("1"))
			{
				User user = new User("Chris", "DeLashmutt",
					Arrays.asList(
						new Post[] {
							new Post(new DateTime(), "This is my first post!")
							, new Post(new DateTime(), "This post is much better...")
						}
					)
				);
				log.trace("Serializing user: " + user);
				log.trace("Serialized user is: " + xstreamService.serialize(user));
			}
			else if (command.equals("2"))
			{
				String xml = "<user firstName=\"Rod\" lastName=\"Johnson\">" +
						"<post><date>2004-07-02T08:42:25.232-04:00</date><text>J2EE is too cumbersome.</text></post>" +
						"<post><date>2011-10-25T16:12:00.981-04:00</date><text>Got to be more careful riding my bike.</text></post>" +
						"</user>";
				User user = xstreamService.deserialize(xml);
				log.trace("Deserialized user is: " + user);
			}
			else if (command.equals("3"))
			{
				User user = new User("Randy", "Savage",
					Arrays.asList(
						new Post[] {
							new Post(new DateTime(), "I'm the Macho Man!")
							, new Post(new DateTime(), "Oooooo Yeeeeah!")
						}
					)
				);
				log.trace("Serializing user: " + user);
				log.trace("Serialized user is: " + jaxb2Service.serialize(user));
			}
			else if (command.equals("4"))
			{
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
						"<user><firstName>Hulk</firstName><lastName>Hogan</lastName>" +
						"<posts>" +
						"<post><date>2013-06-06T23:05:26.751-04:00</date><text>Check out these pythons!</text></post>" +
						"<post><date>2013-06-06T23:05:26.769-04:00</date><text>Wadda you gonna do?</text></post>" +
						"</posts>" +
						"</user>";
				User user = jaxb2Service.deserialize(xml);
				log.trace("Deserialized user is: " + user);
			}
			else
			{
				System.out.println("Bad command.");
			}
		}
	}
}
