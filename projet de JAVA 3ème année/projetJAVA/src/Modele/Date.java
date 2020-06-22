package Modele;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Calendar;
 
public class Date implements Comparable <Date>, Serializable {
  private int jour;
  private int mois;
  private int annee;
   
  public Date ()   { 
	  GregorianCalendar dateAuj = new GregorianCalendar ();
	  annee = dateAuj.get (Calendar.YEAR);
	  mois = dateAuj.get (Calendar.MONTH)+1; // janvier = 0, fevrier = 1...
	  jour = dateAuj.get (Calendar.DAY_OF_MONTH);
	 
  }
  
  public Date (int parJour, int parMois, int parAnnee)   {   
	jour = parJour;
	mois = parMois;
	annee = parAnnee;		
  } 
   
  /**
   * retourne 0 si this et parDate sont egales, 
   * -1 si this precede parDate,
   *  1 si parDate precede this
   */
  public int compareTo (Date parDate) {
    if (annee < parDate.annee)
		return -1;
	if (annee > parDate.annee)
		return 1;
	// les annees sont =
	if (mois < parDate.mois)
		return -1;
	if (mois > parDate.mois)
		return 1;
	// les mois sont =
	if (jour < parDate.jour)
		return -1;
	if (jour > parDate.jour)
		return 1;
	return 0;	
  }
  
 
  public Date dateDuLendemain ()   {	
    if (jour < dernierJourDuMois(mois,annee))
		     return  new Date (jour+1,mois,annee);
		else if (mois < 12)
				return new Date (1,mois+1,annee);
			 else return new Date (1,1,annee+1);	
  }  
  
  public Date dateDeLaVeille () {    
	if (jour > 1)
			return  new Date (jour-1,mois,annee);
	else if (mois > 1)
			   return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
		 else return  new Date (31,12,annee-1);
  }	 
  
  public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
			 case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			 case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			 default : return 31 ;
			}  // switch
	  } 
	  
  private static boolean estBissextile(int parAnnee) {
			return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	  }
    
  public String toString () {
    String chaine = new String();
   
	chaine += jour + " ";
	switch (mois) {
		 case 1: chaine += "janvier"; break;
		 case 2: chaine += "fevrier"; break;
		 case 3: chaine += "mars"; break;
		 case 4: chaine += "avril"; break;
		 case 5: chaine += "mai"; break;
		 case 6: chaine += "juin"; break;
		 case 7: chaine += "juillet"; break;
		 case 8: chaine += "aout"; break;
		 case 9: chaine += "septembre"; break;
		 case 10: chaine += "octobre"; break;
		 case 11: chaine += "novembre"; break;
		 case 12: chaine += "decembre"; break;
		}	
	chaine+=" " +annee;
	return chaine;
  }  
  
  public boolean estValide() {
	  if(annee>0) {
		  if(mois>0 && mois<=12) {
			  if(jour>0 && jour<Date.dernierJourDuMois(mois, annee)) {
				  return true;
			  }
			  
		  }
	  }
	  
	  return false;
  }


  public int getAnnee() { 
	return annee;
}

public int getJour() { 
	return jour;
}

public int getMois() { 
	return mois;
}



public boolean isToday() {
	return new Date().compareTo(this) == 0;
}

}