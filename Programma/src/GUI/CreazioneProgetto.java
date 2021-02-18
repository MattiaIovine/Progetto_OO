package GUI;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class CreazioneProgetto extends JFrame {

	private JPanel contentPane;
	Controller theController;
	JComboBox<String> boxAmbiti;
	JComboBox<String> boxTipologie;
	private JTextField Campo_Titolo;

	public CreazioneProgetto(Controller c) {
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Etichetta_Tipologia = new JLabel("Tipologia");
		Etichetta_Tipologia.setBounds(88, 190, 86, 14);
		contentPane.add(Etichetta_Tipologia);
		
		JLabel Etichetta_Ambito = new JLabel("Ambito");
		Etichetta_Ambito.setBounds(88, 118, 46, 14);
		contentPane.add(Etichetta_Ambito);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.Torna_Gestione_Progetto();
			}
		});
		Bottone_Indietro.setBounds(10, 322, 103, 49);
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_Crea_Progetto = new JButton("Crea Progetto");
		Bottone_Crea_Progetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				System.out.println(boxAmbiti.getSelectedItem());
			}
		});
		Bottone_Crea_Progetto.setBounds(380, 322, 120, 49);
		contentPane.add(Bottone_Crea_Progetto);
		
		
		String[] ambiti = {
		         "Economia",
		         "Medicina",
		         "Informatica",
		         "Ingegneria"      
		};
		
		String[] tipologie = {
		         "Ricerca Sperimentale",
		         "Ricerca di base",
		         "Sviluppo Sperimentale",
		         "Ricerca Industriale"
		};
		
		boxAmbiti = new JComboBox(ambiti);
		boxAmbiti.setSelectedIndex(-1);
		boxAmbiti.setBounds(215, 114, 137, 22);
		contentPane.add(boxAmbiti);
		
		boxTipologie = new JComboBox(tipologie);
		boxTipologie.setSelectedIndex(-1);
		boxTipologie.setBounds(215, 186, 137, 22);
		contentPane.add(boxTipologie);
		
		JLabel Etichetta_Titolo_Progetto = new JLabel("Titolo Progetto");
		Etichetta_Titolo_Progetto.setBounds(88, 46, 86, 14);
		contentPane.add(Etichetta_Titolo_Progetto);
		
		Campo_Titolo = new JTextField();
		Campo_Titolo.setBounds(215, 43, 264, 20);
		contentPane.add(Campo_Titolo);
		Campo_Titolo.setColumns(10);
	}
}
