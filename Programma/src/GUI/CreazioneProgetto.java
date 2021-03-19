package GUI;

import Controller.Controller;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;

public class CreazioneProgetto extends JFrame {

	private JPanel contentPane;
	Controller theController;
	JTextArea Campo_Titolo;
	JFrame frame;

	public CreazioneProgetto(Controller c) {
		setTitle("Crea Nuovo Progetto");
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Etichetta_Tipologia = new JLabel("Tipologia");
		Etichetta_Tipologia.setBounds(88, 205, 86, 14);
		contentPane.add(Etichetta_Tipologia);
		
		JLabel Etichetta_Ambito = new JLabel("Ambito");
		Etichetta_Ambito.setBounds(88, 145, 46, 14);
		contentPane.add(Etichetta_Ambito);
		
		JComboBox<String> Box_Ambiti = new JComboBox<>();
		Box_Ambiti.setModel(new DefaultComboBoxModel<String>(new String[] {"Economia", "Medicina", "Informatica", "Ingegneria"}));
		Box_Ambiti.setBounds(215, 141, 137, 22);
		Box_Ambiti.setSelectedIndex(-1);
		contentPane.add(Box_Ambiti);
		
		JComboBox<String> boxTipologie = new JComboBox<>();
		boxTipologie.setModel(new DefaultComboBoxModel<String>(new String[] {"Ricerca Sperimentale","Ricerca di base","Sviluppo Sperimentale","Ricerca Industriale"}));
		boxTipologie.setBounds(215, 201, 137, 22);
		boxTipologie.setSelectedIndex(-1);
		contentPane.add(boxTipologie);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				theController.Torna_Gestione_Progetto();
			}
		});
		Bottone_Indietro.setBounds(10, 331, 103, 40);
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_Crea_Progetto = new JButton("Crea Progetto");
		Bottone_Crea_Progetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boxTipologie.getSelectedIndex()==-1 || Box_Ambiti.getSelectedIndex()==-1 || Campo_Titolo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Tutti i campi devono essere pieni!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				else {
					theController.Crea_Progetto(Campo_Titolo.getText(),(String) boxTipologie.getSelectedItem(),(String) Box_Ambiti.getSelectedItem());
				}
			}
		});
		Bottone_Crea_Progetto.setBounds(396, 331, 120, 40);
		contentPane.add(Bottone_Crea_Progetto);		
		
		JLabel Etichetta_Titolo_Progetto = new JLabel("Titolo Progetto");
		Etichetta_Titolo_Progetto.setBounds(88, 49, 86, 14);
		contentPane.add(Etichetta_Titolo_Progetto);
		
		Campo_Titolo = new JTextArea();
		Campo_Titolo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Campo_Titolo.setLineWrap(true);
		Campo_Titolo.setBounds(215, 24, 236, 67);
		contentPane.add(Campo_Titolo);
	}
}
