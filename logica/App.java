// Tomás Ignacio Zepeda Velasquez | 21789061-6 | ICCI
// Kevin Matias Mauricio Zamora Riquelme | 21578521-1 | ICCI



package logica;


import java.io.FileNotFoundException;

import java.util.Scanner;



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
				System.out.println("\n1) Cambiar pokemon");
				System.out.println("2) Salir");
				System.out.print("Ingrese una opcion: ");
				
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
				sistema.combatirAltoMando();
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


		
	
	

	
		
		
	}
	
		
