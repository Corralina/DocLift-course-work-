package com.company.controller;

import com.company.service.getDocumentNameAndData;
import com.company.service.getUserDomen;
import com.company.service.loadFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Start");
        getDocumentNameAndData getDocumentNameAndData = new getDocumentNameAndData();
        getUserDomen getUserDomen = new getUserDomen();
        loadFile loadFile = new loadFile();


        String domen = getUserDomen.getDomen();
        Map<String, String> list_file = getDocumentNameAndData.getDocumentPath(domen);
        int count_files = loadFile.loadFiles(list_file, domen);
        MessageOk.getMessage("Зареєстровано " + count_files + " документів\n");

        try {
            TimeUnit.HOURS.sleep(2L);
        } catch (InterruptedException var19) {
            var19.printStackTrace();
        }

    }
}
