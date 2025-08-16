/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author melvin
 */
public class FileChooser {

    private final static JFileChooser selector = new JFileChooser();

    static {
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selector.setDialogTitle("Selecciona la carpeta que se usara como persistencia");
    }

    public static String selectPath() {
        final int result = selector.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            final File folder = selector.getSelectedFile();
            final String path = folder.getAbsolutePath();
            System.out.println("Carpeta seleccionada: " + path);
            return path;
        } else {
            System.out.println("Accion cancelada");
            return null;
        }
    }

}
