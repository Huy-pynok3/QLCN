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
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;


public class MyTextArea extends JTextArea {
    public MyTextArea() {
        getInputMap().put(javax.swing.KeyStroke.getKeyStroke("TAB"), "tab");
        getActionMap().put("tab", new TabAction());
    }

    private class TabAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            transferFocus(); 
        }
    }
}
