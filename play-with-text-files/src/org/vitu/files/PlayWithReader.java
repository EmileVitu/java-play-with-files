package org.vitu.files;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PlayWithReader {

	public static void main(String[] args) {
		
		// PATTERN DE BASE POUR LIRE LE CONTENU D'UN FICHIER AVEC UN READER
		
		// D'abord nous créons l'endroit où stocker les caractères lus dans quelque chose :
		StringBuilder sb = new StringBuilder();
		
		try (Reader reader = new FileReader("files/sonnet.txt");) {
			// FileReader peut jeter deux exceptions : IOException & FileNotFoundException
			// Or FileNotFoundException étends IOException
		// } catch (FileNotFoundException e) {
		// 	System.out.println("J'attrape la FNFE");
		// 	e.printStackTrace();
			// Donc il est inutile d'avoir les deux
			
			// Vu que le fichier est très petit, nous pouvons donner un petit buffer à notre tableau de caractères
			char[] chars = new char[128];

			// La méthode read(chars) nous retourne un entier du nombre de caractères qu'elle à lu
			int number = reader.read(chars);
			// Retourne 16, mais si nous passons [1_000_000], n'en retourne que 555
			// Donc ce n'est pas parce que le tableau de caractères est grand qu'il est nécessairement rempli
			// System.out.println("J'ai lu " + number + " caractères. ");
			// Pour savoir quand le fichier à été entièrement lu, la méthode read() retourne '-1'
			// Il faut donc le passer dans une boucle :
			System.out.println(number + " lus.");
			
			while (number != -1) {
				// Maintenant il faut append les caractères au StringBuilder
				// Sans oublier d'ajouter les deux derniers paramètres pour qu'il sache de où à où les caractères doivent être lus
				sb.append(chars, 0, number);
				number = reader.read(chars);
				
				System.out.println(number + " lus.");
				// Retourne :
				// 128 lus.
				// 128 lus.
				// 128 lus.
				// 128 lus.
				// 96 lus.
				// -1 lus.
			}
		} catch (IOException e) {
			// System.out.println(e.getMessage());
			System.out.println("J'attrape l'IOE");
			e.printStackTrace();
		} 
		System.out.println("Contenu du fichier :");
		System.out.println(sb.toString());
	}

}
