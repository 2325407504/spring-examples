/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.cacheable;

/**
 * Just adding in some cached methods.
 * 
 * @author cdelashmutt
 */
public interface MutableBookService
	extends BookService
{

	/**
	 * Allows removal of a book from the store.
	 * 
	 * @param id The id of the book to remove
	 */
	void deleteBook(int id);

}
