/*
 * Razred Oddih razširite z naslednjimi podrazredi:
Pocitnice, ki mu dodate atributoma naziv hotela, število zvezdic hotela,prevoz (naštevalni tip z vrednostmi 
“letalski”, “avtobusni”, “vlak”, “lastni”) ter atributom naštevalnega tipa ponudba z vrednostmi 
(“nočitev”, “pol penzion”, “polni penzion”).
 */
package si.unimb.ruk.prijatelj.logika.oddihi;

public class Pocitnice extends Oddih{
	private String nazivHotela;
	private int stZvezdic;
	private Prevoz prevoz;
	private Ponudba ponudba;
	
	public enum Prevoz{letalski, avtobusni, vlak, lastni}
	public enum Ponudba{nocitev, pol_penzion,polni_penzion}
	
	public Pocitnice() {
	
	}
	
	public String getNazivHotela() {
		return nazivHotela;
	}
	public void setNazivHotela(String nazivHotela) {
		this.nazivHotela = nazivHotela;
	}
	public int getStZvezdic() {
		return stZvezdic;
	}
	public void setStZvezdic(int stZvezdic) {
		this.stZvezdic = stZvezdic;
	}
	public Prevoz getPrevoz() {
		return prevoz;
	}
	public void setPrevoz(Prevoz prevoz) {
		this.prevoz = prevoz;
	}
	public Ponudba getPonudba() {
		return ponudba;
	}
	public void setPonudba(Ponudba ponudba) {
		this.ponudba = ponudba;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
