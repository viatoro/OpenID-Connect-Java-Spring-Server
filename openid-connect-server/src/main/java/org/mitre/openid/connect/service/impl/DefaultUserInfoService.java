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
package org.mitre.openid.connect.service.impl;

import org.mitre.oauth2.model.ClientDetailsEntity;
import org.mitre.oauth2.model.ClientDetailsEntity.SubjectType;
import org.mitre.oauth2.service.ClientDetailsEntityService;
import org.mitre.openid.connect.model.IUserInfo;
import org.mitre.openid.connect.repository.UserInfoRepository;
import org.mitre.openid.connect.service.PairwiseIdentiferService;
import org.mitre.openid.connect.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserInfoService
 * 
 * @author Michael Joseph Walsh, jricher
 * 
 */
@Service
public class DefaultUserInfoService implements UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ClientDetailsEntityService clientService;

	@Autowired
	private PairwiseIdentiferService pairwiseIdentifierService;

	@Override
	public IUserInfo getByUsername(String username) {
		return userInfoRepository.getByUsername(username);
	}

	@Override
	public IUserInfo getByUsernameAndClientId(String username, String clientId) {

		ClientDetailsEntity client = clientService.loadClientByClientId(clientId);

		IUserInfo userInfo = getByUsername(username);

		if (client == null || userInfo == null) {
			return null;
		}

		if (SubjectType.PAIRWISE.equals(client.getSubjectType())) {
			String pairwiseSub = pairwiseIdentifierService.getIdentifier(userInfo, client);
			userInfo.setSub(pairwiseSub);
		}

		return userInfo;

	}

	@Override
	public IUserInfo getByEmailAddress(String email) {
		return userInfoRepository.getByEmailAddress(email);
	}

}
