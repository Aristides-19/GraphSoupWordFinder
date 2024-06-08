package controller;

import model.GraphADS;
import model.WordSearchModel;
import view.*;
import model.LinkedList;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class App {

    private static GraphADS<Character> soupGraph;
    private static final LinkedList<String> dictionary = new LinkedList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileSelector launchView = new FileSelector();
        launchView.setVisible(true);
    }

    /**
     * Bridge to send data of the file to read from view
     *
     * @param path path of the file txt
     * @return true if the process was succesful, false otherwise
     */
    public static boolean sendFileData(String path) {
        try {
            String[][] lettersFile = LettersFileReader.read(path);
            Character[] vertices = new Character[lettersFile[1].length];

            for (int i = 0; i < vertices.length; i++) {
                vertices[i] = lettersFile[1][i].charAt(0);
            }

            soupGraph = GraphController.createGraph(vertices);

            for (var word : lettersFile[0]) {
                dictionary.insert(word);
            }

            return true;
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * To search every dictionary word on the graph
     *
     * @param choice algorithm to traverse the graph. 0 is DFS and 1 is BFS.
     * @return Array of strings containing a pair with word : found or not. The
     * last element is the time delayed to find every word in the graph in
     * miliseconds.
     */
    public static String[] searchWords(int choice) {
        char[][] words = wordsToChars();
        boolean[] wordsFound = new boolean[dictionary.getSize()];
        String[] returnArray = new String[dictionary.getSize() + 1];

        long startTime = System.nanoTime();
        if (choice == 0) {
            for (int i = 0; i < words.length; i++) {
                wordsFound[i] = WordSearchModel.dfsSearch(soupGraph, words[i]);
            }
        } else if (choice == 1) {
            for (int i = 0; i < words.length; i++) {
                wordsFound[i] = WordSearchModel.bfsSearch(soupGraph, words[i]);
            }
        }
        long endTime = System.nanoTime();
        double time = (double) (endTime - startTime) / 1000000;

        returnArray[dictionary.getSize()] = "Tiempo en encontrar las palabras: " + time + "ms";
        int i = 0;
        for (String word : dictionary) {
            returnArray[i] = wordsFound[i] ? word + ": Encontrada" : word + ": No Encontrada";
            i++;
        }

        return returnArray;
    }

    /**
     * Add a word to the dictionary if the word is valid
     *
     * @param word word to add
     * @return true if the addition proccess was succesful, false otherwise
     */
    public static boolean addDictionaryWord(String word) {
        if (LettersFileReader.isValidWord(word) && !dictionary.contains(word)) {
            dictionary.insert(word);
            return true;
        }
        return false;
    }

    /**
     * Update the text file loaded by the user
     *
     * @return true if the process was succesful, false otherwise
     */
    public static boolean updateDictionaryFile() {
        boolean result = LettersFileReader.write(dictionary, soupGraph);
        return result;
    }

    public static LinkedList<String> getDictionary() {
        return dictionary;
    }

    public static GraphADS<Character> getGraph() {
        return soupGraph;
    }

    /**
     * Convert each word from the dictionary to an array of chars
     *
     * @return array of arrays of chars
     */
    private static char[][] wordsToChars() {
        char[][] words = new char[dictionary.getSize()][];

        int i = 0;
        for (String word : dictionary) {
            words[i] = new char[word.length()];

            for (int j = 0; j < word.length(); j++) {
                words[i][j] = word.charAt(j);
            }

            i++;
        }

        return words;
    }
}
