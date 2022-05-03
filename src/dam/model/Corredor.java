package dam.model;

public class Corredor {
	public static final String[] MODALIDADES = {"10000", "Media Maratón", "Maratón"};
	
	private String nombre;
	private int dorsal;
	private String sexo;
	private int edad;
	private String modalidad;
	
	
	public Corredor(String nombre, int dorsal, String sexo, int edad, String modalidad) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.sexo = sexo;
		this.edad = edad;
		this.modalidad = modalidad;
	}


	public String getNombre() {
		return nombre;
	}


	public int getDorsal() {
		return dorsal;
	}


	public String getSexo() {
		return sexo;
	}


	public int getEdad() {
		return edad;
	}


	public String getModalidad() {
		return modalidad;
	}
	
	
}
