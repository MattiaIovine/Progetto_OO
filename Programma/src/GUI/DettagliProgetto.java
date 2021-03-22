package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Codice.Impiegato;
import Codice.Progetto;
import Controller.Controller;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class DettagliProgetto extends JFrame {

	private JPanel contentPane;
	private Controller theController;

	public DettagliProgetto(Controller c, Progetto progetto) {
		setTitle("Dettagli Progetto");
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bottone_Meeting = new JButton("Organizza Meeting");
		Bottone_Meeting.setBounds(526, 428, 159, 40);
		Bottone_Meeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.Vista_Creazione_Meeting(progetto);
			}	
		});
		if(progetto.isAttivo()) {
			contentPane.add(Bottone_Meeting);
		}
		
		
		ArrayList<Impiegato> partecipanti=progetto.getPartecipanti();
		DefaultListModel<String> modellopartecipanti = new DefaultListModel<String>();
		for(Impiegato i:partecipanti) {
			modellopartecipanti.addElement(i.toStringMinimo());
		}
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(progetto.isAttivo()) {
					theController.Torna_Progetti_Attivi();
				}
				else {
					theController.Torna_Progetti_Terminati();
				}
			}
		});
		Bottone_Indietro.setBounds(10, 428, 89, 40);
		contentPane.add(Bottone_Indietro);
		
		JLabel Etichetta_Titolo = new JLabel("Titolo:");
		Etichetta_Titolo.setBounds(44, 27, 83, 14);
		contentPane.add(Etichetta_Titolo);
		
		JLabel Etichetta_Ambito = new JLabel("Ambito:");
		Etichetta_Ambito.setBounds(44, 65, 83, 14);
		contentPane.add(Etichetta_Ambito);
		
		JLabel Etichetta_Tipologia = new JLabel("Tipologia:");
		Etichetta_Tipologia.setBounds(44, 108, 83, 14);
		contentPane.add(Etichetta_Tipologia);
		
		JLabel Etichetta_Project_Manager = new JLabel("Project Manager:");
		Etichetta_Project_Manager.setBounds(44, 145, 119, 14);
		contentPane.add(Etichetta_Project_Manager);
		
		JLabel Etichetta_Partecipanti = new JLabel("Partecipanti:");
		Etichetta_Partecipanti.setBounds(44, 189, 83, 14);
		contentPane.add(Etichetta_Partecipanti);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 190, 367, 207);
		contentPane.add(scrollPane);
		
		JList Lista_Partecipanti = new JList();
		Lista_Partecipanti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Lista_Partecipanti.setModel(modellopartecipanti);
		scrollPane.setViewportView(Lista_Partecipanti);
		
		JLabel Campo_Titolo = new JLabel(progetto.getTitolo());
		Campo_Titolo.setBounds(175, 27, 296, 14);
		contentPane.add(Campo_Titolo);
		
		JLabel Campo_Ambito = new JLabel(progetto.getAmbito());
		Campo_Ambito.setBounds(175, 65, 296, 14);
		contentPane.add(Campo_Ambito);
		
		JLabel Campo_Tipologia = new JLabel(progetto.getTipologia());
		Campo_Tipologia.setBounds(175, 108, 296, 14);
		contentPane.add(Campo_Tipologia);
		
		JLabel Campo_Project_Manager = new JLabel(progetto.getProjectManager().toStringMinimo());
		Campo_Project_Manager.setBounds(175, 145, 459, 14);
		contentPane.add(Campo_Project_Manager);
		

		
	}
}
