package graphapp.utilities;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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

        file = filePath;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            ArrayList<String> lineDataArray = new ArrayList<>();

            while (line != null) {
                lineDataArray = convertFileLineToArray(line);
                line = reader.readLine();
            }

            data = lineDataArray.toArray(new String[0]);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getData() {
        return data;
    }

    public String getFile() {
        return file;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {}

    private ArrayList<String> convertFileLineToArray(String line) {
        ArrayList<String> dataArray = new ArrayList<>();

        int previousPipe = -1;

        StringBuilder sb;

        for (int i = 0; i < line.length(); i++) {
            sb = new StringBuilder();
            if (line.charAt(i) == '|') {
                if (previousPipe != -1) {
                    for (int j = previousPipe; j < i; j++) {
                        if (!Character.isWhitespace(line.charAt(j)) && line.charAt(j) != '|' && line.charAt(j) != '"') {
                            if (j == 240 || j == 18 ) {
                                sb.append('0');
                            } else {
                                sb.append(line.charAt(j));

                            }
                        }
                    }

                    dataArray.add(sb.toString());
                    previousPipe = i;
                } else {
                    previousPipe = 0;
                    for (int j = previousPipe; j < i; j++) {
                        if (!Character.isWhitespace(line.charAt(j)) && line.charAt(j) != '|' && line.charAt(j) != '"') {
                            sb.append(line.charAt(j));
                        }
                    }

                    dataArray.add(sb.toString());
                    previousPipe = i;
                }
            }
        }

        return dataArray;
    }
}
