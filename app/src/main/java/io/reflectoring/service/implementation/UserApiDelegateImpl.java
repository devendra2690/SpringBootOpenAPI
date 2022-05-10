package io.reflectoring.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.reflectoring.api.UserApiDelegate;
import io.reflectoring.dao.UserDao;
import io.reflectoring.entity.ARMAUser;
import io.reflectoring.model.User;
import io.reflectoring.model.UserValue;
import io.reflectoring.transformer.UserApiTransformer;
import io.reflectoring.validator.UserApiValidator;

@Service
public class UserApiDelegateImpl implements UserApiDelegate {

	private static final String CLASS_NAME = UserApiDelegateImpl.class.getName();
	private static final Logger log = LoggerFactory.getLogger(UserApiDelegateImpl.class);

	@Autowired
	UserDao userDao;

	@Override
	public ResponseEntity<User> user(String username) {

		log.debug("UserApiDelegateImpl::user()::START::request received to fetch Userdetails record for " + username);

		// Validate Input
		UserApiValidator.validateUserGetRequest(username, CLASS_NAME);

		// Make call to DB to fetch data
		log.debug("UserApiDelegateImpl::user()::DAO call to fetch userdetails for " + username);
		ARMAUser armaUser = userDao.fetchUserDetails(username);

		// Transform Data from Entity to Response Model
		log.debug("UserApiDelegateImpl::user():: Transform fetched userdetails data");
		User user = new User();

		if (armaUser == null) {
			log.debug("UserApiDelegateImpl::user()::END::Sending resposnse back to controller");

			user.setResult(UserApiTransformer.transformResultMetadata(HttpStatus.NOT_FOUND.name()));
			user.setValue(new UserValue());

			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		} else {

			log.debug("UserApiDelegateImpl::user()::END::Sending resposnse back to controller");

			UserApiTransformer.transformARMAUserToUser(armaUser, user);

			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

}
