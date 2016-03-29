


SET AUTOCOMMIT=0;

START TRANSACTION;

INSERT INTO client_details_TEMP (client_id, client_secret, client_name, dynamically_registered, refresh_token_validity_seconds, access_token_validity_seconds, id_token_validity_seconds, allow_introspection) VALUES
	('client', 'secret', 'Test Client', false, null, 3600, 600, true);

INSERT INTO client_scope_TEMP (owner_id, scope) VALUES
	('client', 'openid'),
	('client', 'profile'),
	('client', 'email'),
	('client', 'address'),
	('client', 'phone2'),
	('client', 'offline_access');

INSERT INTO client_redirect_uri_TEMP (owner_id, redirect_uri) VALUES
	('client', 'http://localhost/'),
	('client', 'http://localhost:8080/');
	
INSERT INTO client_grant_type_TEMP (owner_id, grant_type) VALUES
	('client', 'authorization_code'),
	('client', 'urn:ietf:params:oauth:grant_type:redelegate'),
	('client', 'implicit'),
	('client', 'refresh_token');


INSERT INTO client_details (client_id, client_secret, client_name, dynamically_registered, refresh_token_validity_seconds, access_token_validity_seconds, id_token_validity_seconds, allow_introspection)  select client_id, client_secret, client_name, dynamically_registered, refresh_token_validity_seconds, access_token_validity_seconds, id_token_validity_seconds, allow_introspection from client_details_TEMP
ON DUPLICATE KEY UPDATE client_details.client_id=VALUES(client_id);


INSERT INTO client_scope (owner_id, scope)  SELECT id , scope FROM client_scope_TEMP, client_details WHERE client_details.client_id = client_scope_TEMP.owner_id
ON DUPLICATE KEY UPDATE  client_scope.owner_id = VALUES(owner_id) , client_scope.scope = VALUES(scope);


INSERT INTO client_redirect_uri (owner_id, redirect_uri)  SELECT id, redirect_uri FROM client_redirect_uri_TEMP, client_details WHERE client_details.client_id = client_redirect_uri_TEMP.owner_id
ON DUPLICATE KEY UPDATE client_redirect_uri.owner_id =VALUES(owner_id) , client_redirect_uri.redirect_uri = VALUES(redirect_uri);


INSERT INTO client_grant_type (owner_id, grant_type)  SELECT id, grant_type FROM client_grant_type_TEMP, client_details WHERE client_details.client_id = client_grant_type_TEMP.owner_id
ON DUPLICATE KEY UPDATE client_grant_type.owner_id=VALUES(owner_id) , client_grant_type.grant_type = VALUES(grant_type);

    
COMMIT;

SET AUTOCOMMIT=1;
