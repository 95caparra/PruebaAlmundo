/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open el template in el editor.
 */
package co.com.almundo.pruebas;

import co.com.almundo.principal.Dispacher;
import co.com.almundo.util.Director;
import co.com.almundo.util.Empleado;
import co.com.almundo.util.Llamada;
import co.com.almundo.util.Asesor;
import co.com.almundo.util.Supervisor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author camil
 */
public class TestUnitario {
    
    /**
	 * Diez llamadas concurrentes.
	 *
	 * @throws InterruptedException
	 *             el interrupted exception
	 */
	@Test
	public void diezLlamadasConcurrentes() throws InterruptedException {
		System.out.println("....... TEST 1 -> 10 llamadas concurrentes 2 operadores , 1 supervisor, 1 director  .......");
		BlockingQueue<Empleado> empleados = new PriorityBlockingQueue<Empleado>();
		Empleado asesor1 = new Asesor("Maicol Asesor");
		Empleado asesor2 = new Asesor("Jesus Asesor");
		Empleado supervisor = new Supervisor("Alejandra Supervisora");
		Empleado director = new Director("Andres Director");

		empleados.put(supervisor);
		empleados.put(director);
		empleados.put(asesor1);
		empleados.put(asesor2);

		List<Llamada> llamadasConcurrentes = new ArrayList<Llamada>();

		for (int i = 0; i < 10; i++) {
			llamadasConcurrentes.add(new Llamada());
		}

		Dispacher dispacher = Dispacher.getIstance();
		dispacher.setEmpleadosDisponibles(empleados);

		for (Llamada llamada : llamadasConcurrentes) {
			dispacher.dispatchCall(llamada);

		}

		sleep(25);

		assertEquals(0, dispacher.cantidadDeLLamadasRestantes());
	}
        
        @Test
	public void muchosEmpleadosMuchasLLamadas() throws InterruptedException {
		System.out.println("....... TEST 2 -> muchos empleados - llamadas, 10 operadores, 5 supervisores, 2 directores .......");

		BlockingQueue<Empleado> empleados = new PriorityBlockingQueue<Empleado>();
		Empleado asesor1 = new Asesor("Pedro Asesor");
		Empleado asesor2 = new Asesor("Juan Asesor");
		Empleado asesor3 = new Asesor("Luis Asesor");
		Empleado asesor4 = new Asesor("Diego Asesor");
		Empleado asesor5 = new Asesor("Angel Asesor");
		Empleado asesor6 = new Asesor("Miguel Asesor");
		Empleado asesor7 = new Asesor("Gensis Asesora");
		Empleado asesor8 = new Asesor("Laura Asesora");
		Empleado asesor9 = new Asesor("Marta Asesora");
		Empleado asesor10 = new Asesor("Juan Pablo Asesor");
		Empleado supervisor = new Supervisor("Alejandra Supervisora");
                Empleado supervisor1 = new Supervisor("Juan Supervisor");
                Empleado supervisor2 = new Supervisor("Carlos Supervisor");
                Empleado supervisor3 = new Supervisor("Pepito Supervisor");
                Empleado supervisor4 = new Supervisor("Ruben Supervisor");
		Empleado director = new Director("Carlos Director");
                Empleado director1 = new Director("Ricardo Director");
                

		empleados.put(supervisor);
                empleados.put(supervisor1);
                empleados.put(supervisor2);
                empleados.put(supervisor3);
                empleados.put(supervisor4);
		empleados.put(director);
		empleados.put(director1);
		empleados.put(asesor1);
		empleados.put(asesor2);
		empleados.put(asesor3);
		empleados.put(asesor4);
		empleados.put(asesor5);
		empleados.put(asesor6);
		empleados.put(asesor7);
		empleados.put(asesor8);
		empleados.put(asesor9);
                empleados.put(asesor10);

		List<Llamada> llamadasConcurrentes = new ArrayList<Llamada>();

		for (int i = 0; i < 15; i++) {
			llamadasConcurrentes.add(new Llamada());
		}

		Dispacher dispacher = Dispacher.getIstance();
		dispacher.setEmpleadosDisponibles(empleados);

		for (Llamada llamada : llamadasConcurrentes) {
			dispacher.dispatchCall(llamada);

		}

		sleep(25);

		assertEquals(0, dispacher.cantidadDeLLamadasRestantes());
	}

	/**
	 * Sleep. duerme el hilo principal tantos segundos. el dispacher es un hilo
	 * aparte da tiempo para que el hilo dispacher a que termine sus tareas
	 * 
	 * @param seconds
	 * 
	 */
	private void sleep(int seconds) {

		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
}
