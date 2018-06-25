/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.windows;

/**
 *
 * @author arvraepe
 */
public interface IScreenEntity {

    public int getWidth();

    public int getHeight();

    public IScreenEntity copy();

    public void clear(int color);

    public IScreenEntity shrink();

    public IScreenEntity scaleBitmap(int width, int height);

    public int getPixel(int pos);
    public int getPixelSize();
    public void setPixel(int pos, int color);
    
}
