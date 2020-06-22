package Vue;

import java.awt.Image;
import java.io.File;
import java.util.StringTokenizer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Modele.Evenement;

public class EtiquetteEvt extends JLabel {
	
	private Evenement evenement;
	
	/** Construit une etiquette repr�sentant un �v�nement avec 
	 * une image et du texte, gr�ce � l'adresse d'une image contenue 
	 * dans ses champs et � la m�thode descriptionEvtToHTML qui cr�e
	 * du texte � placer � c�t� de l'image.
	 * 
	 * @param parEvenement 
	 */
	
	public EtiquetteEvt(Evenement parEvenement) {
		super("", JLabel.CENTER);
		evenement = parEvenement;
		ImageIcon originale = new ImageIcon(evenement.getAdrImage());
		ImageIcon redimensionnee = new ImageIcon(originale.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
		this.setIcon(redimensionnee);
		this.setIconTextGap(18);
		this.setText(this.descriptionEvtToHTML());
	}
	
	/**
	 * Permet de r�cup�rer le titre de l'�v�nement repr�sent� par l'
	 * �tiquette
	 * @return le champ titre de l'�v�nement d�crit par l'�tiquette
	 */
	
	public Evenement getEvenement() {
		return evenement;
	}
	
	/** Transforme le titre, la date et la description d'un �v�nement en
	 * un bloc HTML divisant la description en lignes de 12 mots et mettant
	 * en forme le tout.
	 * @return une cha�ne de caract�res qui contient du code HTML
	 */
	
	public String descriptionEvtToHTML() {
		String chaineFinale = "";
		chaineFinale+= "<html>";
		chaineFinale+= "<h4><strong>" + evenement.getDate().toString() + "</strong></h4><br>";
		chaineFinale += "<h3><strong>" + evenement.getTitre() + "</strong></h3><br>";
		
		// StringTokenizer s�pare la description mot par mot. Une boucle modulo 12 permet
		// d'ajouter une balise <br> (saut de ligne) tous les 12 mots.
		
		StringTokenizer st = new StringTokenizer(evenement.getDescription());
		int i =0;
		while(st.hasMoreTokens()) {
			if(i%12 == 0) {
				chaineFinale+="<br>";
			}
			chaineFinale+=st.nextToken()+" ";
			i++;
		}
		
		
		chaineFinale+="</html>";
		return chaineFinale;
	}
}
