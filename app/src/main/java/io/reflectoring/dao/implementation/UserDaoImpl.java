package io.reflectoring.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.reflectoring.dao.UserDao;
import io.reflectoring.entity.ARMAUser;
import io.reflectoring.repository.UserRespository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRespository userRespository;

    @Override
    public ARMAUser fetchUserDetails(String username) {
        return userRespository.findByLoginName(username);
    }    
}
