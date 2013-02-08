package si.unimb.ruk.prijatelj.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoAranzmaji extends JPanel{

	// zavihekAranzmaji
	private JLabel jLabelAranzmaji;
	private JLabel jLabelProdani;
	private JLabel jLabelRetervirani;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JTextField jTextField5;
	private JTextField jTextField6;
	private JButton jButtonProdaj1;
	private JButton jButtonProdaj2;
	private JButton jButtonProdaj3;
	private JButton jButtonProdaj4;
	private JButton jButtonProdaj5;
	private JButton jButtonProdaj6;
	private JButton jButtonRezerviraj1;
	private JButton jButtonRezerviraj2;
	private JButton jButtonRezerviraj3;
	private JButton jButtonRezerviraj4;
	private JButton jButtonRezerviraj5;
	private JButton jButtonRezerviraj6;
	private JButton jButtonProdaniIzbris;
	private JButton jButtonRezerviraniIzbris;
	private JButton jButtonPotrdi;
	private JButton jButtonIzhod;
	private JList jListProdani;
	private JList jListRezervirani;
	private JTabbedPane tabbed;
	private DefaultListModel lmProdani = new DefaultListModel();
	private DefaultListModel lmRezervirani = new DefaultListModel();
	
	public OknoAranzmaji() {
		this.inicializiraj();
	}
	
	public void inicializiraj() {
		this.setLayout(new BorderLayout());
		
		urediAranzmaje();
		
	}
	
	private void urediAranzmaje() {
		JPanel panelAranzmaji = new JPanel();
		panelAranzmaji.setLayout(new BoxLayout(panelAranzmaji, BoxLayout.X_AXIS));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		
		jLabelAranzmaji = new JLabel("Aranžmaji:");
		panelLeft.add(jLabelAranzmaji);
		
		jTextField1 = new JTextField("Egipt");
		panelLeft.add(jTextField1);
		
		jButtonProdaj1 = new JButton("Prodaj");
		panelLeft.add(jButtonProdaj1);
		
		
		jButtonRezerviraj1 = new JButton("Rezerviraj");
		panelLeft.add(jButtonRezerviraj1);
		
		
		jTextField2 = new JTextField("Gardaland");
		panelLeft.add(jTextField2);
		
		jButtonProdaj2 = new JButton("Prodaj");
		panelLeft.add(jButtonProdaj2);
		
		jButtonRezerviraj2 = new JButton("Rezerviraj");
		panelLeft.add(jButtonRezerviraj2);
		
		jTextField3 = new JTextField("Bali");
		panelLeft.add(jTextField3);
		
		jButtonProdaj3 = new JButton("Prodaj");
		panelLeft.add(jButtonProdaj3);
		
		jButtonRezerviraj3 = new JButton("Rezerviraj");
		panelLeft.add(jButtonRezerviraj3);
		
		jTextField4 = new JTextField("Havaji");
		panelLeft.add(jTextField4);
		
		jButtonProdaj4 = new JButton("Prodaj");
		panelLeft.add(jButtonProdaj4);
		
		jButtonRezerviraj4 = new JButton("Rezerviraj");
		panelLeft.add(jButtonRezerviraj4);
		
		jTextField5 = new JTextField("Kanarski");
		panelLeft.add(jTextField5);
		
		jButtonProdaj5 = new JButton("Prodaj");
		panelLeft.add(jButtonProdaj5);
		
		jButtonRezerviraj5 = new JButton("Rezerviraj");
		panelLeft.add(jButtonRezerviraj5);
		
		jTextField6 = new JTextField("Islandija");
		panelLeft.add(jTextField6);
		
		jButtonProdaj6 = new JButton("Prodaj");
		panelLeft.add(jButtonProdaj6);
		
		jButtonRezerviraj6 = new JButton("Rezerviraj");
		panelLeft.add(jButtonRezerviraj6);
		
		// prodani:
		jLabelProdani = new JLabel("Prodani: ");
		panelLeft.add(jLabelProdani);
		
		jListProdani = new JList(lmProdani);
		panelLeft.add(jListProdani);
		
		jButtonProdaniIzbris = new JButton("Izbris");
		panelLeft.add(jButtonProdaniIzbris);
		
		// rezervirani:
		jLabelRetervirani = new JLabel("Rezervirani");
		panelLeft.add(jLabelRetervirani);
		
		
		jListRezervirani = new JList(lmRezervirani);
		panelLeft.add(jListRezervirani);
		
		jButtonRezerviraniIzbris = new JButton("Izbris");
		panelLeft.add(jButtonRezerviraniIzbris);
		
		jButtonPotrdi = new JButton("Potrdi");
		panelLeft.add(jButtonPotrdi);
		
		
		// posluslaci za rezerviraj in prodaj  
		jButtonProdaj1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmProdani.addElement(jTextField1.getText());
			}
		});
		jButtonProdaj2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmProdani.addElement(jTextField2.getText());
			}
		});
		jButtonRezerviraj1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmRezervirani.addElement(jTextField1.getText());
			}
		});
		jButtonRezerviraj2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmRezervirani.addElement(jTextField2.getText());
			}
		});
		jButtonProdaj3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmProdani.addElement(jTextField3.getText());
			}
		});
		jButtonRezerviraj3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmRezervirani.addElement(jTextField3.getText());
			}
		});
		jButtonProdaj4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmProdani.addElement(jTextField4.getText());
			}
		});
		jButtonRezerviraj4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmRezervirani.addElement(jTextField4.getText());
			}
		});
		jButtonProdaj5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmProdani.addElement(jTextField5.getText());
			}
		});
		jButtonRezerviraj5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmRezervirani.addElement(jTextField5.getText());
			}
		});
		jButtonProdaj6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmProdani.addElement(jTextField6.getText());
			}
		});
		jButtonRezerviraj6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lmRezervirani.addElement(jTextField6.getText());
			}
		});
		
		// poslusalca za izbris
		jButtonProdaniIzbris.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<lmProdani.size(); i++) {
					lmProdani.remove(i);
				}
			}
		});
		
		jButtonRezerviraniIzbris.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<lmRezervirani.size(); i++) {
					lmRezervirani.remove(i);
				}
			}
		});
		
		
		
		panelAranzmaji.add(panelLeft);
		this.add(panelAranzmaji);
	}
}
























