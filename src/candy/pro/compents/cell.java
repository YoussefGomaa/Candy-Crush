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
/*
*/
public class cell extends spot{
    private boolean checked = false;
    public cell(int candynum,JPanel panel) 
    {
        super(candynum);
        panel.add(button);
    }
    public void check_click()
    {
        button.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               checked = true;
//To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
