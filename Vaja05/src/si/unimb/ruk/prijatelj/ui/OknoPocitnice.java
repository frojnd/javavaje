package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import si.unimb.ruk.prijatelj.logika.oddihi.Paket;
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice;
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice.Ponudba;
import si.unimb.ruk.prijatelj.logika.oddihi.Pocitnice.Prevoz;

public class OknoPocitnice extends JPanel{
		private JTabbedPane tabbed;
		
		// initVnesiPocitnice()
		private JLabel jLabelNaziv;
		private JLabel jLabelNazivHotela;
		private JLabel jLabelStZvezdic;
		private JLabel jLabelPrevoz;
		private JLabel jLabelPonudba;
		private JTextField jTextFieldNaziv;
		private JTextField jTextFieldNazivHotela;
		private JSpinner jSpinnerStZvezdic;
		private Choice choicePrevoz;
		private Choice choicePonudba;
		private JComboBox jComboBoxPrevoz;
		private JComboBox jComboBoxPonudba;
		private JButton jButtonVnesi;
		
		// initPreglejPocitnice()
		private JTextArea jTextAreaPreglej;
		private JButton jButtonPreglej;
		
		// initUrediPocitnice()
		private JLabel jLabelIzberiIndeks;
		private JTextField jTextFieldIzberIndeks;
		private JButton jButtonIzberiIndeks;
		
		List<Pocitnice> seznamPocitnic = new ArrayList<Pocitnice>(); 
		Paket paket = new Paket();
		
		public OknoPocitnice() {
			tabbed = new JTabbedPane();
			
			this.inicializiraj();
		}
		
		private void inicializiraj() {
			this.setLayout(new BorderLayout());
			
			initVnesiPocitnice();
			initPreglejPocitnice();
			initUrediPocitnice();
			
			this.add(tabbed);
			
			this.repaint();
		}
		
		private void initVnesiPocitnice() {
			JPanel panelVnesiPocitnice = new JPanel();
			panelVnesiPocitnice.setLayout(new BoxLayout(panelVnesiPocitnice, BoxLayout.X_AXIS));
			
			JPanel panelVnesi = new JPanel();
			panelVnesi.setLayout(new BoxLayout(panelVnesi, BoxLayout.Y_AXIS));
			
			jLabelNaziv = new JLabel("Vnesi naziv: ");
			panelVnesi.add(jLabelNaziv);
			
			jTextFieldNaziv = new JTextField("Naziv oddiha");
			panelVnesi.add(jTextFieldNaziv);
			
			jLabelNazivHotela = new JLabel("Vnesi naziv hotela: ");
			panelVnesi.add(jLabelNazivHotela);
			
			jTextFieldNazivHotela = new JTextField("Naziv hotela ");
			panelVnesi.add(jTextFieldNazivHotela);
			
			jLabelStZvezdic = new JLabel("Število zvezdic: ");
			panelVnesi.add(jLabelStZvezdic);
			
			jSpinnerStZvezdic = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
			panelVnesi.add(jSpinnerStZvezdic);
			
			jLabelPrevoz = new JLabel("Izberi prevoz: ");
			panelVnesi.add(jLabelPrevoz);
			
			String[] prevozi = { "letalski", "avtobusni", "vlak", "lastni" };
			jComboBoxPrevoz = new JComboBox(prevozi);
			panelVnesi.add(jComboBoxPrevoz);
			
			jLabelPonudba = new JLabel("Izberi ponudbo: ");
			panelVnesi.add(jLabelPonudba);
			
			
			String[] ponudba = { "nocitev", "pol_penzion", "polni_penzion" };
			jComboBoxPonudba = new JComboBox(ponudba);
			panelVnesi.add(jComboBoxPonudba);
			
			jButtonVnesi = new JButton("Vnesi");
			panelVnesi.add(jButtonVnesi);
			
			PoslusalecVnos poslusalecVnos = new PoslusalecVnos();
			jButtonVnesi.addActionListener(poslusalecVnos);
			
			panelVnesiPocitnice.add(panelVnesi);
			tabbed.add("Vnos", panelVnesiPocitnice);
		}
		
