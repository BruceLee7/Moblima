package control;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
// import java.nio.file.Path;

/**
 Represents the base for all manager apps
 multiple functions here are inherited
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public abstract class DBManager<T> {

    /**
     * The root access of the Data base Manager
     */
    public String root;
    /**
     * The column index
     */
    public ArrayList<String> columns;
    /**
     * The database
     */
    public ArrayList<T> data;

    /**
     * A function to initialize the filename
     *
     */
    
    public DBManager(String filename) {
        this.root = filename;
        this.data = new ArrayList<T>();
    }

    /**
     * A function to read data from the give text
     * to store the assets
     */
    public DBManager(){
        this.root = "defaultAssets.txt";
    }


    /**
     * The basic read function
     *
     */
    public void read(String root) throws IOException{
        Scanner sc = new Scanner(new FileInputStream(root));
        sc.nextLine();
        String nextLine;
        ArrayList<String> newEle;
        while (sc.hasNext()) {
            nextLine = sc.nextLine();
            newEle = new ArrayList<String>();
            for (String e: nextLine.trim().split(";", 10)){
                newEle.add(e);
            }
            this.data.add(constructFromArr(newEle));
        }
        sc.close();
    };

    /**
     * The basic write function
     *
     */

    public void write(String line, boolean append) throws IOException{
        FileWriter writer = new FileWriter(this.root, append);
        if (append){
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(line);
            bw.close();
        }
        else{
            String overWrite = String.join("|", this.columns) + "\n" + line;
            writer.write(overWrite);
        }
        writer.close();
    };

    /**
     * The basic remove function

     */
    public void remove(String column, String value){
        Integer index = getColumnsIndex(column);
        for (T record: this.data){
            if (decodeFromObj(record).get(index).equals(value)){
                this.data.remove(record);
            }
        }
    }

    /**
     * The basic get index function
     */
    public Integer getColumnsIndex(String column){
        int index = 0;
        for (String col: this.columns){
            if (column.equals(col))
                return index;
            index++;
        }
        return -1;
    }

    /**
     * Two abstract classes to be implemented
     * To Construct from given information
     */
    public abstract T constructFromArr(ArrayList<String> ele) throws NumberFormatException, IOException;
    public abstract ArrayList<String> decodeFromObj(T obj);
}
