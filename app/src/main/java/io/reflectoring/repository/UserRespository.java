package io.reflectoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.reflectoring.entity.ARMAUser;

public interface UserRespository extends JpaRepository<ARMAUser,Long> {

	@Query(value = "select armaUser from ARMAUser armaUser where armaUser.loginName=:loginName")
    ARMAUser findByLoginName(@Param("loginName") String loginName);
}
