package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
            String tab = "", dic = "", data;
            boolean dicBool = false;

            try (Scanner reader = new Scanner(file)) {

                while (reader.hasNextLine()) {
                    data = reader.nextLine();
                    if (data.equals("/dic")) {
                        dicBool = true;
                    }

                    if (!dicBool && !data.equals("dic")) {
                        dic += data + ",";
                    } else if (dicBool && !data.equals("tab") && !data.equals("/dic") && !data.equals("/tab")) {
                        tab += data;
                    }
                }
            }
            String[][] textFile = {dic.split(","), tab.split(",")};

            return textFile;
        } catch (FileNotFoundException e) {

        }
        return null;
    }
}
