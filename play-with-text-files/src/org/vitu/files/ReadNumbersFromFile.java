package org.vitu.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ReadNumbersFromFile {

	public static void main(String[] args) {
	
		List<Integer> ints = new ArrayList<>();
			
		try (Reader reader = new FileReader("files/numbers.txt");
			BufferedReader br = new BufferedReader(reader);) {
			
			String line = br.readLine();
			
			while (line != null) {
				
				try {
					int number = Integer.parseInt(line);
					ints.add(number);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println(line + " is not a number.");
				}
				
				System.out.println("line = " + line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		// } catch (NumberFormatException e) {
		// 	e.printStackTrace();
		}
		// Le code s'arrête et n'affiche pas ints ci-après quand on ne catch pas la NFE
		System.out.println("ints = " + ints);
		// Tous les nombres apparaissant après le string entré par erreur dans le fichier
		// Il faut donc nest le try / catch pour la méthode parseInt, à l'intérieur de la boucle du try-with-ressources
	}
}
