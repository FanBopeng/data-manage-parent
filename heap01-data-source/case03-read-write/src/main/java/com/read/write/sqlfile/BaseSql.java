package com.read.write.sqlfile;

public class BaseSql {

    public static String READ_SQL = "SELECT * FROM %s LIMIT 1";

    public static String WRITE_SQL = "INSERT INTO %s (SELECT * FROM %s WHERE 1=0)" ;

    public static String CREATE_SQL = "SHOW CREATE TABLE %s" ;

    public static String SELECT_SQL = "SELECT * FROM %s" ;

    public static String COUNT_SQL = "SELECT COUNT(1) countNum FROM %s" ;

    public static String PAGE_SQL = "SELECT * FROM %s LIMIT %s,%s" ;

    public static String STRUCT_SQL (){
        StringBuffer sql = new StringBuffer() ;
        sql.append(" SELECT                     ");
        sql.append("     COLUMN_NAME,           ");
        sql.append("     IS_NULLABLE,           ");
        sql.append("     COLUMN_TYPE,           ");
        sql.append("     COLUMN_KEY,            ");
        sql.append("     COLUMN_COMMENT         ");
        sql.append(" FROM                       ");
        sql.append(" information_schema.COLUMNS ");
        sql.append(" WHERE                      ");
        sql.append(" table_schema = '%s'        ");
        sql.append(" AND table_name = '%s'      ");
        return String.valueOf(sql) ;
    }

}
