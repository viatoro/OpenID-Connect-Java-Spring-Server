package org.mitre.oauth2.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.mitre.oauth2.model.UserEntity;
import org.mitre.oauth2.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("jpaUserRepository")
public class JpaUserRepository implements UserRepository {

	@PersistenceContext(unitName="defaultPersistenceUnit")
	private EntityManager em;
	
	@Override
	@Transactional(value="defaultTransactionManager")
	public List<UserEntity> findByUserName(String userName) {
		
		Query user = em.createNativeQuery("", UserEntity.class);
		List s = user.getResultList();
		return s;
	}
}
