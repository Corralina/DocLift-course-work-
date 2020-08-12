package com.company;

import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class ConnectFDB {


    public String [] data_document(int docid) throws ClassNotFoundException, SQLException, IOException {
        Setting setting = new Setting();
        Properties properties = setting.properties();
        String[] result = new  String[3];
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        String url = "jdbc:firebirdsql:" + properties.getProperty("server_name_fb")+ "/" + properties.getProperty("db_port_fb") + ":" + properties.getProperty("db_name_fb");
        Connection conn = DriverManager.getConnection(url, properties.getProperty("user_fb"), properties.getProperty("password_fb"));
        String sql = "select d.DOCCREATEDATE, a.FILENAME, d.INNUM from DOCUMENT d, ATTACHED_FILES a where d.DOCID = a.DOC_ID and d.DOCID =" + docid;
        if (conn == null) {
            System.out.println("Отсутствует соединение с БД!");
        }

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                result[0] = rs.getString(1).substring(0, 10);
                result[1] = rs.getString(2);
                result[2] = rs.getString(3);
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
        conn.close();

        return result;
    }
}
