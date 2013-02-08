package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import si.unimb.ruk.prijatelj.logika.oddihi.Izlet;
import si.unimb.ruk.prijatelj.logika.oddihi.Krizarjenje;
import si.unimb.ruk.prijatelj.logika.oddihi.Paket;

public class OknoKrizarjenja extends JPanel{
		private JTabbedPane tabbed;
		
		// initVnesiKrizarjenje()
		private JLabel jLabelNaziv;
		private JLabel jLabelNazivLadjarja;
		private JLabel jLabelMestoOdhoda;
		private JTextField jTextFieldNaziv;
		private JTextField jTextFieldNazivLadjarja;
		private JTextField jTextFieldMestoOdhoda;
		private JButton jButtonVnesiKrizarjenje;
		
		// initPreglejKrizarjenje()
		private JTextArea jTextAreaPreglej;
		private JButton jButtonPreglej;
		
		// initUrediKrizarjenje()
		private JLabel jLabelIzberiIndeks;
		private JTextField jTextFieldIzberIndeks;
		private JButton jButtonIzberiIndeks;
		
		List<Krizarjenje> seznamKrizarjenj = new ArrayList<Krizarjenje>(); 
		Paket paket = new Paket();
		
		public OknoKrizarjenja() {
			tabbed = new JTabbedPane();
			
			this.inicializiraj();
		}
		
		private void inicializiraj() {
			this.setLayout(new BorderLayout());
			
			initVnesiKrizarjenje();
			initPreglejKrizarjenje();
			initUrediKrizarjenje();
			
			this.add(tabbed);
			
			this.repaint();
		}
		
		private void initVnesiKrizarjenje() {
			JPanel panelVnesiKrizarjenje = new JPanel();
			panelVnesiKrizarjenje.setLayout(new BoxLayout(panelVnesiKrizarjenje, BoxLayout.X_AXIS));
			
			JPanel panelVnesi = new JPanel();
			panelVnesi.setLayout(new BoxLayout(panelVnesi, BoxLayout.Y_AXIS));
			
			jLabelNaziv = new JLabel("Vnesi naziv: ");
			panelVnesi.add(jLabelNaziv);
			
			jTextFieldNaziv = new JTextField("Naziv oddiha");
			panelVnesi.add(jTextFieldNaziv);
			
			jLabelNazivLadjarja = new JLabel("Vnesi naziv ladjarja: ");
			panelVnesi.add(jLabelNazivLadjarja);
			
			jTextFieldNazivLadjarja = new JTextField("Naziv ladjarja ");
			panelVnesi.add(jTextFieldNazivLadjarja);
			
			jLabelMestoOdhoda = new JLabel("Vnesi mesto odhoda: ");
			panelVnesi.add(jLabelMestoOdhoda);
			
			jTextFieldMestoOdhoda = new JTextField("mesto odhoda ");
			panelVnesi.add(jTextFieldMestoOdhoda);
			
			jButtonVnesiKrizarjenje = new JButton("Vnesi");
			panelVnesi.add(jButtonVnesiKrizarjenje);
			
			PoslusalecKrizarjenjeVnos poslusalecIzletVnos = new PoslusalecKrizarjenjeVnos();
			jButtonVnesiKrizarjenje.addActionListener(poslusalecIzletVnos);
			
			panelVnesiKrizarjenje.add(panelVnesi);
			tabbed.add("Vnos", panelVnesiKrizarjenje);
		}
		
		private class PoslusalecKrizarjenjeVnos implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==jButtonVnesiKrizarjenje) {
					System.out.println("isdsfads");
					Krizarjenje krizarjenje = new Krizarjenje(jTextFieldNaziv.getText());
					
					krizarjenje.setNazivLadjarja(jTextFieldNazivLadjarja.getText());
					krizarjenje.setMestoOdhoda(jTextFieldMestoOdhoda.getText());
					
					seznamKrizarjenj.add(krizarjenje);
					paket.setSeznamKrizarjenj(seznamKrizarjenj);
				}
			}
		}
		
		private void initPreglejKrizarjenje() {
			JPanel panelPreglejKrizarjenje = new JPanel();
			panelPreglejKrizarjenje.setLayout(new BoxLayout(panelPreglejKrizarjenje, BoxLayout.X_AXIS));
			
			JPanel panelPreglej = new JPanel();
			panelPreglej.setLayout(new BoxLayout(panelPreglej, BoxLayout.Y_AXIS));
			
			jTextAreaPreglej = new JTextArea();
			panelPreglej.add(jTextAreaPreglej);
			
			jButtonPreglej = new JButton("Prikaži");
			panelPreglej.add(jButtonPreglej);
			
			PoslusalecPreglej poslusalecPreglej = new PoslusalecPreglej();
			jButtonPreglej.addActionListener(poslusalecPreglej);
			
			panelPreglejKrizarjenje.add(panelPreglej);
			tabbed.add("Pregled", panelPreglejKrizarjenje);
			
		}
		
		private class PoslusalecPreglej implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==jButtonPreglej) {
					System.out.println("v pregledu");
					jTextAreaPreglej.setText(paket.toStringKrizarjenja());
				}
			}
		}
		
		private void initUrediKrizarjenje() {
			JPanel panelUrediKrizarjenje = new JPanel();
			
			JPanel panelUredi = new JPanel();
			panelUredi.setLayout(new BoxLayout(panelUredi, BoxLayout.Y_AXIS));
			
			jLabelIzberiIndeks = new JLabel("Izberi Križarjenje za brisanje");
			panelUredi.add(jLabelIzberiIndeks);
			
			jTextFieldIzberIndeks = new JTextField("1");
			panelUredi.add(jTextFieldIzberIndeks);
			
			jButtonIzberiIndeks = new JButton("Izbriši");
			panelUredi.add(jButtonIzberiIndeks);
			
			PoslusalecUredi poslusalecUredi = new PoslusalecUredi();
			jButtonIzberiIndeks.addActionListener(poslusalecUredi);
			
			panelUrediKrizarjenje.add(panelUredi);
			tabbed.add("Uredi", panelUrediKrizarjenje);
		}
		
		private class PoslusalecUredi implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==jButtonIzberiIndeks) {
					System.out.println("V uredi");
					int indeksKrizarjenja = Integer.parseInt(jTextFieldIzberIndeks.getText());
					seznamKrizarjenj.remove((indeksKrizarjenja-1));
				}
			}
		}

}
