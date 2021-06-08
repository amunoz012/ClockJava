 /* set the main window and add clockface to the set of window components
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimeZone;

public class ClockFrame extends JFrame {
    private ClockFace clock;

    private JLabel tzLabel;

    public ClockFrame(){
        super("Clock");
        TimeZone tzName = TimeZone.getDefault();
        String nametz = tzName.getDisplayName();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel(nametz, SwingConstants.LEFT);
        label.setFont(new Font("sans-serif", Font.BOLD, 24));
        JButton TMZ1, TMZ2, TMZ3;
        TMZ1 = new JButton("America/Denver");
        TMZ2 = new JButton("Europe/London");
        TMZ3 = new JButton("Asia/Taipei");
        ClockFace clockFace = new ClockFace();
        JPanel buttonPane = new JPanel();
        buttonPane.setSize(400, 100);
        buttonPane.add(TMZ1);
        buttonPane.add(TMZ2);
        buttonPane.add(TMZ3);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(clockFace);
        container.add(buttonPane, BorderLayout.SOUTH);


        ActionListener al1 = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TimeZone newT = TimeZone.getTimeZone("America/Denver");
                clockFace.setTimeZone(newT);
                String srt = newT.getDisplayName();
                JLabel alabel = new JLabel(srt);
                alabel.setFont(new Font("sans-serif", Font.BOLD, 24));
                container.add(alabel);
            }
        };


        ActionListener al2 = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TimeZone newT = TimeZone.getTimeZone("Europe/London");
                clockFace.setTimeZone(newT);
                String srt = newT.getDisplayName();
                JLabel blabel = new JLabel(srt);
                blabel.setFont(new Font("sans-serif", Font.BOLD, 24));
                container.add(blabel);
            }
        };


        ActionListener al3 = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                TimeZone newT = TimeZone.getTimeZone("Asia/Taipei");
                clockFace.setTimeZone(newT);
                String srt = newT.getDisplayName();
                JLabel clabel = new JLabel(srt);
                clabel.setFont(new Font("sans-serif", Font.BOLD, 24));
                container.add(clabel);
            }
        };


        TMZ1.addActionListener(al1);
        TMZ2.addActionListener(al2);
        TMZ3.addActionListener(al3);
        add(container);
        Timer timer = new Timer(1000, al1);
        pack();
    }

    public static void main(String[] args){
        oop.amunoz.hw8.one.ClockFrame window = new oop.amunoz.hw8.one.ClockFrame();
        EventQueue.invokeLater(() -> window.setVisible(true));
    }
}
