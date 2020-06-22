package Modele;

import java.io.Serializable;

public class Evenement implements Serializable, Comparable <Evenement>{
	private Date chDate;
	private String chTitre;
	private String chAdresseImage;
	private String chDescription;
	private int chPoids;
	
	
	public String toString() {
		return chTitre + " " + chDate + " " + chAdresseImage + " " + chDescription + " "+chPoids ;
	}
	
	//Constructeur
	
	public Evenement(Date parDate, String parTitre, String parAdresseFichier, String parDescription, int parPoids) {
		chDate=parDate;
		chTitre=parTitre;
		chAdresseImage=parAdresseFichier;
		chDescription = parDescription;
		chPoids=parPoids;
	}
	
	public Evenement() {
		chDate=new Date();
		chTitre="";
		chAdresseImage="";
		chDescription = "";
		chPoids=1;
	}
	
	
	
	//Accesseurs
	
	public Date getDate() {
		return chDate;
	}
	
	public String getTitre() {
		return chTitre;
	}
	
	public int getPoids() {
		return chPoids;
	}

	public String getDescription() {
		return chDescription;
	}
	
	public String getAdrImage() {
		return chAdresseImage;
	}
	
	

	
	public int compareTo(Evenement parEven){
		
		int retour=Integer.compare(this.chDate.getAnnee(),parEven.chDate.getAnnee());
		if(retour==0){
			return(Integer.compare(this.chPoids, parEven.chPoids));
			
		}
		else 
			return retour;
	}
	
	public boolean estComprisEntre(int annee1, int annee2) {
		return (chDate.getAnnee()>=annee1 && chDate.getAnnee()<=annee2);
	}
		
}
