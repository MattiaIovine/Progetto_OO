package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FinestraPrincipale extends JFrame {

	private JPanel contentPane;
		Controller theController;
		

	public FinestraPrincipale(Controller c) {
		theController = c;
		setTitle("Finestra Principale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bottone_Chiudi = new JButton("Chiudi");
		Bottone_Chiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		Bottone_Chiudi.setBounds(426, 328, 89, 44);
		contentPane.add(Bottone_Chiudi);
		
		JButton Bottone_Progetti = new JButton("Gestione Progetti");
		Bottone_Progetti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theController.Vista_Gestione_Progetti();
			}
		});
		Bottone_Progetti.setBounds(62, 60, 229, 44);
		contentPane.add(Bottone_Progetti);
		
		JButton Bottone_Meeting = new JButton("Lista Meeting");
		Bottone_Meeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theController.Vista_Visualizza_Meeting();
			}
		});
		Bottone_Meeting.setBounds(62, 160, 229, 44);
		contentPane.add(Bottone_Meeting);
		
		JButton Bottone_Assunzioni = new JButton("Assunzione Impiegato");
		Bottone_Assunzioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theController.Vista_Assunzione_Impiegato();
			}
		});
		Bottone_Assunzioni.setBounds(62, 260, 229, 44);
		contentPane.add(Bottone_Assunzioni);
	}
}
