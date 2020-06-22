package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Controleur.Controleur;



public class PanelNouvelleFrise extends JPanel {
	
	private JButton ajouterNouvelleFrise;
	private JTextField dateDebutTexte;
	private JTextField dateFinTexte;
	private JTextField periodeTexte;
	private JTextField intituleTexte;
	private JTextField fichierTexte;
	
	public PanelNouvelleFrise() {
		
		JLabel dateDebut=new JLabel("Année de début");
		dateDebutTexte = new JTextField(10);
		JLabel dateFin=new JLabel("Année de fin");

		dateFinTexte = new JTextField(10);

		JLabel periode=new JLabel("Période");

		periodeTexte = new JTextField(10);
		JLabel intitule=new JLabel("Intitulé");

		intituleTexte = new JTextField(10);
		JLabel fichier=new JLabel("Nom du fichier");

		fichierTexte = new JTextField(10);
		ajouterNouvelleFrise= new JButton("Créer");
		
		ajouterNouvelleFrise.setActionCommand("NouvelleFrise");
		
		TitledBorder borderFrise;
		borderFrise = BorderFactory.createTitledBorder( "Création d'une Frise chronologique");
		borderFrise.setTitleColor(new Color(255,0,0));
		borderFrise.setTitleFont(new Font("Serif", Font.BOLD, 20));
		borderFrise.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(borderFrise);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints contrainteFrise = new GridBagConstraints();
		contrainteFrise.insets = new Insets(3,3,3,3);
		
		contrainteFrise.gridx=0;
		contrainteFrise.gridy=0;
		this.add(dateDebut,contrainteFrise);
		
		contrainteFrise.gridx=2;
		contrainteFrise.gridy=0;
		this.add(dateDebutTexte,contrainteFrise);
		
		contrainteFrise.gridx=0;
		contrainteFrise.gridy=1;
		this.add(dateFin,contrainteFrise);
		
		contrainteFrise.gridx=2;
		contrainteFrise.gridy=1;
		this.add(dateFinTexte,contrainteFrise);
		
		contrainteFrise.gridx=0;
		contrainteFrise.gridy=4;
		this.add(periode,contrainteFrise);
		
		contrainteFrise.gridx=2;
		contrainteFrise.gridy=4;
		this.add(periodeTexte,contrainteFrise);
		
		contrainteFrise.gridx=0;
		contrainteFrise.gridy=6;
		this.add(intitule,contrainteFrise);
		
		contrainteFrise.gridx=2;
		contrainteFrise.gridy=6;
		this.add(intituleTexte,contrainteFrise);
		
		contrainteFrise.gridx=0;
		contrainteFrise.gridy=8;
		this.add(fichier,contrainteFrise);
		
		contrainteFrise.gridx=2;
		contrainteFrise.gridy=8;
		this.add(fichierTexte,contrainteFrise);
		
		contrainteFrise.gridx=10;
		contrainteFrise.gridy=10;
		this.add(ajouterNouvelleFrise,contrainteFrise);
		
	}
	
	public String getDateDebut(){
		return dateDebutTexte.getText();
	}
	
	public String getDateFin(){
		return dateFinTexte.getText();
	}
	
	public String getPeriode(){
		return periodeTexte.getText();
	}
	
	public String getIntitule(){
		return intituleTexte.getText();
	}
	
	public String getFichier(){
		return fichierTexte.getText();
	}
	
	public void viderFormulaire(){
		dateDebutTexte.setText("");
		dateFinTexte.setText("");
		periodeTexte.setText("");
		intituleTexte.setText("");
		fichierTexte.setText("");
	}
	
	public void enregistreEcouteur(Controleur parControleur){
		ajouterNouvelleFrise.addActionListener(parControleur);
	}
}
