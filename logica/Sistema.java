package logica;

public interface Sistema {

	void nuevaPartida(String nombre);
	boolean cargarPartida();
	
	void revisarEquipo();
	void capturarPokemon(int habitat);
	void accesoPC(int i, int j);
	void combatirGimnasio(int gimnasio);
	void combatirAltoMando();
	void curarEquipo();
	void guardarPartida();
	
	
}
	