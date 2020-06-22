package Vue;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FenetreMereChronologie extends JFrame {
	
	public FenetreMereChronologie() {
		
		super();
		JPanel contentPane = new PanelGeneral();
		this.setContentPane(contentPane);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,600);
		this.setVisible(true);
		this.setLocation(100,100);
		String titreFenetre = "Application de Gestion de Chronologies";
		this.setTitle(titreFenetre);
		
		
		String[] items = {"Affichage", "Quitter", "?"};
		JMenuItem[] menuItem = new JMenuItem[items.length];
		
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JMenu menuCreation=new JMenu("Création");
		menuBar.add(menuCreation);
		
		String[] itemsCreation = {"Nouvelle Frise", "Charger Frise", "Ajouter un événement", "Supprimer un événement"};
		JMenuItem[] menuItemsCreation = new JMenuItem[itemsCreation.length];
		
		for(int i=0; i<itemsCreation.length;i++) {
			menuItemsCreation[i]=new JMenuItem(itemsCreation[i]);
			menuCreation.add(menuItemsCreation[i]);
			menuItemsCreation[i].setActionCommand(itemsCreation[i]);
			menuItemsCreation[i].addActionListener((ActionListener)contentPane);
		}
		
		for(int i = 0; i<items.length;i++){
			menuItem[i] = new JMenuItem(items[i]);
			menuBar.add(menuItem[i]);
			menuItem[i].setActionCommand(items[i]);
			menuItem[i].addActionListener((ActionListener) contentPane);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FenetreMereChronologie();
	}

}
