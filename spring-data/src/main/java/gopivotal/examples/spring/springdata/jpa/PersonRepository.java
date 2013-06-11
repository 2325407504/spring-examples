/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A simple Spring Data repository
 * @author cdelashmutt
 *
 */
@Repository
public interface PersonRepository
	extends CrudRepository<Person, Integer>,
	JpaSpecificationExecutor<Person>
{
	public List<Person> findByActive(@Param("active") boolean active);
	public List<Person> findByLastNameStartingWithOrderByFirstNameAsc(@Param("starting") String starting);
	
	@Query("from Person p where p.active=true and p.firstName like %:firstName% order by p.firstName")
	public List<Person> findActiveByFirstName(@Param("firstName") String firstName);
	
	@Modifying
	@Transactional
	@Query("update Person p set p.active=true")
	public void makeAllActive();
	
}
