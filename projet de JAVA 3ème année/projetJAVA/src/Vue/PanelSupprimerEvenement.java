package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Controleur.Controleur;
import Modele.Chronologie;
import Modele.Evenement;

public class PanelSupprimerEvenement extends JPanel {

		private JButton supprimerEvenement;
		private JTextField nomEvtTexte;
		
		public PanelSupprimerEvenement(Chronologie chronologie) {
			supprimerEvenement = new JButton("Supprimer");
			JLabel evenementEtiquette = new JLabel("Titre de l'événement");
			nomEvtTexte = new JTextField(10);
			
			
			this.setLayout(new GridBagLayout());
			GridBagConstraints contrainteEvenement = new GridBagConstraints();
			contrainteEvenement.insets = new Insets(3,3,3,3);
			
			TitledBorder borderFrise;
			borderFrise = BorderFactory.createTitledBorder("Supprimer un événement");
			borderFrise.setTitleColor(new Color(255,0,0));
			borderFrise.setTitleFont(new Font("Serif", Font.BOLD, 20));
			borderFrise.setTitleJustification(TitledBorder.CENTER);
			this.setBorder(borderFrise);
			
			contrainteEvenement.gridx=0;
			contrainteEvenement.gridy=0;
			this.add(evenementEtiquette,contrainteEvenement);
			
			contrainteEvenement.gridx=1;
			contrainteEvenement.gridy=0;
			this.add(nomEvtTexte,contrainteEvenement);
			
			contrainteEvenement.gridx=0;
			contrainteEvenement.gridy=1;
			this.add(supprimerEvenement,contrainteEvenement);
			
			supprimerEvenement.setActionCommand("Supprimer un événement");
			
		}

		public void viderFormulaire(){
			nomEvtTexte.setText("");
		}
		
		public String getNomEvt(){
			return nomEvtTexte.getText();
		}
		
		public void enregistreEcouteur(Controleur parControleur){
			supprimerEvenement.addActionListener(parControleur);
		}
}
