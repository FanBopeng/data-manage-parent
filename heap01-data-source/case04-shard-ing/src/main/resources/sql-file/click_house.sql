----  数据库1

CREATE DATABASE query_data01 ENGINE = Ordinary;

CREATE TABLE query_data01.ch_table_01 (
  `id` UInt64,
  `user_name` String,
  `phone` String,
  `email` String,
  `create_day` Date DEFAULT CAST(now(),'Date')
) ENGINE = MergeTree(create_day, intHash32(id), 8192)

CREATE TABLE query_data01.ch_table_02 (
  `id` UInt64,
  `user_name` String,
  `phone` String,
  `email` String,
  `create_day` Date DEFAULT CAST(now(),'Date')
) ENGINE = MergeTree(create_day, intHash32(id), 8192)

----  数据库2

CREATE DATABASE query_data02 ENGINE = Ordinary;

CREATE TABLE query_data02.ch_table_01 (
  `id` UInt64,
  `user_name` String,
  `phone` String,
  `email` String,
  `create_day` Date DEFAULT CAST(now(),'Date')
) ENGINE = MergeTree(create_day, intHash32(id), 8192)

CREATE TABLE query_data02.ch_table_02 (
  `id` UInt64,
  `user_name` String,
  `phone` String,
  `email` String,
  `create_day` Date DEFAULT CAST(now(),'Date')
) ENGINE = MergeTree(create_day, intHash32(id), 8192)