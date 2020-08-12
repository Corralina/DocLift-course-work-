package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class Main {


    private static ConnectMySQL connectMySQL;

    static {
        try {
            connectMySQL = new ConnectMySQL();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        ConnectFDB connectFDB = new ConnectFDB();
        int[] number = connectMySQL.getDocumentNumber();
        for (int num : number){
            String[] data = connectFDB.data_document(num);
            connectMySQL.updateDocument(num, data[0], data[1], data[2]);
        }
    }
}
