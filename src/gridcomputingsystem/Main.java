/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem;

import de.muntjak.tinylookandfeel.TinyLookAndFeel;
import gridcomputingsystem.view.MainView;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(new TinyLookAndFeel());
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView mainView = new MainView();
                mainView.setTitle("Grid Computing System");
                mainView.setIconImage(new ImageIcon(getClass().getResource("/gridcomputingsystem/view/images/icon.png")).getImage());
                mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainView.setLocationRelativeTo(null);
                mainView.setExtendedState(Frame.MAXIMIZED_BOTH);
                mainView.setVisible(true);
            }
        });
    }
}
