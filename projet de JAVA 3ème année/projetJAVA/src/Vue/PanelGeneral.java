package Vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Chronologie;

public class PanelGeneral extends JPanel implements ActionListener {
	
	private String[] intitulesPanneaux = {"Création", "Affichage", "Quitter"};
	String[] itemsCreation = {"Nouvelle Frise", "Charger Frise", "Ajouter un événement", "Supprimer un événement"};
	private CardLayout gestionnaireCartes;
	Controleur controleur;
	private Chronologie chronologie;
	private PanelAffichage panelAffichage;
	private PanelCreation panelCreation;
	
	public PanelGeneral(){
		
		chronologie=new Chronologie(); 
		gestionnaireCartes=new CardLayout(2,2);
		this.setLayout(gestionnaireCartes);
		
		panelCreation=new PanelCreation(chronologie);
		this.add(panelCreation, intitulesPanneaux[0]);
		panelAffichage = new PanelAffichage(chronologie);
		controleur= new Controleur(panelCreation, this, panelAffichage);
		this.add(panelAffichage, intitulesPanneaux[1]);
		
		
	}
	
	public void setChronologie(Chronologie parChronologie){
		chronologie=parChronologie;
		panelAffichage=new PanelAffichage(chronologie);
		this.add(panelAffichage, intitulesPanneaux[1]);
	}
	
	public Chronologie getChronologie(){
		return chronologie;
	}
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getActionCommand() == "Nouvelle Frise"){
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelCreation.getGestionnaireDeCartes().show(panelCreation, itemsCreation[0]);
		}
		
		else if(evt.getActionCommand() == "Charger Frise"){
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelCreation.getGestionnaireDeCartes().show(panelCreation, itemsCreation[1]);
		}
		
		else if(evt.getActionCommand() == "Ajouter un événement"){
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelCreation.getGestionnaireDeCartes().show(panelCreation, itemsCreation[2]);
		}
		
		else if(evt.getActionCommand() == "Supprimer un événement"){
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelCreation.getGestionnaireDeCartes().show(panelCreation, itemsCreation[3]);
		}
		
		
		else if(evt.getActionCommand() == "Affichage"){
			gestionnaireCartes.show(this, intitulesPanneaux[1]);
		}
		else if(evt.getActionCommand() == "Quitter"){
			
			JOptionPane confirmation=new JOptionPane();
		
			int code= confirmation.showConfirmDialog(null, "Voulez vous vraiment quitter?","Arret du programme",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(code== JOptionPane.OK_OPTION) {
			System.exit(code);
			}
			
		}
		else if(evt.getActionCommand() == "?"){
			JOptionPane information=new JOptionPane();
			information.showMessageDialog(null,"Informations à propos de mon projet\n\n Ce projet a été créé par \nLouis Bizot dans le cadre du projet\n de Java ,second semestre de 3ème année.","Information",JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
}
