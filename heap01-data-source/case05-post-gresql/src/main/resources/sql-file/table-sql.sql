-- 用户表
CREATE TABLE pq_user (
	ID INT NOT NULL,
	user_name VARCHAR (32) NOT NULL,
	user_age int4 NOT NULL,
	create_time TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT "pg_user_pkey" PRIMARY KEY ("id")
);
-- JSON表
CREATE TABLE pq_user_json (
    ID INT NOT NULL,
    title VARCHAR (32) NOT NULL,
    user_list json NOT NULL,
    create_time TIMESTAMP (6) DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT "user_json_pkey" PRIMARY KEY ("id")
);