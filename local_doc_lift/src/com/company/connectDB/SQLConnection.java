package com.company.connectDB;

import com.company.config.Setting;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnection {
    private SQLConnection(SQLConnection sqlConnection) {
    }

    public static SQLConnection getInstance() {
        return SQLConnection.SQLConnectionHold.INSTANCE;
    }

    public Connection getConnection() {
        Connection conn = null;
        Setting setting = new Setting();
        Properties properties = null;
        try {
            properties = setting.properties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + properties.getProperty("server_name_sql") + ":" + properties.getProperty("db_port_sql")  + "/" + properties.getProperty("db_name_sql") + "? verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url, properties.getProperty("user_sql"), properties.getProperty("password_sql"));
        } catch (SQLException var18) {
            System.out.println(var18.getMessage());
        } catch (ClassNotFoundException var19) {
            var19.printStackTrace();
        }

        return conn;
    }

    private static class SQLConnectionHold {
        private static final SQLConnection INSTANCE = new SQLConnection((SQLConnection)null);

        private SQLConnectionHold() {
        }
    }
}
