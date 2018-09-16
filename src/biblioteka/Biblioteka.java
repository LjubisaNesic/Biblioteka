package biblioteka;

import java.util.ArrayList;
import java.util.Date;

public class Biblioteka {
  
    private ArrayList<Racun> racuni = new ArrayList<>();
    private ArrayList<Knjiga> knjige = new ArrayList<>();
    
    /** no arg konstruktor */
    public Biblioteka() {
    	
        }

    /** metoda za provjeru da li je racun dupli */
    private boolean isNotDoubleRacun(int brojRacuna) throws Exception {
	boolean isNotDouble = true;
	if(racuni.size()> 0) {
	    for(int i = 0; i < racuni.size(); i++) {
		if(racuni.get(i).getBrojRacuna() == brojRacuna) {
		    isNotDouble = false;
		    break;
		}
	    }
	}
	return isNotDouble;
    }
    
    
    /** metoda za prvjeru da li racun sa datim brojem postoji */
    private int postojeciIndeksRacuna(int brojRacuna) throws Exception{
	int indeks = -1;
	for (int i = 0; i < racuni.size(); i++) {
	    if(racuni.get(i).getBrojRacuna() == brojRacuna) {
		indeks = i;
	    }
	}
	if (indeks >= 0) {
	    return indeks;
	} else {
	    throw new Exception("Racun sa tim brojem ne postoji!");
	}
    }
    
    
    /** metoda za kreiranje novog racuna */
    public void kreirajRacun(int brojRacuna, String imeMusterije) throws Exception{
	if(isNotDoubleRacun(brojRacuna)) {
	    Racun racun = new Racun(brojRacuna, imeMusterije);
	    racuni.add(racun);
	    System.out.printf("Racun %s kreiran!", imeMusterije);
	    System.out.println();
	} else {
	    throw new Exception("Racun sa tim brojem vec postoji.");
	}
    }
    
    /** metoda za provjeru da li je knjiga dupla */
    private boolean isNotDoubleKnjiga(int brojKnjige) throws Exception {
	boolean isNotDouble = true;
	if(knjige.size()> 0) {
	    for(int i = 0; i < knjige.size(); i++) {
		if(knjige.get(i).getBrojKnjige() == brojKnjige) {
		    isNotDouble = false;
		    break;
		}
	    }
	}
	return isNotDouble;
    }
    
    /** metoda za prvjeru da li knjiga sa datim brojem postoji */
    private int postojeciIndeksKnjige(int brojKnjige) throws Exception{
	int indeks = -1;
	for (int i = 0; i < knjige.size(); i++) {
	    if(knjige.get(i).getBrojKnjige() == brojKnjige) {
		indeks = i;
	    }
	}
	if (indeks >= 0) {
	    return indeks;
	} else {
	    throw new Exception("Racun sa tim brojem ne postoji!");
	}
    }
  
    /** metoda za kreiranje nove knjige*/
    public void kreiranjKnjigu(int brojKnjige, String imeKnjige) throws Exception{
	if(isNotDoubleKnjiga(brojKnjige)) {
	    Knjiga knjiga = new Knjiga(brojKnjige, imeKnjige);
	    knjige.add(knjiga);
	    System.out.printf("Knjiga %s je kreirana", imeKnjige);
	    System.out.println();
	} else {
	    throw new Exception("Knjiga sa tim brojem vec postoji.");
	}
    }
    
    public void podizanjeKnjige(int brojRacuna, int brojKnjige, Date datumIzdavanja) throws Exception{
	try {
	    int indeksRacuna = postojeciIndeksRacuna(brojRacuna);
	    int indeksKnjige = postojeciIndeksKnjige(brojKnjige);
	    if (!knjige.get(indeksKnjige).isIzdata()) {
		racuni.get(indeksRacuna).setBrojPosudjenihKnjiga(racuni.get(indeksRacuna).getBrojPosudjenihKnjiga()+1);
        	knjige.get(indeksKnjige).setIzdata(true);
        	knjige.get(indeksKnjige).setDatumIzdavanja(datumIzdavanja); 
        	System.out.println("Musterija " + racuni.get(indeksRacuna).getImeMusterije() + " je podigao knjigu " + knjige.get(indeksKnjige).getImeKnjige());
	    } else {
		System.out.println("Knjiga je vec izdata.");
	    }
	} catch (Exception ex) {
	    throw new Exception("Ne ispravan unos", ex);
	}
    }
    
    public void vracanjeKnjige(int brojRacuna, int brojKnjige) throws Exception{
	try {
	    int indeksRacuna = postojeciIndeksRacuna(brojRacuna);
	    int indeksKnjige = postojeciIndeksKnjige(brojKnjige);
	    if (knjige.get(indeksKnjige).isIzdata()) {
		racuni.get(indeksRacuna).setBrojPosudjenihKnjiga(racuni.get(indeksRacuna).getBrojPosudjenihKnjiga()-1);
        	knjige.get(indeksKnjige).setIzdata(false);
        	knjige.get(indeksKnjige).setDatumIzdavanja(null);
        	System.out.println("Musterija " + racuni.get(indeksRacuna).getImeMusterije() + " je vratio knjigu " + knjige.get(indeksKnjige).getImeKnjige());
        	System.out.println();
	    } else {
		System.out.println("Knjiga jos nije izdata");
	    }
	} catch (Exception ex) {
	    throw new Exception("Ne ispravan unos", ex);
	}
    }
    
    public void informacije() {
	if(racuni.size() < 1) {
	    System.out.println("Nema kreiranih racuna!");
	    System.out.println();
	} else {
	    for (int i = 0; i < racuni.size(); i++) {
		System.out.print(i + 1 + " ");
		System.out.println(racuni.get(i).toString());
	    }
	}
	
	if (knjige.size() < 1) {
	    System.out.println("Nema kreiranih knjiga!");
	    System.out.println();
	} else {
	    for (int i = 0; i < knjige.size(); i++) {
		System.out.print(i + 1 + " ");
		System.out.println(knjige.get(i).toString());
	    }
	}
    }
    
}