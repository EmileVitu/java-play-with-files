package org.vitu.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ReadNumbersFromFileV2 {

	public static void main(String[] args) {
	
		List<Integer> ints = new ArrayList<>();
			
		try (Reader reader = new FileReader("files/numbers.txt");
			BufferedReader br = new BufferedReader(reader);) {
			
			String line = br.readLine();
			
			while (line != null) {
				
				int number = Integer.parseInt(line);
				ints.add(number);
				
				System.out.println("line = " + line);
				line = br.readLine();
			}
		// Pour éviter d'avoir deux blocs catch, ou de mettre la classe mère (ici Exception), nous pouvons faire un MultiCatch en utilisant un 'ou' '|'
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}

		System.out.println("ints = " + ints);
	}
}
