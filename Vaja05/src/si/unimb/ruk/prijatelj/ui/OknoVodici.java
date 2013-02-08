package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.PanelPeer;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import si.unimb.ruk.prijatelj.logika.oddihi.Paket;
import si.unimb.ruk.prijatelj.logika.osebe.Vodic;
import sun.awt.windows.ThemeReader;

public class OknoVodici extends JPanel {
	
	private JTabbedPane tabbed;
	
	// spremenljivke za initVnesiVodica()
	private JButton jButtonVnesi;
	private String storename = "";
	private JTextField jTextFieldVnesiIme;
	private JTextField jTextFieldVnesiPriimek;
	private JTextField jTextFieldVnesiEposto;
	private JTextField jTextFieldVnesiRojstniDatum;
	private Checkbox CheckboxDa;
	private Checkbox CheckboxNe;
	private JCheckBox jCheckBoxSlovensko;
	private JCheckBox jCheckBoxNemsko;
	private JCheckBox jCheckBoxItalijansko;
	private JCheckBox jCheckBoxSpansko;
	private JCheckBox jCheckBoxAnglesko;
	
	// spremenljivke za initPreglejVodica()
	private JButton jButtonIzpisi;
	private JTextArea jTextAreaPregledVodicev;
	private JList jListPregledVodicev;
	private DefaultListModel model;
	
	// spremenljivke za initUrediVodica()
	private JLabel jLabelIzberiVodica;
	private JComboBox jComboBoxIzbiraVodica;
	private JButton jButtonIzbrisiVodica;
	private JTextField jTextFieldIndeksVodica;
	
	// list za vodice
	List<Vodic> seznamVodicev = new ArrayList<Vodic>(); 
	Paket paket = new Paket();

	
	public OknoVodici() {
		tabbed = new JTabbedPane();
		
		this.inicializiraj();
	}
	
	private void inicializiraj() {
		this.setLayout(new BorderLayout());
		
		initVnesiVodica();
		initPreglejVodica();
		initUrediVodica();
		
		this.add(tabbed);
		
		this.repaint();
	}
	
	private void initVnesiVodica() {
		JPanel panelVnesiVodica = new JPanel();
		
		panelVnesiVodica.setLayout(new BoxLayout(panelVnesiVodica, BoxLayout.X_AXIS));
		
		// ustvarim labele za pojasnilo 
		JPanel panelJLabel = new JPanel();
		panelJLabel.setLayout(new BoxLayout(panelJLabel, BoxLayout.Y_AXIS));
		
		JLabel item1 = new JLabel("Vnesi ime:");
		item1.setToolTipText("This is gonna show on hower");
		panelJLabel.add(item1);
		
		//JTextField jTextFieldVnesiIme = new JTextField("Vnesi ime");
		jTextFieldVnesiIme = new JTextField("Vnesi ime");
		panelJLabel.add(jTextFieldVnesiIme);
		
		JLabel item2 = new JLabel("Vnesi priimek:");
		panelJLabel.add(item2);
		
		jTextFieldVnesiPriimek = new JTextField("Vnesi priimek");
		panelJLabel.add(jTextFieldVnesiPriimek);
		
		JLabel item3 = new JLabel("Vnesi eposto:");
		panelJLabel.add(item3);
		
		jTextFieldVnesiEposto = new JTextField("Vnesi eposto");
		panelJLabel.add(jTextFieldVnesiEposto);
		
		JLabel item4 = new JLabel("Vnesi rojstni datum:");
		panelJLabel.add(item4);
		
		jTextFieldVnesiRojstniDatum = new JTextField("12-12-1990");
		panelJLabel.add(jTextFieldVnesiRojstniDatum);
		
		JLabel item5 = new JLabel("Licenca gorskega vodnika:");
		panelJLabel.add(item5);
		
		CheckboxGroup checkboxGroupLicenca = new CheckboxGroup();
		CheckboxDa = new Checkbox("Da", checkboxGroupLicenca, false);
		CheckboxNe = new Checkbox("Ne", checkboxGroupLicenca, false);
		panelJLabel.add(CheckboxNe);
		panelJLabel.add(CheckboxDa);
		
		JLabel item6 = new JLabel("Govori:");
		panelJLabel.add(item6);
		
		jCheckBoxSlovensko = new JCheckBox("Slovensko");
		jCheckBoxNemsko = new JCheckBox("Nemsko");
		jCheckBoxItalijansko = new JCheckBox("Italijansko");
		jCheckBoxSpansko = new JCheckBox("Spansko");
		jCheckBoxAnglesko = new JCheckBox("Anglesko");
		
		panelJLabel.add(jCheckBoxSlovensko);
		panelJLabel.add(jCheckBoxNemsko);
		panelJLabel.add(jCheckBoxItalijansko);
		panelJLabel.add(jCheckBoxSpansko);
		panelJLabel.add(jCheckBoxAnglesko);
		
		/*
		JPanel panelJtextField = new JPanel();
		panelJtextField.setLayout(new BoxLayout(panelJtextField, BoxLayout.Y_AXIS));
		*/
		
		//JButton jButtonVnesi = new JButton("Vnesi");
		jButtonVnesi = new JButton("Vnesi");
		
		PoslusalecVoodicVnos poslusalecVodicVnos = new PoslusalecVoodicVnos();
		jButtonVnesi.addActionListener(poslusalecVodicVnos);
		
		panelJLabel.add(jButtonVnesi);
		
		panelVnesiVodica.add(panelJLabel);
		
		tabbed.add("Vnos", panelVnesiVodica);
			
	}
	
