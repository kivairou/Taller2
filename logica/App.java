package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import dominio.*;


public class App {

	private static Scanner scan;
	private static ArrayList<Pokemon> pokemones = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		
		leerPokedex();
		leerGimnasios();
		leerAltoMando();
		leerRegistros();
		leerHabitats();
		
		desplegarMenu();
		

	}
	private static void desplegarMenu() {
		// TODO Auto-generated method stub
		
	}
	private static void leerHabitats() {
		// TODO Auto-generated method stub
		
	}
	private static void leerRegistros() {
		// TODO Auto-generated method stub
		
	}
	private static void leerAltoMando() {
		// TODO Auto-generated method stub
		
	}
	private static void leerGimnasios() {
		// TODO Auto-generated method stub
		
	}
	private static void leerPokedex() throws FileNotFoundException {
		File txtPokedex = new File("Pokedex.txt");
		scan = new Scanner(txtPokedex);
		while (scan.hasNextLine()) {
		String linea = scan.nextLine();
		String partes[] = linea.split(";");
		
		String nombre = partes[0];
		String habitat = partes[1];
		double porcentaje = Double.parseDouble(partes[2]);
		int vida = Integer.parseInt(partes[3]);
		int ataque = Integer.parseInt(partes[4]);
		int defensa = Integer.parseInt(partes[5]);
		int ataqueEspecial = Integer.parseInt(partes[6]);
		int defensaEspecial = Integer.parseInt(partes[7]);
		int velocidad = Integer.parseInt(partes[8]);
		String tipo = partes[9];
		
		Pokemon nuevoPokemon = new Pokemon(nombre,habitat,porcentaje,vida,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,tipo);
		
		pokemones.add(nuevoPokemon);
		
		
		}
		
	}

}
