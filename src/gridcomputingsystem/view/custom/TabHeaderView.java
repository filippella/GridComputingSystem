/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.view.custom;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class TabHeaderView extends JPanel {

    public TabHeaderView(TabActionListener listener, Component tab, String title) {
        setOpaque(false);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
        setLayout(flowLayout);
        add(new JLabel(new ImageIcon(getClass().getResource("/gridcomputingsystem/view/images/save.png"))));
        add(new JLabel(title));
        JLabel button = new JLabel(new ImageIcon(getClass().getResource("/gridcomputingsystem/view/images/close_tab.png")));
        button.addMouseListener(new CloseListener(tab, listener));
        add(button);
    }

    private class CloseListener implements MouseListener {

        private final Component tab;
        private final TabActionListener listener;

        private CloseListener(Component tab, TabActionListener listener) {
            this.tab = tab;
            this.listener = listener;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JLabel) {
                JLabel clickedButton = (JLabel) e.getSource();
                JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
                tabbedPane.remove(tab);
                this.listener.onClose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //TODO Implement the logic here
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //TODO Implement the logic here
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //TODO Implement the logic here
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //TODO Implement the logic here
        }
    }

    public interface TabActionListener {

        void onClose();
    }
}
