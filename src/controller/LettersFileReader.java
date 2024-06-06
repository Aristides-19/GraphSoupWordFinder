package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import model.Queue;
import model.LinkedList;
import model.Graph;
import model.Vertex;

/**
 * Class to read a text file with a determined structure. The dictionary must be
 * between dic - /dic and letters must be between tab - /tab.
 *
 * @author Arístides Pérez
 */
public class LettersFileReader {

    static private String filePath;

    /**
     * Read the txt file and convert it to a string
     *
     * @param path path of the file txt
     * @return Array2D of Strings... Array[0] is word dictionary and Array[1] is
     * word soup
     */
    public static String[][] read(String path) {
        filePath = path;
        try {
            File file = new File(path);
            String tab = "", dic = "", data = "";
            boolean dicB = false, dicBB = false, tabB = false, tabBB = false;
            Queue<String> queue = new Queue<>();

            try (Scanner reader = new Scanner(file)) {

                while (reader.hasNextLine()) {
                    data = reader.nextLine();
                    queue.enqueue(data);
                }

                while (!queue.isEmpty()) {
                    data = queue.dequeue();

                    if (data.equals("/dic")) {
                        dicBB = true;
                    } else if (data.equals("/tab")) {
                        tabBB = true;
                    }

                    if (dicB && !dicBB) {
                        dic += isValidWord(data) ? data + "," : "";
                    } else if (tabB && !tabBB) {
                        tab += data;
                    }

                    if (data.equals("dic")) {
                        dicB = true;
                    } else if (data.equals("tab")) {
                        tabB = true;
                    }
                }
            }
            String[][] textFile = {dic.split(","), tab.split(",")};

            return dicB && dicBB && tabB && tabBB ? textFile : null;
        } catch (FileNotFoundException e) {

        }
        return null;
    }

    /**
     * Write to the path file to update the dictionary
     *
     * @param dictionary dictionary to write
     * @param graph graph created before with word soup letters
     * @return true if the writing was succesful, otherwise false
     */
    public static boolean write(LinkedList<String> dictionary, Graph graph) {
        String toWrite = "dic\n";
        for (String word : dictionary) {
            toWrite += word + "\n";
        }
        toWrite += "/dic\ntab\n";

        Vertex[] vertices = graph.getVertices();

        for (int i = 0; i < vertices.length; i++) {
            toWrite += i < vertices.length - 1 ? vertices[i].getData() + "," : vertices[i].getData() + "\n";
        }
        toWrite += "/tab";

        try (var writer = new FileWriter(filePath)) {
            writer.write(toWrite);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Verifies if the word is valid
     *
     * @param word word to validate
     * @return false if the word length is less than 3 or if the word contains a
     * special character
     */
    public static boolean isValidWord(String word) {
        if (word.length() < 3) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(0);

            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                return false;
            }
        }

        return true;
    }
}
