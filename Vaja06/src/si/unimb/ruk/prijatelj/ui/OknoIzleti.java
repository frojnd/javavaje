package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import si.unimb.ruk.prijatelj.logika.oddihi.Izlet;
import si.unimb.ruk.prijatelj.logika.oddihi.Paket;

public class OknoIzleti extends JPanel{
	private JTabbedPane tabbed;
	
	// spremenljivke za initVnesiIzlet() 
	private JLabel jLabelNaziv;
	private JLabel jLabelZbirnoMesto;
	private JLabel jLabelUraOdhoda;
	private JTextField jTextFieldNaziv;
	private JTextField jTextFieldZbirnoMesto;
	private JTextField jTextFieldUraOdhoda;
	private JButton jButtonVnesiIzlet;
	
	// spremenljivke za initPreglejIzlet();
	private JTextArea jTextAreaPregledIzleti;
	private JButton jButtonPregledIzet;
	private JTextArea jTextAreaStream;
	private JButton jButtonShrani;
	private JButton jButtonNalozi;
	private JFileChooser jFileChooserNalozi;
	private JFileChooser jFileChooserShrani;
	
	// spremenljivke za initUrediIzlet()
	private JLabel jLabelIzberiIndeks;
	private JTextField jTextFieldIzberIndeks;
	private JButton jButtonIzberiIndeks;
	
	List<Izlet> seznamIzletov = new ArrayList<Izlet>(); 
	Paket paket = new Paket();
	
	public OknoIzleti() {
		tabbed = new JTabbedPane();
		
		this.inicializiraj();
	}
	
	private void inicializiraj() {
		this.setLayout(new BorderLayout());
		
		initVnesiIzlet();
		initPreglejIzlet();
		initUrediIzlet();
		
		this.add(tabbed);
		
		this.repaint();
	}
	
	private void initVnesiIzlet() {
		JPanel panelVnesiIzlet = new JPanel();
		panelVnesiIzlet.setLayout(new BoxLayout(panelVnesiIzlet, BoxLayout.LINE_AXIS));
		
		JPanel panelVnesi = new JPanel();
		panelVnesi.setLayout(new BoxLayout(panelVnesi, BoxLayout.Y_AXIS));
		
		jLabelNaziv = new JLabel("Vnesi naziv: ");
		panelVnesi.add(jLabelNaziv);
		
		jTextFieldNaziv = new JTextField("Naziv oddiha");
		panelVnesi.add(jTextFieldNaziv);
		
		
		jLabelZbirnoMesto = new JLabel("Vnesi Zbirno mesto : ");
		panelVnesi.add(jLabelZbirnoMesto);
		
		jTextFieldZbirnoMesto = new JTextField("Zbirno mesto");
		panelVnesi.add(jTextFieldZbirnoMesto);
		
		
		jLabelUraOdhoda = new JLabel("Vnesi uro odhoda : ");
		panelVnesi.add(jLabelUraOdhoda);
		
		jTextFieldUraOdhoda = new JTextField("20:00");
		panelVnesi.add(jTextFieldUraOdhoda);
		
		
		jButtonVnesiIzlet = new JButton("Vnesi");
		panelVnesi.add(jButtonVnesiIzlet);
		
		PoslusalecIzletVnos poslusalecIzletVnos = new PoslusalecIzletVnos();
		jButtonVnesiIzlet.addActionListener(poslusalecIzletVnos);
		
		panelVnesiIzlet.add(panelVnesi);
		tabbed.add("Vnos", panelVnesiIzlet);
	}
	
