/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.gemfire;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository to deal with Posts
 * 
 * @author cdelashmutt
 */
public interface PostRepository
	extends CrudRepository<Post, Integer>
{
	Collection<Post> findByUserId(int userId);
}
