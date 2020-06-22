package Vue;



import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Modele.Chronologie;
import Modele.Evenement;
import Modele.ModeleTable;

public class PanelTable extends JPanel {
	private Chronologie chronologie;
	private JTable tableChronologie;
	private ModeleTable modele;
	
	public PanelTable(Chronologie parChronologie){
		chronologie=parChronologie;
		modele= new ModeleTable(chronologie);
		
		tableChronologie = new JTable(modele);
		tableChronologie.setDefaultRenderer(String.class, new CelluleRenderer());
		JScrollPane scrollPane = new JScrollPane(tableChronologie, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		int nombreDeColonnes = modele.getColumnCount();
		for(int j =0; j<nombreDeColonnes; j++) {
			tableChronologie.getColumnModel().getColumn(j).setPreferredWidth(200);
		}
		
		tableChronologie.getTableHeader().setResizingAllowed(false);
		tableChronologie.getTableHeader().setReorderingAllowed(false);
		tableChronologie.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableChronologie.setRowHeight(100);
		
		
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
		
		
	}
	
	public JTable getTableChronologie() {
		return tableChronologie;
	}
	
	public void setTable(Chronologie parChronologie){
		chronologie = parChronologie;
		ModeleTable modele = new ModeleTable(chronologie);
		tableChronologie.setModel(modele);
	}

	public void scrollToVisible(Evenement evt) {
		for(int i=0;i<modele.getColumnCount();i++){
			for(int j=0;j<4;j++){
				if(modele.getValueAt(j, i)!=null && modele.getValueAt(j, i).toString().equals(evt.getAdrImage())){
					Rectangle rect = tableChronologie.getCellRect(j, i, true);
					tableChronologie.scrollRectToVisible(rect);
				}
			}
		}
		
	}




}
