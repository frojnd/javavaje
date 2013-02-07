// razred omogoca prodajo aranzmajev, ki jih v agenciji ponujajo
package si.unimb.ruk.prijatelj.logika;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import si.unimb.ruk.prijatelj.logika.oddihi.Izlet;
import si.unimb.ruk.prijatelj.logika.oddihi.Krizarjenje;
import si.unimb.ruk.prijatelj.logika.oddihi.Oddih;
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice;

public class Agencija {
	private List<Oddih> seznamOddihov = new ArrayList<Oddih>();

	public Agencija() { }
	
	public Agencija(ArrayList<Oddih> seznamOddihov) {
		this.seznamOddihov = seznamOddihov;
	}
	
	// dodajanje elementov v seznam oddih
	void dodajOddih(Oddih oddih) {
		seznamOddihov.add(oddih);
	}
	
	// odstranjevanje elementov iz seznama oddih
	void odstraniOddih(Oddih oddih) throws PaketAktivenException {
		if (oddih.getPonudbaPaketov().get(0).steviloRezerviranihOddihov()> 0)
		{
			throw new PaketAktivenException();
		}	
		else
			seznamOddihov.remove(oddih);
	}
	
	// prikaz elementa iz seznama oddih, ki je na "indeks", 
	// ce je indeks 3, tretji element.
	Oddih vrniOddih(int indeks) {
		return seznamOddihov.get(indeks);
	}
	
	// prikaz velikosti seznama
	int steviloOddihov() {
		return seznamOddihov.size();
	}
	
	/* 
	 * zdruzi podatke posameznih kategorij aranzmajev
	 * ter jih zdruzeno za vse tipe vrne v sledeci obliki:
	 * pocitnice - steviloRezerviranih, steviloProdanih, zasedenostKapacitet
	 * krizarjenje: steviloRezerviranih, steviloProodanih, zasedenostKapaciter
	 * izlet: steviloRezerviranih, steviloProdanih, zasedenostKapacitet
	 */
	public void porociloStanjaAgencije() {
		List<Pocitnice> seznamPocitnic = new ArrayList<Pocitnice>();
		List<Krizarjenje> seznamKrizarjenj = new ArrayList<Krizarjenje>();
		List<Izlet> seznamIzletov = new ArrayList<Izlet>();
		
		// za vsak oddih v seznamu oddihov
		for (Oddih oddih : seznamOddihov) 
		{
			// instance of je nacin preverjanja ce je dolocen objekt
			// dolocenega tipa
			if (oddih instanceof Pocitnice)
			{
				seznamPocitnic.add((Pocitnice)oddih);				
			}
			
			if (oddih instanceof Krizarjenje)
			{
				seznamKrizarjenj.add((Krizarjenje)oddih);			
			}
			
			if (oddih instanceof Izlet)
			{
				seznamIzletov.add((Izlet)oddih);			
			}
		}
		
		for (Pocitnice pocitnice : seznamPocitnic) {
			pocitnice.toString();
		}
		
		for (Krizarjenje krizarjenje : seznamKrizarjenj) {
			krizarjenje.toString();
		}
		
		for (Izlet izlet : seznamIzletov) {
			izlet.toString();
		}	
	}
	
	@SuppressWarnings("serial")
	public class PaketAktivenException extends Exception
	{
		@Override
		public String toString() {
			return "Napaka, za izbran oddih so ze rezervirana in/ali placana mesta!"; 
		}
	}
}
