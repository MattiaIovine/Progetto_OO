package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codice.Impiegato;
import Codice.Progetto;
import Controller.Controller;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ProgettiAttivi extends JFrame {

	
	private JPanel contentPane;
	Controller theController;
	JFrame frame;
	

	public ProgettiAttivi(ArrayList<Progetto> progettiattivi, Controller c) {
		theController=c;
		setTitle("Progetti Attivi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 27, 454, 319);
		contentPane.add(scrollPane);
		
		DefaultListModel<String> modelloprogetti = new DefaultListModel<String>();
		for(Progetto p: progettiattivi) {
			modelloprogetti.addElement(p.toString());
		}
		JList Lista_Progetti = new JList();
		Lista_Progetti.setModel(modelloprogetti);
		Lista_Progetti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(Lista_Progetti);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				theController.Torna_Gestione_Progetto();
			}
		});
		Bottone_Indietro.setBounds(524, 406, 150, 23);
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_Dettagli_Progetto = new JButton("Dettagli Progetto");
		Bottone_Dettagli_Progetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Lista_Progetti.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame, "Devi selezionare un progetto!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				else {
					theController.Visualizza_Dettagli_Progetto(progettiattivi.get(Lista_Progetti.getSelectedIndex()));
				}
			}
		});
		Bottone_Dettagli_Progetto.setBounds(524, 90, 150, 23);
		contentPane.add(Bottone_Dettagli_Progetto);
		
		JButton Bottone_Termina_Progetto = new JButton("Termina Progetto");
		Bottone_Termina_Progetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Lista_Progetti.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame, "Devi selezionare un progetto!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				else {
					theController.Vista_Termina_Progetto(progettiattivi.get(Lista_Progetti.getSelectedIndex()));
				}
			}
		});
		Bottone_Termina_Progetto.setBounds(524, 235, 150, 23);
		contentPane.add(Bottone_Termina_Progetto);
	}
}
