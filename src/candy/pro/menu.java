package candy.pro;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class menu {

    private JFrame frame;
    private boolean InMenu = true;
    menu() {
        frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JButton StartB = new JButton("Level 1");
        StartB.setBounds(700, 350, 100, 50);

        JButton HighScore = new JButton("HighestScore");
        HighScore.setBounds(700, 500, 100, 50);

        JButton Level2 = new JButton("Leve2");
        Level2.setBounds(700, 425, 100, 50);
        JButton ExitB = new JButton("Exit");
        ExitB.setBounds(700, 570, 100, 50);

        frame.add(StartB);
        frame.add(Level2);
        frame.add(ExitB);
        frame.add(HighScore);
        frame.setVisible(true);

        while(InMenu)
        {
            StartB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    InMenu = false;
                    CandyPro.Select = 1;

                }
            });
            Level2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    InMenu = false;
                    CandyPro.Select = 2;
                }
            });
            HighScore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent s) {
                    frame.setVisible(false);
                    InMenu = false;
                    CandyPro.Select = 3;
                }
            });
            ExitB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    System.exit(1);
                }
            });
        }
    }
}

