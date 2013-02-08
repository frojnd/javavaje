package si.unimb.ruk.prijatelj.ui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class OsnovnoOkno extends JFrame {
	
	
	public OsnovnoOkno() {
		
	}
	
	public void prikazi() {
		JTabbedPane cards = new JTabbedPane();
		
		JPanel zavihekVodici = new OknoVodici();
		cards.add("Vodiči", zavihekVodici);
		
		JPanel zavihekIzleti = new OknoIzleti();
		cards.add("Izleti", zavihekIzleti);
		
		JPanel zavihekKrizarjenja = new OknoKrizarjenja();
		cards.add("Križarjenja", zavihekKrizarjenja);
		
		JPanel zavihekPocitnice = new OknoPocitnice();
		cards.add("Počitnice", zavihekPocitnice);
		
		JPanel zavihekAranzmaji = new OknoAranzmaji();		
		cards.add("Aranžmaji",zavihekAranzmaji);
		
		//JPanel zavihekStatistika = new JPanel();		
		JPanel zavihekStatistika = new OknoStatistika();
		cards.add("Statistika",zavihekStatistika);
		
		this.add(cards);
		
		this.setPreferredSize(new Dimension(640, 480));
		this.setTitle("Agencija");
		this.pack();
		this.setVisible(true);
	}

}
