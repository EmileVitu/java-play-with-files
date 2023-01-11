package org.vitu.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class SomeMoreTextFilesAwesomeness {

	public static void main(String[] args) {
		
		File file = new File("files/data.txt");
		
		StringWriter writerBackup = null;
		
		try (StringWriter writer = new StringWriter();) {
			// Nous avons aussi la méthode CharArrayWriter() qui à aussi une méthode toString() mais qui ne jette pas d'erreur
			write(writer, "Message 1");
			writerBackup = writer;
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		} finally {
			
		}
		
		System.out.println("Writer :");
		System.out.println(writerBackup.toString());
		
		
		// try (Writer writer = new FileWriter(file);BufferedWriter bw = new BufferedWriter(writer);) {
			// Nous avons vu qu'il existe une classe qui étends Writer qui se nomme BufferedWriter
			// Nous pouvons passer aussi un integer en second paramètre pour donner une taille au buffer
			// BufferedWriter fait partie du Pattern Decorator
			
			// bw.write("Bonjour le monde!");
			// bw.newLine(); // Cette méthode n'existe pas sur la classe Writer, encore un avantage d'utiliser BufferedWriter
			// bw.write("Seconde ligne");
			// bw.newLine();
			// bw.write("Troisième ligne");
			// Comme writer est en paramètre du bloc try, la méthode close(), et par conséquent la méthode flush() est automatiquement exécutée
			// writer.flush();
			// Par contre, la méthode flush() n'est pas exécutée pour bw
			// Sinon nous pouvons déplacer la déclaration du BufferedWriter dans les paramètres du bloc try
			// bw.flush();
		// } catch (IOException e) {
			// Toutes les exceptions donné en paramètre ET toutes leurs extensions seront attrappées par le bloc catch
			// Ici par exemple, FileNotFoundException, qui étends IOException sera aussi catchée par le bloc catch
			// System.out.println(e.getMessage());
			// e.printStackTrace();
		// }
		System.out.println("Code exécuté!");
		// En executant ce code, il s'avère que rien ne s'écrit dans le fichier, il nous manque les flush()
	}
	
	public static void write(Writer writer, String message) {
		try (BufferedWriter bw = new BufferedWriter(writer);) {			
			bw.write("Début du message");
			bw.newLine();
			bw.write(message);
			bw.newLine();
			bw.write("Stop");
		} catch (IOException e) {
			// Toutes les exceptions donné en paramètre ET toutes leurs extensions seront attrappées par le bloc catch
			// Ici par exemple, FileNotFoundException, qui étends IOException sera aussi catchée par le bloc catch
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	// Ici nous appelons la méthode write avec un writer et un String en paramètres
	// Le BufferedWriter est flushé et closé après avoir effectué le bloc try
	// Le writer est ensuite flushé et closé aussi
}
