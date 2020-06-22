package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Controleur.Controleur;

public class PanelAjoutEvenement extends JPanel implements ActionListener{
	
private JButton ajouterEvenement;
	
	private JTextField dateEvt;
	private JFileChooser chooser;
	private JTextField description;
	private JTextField titreEvenement;
	private String[] etiquettePoids ={"1","2","3","4"};
	private JComboBox poids;
	private JComboBox joursEvt;
	private JComboBox moisEvt;
	private JLabel choixImage;
	
	private JLabel textePoids;
	
	public PanelAjoutEvenement() {
		ajouterEvenement=new JButton("Ajouter");	
		JLabel dateEvenement =new JLabel("Date");
		dateEvt = new JTextField(4);
		JLabel titreEvt = new JLabel("Titre de l'évenement");
		titreEvenement= new JTextField(10);
		JLabel adresseImage =new JLabel("Adresse de l'image");
		JLabel descriptionEvt  =new JLabel("Description de l'evenement");
		description = new JTextField(10);
		JButton parcourir=new JButton("Parcourir");
		choixImage = new JLabel("Aucun fichier choisi");
		parcourir.setActionCommand("Parcourir");
		parcourir.addActionListener(this);
		
		String[] listeJours = new String[31];
		String[] listeMois = new String[12];
				
		
		
		int result;
        
	    chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choisir une image");
	    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    chooser.setAcceptAllFileFilterUsed(false); 
	    
	     
		
		//remplissage de la boucle des jours fin
		
		for(int k =0; k<31 ;k++){
			listeJours[k]=Integer.toString(k+1);
		}
		
		joursEvt = new JComboBox(listeJours);
				
		//remplissage de la boucle des mois fin
				
		for(int l =0; l<12 ;l++){
			listeMois[l]=Integer.toString(l+1);
		}
		
		moisEvt = new JComboBox(listeMois);
		
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints contrainteEvenement = new GridBagConstraints();
		contrainteEvenement.insets = new Insets(3,3,3,3);
		this.add(ajouterEvenement);
		ajouterEvenement.setActionCommand("Evenement");
		
		poids = new JComboBox(etiquettePoids);
		textePoids=new JLabel("Poids");
		
		TitledBorder borderFrise;
		borderFrise = BorderFactory.createTitledBorder( "Ajout d'un événement à la frise");
		borderFrise.setTitleColor(new Color(255,0,0));
		borderFrise.setTitleFont(new Font("Serif", Font.BOLD, 20));
		borderFrise.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(borderFrise);
		

		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=0;
		this.add(dateEvenement,contrainteEvenement);
		
		contrainteEvenement.gridx=2;
		contrainteEvenement.gridy=0;
		this.add(joursEvt,contrainteEvenement);
		
		contrainteEvenement.gridx=3;
		contrainteEvenement.gridy=0;
		this.add(moisEvt,contrainteEvenement);
		
		contrainteEvenement.gridx=4;
		contrainteEvenement.gridy=0;
		this.add(dateEvt,contrainteEvenement);
		
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=2;
		this.add(titreEvt,contrainteEvenement);
		
		contrainteEvenement.gridx=2;
		contrainteEvenement.gridy=2;
		this.add(titreEvenement,contrainteEvenement);
		
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=4;
		this.add(adresseImage,contrainteEvenement);

		contrainteEvenement.gridx=2;
		contrainteEvenement.gridy=4;
		this.add(parcourir,contrainteEvenement);
		
		contrainteEvenement.gridx=4;
		contrainteEvenement.gridy=4;
		this.add(choixImage,contrainteEvenement);
		
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=6;
		this.add(descriptionEvt,contrainteEvenement);
		
		contrainteEvenement.gridx=2;
		contrainteEvenement.gridy=6;
		this.add(description,contrainteEvenement);
		
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=8;
		this.add(textePoids,contrainteEvenement);
		
		contrainteEvenement.gridx=2;
		contrainteEvenement.gridy=8;
		this.add(poids,contrainteEvenement);
		
		contrainteEvenement.gridx=6;
		contrainteEvenement.gridy=10;
		this.add(ajouterEvenement,contrainteEvenement);
		
		
	}
	
	public String getDateEvt(){
		return dateEvt.getText();
	}
	
	public int getMoisEvt() {
		return moisEvt.getSelectedIndex() +1;
	}
	
	public int getJourEvt() {
		return joursEvt.getSelectedIndex() +1;
	}
	
	public String getAdrImg(){
		return chooser.getSelectedFile().getAbsolutePath();
	}
	
	public String getDescription(){
		return description.getText();
	}
	
	public String getTitreEvenementt(){
		return titreEvenement.getText();
	}
	
	public int getPoids(){
		return poids.getSelectedIndex() +1;
	}
	
	public void enregistreEcouteur(Controleur parControleur){
		ajouterEvenement.addActionListener(parControleur);
	}
	
	public void viderFormulaire(){
		dateEvt.setText("");
		description.setText("");
		titreEvenement.setText("");
		chooser.setSelectedFile(null);
		joursEvt.setSelectedIndex(0);
		moisEvt.setSelectedIndex(0);
		choixImage.setText("Aucun fichier choisi");
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getActionCommand().equals("Parcourir")){
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
				choixImage.setText(chooser.getSelectedFile().getAbsolutePath());
			      }
			   
		}
		
	}
}
