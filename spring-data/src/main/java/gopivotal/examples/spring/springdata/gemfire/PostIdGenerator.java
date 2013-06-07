/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.springdata.gemfire;

import java.util.concurrent.locks.Lock;

import gopivotal.examples.spring.utils.IdGenerator;

import com.gemstone.gemfire.cache.Region;

/**
 * Simple ID generator based on a replicated region.
 * 
 * @author cdelashmutt
 * 
 */
public class PostIdGenerator
	implements IdGenerator<Integer>
{

	Region<String, Integer> region;

	String entityName;

	/**
	 * @param region
	 *            Region to store incrementing integer in.
	 * @param entityName
	 *            Entity name for this id generator.
	 */
	public PostIdGenerator(Region<String, Integer> region, String entityName)
	{
		super();
		this.region = region;
		this.entityName = entityName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gopivotal.examples.spring.utils.IdGenerator#generate()
	 */
	@Override
	public Integer generate()
	{
		Integer nextId;
		Lock lock = region.getDistributedLock(entityName);
		lock.lock();
		nextId = region.get(entityName);
		if (nextId == null)
		{
			nextId = new Integer(1);
		}
		else
			nextId++;
		region.put(entityName, nextId);
		lock.unlock();
		return nextId;
	}
}
