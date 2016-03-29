

SET AUTOCOMMIT=0;

START TRANSACTION;



INSERT INTO system_scope_TEMP (scope, description, icon, restricted, default_scope, structured, structured_param_description) VALUES
  ('openid', 'log in using your identity', 'user', false, true, false, null),
  ('profile', 'basic profile information', 'list-alt', false, true, false, null),
  ('email', 'email address', 'envelope', false, true, false, null),
  ('address', 'physical address', 'home', false, true, false, null),
  ('phone', 'telephone number', 'bell', false, true, false, null),
  ('offline_access', 'offline access', 'time', false, false, false, null);
  
INSERT INTO system_scope (scope, description, icon, restricted, default_scope, structured, structured_param_description)  SELECT scope, description, icon, restricted, default_scope, structured, structured_param_description FROM system_scope_TEMP
ON DUPLICATE KEY UPDATE system_scope.scope=VALUES(scope);

COMMIT;

SET AUTOCOMMIT=1;