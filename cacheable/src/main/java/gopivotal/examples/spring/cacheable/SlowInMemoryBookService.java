/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.cacheable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * A slow book lookup service.
 * 
 * @author cdelashmutt
 */
@Service("slowBookService")
public class SlowInMemoryBookService
implements BookService
{
	List<Book> books = new ArrayList<Book>();

	/* (non-Javadoc)
	 * @see gopivotal.examples.spring.cacheable.BookService#getBookById(int)
	 */
	@Override
	public Book getBookById(int id)
	{
		//Force a wait!
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		//Slow, linear search.  Don't do this!
		for(Book book : books)
		{
			if(book.getId() == id)
				return book;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see gopivotal.examples.spring.cacheable.BookService#getBooksWithTitlesStartingWith(java.lang.String)
	 */
	@Override
	public List<Book> getBooksWithTitlesStartingWith(String starting)
	{
		//Force a wait
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		List<Book> returnBooks = new ArrayList<Book>();
		//Slow linear search.  Don't do this!
		for(Book book : books)
		{
			if(book.getTitle().startsWith(starting))
				returnBooks.add(book);
		}
		return returnBooks;
	}
	
	@Value("#{bookList}")
	public void setBooks(Collection<Book> newBooks)
	{
		books.addAll(newBooks);
	}
	
	protected List<Book> getBooks()
	{
		return this.books;
	}
}
