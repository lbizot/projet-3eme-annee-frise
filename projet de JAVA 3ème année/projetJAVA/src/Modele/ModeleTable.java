package Modele;

import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

public class ModeleTable extends DefaultTableModel{
	
	Chronologie chronologie;
	String[] intitulesColonnes;
	HashMap<String, Evenement> hashMapEvenementIntitule;
	
	public ModeleTable(Chronologie parChronologie){

		chronologie=parChronologie;
		hashMapEvenementIntitule=new HashMap<String, Evenement>();
		
		setColumnCount(chronologie.getDateFin().getAnnee()-chronologie.getDateDebut().getAnnee());
		setRowCount(4);			
		
		setModeleTable(chronologie);
	}

	public void setModeleTable(Chronologie parChronologie){
		
		chronologie=parChronologie;

		int firstYear = chronologie.getDateDebut().getAnnee();
		intitulesColonnes = new String[chronologie.getDateFin().getAnnee()-chronologie.getDateDebut().getAnnee()+1];
		
		for(int i=0; i<intitulesColonnes.length; i++){
			
			if(i%chronologie.getPeriode()==0){
				intitulesColonnes[i]=Integer.toString(firstYear+i);
			}
			
			else {
				intitulesColonnes[i]="";
			}
			
		}
		
		intitulesColonnes[intitulesColonnes.length-1]=Integer.toString(chronologie.getDateFin().getAnnee());
		
		
		this.setColumnIdentifiers(intitulesColonnes);
		
		
		
		for(int annee : chronologie.getTabEvt().keySet()) {
			if(chronologie.getTabEvt().get(annee).size()!=0){
				for(Evenement evt : chronologie.getTabEvt().get(annee)){
					setValueAt(evt.getAdrImage(), 3-(evt.getPoids()-1), (intitulesColonnes.length-(chronologie.getDateFin().getAnnee()-evt.getDate().getAnnee()))-1);
					hashMapEvenementIntitule.put(evt.getAdrImage(), evt);
			}
		}
		}
		
	}
	
	public Chronologie getChronologie() {
		return chronologie;
	}
	
	public HashMap<String, Evenement> getHashMapEvenementIntitule(){
		return hashMapEvenementIntitule;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Class getColumnClass(int parNum){
		return String.class;
	}
	
}
