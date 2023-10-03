package personnage;

public class Romain {
	private String nom;
	private String texte;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert !(force < 0) : "omggggggg";
		this.nom = nom;
		this.force = force;

	}
	
	public int getForce() {
		return force;
	}

	public void sEquiper(Equipement stuff) {
		switch (nbEquipement) {
		case 0:
			equipe(stuff, 0);
			break;
		case 1:
			if (equipement[0] == stuff) {
				System.out.println("le soldat " + nom + " possede deja un " + stuff);

			} else {
				equipe(stuff, 1);
			}
			break;
		default:
			System.out.println("le soldat " + nom + " est deja bien protege !");
			break;
		}
	}

	private void equipe(Equipement stuff, int i) {
		equipement[i] = stuff;
		nbEquipement++;
		System.out.println("le soldat " + nom + " s equipe avec un " + stuff);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String text) {
		System.out.println(prendreParole() + "<" + text + ">");
	}

	private String prendreParole() {
		// TODO Auto-generated method stub
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0 : "il est ko";
//		int tmp = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		}
//
//		else {
//			parler("j abandonne... ");
//
//		}
//
//		assert tmp > force : "omg il a pas perdu d hp !!";
//
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
		parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
			}
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
			}
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipement[i] == null) {
				continue;
				} else {
				equipementEjecte[nbEquipementEjecte] =
				equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
				}
				}
				return equipementEjecte;
				}




	public static void main(String[] args) {
		Romain romain = new Romain("Minus", 6);
		romain.prendreParole();
		romain.parler("LES GAU... LES GAU GAU.. LES GAULOIS !!");
		romain.recevoirCoup(25);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.BOUCLIER);

	}

}