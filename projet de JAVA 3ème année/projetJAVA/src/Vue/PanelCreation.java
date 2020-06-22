package Vue;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Controleur;
import Modele.Chronologie;

public class PanelCreation extends JPanel{

	
	private PanelNouvelleFrise panelNouvelleFrise;
	private PanelFriseFichier panelFriseFichier;
	private PanelAjoutEvenement panelAjoutEvenement;
	private CardLayout gestionnaireDeCartes;
	private PanelSupprimerEvenement panelSuppressionEvenement;

	public PanelCreation(Chronologie parChronologie){
		
		panelFriseFichier =new PanelFriseFichier();
		panelNouvelleFrise = new PanelNouvelleFrise();
		panelAjoutEvenement = new PanelAjoutEvenement();
		panelSuppressionEvenement = new PanelSupprimerEvenement(parChronologie);
		
		gestionnaireDeCartes = new CardLayout(3,3);
		this.setLayout(gestionnaireDeCartes);
		
		this.add(panelNouvelleFrise, "Nouvelle Frise");
		this.add(panelFriseFichier, "Charger Frise");
		this.add(panelAjoutEvenement, "Ajouter un événement");
		this.add(panelSuppressionEvenement, "Supprimer un événement");
	}
	
	public PanelNouvelleFrise getPanelNouvelleFrise() {
		return panelNouvelleFrise;
	}
	
	public PanelFriseFichier getPanelFriseFichier() {
		return panelFriseFichier;
	}
	
	public PanelAjoutEvenement getPanelAjoutEvenement() {
		return panelAjoutEvenement;
	}
	
	public PanelSupprimerEvenement getPanelSuppressionEvenement() {
		return panelSuppressionEvenement;
	}
	
	public CardLayout getGestionnaireDeCartes() {
		return gestionnaireDeCartes;
	}
	
	public void enregistreEcouteur(Controleur parControleur){
		panelNouvelleFrise.enregistreEcouteur(parControleur);
		panelFriseFichier.enregistreEcouteur(parControleur);
		panelAjoutEvenement.enregistreEcouteur(parControleur);
		panelSuppressionEvenement.enregistreEcouteur(parControleur);
		
	}
}