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
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class grid extends manage
{
    private cell cells[][];//array of buttons
    private int arr[][]; // the main arr
    private int rows,colmn,check_x = -1,check_y = -1;

    public grid(int rows,int colmn,JPanel panel) {

        cells = new cell[rows][colmn];
        arr = new int[rows][colmn];
        this.rows = rows;
        this.colmn = colmn;

        //setting all the values in array = -1
        for(int i=0;i<rows;i++)
            for(int j=0;j<colmn;j++)
                arr[i][j] = -1;

             //create array
             make_first(arr, rows, colmn);

        //draw the buttons
        for(int i=0;i<rows;i++)
            for(int j=0;j<colmn;j++)
                cells[i][j] = new cell(arr[i][j], panel);

    }
   
     public  void check()
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0 ;j < colmn; j++)
            {
                cells[i][j].check_click();
               if(cells[i][j].isChecked() && check_x  == -1)
               {
                   check_x = i;
                   check_y = j;
               }

               //el mkan el dost 3leh mykonsh nafs el button
               else if(cells[i][j].isChecked() && (check_x != i || check_y != j))
               {

                   // el buttons el far2 mbenhom mkan 1
                   if ((i == check_x && Math.abs(j - check_y) == 1) || (j == check_y && Math.abs(i - check_x) == 1))
                   {

                       swapbutton(cells[check_x][check_y], cells[i][j],j!=check_y);
                       swaparr(arr, check_x, check_y, i, j);

                       int no_up = 0, no_down = 0, no_right = 0, no_left = 0;
                       boolean matchfoundboth = false, matchfoundH = false, matchfoundV = false;

                       //first buttom
                       no_up = match_up(arr, check_x, check_y,arr[check_x][check_y]);
                       no_down = match_down(arr, check_x, check_y, rows,arr[check_x][check_y]);
                       no_left = match_left(arr, check_x, check_y, arr[check_x][check_y]);
                       no_right = match_right(arr, check_x, check_y,colmn, arr[check_x][check_y]);

                       if(no_down + no_up - 1 >= 3 && no_left + no_right - 1 >= 3)
                       {
                           matchfoundboth = true;
                           DeleteV(arr,cells,check_x - no_up + 1,check_y,no_down + no_up - 1);
                           DeleteH(arr,cells,check_x,check_y - no_left + 1,no_left + no_right - 1);
                           Matching(arr,cells,rows,colmn);
                       }

                       else if (no_down + no_up - 1 >= 3)
                       {
                           Matching(arr,cells,rows,colmn);
                           matchfoundV = true;
                       }

                       else if (no_left + no_right - 1 >= 3)
                       {
                           Matching(arr,cells,rows,colmn);
                           matchfoundH = true;
                       }

                       //2nd buttom
                       no_up = match_up(arr, i, j,arr[i][j]);
                       no_down = match_down(arr, i, j, rows, arr[i][j]);
                       no_left = match_left(arr, i, j, arr[i][j]);
                       no_right = match_right(arr, i, j,colmn, arr[i][j]);

                       if(no_down + no_up - 1 >= 3 && no_left + no_right - 1 >= 3)
                       {
                           matchfoundboth = true;
                           DeleteV(arr,cells,i - no_up + 1,j,no_down + no_up - 1);
                           DeleteH(arr,cells,i,j - no_left + 1,no_left + no_right - 1);
                           Matching(arr,cells,rows,colmn);
                       }

                       else if (no_down + no_up -1 >= 3)
                       {
                           Matching(arr,cells,rows,colmn);
                           matchfoundV = true;
                       }

                       else if (no_left + no_right -1 >= 3)
                       {
                           Matching(arr,cells,rows,colmn);
                           matchfoundH = true;
                       }

                       //re-swap;
                       if (matchfoundH == false && matchfoundV == false && matchfoundboth == false)
                       {
                           swapbutton(cells[check_x][check_y], cells[i][j],j!=check_y);
                           swaparr(arr, check_x, check_y, i, j);
                       }

                       //***********************************************************************************************
                       //setting the Score for level 1 and 2
                      if (CandyPro.Select == 1)
                      {
                          if (startgame.Score >= 150)
                              startgame.close = true;
                      }
                      else if (CandyPro.Select == 2)
                      {
                          if (startgame.Score >= 300)
                              startgame.close = true;
                      }
                   }
                   //resetting every checked button
                   cells[check_x][check_y].setChecked(false);
                   wait(800);
                   cells[i][j].setChecked(false);
                   check_x = -1;
                   check_y = -1;
               }
            }
        }
    }
}
