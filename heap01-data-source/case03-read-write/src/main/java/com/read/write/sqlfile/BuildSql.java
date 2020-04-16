package com.read.write.sqlfile;


import org.apache.commons.lang.StringUtils;

public class BuildSql {

    /**
     * 读权限SQL
     */
    public static String buildReadSql(String table) {
        String readSql = null ;
        if (StringUtils.isNotEmpty(table)){
            readSql = String.format(BaseSql.READ_SQL, table);
        }
        return readSql;
    }

    /**
     * 读权限SQL
     */
    public static String buildWriteSql(String table){
        String writeSql = null ;
        if (StringUtils.isNotEmpty(table)){
            writeSql = String.format(BaseSql.WRITE_SQL, table,table);
        }
        return writeSql ;
    }

    /**
     * 表创建SQL
     */
    public static String buildStructSql (String table){
        String structSql = null ;
        if (StringUtils.isNotEmpty(table)){
            structSql = String.format(BaseSql.CREATE_SQL, table);
        }
        return structSql ;
    }

    /**
     * 表结构SQL
     */
    public static String buildTableSql (String schema,String table){
        String structSql = null ;
        if (StringUtils.isNotEmpty(table)){
            structSql = String.format(BaseSql.STRUCT_SQL(), schema,table);
        }
        return structSql ;
    }

    /**
     * 全表查询SQL
     */
    public static String buildSelectSql (String table){
        String selectSql = null ;
        if (StringUtils.isNotEmpty(table)){
            selectSql = String.format(BaseSql.SELECT_SQL,table);
        }
        return selectSql ;
    }

    /**
     * 总数查询SQL
     */
    public static String buildCountSql (String table){
        String countSql = null ;
        if (StringUtils.isNotEmpty(table)){
            countSql = String.format(BaseSql.COUNT_SQL,table);
        }
        return countSql ;
    }

    /**
     * 分页查询SQL
     */
    public static String buildPageSql (String table,int offset,int size){
        String pageSql = null ;
        if (StringUtils.isNotEmpty(table)){
            pageSql = String.format(BaseSql.PAGE_SQL,table,offset,size);
        }
        return pageSql ;
    }

}
