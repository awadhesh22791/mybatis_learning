create table users
(
   id INTEGER IDENTITY PRIMARY KEY,
   first_name VARCHAR(255) NOT NULL, 
   last_name VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL
);

create table roles
(
   id INTEGER IDENTITY PRIMARY KEY,
   user_id INTEGER NOT NULL, 
   role VARCHAR(255) NOT NULL
);