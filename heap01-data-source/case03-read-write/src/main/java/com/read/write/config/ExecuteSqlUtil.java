package com.read.write.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSqlUtil {

    public static ResultSet query(Connection conn, String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return query(stmt, sql);
    }

    private static ResultSet query(Statement stmt, String sql)throws SQLException {
        return stmt.executeQuery(sql);
    }

    public static int update(Connection conn, String sql)
            throws SQLException {
        Statement stmt = conn.createStatement();
        return executeUpdate(stmt, sql);
    }

    private static int executeUpdate(Statement stmt, String sql)throws SQLException {
        return stmt.executeUpdate(sql);
    }

    /**
     * 关闭资源
     */
    public static void closeResource (ResultSet resultSet,
                                      Statement statement,
                                      Connection connection) {
        if (resultSet != null) {
            try {resultSet.close();
            } catch (SQLException se) {se.printStackTrace();}
        }
        if (statement != null) {
            try {statement.close();
            } catch (SQLException se) {se.printStackTrace();}
        }
        if (connection != null) {
            try {connection.close();
            } catch (SQLException se) {se.printStackTrace();}
        }
    }
}
