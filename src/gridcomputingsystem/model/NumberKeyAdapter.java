/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Filippo-TheAppExpert
 * 
 * This class is used for detecting typed key and consume if the character is not a digit
 */
public class NumberKeyAdapter extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        char typedKey = e.getKeyChar();
        if (!(Character.isDigit(typedKey) || (typedKey == KeyEvent.VK_BACK_SPACE) || (typedKey == KeyEvent.VK_DELETE) || (typedKey == '.'))) {
            JOptionPane.showMessageDialog(null, "Only Number digits only!");
            e.consume();
        }
    }
}
