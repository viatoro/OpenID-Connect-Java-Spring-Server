package org.mitre.oauth2.repository;

import java.util.List;

import org.mitre.oauth2.model.UserEntity;

public interface UserRepository {

	public List<UserEntity> findByUserName(String userName);

}
