package org.vitu.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class EvenMoreFunWithFiles {

	public static void main(String[] args) {
		
		// Le fichier suivant n'existe pas encore
		File file = new File("files/data.txt");
		
		// Nous créons un nouveau fichier avec un bloc try / catch, car il y a une éventualité de lancement d'une IOException
		// try {
			// Création du fichier
			// file.createNewFile();
			// System.out.println("Le fichier a bien été créé !");
			// Ecriture de contenu dans le fichier
			// Writer writer = new FileWriter(file);
			// writer.write("Bonjour le monde!\n"); 				// L'écriture se fait dans les buffer internes, et transmis au FileSystem
			// writer.write("Une deuxième ligne");
			// writer.flush();									// L'ordre est transmis au FileSystem pour l'écrire, donc le fichier sera modifié
			// writer.close();									// Pour éviter des bugs de file leaking, très important, close() appelle flush() également
			// !!! : Génère un file leaking si une des lignes précédentes lance une erreur car le fichier ne sera pas flushé et closé !!!
 		// } catch (IOException e) {
			// System.out.println(e.getMessage());
			// e.printStackTrace();
		// }
		// Pourtant, le fichier n'est pas visible dans l'arborescence, il faut rafraichir le package explorer avec clic droit refresh et aussi F5
		
		// La bonne pratique
		try (Writer writer = new FileWriter(file)) {
			file.createNewFile();
			System.out.println("Le fichier a bien été créé !");
			writer.write("Bonjour le monde!\n");
			
			getInformation(true);
			
			writer.write("Une deuxième ligne");
			// writer.close(); --> Puisque writer est en paramètre du try-with-ressources, il sera automatiquement closé, donc flushé en sortant du bloc try / catch
 		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Le finally est bien éxecuté");
		}
		System.out.println("Nous continuons le code après le bloc try / catch");
	}
	// Permet de lancer une exception au sein du bloc try
	public static String getInformation(boolean error) throws IOException {
		if (error) {
			throw new IOException("Erreur générée");
		} else {
			return "Une information";
		}
	}
}
