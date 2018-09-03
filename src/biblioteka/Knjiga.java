package biblioteka;

public class Knjiga {
    private int brojKnjige;
    private String imeKnjige;
    private boolean statusKnjige;
    
    private static int ukupanBrojKnjiga;

    public Knjiga() throws Exception {
	this(0, null, false);
    }
    
    public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) throws Exception {
	setBrojKnjige(brojKnjige);
	setImeKnjige(imeKnjige);
	setStatusKnjige(statusKnjige);
    }

    public int getBrojKnjige() {
        return brojKnjige;
    }

    private void setBrojKnjige(int brojKnjige) throws Exception {
	if (brojKnjige >= 0) {
        this.brojKnjige = brojKnjige;
	} else {
	    throw new Exception("Broj knjige mora biti pozitivan");
	}
    }

    public String getImeKnjige() {
        return imeKnjige;
    }

    private void setImeKnjige(String imeKnjige) {
        this.imeKnjige = imeKnjige;
    }

    public boolean isStatusKnjige() {
        return statusKnjige;
    }

    private void setStatusKnjige(boolean statusKnjige) throws Exception {
	if(statusKnjige == false || statusKnjige == true) {
        this.statusKnjige = statusKnjige;
	} else {
	    throw new Exception("Pogresan unos! (Dozvoljeno: false/true)");
	}
    }

    public static int getUkupanBrojKnjiga() {
        return ukupanBrojKnjiga;
    }

    @Override
    public String toString() {
	return "Knjiga [brojKnjige=" + brojKnjige + ", imeKnjige=" + imeKnjige + ", statusKnjige=" + statusKnjige + "]";
    }
    
    

}
