package model;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class SetImage {

    public static void setIcon(JFrame object) {
        ImageIcon i = new ImageIcon("src//resources//logo_4_full.png");
        Image image = i.getImage();
        object.setIconImage(image);
    }

    public static void setIcon(JDialog object) {
        ImageIcon i = new ImageIcon("src//resources//logo_4_full.png");
        Image image = i.getImage();
        object.setIconImage(image);
    }
}
