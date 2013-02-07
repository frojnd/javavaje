/*
 * Za zaključek implementirajte še testni razred Zagonski. V zagonski metodi omenjenega 
razreda omogočite, da bo uporabnik lahko vnesel podatke o oddihih ter vnesene oddihe 
izpisal na zaslon.
 */
package si.unimb.ruk.prijatelj.logika;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import si.unimb.ruk.prijatelj.logika.oddihi.Destinacija;
import si.unimb.ruk.prijatelj.logika.oddihi.Izlet;
import si.unimb.ruk.prijatelj.logika.oddihi.Krizarjenje;
import si.unimb.ruk.prijatelj.logika.oddihi.Oddih;
import si.unimb.ruk.prijatelj.logika.oddihi.Paket;
import si.unimb.ruk.prijatelj.logika.oddihi.Paket.PaketZasedenException;
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice;
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice.Ponudba;
import si.unimb.ruk.prijatelj.logika.osebe.Potnik;
import si.unimb.ruk.prijatelj.logika.osebe.Potnik.Placilo;
import si.unimb.ruk.prijatelj.logika.osebe.Vodic;
import si.unimb.ruk.prijatelj.logika.osebe.Vodic.Jezik;
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice.Prevoz;

/**
 * @author Joze
 *
 */
