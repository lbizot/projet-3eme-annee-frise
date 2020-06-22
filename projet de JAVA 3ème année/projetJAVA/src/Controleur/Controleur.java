package Controleur;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Date;

import java.io.File;
import java.lang.Integer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Modele.Chronologie;
import Modele.Evenement;
import Modele.LectureEcriture;
import Vue.PanelAffichage;
import Vue.PanelAjoutEvenement;
import Vue.PanelCreation;
import Vue.PanelFriseFichier;
import Vue.PanelGeneral;
import Vue.PanelNouvelleFrise;
import Vue.PanelSupprimerEvenement;

public class Controleur implements ActionListener{
	
	private PanelCreation panelCreation;
	private PanelGeneral panelGeneral;
	private PanelAffichage panelAffichage;
	private PanelNouvelleFrise panelNouvelleFrise;
	private PanelFriseFichier panelFriseFichier;
	private PanelAjoutEvenement panelAjoutEvenement;
	private PanelSupprimerEvenement panelSupprimerEvenement;
	
	public Controleur(PanelCreation parPanelCreation, PanelGeneral parPanelGeneral, PanelAffichage parPanelAffichage){
		panelCreation=parPanelCreation;
		panelGeneral=parPanelGeneral;
		panelAffichage=parPanelAffichage;
		
		panelNouvelleFrise = panelCreation.getPanelNouvelleFrise();
		panelFriseFichier = panelCreation.getPanelFriseFichier();
		panelAjoutEvenement=panelCreation.getPanelAjoutEvenement();
		panelSupprimerEvenement=panelCreation.getPanelSuppressionEvenement();
		panelCreation.enregistreEcouteur(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getActionCommand().equals("NouvelleFrise")){
				Chronologie chronologie = new Chronologie(new Date(01,01,Integer.parseInt(panelNouvelleFrise.getDateDebut())), 
						new Date(31,12,Integer.parseInt(panelNouvelleFrise.getDateFin())), Integer.parseInt(panelNouvelleFrise.getPeriode()), panelNouvelleFrise.getIntitule(), 
						panelNouvelleFrise.getFichier());
				if(chronologie.estValide()) {
					File fichier = new File("chronologies"+File.separator+panelNouvelleFrise.getFichier()+".ser");
					LectureEcriture.ecriture(fichier, chronologie);
					panelGeneral.setChronologie(chronologie);
					panelNouvelleFrise.viderFormulaire();
				}
				else {
					ImageIcon originale= new ImageIcon("images"+File.separator+"erreur.png");
					ImageIcon redimensionnee = new ImageIcon(originale.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
					JOptionPane.showMessageDialog(panelNouvelleFrise, "La chronologie n'est pas valide. \nVeuillez entrer une année de \ndébut inférieure à celle de fin.", "Erreur", 1, redimensionnee);
				}
		}
		
		if(evt.getActionCommand().equals("Fichier")){
			File fichier = new File("chronologies"+File.separator+panelFriseFichier.getNomFichier());
			panelGeneral.setChronologie((Chronologie) LectureEcriture.lecture(fichier));
		}
		
		if(evt.getActionCommand().equals("Evenement")){
			Chronologie tempoChrono = panelGeneral.getChronologie();
			Date tempoDate = new Date(panelAjoutEvenement.getJourEvt(),panelAjoutEvenement.getMoisEvt(),Integer.parseInt(panelAjoutEvenement.getDateEvt()));
			if(tempoDate.estValide()) {
				Evenement tempoEvt = new Evenement(tempoDate, panelAjoutEvenement.getTitreEvenementt(), panelAjoutEvenement.getAdrImg(), panelAjoutEvenement.getDescription(), panelAjoutEvenement.getPoids());
				if(tempoEvt.estComprisEntre(tempoChrono.getDateDebut().getAnnee(), tempoChrono.getDateFin().getAnnee())) {
					tempoChrono.ajout(tempoEvt);
					panelGeneral.setChronologie(tempoChrono);
					File fichier = new File("chronologies"+File.separator+panelGeneral.getChronologie().getAdresseFichier()+".ser");
					LectureEcriture.ecriture(fichier, tempoChrono);
					panelAjoutEvenement.viderFormulaire();
				}
				
				else {
					ImageIcon originale= new ImageIcon("images"+File.separator+"erreur.png");
					ImageIcon redimensionnee = new ImageIcon(originale.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
					JOptionPane.showMessageDialog(panelAjoutEvenement, "L'événement n'est pas valide.\nEntrez un événement compatible avec votre\nchronologie", "Erreur", 1, redimensionnee);
				}
				
				
			}
			else {
				ImageIcon originale= new ImageIcon("images"+File.separator+"erreur.png");
				ImageIcon redimensionnee = new ImageIcon(originale.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
				JOptionPane.showMessageDialog(panelAjoutEvenement, "L'événement n'est pas valide.\nEntrez une date valide", "Erreur", 1, redimensionnee);
			}
		}
		
		if(evt.getActionCommand().equals("Supprimer un événement")) {
			Chronologie tempoChrono=panelGeneral.getChronologie();
			for(int annee : tempoChrono.getTabEvt().keySet()){
				for(Evenement evenement : tempoChrono.getTabEvt().get(annee)){
					if(evenement.getTitre().equals(panelSupprimerEvenement.getNomEvt())){
						tempoChrono.supprimerEvenement(evenement);
					}
				}
			}
			
			panelGeneral.setChronologie(tempoChrono);
			File fichier = new File("chronologies"+File.separator+panelGeneral.getChronologie().getAdresseFichier()+".ser");
			LectureEcriture.ecriture(fichier, tempoChrono);
			panelCreation.getPanelSuppressionEvenement().viderFormulaire();
		}
	}

}