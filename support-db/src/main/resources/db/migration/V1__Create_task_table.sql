CREATE TABLE tasks (
  id BIGSERIAL NOT NULL PRIMARY KEY ,
  title VARCHAR(128) NOT NULL ,
  created_at TIMESTAMP NOT NULL ,
  updated_at TIMESTAMP NOT NULL
);