package org.vitu.files;

import java.io.File;
import java.nio.file.Path;

public class FunWithFiles {

	public static void main(String[] args) {
		
		// Les objets 'File' et 'Path' datent de Java 1
		File file = new File("files/debug.log");
		// Il existe donc une méthode toString() sur File car nous pouvons le print sans jeter d'exception même si il n'existe pas. 
		System.out.println("File = " + file);
		// --> File = files\debug.log : Toutefois nous pouvons voir que le / est devenu un \ automatiquement grâce au RunTime Java. 
		
		Path path = Path.of("files/debug.log");
		System.out.println("Path = " + path);
		// Nous pouvons effectuer les deux mêmes constats sur Path que ceux fait précédemment sur File. 
		// Il n'y a donc aucun accès disque en créant une instance de File ou de Path, ce sont des wrapper sur des chaînes de caractères qui est censé représenter un chemin sur un disque. 
		
		// Nous pouvons aussi écrire un Path ou un File en chemin absolu plutôt que relatif comme les deux exemples précédents. 
		File mdp = new File("C:/Users/Emile/Desktop/Paperasse/mdp.txt");
		
		// Il existe de nombreuses méthodes pour tester et faire d'autres actions sur les chemins :
		System.out.println("debug.log existe ? --> " + file.exists());
		System.out.println("mdp existe ? --> " + mdp.exists());
		System.out.println("mdp est un répertoire ? --> " + mdp.isDirectory());
		System.out.println("mdp est il lisible ? --> " + mdp.canRead());
		System.out.println("mdp est il exécutable ? --> " + mdp.canExecute());
		// A savoir qu'à ce moment-là, il y a bien des requêtes sur le File System qui sont effectuées. 
	}

}
