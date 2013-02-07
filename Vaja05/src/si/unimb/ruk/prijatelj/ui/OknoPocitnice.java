package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class OknoPocitnice extends JPanel{
		private JTabbedPane tabbed;
		
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
			
			panelVnesiPocitnice.setLayout(new BoxLayout(panelVnesiPocitnice, BoxLayout.LINE_AXIS));
			
			
			tabbed.add("Vnos", panelVnesiPocitnice);
		}
		
		private void initPreglejPocitnice() {
			JPanel panelPreglejPocitnice = new JPanel();
			
			tabbed.add("Pregled", panelPreglejPocitnice);
			
		}
		
		private void initUrediPocitnice() {
			JPanel panelUrediPocitnice = new JPanel();
			
			tabbed.add("Uredi", panelUrediPocitnice);
		}
}
