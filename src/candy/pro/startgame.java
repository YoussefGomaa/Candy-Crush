/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candy.pro;

/**
 *
 * @author youssef
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import candy.pro.compents.grid;

public class startgame {
    JFrame gframe;
    grid gr;
    private int wantrows,wantcolmn;
    public static int Score = 300;
    public static boolean close = false;

    //level 1
    public startgame() 
    {
        wantrows = 7;
        wantcolmn = 6;
        close = false;
        stopwatch.resetclock();
        gframe = new JFrame();
        gframe.setSize(1920, 1080);
        gframe.setLayout(new FlowLayout());
        gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        //background
        try {
            gframe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("play.png")))));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3=new JPanel();

        //buttons
        panel.setBounds(375,120,500,500);
        //stopwatch
        panel2.setBounds(37,440,340,50);
        //score
        panel3.setBounds(27,200,350,50);

        Font f = new Font("Arial", Font.BOLD, 30);
         
        panel.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);

        new Dialog();
        gr = new grid(wantrows,wantcolmn,panel);

       //*****************************************
       new stopwatch(panel2);
       JLabel s = new JLabel("Score: " + Score);
       s.setForeground(Color.gray);
       s.setFont(f);
       panel3.add(s);
        
       //******************************************
         gframe.add(panel);
         gframe.add(panel2);
         gframe.add(panel3);
         gframe.setVisible(true);

         //InGame
         while (true)
         {
          gr.check();
          s.setText("Score " + Score);
          stopwatch.set_time();

          if(close)
          {
              stopwatch.state = false;
              new Dialog(Score);
              gframe.dispose();
              Score = 0;
              break;
          }
        }
    }
    public startgame(int x)
    {
        wantrows = 8;
        wantcolmn = 8;
        close = false;
        gframe = new JFrame();
        stopwatch.resetclock();
        gframe.setSize(1920, 1080);
        gframe.setLayout(new FlowLayout());
        gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //background
        try {
            gframe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("play2.jpg")))));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3=new JPanel();

        //buttons
        panel.setBounds(375,120,80*wantcolmn,72*wantrows);
        //stopwatch
        panel2.setBounds(37,440,340,50);
        //score
        panel3.setBounds(27,200,350,50);

        Font f = new Font("Arial", Font.BOLD, 30);

        panel.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);


        new Dialog();
        gr = new grid(wantrows,wantcolmn,panel);

        //*****************************************
        new stopwatch(panel2);
        JLabel s = new JLabel("Score: " + Score);
        s.setForeground(Color.gray);
        s.setFont(f);
        panel3.add(s);

        //******************************************
        gframe.add(panel);
        gframe.add(panel2);
        gframe.add(panel3);
        gframe.setVisible(true);

        while (true)
        {
            gr.check();
            s.setText("Score " + Score);
            stopwatch.set_time();
            if(close)
            {
                stopwatch.state = false;
                new Dialog(Score);
                gframe.dispose();
                Score = 0;
                break;
            }
        }
    }

}
