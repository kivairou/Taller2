package dominio;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private int medallas;
	private ArrayList<Pokemon> pokemons;
	
	public Jugador(String nombre) {
		
		this.nombre = nombre;
		this.medallas = 0;
		this.pokemons = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getMedallas() {
		return medallas;
	}
	
	public void ganarMedalla() {
		medallas++;
	}
	
	public void agregarPokemon(Pokemon p) {
		for(Pokemon existe: pokemons) {
			if(existe.getNombre().equalsIgnoreCase(p.getNombre())) {
				System.out.println("Ya tienes a: "+ p.getNombre());
				return;
			}
		}
		pokemons.add(p);
	}
	
	public void curarPokemon() {
		for(Pokemon p: pokemons) {
			p.setEstado("Vivo");
		}
		System.out.println("Todos tus pokemones han sido curados");
	}
	
	public void mostrarEquipo() {
		
		System.out.println("Equipo Actual:");
		int cantPoke = 1;
		for(Pokemon p: pokemons) {
			System.out.println(cantPoke+") "+p);
			cantPoke++;
		}
		
	}
}
