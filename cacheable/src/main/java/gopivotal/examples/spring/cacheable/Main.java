/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.cacheable;

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

		// Normally these should be kept as BookService references, but we need
		// to call some eviction methods in the CachedInMemoryBookService
		// examples.
		BookService slowBookService = context.getBean(
				"slowBookService", BookService.class);
		MutableBookService cachedBookService = context.getBean(
				"cachedBookService", MutableBookService.class);

		System.out.println("----------------------------");
		System.out.println("-----@Cacheable Example-----");
		System.out.println("----------------------------\n");

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		boolean keepGoing = true;
		while (keepGoing)
		{
			System.out.println("----------------------------");
			System.out.println("1. Get Book by id");
			System.out
					.println("2. Get Books with titles that start with a string");
			System.out.println("3. Cached Get Book by id");
			System.out
					.println("4. Cached Get Books with titles that start with a string");
			System.out.println("5. Remove Book from mutable store");
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
					System.out.println(slowBookService.getBookById(id));
				}
				catch (Exception e)
				{
					log.error("Error retrieving book by id", e);
				}
			}
			else if (command.equals("2"))
			{
				System.out.print("Enter string to search for: ");
				try
				{
					String startsWith = input.readLine();
					for (Book book : slowBookService
							.getBooksWithTitlesStartingWith(startsWith))
					{
						System.out.println(book);
					}
				}
				catch (Exception e)
				{
					log.error("Error retrieving books", e);
				}
			}
			else if (command.equals("3"))
			{
				System.out.print("Enter id: ");
				try
				{
					int id = Integer.parseInt(input.readLine());
					System.out.println(cachedBookService.getBookById(id));
				}
				catch (Exception e)
				{
					log.error("Error retrieving book by id", e);
				}
			}
			else if (command.equals("4"))
			{
				System.out.print("Enter string to search for: ");
				try
				{
					String startsWith = input.readLine();
					for (Book book : cachedBookService
							.getBooksWithTitlesStartingWith(startsWith))
					{
						System.out.println(book);
					}
				}
				catch (Exception e)
				{
					log.error("Error retrieving books", e);
				}
			}
			else if (command.equals("5"))
			{
				System.out.print("Enter the book id to delete: ");
				try
				{
					int id = Integer.parseInt(input.readLine());
					cachedBookService.deleteBook(id);
				}
				catch (Exception e)
				{
					log.error("Error retrieving book by id", e);
				}
			}
			else
			{
				System.out.println("Bad command.");
			}
		}
	}

}
