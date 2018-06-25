/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.windows;

import java.awt.Color;

/**
 *
 * @author arvraepe
 */
public class GameColor {
    
    public static final int background = argb("#FEFEFE");
    public static final int foreground = argb("#111111");
    
    public static int argb(String hex) {
        return argb(Color.decode(hex));
    }
    
    public static int argb(Color color) {
        return argb(color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue());
    }
    
    public static int argb(int a, int r, int g, int b){             
        return ((byte) a << 24) + (((byte) r & 0xFF) << 16) + (((byte) g & 0xFF) << 8) + ((byte) b & 0xFF);  
    }
    
}