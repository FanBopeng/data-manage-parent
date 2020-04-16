package com.read.write.config;

public enum DataSourceType {

    MySql("MySql", "com.mysql.jdbc.Driver"),
    Oracle("Oracle", "oracle.jdbc.OracleDriver"),
    DB2("DB2", "com.ibm.db2.jcc.DB2Driver");

    private String dataSourceName;
    private String driverClassName;

    public static String getDriver (String dataSourceName) {
        DataSourceType[] types = DataSourceType.values();
        for (DataSourceType type : types) {
            if (type.getDataSourceName().equals(dataSourceName)) {
                return type.getDriverClassName();
            }
        }
        return null;
    }

    DataSourceType(String dataSourceName, String driverClassName){
        this.dataSourceName = dataSourceName ;
        this.driverClassName = driverClassName ;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
    public String getDriverClassName() {
        return driverClassName;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
