package prahl.daniel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by danielprahl on 7/5/17.
 */
public class Util {


    public static void shortenCSV(){
        String csvFile = "/Users/danielprahl/dev/projects/legoviewer/src/main/resources/instructions.csv";
        String line = "";
        String cvsSplitBy = ",";
        String outPut = "";
        boolean isFirst = true;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            System.out.println("Starting...");
            //while ((line = br.readLine()) != null) {
            for (int i = 0; i < 11000; i++){ line = br.readLine();
                // use comma as separator
                String[] legoSetData = line.split(cvsSplitBy);
                if(isFirst) {
                    isFirst = false;
                    continue;
                }

                outPut  +=  legoSetData[0] + "," +
                            legoSetData[1] + "," +
                            legoSetData[2] + "\n";

                //System.out.print(outPut);
            }
            System.out.println("...Complete.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            PrintWriter writer = new PrintWriter("newInstructions.csv", "UTF-8");
            writer.print(outPut);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void parseCSVtoJSON(){
        String csvFile = "/Users/danielprahl/dev/projects/legoviewer/src/main/resources/instructions.csv";
        String line = "";
        String cvsSplitBy = ",";
        String outPut = "";
        boolean isFirst = true;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            //while ((line = br.readLine()) != null) {
            for (int i = 0; i < 1000; i++){ line = br.readLine();

                // use comma as separator
                String[] legoSetData = line.split(cvsSplitBy);

                if(!isFirst){
                    outPut += ",";
                }

                outPut += "{\n \"setNumber\" : " + legoSetData[0] + " , " +
                        " \"url\" : " + legoSetData[1] + " , " +
                        " \"description\" : " + legoSetData[2] + " \n}";

                isFirst = false;
                //System.out.print(outPut);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            PrintWriter writer = new PrintWriter("instructions.json", "UTF-8");
            writer.print("[");
            writer.print(outPut);
            writer.print("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
