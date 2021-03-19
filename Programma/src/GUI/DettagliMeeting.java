package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codice.Impiegato;
import Codice.Meeting;
import Controller.Controller;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DettagliMeeting extends JFrame {

	private JPanel contentPane;
	Controller theController;
	
	
	public DettagliMeeting(Controller c, ArrayList<Impiegato> partecipanti, Meeting m) {
		theController=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> modellopartecipanti = new DefaultListModel<String>();
		for(Impiegato i:partecipanti) {
			modellopartecipanti.addElement(i.toStringMinimo());
		}
		
		JList Lista_Partecipanti = new JList();
		Lista_Partecipanti.setModel(modellopartecipanti);
		Lista_Partecipanti.setBounds(10, 108, 553, 176);
		contentPane.add(Lista_Partecipanti);
		
		JLabel Etichetta_Progetto = new JLabel("Progetto: "+m.getArgomento().getTitolo());
		Etichetta_Progetto.setBounds(10, 11, 501, 21);
		contentPane.add(Etichetta_Progetto);
		
		JLabel Etichetta_Tipo = new JLabel(m.getTipo());
		Etichetta_Tipo.setBounds(10, 54, 143, 21);
		contentPane.add(Etichetta_Tipo);
		
		JLabel Etichetta_Data = new JLabel("Data: "+m.getData().getTime());
		Etichetta_Data.setBounds(367, 50, 196, 28);
		contentPane.add(Etichetta_Data);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				theController.Vista_Visualizza_Meeting();
			}
		});
		Bottone_Indietro.setBounds(10, 319, 89, 23);
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_Termina_Meeting = new JButton("Termina Meeting");
		Bottone_Termina_Meeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valori[]=Lista_Partecipanti.getSelectedIndices();
				for(int i=valori.length-1; i>=0;i--) {
					partecipanti.remove(valori[i]);
				}
				theController.Termina_Meeting(m, partecipanti);
			}
		});
		Bottone_Termina_Meeting.setBounds(505, 319, 149, 38);
		contentPane.add(Bottone_Termina_Meeting);
		
		JLabel Etichetta_Seleziona_Assenti = new JLabel("Seleziona gli impiegati assenti");
		Etichetta_Seleziona_Assenti.setBounds(10, 86, 248, 14);
		contentPane.add(Etichetta_Seleziona_Assenti);
	}

}
