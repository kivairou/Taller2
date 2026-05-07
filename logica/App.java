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
		Scanner scan = new Scanner (System.in);
		int opcion = 0;
		do {
		System.out.println("1) Continuar.");
		System.out.println("2) Nueva Partida.");
		System.out.println("3) Salir.");
		opcion = scan.nextInt();
		
		switch (opcion) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			System.out.println("Nos vemos...");
			break;
		default:
			System.out.println("Opcion no válida");
			break;
		}
		}while (opcion !=3);
		
	}
	private static void leerHabitats() throws FileNotFoundException {
		File txtHabitats = new File("Habitats.txt");
		scan = new Scanner(txtHabitats);
		ArrayList<String> habitats = new ArrayList<>();
		while (scan.hasNextLine()) {
			String habitat = scan.nextLine();
			habitats.add(habitat);
		}
		
	}
	private static void leerRegistros() {
		// TODO Auto-generated method stub
		
	}
	private static void leerAltoMando() throws FileNotFoundException {
		File txtAltoMando = new File("AltoMando.txt");
		scan = new Scanner(txtAltoMando);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String partes[] = linea.split(";");
			
			int numero = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			String pokemon1 = partes[2];
			String pokemon2 = partes[3];
			String pokemon3 = partes[4];
			String pokemon4 = partes[5];
			String pokemon5 = partes[6];
			String pokemon6 = partes[7];
		}
		
		
	}
	private static void leerGimnasios() throws FileNotFoundException {
		File txtGimnasios = new File("Gimnasios.txt");
		scan = new Scanner(txtGimnasios);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String partes[] = linea.split(";");
			
			int numero = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			boolean estado = Boolean.parseBoolean(partes[2]);
			int cantidad = Integer.parseInt(partes[3]);
			
			for (int i = 0; i<cantidad;i++) {
				String pokemon = partes[i];
				
				
			}
		}
		
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
