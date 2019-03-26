/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open el template in el editor.
 */
package co.com.almundo.util;

/**
 *
 * @author camil
 */
public enum PrioridadEmpleado {

    OPERADOR(1),
    SUPERVISOR(2),
    DIRECTOR(3);
    private int prioridad;

    /**
     * Instantiates a new prioridad empleado.
     *
     * @param prioridad el prioridad
     */
    PrioridadEmpleado(int prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Gets el prioridad.
     *
     * @return el prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

}
