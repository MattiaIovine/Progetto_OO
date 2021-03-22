package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GestioneProgetti extends JFrame {

	private JPanel contentPane;
	private Controller theController;

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
		Bottone_Indietro.setBounds(10, 327, 89, 44);
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_Progetti_Attivi = new JButton("Visualizza Progetti Attivi");
		Bottone_Progetti_Attivi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				theController.Vista_Progetti_Attivi();
			}
		});
		Bottone_Progetti_Attivi.setBounds(133, 55, 281, 44);
		contentPane.add(Bottone_Progetti_Attivi);
		
		JButton Bottone_Crea_Progetto = new JButton("Crea Nuovo Progetto");
		Bottone_Crea_Progetto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.Vista_Creazione_Progetto();
			}
		});
		Bottone_Crea_Progetto.setBounds(133, 240, 281, 44);
		contentPane.add(Bottone_Crea_Progetto);
		
		JButton Bottone_Progetti_Terminati = new JButton("Visualizza Progetti Terminati");
		Bottone_Progetti_Terminati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.Vista_Progetti_Terminati();
			}
		});
		Bottone_Progetti_Terminati.setBounds(133, 147, 281, 44);
		contentPane.add(Bottone_Progetti_Terminati);
	}

}
