	package GUI;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import Codice.Progetto;
	import Controller.Controller;
	import javax.swing.JLabel;
	import javax.swing.JButton;
	import javax.swing.JCheckBox;
	import javax.swing.JSpinner;
	import javax.swing.SpinnerNumberModel;
	import java.awt.event.ActionListener;
	import java.awt.event.ItemEvent;
	import java.awt.event.ItemListener;
	import java.awt.event.ActionEvent;


	public class TerminazioneProgetto extends JFrame {

		private JPanel contentPane;
		Controller theController;

		public TerminazioneProgetto(Controller c, Progetto progetto) {
			setTitle("Terminazione Progetto");
			theController=c;
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 613, 306);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			JLabel Etichetta_Titolo_Progetto = new JLabel("Sei sicuro di voler terminare il progetto "+progetto.getTitolo()+ "?");
			Etichetta_Titolo_Progetto.setBounds(57, 11, 544, 24);
			contentPane.add(Etichetta_Titolo_Progetto);
			
			JLabel Etichetta_Testo = new JLabel("Inserisci la valutazione che vuoi dare al progetto");
			Etichetta_Testo.setBounds(57, 90, 307, 14);
			contentPane.add(Etichetta_Testo);
			
			JSpinner Spinner_Valutazione = new JSpinner();
			Spinner_Valutazione.setModel(new SpinnerNumberModel(0, 0, 10, 1));
			Spinner_Valutazione.setBounds(213, 140, 57, 20);
			contentPane.add(Spinner_Valutazione);
			
			JLabel Etichetta_Valutazione = new JLabel("Valutazione");
			Etichetta_Valutazione.setBounds(57, 143, 86, 14);
			contentPane.add(Etichetta_Valutazione);
			
			JButton Bottone_Conferma = new JButton("Termina Progetto");
			Bottone_Conferma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theController.Termina_Progetto(progetto,(Integer) Spinner_Valutazione.getValue());
				}
			});
			Bottone_Conferma.setBounds(398, 218, 180, 23);
			Bottone_Conferma.setEnabled(false);
			contentPane.add(Bottone_Conferma);

			JCheckBox chckbx_Conferma_Terminazione = new JCheckBox("Conferma Terminazione");
			chckbx_Conferma_Terminazione.setBounds(57, 42, 194, 23);
			contentPane.add(chckbx_Conferma_Terminazione);
			chckbx_Conferma_Terminazione.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	               if(e.getStateChange() == ItemEvent.SELECTED) {
	            	   Bottone_Conferma.setEnabled(true);
	               }
	               else {
	            	   Bottone_Conferma.setEnabled(false);
	               }
	            }
	        });
			
			JButton Bottone_Annulla = new JButton("Annulla Terminazione");
			Bottone_Annulla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theController.Vista_Progetti_Attivi();
				}
			});
			Bottone_Annulla.setBounds(57, 218, 158, 23);
			contentPane.add(Bottone_Annulla);
			
		}
	}
