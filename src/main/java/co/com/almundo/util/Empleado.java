package co.com.almundo.util;

/**
 *
 *  @author camil
 */
public class Empleado implements Runnable, Comparable<Empleado> {

	/** el prioridad. */
	private PrioridadEmpleado prioridad;
	
	/** el llamada. */
	private Llamada llamada;
	
	/** el nombre. */
	private String nombre;

	/**
	 * Instantiates a new empleado.
	 *
	 * @param prioridad el prioridad
	 * @param llamada el llamada
	 * @param nombre el nombre
	 */
	public Empleado(PrioridadEmpleado prioridad, Llamada llamada, String nombre) {
		super();
		this.prioridad = prioridad;
		this.llamada = llamada;
		this.nombre = nombre;
	}

	/**
	 * Instantiates a new empleado.
	 *
	 * @param prioridad el prioridad
	 */
	public Empleado(PrioridadEmpleado prioridad) {
		super();
		this.prioridad = prioridad;
	}

	/**
	 * Instantiates a new empleado.
	 *
	 * @param prioridad el prioridad
	 * @param nombre el nombre
	 */
	public Empleado(PrioridadEmpleado prioridad, String nombre) {
		super();
		this.prioridad = prioridad;
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Empleado empleado2) {
		if (this.getPrioridad().getPrioridad() < empleado2.getPrioridad().getPrioridad()) {
			return -1;
		}
		if (this.getPrioridad().getPrioridad() > empleado2.getPrioridad().getPrioridad()) {
			return 1;
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("static-access")
	public void run() {
		try {
			System.out.println("\nEmpleado " + this.getNombre() + " atendiendo llamada\n");
			Thread.sleep(llamada.getDuracion());
			System.out.println("\nLlamada del empleado : "+this.getNombre()+ " ... finalizada. Duración :   " + llamada.getDuracion() / 1000 + " segundos");
		} catch (InterruptedException e) {
			System.out.println("Error atendiendo llamada del empleado" + this.getNombre());
			e.printStackTrace();
		}
	}

	/**
	 * Atenderllamada.
	 *
	 * @param llamada el llamada
	 */
	public void atenderllamada(Llamada llamada) {
		this.llamada = llamada;
	}

	/**
	 * Gets el prioridad.
	 *
	 * @return el prioridad
	 */
	public PrioridadEmpleado getPrioridad() {
		return prioridad;
	}

	/**
	 * Sets el prioridad.
	 *
	 * @param prioridad el new prioridad
	 */
	public void setPrioridad(PrioridadEmpleado prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * Gets el llamada.
	 *
	 * @return el llamada
	 */
	public Llamada getLlamada() {
		return llamada;
	}

	/**
	 * Sets el llamada.
	 *
	 * @param llamada el new llamada
	 */
	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	/**
	 * Gets el nombre.
	 *
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets el nombre.
	 *
	 * @param nombre el new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
