package si.unimb.ruk.prijatelj.logika.osebe;

/**
 * @author Joze
 *
 */
public class Potnik extends Oseba{
	private String kontaktnaStevilka;
	private String naslov;
	private String posta;
	private String postnaStevilka;
	
	
	/**
	 * 
	 */
	public Potnik() {
		super();
		kontaktnaStevilka = new String();
		naslov = new String();
		posta = new String();
		postnaStevilka = new String();				
	}
	
	/**
	 * @param kontaktnaStevilka
	 * @param naslov
	 * @param posta
	 * @param postnaStevilka
	 */
	public Potnik(String kontaktnaStevilka, String naslov, String posta, String postnaStevilka)
	{
		this.kontaktnaStevilka = kontaktnaStevilka;
		this.naslov = naslov;
		this.posta = posta;
		this.postnaStevilka = postnaStevilka;		
	}
	
	/**
	 * @return
	 */
	public String getKontaktnaStevilka() {
		return kontaktnaStevilka;
	}
	
	/**
	 * @param kontaktnaStevilka
	 */
	public void setKontaktnaStevilka(String kontaktnaStevilka) {
		this.kontaktnaStevilka = kontaktnaStevilka;
	}
	
	/**
	 * @return
	 */
	public String getNaslov() {
		return naslov;
	}
	
	/**
	 * @param naslov
	 */
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	
	/**
	 * @return
	 */
	public String getPosta() {
		return posta;
	}
	
	/**
	 * @param posta
	 */
	public void setPosta(String posta) {
		this.posta = posta;
	}
	
	/**
	 * @return
	 */
	public String getPostnaStevilka() {
		return postnaStevilka;
	}
	
	/**
	 * @param postnaStevilka
	 */
	public void setPostnaStevilka(String postnaStevilka) {
		this.postnaStevilka = postnaStevilka;
	}
	
	/* (non-Javadoc)
	 * @see si.unimb.ruk.prijatelj.logika.osebe.Oseba#toString()
	 */
	public String toString() {
		String str = super.toString();
		str = str + "\n Kontakt: "+ kontaktnaStevilka + "\n";
		str = str + "Naslov: "+ naslov + "\n";		
		str = str + "Postna st.: "+ postnaStevilka + "\n";
		str = str + "Posta: "+ posta + "\n";
		
		return str;
	}
	
}
