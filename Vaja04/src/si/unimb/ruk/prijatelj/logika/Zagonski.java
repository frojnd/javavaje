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
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice;
import si.unimb.ruk.prijatelj.logika.osebe.Vodic;
import si.unimb.ruk.prijatelj.logika.osebe.Vodic.Jezik;

/**
 * @author Joze
 *
 */
public class Zagonski {
	public static void main(String args[]) {
		
		List<Oddih> oddihi = new ArrayList<Oddih>();

		Scanner in = new Scanner(System.in);
		int x=0;
		do {
			System.out.println("Menu");
			System.out.println("--------------------------");
			System.out.println("0: vnos podatkov o oddihih");
			System.out.println("1: izpis podatkov o oddihih");
			System.out.println("2: Izhod");
			System.out.println("--------------------------");
			
			x=in.nextInt();
			switch(x) {
			case 0:
				Scanner sc = new Scanner(System.in);
				int y=0;
				do {
					System.out.println("-------------------------------");
					System.out.println("0: vnos podatkov o izletih");
					System.out.println("1: vnos podatkov o krizarjenjih");
					System.out.println("2: vnos podatkov o pocitnicah");
					System.out.println("3: izpis podatkov");
					System.out.println("4: prejsni menu");
					System.out.println("-------------------------------");
					
					y=sc.nextInt();
					switch(y) {
					case 0:
						// napolnemo podatke o izletih
						Scanner scan = new Scanner(System.in);
						System.out.println("-----Podatki o izletih-----");
						
						System.out.println("Vnesi naziv oddiha: ");
						String tmp = scan.nextLine();
						Izlet izlet = new Izlet(tmp);
						
						System.out.println("Vnesi uro odhoda: ");
						String uraOdhoda = scan.nextLine();
						izlet.setUraOdhoda(uraOdhoda);
						
						System.out.println("Vnesi zbirno mesto: ");
						String zbirnoMesto = scan.nextLine();
						izlet.setZbirnoMesto(zbirnoMesto);
						
						// napolnemo podatke o vodicih
						// najprej napolnimo preko razreda Oseba
						System.out.println("-----Podati o vodicu-----");
						
						System.out.println("Vnesi ime: ");
						String imeV = scan.nextLine();
						
						System.out.println("Vnesi priimek: ");
						String priimekV = scan.nextLine();
						
						Vodic vodic = new Vodic(imeV, priimekV);
						
						System.out.println("Vnesi e-posto: ");
						String ePostaV = scan.nextLine();
						vodic.setEposta(ePostaV);
						
						System.out.println("Vnesi rojdni datum (Leto, Mesec, Dan)");
						int rojDanLV = scan.nextInt();
						int rojDanMV = scan.nextInt();
						int rojDanDV = scan.nextInt();
						GregorianCalendar rojDanV = new GregorianCalendar(rojDanLV, rojDanMV, rojDanDV);
						vodic.setRojstniDatum(rojDanV);
						
						// nato napolnemo direktno iz razreda Vodic
						Boolean imaNimaLicenco;
						
						scan.nextLine(); // eat away :P
						System.out.println("Ali ima licenco gorskega vodnika (da / ne)");
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
						System.out.println("Oddih (" + tmp + ")\n Vnesi st prostih mest: ");
						int prostaMesta = scan.nextInt();
						
						System.out.println("Vnesi ceno: ");
						double cena = scan.nextInt();
						
						System.out.println("Vnesi datum zacetka oddiha - leto, mesec, dan");
						int letoZ = scan.nextInt();
						int mesecZ = scan.nextInt()-1;
						int danZ = scan.nextInt();
						GregorianCalendar datumZacetka = new GregorianCalendar(letoZ,mesecZ, danZ);
					
						System.out.println("Vnesi koncni datum oddiha - leto, mesec, dan");
						int letoK = scan.nextInt();
						int mesecK = scan.nextInt()-1;
						int danK = scan.nextInt();
						GregorianCalendar datumKonca = new GregorianCalendar(letoK,mesecK, danK);
						
						scan.nextLine(); // eat away :P
						System.out.println("Vnesi naziv destinacije: ");
						String nazivD = scan.nextLine();
						
						Destinacija cilj = new Destinacija(nazivD);
						
						List<Paket> seznamPaketov = new ArrayList<Paket>();
						Paket paket = new Paket(cena, datumZacetka, datumKonca, prostaMesta);
						seznamPaketov.add(paket);
						
						System.out.println("Izracunaj ceno za X potnikov: ");
						int stPotnikov = scan.nextInt();
						System.out.println("Cena za "+stPotnikov+" potnikov = "+paket.izracunajCeno(stPotnikov));
						
						System.out.println("Izracunaj ceno za X odraslih in Y otrok: ");
						int stOtrok = scan.nextInt();
						int stOdraslih = scan.nextInt();
						System.out.println("Cena za "+stOtrok+" otrok in "+stOdraslih+" odraslih = "+paket.izracunajCeno(stOdraslih, stOtrok));
						
						izlet.setPonudbaPaketov(seznamPaketov);
						izlet.setVodic(vodic);
						izlet.setDestinacija(cilj);
						oddihi.add(izlet);
						
						break;
						
					case 1:
						// napolnemo podatke o krizarjenjih
						Scanner scan1 = new Scanner(System.in);
						System.out.println("-----Podatki o krizarjenjih-----");
						System.out.println("Vnesi naziv oddiha: ");
						String tmpK = scan1.nextLine();
						Krizarjenje krizarjenje = new Krizarjenje(tmpK);
						
						
						System.out.println("Naziv ladjarja: ");
						String nazivLadjarja = scan1.nextLine();
						krizarjenje.setNazivLadjarja(nazivLadjarja);
						
						System.out.println("Mesto odhoda: ");
						String mestoOdhoda = scan1.nextLine();
						krizarjenje.setMestoOdhoda(mestoOdhoda);
						
						// napolnimo podatke o vodicih
						// najprej napolnimo preko razreda Oseba
						System.out.println("-----Podati o vodicKu-----");
						
						System.out.println("Vnesi ime: ");
						String imeVodica = scan1.nextLine();
						
						System.out.println("Vnesi priimek: ");
						String priimekVodica = scan1.nextLine();
						
						Vodic vodicK = new Vodic(imeVodica, priimekVodica);
						
						System.out.println("Vnesi e-posto: ");
						String ePostaVodica = scan1.nextLine();
						vodicK.setEposta(ePostaVodica);
						
						System.out.println("Vnesi rojdni datum (Leto, Mesec, Dan)");
						int rojDanLVodica = scan1.nextInt();
						int rojDanMVodica= scan1.nextInt();
						int rojDanDVodica= scan1.nextInt();
						GregorianCalendar rojDanVodica = new GregorianCalendar(rojDanLVodica, rojDanMVodica, rojDanDVodica);
						vodicK.setRojstniDatum(rojDanVodica);
						
						// nato napolnemo direktno iz razreda Vodic
						Boolean imaNimaLicencoK;
						
						scan1.nextLine(); // eat away :P
						System.out.println("Ali ima licenco gorskega vodnika (da / ne)");
						String licencaK = scan1.nextLine();
						
						if (licencaK.equals("da")) {
							imaNimaLicencoK = true;
						}
						else {
							imaNimaLicencoK = false;
						}
						vodicK.setLicencaGorskegaVodnika(imaNimaLicencoK);
						
						System.out.println("Katere jezike govori vodicK: ");
						System.out.println("1 Anglesko");
						System.out.println("2 Nemsko");
						System.out.println("3 Spansko");
						System.out.println("4 Italijansko");
						System.out.println("5 Slovensko");
						System.out.println("Za vnos pritisnite stevilko jezika, za nadaljevanje pa 0");
						int stJezikaK = -1;
						List<Jezik> seznamJezikovK = new ArrayList<Jezik>();
						while (stJezikaK != 0)
						{
							stJezikaK = scan1.nextInt();
							
							switch (stJezikaK) {
							case 1:
								seznamJezikovK.add(Jezik.Anglesko);
								break;
							case 2:
								seznamJezikovK.add(Jezik.Nemsko);
								break;
							case 3:
								seznamJezikovK.add(Jezik.Italijansko);
								break;
							case 4:
								seznamJezikovK.add(Jezik.Spansko);
								break;
							case 5:
								seznamJezikovK.add(Jezik.Slovensko);
								break;
							default:
								break;
							}					
						}
						vodicK.setGovori(seznamJezikovK);
						
						// napolnemo podatke o paketKih
						System.out.println("-----Podati o paketKu-----");
						System.out.println("Oddih (" + tmpK + ")\n Vnesi st prostih mest: ");
						int prostaMestaK = scan1.nextInt();
						
						System.out.println("Vnesi ceno: ");
						double cenaK = scan1.nextInt();
						
						System.out.println("Vnesi datum zacetka oddiha - leto, mesec, dan");
						int letoZK = scan1.nextInt();
						int mesecZK = scan1.nextInt()-1;
						int danZK = scan1.nextInt();
						GregorianCalendar datumZacetkaK = new GregorianCalendar(letoZK,mesecZK, danZK);
					
						System.out.println("Vnesi koncni datum oddiha - leto, mesec, dan");
						int letoKK = scan1.nextInt();
						int mesecKK = scan1.nextInt()-1;
						int danKK = scan1.nextInt();
						GregorianCalendar datumKoncaK = new GregorianCalendar(letoKK,mesecKK, danKK);
						
						scan1.nextLine(); // eat away :P
						System.out.println("Vnesi naziv destinacije: ");
						String nazivDK = scan1.nextLine();
						
						Destinacija ciljK = new Destinacija(nazivDK);
						
						List<Paket> seznamPaketovK = new ArrayList<Paket>();
						Paket paketK = new Paket(cenaK, datumZacetkaK, datumKoncaK, prostaMestaK);
						seznamPaketovK.add(paketK);
						
						System.out.println("Izracunaj ceno za X potnikov: ");
						int stPotnikovK = scan1.nextInt();
						System.out.println("Cena za "+stPotnikovK+" potnikov = "+paketK.izracunajCeno(stPotnikovK));
						
						System.out.println("Izracunaj ceno za X odraslih in Y otrok: ");
						int stOtrokK = scan1.nextInt();
						int stOdraslihK = scan1.nextInt();
						System.out.println("Cena za "+stOtrokK+" otrok in "+stOdraslihK+" odraslih = "+paketK.izracunajCeno(stOdraslihK, stOtrokK));
						
						krizarjenje.setPonudbaPaketov(seznamPaketovK);
						krizarjenje.setVodic(vodicK);
						krizarjenje.setDestinacija(ciljK);
						oddihi.add(krizarjenje);
						
						break;
						
					case 2:
						// napolnimo podatke o pocitnicah
						Scanner scanP = new Scanner(System.in);
						System.out.println("-----Podatki o pocitnicah-----");
						System.out.println("Vnesite naziv oddiha");
						String tmpP = scanP.nextLine();
						Pocitnice pocitnice = new Pocitnice(tmpP);
						
						System.out.println("Naziv hotela: ");
						String nazivHotela = scanP.nextLine();
						pocitnice.setNazivHotela(nazivHotela);
						
						System.out.println("Stevilo zvezdic: ");
						int stZvezdic = scanP.nextInt();
						pocitnice.setStZvezdic(stZvezdic);
						
						// eat away
						scanP.nextLine();
						
						// napolnemo podatke o vodicih
						// najprej napolnemo preko razreda Oseba
System.out.println("-----Podati o vodicPu-----");
						
						System.out.println("Vnesi ime: ");
						String imeVodicaPocitnice = scanP.nextLine();
						
						System.out.println("Vnesi priimek: ");
						String priimekVodicaPocitnice = scanP.nextLine();
						
						Vodic vodicP = new Vodic(imeVodicaPocitnice, priimekVodicaPocitnice);
						
						System.out.println("Vnesi e-posto: ");
						String ePostaVodicaPocitnice = scanP.nextLine();
						vodicP.setEposta(ePostaVodicaPocitnice);
						
						System.out.println("Vnesi rojdni datum (Leto, Mesec, Dan)");
						int rojDanLVodicaPocitnice = scanP.nextInt();
						int rojDanMVodicaPocitnice= scanP.nextInt();
						int rojDanDVodicaPocitnice= scanP.nextInt();
						GregorianCalendar rojDanVodicaPocitnice = new GregorianCalendar(rojDanLVodicaPocitnice, rojDanMVodicaPocitnice, rojDanDVodicaPocitnice);
						vodicP.setRojstniDatum(rojDanVodicaPocitnice);
						
						// nato napolnemo direktno iz razreda Vodic
						Boolean imaNimaLicencoP;
						
						scanP.nextLine(); // eat away :P
						System.out.println("Ali ima licenco gorskega vodnika (da / ne)");
						String licencaP = scanP.nextLine();
						
						if (licencaP.equals("da")) {
							imaNimaLicencoP = true;
						}
						else {
							imaNimaLicencoP = false;
						}
						vodicP.setLicencaGorskegaVodnika(imaNimaLicencoP);
						
						System.out.println("Katere jezike govori vodicP: ");
						System.out.println("1 Anglesko");
						System.out.println("2 Nemsko");
						System.out.println("3 Spansko");
						System.out.println("4 Italijansko");
						System.out.println("5 Slovensko");
						System.out.println("Za vnos pritisnite stevilko jezika, za nadaljevanje pa 0");
						int stJezikaP = -1;
						List<Jezik> seznamJezikovP = new ArrayList<Jezik>();
						while (stJezikaP != 0)
						{
							stJezikaP = scanP.nextInt();
							
							switch (stJezikaP) {
							case 1:
								seznamJezikovP.add(Jezik.Anglesko);
								break;
							case 2:
								seznamJezikovP.add(Jezik.Nemsko);
								break;
							case 3:
								seznamJezikovP.add(Jezik.Italijansko);
								break;
							case 4:
								seznamJezikovP.add(Jezik.Spansko);
								break;
							case 5:
								seznamJezikovP.add(Jezik.Slovensko);
								break;
							default:
								break;
							}					
						}
						vodicP.setGovori(seznamJezikovP);
						
						// napolnemo podatke o paketPih
						System.out.println("-----Podati o paketPu-----");
						System.out.println("Oddih (" + tmpP + ")\n Vnesi st prostih mest: ");
						int prostaMestaP = scanP.nextInt();
						
						System.out.println("Vnesi ceno: ");
						double cenaP = scanP.nextInt();
						
						System.out.println("Vnesi datum zacetka oddiha - leto, mesec, dan");
						int letoZP = scanP.nextInt();
						int mesecZP = scanP.nextInt()-1;
						int danZP = scanP.nextInt();
						GregorianCalendar datumZacetkaP = new GregorianCalendar(letoZP,mesecZP, danZP);
					
						System.out.println("Vnesi koncni datum oddiha - leto, mesec, dan");
						int letoKP = scanP.nextInt();
						int mesecKP = scanP.nextInt()-1;
						int danKP = scanP.nextInt();
						GregorianCalendar datumKoncaP = new GregorianCalendar(letoKP,mesecKP, danKP);
						
						scanP.nextLine(); // eat away :P
						System.out.println("Vnesi naziv destinacije: ");
						String nazivDP = scanP.nextLine();
						
						Destinacija ciljP = new Destinacija(nazivDP);
						
						List<Paket> seznamPaketovP = new ArrayList<Paket>();
						Paket paketP = new Paket(cenaP, datumZacetkaP, datumKoncaP, prostaMestaP);
						seznamPaketovP.add(paketP);
						
						System.out.println("Izracunaj ceno za X potnikov: ");
						int stPotnikovP = scanP.nextInt();
						System.out.println("Cena za "+stPotnikovP+" potnikov = "+paketP.izracunajCeno(stPotnikovP));
						
						System.out.println("Izracunaj ceno za X odraslih in Y otrok: ");
						int stOtrokP = scanP.nextInt();
						int stOdraslihP = scanP.nextInt();
						System.out.println("Cena za "+stOtrokP+" otrok in "+stOdraslihP+" odraslih = "+paketP.izracunajCeno(stOdraslihP, stOtrokP));
						
						pocitnice.setPonudbaPaketov(seznamPaketovP);
						pocitnice.setVodic(vodicP);
						pocitnice.setDestinacija(ciljP);
						oddihi.add(pocitnice);
						
						break;
						
					case 3:
						System.out.println("Izpis podatkov: ");
						for (int i = 0; i < oddihi.size(); i++) {					
							System.out.println(oddihi.get(i).toString());
						}
						break;
					}
				}
				while(y!=4);
				
				break;
			case 1:
				System.out.println("Izpis podatkov: ");
				for (int i = 0; i < oddihi.size(); i++) {					
					System.out.println(oddihi.get(i).toString());
				}
				break;
			}
		}
		while(x!=2);
	}

}
