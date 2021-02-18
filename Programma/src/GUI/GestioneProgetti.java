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
public class GestioneProgetti extends JFrame {

	private JPanel contentPane;

		Controller theController;

	public GestioneProgetti(Controller c) {
		theController = c;
		setTitle("Gestione Progetti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				theController.Torna_Finestra_Principale();
			}
		});
		Bottone_Indietro.setBounds(426, 328, 89, 44);
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_VediProgetti = new JButton("Visualizza Progetti Attivi");
		Bottone_VediProgetti.setBounds(60, 68, 169, 44);
		contentPane.add(Bottone_VediProgetti);
		
		JButton Bottone_CreaProgetto = new JButton("Crea Nuovo Progetto");
		Bottone_CreaProgetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.Vista_Creazione_Progetto();
			}
		});
		Bottone_CreaProgetto.setBounds(60, 209, 169, 44);
		contentPane.add(Bottone_CreaProgetto);
		
		JButton Bottone_FineProgetto = new JButton("Termina Progetto");
		Bottone_FineProgetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Bottone_FineProgetto.setBounds(60, 137, 169, 44);
		contentPane.add(Bottone_FineProgetto);
	}

}
