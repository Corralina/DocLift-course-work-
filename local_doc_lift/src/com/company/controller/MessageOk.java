package com.company.controller;

import javax.swing.*;

public class MessageOk extends JDialog {
    private static final long serialVersionUID = 1357221208964337731L;
    private static String[] button = new String[]{"Ok"};
    static int mess;

    public MessageOk() {
    }

    public static Integer getMessage(String message) {
        mess = JOptionPane.showOptionDialog(new JDialog(), message, "INFO", 0, 1, (Icon)null, button, (Object)null);
        return mess;
    }
}