package biblioteka;

import java.util.List;
import java.util.Objects;

/**
 * Predstavlja knjigu.
 * <p>
 * Sadrzi osnovne podatke o knjizi: naslov, ISBN, autore, izdavaca i izdanje.
 *
 * @author Danilo Cerovic
 * @version 1.0
 */
public class Knjiga {

	/**
	 * Naslov knjige kao String.
	 */
	private String naslov;

	/**
	 * ISBN knjige kao String.
	 */
	private long isbn;

	/**
	 * Lista svih autora knjige.
	 */
	private List<Autor> autori;

	/**
	 * Izdavac knjige kao String.
	 */
	private String izdavac;

	/**
	 * Izdanje knjige kao String.
	 */
	private int izdanje;

	/**
	 * Kreira praznu knjigu.
	 */
	public Knjiga() {
	}

	/**
	 * Kreira knjigu i postavlja naslov, ISBN, autore, izdavaca i izdanje.
	 *
	 * @param naslov naslov knjige
	 * @param isbn ISBN knjige
	 * @param autori lista autora knjige
	 * @param izdavac izdavac knjige
	 * @param izdanje izdanje knjige
	 */
	public Knjiga(String naslov, long isbn, List<Autor> autori, String izdavac, int izdanje) {
		setNaslov(naslov);
		setIsbn(isbn);
		setAutori(autori);
		setIzdavac(izdavac);
		setIzdanje(izdanje);
	}

	/**
	 * Vraca naslov knjige.
	 *
	 * @return naslov knjige kao String.
	 */
	public String getNaslov() {
		return naslov;
	}

	/**
	 * Postavlja naslov knjige.
	 *
	 * @param naslov naslov knjige kao String. Ne sme biti null ili prazan.
	 *
	 * @throws java.lang.NullPointerException Ako je unet naslov null.
	 * @throws java.lang.IllegalArgumentException Ako je unet naslov prazan string.
	 */
	public void setNaslov(String naslov) {
		if (naslov == null)
			throw new NullPointerException("Naslov ne sme biti null");
		
		if (naslov.isEmpty())
			throw new IllegalArgumentException("Naslov ne sme biti prazan");
		
		this.naslov = naslov;
	}

	/**
	 * Vraca ISBN knjige.
	 *
	 * @return ISBN knjige kao long.
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Postavlja ISBN knjige.
	 *
	 * @param isbn ISBN knjige kao long. Mora biti veci od nule.
	 *
	 * @throws java.lang.IllegalArgumentException Ako je unet ISBN nula ili manji od nule.
	 */
	public void setIsbn(long isbn) {
		if (isbn <= 0)
			throw new IllegalArgumentException("ISBN ne sme biti nula niti manji");
		
		this.isbn = isbn;
	}

	/**
	 * Vraca sve autore knjige.
	 *
	 * @return lista autora knjige.
	 */
	public List<Autor> getAutori() {
		return autori;
	}

	/**
	 * Postavlja autore knjige.
	 *
	 * @param autori lista autora knjige.
	 */
	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}


	/**
	 * Vraca izdavaca knjige.
	 *
	 * @return izdavac knjige kao String.
	 */
	public String getIzdavac() {
		return izdavac;
	}


	/**
	 * Postavlja izdavaca knjige.
	 *
	 * @param izdavac izdavac knjige kao String. Ne sme biti null ili prazno.
	 *
	 * @throws java.lang.NullPointerException Ako je unet izdavac null.
	 * @throws java.lang.IllegalArgumentException Ako je unet izdavac prazan string.
	 */
	public void setIzdavac(String izdavac) {
		if (izdavac == null)
			throw new NullPointerException("Izdavac ne sme biti null");
		
		if (izdavac.isEmpty())
			throw new IllegalArgumentException("Izdavac ne sme biti prazan");		
		
		this.izdavac = izdavac;
	}

	/**
	 * Vraca izdanje knjige.
	 *
	 * @return izdanje knjige kao int.
	 */
	public int getIzdanje() {
		return izdanje;
	}

	/**
	 * Postavlja izdanje knjige.
	 *
	 * @param izdanje izdanje knjige kao int. Ne sme biti manje od jedan.
	 *
	 * @throws java.lang.IllegalArgumentException Ako je uneto izdanje manje od jedan.
	 */
	public void setIzdanje(int izdanje) {
		if (izdanje < 1)
			throw new IllegalArgumentException("Izdanje mora biti 1 ili vece");
		
		this.izdanje = izdanje;
	}

	/**
	 * Vraca String sa svim podacima o knjizi u odredjenom formatu.
	 * <p>
	 * Primer formata:
	 * "Knjiga [naslov=Na Drini Cuprija, isbn=97804510, autori:[ime=Ivo, prezime=Andric],
	 * izdavac: Dereta, izdanje: 6 ]"
	 *
	 * @return String sa svim podacima o knjizi u odredjenom formatu.
	 */
	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}

	/**
	 * Vraca hashCode izracunat na osnovu vrednosti ISBN-a knjige.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	/**
	 * Poredi dve knjige prema ISBN-u.
	 *
	 * @param obj Knjiga sa kojom ce da se poredi.
	 *
	 * @return
	 * <ul>
	 *    	<li><b>true</b> ako obe knjige imaju isti ISBN</li>
	 *    	<li><b>false</b> ako je uneti objekat null, ako nije klase Knjiga ili ako nije isti ISBN</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return isbn == other.isbn;
	}
	
	
}
