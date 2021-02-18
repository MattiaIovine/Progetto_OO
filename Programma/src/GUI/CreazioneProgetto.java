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

public class CreazioneProgetto extends JFrame {

	private JPanel contentPane;
	Controller theController;

	public CreazioneProgetto(Controller c) {
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipologia");
		lblNewLabel.setBounds(88, 46, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ambito");
		lblNewLabel_1.setBounds(87, 118, 46, 14);
		contentPane.add(lblNewLabel_1);
		
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
			}
		});
		Bottone_Crea_Progetto.setBounds(380, 322, 120, 49);
		contentPane.add(Bottone_Crea_Progetto);
	}
}
