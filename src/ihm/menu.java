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
import java.util.ArrayList;

import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.time.format.DateTimeFormatter;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {
	static List listComp = new List();
	static List listCompInsc = new List();
	static List listCompDesinsc = new List();
	static ArrayList<Competition> Listecomp = new ArrayList<Competition>();
	static ArrayList<Candidat> Listecand = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listeeq = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listepers = new ArrayList<Candidat>();
	
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
	private JTable tabCompListeComp;
	private JTextField tFCompModCompNom;
	private JTextField tFCompModCompDate;
	private JTextField tFCompModCompEq;
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
		menuComp(Conteneur);
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
				menuReset();
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
				menuReset();
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
				menuReset();
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

		menuReset();
	}

	public void menuComp(JTabbedPane tabbedPane)
	{
		// Onglet des Compétitions
		
		JPanel panComp = new JPanel();
		tabbedPane.addTab("Comp\u00E9tition", null, panComp, null);
		panComp.setLayout(null);
		
		JTabbedPane panCompIntérieur = new JTabbedPane(JTabbedPane.TOP);
		panCompIntérieur.setBounds(234, 11, 224, 401);
		panComp.add(panCompIntérieur);
		
		// Liste des candidats inscrits
		
		JPanel panCompListeCand = new JPanel();
		panCompIntérieur.addTab("Inscrits", null, panCompListeCand, null);
		panCompListeCand.setLayout(null);
		
		tabCompListeComp = new JTable();
		tabCompListeComp.setBounds(10, 10, 199, 336);
		tabCompListeComp.setEnabled(false);
		panCompListeCand.add(tabCompListeComp);
		
		// Inscrire un candidat
		
		JPanel panCompInscCand = new JPanel();
		panCompIntérieur.addTab("Inscrire", null, panCompInscCand, null);
		panCompInscCand.setLayout(null);
		
		listCompInsc.setBounds(10, 10, 199, 310);
		panCompInscCand.add(listCompInsc);
		
		JButton btnCompInscCompInsc = new JButton("Inscrire");
		btnCompInscCompInsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Candidat> Uneliste = new ArrayList<Candidat>();
				Uneliste.addAll(co.getNonInscrits(Listecomp.get(listComp.getSelectedIndex())));
				co.inscComp(Uneliste.get(listCompInsc.getSelectedIndex()), Listecomp.get(listComp.getSelectedIndex()));
				menuReset();
			}
		});
		btnCompInscCompInsc.setBounds(10, 323, 199, 23);
		panCompInscCand.add(btnCompInscCompInsc);
		
		// Désinscrire un candidat
		
		JPanel panCompDésinscCand = new JPanel();
		panCompIntérieur.addTab("D\u00E9sinscrire", null, panCompDésinscCand, null);
		panCompDésinscCand.setLayout(null);
		
		JButton btnCompDesinsc = new JButton("D\u00E9sinscrire");
		btnCompDesinsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Candidat> Uneliste = new ArrayList<Candidat>();
				Uneliste.addAll(co.getlisteCandidat(Listecomp.get(listComp.getSelectedIndex())));
				co.desinscComp(Listecomp.get(listComp.getSelectedIndex()), Uneliste.get(listCompDesinsc.getSelectedIndex()));
				menuReset();
			}
		});
		btnCompDesinsc.setBounds(10, 323, 199, 23);
		panCompDésinscCand.add(btnCompDesinsc);
		
		listCompDesinsc.setBounds(10, 10, 199, 307);
		panCompDésinscCand.add(listCompDesinsc);
		
		// Modifier une compétition
		
		JPanel panCompModCamp = new JPanel();
		panCompIntérieur.addTab("Modifier", null, panCompModCamp, null);
		panCompModCamp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 11, 87, 14);
		panCompModCamp.add(lblNewLabel);
		
		tFCompModCompNom = new JTextField();
		tFCompModCompNom.setBounds(107, 8, 102, 20);
		panCompModCamp.add(tFCompModCompNom);
		tFCompModCompNom.setColumns(10);
		
		JLabel lblDateDeCloture = new JLabel("Date de Cloture");
		lblDateDeCloture.setBounds(10, 36, 87, 14);
		panCompModCamp.add(lblDateDeCloture);
		
		tFCompModCompDate = new JTextField();
		tFCompModCompDate.setColumns(10);
		tFCompModCompDate.setBounds(107, 33, 102, 20);
		panCompModCamp.add(tFCompModCompDate);
		
		JLabel lblEnquipe = new JLabel("En \u00E9quipe");
		lblEnquipe.setBounds(10, 61, 87, 14);
		panCompModCamp.add(lblEnquipe);
		
		tFCompModCompEq = new JTextField();
		tFCompModCompEq.setColumns(10);
		tFCompModCompEq.setBounds(107, 58, 102, 20);
		panCompModCamp.add(tFCompModCompEq);
		
		JButton btnCompModCompValider = new JButton("Valider");
		btnCompModCompValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean boo = false;
				String dated = tFCompModCompDate.getText();
				LocalDate date = LocalDate.parse(dated, formatter);
				if(tFCompModCompEq.getText().equalsIgnoreCase("1"))
					boo = true;
				Competition Unecomp = Listecomp.get(listComp.getSelectedIndex());
				Unecomp.setNom(tFCompModCompNom.getText());
				Unecomp.setDateCloture(date);
				Unecomp.setEnEquipe(boo);
				co.modComp(Unecomp);
			}
		});
		btnCompModCompValider.setBounds(10, 86, 199, 23);
		panCompModCamp.add(btnCompModCompValider);
		
		// Supprimer une compétition
		
		JPanel panCompSuppComp = new JPanel();
		panCompIntérieur.addTab("Supprimer", null, panCompSuppComp, null);
		panCompSuppComp.setLayout(null);
		
		JButton btnCompSupp = new JButton("Supprimer");
		btnCompSupp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				co.supprComp(Listecomp.get(listComp.getSelectedIndex()));
				
				listComp.removeAll();
				
				for(Competition c : Inscriptions.getInscriptions().getCompetitions())
				{
					listComp.add(c.getNom());
				}
			}
		});
		btnCompSupp.setBounds(10, 11, 199, 23);
		panCompSuppComp.add(btnCompSupp);
		
		// Update de la liste
		listComp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuCompUpdateListe();
				menuCompUpdateInsc();
				menuCompUpdateDesinsc();
				menuCompUpdateMod();
			}

			private void menuCompUpdateMod() {
				String Eq = "0";
				Competition choix = Listecomp.get(listComp.getSelectedIndex());
				tFCompModCompNom.setText(choix.getNom());
				tFCompModCompDate.setText(choix.getDateCloture().toString());
				if(choix.estEnEquipe())
					Eq = "1";
				tFCompModCompEq.setText(Eq);
			}

			private void menuCompUpdateDesinsc() {
				listCompDesinsc.removeAll();
				ArrayList<Candidat> Uneliste = new ArrayList<Candidat>();
				Uneliste.addAll(co.getlisteCandidat((Listecomp.get(listComp.getSelectedIndex()))));

				for(Candidat c : Uneliste)
				{
					if(c.getSub()==Listecomp.get(listComp.getSelectedIndex()).estEnEquipe())
					{
						if(c.getSub())
							listCompDesinsc.add(c.getNom());
						else
							listCompDesinsc.add(c.getNom()+" "+c.getPrenom());
					}
							
				}
			}

			private void menuCompUpdateInsc() {
				
				listCompInsc.removeAll();
				ArrayList<Candidat> Uneliste = new ArrayList<Candidat>();
				Uneliste.addAll(co.getNonInscrits(Listecomp.get(listComp.getSelectedIndex())));
				
				for(Candidat c : Uneliste)
				{
					if(c.getSub()==Listecomp.get(listComp.getSelectedIndex()).estEnEquipe())
					{
						if(c.getSub())
							listCompInsc.add(c.getNom());
						else
							listCompInsc.add(c.getNom()+" "+c.getPrenom());
					}
							
				}
			}

			private void menuCompUpdateListe() {
				DefaultTableModel modelTabCompListeComp = new DefaultTableModel();
				tabCompListeComp.setModel(modelTabCompListeComp);
				modelTabCompListeComp.setRowCount(0);
				modelTabCompListeComp.addColumn(new Object[]{"Nom","Date de cloture","En équipe"});
				
				modelTabCompListeComp.addRow(new Object[]{"Nom","Date de cloture","En équipe"});
				
				Listecomp.addAll(Inscriptions.getInscriptions().getCompetitions());
				
				for(Candidat c : co.getlisteCandidat(Listecomp.get(listComp.getSelectedIndex())))
				{
					modelTabCompListeComp.addRow(new Object[]{c.getNom()});
				}
			}
		});
		listComp.setBounds(10, 11, 218, 401);
		panComp.add(listComp);
		
		menuCompReset(listComp);
	}
	
	public void menuReset()
	{
		menuInscReset(tabInscAffComp,tabInscAffCand,tabInscAffEq);
		menuCompReset(listComp);
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

	public void menuCompReset(List list)
	{
		list.removeAll();
		
		for(Competition c : Inscriptions.getInscriptions().getCompetitions())
		{
			list.add(c.getNom());
		}
		
		listCompInsc.removeAll();
		
		if(listComp.getSelectedIndex()>=0)
			for(Candidat c : co.getNonInscrits(Listecomp.get(listComp.getSelectedIndex())))
			{
				if(c.getSub()==Listecomp.get(listComp.getSelectedIndex()).estEnEquipe())
				{
					if(c.getSub())
						listCompInsc.add(c.getNom());
					else
						listCompInsc.add(c.getNom()+" "+c.getPrenom());
				}
			}
		
		listCompDesinsc.removeAll();
		
		if(listComp.getSelectedIndex()>=0)
			for(Candidat c : co.getNonInscrits(Listecomp.get(listComp.getSelectedIndex())))
			{
				if(c.getSub()==Listecomp.get(listComp.getSelectedIndex()).estEnEquipe())
				{
					if(c.getSub())
						listCompDesinsc.add(c.getNom());
					else
						listCompDesinsc.add(c.getNom()+" "+c.getPrenom());
				}
			}
	}
}
