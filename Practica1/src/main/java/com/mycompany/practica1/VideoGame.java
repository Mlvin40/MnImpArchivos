/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1;

import java.io.Serializable;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author melvin
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class VideoGame implements Serializable {

    private final UUID id;
    private String tittle;
    private int hoursPlayed;
    private boolean completed;

    public VideoGame(String title, int hoursPlayed, boolean completed) {
        this.id = UUID.randomUUID();
        this.tittle = title;
        this.hoursPlayed = hoursPlayed;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return this.id + " " + this.tittle + " "
                + " - " + this.hoursPlayed
                + " - " + (this.completed ? "Completado" : "Incompleto");
    }

}
