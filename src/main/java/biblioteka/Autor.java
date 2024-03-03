package biblioteka;

import java.util.Objects;

/**
 * Predstavlja autora knjige.
 *
 * Sadrzi osnovne podatke o autoru: ime, prezime.
 *
 * @author Bojan Tomic
 * @version 1.0
 */
public class Autor {

	/**
	 * Ime autora kao String.
	 */
	private String ime;

	/**
	 * Prezime autora kao String.
	 */
	private String prezime;

	/**
	 * Kreira praznog autora.
	 *
	 */
	public Autor() {
	}

	/**
	 * Kreira autora i postavlja ime i prezime.
	 *
	 * @param ime ime autora
	 * @param prezime prezime autora
	 */
	public Autor(String ime, String prezime) {
		setIme(ime);
		setPrezime(prezime);
	}

	/**
	 * Vraca ime autora.
	 *
	 * @return ime autora kao String.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime autora.
	 *
	 * @param ime ime autora kao String. Ne sme biti null ili prazno.
	 *
	 * @throws java.lang.NullPointerException Ako je uneto ime null.
	 * @throws java.lang.IllegalArgumentException Ako je uneto ime prazan string.
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null");
		
		if (ime.isEmpty())
			throw new IllegalArgumentException("Ime ne sme biti prazno");
		
		this.ime = ime;
	}

	/**
	 * Vraca prezime autora.
	 *
	 * @return prezime autora kao String.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime autora.
	 *
	 * @param prezime prezime autora kao String. Ne sme biti null ili prazno.
	 *
	 * @throws java.lang.NullPointerException ako je uneto prezime null.
	 * @throws java.lang.IllegalArgumentException ako je uneto prezime prazan String.
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");
		
		if (prezime.isEmpty())
			throw new IllegalArgumentException("Prezime ne sme biti prazno");

		this.prezime = prezime;
	}

	/**
	 * Vraca String sa svim podacima o autoru u odredjenom formatu.
	 *
	 * Primer formata:
	 * "Autor [ime=Pera, prezime=Peric]"
	 *
	 * @return String sa svim podacima o autoru u odredjenom formatu.
	 */
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}


	/**
	 * Vraca hashCode izracunat na osnovu vrednosti imena i prezimena autora.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}

	/**
	 * Poredi dva autora prema imenu i prezimenu.
	 *
	 * @param obj Autor sa kojim ce da se poredi.
	 *
	 * @return
	 * <ul>
	 *    	<li><b>true</b> ako oba autora imaju isto ime i prezime</li>
	 *    	<li><b>false</b> ako je uneti objekat null, ako nije klase Autor ili ako nisu isti ime i prezime</li>
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
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	
}
