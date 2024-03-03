package biblioteka.interfejs;


import biblioteka.Autor;
import biblioteka.Knjiga;

import java.util.List;

/**
 * Prestavlja osnovne funkcionalnosti biblioteke sa dodavanjem knjiga, brisanjem, pretrazivanjem...
 *
 * Ostavlja se da podklase implementiraju ove metode koriscenjem nekih kolekcija ili struktura podataka
 *
 * @author Bojan Tomic
 *
 */
public interface BibliotekaInterfejs {

	/**
	 * Dodaje knjigu u biblioteku
	 *
	 * Duplikati i null vrednosti nisu dozvoljeni.
	 *
	 * @param knjiga Knjiga koju treba dodati u biblioteku.
	 *
	 * @throws java.lang.NullPointerException Ako je uneta knjiga null.
	 * @throws java.lang.IllegalArgumentException Ako uneta knjiga vec postoji u biblioteci.
	 */
	void dodajKnjigu(Knjiga knjiga);

	/**
	 * Brise knjigu iz biblioteke.
	 *
	 * Ako takva knjiga ne postoji ili ako je uneta null vrednost nista se ne desava.
	 *
	 * @param knjiga Knjiga koju treba obrisati iz biblioteke.
	 */
	void obrisiKnjigu(Knjiga knjiga);

	/**
	 * Vraca sve knjige iz biblioteke.
	 *
	 * @return Lista sa svim knjigama.
	 */
	List<Knjiga> vratiSveKnjige();

	/**
	 * Pronalazi i vraca listu knjiga koji odgovaraju kriterijumima pretrage.
	 *
	 * Vrsi pretragu prema kriterijumima koji su uneti. Pri tome gleda se deo naslova (ne mora da bude tacan naslov),
	 * a ako nije unet neki kriterijum (null vrednost ili 0 za isbn), onda se taj kriterijum ne razmatra.
	 *
	 * @param autor Autor knjige
	 * @param isbn isbn broj knjige
	 * @param naslov naslov knjige
	 * @param izdavac izdavac knjige
	 *
	 * @return lista knjiga koji odgovaraju kriterijumima pretrage
	 *
	 * @throws java.lang.IllegalArgumentException ako nije unet nijedan kriterijum pretrage.
	 */
	List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac);

}
