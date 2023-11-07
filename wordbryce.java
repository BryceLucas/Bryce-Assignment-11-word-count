// wordbryce.java
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class wordbryce {

    public static void main(String[] args) {
        // HashMap to store the words and their counts
        Map<String, Integer> wordCountMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            // Creating BufferedReader object to read the input text file
            reader = new BufferedReader(new FileReader("Counterbryce/input.txt"));

            // Reading the first line into currentLine
            String currentLine = reader.readLine();

            while (currentLine != null) {
                // Converting the currentLine to lowercase
                String word = currentLine.toLowerCase();

                // Checking if the word is already in wordCountMap
                if(wordCountMap.containsKey(word)) {
                    // If it is, increment its count by one
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    // If not, add the word to wordCountMap with 1 as its value
                    wordCountMap.put(word, 1);
                }

                // Reading the next line into currentLine
                currentLine = reader.readLine();
            }

            // Creating BufferedWriter object to write the output text file
            BufferedWriter writer = new BufferedWriter(new FileWriter("Counterbryce/output.txt"));

            // Writing each word and its count to the output file
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }

            // Closing the writer
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Closing the reader
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

