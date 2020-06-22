package Modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Chronologie implements Serializable {
	
	private Date dateDebut;
	private Date dateFin;
	private int periode;
	private String intitule;
	private String adresseFichier;
	private TreeMap<Integer, TreeSet<Evenement>> tabEvt;
	
	
	
	public Chronologie(Date parDateDebut, Date parDateFin, int parPeriode, String parIntitule, String parAdresseFichier){
		dateDebut=parDateDebut;
		dateFin=parDateFin;
		periode=parPeriode;
		intitule=parIntitule;
		adresseFichier=parAdresseFichier;
		tabEvt=new TreeMap<Integer, TreeSet<Evenement>>();
	}
	
	public Chronologie() {
		dateDebut=new Date();
		dateFin=new Date();
		periode=1;
		intitule="";
		adresseFichier="";
		tabEvt=new TreeMap<Integer, TreeSet<Evenement>>();
		this.ajout(new Evenement());
	}

	public void ajout(Evenement parEvenement) {
		int numAnnee = parEvenement.getDate().getAnnee();
		if(tabEvt.containsKey(numAnnee)){
			tabEvt.get(numAnnee).add(parEvenement);
		}
		else{
			tabEvt.put(numAnnee, new TreeSet<Evenement>());
			tabEvt.get(numAnnee).add(parEvenement);
		}
		
		if(tabEvt.containsKey(parEvenement.getDate().getAnnee())){
			tabEvt.get(parEvenement.getDate().getAnnee()).add(parEvenement);
		}
		else{
			tabEvt.put(parEvenement.getDate().getAnnee(), new TreeSet<Evenement>());
			tabEvt.get(parEvenement.getDate().getAnnee()).add(parEvenement);
			
		}
		
	
	}
	
	public void supprimerEvenement(Evenement parEvenement) {
		tabEvt.get(parEvenement.getDate().getAnnee()).remove(parEvenement);
	}
	
	public String afficherEvt(){
		String chaineFinale = "";
		for(int annee : tabEvt.keySet()){
			for(Evenement evt : tabEvt.get(annee)){
				chaineFinale+=evt.toString() + "\n";
			}
		}
		
		return chaineFinale;	
		
	}
	
	public String toString(){
		
		String chaineEvenement = null;
		for(int annee : tabEvt.keySet()){
			for(Evenement evt : tabEvt.get(annee)){
				chaineEvenement+=evt.toString() + "\n";
			}
		}
		
		
		return intitule + "\n de " + dateDebut + "à" + dateFin + "\n adresse fichier :" + adresseFichier + "\n Evenements :"+chaineEvenement;
	}

	


	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public int getPeriode() {
		return periode;
	}



	public void setPeriode(int periode) {
		this.periode = periode;
	}



	public String getIntitule() {
		return intitule;
	}



	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}



	public String getAdresseFichier() {
		return adresseFichier;
	}



	public void setAdresseFichier(String adresseFichier) {
		this.adresseFichier = adresseFichier;
	}



	public TreeMap<Integer, TreeSet<Evenement>> getTabEvt() {
		return tabEvt;
	}



	public void setTabEvt(TreeMap<Integer, TreeSet<Evenement>> tabEvt) {
		this.tabEvt = tabEvt;
	}
	
	public int getSizeTabEvt() {
		int resultat=0;
		for(int annee : tabEvt.keySet()){
			for(Evenement evt : tabEvt.get(annee)){
				resultat++;
			}
		}
		return resultat;
	}
	
	public boolean estValide() {
		return dateDebut.compareTo(dateFin)<0;
	}
	
}
