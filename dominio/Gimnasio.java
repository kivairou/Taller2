package dominio;

import java.util.ArrayList;

public class Gimnasio {
	private int numero;
	private String nombre;
	private String estado;
	private ArrayList<Pokemon> pokemons;
	
	public Gimnasio(int numero, String nombre, String estado, ArrayList<Pokemon> pokemons) {
		
		this.numero = numero;
		this.nombre = nombre;
		this.estado = "Sin derrotar";
		this.pokemons = pokemons;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}
	
	
	
}
