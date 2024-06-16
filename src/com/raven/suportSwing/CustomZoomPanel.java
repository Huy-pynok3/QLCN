/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.suportSwing;

/**
 *
 * @author T14
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class CustomZoomPanel extends JPanel {
    private double scaleFactor = 1.0;
    private JPanel contentPanel;

    public CustomZoomPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        setupKeyBindings();
    }

    private void setupKeyBindings() {
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.CTRL_DOWN_MASK), "zoomIn");
        actionMap.put("zoomIn", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoomIn();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK), "zoomOut");
        actionMap.put("zoomOut", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoomOut();
            }
        });
    }

    public void zoomIn() {
        scaleFactor += 0.1;
        revalidate();
        repaint();
    }

    public void zoomOut() {
        scaleFactor = Math.max(0.1, scaleFactor - 0.1);
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform at = g2.getTransform();
        at.scale(scaleFactor, scaleFactor);
        g2.setTransform(at);
        contentPanel.paint(g2);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = contentPanel.getPreferredSize();
        return new Dimension((int) (d.width * scaleFactor), (int) (d.height * scaleFactor));
    }
}

