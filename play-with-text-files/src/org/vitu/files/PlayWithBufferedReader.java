package org.vitu.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.Collectors;

public class PlayWithBufferedReader {

	public static void main(String[] args) {
		
		// PATTERN AVEC UN BUFFEREDREADER POUR LIRE LE CONTENU D'UN FICHIER		
		
		// Cette métode est beaucoup plus concise
		
		String sonnet = null;
		
		try (Reader reader = new FileReader("files/sonnet.txt");
			BufferedReader br = new BufferedReader(reader);) {
			// Ici nous décorons notre Reader avec un BufferedReader
			// L'avantage c'est que nous avons deux méthodes supplémentaires avec cette décoration : readLine() et lines() (qui retourne un Stream<> de Strings)
			// Nous pouvons ainsi le concaténer dans un seul string à l'aide du Collector joining() avec le '\n' pour les séparer
			sonnet = br.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			System.out.println("J'attrape l'IOE");
			e.printStackTrace();
		}
		System.out.println("Contenu du fichier :");
		System.out.println(sonnet);
	}
}