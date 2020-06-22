package Vue;

import java.awt.Component;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import Modele.Evenement;

public class CelluleRenderer extends JLabel implements TableCellRenderer{
	public CelluleRenderer() {
		super();
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object adrImage, boolean estSelectionne, 
			boolean aLeFocus, int ligne, int colonne) {
		String evenement = (String) adrImage;
		ImageIcon originale= new ImageIcon(evenement);
		
		ImageIcon redimensionnee = new ImageIcon(originale.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
		this.setIcon(redimensionnee);
		return this;
	}

}
