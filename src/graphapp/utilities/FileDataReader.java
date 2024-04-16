package graphapp.utilities;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/** TODO: This needs a few methods:
 * - getData
 * - setFileName, path? idk how this upload will work...
 *
 *
  */
public class FileDataReader extends Reader {
    private String file;
    private String[] data;

    public FileDataReader(String filePath) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            System.out.println(line);
//            while (line != null) {
//                System.out.printf(line);
//                line = reader.readLine();
//            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {}

    private String[] convertFileLineToArray(String line) {
        ArrayList<String> dataArray = new ArrayList<>();

        // Really just need to get the left of the pipe symbol
        // So I could just find "this" iterant of a loop and look for the last pipe and then push the string that is in between to the array list.

        return (String[]) dataArray.toArray();
    }
}
