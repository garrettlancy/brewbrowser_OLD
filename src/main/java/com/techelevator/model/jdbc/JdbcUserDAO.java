package com.techelevator.model.jdbc;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.User;
import com.techelevator.model.dao.UserDAO;
import com.techelevator.security.PasswordHasher;


@Component
public class JdbcUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;


	@Autowired
	public JdbcUserDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User getUser(String username) {
		User user = null;
		String sqlSelectUser = "SELECT * FROM users WHERE username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectUser, username);
		if(results.next()) {
			user = mapRowToUser(results);
		}
		return user;
	}

	@Override
	public User getUserById(long userId) {
		User user = null;
		String sqlSelectUser = "SELECT * FROM users WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectUser, userId);
		if(results.next()) {
			user = mapRowToUser(results);
		}
		return user;
	}


	@Override
	public void saveUser(User user) {
		String sqlSaveUser = "INSERT INTO users(email, username, password) VALUES(?, ?, ?)";
		jdbcTemplate.update(sqlSaveUser, user.getEmail(), user.getUsername(), user.getPassword());
	}

	@Override
	public void saveUserToBrewery(long userId, long breweryId) {
		String sqlSaveUserToBrewery = "INSERT INTO breweries_users(user_id, brewery_id) VALUES(?, ?)";
		jdbcTemplate.update(sqlSaveUserToBrewery, userId, breweryId);
	}

	private User mapRowToUser(SqlRowSet row) {
		User user = new User();
		user.setId(row.getLong("id"));
		user.setEmail(row.getString("email"));
		user.setUsername(row.getString("username"));
		user.setPassword(row.getString("password"));
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM users WHERE email = ?", email);
		if(results.next()) {
			user = mapRowToUser(results);
		}
		return user;
	}

	@Override
	public boolean searchForUsernameAndPassword(String userName, String password) {
		String sqlSearchForUser = "SELECT * "+
				"FROM app_user "+
				"WHERE UPPER(user_name) = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toUpperCase());
		if(results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			return storedPassword.equals(hashedPassword);
		} else {
			return false;
		}
	}

	@Override
	public String checkBreweryPermissions(long breweryId) {
		return jdbcTemplate.queryForObject("SELECT email FROM users WHERE id = (SELECT user_id FROM breweries_users WHERE brewery_id = ?)", String.class, breweryId);
	}




}
