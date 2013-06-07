/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.utils;

/**
 * A simple ID generator
 * @author cdelashmutt
 *
 */
public interface IdGenerator<ID>
{
	ID generate();
}
