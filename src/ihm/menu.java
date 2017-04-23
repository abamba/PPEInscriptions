package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import menus.MenuIndex;
import persistance.Connect;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;

import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.time.format.DateTimeFormatter;

public class menu extends JFrame {

	private JPanel contentPane;
	private JTable tabInscAffComp;
	private JTable tabInscAffCand;
	private JTable tabInscAffEq;
	private JTextField tFInscAddCompAnnee;
	private JTextField tFInscAddCompMois;
	private JTextField tFInscAddCompJour;
	private Connect co = Inscriptions.getInscriptions().getConnect();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
	private JTextField tFInscAddCandNom;
	private JTextField tFInscAddCandPrenom;
	private JTextField tFInscAddCandMail;
	private JTextField tFInscAddEqNom;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		MenuIndex.Index();
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTabbedPane Conteneur = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(Conteneur);
		
		menuInsc(Conteneur);
	}

	public void menuInsc(JTabbedPane tabbedPane)
	{
		
		// Onglet des inscriptions
		
		JPanel panInsc = new JPanel();
		tabbedPane.addTab("Inscription", null, panInsc, null);
		panInsc.setLayout(null);
		
		JTabbedPane panInscIntérieur = new JTabbedPane(JTabbedPane.TOP);
		panInscIntérieur.setBounds(10, 11, 449, 401);
		panInsc.add(panInscIntérieur);
		
		// Créer une compétition
		
		JPanel panInscAddComp = new JPanel();
		panInscIntérieur.addTab("Cr\u00E9er Comp\u00E9tition", null, panInscAddComp, null);
		panInscAddComp.setLayout(null);
		
		JFormattedTextField FtfInscAddCompNomComp = new JFormattedTextField();
		FtfInscAddCompNomComp.setBounds(228, 11, 206, 20);
		panInscAddComp.add(FtfInscAddCompNomComp);
		
		JLabel LblInscAddCompNomComp = new JLabel("Nom de la Comp\u00E9tition");
		LblInscAddCompNomComp.setBounds(10, 14, 206, 14);
		panInscAddComp.add(LblInscAddCompNomComp);
		
		JLabel LblInscAddCompDateCloture = new JLabel("Date de cloture (aaaa-mm-dd)");
		LblInscAddCompDateCloture.setBounds(10, 39, 206, 14);
		panInscAddComp.add(LblInscAddCompDateCloture);
		
		JLabel LblInscAddCompEnEquipe = new JLabel("En \u00E9quipe");
		LblInscAddCompEnEquipe.setBounds(10, 64, 206, 14);
		panInscAddComp.add(LblInscAddCompEnEquipe);
		
		tFInscAddCompAnnee = new JTextField();
		tFInscAddCompAnnee.setBounds(228, 36, 88, 20);
		panInscAddComp.add(tFInscAddCompAnnee);
		tFInscAddCompAnnee.setColumns(4);
		
		tFInscAddCompMois = new JTextField();
		tFInscAddCompMois.setColumns(2);
		tFInscAddCompMois.setBounds(326, 36, 49, 20);
		panInscAddComp.add(tFInscAddCompMois);
		
		tFInscAddCompJour = new JTextField();
		tFInscAddCompJour.setColumns(2);
		tFInscAddCompJour.setBounds(385, 36, 49, 20);
		panInscAddComp.add(tFInscAddCompJour);
		
		JToggleButton tglbtnInscAddCompEnEq = new JToggleButton("Non");
		tglbtnInscAddCompEnEq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tglbtnInscAddCompEnEq.isSelected())
					tglbtnInscAddCompEnEq.setText("Oui");
				else
					tglbtnInscAddCompEnEq.setText("Non");
			}
		});
		tglbtnInscAddCompEnEq.setBounds(228, 60, 206, 20);
		panInscAddComp.add(tglbtnInscAddCompEnEq);
		
		JButton btnInscAddCompCréer = new JButton("Cr\u00E9er");
		btnInscAddCompCréer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String dated = tFInscAddCompAnnee.getText()+"-"+tFInscAddCompMois.getText()+"-"+tFInscAddCompJour.getText();
				LocalDate date = LocalDate.parse(dated, formatter);
				Competition comp = new Competition(Inscriptions.getInscriptions(),FtfInscAddCompNomComp.getText(),date,tglbtnInscAddCompEnEq.isSelected());
				co.createComp(comp);
				menuInscReset(tabInscAffComp,tabInscAffCand,tabInscAffEq);
			}
		});

		btnInscAddCompCréer.setBounds(172, 86, 100, 23);
		panInscAddComp.add(btnInscAddCompCréer);
		
		// Créer un candidat
		
		JPanel panInscAddCand = new JPanel();
		panInscIntérieur.addTab("Cr\u00E9er Candidat", null, panInscAddCand, null);
		panInscAddCand.setLayout(null);
		
		JLabel lblNomDuCandidat = new JLabel("Nom");
		lblNomDuCandidat.setBounds(10, 14, 206, 14);
		panInscAddCand.add(lblNomDuCandidat);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(10, 39, 206, 14);
		panInscAddCand.add(lblPrnom);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 64, 206, 14);
		panInscAddCand.add(lblMail);
		
		tFInscAddCandNom = new JTextField();
		tFInscAddCandNom.setBounds(228, 11, 206, 20);
		panInscAddCand.add(tFInscAddCandNom);
		tFInscAddCandNom.setColumns(10);
		
		tFInscAddCandPrenom = new JTextField();
		tFInscAddCandPrenom.setColumns(10);
		tFInscAddCandPrenom.setBounds(228, 36, 206, 20);
		panInscAddCand.add(tFInscAddCandPrenom);
		
		tFInscAddCandMail = new JTextField();
		tFInscAddCandMail.setColumns(10);
		tFInscAddCandMail.setBounds(228, 61, 206, 20);
		panInscAddCand.add(tFInscAddCandMail);
		
		JButton btnInscAddCandCréer = new JButton("Cr\u00E9er");
		btnInscAddCandCréer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat cand = new Candidat(Inscriptions.getInscriptions(),tFInscAddCandNom.getText());
				cand.setPrenom(tFInscAddCandPrenom.getText());
				cand.setMail(tFInscAddCandMail.getText());
				cand.setSub(false);
				co.createPers(cand);
				menuInscReset(tabInscAffComp, tabInscAffCand, tabInscAffEq);
			}
		});
		btnInscAddCandCréer.setBounds(172, 86, 100, 23);
		panInscAddCand.add(btnInscAddCandCréer);
		
		
		
		// Créer une équipe
		
		JPanel panInscAddEq = new JPanel();
		panInscIntérieur.addTab("Cr\u00E9er Equipe", null, panInscAddEq, null);
		panInscAddEq.setLayout(null);
		
		JLabel label = new JLabel("Nom");
		label.setBounds(10, 10, 206, 14);
		panInscAddEq.add(label);
		
		tFInscAddEqNom = new JTextField();
		tFInscAddEqNom.setColumns(10);
		tFInscAddEqNom.setBounds(228, 11, 206, 20);
		panInscAddEq.add(tFInscAddEqNom);
		
		JButton btnInscAddEqCréer = new JButton("Cr\u00E9er");
		btnInscAddEqCréer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat cand = new Candidat(Inscriptions.getInscriptions(),tFInscAddEqNom.getText());
				cand.setSub(true);
				co.createPers(cand);
				menuInscReset(tabInscAffComp, tabInscAffCand, tabInscAffEq);
			}
		});
		btnInscAddEqCréer.setBounds(172, 86, 100, 23);
		panInscAddEq.add(btnInscAddEqCréer);
		
		// Afficher les Compétitions
		
		JPanel panInscAffComp = new JPanel();
		panInscIntérieur.addTab("Afficher Comp\u00E9titions", null, panInscAffComp, null);
		panInscAffComp.setLayout(null);
		
		tabInscAffComp = new JTable();
		tabInscAffComp.setEnabled(false);
		tabInscAffComp.setRowSelectionAllowed(false);
		tabInscAffComp.setBounds(10, 10, 424, 336);
		panInscAffComp.add(tabInscAffComp);

		// Afficher les Candidats
		
		JPanel panInscAffCand = new JPanel();
		panInscIntérieur.addTab("Afficher Candidats", null, panInscAffCand, null);
		panInscAffCand.setLayout(null);
		
		tabInscAffCand = new JTable();
		tabInscAffCand.setRowSelectionAllowed(false);
		tabInscAffCand.setEnabled(false);
		tabInscAffCand.setBounds(10, 10, 424, 336);
		panInscAffCand.add(tabInscAffCand);
		
		// Afficher les équipe
		
		JPanel panInscAffEq = new JPanel();
		panInscIntérieur.addTab("Afficher Equipes", null, panInscAffEq, null);
		panInscAffEq.setLayout(null);
		
		tabInscAffEq = new JTable();
		tabInscAffEq.setRowSelectionAllowed(false);
		tabInscAffEq.setEnabled(false);
		tabInscAffEq.setBounds(10, 10, 424, 336);
		panInscAffEq.add(tabInscAffEq);

		menuInscReset(tabInscAffComp, tabInscAffCand, tabInscAffEq);
	}
	
	public void menuInscReset(JTable tabInscAffComp, JTable tabInscAffCand, JTable tabInscAffEq)
	{
		// Reset l'affichage des compétitions
		DefaultTableModel modelTabInscAffComp = new DefaultTableModel();
		tabInscAffComp.setModel(modelTabInscAffComp);
		modelTabInscAffComp.setRowCount(0);
		modelTabInscAffComp.addColumn(new Object[]{"Nom"});
		modelTabInscAffComp.addColumn(new Object[]{"Date de cloture"});
		modelTabInscAffComp.addColumn(new Object[]{"Est en équipe"});
		
		modelTabInscAffComp.addRow(new Object[]{"Nom","Date de cloture","Est en équipe"});
		
		for(Competition c : Inscriptions.getInscriptions().getCompetitions())
		{
			modelTabInscAffComp.addRow(new Object[]{c.getNom(),c.getDateCloture(),c.estEnEquipe()});
		}
		
		// Reset l'affichage des candidats
		DefaultTableModel modelTabInscAffCand = new DefaultTableModel();
		tabInscAffCand.setModel(modelTabInscAffCand);
		modelTabInscAffCand.setRowCount(0);
		modelTabInscAffCand.addColumn(new Object[]{"Nom"});
		modelTabInscAffCand.addColumn(new Object[]{"Prénom"});
		modelTabInscAffCand.addColumn(new Object[]{"Mail"});
		
		modelTabInscAffCand.addRow(new Object[]{"Nom","Prénom","Mail"});
		
		for(Candidat c : Inscriptions.getInscriptions().getCandidats())
		{
			if(!c.getSub())
				modelTabInscAffCand.addRow(new Object[]{c.getNom(),c.getPrenom(),c.getMail()});
		}
		
		// Reset l'affichage des équipes
		DefaultTableModel modelTabInscAffEq = new DefaultTableModel();
		tabInscAffEq.setModel(modelTabInscAffEq);
		modelTabInscAffEq.setRowCount(0);
		modelTabInscAffEq.addColumn(new Object[]{"Nom"});
		
		modelTabInscAffEq.addRow(new Object[]{"Nom"});
		
		for(Candidat c : Inscriptions.getInscriptions().getCandidats())
		{
			if(c.getSub())
				modelTabInscAffEq.addRow(new Object[]{c.getNom()});
		}
	}
}
