package graphapp.components;

import javax.swing.*;
import java.awt.*;

public class Form extends Canvas {
    Canvas form;

    public Form() {
        super();

        // create a empty canvas
        form = new Canvas() {
            public void paint(Graphics g)
            {
            }
        };

        form.setBackground(Color.black);
    }

    public Canvas getForm() {
        return form;
    }
}
