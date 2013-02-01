/*
 * Za zaključek implementirajte še testni razred Zagonski. V zagonski metodi omenjenega 
razreda omogočite, da bo uporabnik lahko vnesel podatke o oddihih ter vnesene oddihe 
izpisal na zaslon.
 */

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

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
				System.out.print("Vnesi naziv oddiha: ");
				String nazivO = sc.nextLine();
				Oddih oddih = new Oddih(nazivO);
				
				// vnos podatkov za vodic
				System.out.println("----Podatki o vodicu----");
				System.out.print("Vnesi ime: ");
				String ime = sc.nextLine();
				
				System.out.print("Vnesi priimek: ");
				String priimek = sc.nextLine();
				Oseba vodicOddiha = new Oseba(ime,priimek);
				
				System.out.print("Vnesi eposto: ");
				String eposta = sc.nextLine();
				vodicOddiha.setEposta(eposta);
				
				System.out.println("Vnesi datum rojstva: (Leto, mesec, dan)");
				int letoRojstniV = sc.nextInt();
				int mesecRojstniV = sc.nextInt();
				int danRojstniV = sc.nextInt();
				GregorianCalendar rojstniDanV = new GregorianCalendar(letoRojstniV, mesecRojstniV-1, danRojstniV);
				vodicOddiha.setRojstniDatum(rojstniDanV);
				oddih.setVodic(vodicOddiha);
				
				// napolnemo podatke o destinacijah	
				System.out.println("----Podatki o destinacijah----");
				sc.nextLine();
				System.out.print("Vnesi naziv destinacije ");
				String nazivD = sc.nextLine();
				Destinacija destinacija = new Destinacija(nazivD);
				oddih.setDestinacija(destinacija);
				
				System.out.print("Vnesi lokacija destinacije: ");
				String lokacijaD = sc.nextLine();
				destinacija.setLokacija(lokacijaD);
				
				System.out.print("Vnesi drzavo destinacije: ");
				String drzavaD = sc.nextLine();
				destinacija.setDrzava(drzavaD);
				
				// napolnemo preostale podatke o oddihih
				System.out.println ("Vnesi zacetek oddiha: (Leto, mesec, dan)");
				int letoZoddiha = sc.nextInt();
				int mesecZoddiha = sc.nextInt();
				int danZoddiha = sc.nextInt();
				GregorianCalendar zacetekOddiha = new GregorianCalendar(letoZoddiha, mesecZoddiha-1, danZoddiha);
				oddih.setZacetekOddiha(zacetekOddiha);
				
				System.out.println ("Vnesi konec oddiha: (Leto, mesec, dan)");
				int letoKoddiha = sc.nextInt();
				int mesecKoddiha = sc.nextInt();
				int danKoddiha = sc.nextInt();
				GregorianCalendar konecOddiha = new GregorianCalendar(letoKoddiha, mesecKoddiha-1, danKoddiha);
				oddih.setKonecOddiha(konecOddiha);
				
				System.out.print("Vnesi ceno oddiha: ");
				int cenaOddiha = sc.nextInt();
				oddih.setCena(cenaOddiha);
				
				System.out.print("Vnesi stevilo prostih mest: ");
				int stProstihMestO = sc.nextInt();
				oddih.setStMest(stProstihMestO);
				
				oddihi.add(oddih);
				
				break;
			case 1:
				System.out.println("Izpis podatkov: ");
				for (int i = 0; i < oddihi.size(); i++) {
					oddihi.get(i).izpisi();					
				}
				break;
			}
		}
		while(x!=2);
	}

}
