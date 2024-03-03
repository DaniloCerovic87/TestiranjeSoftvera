package biblioteka;

import biblioteka.interfejs.BibliotekaInterfejs;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementira BibliotekaInterfejs preko ArrayList klase koja se koristi za skladistenje knjiga.
 *
 * @author Bojan Tomic
 *
 */
public class Biblioteka implements BibliotekaInterfejs {

	/**
	 * Lista svih knjiga iz biblioteke
	 */
	private List<Knjiga> knjige = new ArrayList<>();


	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Knjiga je duplikat");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	/**
	 * Pronalazi i vraca listu knjiga koji odgovaraju kriterijumima pretrage.
	 *
	 * Vrsi pretragu samo prema naslovu (ostali kriterijumi se ignorisu).
	 * Pri tome gleda se deo naslova (ne mora da bude tacan naslov),
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
	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn < 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu");
		
		List<Knjiga> rezultati = new ArrayList<>();
		
		if (naslov!=null)
		  for (Knjiga k: knjige)
			if (k.getNaslov().toLowerCase().contains(naslov.toLowerCase().trim()))
				rezultati.add(k);		
		
		return rezultati;
	}

}
