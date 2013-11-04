package com.yulong.news.controller.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yulong.news.dao.UserDAO;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;
	/**
	 * Retrieves a user record containing the user's credentials and access.
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// Declare a null Spring User
		UserDetails user = null;

		try {

			// Search database for a user that matches the specified username
			// You can provide a custom DAO to access your persistence layer
			// Or use JDBC to access your database
			// DbUser is our custom domain user. This is not the same as
			// Spring's User
			com.yulong.news.bean.User dbUser = userDAO.getUserByUserId(username);

			// Populate the Spring User object with details from the dbUser
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the correct
			// role type

			user = new User(dbUser.getUserId(), dbUser.getUserPsd(), true,
					true, true, true, getAuthorities(dbUser.getUserGroup()));

		} catch (Exception e) {
			throw new UsernameNotFoundException("Error in retrieving user");
		}

		// Return user to Spring for processing.
		// Take note we're not the one evaluating whether this user is
		// authenticated or valid
		// We just merely retrieve a user that matches the specified username
		return user;
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param access
	 *            an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	@SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> getAuthorities(String group) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// All users are granted with ROLE_USER access
		// Therefore this user gets a ROLE_USER by default
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));

		// Check if this user has admin access
		// We interpret Integer(1) as an admin user
		if (Integer.parseInt(group) == 1) {
			// User has admin access
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}

		// Return list of granted authorities
		return authList;
	}

}
