package ihm;

import java.awt.BorderLayout;
import java.awt.Button;
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
import javax.swing.JList;
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
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.time.format.DateTimeFormatter;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class menu extends JFrame {
	static Inscriptions i = Inscriptions.getInscriptions();
	static Competition choix_comp;
	static List listComp = new List();
	static List listCompInsc = new List();
	static List listCompDesinsc = new List();
	static List listCand = new List();
	static List listCandInscA = new List();
	static List listCandDesinscDe = new List();
	static List listCandAppartEq = new List();
	static ArrayList<Competition> Listecomp = new ArrayList<Competition>();
	static ArrayList<Candidat> Listecand = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listeeq = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listepers = new ArrayList<Candidat>();
	
	static DefaultTableModel modelTabCompListeComp = new DefaultTableModel();
	
	private JTable tableCandEstInsc;
	private JTextField tFModCandNom;
	private JTextField tFModCandPrenom;
	private JTextField tFModCandMail;
	
	private JPanel contentPane;
	private JTable tabInscAffComp;
	private JTable tabInscAffCand;
	private JTable tabInscAffEq;
	private JTextField tFInscAddCompNom;
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
	private JTable tabCandAppartEq;
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
		menuCand(Conteneur);
	}

	public void menuInsc(JTabbedPane tabbedPane)
	{
		
		// Onglet des inscriptions

		JPanel panInsc = new JPanel();
		panInsc.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuInscReset();
			}
		});
		tabbedPane.addTab("Affichage", null, panInsc, null);
		panInsc.setLayout(null);
		JTabbedPane panInt�rieur = new JTabbedPane(JTabbedPane.TOP);
		panInt�rieur.setBounds(10, 11, 449, 401);
		panInsc.add(panInt�rieur);
		
		// Cr�er une comp�tition
		MenuCreateComp(panInt�rieur);
		// Cr�er un candidat
		MenuCreateCand(panInt�rieur);
		// Cr�er une �quipe
		MenuCreateEq(panInt�rieur);
		// Afficher les Comp�titions
		MenuAffComp(panInt�rieur);
		// Afficher les Candidats
		MenuAffCand(panInt�rieur);
		// Afficher les �quipe
		MenuAffEq(panInt�rieur);
	}

	public void menuInscReset() {

		// Reset l'affichage des comp�titions
		menuResetAffComp();
		
		// Reset l'affichage des candidats
		menuResetAffCand();
		
		// Reset l'affichage des �quipes
		menuResetAffEq();

	}

	private void menuResetAffEq() {
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

	private void menuResetAffCand() {
		DefaultTableModel modelTabInscAffCand = new DefaultTableModel();
		tabInscAffCand.setModel(modelTabInscAffCand);
		modelTabInscAffCand.setRowCount(0);
		modelTabInscAffCand.addColumn(new Object[]{"Nom"});
		modelTabInscAffCand.addColumn(new Object[]{"Pr�nom"});
		modelTabInscAffCand.addColumn(new Object[]{"Mail"});
		
		modelTabInscAffCand.addRow(new Object[]{"Nom","Pr�nom","Mail"});
		
		for(Candidat c : Inscriptions.getInscriptions().getCandidats())
		{
			if(!c.getSub())
				modelTabInscAffCand.addRow(new Object[]{c.getNom(),c.getPrenom(),c.getMail()});
		}
	}

	private void menuResetAffComp() {
		DefaultTableModel modelTabInscAffComp = new DefaultTableModel();
		tabInscAffComp.setModel(modelTabInscAffComp);
		modelTabInscAffComp.setRowCount(0);
		modelTabInscAffComp.addColumn(new Object[]{"Nom"});
		modelTabInscAffComp.addColumn(new Object[]{"Date de cloture"});
		modelTabInscAffComp.addColumn(new Object[]{"Est en �quipe"});
		
		modelTabInscAffComp.addRow(new Object[]{"Nom","Date de cloture","Est en �quipe"});
		
		String enEquipe;
		
		for(Competition c : Inscriptions.getInscriptions().getCompetitions())
		{
			enEquipe = "Solo";
			if(c.estEnEquipe())
				enEquipe = "Equipe";
			modelTabInscAffComp.addRow(new Object[]{c.getNom(),c.getDateCloture(),enEquipe});
		}
	}

	public void menuComp(JTabbedPane tabbedPane)
	{
		// Onglet des Comp�titions
		
		JPanel panComp = new JPanel();
		panComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuResetComp();
			}
		});
		tabbedPane.addTab("Comp\u00E9tition", null, panComp, null);
		panComp.setLayout(null);
		
		JTabbedPane panInt�rieur = new JTabbedPane(JTabbedPane.TOP);
		panInt�rieur.setBounds(234, 11, 224, 401);
		panComp.add(panInt�rieur);
		
		// Liste des candidats inscrits
		MenuListeCandInscrits(panInt�rieur);
		// Inscrire un candidat
		MenuInscrireCandidatComp(panInt�rieur);
		// D�sinscrire un candidat
		MenuDesinscCandidatComp(panInt�rieur);
		// Modifier une comp�tition
		MenuModComp(panInt�rieur);
		// Supprimer une comp�tition
		MenuSuppComp(panInt�rieur);

		listComp.setBounds(10, 11, 219, 403);
		panComp.add(listComp);
	}

	protected void menuResetComp() {
		menuResetListeDesCompetitions();
		menuResetInscrireDansComp();
		menuResetDesinscrireDeComp();
		menuResetInscritsDuneComp();
	}

	private void menuResetListeDesCompetitions() {
		Listecomp.clear();
		Listecomp.addAll(i.getCompetitions());
		
		listComp.removeAll();
		
		for(Competition c : Listecomp)
		{
			listComp.add(c.getNom());
		}
	}

	private void menuResetInscritsDuneComp() {
		if (listComp.getSelectedIndex()>-1)
		{
			tabCompListeComp.removeAll();
			
			tabCompListeComp.setModel(modelTabCompListeComp);
			modelTabCompListeComp.setRowCount(0);
			modelTabCompListeComp.addColumn(new Object[]{"Nom"});
			modelTabCompListeComp.addRow(new Object[]{"Nom"});
			Listecomp.addAll(Inscriptions.getInscriptions().getCompetitions());
			choix_comp = Listecomp.get(listComp.getSelectedIndex());
			
			for(Candidat c : choix_comp.getCandidats())
			{
				modelTabCompListeComp.addRow(new Object[]{c.getNom()});
			}
		}
	}

	private void menuResetDesinscrireDeComp() {
		// TODO Auto-generated method stub
		
	}

	private void menuResetInscrireDansComp() {
		// TODO Auto-generated method stub
		
	}
	
	public void menuCand(JTabbedPane tabbedPane)
	{	
		//Onglet Candidat 
		
		JPanel panCand = new JPanel();
		tabbedPane.addTab("Candidat", null, panCand, null);
		panCand.setLayout(null);
		
		JTabbedPane PaneCandInt�rieur = new JTabbedPane(JTabbedPane.TOP);
		PaneCandInt�rieur.setBounds(235, 11, 224, 402);
		panCand.add(PaneCandInt�rieur);
		
		//Liste des inscriptions d'un candidat
		MenuListInscriptions(PaneCandInt�rieur);
		//Inscrire un candidat � une comp�tition
		MenuInscrireCandidat(PaneCandInt�rieur);
		//D�sinscrire un candidat d'une comp�tition
		MenuDesinscCandidat(PaneCandInt�rieur);
		//Modifier un candidat
		MenuModCandidat(PaneCandInt�rieur);
		//Equipes auxquels appartient un candidat
		MenuEquipesDunCandidat(PaneCandInt�rieur);
		//Supprimer un candidat
		MenuSupprCandidatDuneComp(PaneCandInt�rieur);
		
		listCand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(listCand.getSelectedIndex()>=0)
				{
					menuCandUpdateEstInsc();
					menuCandUpdateDesinsc();
					menuCandUpdateModInsc();
					menuCandUpdateComposer();
					menuCandUpdateInscrire();
				}
		
			}

			private void menuCandUpdateInscrire() {
				Candidat choix = Listecand.get(listCand.getSelectedIndex());
				listCandInscA.removeAll();
				for(Competition c : Inscriptions.getInscriptions().getCompetitions())
				{
					if(c.estEnEquipe()==choix.getSub())
						listCandInscA.add(c.getNom());
				}
			}

			private void menuCandUpdateComposer() {
				
				DefaultTableModel ModeltabCandInscA = new DefaultTableModel();
				tabCandAppartEq.setModel(ModeltabCandInscA);
				ModeltabCandInscA.setRowCount(0);
				ModeltabCandInscA.addColumn(new Object[]{"Nom"});

				ModeltabCandInscA.addRow(new Object[]{"Nom"});
		        Listecand.addAll(Inscriptions.getInscriptions().getCandidats()); 

				Candidat choix = Listecand.get(listCand.getSelectedIndex());
				if(choix.getSub())
					for(Candidat c : co.Composition(choix))
					{
						ModeltabCandInscA.addRow(new Object[]{c.getNom()});
					}
				else
					for(Candidat c : co.CompositionEquipe(choix))
					{
						ModeltabCandInscA.addRow(new Object[]{"Equipe "+c.getNom()});
					}
				
				listCandAppartEq.removeAll();
				
				for(Candidat c : Inscriptions.getInscriptions().getCandidats())
				{
					if(c.getSub()!=choix.getSub())
					{
						listCandAppartEq.add(c.getNom());
					}
				}
				
			}

			private void menuCandUpdateModInsc() {
				Candidat choix = Listecand.get(listCand.getSelectedIndex());
		        tFModCandNom.setText(choix.getNom());
		        tFModCandPrenom.setText(choix.getPrenom());
				tFModCandMail.setText(choix.getMail());
			}

			private void menuCandUpdateEstInsc() {
				DefaultTableModel ModelCandEstInsc = new DefaultTableModel();
				tableCandEstInsc.setModel(ModelCandEstInsc);
				ModelCandEstInsc.setRowCount(0);
				ModelCandEstInsc.addColumn(new Object[]{"Nom"});

				ModelCandEstInsc.addRow(new Object[]{"Nom"});
		        Listecand.addAll(Inscriptions.getInscriptions().getCandidats()); 

		        for(Competition c : co.getListeComp(Listecand.get(listCand.getSelectedIndex())))
		        {
		        	ModelCandEstInsc.addRow(new Object[]{c.getNom()});
		        }
			}

			private void menuCandUpdateDesinsc() {
				listCandDesinscDe.removeAll();
				for (Competition c : co.getListeComp(Listecand.get(listCand.getSelectedIndex())))
				{
					listCandDesinscDe.add(c.getNom());
				}
			}
		});
		
		
		//Liste des candidats
		
		listCand.setBounds(10, 11, 219, 403);
		panCand.add(listCand);
		
		menuCandReset(listCand);
	}
	
	private void MenuAffEq(JTabbedPane panInscInt�rieur) {
		JPanel panInscAffEq = new JPanel();
		panInscAffEq.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuResetAffEq();
			}
		});
		panInscInt�rieur.addTab("Afficher Equipes", null, panInscAffEq, null);
		panInscAffEq.setLayout(null);
		
		tabInscAffEq = new JTable();
		tabInscAffEq.setRowSelectionAllowed(false);
		tabInscAffEq.setEnabled(false);
		tabInscAffEq.setBounds(10, 10, 424, 336);
		panInscAffEq.add(tabInscAffEq);
	}

	private void MenuAffCand(JTabbedPane panInscInt�rieur) {
		JPanel panInscAffCand = new JPanel();
		panInscAffCand.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuResetAffCand();
			}
		});
		panInscInt�rieur.addTab("Afficher Candidats", null, panInscAffCand, null);
		panInscAffCand.setLayout(null);
		
		tabInscAffCand = new JTable();
		tabInscAffCand.setRowSelectionAllowed(false);
		tabInscAffCand.setEnabled(false);
		tabInscAffCand.setBounds(10, 10, 424, 336);
		panInscAffCand.add(tabInscAffCand);
	}

	private void MenuAffComp(JTabbedPane panInscInt�rieur) {
		JPanel panInscAffComp = new JPanel();
		panInscAffComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuResetAffComp();
			}
		});
		panInscInt�rieur.addTab("Afficher Comp\u00E9titions", null, panInscAffComp, null);
		panInscAffComp.setLayout(null);
		
		tabInscAffComp = new JTable();
		tabInscAffComp.setEnabled(false);
		tabInscAffComp.setRowSelectionAllowed(false);
		tabInscAffComp.setBounds(10, 10, 424, 336);
		panInscAffComp.add(tabInscAffComp);
	}

	private void MenuCreateEq(JTabbedPane panInscInt�rieur) {
		JPanel panInscAddEq = new JPanel();
		panInscInt�rieur.addTab("Cr\u00E9er Equipe", null, panInscAddEq, null);
		panInscAddEq.setLayout(null);
		
		JLabel label = new JLabel("Nom");
		label.setBounds(10, 10, 206, 14);
		panInscAddEq.add(label);
		
		tFInscAddEqNom = new JTextField();
		tFInscAddEqNom.setColumns(10);
		tFInscAddEqNom.setBounds(228, 11, 206, 20);
		panInscAddEq.add(tFInscAddEqNom);
		
		JButton btnInscAddEqCr�er = new JButton("Cr\u00E9er");
		btnInscAddEqCr�er.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat cand = new Candidat(Inscriptions.getInscriptions(),tFInscAddEqNom.getText());
				cand.setSub(true);
				i.createCandidat(cand.getNom(), cand.getPrenom(), cand.getMail(), cand.getSub());
				menuResetAddEq();
			}

			private void menuResetAddEq() {
				tFInscAddEqNom.setText("");
			}
		});
		btnInscAddEqCr�er.setBounds(172, 86, 100, 23);
		panInscAddEq.add(btnInscAddEqCr�er);
	}

	private void MenuCreateCand(JTabbedPane panInscInt�rieur) {
		JPanel panInscAddCand = new JPanel();
		panInscInt�rieur.addTab("Cr\u00E9er Candidat", null, panInscAddCand, null);
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
		
		JButton btnInscAddCandCr�er = new JButton("Cr\u00E9er");
		btnInscAddCandCr�er.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat cand = new Candidat(Inscriptions.getInscriptions(),tFInscAddCandNom.getText());
				cand.setPrenom(tFInscAddCandPrenom.getText());
				cand.setMail(tFInscAddCandMail.getText());
				cand.setSub(false);
				i.createCandidat(cand.getNom(), cand.getPrenom(), cand.getMail(), cand.getSub());
				menuResetAddCand();
			}

			private void menuResetAddCand() {
				tFInscAddCandNom.setText("");
				tFInscAddCandPrenom.setText("");
				tFInscAddCandMail.setText("");
			}
		});
		btnInscAddCandCr�er.setBounds(172, 86, 100, 23);
		panInscAddCand.add(btnInscAddCandCr�er);
	}

	private void MenuCreateComp(JTabbedPane panInscInt�rieur) {
		JPanel panInscAddComp = new JPanel();
		panInscInt�rieur.addTab("Cr\u00E9er Comp\u00E9tition", null, panInscAddComp, null);
		panInscAddComp.setLayout(null);
		
		JTextField tFInscAddCompNom = new JTextField();
		tFInscAddCompNom.setBounds(228, 11, 206, 20);
		panInscAddComp.add(tFInscAddCompNom);
		
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
		
		JButton btnInscAddCompCr�er = new JButton("Cr\u00E9er");
		btnInscAddCompCr�er.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String dated = tFInscAddCompAnnee.getText()+"-"+tFInscAddCompMois.getText()+"-"+tFInscAddCompJour.getText();
				LocalDate date = LocalDate.parse(dated, formatter);
				Competition comp = new Competition(Inscriptions.getInscriptions(),tFInscAddCompNom.getText(),date,tglbtnInscAddCompEnEq.isSelected());
				i.createCompetition(comp.getNom(), comp.getDateCloture(), comp.estEnEquipe());
				menuResetCreateComp();
			}

			private void menuResetCreateComp() {
				tFInscAddCompNom.setText("");
				tFInscAddCompAnnee.setText("");
				tFInscAddCompMois.setText("");
				tFInscAddCompJour.setText("");
			}
		});

		btnInscAddCompCr�er.setBounds(172, 86, 100, 23);
		panInscAddComp.add(btnInscAddCompCr�er);
	}

	private void MenuSuppComp(JTabbedPane panCompInt�rieur) {
		JPanel panCompSuppComp = new JPanel();
		panCompInt�rieur.addTab("Supprimer", null, panCompSuppComp, null);
		panCompSuppComp.setLayout(null);
		
		JButton btnCompSupp = new JButton("Supprimer");
		btnCompSupp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Listecomp.get(listComp.getSelectedIndex()).delete();
				
				listComp.removeAll();
				
				for(Competition c : Inscriptions.getInscriptions().getCompetitions())
				{
					listComp.add(c.getNom());
				}
			}
		});
		btnCompSupp.setBounds(10, 11, 199, 23);
		panCompSuppComp.add(btnCompSupp);
	}

	private void MenuModComp(JTabbedPane panCompInt�rieur) {
		JPanel panCompModCamp = new JPanel();
		panCompInt�rieur.addTab("Modifier", null, panCompModCamp, null);
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
				
				listComp.removeAll();
				Listecomp.clear();
				Listecomp.addAll(co.getComp());
				for(Competition c : Inscriptions.getInscriptions().getCompetitions())
				{
					listComp.add(c.getNom());
				}
			}
		});
		btnCompModCompValider.setBounds(10, 86, 199, 23);
		panCompModCamp.add(btnCompModCompValider);
	}

	private void MenuDesinscCandidatComp(JTabbedPane panCompInt�rieur) {
		JPanel panCompD�sinscCand = new JPanel();
		panCompD�sinscCand.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuResetDesinscrireDeComp();
			}
		});
		panCompInt�rieur.addTab("D\u00E9sinscrire", null, panCompD�sinscCand, null);
		panCompD�sinscCand.setLayout(null);
		
		JButton btnCompDesinsc = new JButton("D\u00E9sinscrire");
		btnCompDesinsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Candidat> Uneliste = new ArrayList<Candidat>();
				Uneliste.addAll(co.getlisteCandidat(Listecomp.get(listComp.getSelectedIndex())));
				co.desinscComp(Listecomp.get(listComp.getSelectedIndex()), Uneliste.get(listCompDesinsc.getSelectedIndex()));
			}
		});
		btnCompDesinsc.setBounds(10, 323, 199, 23);
		panCompD�sinscCand.add(btnCompDesinsc);
		
		listCompDesinsc.setBounds(10, 10, 199, 307);
		panCompD�sinscCand.add(listCompDesinsc);
	}

	private void MenuInscrireCandidatComp(JTabbedPane panCompInt�rieur) {
		JPanel panCompInscCand = new JPanel();
		panCompInscCand.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuResetInscrireDansComp();
			}
		});
		panCompInt�rieur.addTab("Inscrire", null, panCompInscCand, null);
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
				for(Candidat c : Uneliste)
				{
					listCompDesinsc.add(c.getNom());
				}
			}
		});
		btnCompInscCompInsc.setBounds(10, 323, 199, 23);
		panCompInscCand.add(btnCompInscCompInsc);
	}

	private void MenuListeCandInscrits(JTabbedPane panCompInt�rieur) {
		JPanel panCompListeCand = new JPanel();
		panCompListeCand.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				menuResetInscritsDuneComp();
			}
		});
		panCompInt�rieur.addTab("Inscrits", null, panCompListeCand, null);
		panCompListeCand.setLayout(null);
		
		tabCompListeComp = new JTable();
		tabCompListeComp.setBounds(10, 10, 199, 336);
		tabCompListeComp.setEnabled(false);
		panCompListeCand.add(tabCompListeComp);
	}
	

	
	
	private void MenuSupprCandidatDuneComp(JTabbedPane paneCandInt�rieur) {
		JPanel panCandSuppr = new JPanel();
		paneCandInt�rieur.addTab("Supprimer", null, panCandSuppr, null);
		panCandSuppr.setLayout(null);
		
		Button buttonCandSuppr = new Button("Supprimer le candidat");
		buttonCandSuppr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				co.delCandidat(Listecand.get(listCand.getSelectedIndex()));
				menuCandReset(listCand);
			}
		});
		buttonCandSuppr.setBounds(10, 10, 199, 22);
		panCandSuppr.add(buttonCandSuppr);
	}

	private void MenuEquipesDunCandidat(JTabbedPane paneCandInt�rieur) {
		JPanel panCandAppartEq = new JPanel();
		paneCandInt�rieur.addTab("Equipes", null, panCandAppartEq, null);
		panCandAppartEq.setLayout(null);
		
		listCandAppartEq.setBounds(10, 171, 199, 101);
		panCandAppartEq.add(listCandAppartEq);
		
		tabCandAppartEq = new JTable();
		tabCandAppartEq.setBounds(10, 39, 199, 101);
		panCandAppartEq.add(tabCandAppartEq);
		
		JButton btnValiderEquipe = new JButton("Ajouter");
		btnValiderEquipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat choix = Listecand.get(listCand.getSelectedIndex());
				Listeeq.clear();
				for(Candidat c : Inscriptions.getInscriptions().getCandidats())
				{
					if(c.getSub()!=choix.getSub())
					{
						Listeeq.add(c);
					}
				}
				Candidat choix_eq = Listeeq.get(listCandAppartEq.getSelectedIndex());
				//if(choix.getSub())
					//co.Compose(choix_eq,choix);
				//else
					//co.Compose(choix,choix_eq);
			}
		});
		btnValiderEquipe.setBounds(67, 278, 89, 23);
		panCandAppartEq.add(btnValiderEquipe);
		
		JLabel lblMembresEquipes = new JLabel("Membres / Equipes");
		lblMembresEquipes.setBounds(10, 11, 199, 14);
		panCandAppartEq.add(lblMembresEquipes);
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter un Membre / Equipe");
		lblNewLabel_1.setBounds(10, 151, 199, 14);
		panCandAppartEq.add(lblNewLabel_1);
	}

	private void MenuModCandidat(JTabbedPane paneCandInt�rieur) {
		JPanel panCandMod = new JPanel();
		paneCandInt�rieur.addTab("Modifier", null, panCandMod, null);
		panCandMod.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 11, 46, 14);
		panCandMod.add(lblNom);
		
		tFModCandNom = new JTextField();
		tFModCandNom.setBounds(66, 8, 143, 20);
		panCandMod.add(tFModCandNom);
		tFModCandNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(10, 42, 46, 14);
		panCandMod.add(lblPrnom);
		
		tFModCandPrenom = new JTextField();
		tFModCandPrenom.setBounds(66, 39, 143, 20);
		panCandMod.add(tFModCandPrenom);
		tFModCandPrenom.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 73, 46, 14);
		panCandMod.add(lblMail);
		
		tFModCandMail = new JTextField();
		tFModCandMail.setBounds(66, 70, 143, 20);
		panCandMod.add(tFModCandMail);
		tFModCandMail.setColumns(10);
		
		JButton btnModCand = new JButton("Enregistrer");
		btnModCand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat choix = Listecand.get(listCand.getSelectedIndex());
				choix.setNom(tFModCandNom.getText());
				choix.setPrenom(tFModCandPrenom.getText());
				choix.setMail(tFModCandMail.getText());
				co.modPers(choix);
				menuCandReset(listCand);
			}
		});
		btnModCand.setBounds(10, 98, 199, 23);
		panCandMod.add(btnModCand);
	}

	private void MenuDesinscCandidat(JTabbedPane paneCandInt�rieur) {
		JPanel panCandDesisnc = new JPanel();
		paneCandInt�rieur.addTab("D\u00E9sinscrire de", null, panCandDesisnc, null);
		panCandDesisnc.setLayout(null);
		
		listCandDesinscDe.setBounds(10, 10, 199, 287);
		panCandDesisnc.add(listCandDesinscDe);
		Button btnCandDesinsc = new Button("D\u00E9sinscrire");
		btnCandDesinsc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat choixCandidat = Listecand.get(listCand.getSelectedIndex());
				Listecomp.addAll(co.getListeComp(choixCandidat));
				Competition choixComp = Listecomp.get(listCandDesinscDe.getSelectedIndex());
				co.desinscComp(choixComp, choixCandidat);
				listCandDesinscDe.removeAll();
				for(Competition c : co.getListeComp(choixCandidat))
				{
					listCandDesinscDe.add(c.getNom());
				}
			}
		});
		btnCandDesinsc.setBounds(72, 303, 70, 22);
		panCandDesisnc.add(btnCandDesinsc);
	}

	private void MenuInscrireCandidat(JTabbedPane paneCandInt�rieur) {
		JPanel panCandInscA = new JPanel();
		paneCandInt�rieur.addTab("Inscrire \u00E0", null, panCandInscA, null);
		panCandInscA.setLayout(null);
		
		listCandInscA.setBounds(10, 10, 199, 281);
		panCandInscA.add(listCandInscA);
		
		Button btnCandInscA = new Button("Enregistrer");
		btnCandInscA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Candidat choix = Listecand.get(listCand.getSelectedIndex());
				Listecomp.clear();
				for (Competition c : Inscriptions.getInscriptions().getCompetitions())
				{
					if(c.estEnEquipe()==choix.getSub())
						Listecomp.add(c);
				}
				Competition choix_comp = Listecomp.get(listCandInscA.getSelectedIndex());
				co.inscComp(choix, choix_comp);
			}
		});
		btnCandInscA.setActionCommand("Enregistrer");
		btnCandInscA.setBounds(74, 297, 70, 22);
		panCandInscA.add(btnCandInscA);
	}

	private void MenuListInscriptions(JTabbedPane paneCandInt�rieur) {
		JPanel panCandEstInsc = new JPanel();
		panCandEstInsc.setBackground(UIManager.getColor("Button.light"));
		paneCandInt�rieur.addTab("Est inscrit \u00E0", null, panCandEstInsc, null);
		panCandEstInsc.setLayout(null);
		
		tableCandEstInsc = new JTable();
		tableCandEstInsc.setEnabled(false);
		tableCandEstInsc.setRowSelectionAllowed(false);
		tableCandEstInsc.setBounds(10, 11, 199, 336);
		panCandEstInsc.add(tableCandEstInsc);

	}

	public void menuCandReset(List list)
	{
		list.removeAll();
		
		for(Candidat c : Inscriptions.getInscriptions().getCandidats())
		{
			if(c.getSub())
				list.add("Equipe \""+c.getNom()+"\"");
			else
				list.add(c.getPrenom()+" "+c.getNom());			
		}
		if(listCand.getSelectedIndex()>=0)
		{
			DefaultTableModel ModelCandEstInsc = new DefaultTableModel();
			tableCandEstInsc.setModel(ModelCandEstInsc);
			ModelCandEstInsc.setRowCount(0);
			ModelCandEstInsc.addColumn(new Object[]{"Nom"});

			ModelCandEstInsc.addRow(new Object[]{"Nom"});
	        Listecand.addAll(Inscriptions.getInscriptions().getCandidats()); 
	        
	        for(Competition c : co.getListeComp(Listecand.get(listCand.getSelectedIndex())))
	        {
	        	ModelCandEstInsc.addRow(new Object[]{c.getNom()});
	        }
		}
		listCand.removeAll();
		Listecand.clear();
		Listecand.addAll(Inscriptions.getInscriptions().getCandidats());
		
		for(Candidat c : Listecand)
		{
			listCand.add(c.getNom());
		}
	}
}
