package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

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
		private JLabel jLabelStream;
		private JTextArea jTextAreaStream;
		private JButton jButtonShrani;
		private JButton jButtonNalozi;
		
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
			
			jLabelStream = new JLabel("\n");
			panelPreglej.add(jLabelStream);
			
			jButtonShrani = new JButton("Serializiraj");
			panelPreglej.add(jButtonShrani);
			
			jButtonShrani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("VVVVV jButtonShrani.addActionListener");
					/*
					Krizarjenje krizarjenje = new Krizarjenje("Naziv");
					krizarjenje.setNazivLadjarja("naziv ladjarja");
					krizarjenje.setMestoOdhoda("mesto oddiha");
					*/
					
					
					try {
						/*
						FileOutputStream fileOut = new FileOutputStream("Krizarjenje.ser");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						*/
						FileOutputStream fileOut = new FileOutputStream("Krizarjenje.zip");
						ObjectOutputStream out = new ObjectOutputStream(new GZIPOutputStream(fileOut));
						
						out.writeObject(seznamKrizarjenj);
						out.close();
						fileOut.close();
					}
					catch(IOException i) {
						i.printStackTrace();
					}
				}
			});
			
			jButtonNalozi = new JButton("Deserializiraj");
			panelPreglej.add(jButtonNalozi);
			
			jButtonNalozi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//List<Krizarjenje> seznamKrizarjenj = null;
					seznamKrizarjenj = null;
					try {
						FileInputStream fileIn = new FileInputStream("Krizarjenje.ser");
						ObjectInputStream in = new  ObjectInputStream(fileIn);
						seznamKrizarjenj = (List<Krizarjenje>) in.readObject();
						in.close();
						fileIn.close();
					}
					catch(IOException i) {
						i.printStackTrace();
						return;
					}
					catch(ClassNotFoundException c) {
						System.out.println("class not found");
						c.printStackTrace();
						return;
					}
					for(int i=0; i<seznamKrizarjenj.size(); i++) {
						System.out.println(seznamKrizarjenj.get(i).toString());
					}
				}
			});
			
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
