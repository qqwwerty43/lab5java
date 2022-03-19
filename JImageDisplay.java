package com.company;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import java.awt.Graphics;

public class JImageDisplay extends javax.swing.JComponent{

    /** Экземпляр изображения **/
    private BufferedImage ScreenImage;

    /**
     * Метод, необходимый для получения изображения из другого класса
     **/
    public BufferedImage getImage() {
        return ScreenImage;
    }

    /** Ширина изображения **/
    public int width;

    /** Высота изображения **/
    public int height;

    /**
     * Конструктор класса
     **/
    public JImageDisplay(int target_width, int target_height) {
        this.ScreenImage = new BufferedImage(target_width, target_height, BufferedImage.TYPE_INT_RGB);
        Dimension size = new Dimension(target_width, target_height);
        setPreferredSize(size);
    }

    /**
     * Переопределенный метод, который позволяет изображению перерисовать себя
     **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ScreenImage, 0, 0, ScreenImage.getWidth(), ScreenImage.getHeight(), null);
    }

    /**
     * Метод, делающий изображение полностью черным
     **/
    public void clearImage() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.ScreenImage.setRGB(x, y, 0);
            }
        }
    }

    /**
     * Метод, задающий заданному пикселю заданный цвет
     **/
    public void drawPixel(int x, int y, int rgbColor) {
        this.ScreenImage.setRGB(x, y, rgbColor);
    }
}
