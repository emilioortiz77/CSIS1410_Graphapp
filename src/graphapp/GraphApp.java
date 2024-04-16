package graphapp;

import graphapp.utilities.Calculator;
import graphapp.utilities.FileDataReader;

public class GraphApp {

    public static void main(String[] args) {
        System.out.printf("%s%n", new Calculator().helloWorld());
        FileDataReader fileReader = new FileDataReader("./data/data.txt");
    }
}
