package biblioteka;

public class Racun {
    private int brojRacuna;
    private String imeMusterije;
    private int brojPosudjenihKnjiga;

    private static int ukupanBrojRacuna;

    public Racun() throws Exception {
	this(0, null, 0);
    }

    public Racun(int brojRacuna, String imeMusterije, int brojPosudjenihKnjiga) throws Exception {
	setBrojRacuna(brojRacuna);
	setImeMusterije(imeMusterije);
	setBrojPosudjenihKnjiga(brojPosudjenihKnjiga);

	ukupanBrojRacuna++;
    }

    public int getBrojRacuna() {
	return brojRacuna;
    }

    private void setBrojRacuna(int brojRacuna) throws Exception {
	if (brojRacuna >= 0) {
	    this.brojRacuna = brojRacuna;
	} else {
	    throw new Exception("Broj racuna mora biti pozitivan.");
	}
    }

    public String getImeMusterije() {
	return imeMusterije;
    }

    private void setImeMusterije(String imeMusterije) throws Exception {
	boolean isLetter = true;
	for (int i = 0; i < imeMusterije.length(); i++) {
	    if (!Character.isLetter(imeMusterije.charAt(i)) && !(imeMusterije.charAt(i) == ' ')) {
		isLetter = false;
		break;
	    }
	}
	if (isLetter) {
	    this.imeMusterije = imeMusterije;
	} else {
	    throw new Exception("Karakteri imena mogu da budu samo slova.");
	}
    }

    public int getBrojPosudjenihKnjiga() {
	return brojPosudjenihKnjiga;
    }

    private void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) throws Exception {
	if (brojPosudjenihKnjiga <= 3) {
	    this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
	} else {
	    throw new Exception(getImeMusterije() + " vec ima 3 posudjene knjige (maximalan broj).");
	}
    }

    public static int getUkupanBrojRacuna() {
	return ukupanBrojRacuna;
    }

    @Override
    public String toString() {
	return "Racun [brojRacuna=" + brojRacuna + ", imeMusterije=" + imeMusterije + ", brojPosudjenihKnjiga="
		+ brojPosudjenihKnjiga + "]";
    }

}
