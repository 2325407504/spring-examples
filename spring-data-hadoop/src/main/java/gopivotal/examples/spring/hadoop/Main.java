package gopivotal.examples.spring.hadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
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

		System.out.println("----------------------------");
		System.out.println("-Spring Data Hadoop Example-");
		System.out.println("----------------------------\n");

		Callable<String> script = context.getBean("listFilesystem",
				Callable.class);
		
		Callable<Void> wordCountRunner = context.getBean("wordCountRunner", Callable.class);

		Callable<Object> getOutputContent = context.getBean("getOutputContent",
				Callable.class);

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		boolean keepGoing = true;
		while (keepGoing)
		{
			try
			{
				System.out.println("----------------------------");
				System.out.println("1. Run Script");
				System.out.println("2. Run Word Count");
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
					log.trace(script.call());
				}
				else if (command.equals("2"))
				{
					log.trace("Starting job");
					wordCountRunner.call();
					log.trace("Job complete!");
					log.trace("Job output: " + getOutputContent.call());
				}
				else
				{
					System.out.println("Bad command.");
				}
			}
			catch (Exception e)
			{
				log.error(e);
			}
		}
	}
}