		private class PoslusalecVnos implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==jButtonVnesi) {
					System.out.println("V: PoslusalecVnos");
					
					Pocitnice pocitnice = new Pocitnice(jTextFieldNaziv.getText());
					pocitnice.setNaziv(jTextFieldNazivHotela.getText());
					pocitnice.setNazivHotela(jTextFieldNazivHotela.getText());
					
					
					// primerjam string z enum zato morm enum spmenit v string z ""
					if(jComboBoxPrevoz.getSelectedItem().equals("" + Prevoz.avtobusni)) {
						pocitnice.setPrevoz(Prevoz.avtobusni);
					}
					
					else if (jComboBoxPrevoz.getSelectedItem().equals("" + Prevoz.lastni)) {
						pocitnice.setPrevoz(Prevoz.lastni);
					}
					else if (jComboBoxPrevoz.getSelectedItem().equals("" + Prevoz.letalski)) {
						pocitnice.setPrevoz(Prevoz.letalski);
					}
					else if (jComboBoxPrevoz.getSelectedItem().equals("" + Prevoz.vlak)) {
						pocitnice.setPrevoz(Prevoz.vlak);
					}
					
					// primerjam string z enum zato morm enum spmenit v string z ""
					if(jComboBoxPonudba.getSelectedItem().equals("" + Ponudba.nocitev)) {
						pocitnice.setPonudba(Ponudba.nocitev);
					}
					else if(jComboBoxPonudba.getSelectedItem().equals("" + Ponudba.pol_penzion)) {
						pocitnice.setPonudba(Ponudba.pol_penzion);
					}
					else if(jComboBoxPonudba.getSelectedItem().equals("" + Ponudba.polni_penzion)) {
						pocitnice.setPonudba(Ponudba.polni_penzion);
					}
					
					Integer stZvezdic = (Integer)jSpinnerStZvezdic.getValue();
					if(stZvezdic==1) {
						pocitnice.setStZvezdic(stZvezdic);
					}
					else if(stZvezdic==2) {
						pocitnice.setStZvezdic(stZvezdic);
					}
					else if(stZvezdic==3) {
						pocitnice.setStZvezdic(stZvezdic);
					}
					else if(stZvezdic==4) {
						pocitnice.setStZvezdic(stZvezdic);
					}
					else if(stZvezdic==5) {
						pocitnice.setStZvezdic(stZvezdic);
					}
										
					seznamPocitnic.add(pocitnice);
					paket.setSeznamPocitnic(seznamPocitnic);				
				}
			}
		}
		
		private void initPreglejPocitnice() {
			JPanel panelPreglejPocitnice = new JPanel();
			panelPreglejPocitnice.setLayout(new BoxLayout(panelPreglejPocitnice, BoxLayout.X_AXIS));
			
			JPanel panelPreglej = new JPanel();
			panelPreglej.setLayout(new BoxLayout(panelPreglej, BoxLayout.Y_AXIS));
			
			jTextAreaPreglej = new JTextArea();
			panelPreglej.add(jTextAreaPreglej);
			
			jButtonPreglej = new JButton("Prikaži");
			panelPreglej.add(jButtonPreglej);
			
			PoslusalecPreglej poslusalecPreglej = new PoslusalecPreglej();
			jButtonPreglej.addActionListener(poslusalecPreglej);
			
			panelPreglejPocitnice.add(panelPreglej);
			tabbed.add("Pregled", panelPreglejPocitnice);
			
		}
		
		private class PoslusalecPreglej implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==jButtonPreglej) {
					System.out.println("v pregledu");
					jTextAreaPreglej.setText(paket.toStringPocitnice());
				}
			}
		}
		
		private void initUrediPocitnice() {
			JPanel panelUrediPocitnice = new JPanel();
			
			JPanel panelUredi = new JPanel();
			panelUredi.setLayout(new BoxLayout(panelUredi, BoxLayout.Y_AXIS));
			
			jLabelIzberiIndeks = new JLabel("Izberi počitnice za brisanje");
			panelUredi.add(jLabelIzberiIndeks);
			
			jTextFieldIzberIndeks = new JTextField("1");
			panelUredi.add(jTextFieldIzberIndeks);
			
			jButtonIzberiIndeks = new JButton("Izbriši");
			panelUredi.add(jButtonIzberiIndeks);
			
			PoslusalecUredi poslusalecUredi = new PoslusalecUredi();
			jButtonIzberiIndeks.addActionListener(poslusalecUredi);
			
			panelUrediPocitnice.add(panelUredi);
			tabbed.add("Uredi", panelUrediPocitnice);
		}
		
		private class PoslusalecUredi implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==jButtonIzberiIndeks) {
					System.out.println("V uredi");
					int indeksPocitnic = Integer.parseInt(jTextFieldIzberIndeks.getText());
					seznamPocitnic.remove((indeksPocitnic-1));
				}
			}
		}
}
