package graphapp.tests.utilities;

import graphapp.utilities.FileDataReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileDataReaderTest {

    @Test
    void getData() {
        FileDataReader file = new FileDataReader("./data/data.txt");
        assertEquals(10, file.getData().length);
    }

    @Test
    void getFile() {
        FileDataReader file = new FileDataReader("./data/data.txt");
        assertEquals("./data/data.txt", file.getFile());
    }
}