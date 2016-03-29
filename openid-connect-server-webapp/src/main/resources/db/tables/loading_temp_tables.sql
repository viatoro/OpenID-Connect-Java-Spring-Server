--
-- Temporary tables used during the bootstrapping process to safely load users and clients.
-- These are not needed if you're not using the users.sql/clients.sql files to bootstrap the database.
--

CREATE TEMPORARY TABLE IF NOT EXISTS authorities_TEMP (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint ix_authority_TEMP unique (username,authority));
      
CREATE TEMPORARY TABLE IF NOT EXISTS users_TEMP (
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled boolean not null);

CREATE TEMPORARY TABLE IF NOT EXISTS user_info_TEMP (
	sub VARCHAR(255) not null primary key,
	preferred_username VARCHAR(255),
	name VARCHAR(255),
	given_name VARCHAR(255),
	family_name VARCHAR(255),
	middle_name VARCHAR(255),
	nickname VARCHAR(255),
	profile VARCHAR(255),
	picture VARCHAR(255),
	website VARCHAR(255),
	email VARCHAR(255),
	email_verified BOOLEAN,
	gender VARCHAR(255),
	zone_info VARCHAR(255),
	locale VARCHAR(255),
	phone_number VARCHAR(255),
	address_id VARCHAR(255),
	updated_time VARCHAR(255),
	birthdate VARCHAR(255)
);

CREATE TEMPORARY TABLE IF NOT EXISTS client_details_TEMP (
	client_description VARCHAR(255),
	dynamically_registered BOOLEAN,
	id_token_validity_seconds BIGINT,
	
	client_id VARCHAR(255),
	client_secret VARCHAR(2048),
	access_token_validity_seconds BIGINT,
	refresh_token_validity_seconds BIGINT,
	allow_introspection BOOLEAN,
	
	client_name VARCHAR(255)
);

CREATE TEMPORARY TABLE IF NOT EXISTS client_scope_TEMP (
	owner_id VARCHAR(255),
	scope VARCHAR(2048)
);

CREATE TEMPORARY TABLE IF NOT EXISTS client_redirect_uri_TEMP (
	owner_id VARCHAR(255),
	redirect_uri VARCHAR(2048) 
);

CREATE TEMPORARY TABLE IF NOT EXISTS client_grant_type_TEMP (
	owner_id VARCHAR(255),
	grant_type VARCHAR(2000)
);

CREATE TEMPORARY TABLE IF NOT EXISTS system_scope_TEMP (
	scope VARCHAR(255),
	description VARCHAR(4096),
	icon VARCHAR(255),
	restricted BOOLEAN,
	default_scope BOOLEAN,
	structured BOOLEAN,
	structured_param_description VARCHAR(255)
);