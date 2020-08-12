package com.company;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class ConnectMySQL {

    private Setting setting = new Setting();
    private Properties properties = setting.properties();

    public ConnectMySQL() throws IOException {
    }


    public int[] getDocumentNumber() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + properties.getProperty("server_name_sql") + ":" + properties.getProperty("db_port_sql")  + "/" + properties.getProperty("db_name_sql") + "? verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, properties.getProperty("user_sql"), properties.getProperty("password_sql"));
        String sql = "select id from docfile where bust='T'";
        int c = 0;
        if (conn == null) {
            System.out.println("Отсутствует соединение с БД!");
        }

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                c++;

            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
        int[] result = new int[c];
        String sql_2 = "select d.dss_id from docfile d where bust='T'";
        int col = 0;
        if (conn == null) {
            System.out.println("Отсутствует соединение с БД!");
        }

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_2);

            while (rs.next()) {
                result[col] = rs.getInt(1);
                col++;
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
        conn.close();

        return result;

    }
    public void updateDocument(int docid, String data, String name, String number) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + properties.getProperty("server_name_sql") + ":" + properties.getProperty("db_port_sql")  + "/" + properties.getProperty("db_name_sql") + "? verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String sql = "update docfile set docname = '" + name +"', datacreate = '" + data + "', number = '" + number + "', bust = 'F' where dss_id =" + docid;
        try (Connection connection = DriverManager.getConnection(url, properties.getProperty("user_sql"), properties.getProperty("password_sql"));
             Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }
    }
}
