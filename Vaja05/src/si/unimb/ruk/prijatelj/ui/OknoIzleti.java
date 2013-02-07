package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class OknoIzleti extends JPanel{
	private JTabbedPane tabbed;
	
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
		
		
		tabbed.add("Vnos", panelVnesiIzlet);
	}
	
	private void initPreglejIzlet() {
		JPanel panelPreglejIzlet = new JPanel();
		
		tabbed.add("Pregled", panelPreglejIzlet);
		
	}
	
	private void initUrediIzlet() {
		JPanel panelUrediIzlet = new JPanel();
		
		tabbed.add("Uredi", panelUrediIzlet);
	}

}
