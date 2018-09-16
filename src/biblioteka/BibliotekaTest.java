package biblioteka;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotekaTest {
    
    private static void pomocnaMetodaZaTestiranje(Biblioteka biblioteka, Date datumIzdavanja) {
	try {
	biblioteka.kreirajRacun(1, "Ljubisa Nesic");
	biblioteka.kreirajRacun(2, "Saban Saulic");
	biblioteka.kreiranjKnjigu(1, "Magerece godine");
	biblioteka.kreiranjKnjigu(2, "Dozivljaji macka Tose");
	biblioteka.kreiranjKnjigu(3, "Cardak ni na nebu ni na zemlji");
	biblioteka.kreiranjKnjigu(4, "Java Osnove");
	biblioteka.podizanjeKnjige(1, 1, datumIzdavanja);
	biblioteka.podizanjeKnjige(1, 2, datumIzdavanja);
	biblioteka.podizanjeKnjige(1, 3, datumIzdavanja);
	
	biblioteka.vracanjeKnjige(1, 2);
	biblioteka.podizanjeKnjige(2, 4, datumIzdavanja);
	
	} catch(Exception ex) {
	    System.out.println(ex.getMessage());
	    ex.printStackTrace();
	}
	
    }

    public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	
	Biblioteka biblioteka = new Biblioteka();
	Date datumIzdavanja = new Date();
	
	pomocnaMetodaZaTestiranje(biblioteka, datumIzdavanja);
	
	
	byte opcija = -1;
	
	while (opcija != 0) {
	    try {
		System.out.println("Izaberite opciju:" + "\n1. -> kreiranje racuna" + "\n2. -> kreiranje knjige" +
	    "\n3. -> podizanje knjige" + "\n4. -> vracanje knjige" + "\n5. -> ispisivanje detalja postojecih racuna i knjiga" + "\n0. -> izlaz");
		
		System.out.println();
		
		opcija = input.nextByte();
		
        		if (opcija == 1) {
        		    try {
        			System.out.print("Unesite broj novog racuna: ");
        			int brojRacuna = input.nextInt();
        			input.nextLine();
        			System.out.print("Unesite ime musterije: ");
        			String imeMusterije = input.nextLine();
        			
        			biblioteka.kreirajRacun(brojRacuna, imeMusterije);
        		    } catch (Exception ex) {
        			ex.printStackTrace();
        		    }
        		    
        		}
        		
        		else if (opcija == 2) {
        		    try {
        		    System.out.print("Unesite broj nove knjige: ");
        		    int brojKnjige = input.nextInt();
        		    input.nextLine();
        		    System.out.print("Unesite ime knjige: ");
        		    String imeKnjige = input.nextLine();
        		    
        		    biblioteka.kreiranjKnjigu(brojKnjige, imeKnjige);
        		    } catch(Exception ex) {
        			ex.printStackTrace();
        		    }
        		}
        		
        		else if (opcija == 3) {
        		    try {
        			System.out.print("Unesite broj racuna musterije koja/i dize knjigu: ");
        			int brojRacuna = input.nextInt();
        			System.out.print("Unesite broj knjige koju izdajete: ");
        			int brojKnjige = input.nextInt();
        			datumIzdavanja = new Date();
        			
        			biblioteka.podizanjeKnjige(brojRacuna, brojKnjige, datumIzdavanja);
        		    } catch (Exception ex) {
        			ex.printStackTrace();
        		    }
        		}
        		
        		else if (opcija == 4) {
        		    try {
        			System.out.print("Unesite broj racuna musterije koja/i vraca knjigu: ");
        			int brojRacuna = input.nextInt();
        			System.out.print("Unesite broj knjige koju musterija vraca: ");
        			int brojKnjige = input.nextInt();
        			
        			biblioteka.vracanjeKnjige(brojRacuna, brojKnjige);
        		    } catch(Exception ex) {
        			ex.printStackTrace();
        		    }
        		}
        		
        		else if (opcija == 5) {
        		    biblioteka.informacije();
        		    System.out.println();
        		}
		
        		while (opcija < 0 && opcija > 5) {
        		    System.out.println("Pogresan unos!");
        		    System.out.println("Izaberite opciju:" + "\n1. -> kreiranje racuna" + "\n2. -> kreiranje knjige" +
        			    "\3. -> podizanje knjige" + "\n4. -> vracanje knjige" + "\5. -> ispisivanje detalja postojecih racuna i knjiga" + "\n0. -> izlaz");
        		    
        		    System.out.println();
        		    opcija = input.nextByte();
        		}
		
		
	    } catch(InputMismatchException ex) {
		System.out.println("Pogresan unos!");
		input.nextLine();
	    }
	    
	}
	
	System.out.println("Kraj aplikacije!");
	input.close();
	
    }

}
