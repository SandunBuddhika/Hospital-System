package model;

import java.awt.Font;
import java.io.File;

public class Set_Font {

    public static byte BOLD = 1;
    public static byte MEDIUM = 2;
    public static byte REGULAR = 3;

    public static Font setFont(float f, byte i) {
        Font sizedFont = null;
        try {
            if (i == BOLD) {
                File font_file = new File("src//resources//Poppins-Medium.ttf");
                Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
                sizedFont = font.deriveFont(f);
            } else if (i == MEDIUM) {
                File font_file = new File("src//resources//Poppins-Regular.ttf");
                Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
                sizedFont = font.deriveFont(f);
            } else if (i == REGULAR) {
                File font_file = new File("src//resources//Poppins-Regular.ttf");
                Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
                sizedFont = font.deriveFont(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sizedFont;
    }
}
