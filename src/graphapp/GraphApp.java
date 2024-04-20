package graphapp;

import graphapp.components.Form;
import graphapp.models.OrderedPair;
import graphapp.models.TimeFrame;
import graphapp.utilities.Calculator;
import graphapp.utilities.FileDataReader;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.List;

public class GraphApp {
    private static final TimeFrame YEAR = TimeFrame.YEAR;
    private static final TimeFrame MONTH = TimeFrame.MONTH;
    private static final TimeFrame DAY = TimeFrame.DAILY;

    public static void main(String[] args) {
        FileDataReader fileReader = new FileDataReader("./data/data.txt");

        List<String> dataArray = new ArrayList<>(List.of(fileReader.getData()));
        dataArray.sort(new DateComparator());

        Calculator calculator = new Calculator();

        List<OrderedPair> foo = calculator.convertListToOrderedPairs(dataArray, MONTH);


        StringBuilder foobar = new StringBuilder();
        for (int i = 0; i < foo.size(); i++) {
            foobar.append(String.format(" (%s, %s) ", foo.get(i).getX(), foo.get(i).getY()));
        }

        // UI STUFF


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        Form form = new Form();
        frame.add(form.getForm(), BorderLayout.SOUTH);

        JLabel jLabel = new JLabel(String.valueOf(foobar));

        jLabel.setVisible(true);
        jLabel.setSize(new Dimension(50, 100));
        frame.add(jLabel);

        frame.setSize(300, 600);
        frame.setVisible(true);
    }
}

class DateComparator implements java.util.Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int date1 = (int) LocalDateTime.parse(a).toEpochSecond(ZoneOffset.UTC);
        int date2 = (int) LocalDateTime.parse(b).toEpochSecond(ZoneOffset.UTC);

        return Integer.compare(date1, date2);
    }
}
