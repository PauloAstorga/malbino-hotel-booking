INSERT INTO ROLE(name, code) VALUES ('ADMINISTRATOR','ADM');
INSERT INTO ROLE(name, code) VALUES ('USER','USR');
INSERT INTO ROLE(name, code) VALUES ('CLIENT','CLI');

INSERT INTO SYS_USER(username, mail, password, created_at, modified_at, role_id) VALUES ('malbino','malbino@admin.com','malbino321', now(), now(), 1);

INSERT INTO SYS_USER(username, mail, password, created_at, modified_at, role_id) VALUES ('client','itsmeaclient@client.co','client321', now(), now(), 3);

INSERT INTO SYS_USER(username, mail, password, created_at, modified_at, role_id) VALUES ('normaluser','normaluser@user.com','user321', now(), now(), 2);
