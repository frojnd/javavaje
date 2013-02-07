package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class OknoKrizarjenja extends JPanel{
		private JTabbedPane tabbed;
		
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
			
			panelVnesiKrizarjenje.setLayout(new BoxLayout(panelVnesiKrizarjenje, BoxLayout.LINE_AXIS));
			
			
			tabbed.add("Vnos", panelVnesiKrizarjenje);
		}
		
		private void initPreglejKrizarjenje() {
			JPanel panelPreglejKrizarjenje = new JPanel();
			
			tabbed.add("Pregled", panelPreglejKrizarjenje);
			
		}
		
		private void initUrediKrizarjenje() {
			JPanel panelUrediKrizarjenje = new JPanel();
			
			tabbed.add("Uredi", panelUrediKrizarjenje);
		}

}
