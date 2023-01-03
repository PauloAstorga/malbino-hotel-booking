INSERT INTO ROLE (name, code) VALUES ('ADMINISTRATOR','ADM');
INSERT INTO ROLE (name, code) VALUES ('USER','USR');
INSERT INTO ROLE (name, code) VALUES ('CLIENT','CLI');

INSERT INTO USER (username, mail, password, created_at, modified_at, role_id) VALUES ('malbino','malbino@admin.com','malbino321', sysdate(), sysdate(), 1);

INSERT INTO USER (username, mail, password, created_at, modified_at, role_id) VALUES ('client','itsmeaclient@client.co','client321', sysdate(), sysdate(), 3);

INSERT INTO USER (username, mail, password, created_at, modified_at, role_id) VALUES ('normaluser','normaluser@user.com','user321', sysdate(), sysdate(), 2);
