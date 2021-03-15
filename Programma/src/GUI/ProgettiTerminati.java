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

public class ProgettiTerminati extends JFrame {

	
	private JPanel contentPane;
	Controller theController;
	JFrame frame;
	

	public ProgettiTerminati(ArrayList<Progetto> terminati, Controller c) {
		theController=c;
		setTitle("Progetti Terminati");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(43, 27, 454, 319);
		contentPane.add(scrollPane);
		
		DefaultListModel<String> modelloprogetti = new DefaultListModel<String>();
		for(Progetto p: terminati) {
			modelloprogetti.addElement(p.toString());
		}
		JList Lista_Progetti = new JList();
		scrollPane.setViewportView(Lista_Progetti);
		Lista_Progetti.setModel(modelloprogetti);
		Lista_Progetti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
					theController.Visualizza_Dettagli_Progetto(terminati.get(Lista_Progetti.getSelectedIndex()));
				}
			}
		});
		Bottone_Dettagli_Progetto.setBounds(524, 90, 150, 23);
		contentPane.add(Bottone_Dettagli_Progetto);
	}
}