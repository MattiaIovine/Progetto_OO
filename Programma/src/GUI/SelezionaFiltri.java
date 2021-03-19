package GUI;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Codice.Skill;
import Controller.Controller;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SelezionaFiltri extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	Controller theController;

	public SelezionaFiltri(ArrayList<Skill> listaskill, Controller c) {
		setTitle("Selezione Filtri");
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner Spinner_Valutazione = new JSpinner();
		Spinner_Valutazione.setModel(new SpinnerNumberModel(0, 0, 1000, 10)); 
		Spinner_Valutazione.setBounds(165, 33, 68, 20);
		contentPane.add(Spinner_Valutazione);

		JSpinner Spinner_Salario = new JSpinner();
		Spinner_Salario.setModel(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 50.0));
		Spinner_Salario.setBounds(165, 78, 68, 20);
		contentPane.add(Spinner_Salario);
		
		JLabel Etichetta_Valutazione = new JLabel("Valutazione Minima");
		Etichetta_Valutazione.setBounds(35, 36, 103, 14);
		contentPane.add(Etichetta_Valutazione);

		JLabel Etichetta_Salario = new JLabel("Salario Minimo");
		Etichetta_Salario.setBounds(37, 81, 83, 14);
		contentPane.add(Etichetta_Salario);
		
		JLabel Etichetta_Ambito = new JLabel("Ambito");
		Etichetta_Ambito.setBounds(35, 139, 46, 14);
		contentPane.add(Etichetta_Ambito);
		
		JComboBox Box_Ambiti = new JComboBox();
		Box_Ambiti.setModel(new DefaultComboBoxModel(new String[] {"Qualsiasi", "Economia", "Medicina", "Informatica", "Ingegneria"}));
		Box_Ambiti.setBounds(165, 135, 91, 22);
		contentPane.add(Box_Ambiti);
		
		DefaultListModel<String> ModelloAbilità = new DefaultListModel<String>();
		for(Skill s:listaskill) {ModelloAbilità.addElement(s.getNome());}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(130, 189, 287, 81);
		contentPane.add(scrollPane);
		JList Lista_Skill = new JList();
		Lista_Skill.setModel(ModelloAbilità);
		scrollPane.setColumnHeaderView(Lista_Skill);

		Lista_Skill.setVisible(true);
		
		
		JLabel Etichetta_Skill = new JLabel("Skill Richieste");
		Etichetta_Skill.setBounds(37, 226, 83, 14);
		contentPane.add(Etichetta_Skill);
		
		JButton Bottone_Seleziona_Filtri = new JButton("Conferma Filtri");
		Bottone_Seleziona_Filtri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Skill> SkillSelezionate = new ArrayList<>();
				for (int i:Lista_Skill.getSelectedIndices()) {
					SkillSelezionate.add(listaskill.get(i));
				}
				try {
				    Spinner_Valutazione.commitEdit();
				    Spinner_Salario.commitEdit();
				} catch ( java.text.ParseException pe ) {
					JOptionPane.showMessageDialog(frame, "Errore!","Attenzione", JOptionPane.ERROR_MESSAGE);
				}
				theController.getImpiegatibyFiltri((Integer) Spinner_Valutazione.getValue(),(Double) Spinner_Salario.getValue(),(String) Box_Ambiti.getSelectedItem(), SkillSelezionate);
			}
		});
		Bottone_Seleziona_Filtri.setBounds(442, 313, 118, 32);
		contentPane.add(Bottone_Seleziona_Filtri);
		
		JButton Bottone_Cancella_Creazione = new JButton("Cancella Creazione Progetto");
		Bottone_Cancella_Creazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				theController.RimuoviUltimoProgetto();
			}
		});
		Bottone_Cancella_Creazione.setBounds(10, 313, 188, 32);
		contentPane.add(Bottone_Cancella_Creazione);
		

	}
}
