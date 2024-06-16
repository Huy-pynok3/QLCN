
package com.raven.suportSwing;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author T14
 */
public class ZoomHandler extends KeyAdapter {
    private JFrame frame;
    private int zoomLevel = 100; // Kích thước ban đầu là 100%

    public ZoomHandler(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()) {
            if (e.getKeyCode() == KeyEvent.VK_EQUALS || e.getKeyCode() == KeyEvent.VK_PLUS) {
                zoomIn();
            } else if (e.getKeyCode() == KeyEvent.VK_MINUS) {
                zoomOut();
            }
        }
    }

    private void zoomIn() {
        zoomLevel += 10;
        resizeComponents();
    }

    private void zoomOut() {
        zoomLevel -= 10;
        resizeComponents();
    }

    private void resizeComponents() {
        Component[] components = frame.getContentPane().getComponents();
        for (Component component : components) {
            component.setFont(component.getFont().deriveFont((float) zoomLevel));
        }
        frame.revalidate();
        frame.repaint();
    }
}