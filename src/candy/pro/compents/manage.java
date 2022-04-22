//asf
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candy.pro.compents;

/**
 *
 * @author youssef
 */
import candy.pro.CandyPro;
import candy.pro.startgame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public abstract class  manage {

    private static Icon icon[] = {
            new ImageIcon("1.png"),
            new ImageIcon("2.png"),
            new ImageIcon("3.png"),
            new ImageIcon("4.png"),
            new ImageIcon("5.png"),
            new ImageIcon("6.png")};

    //Drawing the grid and it's icons
    public static JButton icon_button(int candynum)
    {
        //byrasam el image 3la button
        JButton button = new JButton(icon[candynum]);
        button.setSize(30,20);
        button.setOpaque(false);


        //delete style of button
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }
    public static void make_first(int arr[][],int row,int colm)
    {
        Random rand = new Random();

        for (int i=0;i<row;i++)
        {
            for (int j = 0; j < colm; j++)
            {
             
                int n ;
                if(CandyPro.Select == 1)
                    n = rand.nextInt(4);
                else
                    n = rand.nextInt(6);

                // grid random without matching
                while (match_first(arr,i,j,n))
                {
                    if(CandyPro.Select==1)
                        n = rand.nextInt(4);
                    else
                        n = rand.nextInt(6);
                }

                arr[i][j] = n;
            }

        }
    }
    public  static  boolean match_first(int arr[][],int i,int j,int candynum)
    {

        if (match_left(arr, i, j,candynum) >= 3)
            return true;
        else if (match_up(arr, i, j,candynum) >= 3)
            return true;
        else
            return false;

    }

     //*****************************************************************************************************************
    //Checking if there is a match after swapping or not
    public static Integer match_right(int arr[][],int indx,int indy,int colmn,int image)
    {
        int counter=1;
        for(int j = indy+1; j < colmn ;j++)
        {
            if(image == arr[indx][j])
               counter++;
        else
            break;
        }
        return counter;
    }
    public static Integer match_left(int arr[][],int indx,int indy,int image)
    {
        int counter = 1;
        for(int j = indy-1; j >= 0 ;j--)
        {
            if(image == arr[indx][j])
                  counter++;
        else
            break;
        }
        return counter;
    }
    public static Integer match_down(int arr[][],int indx,int indy,int rows,int image)
    {
        int counter = 1;
        for(int j = indx+1; j < rows ;j++)
        {
            if(image == arr[j][indy])
               counter++;
        else
            break;
        }
        return counter;
    }
    public static Integer match_up(int arr[][],int indx,int indy,int image)
    {
        int counter=1;
        for(int j = indx-1 ;j >= 0 ;j--)
        {
            if(image == arr[j][indy])
              counter++;
        else
            break;
        }
        return counter;
    }

    //******************************************************************************************************************
    //Matching
    public static void Matching(int arr[][],cell cells[][],int rows,int colmn)
    {
        while (true)
        {
            boolean ExistH,ExistV;
            ExistH = whileH(arr,cells,rows,colmn);
            ExistV = whileV(arr,cells,rows,colmn);
            if (!ExistH && !ExistV)
                break;
        }
    }


    //Delete if there a match in rows
    //******************************************************************************************************************
    public static void DeleteH (int arr[][], cell c[][],int row,int col,int no_match)
    {
        Random rand = new Random();
        int n ;
        startgame.Score += no_match;
        for(int i = col; i <= col + no_match - 1 ;i++)
        {
            if(CandyPro.Select==1)
                n = rand.nextInt(4);
            else
                n = rand.nextInt(6);
            c[row][i].getButton().setIcon(icon[n]);
            arr[row][i] = n;
        }
        wait(300);
    }

    public static boolean matchH(int arr[][],cell c[][],int row,int col)
    {
        int n = 0;
        int image = -1;
        boolean matching = false;

        for(int i = 0; i < col;i++ )
        {
            if(arr[row][i] == image)
            {
                n++;
            }
            else
            {
                if(n > 2)
                {
                    matching = true;
                    DeleteH(arr,c,row,i-n,n);
                    i = -1;
                    n = 0;
                    image = -1;
                    continue;
                }
                else
                {
                    n = 1;
                    image = arr[row][i];
                }
            }
            if(i == col-1 && n > 2)
            {
                matching = true;
                DeleteH(arr,c,row,i-n +1,n);
                i = -1;
                n = 0;
                image = -1;
                continue;
            }
        }
        return matching;
    }

    public static boolean whileH(int arr[][],cell c[][],int rows,int col)
    {
        boolean ExistMatch,MatchV = false;
        while (true)
        {
            ExistMatch = false;
            for(int l = 0; l < rows ; l++)
            {
                if(matchH(arr,c,l,col))
                {
                    MatchV = true;
                    ExistMatch = true;
                }
            }
            // when there is no match
            if(!ExistMatch)
                break;
        }
        return MatchV;
    }

    //******************************************************************************************************************
    //Finding the match in column and delete it
    public static void DeleteV (int arr[][], cell c[][],int row,int col,int no_match)
    {
        Random rand = new Random();
        int n;
        startgame.Score += no_match;
        for(int i = row  ; i <= row + no_match - 1;i++)
        {
            if(CandyPro.Select==1)
                n = rand.nextInt(4);
            else
                n = rand.nextInt(6);
            c[i][col].getButton().setIcon(icon[n]);
            arr[i][col] = n;
        }
        wait(300);

    }

    public static boolean matchV(int arr[][],cell c[][],int col,int rows )
    {
        int n = 0;
        int image = -1;
        boolean Matching = false;
        for(int i = 0; i < rows;i++ )
        {
            if(arr[i][col] == image)
            {
                n++;
            }
            else
            {
                if(n > 2)
                {
                    Matching = true;
                    DeleteV(arr,c,i-n,col,n);

                    i = -1;
                    n = 0;
                    image = -1;
                    continue;
                }
                else
                {
                    n = 1;
                    image = arr[i][col];
                }
            }
            if(i == rows - 1 && n > 2)
            {
                Matching = true;
                DeleteV(arr,c,i-n+1,col,n);
                i = -1;
                n = 0;
                image = -1;
                continue;
            }
        }
        return Matching;
    }

    public static boolean whileV(int arr[][],cell c[][], int rows,int col)
    {
        boolean ExistMatch, MatchH = false;
        while (true)
        {
            ExistMatch = false ;
            for(int l = 0; l < col ; l++) {
                if (matchV(arr, c, l,rows))
                {
                    MatchH = true;
                    ExistMatch = true;
                }

            }
            if(!ExistMatch)
                break;
        }
        return MatchH;
    }

    //******************************************************************************************************************
    //Swapping buttons and anitmations
    public static void swapbutton (cell c1,cell c2,boolean xpos_diff)
    {
          JButton a,b;
        if(xpos_diff)
        {
            if(c1.getButton().getLocation().x < c2.getButton().getLocation().x)
            {
                a = c1.getButton();
                b = c2.getButton();
            }
            else
            {
                a = c2.getButton();
                b = c1.getButton();
            }
            int counter = 0;
            while(counter < 5)
            {
                a.setLocation(a.getLocation().x+8,a.getLocation().y );
                b.setLocation(b.getLocation().x-8,b.getLocation().y );
                counter++;
                wait(65);
            }
        }
        else
        {
            if(c1.getButton().getLocation().y<c2.getButton().getLocation().y)
            {
                a=c1.getButton();
                b=c2.getButton();
            }
            else
            {
                a = c2.getButton();
                b = c1.getButton();
            }

            int counter = 0;
            while(counter < 6)
            {
                a.setLocation(a.getLocation().x,a.getLocation().y+6 );
                b.setLocation(b.getLocation().x,b.getLocation().y-6 );
                counter++;
                wait(50);
            }
        }


        Icon i = c1.getButton().getIcon();
        c1.getButton().setIcon(c2.getButton().getIcon());
        c2.getButton().setIcon(i);

        if(xpos_diff)
        {
            int counter = 0;
            while(counter < 5)
            {
                a.setLocation(a.getLocation().x-8,a.getLocation().y );
                b.setLocation(b.getLocation().x+8,b.getLocation().y );
                counter++;
                wait(65);
            }
        }
        else
        {
            int counter = 0;
            while(counter < 6)
            {
                a.setLocation(a.getLocation().x,a.getLocation().y-6 );
                b.setLocation(b.getLocation().x,b.getLocation().y +6);
                counter++;
                wait(50);
            }
        }

    }

    //***************************************************************************************************************
    //Swapping arr values
    public static void swaparr (int arr[][],int x1,int y1,int x2,int y2)
    {
        int image = arr[x1][y1];
        arr[x1][y1] = arr [x2][y2];
        arr[x2][y2] = image;
    }

    //*****************************************************************************************************************
    //wait function for animation
    public static void wait(int ms)
    {
       long  time_bef=System.currentTimeMillis();
       while(true)
       {
           if(System.currentTimeMillis()-time_bef>=ms)
               break;
       }
       
    }

}