	private class PoslusalecVoodicVnos implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==jButtonVnesi) {
				/*
				System.out.println("Pritisnil si gumb Vnesi");
				storename = jTextFieldVnesiIme.getText();
				JOptionPane.showMessageDialog(null, "Hello " + storename);
				System.exit(0);
				*/
				Vodic vodicVnos = new Vodic(jTextFieldVnesiIme.getText(), jTextFieldVnesiPriimek.getText());
				
				vodicVnos.setEposta(jTextFieldVnesiEposto.getText());
				
				String rojstniDatumV = jTextFieldVnesiRojstniDatum.getText();
				String[] razdeli = rojstniDatumV.split("-");
				
				for(int i=0; i<razdeli.length; i++) {
					System.out.println(Integer.parseInt(razdeli[i]));
				}
				
				GregorianCalendar rdVodica = new GregorianCalendar((Integer.parseInt(razdeli[2])), Integer.parseInt(razdeli[1])-1, Integer.parseInt(razdeli[0]));
				vodicVnos.setRojstniDatum(rdVodica);
				
				Boolean imaNimaLicenco;
				if(CheckboxDa.getState()) {
					imaNimaLicenco = true;
				}
				else {
					imaNimaLicenco = false;
				}
				vodicVnos.setLicencaGorskegaVodnika(imaNimaLicenco);
				
				List<Vodic.Jezik> seznamJezikov = new ArrayList<Vodic.Jezik>();
				if(jCheckBoxAnglesko.isSelected()) {
					seznamJezikov.add(Vodic.Jezik.Anglesko);
				}
				if(jCheckBoxItalijansko.isSelected()) {
					seznamJezikov.add(Vodic.Jezik.Italijansko);
				}
				if(jCheckBoxNemsko.isSelected()) {
					seznamJezikov.add(Vodic.Jezik.Nemsko);
				}
				if(jCheckBoxSlovensko.isSelected()) {
					seznamJezikov.add(Vodic.Jezik.Slovensko);
				}
				if(jCheckBoxSpansko.isSelected()) {
					seznamJezikov.add(Vodic.Jezik.Spansko);
				}
				vodicVnos.setGovori(seznamJezikov);
				System.out.println("Govori: " + vodicVnos.getGovori());
				
				seznamVodicev.add(vodicVnos);
				paket.setSeznamVodicev(seznamVodicev);
			}
		}
	}

	
	private void initPreglejVodica() {
		JPanel panelPreglejVodica = new JPanel();
		panelPreglejVodica.setLayout(new BoxLayout(panelPreglejVodica, BoxLayout.X_AXIS));
		
		JPanel panelPregled = new JPanel();
		panelPregled.setLayout(new BoxLayout(panelPregled, BoxLayout.Y_AXIS));
		
		jTextAreaPregledVodicev = new JTextArea();
		panelPregled.add(jTextAreaPregledVodicev);
		/*
		model = new DefaultListModel();
		jListPregledVodicev = new JList<>(model);
		panelPregled.add(jListPregledVodicev);
		*/
		
		jButtonIzpisi = new JButton("Izpisi");
		PoslusalecVodicPreglej poslusalecVodicPreglej = new PoslusalecVodicPreglej();
		jButtonIzpisi.addActionListener(poslusalecVodicPreglej);
		
		panelPregled.add(jButtonIzpisi);
		
		panelPreglejVodica.add(panelPregled);
		
		tabbed.add("Pregled", panelPreglejVodica);
	}
	
	private class PoslusalecVodicPreglej implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==jButtonIzpisi) {
				//jTextAreaPregledVodicev.setText(jTextFieldVnesiIme.getText());
				System.out.println("izpis");
				jTextAreaPregledVodicev.setText(paket.toStringVodici());
				//model.addElement(paket.toStringVodici()+ "\n");
			}
			
		}
	}
	
	private void initUrediVodica() {
		JPanel panelUrediVodica = new JPanel();
		//panelUrediVodica.setLayout(new BoxLayout(panelUrediVodica, BoxLayout.X_AXIS));
		
		JPanel panelUredi = new JPanel();
		panelUredi.setLayout(new BoxLayout(panelUredi, BoxLayout.X_AXIS));
		
		jLabelIzberiVodica = new JLabel("Izberi Vodiča:");
		panelUredi.add(jLabelIzberiVodica);
		
		System.out.println("seznamVodicev.size()" + seznamVodicev.size());
		
		jTextFieldIndeksVodica = new JTextField("1");
		panelUredi.add(jTextFieldIndeksVodica);
		
		
		jButtonIzbrisiVodica = new JButton("Izbrisi vodiča: ");
		PoslusalecVodicUredi posVodicUredi = new PoslusalecVodicUredi();
		jButtonIzbrisiVodica.addActionListener(posVodicUredi);
		
		panelUredi.add(jButtonIzbrisiVodica);
		
		panelUrediVodica.add(panelUredi);
		tabbed.add("Uredi", panelUrediVodica);
	}
	
	private class PoslusalecVodicUredi implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("test");
			
			int indeksVodica = Integer.parseInt(jTextFieldIndeksVodica.getText());
			seznamVodicev.remove((indeksVodica-1));
		}
	}
	
}
