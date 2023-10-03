package personnage;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getEffetPotion() {
		return effetPotion;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void boirePotion(int forceP) {
		effetPotion = forceP;
		parler("Merci druide, je sens que ma force est "+effetPotion+" fois decuplee");
	}

	public void parler(String text) {
		System.out.println(prendreParole()+"<"+text+">");
	}

//	private String prendreParole() {
//		
//		return "Le Gaulois "+nom+" : ";
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + "envoie un grand coup dans la machoir de "+romain.getNom());
//		romain.recevoirCoup((force / 3)*effetPotion);
//	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
		}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
		nb_trophees++) {
		this.trophees[nb_trophees] = trophees[i];
		}
		return;
		}


	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.preparerPotion();
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Monsieur Obelix !");
		System.out.println(druide.getForcePotion());
		asterix.boirePotion(druide.getForcePotion());
		Romain romain = new Romain("Ballondebaudrus",2);
		asterix.frapper(romain);
		
	}
	
	
}

