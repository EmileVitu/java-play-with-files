package org.vitu.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadNumbersFromFileV3 {

	public static void main(String[] args) {
		
		Function<String, Stream<Integer>> lineToInt = 
				line -> {
					try {
						return Stream.of(Integer.parseInt(line));
					} catch (NumberFormatException e) {
						// System.out.println(line + " is not a number. ");
					}
					return Stream.empty();
				};
		// En faisant ainsi, nous retournons soit un Stream<> contenant un entier, soit un Stream<> vide
		// Ainsi notre fonction gère les erreurs en interne
		
		List<Integer> ints = new ArrayList<>();
			
		try (Reader reader = new FileReader("files/numbers.txt");
			BufferedReader br = new BufferedReader(reader);) {
				ints = br.lines()
						.filter(line -> !line.startsWith("#"))		// En ajoutant le filter nous pouvons retirer les commentaires si ils commencent tous par '#'
						.flatMap(lineToInt)							// flatMap() nous sert à transformer un Stream<Stream<>> en un seul Stream<>
						.collect(Collectors.toList());				// La méthode collect() en passant le Collector toList() nous transforme notre Stream<> en List<>
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ints = " + ints);
	}
	// Nous pourrions aussi remplacer Stream.of() par un optional en disant que le résultat du parseInt() sera mis dans un optional
	// Et si jamais on ne peut pas repartir on retourne un optional vide avant de finir par un flatMap() sur les optionals
}
