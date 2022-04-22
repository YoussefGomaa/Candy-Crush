/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candy.pro;

import java.awt.Color;
import java.awt.Font;
import java.awt.PageAttributes;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author youse
 */
public class stopwatch {
   public static long milescoend = 0;
   public static int scoend = 0;
   public static int minute = 0;
   public static   long time_in_start=System.currentTimeMillis();
   static boolean state = true;
   public  static  JLabel text2=new JLabel("00 :"), text3=new JLabel("00 :");
    stopwatch(JPanel panel2){
        Font f=new Font("Arial", Font.BOLD, 30);
        
         text2 = new JLabel("00 :");
         text3 = new JLabel("00 :");
       
        JLabel Time=new JLabel("Time: ");
        Time.setForeground(Color.gray);
        text2.setForeground(Color.gray);
        text3.setForeground(Color.gray);
   
       // JLabel score=new JLabel("\t \t \t \t \t \t \t \t \t \t \t \t \t \t score: "+startgame.scoor);

        Time.setFont(f);
        panel2.add(Time);
        
        text2.setFont(f);
        panel2.add(text2);
        text3.setFont(f);
        panel2.add(text3);
       
       // score.setFont(f);
        //panel2.add(score);
      // text4.setText(" : "+milescoend);
       text3.setText(" : "+scoend);
       text2.setText(""+ minute);
       time_in_start=System.currentTimeMillis();
          }
     public static void set_time(){
      
         milescoend+=System.currentTimeMillis()-time_in_start;
         if(milescoend>=1e3)
         {
             scoend++;
             milescoend=0;
         }
         if(scoend>=60)
         {
             scoend=0;
             minute++;
         }
    
       text3.setText(" : "+scoend);
       text2.setText(""+minute);      
       time_in_start = System.currentTimeMillis();
     }
     public static void resetclock ()
     {
         milescoend = 0;
         scoend = 0;
         minute = 0;
     }
}
