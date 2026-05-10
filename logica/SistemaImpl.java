package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import dominio.*;

public class SistemaImpl implements Sistema{
	
	private static SistemaImpl instancia;
	
	private Jugador jugador;
	private ArrayList<Pokemon> pokemones;
	private ArrayList<Gimnasio> gimnasios;
	private ArrayList<AltoMando> altosMandos;
	private ArrayList<String> habitats;
	private Random random;
	private static Scanner scan;
	
	private SistemaImpl() {
		this.pokemones = new ArrayList<>();
		this.gimnasios = new ArrayList<>();
		this.altosMandos = new ArrayList<>();
		this.habitats = new ArrayList<>();
		this.random = new Random();
		
		cargarHabitats();
		cargarPokedex();
		cargarGimnasios();
		cargarAltosMandos();
	}

	public static SistemaImpl getInstancia() {
		if (instancia == null) {
			instancia = new SistemaImpl();
		}
		return instancia;
	}
	

	private Pokemon buscarPokemon(String nombre) {
		for(Pokemon p: pokemones) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				return p;
			}
		}
		return null;
	}
	
	private void cargarAltosMandos() {
		// TODO Auto-generated method stub
		
	}

	private void cargarGimnasios() {
		// TODO Auto-generated method stub
		
	}

	private void cargarHabitats() {
		// TODO Auto-generated method stub
		
	}

	private void cargarPokedex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuevaPartida(String nombre) {
		this.jugador = new Jugador(nombre,0);
		System.out.println("Bienvenido "+ nombre+"!!");
		
	}

	@Override
	public boolean cargarPartida() {
		try (Scanner scan = new Scanner(new File("Registros.txt"))){
			if (!scan.hasNextLine()) return false;
			
			String[] partes = scan.nextLine().split(";");
			this.jugador = new Jugador(partes[0],Integer.parseInt(partes[1]));
			
			while(scan.hasNextLine()) {
				
				String[] partes2 = scan.nextLine().split(";");
				Pokemon buscarPoke = buscarPokemon(partes2[0]);
				if(buscarPoke != null) {
					Pokemon nuevoPoke = buscarPoke.clonar();
					nuevoPoke.setEstado(partes2[2]);
					jugador.getPokemons().add(nuevoPoke);
				}
			}
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	@Override
	public void revisarEquipo() {
		System.out.println("Equipo Actual:");
		
		ArrayList<Pokemon> poke = jugador.getPokemons();
		if(poke.isEmpty()) {
			System.out.println("No tienes ningun pokemon aun.");
			return;
		}
		for(int i = 0; i < poke.size(); i++) {
			Pokemon p = poke.get(i);
			System.out.println(i+1+") "+ p);
		}
		
	}

	@Override
	public void capturarPokemon(int habitat) {
		scan = new Scanner(System.in);
		if(habitat<1 || habitat > habitats.size()) return;
		String zona = habitats.get(habitat-1);
		
		ArrayList<Pokemon> locales = new ArrayList<>();
		for(Pokemon p: pokemones) {
			if(p.getHabitat().equalsIgnoreCase(zona)) {
				locales.add(p);
			}
		}
		
		double suerte = random.nextDouble();
		double acumulado = 0;
		Pokemon encontrado = null;
		
		for(Pokemon p: locales) {
			acumulado += p.getPorcentajeAparicion();
			if(suerte<=acumulado) {
				encontrado = p;
				break;
			}
		}
		
		if(encontrado!=null) {
			System.out.println("\nOh!! Ha aparecido un increible "+encontrado.getNombre());
			System.out.println("\nQue deseas hacer?");
			System.out.println("\n1) Capturar");
			System.out.println("2) Huir");
			
			if(scan.nextLine().equals("1")) {
				boolean loTiene = false;
				for(Pokemon p: jugador.getPokemons()) {
					if(p.getNombre().equalsIgnoreCase(encontrado.getNombre())) {
						loTiene = true;
					}
					
					if(loTiene) {
						System.out.println("Ya has capturado a este pokemon");
					} else {
						jugador.getPokemons().add(encontrado.clonar());
						System.out.println(encontrado.getNombre()+ " capturado con exito!!");
						System.out.println(encontrado.getNombre()+ " ha sido agregado a tu equipo!");
					}
				}
			}
		}
		
	}

	@Override
	public void accesoPC(int i, int j) {
		ArrayList<Pokemon> lista = jugador.getPokemons();
		if(i>=0 && i<lista.size() && j>=0 && j < lista.size()) {
			Collections.swap(lista, i, j);
			System.out.println("Cambio realizado.");
		}else {
			System.out.println("Posiciones invalidas.");
		}
		
	}

	@Override
	public void combatirGimnasio(int gimnasio) {
		if (gimnasio < 1 || gimnasio > 8) {
			System.out.println("Ese gimnasio no existe.");
		}
        
		if(gimnasio != jugador.getMedallas()+1) {
			if(gimnasio <= jugador.getMedallas()) {
				System.out.println("Ya has derrotado a ese lider de gimnasio");
			}else {
				Gimnasio g = gimnasios.get(gimnasio-1);
				System.out.println("Calmado Entrenador!!! No puedes retar a "+g.getNombre()+ " sin haber derrotado a los lideres anteriores!!");
			}
			return;
		}
		
		Gimnasio g = gimnasios.get(gimnasio-1);
		System.out.println("Desafiando a "+g.getNombre()+"!!");
		
		boolean victoria = ejecutarBatalla(g.getPokemons(), g.getNombre());
		
		if(victoria) {
			System.out.println("Has derrotado a "+g.getNombre()+ " y ganas una medalla!");
			jugador.setMedallas(jugador.getMedallas()+1);
			g.setEstado("Derrotado");
		}else {
			System.out.println("Te has quedado sin pokemons en tu equipo!");
			System.out.println("Volviendo al menu...");
		}
		
	}

	private boolean ejecutarBatalla(ArrayList<Pokemon> equipoRival, String nombreRival) {
		int pkmnRivalActual = 0;
	  
	    Pokemon miPkmn = obtenerPrimerVivo();

	    if (miPkmn == null) {
	        System.out.println("No tienes Pokemon aptos para luchar.");
	        return false;
	    }

	    while (pkmnRivalActual < equipoRival.size()) {
	        Pokemon rival = equipoRival.get(pkmnRivalActual);
	        System.out.println("\n" + nombreRival + " saca a " + rival.getNombre());
	        System.out.println(jugador.getNombre()+" saca a "+miPkmn.getNombre());

	        System.out.print("\nQue deseas hacer?");
	        System.out.println("1) Atacar");
	        System.out.println("2) Cambiar de pokemon");
	        System.out.println("3) Rendirse");
	        System.out.print("Ingrese una opcion: ");
	        String op = scan.nextLine();

	        if (op.equals("1")) {
	            
	            double mult = TablaTipos.obtenerMultiplicador(miPkmn.getTipo(), rival.getTipo());
	            double misStats = miPkmn.getSumaStats();
	            
	            
	            if (mult > 1.0) { misStats *= 2; System.out.println("¡Es súper efectivo!"); }
	            else if (mult < 1.0 && mult > 0) { misStats *= 0.5; System.out.println("No es muy efectivo..."); }
	            else if (mult == 0) { misStats = 0; System.out.println("No afecta..."); }

	            System.out.println(miPkmn.getNombre() + " final: " + misStats + " vs " + rival.getNombre() + ": " + rival.getSumaStats());

	            if (misStats >= rival.getSumaStats()) {
	                System.out.println("¡" + rival.getNombre() + " debilitado!");
	                pkmnRivalActual++;
	            } else {
	                System.out.println("¡" + miPkmn.getNombre() + " ha caído!");
	                miPkmn.setEstado("Debilitado");
	                miPkmn = obtenerPrimerVivo();
	                if (miPkmn == null) {
	                    System.out.println("¡Te has quedado sin Pokémon!");
	                    return false;
	                }
	            }
	        } 
	        else if (op.equals("2")) {
	            
	            revisarEquipo(); 
	            System.out.print("Elige el número de Pokémon: ");
	            int idx = Integer.parseInt(scan.nextLine()) - 1;
	            Pokemon elegido = jugador.getPokemons().get(idx);
	            
	            if (elegido.getEstado().equals("Vivo") && idx < 6) {
	                miPkmn = elegido;
	            } else {
	                System.out.println("No puedes elegir ese Pokémon (está debilitado o no está en tu equipo).");
	            }
	        } 
	        else {
	            return false; // Rendirse
	        }
	    }
	    return true; // Victoria: se acabaron los pokémon del rival
	}

	// Método auxiliar para buscar el primer pokemon vivo en los primeros 6
	private Pokemon obtenerPrimerVivo() {
	    List<Pokemon> equipo = jugador.getEquipo();
	    for (Pokemon p : equipo) {
	        if (p.getEstado().equals("Vivo")) return p;
	    }
	    return null;
	}
	

	@Override
	public void combatirAltoMando(int altoMando) {
		// Validar que tenga las 8 medallas
	    if (jugador.getMedallas() < 8) {
	        System.out.println("No tienes suficientes medallas para el Alto Mando.");
	        return;
	    }

	    System.out.println("\n=== BIENVENIDO AL DESAFÍO DEL ALTO MANDO ===");
	    
	    // Bucle consecutivo de los 7 miembros
	    for (int i = 0; i < altosMandos.size(); i++) {
	        AltoMando miembro = altosMandos.get(i);
	        System.out.println("\nCombate " + (i + 1) + "/7: Contra " + miembro.getNombre());
	        
	        boolean victoria = ejecutarBatalla(miembro.getPokemons(), miembro.getNombre());

	        if (!victoria) {
	            System.out.println("Has caído en el Alto Mando. Debes empezar el desafío desde el principio.");
	            return; // Termina el método por derrota o rendición
	        }
	        
	        System.out.println("¡Has superado a " + miembro.getNombre() + "!");
	    }

	    System.out.println("\n¡INCREÍBLE! ¡Has derrotado al Alto Mando y eres el NUEVO CAMPEÓN!");
		
	}

	@Override
	public void curarEquipo() {
		for(Pokemon p: jugador.getPokemons()) {
			p.setEstado("Vivo");
		}
		System.out.println("tu equipo se ha recuperado!");
		
	}

	@Override
	public void guardarPartida() {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter("Registros.txt"))) {
			escritor.write(jugador.getNombre() + ";" + (jugador.getMedallas()));
			escritor.newLine();
			
			for(Pokemon p: jugador.getPokemons()) {
				escritor.write(p.getNombre() + ";" + p.getEstado());
				escritor.newLine();
			}
			System.out.println("Partida guardada correctamente.");
		} catch (IOException e) {
			System.out.println("Error al guardar.");
		}
		
	}

}
