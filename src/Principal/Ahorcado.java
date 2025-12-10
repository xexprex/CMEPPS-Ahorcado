package Principal;

import java.util.Scanner;

public class Ahorcado {

	public static void main(String[] args) {
		//Variables.
		Scanner scanner=new Scanner(System.in);
		int J1 = 0,J2 = 0;
		int partida = 1;
		boolean EscribeJ1=true;
		
		System.out.println("Juego del ahorcado (Mejor de 5)");
		
		//partidas
		while(partida <=5 && J1<3 && J2<3) {
			System.out.println("\n--- Partida " + partida + " ---");
			
			//Definimos los roles
				String escribe = EscribeJ1 ? "Jugador 1" : "Jugador 2";
				String adivina = EscribeJ1 ? "Jugador 1" : "Jugador 2";
				
			//Escribir palabra para jugar
			System.out.println("Escribe palabra secreta: ");
			String palabraSecreta = "";
			
		
			boolean valido = false;
			while(!valido){
				palabraSecreta = scanner.next().toUpperCase();
				
				if(palabraSecreta.matches("[A-ZÑ]+")) {
					valido = true;
				}else {
					System.out.println("Error debe ser una letra de (A-Z)");
				}				
			}
			
			
			//Empieza la ronda
			boolean advinaGanar = Ronda(palabraSecreta,scanner);
			
			if(advinaGanar) {
				System.out.println(adivina + " ha adivinado la palabra");
				if(EscribeJ1) {
					J2++;
				}else{
					J1++;
				}
			}else {
				System.out.println(escribe + " gana, La palabra es: " + palabraSecreta);
				if(EscribeJ1) {
					J1++;
				}else{
					J2++;
				}
			}
			System.out.println("\n Marcador J1 " + J1 +" | J2: " + J2);
			partida++;
			
			//Cambiamos el turno
			EscribeJ1 = !EscribeJ1;
		}
	}
	
	private static boolean Ronda(String palabra, Scanner sc) {
		char[] progreso = new char[palabra.length()];
		
		for(int i=0;i<progreso.length;i++) {
			progreso[i]='_';
		}
		
		int fallos=0;
		int fallomaximo=6;
		
		while(fallos<fallomaximo) {
			System.out.println(ahorcado[fallos]);
			System.out.println("Palabra: " + String.valueOf(progreso));
			
			
			//validar la palabra
			char letra = ' ';
			boolean valido = false;
			while(!valido){
				System.out.println("Introduce una letra: ");
				String entrada = sc.next().toUpperCase();
				
				char c=entrada.charAt(0);
				if(Character.isLetter(c)) {
					letra=c;
					valido=true;
				}else {
					System.out.println("Error debe ser una letra de (A-Z)");
				}
				
			}
			
			boolean acierto = false,completa=true;
			
			//Si acierta
			for(int i=0;i<palabra.length();i++) {
				if(palabra.charAt(i)==letra) {
					progreso[i]=letra;
					acierto=true;
				}
					if(progreso[i]=='_') {
						completa=false;
					}
			}
			
			if(!acierto) {
				fallos++;
				System.out.println("Fallo: Te quedan " + (fallomaximo - fallos) + " intentos");
			}
			
			if(completa) {
				return true;
			}
		}
		
		System.out.println(ahorcado[fallos]);
		return false;
	}
	
	
	private static final String[] ahorcado = {
			"  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
	        "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
	        "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
	        "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
	        "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
	        "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
	        "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
	    };
}