	private class PoslusalecIzletVnos implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==jButtonVnesiIzlet) {
				System.out.println("isdsfads");
				Izlet izlet = new Izlet(jTextFieldNaziv.getText());
				
				izlet.setZbirnoMesto(jTextFieldZbirnoMesto.getText());
				izlet.setUraOdhoda(jTextFieldUraOdhoda.getText());
				
				seznamIzletov.add(izlet);
				paket.setSeznamIzletov(seznamIzletov);
			}
		}
	}
	
	private void initPreglejIzlet() {
		JPanel panelPreglejIzlet = new JPanel();
		panelPreglejIzlet.setLayout(new BoxLayout(panelPreglejIzlet, BoxLayout.X_AXIS));
		
		JPanel panelPregledIzlet = new JPanel();
		panelPregledIzlet.setLayout(new BoxLayout(panelPregledIzlet, BoxLayout.Y_AXIS));
		
		jTextAreaPregledIzleti = new JTextArea();
		panelPregledIzlet.add(jTextAreaPregledIzleti);
		
		jButtonPregledIzet = new JButton("Prikaži");
		panelPregledIzlet.add(jButtonPregledIzet);
		
		PoslusalecIzletPregled poslusalecIzletPregled = new PoslusalecIzletPregled();
		jButtonPregledIzet.addActionListener(poslusalecIzletPregled);
		
		JLabel jLabelStream = new JLabel("Izpis podatkov:");
		panelPregledIzlet.add(jLabelStream);
		
		jTextAreaStream = new JTextArea();
		panelPregledIzlet.add(jTextAreaStream);
		
		jButtonShrani = new JButton("Shrani v datoteko");
		panelPregledIzlet.add(jButtonShrani);
		
		jFileChooserShrani = new JFileChooser();
		jFileChooserShrani.setDialogTitle("Kam zelis shraniti"); 
		//panelPregledIzlet.add(jFileChooserShrani);
		
		jButtonShrani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				jTextAreaStream.setText("test");
				String fileName = "temp.txt";
				try {
					// assume defalut encoding
					FileWriter filewriter = new FileWriter(fileName);
					
					// allways wrap FileWriter in BufferedWriter
					BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
					
					// write() does not automatically append a newline character
					bufferedWriter.write(jTextAreaPregledIzleti.getText());
					
					// allways close files
					bufferedWriter.close();
				}
				catch(IOException ex) {
					System.out.println("Error writing to file: " + fileName);
					// or we could just do that:
					// ex.printStackTrace();
				}
			}
		});
		
		jButtonNalozi = new JButton("Naloži iz datoteke");
		panelPregledIzlet.add(jButtonNalozi);
		
		jButtonNalozi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ime datoteke za odpret (enako kot za shranit)
				String fileName = "temp.txt";
				
				// za referencirat vsako vrstico posebej
				String line = null;
				
				try {
					// FileReader bere text v default encodingu
					FileReader fileReader = new FileReader(fileName);
					
					// vedno ovij FileReader v BufferedReader
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					
					
					jTextAreaStream.read(bufferedReader, "jTextArea1");
					/*
					while((line = bufferedReader.readLine()) != null) {
						System.out.println(line);
					}
					*/
					
					// vedno zapri datoteke
					bufferedReader.close();
					
				}
				catch(FileNotFoundException ex) {
					System.out.println("Unable to open file" + fileName);
				}
				catch(IOException ex) {
					System.out.println("Error reading file" + fileName);
					//ex.printStackTrace();
				}
			}
		});
		
		panelPreglejIzlet.add(panelPregledIzlet);
		tabbed.add("Pregled", panelPreglejIzlet);
		
	}
	
	private class PoslusalecIzletPregled implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==jButtonPregledIzet) {
				System.out.println("v pregledu");
				jTextAreaPregledIzleti.setText(paket.toStringIzleti());
			}
		}
	}
	
	private void initUrediIzlet() {
		JPanel panelUrediIzlet = new JPanel();
		
		JPanel panelUredi = new JPanel();
		panelUredi.setLayout(new BoxLayout(panelUredi, BoxLayout.Y_AXIS));
		
		jLabelIzberiIndeks = new JLabel("Izberi izlet za brisanje");
		panelUredi.add(jLabelIzberiIndeks);
		
		jTextFieldIzberIndeks = new JTextField("1");
		panelUredi.add(jTextFieldIzberIndeks);
		
		jButtonIzberiIndeks = new JButton("Izbrisi");
		panelUredi.add(jButtonIzberiIndeks);
		
		PoslusalecIzletUredi poslusalecIzletUredi = new PoslusalecIzletUredi();
		jButtonIzberiIndeks.addActionListener(poslusalecIzletUredi);
		
		panelUrediIzlet.add(panelUredi);
		tabbed.add("Uredi", panelUrediIzlet);
	}
	
	private class PoslusalecIzletUredi implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==jButtonIzberiIndeks) {
				System.out.println("V uredi");
				int indeksIzleta = Integer.parseInt(jTextFieldIzberIndeks.getText());
				seznamIzletov.remove((indeksIzleta-1));
			}
		}
	}

}
