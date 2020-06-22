package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controleur.Controleur;

public class PanelFriseFichier extends JPanel {
	
	private JButton ajouterFriseFichier;
	private JComboBox fichiers;
	private String[] listeFichiers;
	
	public PanelFriseFichier() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints contrainteEvenement = new GridBagConstraints();
		contrainteEvenement.insets = new Insets(3,3,3,3);
	
		JLabel nomDuFichier=new JLabel("Nom du fichier");
		File repertoire = new File("chronologies");
		listeFichiers = repertoire.list();
		fichiers = new JComboBox(listeFichiers);
		
		ajouterFriseFichier=new JButton("Charger");	
		ajouterFriseFichier.setActionCommand("Fichier");
		
		
		TitledBorder borderFrise;
		borderFrise = BorderFactory.createTitledBorder( "Chargement d'une chronologie déjà existante");
		borderFrise.setTitleColor(new Color(255,0,0));
		borderFrise.setTitleFont(new Font("Serif", Font.BOLD, 20));
		borderFrise.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(borderFrise);
		
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=0;
		this.add(nomDuFichier,contrainteEvenement);
		
		contrainteEvenement.gridx=1;
		contrainteEvenement.gridy=0;
		this.add(fichiers,contrainteEvenement);
		
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=1;
		this.add(ajouterFriseFichier,contrainteEvenement);
		
	}
	
	
	public String getNomFichier(){
		int i = fichiers.getSelectedIndex();
		return (String) fichiers.getItemAt(i);
		
	}
	
	public void enregistreEcouteur(Controleur parControleur){
		ajouterFriseFichier.addActionListener(parControleur);
	}
}
