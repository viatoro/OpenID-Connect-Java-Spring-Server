/*******************************************************************************
 * Copyright 2016 The MITRE Corporation
 *   and the MIT Internet Trust Consortium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.mitre.openid.connect.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.mitre.openid.connect.model.DefaultUserInfo;
import org.mitre.openid.connect.model.IUserInfo;
import org.mitre.openid.connect.repository.UserInfoRepository;
import org.mitre.openid.connect.sys.model.User;
import org.springframework.stereotype.Repository;

import static org.mitre.util.jpa.JpaUtil.getSingleResult;

/**
 * JPA UserInfo repository implementation
 * 
 * @author Michael Joseph Walsh
 *
 */
@Repository("jpaUserInfoRepository")
public class JpaUserInfoRepository implements UserInfoRepository {

	@PersistenceContext(unitName="defaultPersistenceUnit")
	private EntityManager manager;

	/**
	 * Get a single UserInfo object by its username
	 */
	@Override
	public IUserInfo getByUsername(String username) {
		TypedQuery<User> query = manager.createNamedQuery(User.QUERY_BY_USERNAME, User.class);
		query.setParameter(User.PARAM_USERNAME, username);

		return getSingleResult(query.getResultList());

	}

	/**
	 * Get a single UserInfo object by its email address
	 */
	@Override
	public IUserInfo getByEmailAddress(String email) {
		TypedQuery<User> query = manager.createNamedQuery(User.QUERY_BY_EMAIL, User.class);
		query.setParameter(User.PARAM_EMAIL, email);

		return getSingleResult(query.getResultList());
	}

}
