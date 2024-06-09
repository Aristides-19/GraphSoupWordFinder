package controller;

import model.Graph;
import model.WordSearchModel;
import view.*;
import model.LinkedList;
import model.WordSearchGraphDisplay;

/**
 * Main Controller of the Project
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class App {

    private static Graph<Character> soupGraph;
    private static final LinkedList<String> dictionary = new LinkedList<>();
    private static double msTime;

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
    public static boolean sendFilePath(String path) {
        try {
            String[][] lettersFile = FileController.read(path);
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
     * To search one word on the graph.
     *
     * @param choice algorithm to traverse the graph. 0 is DFS and 1 is BFS
     * @param word the word to search on the graph
     * @return 0 if the word wasn't found but there is at least the first letter
     * on the graph, otherwise -1 and the viewer won't be displayed. 1 if the
     * word     * was found.
     */
    public static int searchWord(int choice, String word) {
        char[] wordChars = new char[word.length()];
        int returnV;
        for (int i = 0; i < word.length(); i++) {
            wordChars[i] = word.charAt(i);
        }

        if (choice == 0) {
            returnV = WordSearchGraphDisplay.viewDfs(soupGraph, wordChars) ? 1 : 0;
        } else {
            returnV = WordSearchGraphDisplay.viewBfs(soupGraph, wordChars) ? 1 : 0;
        }

        if (WordSearchGraphDisplay.getNodeCount() == 0) {
            return -1;
        } else {
            return returnV;
        }
    }

    /**
     * To search every dictionary word on the graph. The time delayed is set to
     * the msTime attribute from App.
       *
     * @param choice algorithm to traverse the graph. 0 is DFS and 1 is BFS.
     * @return boolean array where each index shows a boolean value whether
     * index word was found in the graph
     */
    public static boolean[] searchWords(int choice) {
        char[][] words = wordsToChars();
        boolean[] wordsFound = new boolean[dictionary.getSize()];

        long startTime = System.nanoTime();
        if (choice == 0) {
            for (int i = 0; i < words.length; i++) {
                wordsFound[i] = WordSearchModel.dfsSearch(soupGraph, words[i]);
            }
        } else {
            for (int i = 0; i < words.length; i++) {
                wordsFound[i] = WordSearchModel.bfsSearch(soupGraph, words[i]);
            }
        }
        long endTime = System.nanoTime();
        msTime = (double) (endTime - startTime) / 1000000;

        return wordsFound;
    }

    /**
     * Add a word to the dictionary if the word is valid
     *
     * @param word word to add
     * @return true if the addition proccess was succesful, false otherwise
     */
    public static boolean addDictionaryWord(String word) {
        if (FileController.isValidWord(word) && !dictionary.contains(word)) {
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
        boolean result = FileController.write(dictionary, soupGraph);
        return result;
    }

    public static LinkedList<String> getDictionary() {
        return dictionary;
    }

    public static Graph<Character> getGraph() {
        return soupGraph;
    }

    /**
     * It can not be called if searchWords never has been called
     *
     * @return time delayed to find every word on dictionary from last search
     */
    public static double getMsTime() {
        return msTime;
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
