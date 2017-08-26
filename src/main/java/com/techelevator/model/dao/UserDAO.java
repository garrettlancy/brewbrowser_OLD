package com.techelevator.model.dao;

import com.techelevator.User;

public interface UserDAO {

    public User getUser(String username);
    
    public void saveUser(User user);
    
    public User getUserByEmail(String email);

	public void saveUserToBrewery(long userId, long breweryId);

	public User getUserById(long userId);
	
	public String checkBreweryPermissions(long breweryId);

	public boolean searchForUsernameAndPassword(String userName, String password);

}
