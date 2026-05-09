package dominio;

import java.util.ArrayList;

public class AltoMando {
	
	private int numero;
	private String nombre;
	private ArrayList<Pokemon> pokemons;
	
	
	public AltoMando(int numero, String nombre, ArrayList<Pokemon> pokemons) {
		
		this.numero = numero;
		this.nombre = nombre;
		this.pokemons = pokemons;
	}
	
	public int getNumero() {
		return numero;
	}
	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	
	
	
	
}
