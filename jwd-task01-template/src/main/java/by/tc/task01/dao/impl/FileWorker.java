package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Nastya
 */
public class FileWorker {
    public boolean readFromFile(String nameAppliance,String request) {
        try{
            InputStream in = this.getClass().getResourceAsStream("/appliances_db.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;            
            while ((line = reader.readLine()) != null) {
                if(line.contains(nameAppliance) && line.contains(request)){
                    return true;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
}
