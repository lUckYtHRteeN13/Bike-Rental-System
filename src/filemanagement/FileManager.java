/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jael PC
 */
public class FileManager {
    private File file;
        
    public FileManager( File file ) {
        this.file= file;
    }
    
    // Setter Methods
    public File setFile( File file ) {
        this.file = file;        
        return this.file;
    }

    // Getter Methods
    public  File getFile() {
        return this.file;
    }
    
    // Other Methods
    public String save( String data ) {
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            fileWriter.write(data);
            fileWriter.close();
            
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return data;
    }
    
    public String load() {
        String data = "";
        try {
          Scanner fileReader = new Scanner(this.file);
          
          while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            data = data + (line + "\n");
          }
          
          fileReader.close();
          
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
        return data;
    }
    
    public static void main( String args[] ) {
        File file = new File("Unknown.txt");        
        FileManager fm = new FileManager(file);
        String d = fm.load();
        String[] data_rows = d.split("\\n");
        String[][] data = new String[data_rows.length][];
        for (int x = 0; x < data_rows.length; x++) {
            data[x] = data_rows[x].split("\\|");
        }
        
        System.out.println(Arrays.toString(data[0]));
        System.out.print(Arrays.toString(Arrays.asList(Arrays.copyOfRange(data, 1, data_rows.length)).toArray()));
        
    }
}
