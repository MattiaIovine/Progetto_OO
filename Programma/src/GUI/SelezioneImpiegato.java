package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codice.*;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Controller.Controller;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class SelezioneImpiegato extends JFrame {

	Controller theController;
	ArrayList<Impiegato> scelti = new ArrayList<>();
	private JPanel contentPane;
	JFrame frame;

	public SelezioneImpiegato(Controller c, ArrayList<Impiegato> Risultati) {
		theController=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(53, 45, 283, 169);
		contentPane.add(scrollPane);
		
		DefaultListModel<String> newListModel = new DefaultListModel<String>();
		for(Impiegato impiegato:Risultati) {
			newListModel.addElement(impiegato.toString());
		}
		JList Lista_Impiegati = new JList();
		scrollPane.setViewportView(Lista_Impiegati);
		Lista_Impiegati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Lista_Impiegati.setToolTipText("");
		Lista_Impiegati.setModel(newListModel);
		Lista_Impiegati.setVisible(true);
	
		JLabel Etichetta_Selezione1 = new JLabel("Seleziona il Masto");
		Etichetta_Selezione1.setBounds(53, 11, 269, 23);
		contentPane.add(Etichetta_Selezione1);
		
		JLabel Etichetta_Selezione2 = new JLabel("Seleziona gli altri componenti");
		Etichetta_Selezione2.setBounds(53, 11, 269, 23);
		contentPane.add(Etichetta_Selezione2);
		Etichetta_Selezione2.setVisible(false);
		
		JButton Bottone_Completa = new JButton("Completa Selezione");
		Bottone_Completa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Lista_Impiegati.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame, "Seleziona qualcosa!","Errore!", JOptionPane.ERROR_MESSAGE);
				}
				else if(scelti.size()==0){
					scelti.add(Risultati.get(Lista_Impiegati.getSelectedIndex()));
					Risultati.remove(Lista_Impiegati.getSelectedIndex());
					newListModel.remove(Lista_Impiegati.getSelectedIndex());
					Etichetta_Selezione1.setVisible(false);	
					Etichetta_Selezione2.setVisible(true);
					Lista_Impiegati.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				}
				else {
					for(int i:Lista_Impiegati.getSelectedIndices()) {
						scelti.add(Risultati.get(i));
					}
					theController.Aggiungi_Impiegati(scelti);
				}

			}	
		});
		Bottone_Completa.setBounds(419, 140, 125, 23);
		contentPane.add(Bottone_Completa);
		
		JButton Bottone_Cancella = new JButton("Cancella Creazione Progetto");
		Bottone_Cancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				theController.RimuoviUltimoProgetto();
			}
		});
		Bottone_Cancella.setBounds(53, 273, 196, 23);
		contentPane.add(Bottone_Cancella);
		
		JButton Bottone_Indietro = new JButton("Ritorna ai Filtri");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.Torna_Filtri();
			}
		});
		Bottone_Indietro.setBounds(419, 273, 125, 23);
		contentPane.add(Bottone_Indietro);
		

	}
}
