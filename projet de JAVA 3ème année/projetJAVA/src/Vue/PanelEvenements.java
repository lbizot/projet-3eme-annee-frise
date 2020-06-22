package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Chronologie;
import Modele.Evenement;

public class PanelEvenements extends JPanel{

	private CardLayout gestionnaireDeCartes;
	private EtiquetteEvt[] tableauEtiquettesEvts;
	private String[] titresEvts;
	private JButton boutonDefilerGauche;
	private JButton boutonDefilerDroit;
	private JPanel panelDiapoEvts;
	private Chronologie chronologie;
		
		public PanelEvenements(Chronologie parChronologie){
			
			chronologie=parChronologie;
			
			boutonDefilerDroit = new JButton(">");
			boutonDefilerGauche = new JButton("<");
			boutonDefilerDroit.setActionCommand("Droite");
			boutonDefilerGauche.setActionCommand("Gauche");
			
			
			panelDiapoEvts = new JPanel();
			gestionnaireDeCartes = new CardLayout(5,5);
			panelDiapoEvts.setLayout(gestionnaireDeCartes);
			tableauEtiquettesEvts = new EtiquetteEvt[chronologie.getSizeTabEvt()];
			
			titresEvts = new String[chronologie.getSizeTabEvt()];
			
			int i =0;
			
			for(int annee : chronologie.getTabEvt().keySet()){
				for(Evenement evt : chronologie.getTabEvt().get(annee)){
					titresEvts[i]=evt.getTitre();
					tableauEtiquettesEvts[i]=new EtiquetteEvt(evt);
					panelDiapoEvts.add(tableauEtiquettesEvts[i], titresEvts[i]);
					i++;
				}
			}
			
			this.setLayout(new BorderLayout());

			
			this.add(boutonDefilerGauche, BorderLayout.WEST);
			this.add(panelDiapoEvts, BorderLayout.CENTER);
			this.add(boutonDefilerDroit, BorderLayout.EAST);
			
			this.gestionnaireDeCartes.first(panelDiapoEvts);
			
		}
		
		public Evenement estAffiche(){
			for(int i=0;i<tableauEtiquettesEvts.length;i++){
				if(tableauEtiquettesEvts[i].isVisible() == true){
					return tableauEtiquettesEvts[i].getEvenement();
				}
			}
			
			return null;
		}
		
		public void enregistreEcouteur(JPanel panel){
			boutonDefilerDroit.addActionListener((ActionListener) panel);
			boutonDefilerGauche.addActionListener((ActionListener) panel);
		}
		
		public CardLayout getCardLayout() {
			return gestionnaireDeCartes;
		}
		
		public JPanel containerCardLayout() {
			return panelDiapoEvts;
		}
		
		public JPanel getPanelDiapoEvts(){
			return panelDiapoEvts;
		}

	
}
