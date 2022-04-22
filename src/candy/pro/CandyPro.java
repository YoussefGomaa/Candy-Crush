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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CandyPro {

    /**
     * @param args the command line arguments
     */

    public static int Select = 0;
    public static void main(String[] args) {
        // TODO code application logic here

        while(true)
        {
            if (Select == 0)
              new menu();
            if(Select == 1)
                new  startgame();
            else if (Select == 2)
                new startgame(1);
            else if (Select == 3)
               new HighestScore();
        }
    }
}
