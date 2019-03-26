/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open el template in el editor.
 */
package co.com.almundo.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author camil
 */
public class Llamada {

    /**
     * el Constant MIN_DURACION.
     */
    private static final int MIN_DURACION = 5;

    /**
     * el Constant MAX_DURACION.
     */
    private static final int MAX_DURACION = 10;

    /**
     * el duracion.
     */
    private int duracion;

    /**
     * Instantiates a new llamada.
     */
    public Llamada() {
        duracion = (ThreadLocalRandom.current().nextInt(MIN_DURACION, MAX_DURACION + 1)) * 1000;
    }

    /**
     * Gets el duracion.
     *
     * @return el duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Sets el duracion.
     *
     * @param duracion el new duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
