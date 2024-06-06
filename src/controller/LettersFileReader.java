package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.Queue;

/**
 * Class to read a text file with a determined structure. The dictionary must be
 * between dic - /dic and letters must be between tab - /tab.
 *
 * @author Arístides Pérez
 */
public class LettersFileReader {

    /**
     * Read the txt file and convert it to a string
     *
     * @param path path of the file txt
     * @return Array2D of Strings... Array[0] is word dictionary and Array[1] is
     * word soup
     */
    public static String[][] read(String path) {
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
                        dic += data + ",";
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
}
