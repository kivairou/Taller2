package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import dominio.*;


public class App {

	private static Scanner scan;
	private static ArrayList<Pokemon> pokemones = new ArrayList<>();
	private static ArrayList<AltoMando> altosMandos = new ArrayList<>();
	private static ArrayList<Gimnasio> gimnasios = new ArrayList<>();
	private static ArrayList<String> habitats = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		
	
		
		leerPokedex();
		leerHabitats();
	
		desplegarMenuInicial();
		

	}
	private static void desplegarMenuInicial() throws FileNotFoundException {
		scan = new Scanner (System.in);
		int opcion = 0;
		do {
		System.out.println("1) Continuar.");
		System.out.println("2) Nueva Partida.");
		System.out.println("3) Salir.");
		System.out.print("Ingrese una opcion: ");
		opcion = scan.nextInt();
		scan.nextLine();
		
		switch (opcion) {
		case 1:
			leerRegistros();
			break;
		case 2:
			leerGimnasios();
			leerAltoMando();
			System.out.print("Ingrese su apodo de jugador: ");
			String nombreJugador = scan.nextLine();
			Jugador nuevoJugador = new Jugador(nombreJugador);
			desplegarMenu(nuevoJugador);
			break;
		case 3:
			System.out.println("Nos vemos entrenador...");
			break;
		default:
			System.out.println("Ingrese una opcion valida!!");
			break;
		}
		}while (opcion !=3);
		
	}
	private static void desplegarMenu(Jugador jugador) {
		scan = new Scanner(System.in);
		int opcion = 0;
		
		do {
			System.out.println("1) Revisar equipo.");
			System.out.println("2) Salir a capturar.");
			System.out.println("3) Acceso al PC (cambiar Pokemon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafio al Alto Mando.");
			System.out.println("6) Curar Pokemon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			System.out.print("Ingrese una opcion: ");
			
			opcion = scan.nextInt();
			scan.nextLine();
			
			switch(opcion) {
			case 1:
				revisarEquipo(jugador);
				break;
			case 2:
				salirCapturar(jugador);
				break;
			case 3:
				accesoPC(jugador);
				break;
			case 4:
				retarGimnasio(jugador);
				break;
			case 5:
				desafioAltoMando(jugador);
				break;
			case 6:
				curarPokemon(jugador);
				break;
			case 7:
				guardarRegistro(jugador);
				break;
			case 8:
				guardarRegistro(jugador);
				break;
			default:
				System.out.println("Ingrese una opcion valida!!");
				break;
			}
		}while(opcion!=8);
		
	}
	private static void guardarRegistro(Jugador j) {
		// TODO Auto-generated method stub
		
	}
	private static void curarPokemon(Jugador j) {
		// TODO Auto-generated method stub
		
	}
	private static void desafioAltoMando(Jugador j) {
		// TODO Auto-generated method stub
		
	}
	private static void retarGimnasio(Jugador j) {

		// TODO Auto-generated method stub
		
	}
	private static void accesoPC(Jugador j) {
		// TODO Auto-generated method stub
		
	}
	private static void salirCapturar(Jugador j) {

		// TODO Auto-generated method stub
		
	}
	private static void revisarEquipo(Jugador j) {
		// TODO Auto-generated method stub
		
	}
	private static void leerHabitats() throws FileNotFoundException {
		File txtHabitats = new File("Habitats.txt");
		scan = new Scanner(txtHabitats);
		
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
			String[] partes = linea.split(";");
			
			int numero = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			
			ArrayList<Pokemon> pokeAltoMando = new ArrayList<>();
			
			for(int i = 2; i<partes.length;i++) {
				String nombrePoke = partes[i];
				for(Pokemon p: pokemones) {
					if(p.getNombre().equalsIgnoreCase(nombrePoke)) {
						pokeAltoMando.add(p);
					}
				}
			}
			AltoMando nuevoAltoMando = new AltoMando(numero,nombre,pokeAltoMando);
			altosMandos.add(nuevoAltoMando);
			
			
			
		}
		
		
	}
	private static void leerGimnasios() throws FileNotFoundException {
		File txtGimnasios = new File("Gimnasios.txt");
		scan = new Scanner(txtGimnasios);
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes= linea.split(";");
			
			int numero = Integer.parseInt(partes[0]);
			String nombre = partes[1];
			String estado = partes[2];
			int cantidad = Integer.parseInt(partes[3]);
			
			ArrayList<Pokemon> pokemonsGim = new ArrayList<>();
			
			for (int i = 0; i<cantidad;i++) {
				String nombrePokemon = partes[4+i];
				for(Pokemon p: pokemones) {
					if(p.getNombre().equalsIgnoreCase(nombrePokemon)) {
						pokemonsGim.add(p);
					}
				}
				
			}
			Gimnasio nuevoGimnasio = new Gimnasio(numero,nombre,estado,pokemonsGim);
			gimnasios.add(nuevoGimnasio);
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
