package org.mitre.oauth2.service.impl;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class DefaultUserDetailsService extends JdbcDaoImpl implements UserDetailsService {

}
