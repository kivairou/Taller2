package dominio;

public class Gimnasios {
	private int numero;
	private String nombre;
	private boolean estado;
	private int cantidadPokemon;
	
	public Gimnasios(int numero, String nombre, boolean estado, int cantidadPokemon) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.estado = estado;
		this.cantidadPokemon = cantidadPokemon;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public int getCantidadPokemon() {
		return cantidadPokemon;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
