package io.reflectoring.dao;

import io.reflectoring.entity.ARMAUser;

public interface UserDao {

    public ARMAUser fetchUserDetails(String username);    
}
