package personnage;

public class Druide {
	private String nom;
	private int effetPotionmin;
	private int effetPotionmax;
	public Druide (String nom, int effetPotionmin, int effetPotionmax) {
		this.nom=nom;
		this.effetPotionmin=effetPotionmin;
		this.effetPotionmax=effetPotionmax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionmin + " à " + effetPotionmax + ".");

	}
	public String getNom() {
		return nom;
	}
	public void parler (String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");

	}
	private String prendreParole() { 
		return "Le druide " + nom + " : "; 
		}


}
