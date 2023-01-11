package org.vitu.files;

public class QuizzWithFinally {

	public static void main(String[] args) {

		QuizzWithFinally quizzWithFinally = new QuizzWithFinally();
		
		String message = quizzWithFinally.quizz(true);
		System.out.println("Message = " + message);
		
	}
	
	public String quizz(boolean error) {
		
		try {
			if (error) {
				throw new IllegalStateException("Je jette l'exception");
			}
			return "Try";
		} catch (Exception e) {
			// Il est très déconseillé de mettre les Exceptions en global comme ici, il vaut mieux préciser de quelle classe d'Exception il s'agit
			System.out.println("Je suis dans le catch");
		} finally {
			System.out.println("Je suis dans le finally");
		}
		
		return "avec une erreur";
		// Donc le bloc finally s'exécute avant le return du bloc try lorsqu'il n'y a pas d'erreur
		// Lorsqu'on à une erreur, le catch s'exécute, puis le finally, puis le return de la classe quizz
	}
}
