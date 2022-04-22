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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class  spot {
   protected int candynum;
   protected JButton button;

    public spot(int candynum) {
        this.candynum = candynum;
        button = manage.icon_button(candynum);
    }

    public JButton getButton() {

        return button;
    }

    public void setButton(JButton button) {

        this.button = button;
    }

    public int getCandynum() {

        return candynum;
    }

    //override functions
    public abstract void check_click();
    public abstract boolean isChecked();
    public abstract void setChecked(boolean checked);
}
