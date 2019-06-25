/*==============================================================*/

DROP TABLE IF EXISTS users CASCADE;

DROP TABLE IF EXISTS client CASCADE;

/*==============================================================*/
/* Table: client                                                */
/*==============================================================*/
CREATE TABLE client
(
  id_client    INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name         TEXT NOT NULL,
  surname      TEXT NOT NULL,
  PESEL        TEXT NOT NULL,
  phone_number TEXT NOT NULL,
  mail         TEXT NOT NULL
);

/*==============================================================*/
/* Table: users                                        */
/*==============================================================*/
CREATE TABLE users
(
  id    INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username     TEXT NOT NULL,
  password     TEXT NOT NULL,
  gender       TEXT NOT NULL,
  phone_number TEXT NOT NULL,
  employee_id        TEXT NOT NULL,
  profile_pic TEXT NOT NULL,
  email        TEXT NOT NULL
);