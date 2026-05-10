package dominio;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	private int medallas;
	private ArrayList<Pokemon> pokemons;
	
	public Jugador(String nombre, int medallas) {
		
		this.nombre = nombre;
		this.medallas = medallas;
		this.pokemons = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getMedallas() {
		return medallas;
	}
	
	
	public void setMedallas(int medallas) {
		this.medallas = medallas;
	}

	public List<Pokemon> getEquipo() {
        return pokemons.subList(0, Math.min(pokemons.size(), 6));
    }

    public boolean yaTiene(String nombre) {
        for (Pokemon p : pokemons) {
            if (p.getNombre().equalsIgnoreCase(nombre)) return true;
        }
        return false;
    }
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}
	
	
}
