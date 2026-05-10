package logica;

//import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.Scanner;
//import dominio.*;


public class App {

	private static Scanner scan;
	private static Sistema sistema = SistemaImpl.getInstancia();
	
	public static void main(String[] args) throws FileNotFoundException {
		
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
			if(sistema.cargarPartida()) {
				desplegarMenu();
			}else {
				System.out.println("No se encontro una partida guardada.");
			}
			break;
		case 2:
			System.out.print("Ingrese Apodo: ");
			String apodo = scan.nextLine();
			sistema.nuevaPartida(apodo);
			System.out.println("Bienvenido "+ apodo+ "!!");
			desplegarMenu();
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
	private static void desplegarMenu() {
		scan = new Scanner(System.in);
		int opcion = 0;
		
		do {
			System.out.println("\n1) Revisar equipo.");
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
				sistema.revisarEquipo();
				break;
			case 2:
				System.out.println("\nDonde deseas ir a explorar?");
				System.out.println("\nZonas disponibles:");
				System.out.println("1) Lago");
				System.out.println("2) Cueva");
				System.out.println("3) Montaña");
				System.out.println("4) Bosque");
				System.out.println("5) Prado");
				System.out.println("6) Mar");
				System.out.println("7) Volver al menu.");
				System.out.print("Ingrese Zona: ");
				try {
					
					int zona = scan.nextInt();
					scan.nextLine();
				
					if(zona!=7) {
						sistema.capturarPokemon(zona);
					}
				}catch(Exception e) {
					System.out.println("Zona no valida.");
				}
				break;
			case 3:
				sistema.revisarEquipo();
				System.out.println("1) Cambiar pokemon");
				System.out.println("2) Salir");
				
				if(scan.nextLine().equals("1")) {
					System.out.print("Posicion del primer pokemon: ");
					int p1 = Integer.parseInt(scan.nextLine());
					System.out.print("Posicion del segundo pokemon: ");
					int p2 = Integer.parseInt(scan.nextLine());
					sistema.accesoPC(p1-1, p2-1);
				}
				break;
			case 4:
				System.out.print("A que numero de gimnasio deseas retar?(1-8): ");
				try {
					int numGimnasio = Integer.parseInt(scan.nextLine());
					sistema.combatirGimnasio(numGimnasio);
				}catch(Exception e) {
					System.out.println("Numero invalido...");
				}
				break;
			case 5:
				
				break;
			case 6:
				sistema.curarEquipo();
				break;
			case 7:
				sistema.guardarPartida();
				break;
			case 8:
				sistema.guardarPartida();
				System.out.println("Cerrando partida...");
				break;
			default:
				System.out.println("Ingrese una opcion valida!!");
				break;
			}
		}while(opcion!=8);
		
	}

	/*private static void leerHabitats() throws FileNotFoundException {
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
	//private static void leerPokedex() throws FileNotFoundException {
	//	File txtPokedex = new File("Pokedex.txt");
	//	scan = new Scanner(txtPokedex);
	//	while (scan.hasNextLine()) {
	//	String linea = scan.nextLine();
	//	String partes[] = linea.split(";");
		
	//	String nombre = partes[0];
	//	String habitat = partes[1];
	//	double porcentaje = Double.parseDouble(partes[2]);
	//	int vida = Integer.parseInt(partes[3]);
	//	int ataque = Integer.parseInt(partes[4]);
	//	int defensa = Integer.parseInt(partes[5]);
	//	int ataqueEspecial = Integer.parseInt(partes[6]);
	//	int defensaEspecial = Integer.parseInt(partes[7]);
	//	int velocidad = Integer.parseInt(partes[8]);
	//	String tipo = partes[9];
		
	//	Pokemon nuevoPokemon = new Pokemon(nombre,habitat,porcentaje,vida,ataque,defensa,ataqueEspecial,defensaEspecial,velocidad,tipo);
		
	//	pokemones.add(nuevoPokemon);
		
		
	//	}
		
	}*/

}
