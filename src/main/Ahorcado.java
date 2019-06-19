package main;

import java.util.Scanner;

public class Ahorcado {

	/**
	 * Juego del Ahorcado en el que hay que adivinar una palabra insertando letras
	 * hasta que se muestre la palabra completa o el numero de vidas baje a 0.
	 */

	public static final int VIDAS_MAXIMAS = 9;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int vidas = VIDAS_MAXIMAS;
		int i = 0;
		String palabra = "viernes";
		char[] letras;
		char[] letrasOcultas;
		char letra;
		boolean fallo = false;
		int win = 0;

		// System.out.println("Inserte la palabra a adivinar: ");
		// palabra = sc.nextLine();
		letras = new char[palabra.length()];
		letrasOcultas = new char[palabra.length()];

		while (i < palabra.length()) {
			letras[i] = palabra.charAt(i);
			letrasOcultas[i] = '_';
			i++;
		}

		while (vidas > 0 && win!=letrasOcultas.length) {
			fallo = true;
			System.out.println("\nInserte una letra: " + vidas + "/" + VIDAS_MAXIMAS);
			letra = sc.nextLine().toLowerCase().trim().charAt(0);

			for (int j = 0; j < letras.length; j++) {
				if (letra == letras[j]) {
					letrasOcultas[j] = letras[j];
					fallo = false;
					win++;
				}
			}
			if (fallo) {
				vidas--;
			}
			System.out.println(letrasOcultas);
			
			if (win==letrasOcultas.length) {
				vidas=0;
			}
		}

		if (win==letrasOcultas.length) {
			System.out.println("\nHAS GANADO! :D");
		} else {
			System.out.println("\nHAS PERDIDO! :(");
		}
		sc.close();
	}
}