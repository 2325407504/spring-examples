/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.cacheable;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * A cached version of the slow book lookup service
 * 
 * @author cdelashmutt
 */
@Service("cachedBookService")
public class CachedInMemoryBookService
extends SlowInMemoryBookService
implements MutableBookService
{
	Logger log = Logger.getLogger(CachedInMemoryBookService.class);

	/* (non-Javadoc)
	 * @see gopivotal.examples.spring.cacheable.SlowInMemoryBookService#getBookById(int)
	 */
	@Override
	@Cacheable("books")
	public Book getBookById(int id)
	{
		// TODO Auto-generated method stub
		return super.getBookById(id);
	}

	/* (non-Javadoc)
	 * @see gopivotal.examples.spring.cacheable.SlowInMemoryBookService#getBooksWithTitlesStartingWith(java.lang.String)
	 */
	@Override
	@Cacheable("bookQuery")
	public List<Book> getBooksWithTitlesStartingWith(String starting)
	{
		// TODO Auto-generated method stub
		return super.getBooksWithTitlesStartingWith(starting);
	}

	@Caching(evict={@CacheEvict(value="books", key="#id"), @CacheEvict(value="bookQuery", allEntries=true)})
	public void deleteBook(int id)
	{
		//Need to go about this the hard way because calling getBookById would re-cache the object!
		for(Book book : getBooks())
		{
			if(book.getId() == id)
			{
				super.getBooks().remove(book);
				break;
			}
		}
	}

}
