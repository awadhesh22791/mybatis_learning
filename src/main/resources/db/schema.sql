create table user
(
   id INTEGER IDENTITY PRIMARY KEY,
   first_name VARCHAR(255) NOT NULL, 
   last_name VARCHAR(255) NOT NULL,
   email_address VARCHAR(255) NOT NULL
);