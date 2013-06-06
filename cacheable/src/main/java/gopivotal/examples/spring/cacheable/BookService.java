/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.cacheable;

import java.util.List;

/**
 * Service to return books
 * @author cdelashmutt
 *
 */
public interface BookService
{
	Book getBookById(int id);
	
	List<Book> getBooksWithTitlesStartingWith(String starting);
}
