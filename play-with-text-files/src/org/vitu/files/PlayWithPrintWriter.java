package org.vitu.files;

// import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

public class PlayWithPrintWriter {

	public static void main(String[] args) {

		CharArrayWriter writer = new CharArrayWriter();
		// Cette classe stocke les données en mémoire, et par conséquent ne jette pas d'exception (peut-être vu en lisant la description de la classe)
		// BufferedWriter bw = new BufferedWriter(writer);
		// Ici nous décorons Writer
		PrintWriter printWriter = new PrintWriter(writer);
		// La classe PrintWriter permet d'utiliser les println et printf qui viennent du C
		// Cette décoration ne jette pas d'exceptions non plus
		// Aussi nous décorons une décoration de Writer, nous avons donc deux niveaux de décoration
		
		int number = 12;
		// Ici, number est imprimé en tant qu'integer
		printWriter.println("number = " + number);
		// Ici, number est imprimé en tant que chaîne de caractères
		printWriter.println(number);
	
		boolean b = true;
		printWriter.println(b);
		// Nous pouvons aussi imprimer avec format
		printWriter.printf("Number = %d\n", 42);
		// La documentation se situe ici : https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html#syntax
		// Nous pouvons aussi la trouver en survolant la méthode printf et en cliquant sur le lien 'Format String Syntax'
		
		// Nous ne sommes pas dans un bloc try-with-ressources, donc il faut guarantir l'envoi des données depuis le FS
		printWriter.flush();
		writer.flush();
		
		System.out.println("Résultat = ");
		// Nous imprimons notre CharArrayWriter (données en mémoire)
		System.out.println(writer.toString());
	}

}
