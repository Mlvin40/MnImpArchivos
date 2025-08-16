/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melvin
 */
public class VideoGameService {
    
        private List<VideoGame> games = new ArrayList<>();
    private final String filePath;

    public VideoGameService(String filePath) {
        this.filePath = filePath + File.separator + "video-games.meida";
        this.loadData();
    }

    private void saveInFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(this.games);
        } catch (IOException e) {
            System.err.println("Error guardando archivo: \n" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<VideoGame> returnVideoGameList(Object object) {
        if (!(object instanceof List<?>)) return null;
        final List<?> list = (List<?>) object;
        for (Object item : list) {
            if (!(item instanceof VideoGame)) return null;
        }
        return (List<VideoGame>) list;
    }

    private void loadData() {
        final File file = new File(filePath);
        if (file.exists()) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                final Object object = objectInputStream.readObject();
                final List<VideoGame> list = returnVideoGameList(object);
                if (list == null) {
                    System.out.println("No es una lista de juegos.");
                    return;
                }
                this.games = list;
                System.out.println("Datos cargados con exito.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Hubo un error al cargar el archivo: \n" + e.getMessage());
            }
        } else {
            System.out.println("No existe un archivo de persistencia.");
        }
    }
    
}
