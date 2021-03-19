package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Codice.Impiegato;
import Codice.Meeting;
import Codice.Progetto;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import Controller.Controller;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
public class VisualizzaMeeting extends JFrame {
	
	private JPanel contentPane;
	Controller theController;
	JFrame frame;

	public VisualizzaMeeting(Controller c, ArrayList<Meeting> meetings) {
		theController = c;
		setTitle("Gestione Meeting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> modellomeetings = new DefaultListModel<String>();
		for(Meeting m:meetings) {
			modellomeetings.addElement(m.toString());
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 75, 589, 178);
		contentPane.add(scrollPane);
		
		JList Lista_Meetings = new JList();
		Lista_Meetings.setModel(modellomeetings);
		Lista_Meetings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(Lista_Meetings);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.setBounds(50, 327, 89, 44);
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				theController.Torna_Finestra_Principale();
			}
		});
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_Tieni_Meeting = new JButton("Tieni Meeting");
		Bottone_Tieni_Meeting.setBounds(585, 327, 133, 44);
		Bottone_Tieni_Meeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Lista_Meetings.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame, "Devi selezionare un meeting!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				else {
					theController.Tieni_Meeting(meetings.get(Lista_Meetings.getSelectedIndex()));
				}
			}
		});
		contentPane.add(Bottone_Tieni_Meeting);
		
	
	}
}
