package com.company.service;

import com.company.connectDB.SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class getDocumentNameAndData{

    public Map getDocumentPath(String domen){
        SQLConnection dc = SQLConnection.getInstance();
        String sql = "Select doc_attached.data, doc_attached.name from doc_attached inner join reg_doc on doc_attached.id = reg_doc.doc_id inner join reg_coll on reg_doc.id = reg_coll.register_id inner join collegues on reg_coll.collegue_id = collegues.id where collegues.domen = '" + domen +"'";
        HashMap result = new HashMap();
        try {
            Connection conn = dc.getConnection();
            if (conn == null) {
                System.out.println("Отсутствует соединение с БД!");
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                result.put(rs.getString(2),rs.getString(1));
            }

            conn.close();
        } catch (SQLException var8) {
            var8.printStackTrace();
        }



        return result;

    }



}
