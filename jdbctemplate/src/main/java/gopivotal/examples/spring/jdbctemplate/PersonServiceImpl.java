/**
 * Copyright GoPivotal, Inc.
 */
package gopivotal.examples.spring.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * TODO: Describe PersonServiceImpl
 * 
 * @author cdelashmutt
 * 
 */
@Service
public class PersonServiceImpl
	implements PersonService
{
	private NamedParameterJdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see gopivotal.examples.spring.jdbctemplate.PersonService#getPerson(int)
	 */
	@Override
	public Person getPerson(int id)
	{
		Person returnPerson = this.jdbcTemplate.queryForObject(
				"select * from Person where id=:id"
				, new MapSqlParameterSource("id", id)
				, PersonRowMapper.instance);

		return returnPerson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gopivotal.examples.spring.jdbctemplate.PersonService#getPeople(boolean)
	 */
	@Override
	public List<Person> getPeople(boolean active)
	{
		List<Person> returnPeople = this.jdbcTemplate.query(
				"select * from Person where active=:active"
				, new MapSqlParameterSource("active", active)
				, PersonRowMapper.instance);

		return returnPeople;
	}

	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public static class PersonRowMapper
		implements RowMapper<Person>
	{
		public final static PersonRowMapper instance = new PersonRowMapper();

		private PersonRowMapper()
		{
		}

		public Person mapRow(ResultSet rs, int rowNum)
			throws SQLException
		{
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setFirstName(rs.getString("firstName"));
			person.setLastName(rs.getString("lastName"));
			person.setActive(rs.getBoolean("active"));
			return person;
		}
	}

}
