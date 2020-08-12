package com.company.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class loadFile {

    public int loadFiles(Map<String, String> list, String domen){
        File dir_finish = new File("C:\\Users\\"+domen+"\\Desktop\\Doc_lift\\" + this.getThisDate());
        if (!dir_finish.exists()) {
            dir_finish.mkdirs();
        }
        int finish = 0;
        for (String key : list.keySet()){
            String string = key;
            File file = new File(DataParsPath(list.get(key)) + string);
            File file_finish = new File(dir_finish.getPath() + "\\" + string);
            try {
                Files.copy(file.toPath(), file_finish.toPath(), StandardCopyOption.REPLACE_EXISTING);
                finish ++;
            } catch (NoSuchFileException var8) {
            } catch (IOException var9) {
                var9.printStackTrace();
            }

        }


        return finish;
    }

    public String DataParsPath(String data){
        String result = "\\\\10.12.16.6\\DSS_Attach\\" + data.substring(0,4) + "\\" + data.substring(5,7) + "\\" + data.substring(8,10) + "\\";
        return result;
    }

    public String getThisDate() {
        String thisDate = null;
        Calendar c = Calendar.getInstance();
        Date currentDate = c.getTime();
        c.setTime(currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy\\MM\\dd");
        thisDate = sdf.format(currentDate);
        return thisDate;
    }

}
