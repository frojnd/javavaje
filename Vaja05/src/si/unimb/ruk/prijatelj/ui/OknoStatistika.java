package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OknoStatistika extends JPanel{
	private JLabel jLabelZasluzki;
	private JLabel jLabelZasluzkiToLeto;
	private JLabel jLabelZaposleni;
	private JLabel jLabelStVodicev;
	private JLabel jLabelStAranzmajev;
	private JLabel jLabelProdani;
	private JLabel jLabelRezervirani;
	private JTextField jTextFieldZasluzki;
	private JTextField jTextFieldZasluzkiToLeto;
	private JTextField jTextFieldStZaposlenih;
	private JTextField jTextFieldStVodicev;
	private JTextField jTextFieldProdani;
	private JTextField jTextFieldRezervirani;
	
	public OknoStatistika() {
		this.inicializiraj();
	}
	
	public void inicializiraj() {
		this.setLayout(new BorderLayout());
		
		statistika();
	}
	
	public void statistika() {
		
		JPanel panelStatistika = new JPanel();
		panelStatistika.setLayout(new BoxLayout(panelStatistika, BoxLayout.X_AXIS));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		
		jLabelZasluzki = new JLabel("Zasluzki ta mesec:");
		panelLeft.add(jLabelZasluzki);
		
		jTextFieldZasluzki = new JTextField("5000.00");
		panelLeft.add(jTextFieldZasluzki);
		
		jLabelZasluzkiToLeto = new JLabel("Zasluzki to leto:");
		panelLeft.add(jLabelZasluzki);
		
		jTextFieldZasluzkiToLeto = new JTextField("50000.00");
		panelLeft.add(jTextFieldZasluzkiToLeto);
		
		jLabelZaposleni = new JLabel("Število zaposlenih:");
		panelLeft.add(jLabelZaposleni);
		
		jTextFieldStZaposlenih = new JTextField("20");
		panelLeft.add(jTextFieldStZaposlenih);
		
		jLabelStVodicev = new JLabel("Število vodičev:");
		panelLeft.add(jLabelStVodicev);
		
		jTextFieldStVodicev = new JTextField("10");
		panelLeft.add(jTextFieldStVodicev);
		
		jLabelProdani = new JLabel("Število prodanih aranžmajev:");
		panelLeft.add(jLabelProdani);
		
		jTextFieldProdani = new JTextField("2");
		panelLeft.add(jTextFieldProdani);
		
		jLabelRezervirani = new JLabel("Število rezerviranih aranžmajev");
		panelLeft.add(jLabelRezervirani);
		
		jTextFieldRezervirani = new JTextField("4");
		panelLeft.add(jTextFieldRezervirani);
		
		panelStatistika.add(panelLeft);
		this.add(panelStatistika);
	}

}


