package controller;

import model.Graph;
import model.WordSearchModel;
import view.*;
import model.LinkedList;

/**
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class App {

    private static Graph<Character> soupGraph;
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
     * @return the graph if the process was succesful, null otherwise
     */
    public static Graph<Character> sendFileData(String path) {
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

            return soupGraph;
        } catch (Exception e) {

        }
        return null;
    }
}
