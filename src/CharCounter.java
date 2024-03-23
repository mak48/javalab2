import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CharCounter {
    final String inputFile, outputFile;
    private HashMap<Character, Integer> countMap;

    public CharCounter(String inputFile, String outputFile){
        countMap = new HashMap<>();
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void readAndCount(){
        File file = new File(inputFile);

        Scanner fileScan = null;
        try {
            fileScan = new Scanner(file);
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                for (char c : line.toCharArray()) {
                    if (checkLetter(c)) {
                        if (countMap.containsKey(c))
                            countMap.put(c, countMap.get(c) + 1);
                        else
                            countMap.put(c, 1);
                    }
                }
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
    }

    private boolean checkLetter(char c){
        return c >='A' && c<='Z' || c>='a' && c<='z';
    }

    public void writeToFile(){
        File file = new File(outputFile);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            ArrayList <Character> sortedKeys = new ArrayList<Character>(countMap.keySet());
            Collections.sort(sortedKeys);
            for (char key : sortedKeys) {
                bf.write(key + ": "+countMap.get(key));
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            System.out.println("Error with writing in file");
        }
    }
}
