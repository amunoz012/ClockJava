/* continuation of previous homework with new methods
 *
 *
 *
 *
 *
 * @author Antonio Munoz
 * @version HW 8, #1
 * @bugs
 */



package oop.amunoz.hw8.one;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.TimeZone;

public class ClockFace extends JComponent{

    /**
     * getters and setters
     */
    private static final long serialVersionUID = 4051132060218915341L;
    private int hour, minute, second;
    LocalTime time = LocalTime.now();

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    /*default constructor*/
    public ClockFace() {
        this.hour = time.getHour();
        this.minute = time.getMinute();
        this.second = time.getSecond();

        setPreferredSize(new Dimension(400, 400));
    }


    public ClockFace(int hour, int minute, int second) {
        this.hour = hour;
        if (hour < 0 || hour > 23) {
            hour = time.getHour();
        }

        this.minute = minute;
        if (minute < 0 || hour > 59) {
            hour = time.getMinute();
        }

        this.second = second;
        if (second < 0 || second > 59) {
            hour = time.getSecond();
        }
    }

    /*move time forward by one second, them call repaint*/
    public void tick() {
        for(this.second = 0; this.second < 60; this.second++) {
            JFrame f = new JFrame();
            ClockFace cf = new ClockFace();
            f.add(cf);
            f.getContentPane().isValid();
            f.getContentPane().repaint();

            if (this.second == 60) {
                this.second = 0;
                this.minute++;
            }
            if (this.minute == 60) {
                this.minute = 0;
                this.hour++;
            }
        }
    }

    /*Sets the hour, minute, and second based on local time zone*/
    public void setTimeZone(TimeZone tz) {
        TimeZone.setDefault(tz);
        LocalTime lt = LocalTime.now();
        lt.getHour();
        lt.getMinute();
        lt.getSecond();
        repaint();
        TimeZone.setDefault(tz);
    }

    /*modifies JComponent to display a clock face*/
    public void paintComponent(Graphics arg) {
        BufferedImage bg = null;
        try {
            bg = ImageIO.read(new File("clock.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int w = bg.getWidth(null);
        int h = bg.getHeight(null);

        BufferedImage bi = new
                BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.getGraphics();
        g.drawImage(bg, 0, 0, null);

        g.drawLine(0, 0, 190, 0);

    }
}
