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
/**
 * 
 */
package org.mitre.openid.connect.client;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.mitre.openid.connect.model.IUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;

/**
 * 
 * Simple mapper that adds COM000000 to the authorities map for all queries,
 * plus adds COM999999 if the subject and issuer pair are found in the
 * configurable "admins" set.
 * 
 * @author jricher
 * 
 */
public class NamedAdminAuthoritiesMapper implements OIDCAuthoritiesMapper {

	private static Logger logger = LoggerFactory.getLogger(NamedAdminAuthoritiesMapper.class);

	private static final SimpleGrantedAuthority COM999999 = new SimpleGrantedAuthority("COM999999");
	private static final SimpleGrantedAuthority COM000000 = new SimpleGrantedAuthority("COM000000");

	private Set<SubjectIssuerGrantedAuthority> admins = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> mapAuthorities(JWT idToken, IUserInfo userInfo) {

		Set<GrantedAuthority> out = new HashSet<>();
		try {
			JWTClaimsSet claims = idToken.getJWTClaimsSet();

			SubjectIssuerGrantedAuthority authority = new SubjectIssuerGrantedAuthority(claims.getSubject(), claims.getIssuer());
			out.add(authority);

			if (admins.contains(authority)) {
				out.add(COM999999);
			}

			// everybody's a user by default
			out.add(COM000000);

		} catch (ParseException e) {
			logger.error("Unable to parse ID Token inside of authorities mapper (huh?)");
		}
		return out;
	}

	/**
	 * @return the admins
	 */
	public Set<SubjectIssuerGrantedAuthority> getAdmins() {
		return admins;
	}

	/**
	 * @param admins the admins to set
	 */
	public void setAdmins(Set<SubjectIssuerGrantedAuthority> admins) {
		this.admins = admins;
	}

}
