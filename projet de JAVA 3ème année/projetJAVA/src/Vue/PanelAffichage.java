package Vue;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JViewport;

import Modele.Chronologie;
import Modele.Evenement;
import Modele.ModeleTable;


public class PanelAffichage extends JPanel implements MouseListener, ActionListener{
	
	private PanelEvenements etiquettesEvenements;
	private PanelTable table;
	private Chronologie chronologie;
	
	public PanelAffichage(Chronologie parChronologie){
		this.setLayout(new GridLayout(2, 1));
		chronologie = parChronologie;
		JLabel intitule=new JLabel(chronologie.getIntitule(), JLabel.CENTER);
		etiquettesEvenements = new PanelEvenements(chronologie);
		table = new PanelTable(chronologie);
		
		table.getTableChronologie().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table=(JTable) evt.getSource();
				ModeleTable model=(ModeleTable) table.getModel();
				Point point= evt.getPoint();
				int rowIndex = table.rowAtPoint(point);
				int colIndex = table.columnAtPoint(point);
				if(model.getValueAt(rowIndex, colIndex)!=null) {
						etiquettesEvenements.getCardLayout().show(etiquettesEvenements.containerCardLayout(),
						model.getHashMapEvenementIntitule().get(model.getValueAt(rowIndex, colIndex)).getTitre());
						
				}
			}
		});
		
		intitule.setFont(new Font("Serif", Font.BOLD, 20));
		
		JPanel panelHaut = new JPanel();
		panelHaut.setLayout(new BorderLayout());
		
		panelHaut.add(intitule, BorderLayout.NORTH);
		panelHaut.add(etiquettesEvenements, BorderLayout.CENTER);
		
		etiquettesEvenements.enregistreEcouteur(this);
		
		this.add(panelHaut);
		this.add(table);
		
		
		
	}
	
	
	
	public JPanel getPanelEvenements() {
		return etiquettesEvenements;
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getActionCommand().equals("Gauche")) {
			etiquettesEvenements.getCardLayout().previous(etiquettesEvenements.getPanelDiapoEvts());
			table.scrollToVisible(etiquettesEvenements.estAffiche());
		}
		if(evt.getActionCommand().equals("Droite")) {
			etiquettesEvenements.getCardLayout().next(etiquettesEvenements.getPanelDiapoEvts());
			table.scrollToVisible(etiquettesEvenements.estAffiche());
		}
		
		
	}

}
