/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.jdbctemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Small driver to bootstrap the example
 * 
 * @author cdelashmutt
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

		PersonService service = context.getBean(PersonService.class);

		System.out.println("----------------------------");
		System.out.println("----JdbcTemplate Example----");
		System.out.println("----------------------------\n");

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		boolean keepGoing = true;
		while (keepGoing)
		{
			System.out.println("----------------------------");
			System.out.println("1. Get Person by id");
			System.out.println("2. Get People by active flag");
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
				System.out.print("Enter id: ");
				try
				{
					int id = Integer.parseInt(input.readLine());
					System.out.println(service.getPerson(id));
				}
				catch (Exception e)
				{
					log.error("Error retrieving person by id", e);
				}
			}
			else if (command.equals("2"))
			{
				System.out.print("Enter true for only active People, and false for inactive People: ");
				try
				{
					boolean active = Boolean.parseBoolean(input.readLine());
					for(Person person : service.getPeople(active))
					{
						System.out.println(person);
					}
				}
				catch (Exception e)
				{
					log.error("Error retrieving people by active or inactive", e);
				}
			}
			else
			{
				System.out.println("Bad command.");
			}
		}
	}

}
