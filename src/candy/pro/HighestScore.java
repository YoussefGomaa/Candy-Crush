package candy.pro;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HighestScore {
    JFrame Highframe;
    private boolean InHighscore = true;
    private String data = "",data2 = "";
 public HighestScore()
   {
      Highframe = new JFrame();
     Highframe.setSize(1920, 1080);
     Highframe.setLayout(new FlowLayout());
     Highframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       try {
           Highframe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg")))));
       } catch (IOException e) {
           e.printStackTrace();
       }


          JPanel panel = new JPanel();
          Font f = new Font("Arial", Font.BOLD, 30);
          panel.setBounds(440,350,600,100);
          panel.setOpaque(false);

          //Button
          JButton Return = new JButton("Return to menu");
          Return.setBounds(625, 460, 220, 50);
          Return.setBorderPainted(false);

         try {
          File my = new File("E:\\Games\\Candy2\\candy_28-3\\score.txt");
          Scanner myreader = new Scanner(my);
          while (myreader.hasNextLine())
              data = myreader.nextLine();
          myreader.close();
         } catch (Exception e) {
          System.out.println("NO more files");
         }

          //Label
         JLabel label = new JLabel("Highest Score in level 1 : " + data);
         label.setForeground(Color.BLACK);
         label.setFont(f);

          try {
           File my = new File("E:\\Games\\Candy2\\candy_28-3\\score2.txt");
           Scanner myreader = new Scanner(my);
           while (myreader.hasNextLine())
               data2 = myreader.nextLine();
           myreader.close();
           } catch (Exception e) {
           System.out.println("NO more files");
           }

           JLabel label2 = new JLabel("Highest Score in level 2 : " + data2);
           label2.setForeground(Color.BLACK);
           label2.setFont(f);
           panel.add(label);
           panel.add(label2);


       //drawing the frame
            Highframe.add(panel);
            Highframe.add(Return);
            Highframe.setVisible(true);

     while (InHighscore)
     {
         Return.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 CandyPro.Select = 0;
                 InHighscore = false;
                 Highframe.setVisible(false);
             }
         });
     }
   }
}
