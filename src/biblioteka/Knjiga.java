package biblioteka;

import java.util.Date;

public class Knjiga {
    private int brojKnjige;
    private String imeKnjige;
    private boolean izdata = false;
    private Date datumIzdavanja;
    
    private static int ukupanBrojKnjiga;

    public Knjiga() throws Exception {
	this(0, null);
    }
    
    public Knjiga(int brojKnjige, String imeKnjige) throws Exception {
	setBrojKnjige(brojKnjige);
	setImeKnjige(imeKnjige);
	
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

    public boolean isIzdata() {
        return izdata;
    }

    public void setIzdata(boolean izdata) throws Exception {
	this.izdata = izdata;
	
    }
    
    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public static int getUkupanBrojKnjiga() {
        return ukupanBrojKnjiga;
    }

    @Override
    public String toString() {
	return "Knjiga [brojKnjige=" + brojKnjige + ", imeKnjige=" + imeKnjige + ", izdata=" + izdata + ", datumIzdavanja=" + datumIzdavanja + "]";
    }
    
    

}
