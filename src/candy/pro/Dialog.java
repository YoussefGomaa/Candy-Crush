/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candy.pro;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author youse
 */
public class Dialog {
    JFrame f;
    private static String  name;
    private long last_score = 0;
    private long curr_score = 0;

    // first dialog to enter your name
    public Dialog() {
        f = new JFrame("Candy Crush");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

        while (name == null || name.isEmpty())
        {
            name = JOptionPane.showInputDialog(f, "Enter your name");
        }
        f.dispose();
    }

    // 2nd dialog after you win the game
   public Dialog(int x)
   {
       high_score(CandyPro.Select);
       f = new JFrame("Candy Crush");
       f.setSize(300, 300);
       f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
       int input = JOptionPane.showConfirmDialog(f, "Well Done! " + name + " Your score is " + x + " in time " + stopwatch.minute + ":" + stopwatch.scoend + ":" + stopwatch.milescoend + " Do you want to play lvl 2 ", "GameEnd", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

       //navigate between the game
       if (CandyPro.Select == 1)
       {
           if (input == 0)
               CandyPro.Select = 2;
           else if (input == 1)
               CandyPro.Select = 0;
               f.setVisible(false);
       }
       else if (CandyPro.Select == 2)
       {
           if (input == 0)
               CandyPro.Select = 0;
           else if (input == 1)
               System.exit(1);
       }
   }



    //adding the best score and best time to the file
    void high_score(int x)
    {
        String data = "";
        try{
            File my;
            if(x==1)
            {
                my = new File("E:\\Games\\Candy2\\candy_28-3\\time.txt");
            }
            else
            {
                my = new File("E:\\Games\\Candy2\\candy_28-3\\time2.txt");
            }
            Scanner myreader = new Scanner(my);
            while(myreader.hasNextLine())
                data = myreader.nextLine();
            last_score=Integer.parseInt(data);
            myreader.close();
        }
        catch (Exception e)
        {

        }

        curr_score=(stopwatch.minute*60)+stopwatch.scoend+(stopwatch.milescoend/1000);
        if(curr_score < last_score||last_score==0)
        {
            try{
                FileWriter w;
                if(x == 1)
                    w = new FileWriter("E:\\Games\\Candy2\\candy_28-3\\score.txt");
                else
                    w = new FileWriter("E:\\Games\\Candy2\\candy_28-3\\score2.txt");
                w.write(name + "  " + stopwatch.minute+":"+stopwatch.scoend+":"+stopwatch.milescoend);
                w.close();
                FileWriter t;
                if(x == 1)
                    t = new FileWriter("E:\\Games\\Candy2\\candy_28-3\\time.txt");
                else
                    t = new FileWriter("E:\\Games\\Candy2\\candy_28-3\\time2.txt");
                String s = String.valueOf(curr_score);
                t.write(s);
                t.close();
            }
            catch(Exception e)
            {

            }
        }
    }
}
