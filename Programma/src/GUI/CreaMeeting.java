package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codice.Progetto;
import Controller.Controller;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreaMeeting extends JFrame {

	private JPanel contentPane;
	Controller theController;
	private JTextField Campo_Inserimento;
	JFrame frame;
	private boolean telematico=false;

	public CreaMeeting(Controller c, Progetto progetto) {
		theController=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JSpinner spinner_anno = new JSpinner();
		spinner_anno.setModel(new SpinnerNumberModel(2021, 2021, 3000, 1));
		spinner_anno.setBounds(58, 343, 63, 20);
		contentPane.add(spinner_anno);
		
		JSpinner spinner_giorno = new JSpinner();
		spinner_giorno.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_giorno.setBounds(263, 343, 63, 20);
		contentPane.add(spinner_giorno);
		
		JSpinner spinner_ora = new JSpinner();
		spinner_ora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_ora.setBounds(368, 343, 46, 20);
		contentPane.add(spinner_ora);
		
		JSpinner spinner_minuto = new JSpinner();
		spinner_minuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_minuto.setBounds(461, 343, 46, 20);
		contentPane.add(spinner_minuto);
		
		JLabel Etichetta_Anno = new JLabel("Anno");
		Etichetta_Anno.setBounds(91, 318, 46, 14);
		contentPane.add(Etichetta_Anno);
		
		JLabel Etichetta_Mese = new JLabel("Mese");
		Etichetta_Mese.setBounds(193, 318, 46, 14);
		contentPane.add(Etichetta_Mese);
		
		JLabel Etichetta_Giorno = new JLabel("Giorno");
		Etichetta_Giorno.setBounds(280, 318, 46, 14);
		contentPane.add(Etichetta_Giorno);
		
		JLabel Etichetta_Ora = new JLabel("Ora");
		Etichetta_Ora.setBounds(384, 318, 46, 14);
		contentPane.add(Etichetta_Ora);
		
		JLabel Etichetta_Minuto = new JLabel("Minuto");
		Etichetta_Minuto.setBounds(477, 318, 46, 14);
		contentPane.add(Etichetta_Minuto);
		
		JComboBox<String> Box_mese = new JComboBox<>();
		Box_mese.setModel(new DefaultComboBoxModel<String>(new String[] {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"}));
		Box_mese.setBounds(131, 342, 108, 22);
		contentPane.add(Box_mese);
		
		JLabel Etichetta_Codice_Stanza = new JLabel("Codice_Stanza");
		Etichetta_Codice_Stanza.setBounds(248, 237, 101, 14);
		contentPane.add(Etichetta_Codice_Stanza);
		Etichetta_Codice_Stanza.setVisible(false);
		
		JLabel Etichetta_Sala_Riunioni = new JLabel("Sala_Riunioni");
		Etichetta_Sala_Riunioni.setBounds(248, 237, 101, 14);
		contentPane.add(Etichetta_Sala_Riunioni);
		Etichetta_Sala_Riunioni.setVisible(false);
		
		JButton Bottone_Conferma = new JButton("Organizza Meeting");
		Bottone_Conferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mese=0;
				switch((String) Box_mese.getSelectedItem()) {
					case "Gennaio": mese=0;
					break;
					case "Febbraio": mese=1;
					break;
					case "Marzo": mese=2;
					break;
					case "Aprile": mese=3;
					break;
					case "Maggio": mese=4;
					break;
					case "Giugno": mese=5;
					break;
					case "Luglio": mese=6;
					break;
					case "Agosto": mese=7;
					break;
					case "Settembre": mese=8;
					break;
					case "Ottobre": mese=9;
					break;
					case "Novembre": mese=10;
					break;
					case "Dicembre": mese=11;
					break;
				}
				if(mese==1&&(Integer)spinner_giorno.getValue()>28) {
					JOptionPane.showMessageDialog(frame, "Febbraio non può avere più di 28 giorni!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				else if((mese==10||mese==8||mese==3||mese==5)&&(Integer)spinner_giorno.getValue()>30) {
					JOptionPane.showMessageDialog(frame, "Il mese non può avere 31 giorni!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				else {				
					if(!Campo_Inserimento.getText().isEmpty()){
						if(telematico) {
							theController.Crea_Meeting_Telematico(progetto, Campo_Inserimento.getText(), (Integer) spinner_anno.getValue(),
								mese,(Integer)spinner_giorno.getValue(), (Integer)spinner_ora.getValue(), (Integer)spinner_minuto.getValue());
						}
						else {
							theController.Crea_Meeting_Fisico(progetto, Campo_Inserimento.getText(), (Integer) spinner_anno.getValue(),
								mese,(Integer)spinner_giorno.getValue(), (Integer)spinner_ora.getValue(), (Integer)spinner_minuto.getValue());
						}
					}
					else JOptionPane.showMessageDialog(frame, "Inserisci qualcosa", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		Bottone_Conferma.setBounds(568, 383, 122, 23);
		contentPane.add(Bottone_Conferma);
		Bottone_Conferma.setEnabled(false);
		
		JLabel Etichetta_temp = new JLabel("Seleziona il tipo di meeting che vuoi creare per il progetto "+progetto.getTitolo());
		Etichetta_temp.setBounds(97, 48, 593, 28);
		contentPane.add(Etichetta_temp);
		
		JCheckBox chckbx_Telematico = new JCheckBox("Meeting Telematico");
		chckbx_Telematico.setBounds(97, 139, 173, 23);
		contentPane.add(chckbx_Telematico);
		
		JCheckBox chckbx_Fisico = new JCheckBox("Meeting Fisico");
		chckbx_Fisico.setBounds(424, 139, 141, 23);
		contentPane.add(chckbx_Fisico);
		
        chckbx_Telematico.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
               if(e.getStateChange() == ItemEvent.SELECTED) {
            	   Bottone_Conferma.setEnabled(true);
            	   chckbx_Fisico.setEnabled(false);
            	   Etichetta_Codice_Stanza.setVisible(true);
            	   telematico=true;
               }
               else {
            	   Bottone_Conferma.setEnabled(false);
            	   chckbx_Fisico.setEnabled(true);
            	   Etichetta_Codice_Stanza.setVisible(false);
               }
            }
        });
        
        chckbx_Fisico.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
               if(e.getStateChange() == ItemEvent.SELECTED) {
            	   Bottone_Conferma.setEnabled(true);
            	   chckbx_Telematico.setEnabled(false);
            	   Etichetta_Sala_Riunioni.setVisible(true);
            	   telematico=false;
               }
               else {
            	   Bottone_Conferma.setEnabled(false);
            	   chckbx_Telematico.setEnabled(true);
            	   Etichetta_Sala_Riunioni.setVisible(false);
               }
            }
        });
		
		Campo_Inserimento = new JTextField();
		Campo_Inserimento.setBounds(248, 262, 122, 20);
		contentPane.add(Campo_Inserimento);
		Campo_Inserimento.setColumns(10);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theController.Visualizza_Dettagli_Progetto(progetto);
				setVisible(false);
			}
		});
		Bottone_Indietro.setBounds(32, 383, 89, 23);
		contentPane.add(Bottone_Indietro);


		

	}
}