public class Zagonski {
	public static void main(String args[]) {
		List<Oddih> oddihi = new ArrayList<Oddih>();
		
		Scanner sc = new Scanner(System.in);
		int y=0;
		do {
			System.out.println("-------------------------------");
			System.out.println("0: vnos podatkov o izletih");
			System.out.println("1: izpis podatkov o oddihih");
			System.out.println("2: brisanje oddiha");
			System.out.println("3: Izhod");
			System.out.println("-------------------------------");
			
			y=sc.nextInt();
			switch(y) {
			case 0:
		
				// napolnemo podatke o izletih
				Scanner scan = new Scanner(System.in);
				System.out.println("-----Podatki o izletih-----");
				
				System.out.print("Vnesi naziv oddiha: ");
				String tmp = scan.nextLine();
				Izlet izlet = new Izlet(tmp);
				
				System.out.print("Vnesi uro odhoda: ");
				String uraOdhoda = scan.nextLine();
				izlet.setUraOdhoda(uraOdhoda);
				
				System.out.print("Vnesi zbirno mesto: ");
				String zbirnoMesto = scan.nextLine();
				izlet.setZbirnoMesto(zbirnoMesto);
				
				// napolnemo podatke o vodicih
				// najprej napolnimo preko razreda Oseba
				System.out.println("-----Podati o vodicu-----");
				
				System.out.print("Vnesi ime: ");
				String imeV = scan.nextLine();
				
				System.out.print("Vnesi priimek: ");
				String priimekV = scan.nextLine();
				
				Vodic vodic = new Vodic(imeV, priimekV);
				
				System.out.print("Vnesi e-posto: ");
				String ePostaV = scan.nextLine();
				vodic.setEposta(ePostaV);
				
				System.out.println("Vnesi rojstni datum (Leto, Mesec, Dan)");
				int rojDanLV = scan.nextInt();
				int rojDanMV = scan.nextInt();
				int rojDanDV = scan.nextInt();
				GregorianCalendar rojDanV = new GregorianCalendar(rojDanLV, rojDanMV-1, rojDanDV);
				vodic.setRojstniDatum(rojDanV);
				
				System.out.println(vodic.getRojstniDatum());
				
				// nato napolnemo direktno iz razreda Vodic
				Boolean imaNimaLicenco;
				
				scan.nextLine(); // eat away :P
				System.out.print("Ali ima licenco gorskega vodnika (da / ne): ");
				String licenca = scan.nextLine();
				
				if (licenca.equals("da")) {
					imaNimaLicenco = true;
				}
				else {
					imaNimaLicenco = false;
				}
				vodic.setLicencaGorskegaVodnika(imaNimaLicenco);
				
				System.out.println("Katere jezike govori vodic: ");
				System.out.println("1 Anglesko");
				System.out.println("2 Nemsko");
				System.out.println("3 Spansko");
				System.out.println("4 Italijansko");
				System.out.println("5 Slovensko");
				System.out.println("Za vnos pritisnite stevilko jezika, za nadaljevanje pa 0");
				int stJezika = -1;
				List<Jezik> seznamJezikov = new ArrayList<Jezik>();
				while (stJezika != 0)
				{
					stJezika = scan.nextInt();
					
					switch (stJezika) {
					case 1:
						seznamJezikov.add(Jezik.Anglesko);
						break;
					case 2:
						seznamJezikov.add(Jezik.Nemsko);
						break;
					case 3:
						seznamJezikov.add(Jezik.Italijansko);
						break;
					case 4:
						seznamJezikov.add(Jezik.Spansko);
						break;
					case 5:
						seznamJezikov.add(Jezik.Slovensko);
						break;
					default:
						break;
					}					
				}
				vodic.setGovori(seznamJezikov);
				
				// napolnemo podatke o paketih
				System.out.println("-----Podati o paketu-----");
				System.out.print("Oddih (" + tmp + ")\n Vnesi st prostih mest: ");
				int prostaMesta = scan.nextInt();
				
				System.out.print("Vnesi ceno: ");
				double cena = scan.nextInt();
				
				System.out.println("Vnesi datum zacetka oddiha - leto, mesec, dan");
				int letoZ = scan.nextInt();
				int mesecZ = scan.nextInt()-1;
				int danZ = scan.nextInt();
				GregorianCalendar datumZacetka = new GregorianCalendar(letoZ, mesecZ-1, danZ);
			
				System.out.println("Vnesi koncni datum oddiha - leto, mesec, dan");
				int letoK = scan.nextInt();
				int mesecK = scan.nextInt()-1;
				int danK = scan.nextInt();
				GregorianCalendar datumKonca = new GregorianCalendar(letoK, mesecK-1, danK);
				
				scan.nextLine(); // eat away new line
				System.out.print("Vnesi naziv destinacije: ");
				String nazivD = scan.nextLine();
				
				Destinacija cilj = new Destinacija(nazivD);
				
				List<Paket> seznamPaketov = new ArrayList<Paket>();
				Paket paket = new Paket(cena, datumZacetka, datumKonca, prostaMesta);
				seznamPaketov.add(paket);
				
				List<Potnik> seznamPotnikov = new ArrayList<Potnik>();
				System.out.print("Koliko potnikov zelite vnesti: ");
				int stZeljenihPotnikov = scan.nextInt();
				for (int i=0; i<stZeljenihPotnikov; i++) {
					System.out.println("----Podatki o potniku----");
					System.out.print("Vnesi ime: ");
					scan.nextLine();
					String imePotnika = scan.nextLine();
					
					System.out.print("Vnesi priimek: ");
					String priimekPotnika = scan.nextLine();
					
					System.out.print("Vnesi eposto: ");
					String epostaPotnika = scan.nextLine();
					
					System.out.println("Vnesi rojstni datum: (Leto, Mesec, Dan)");
					int rojDanLP = scan.nextInt();
					int rojDanMP = scan.nextInt();
					int rojDanDP = scan.nextInt();
					GregorianCalendar rojDanP = new GregorianCalendar(rojDanLP, rojDanMP-1, rojDanDP);
					
					System.out.print("Kontaktna stevilka: ");
					scan.nextLine();
					String kontaktnaStPotnik = scan.nextLine();
					
					System.out.print("Vnesi naslov: ");
					String naslovPotnika = scan.nextLine();
					
					System.out.print("Vnesi posto: ");
					String postaPotnika = scan.nextLine();
					
					System.out.print("Vnesi postno stevilko: ");
					String postnaStPotnika = scan.nextLine();
					Potnik potnik = new Potnik(imePotnika, priimekPotnika, epostaPotnika, rojDanP, kontaktnaStPotnik, naslovPotnika, postaPotnika, postnaStPotnika);
					
					System.out.println("Stanje placila: ");
					System.out.println("0: rezerviral");
					System.out.println("1: placal");
					
					int stanjePlacilaP = scan.nextInt();
					if (stanjePlacilaP == 0) { potnik.setStanjePlacila(Placilo.rezerviral); }
					else if(stanjePlacilaP == 1) { potnik.setStanjePlacila(Placilo.placal); } 
					
					seznamPotnikov.add(potnik);
					paket.setPrijavljeniPotniki(seznamPotnikov);
					
					try {
						paket.prijaviPotnika(potnik);
					} catch (PaketZasedenException e) {
						System.out.println("Ne morete dodati potnikov, zal so mesta ze zasedena.");
						e.printStackTrace();
					}
					
				}
				
				izlet.setPonudbaPaketov(seznamPaketov);
				izlet.setVodic(vodic);
				izlet.setDestinacija(cilj);
				oddihi.add(izlet);
				
				break;
				
			case 1:
				System.out.println("Izpis podatkov: ");
				for (int i = 0; i < oddihi.size(); i++) {					
					System.out.println(oddihi.get(i).toString());
				}
				
				break;
			case 2:
			}
		}
		while(y!=3);
	}

}
