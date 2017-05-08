package ihm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.List;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JList;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class menuBase extends JFrame {

	static Inscriptions i = Inscriptions.getInscriptions();
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
	
	static ArrayList<Competition> Listecomp = new ArrayList<Competition>();
	static ArrayList<Candidat> Listepers = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listeeq = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listecompcand = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listecandeq = new ArrayList<Candidat>();
	static ArrayList<Competition> Listecandcomp = new ArrayList<Competition>();
	static ArrayList<Competition> Listecandcompremove = new ArrayList<Competition>();
	static ArrayList<Competition> Listeeqcomp = new ArrayList<Competition>();
	static ArrayList<Competition> Listeeqcompremove = new ArrayList<Competition>();
	static ArrayList<Candidat> Listeeqpers = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listeeqpersremove = new ArrayList<Candidat>();
	
	static int panel1, panel2, panel3 = 1;
	
	static JTabbedPane General = new JTabbedPane(JTabbedPane.TOP);
	static JTabbedPane panelCompOptions = new JTabbedPane(JTabbedPane.TOP);
	
	static JPanel panelComp = new JPanel();
	static JPanel panelPers = new JPanel();
	static JPanel panelEq = new JPanel();
	
	static JPanel panCreateComp = new JPanel();
	static JPanel panModComp = new JPanel();
	static JPanel panSuppComp = new JPanel();
	static JPanel panInscrireComp = new JPanel();
	static JPanel panInscritsComp = new JPanel();
	
	static List ListComp = new List();
	static List ListCompInscrire = new List();
	
	private JPanel contentPane;
	
	private JTextField CompAddNom;
	
	private JSpinner CompAddAnnee = new JSpinner();
	private JSpinner CompAddDate;
	private JSpinner CompAddMois = new JSpinner();
	private JSpinner CompAddJour = new JSpinner();
	
	private JCheckBox CompAddEnEquipe = new JCheckBox("");
	private final JButton CompSuppValider = new JButton("Supprimer");
	private final JLabel label_1 = new JLabel("Nom");
	private final JTextField CompModNom = new JTextField();
	private final JSpinner CompModDate = new JSpinner();
	private final JLabel label_2 = new JLabel("Date");
	private final JLabel label_3 = new JLabel("En \u00E9quipe");
	private final JCheckBox compModEnEquipe = new JCheckBox("");
	private final JButton CompModValider = new JButton("Modifier");
	private final List ListCompInsc = new List();
	private final JButton CompInscValider = new JButton("Inscrire");
	private final List ListPers = new List();
	private final JTabbedPane panelCandOptions = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panPersAdd = new JPanel();
	private final JPanel panPersMod = new JPanel();
	private final JPanel panPersSupp = new JPanel();
	private final JPanel panPersComp = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("Nom");
	private final JTextField PersAddNom = new JTextField();
	private final JLabel label_4 = new JLabel("Pr\u00E9nom");
	private final JTextField PersAddPrenom = new JTextField();
	private final JLabel label_5 = new JLabel("Mail");
	private final JTextField PersAddMail = new JTextField();
	private final JButton PersAddValider = new JButton("Cr\u00E9er");
	private final JLabel label_6 = new JLabel("Nom");
	private final JTextField PersModNom = new JTextField();
	private final JTextField PersModPrenom = new JTextField();
	private final JLabel label_7 = new JLabel("Pr\u00E9nom");
	private final JLabel label_8 = new JLabel("Mail");
	private final JTextField PersModMail = new JTextField();
	private final JButton PersModValider = new JButton("Modifier");
	private final JButton PersSuppValider = new JButton("Supprimer");
	private final JButton PersCompAddValider = new JButton("Inscrire");
	private final JButton PersCompRemoveValider = new JButton("D\u00E9sinscrire");
	private final List ListPersCompAdd = new List();
	private final List ListPersCompRemove = new List();
	private final List ListEq = new List();
	private final List ListEqCompAdd = new List();
	private final List ListEqCompRemove = new List();
	private final JTabbedPane panelEqOptions = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panEqMod = new JPanel();
	private final JPanel panEqSupp = new JPanel();
	private final JPanel panEqPers = new JPanel();
	private final JPanel panEqComp = new JPanel();
	private final JLabel label_9 = new JLabel("Nom");
	private final JTextField EqAddNom = new JTextField();
	private final JLabel label_10 = new JLabel("Mail");
	private final JTextField EqAddMail = new JTextField();
	private final JLabel label_11 = new JLabel("Nom");
	private final JTextField EqModNom = new JTextField();
	private final JTextField EqModMail = new JTextField();
	private final JLabel label_12 = new JLabel("Mail");
	private final JButton EqModValider = new JButton("Modifier");
	private final JButton EqSuppValider = new JButton("Supprimer");
	private final List ListEqPersAdd = new List();
	private final JButton EqPersAddValider = new JButton("Ajouter");
	private final List ListEqPersRemove = new List();
	private final JButton EqPersAddRemove = new JButton("Enlever");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuBase frame = new menuBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuBase() {
		PersAddNom.setBounds(118, 8, 100, 20);
		PersAddNom.setColumns(10);
		
		// Fenêtre par défaut
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		General.setBounds(10, 11, 464, 439);
		contentPane.add(General);
		
		// Compétition
		
		General.addTab("Competition", null, panelComp, null);
		panelComp.setLayout(null);
		ListComp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch (panel1)
				{
				case 1 :
					CompAddUpdate();
					break;
				case 2 :
					CompModUpdate();
					break;
				case 4 :
					CompInscrireUpdate();
					break;
				case 5 :
					CompInscritsUpdate();
					break;
				}
			}

		});
		
		ListComp.setBounds(10, 10, 200, 391);
		panelComp.add(ListComp);
		
		panelCompOptions.setBounds(216, 10, 233, 391);
		panelComp.add(panelCompOptions);
		
		// Personne
		
		General.addTab("Personne", null, panelPers, null);
		panelPers.setLayout(null);
		ListPers.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(ListPers.getSelectedIndex()>-1)
					PersUpdateBoutons(true);
				
				PersModUpdate();
				PersCompUpdate();
			}

			private void PersUpdateBoutons(boolean b) {
				PersModValider.setEnabled(b);
				PersSuppValider.setEnabled(b);
			}

			private void PersCompUpdate() {
				Listecandcomp.clear();
				Listecandcomp.addAll(getPers().getCompetitions());
				Listecandcompremove.clear();
				Listecandcompremove.addAll(getPers().getNonCompetitions());
				ListPersCompAdd.removeAll();
				ListPersCompRemove.removeAll();
				for(Competition c : Listecandcomp)
				{
					ListPersCompRemove.add(c.getNom());
				}
				for(Competition c : Listecandcompremove)
				{
					ListPersCompAdd.add(c.getNom());
				}
			}

			private void PersModUpdate() {
				PersModNom.setText(getPers().getNom());
				PersModPrenom.setText(getPers().getPrenom());
				PersModMail.setText(getPers().getMail());
			}
		});
		ListPers.setBounds(10, 10, 200, 391);
		
		panelPers.add(ListPers);
		panelCandOptions.setBounds(216, 10, 233, 391);
		
		panelPers.add(panelCandOptions);
		panPersAdd.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				PersCreateUp();
			}
		});
		
		panelCandOptions.addTab("Cr\u00E9er", null, panPersAdd, null);
		panPersAdd.setLayout(null);
		lblNewLabel_2.setBounds(10, 11, 100, 14);
		
		panPersAdd.add(lblNewLabel_2);
		
		panPersAdd.add(PersAddNom);
		label_4.setBounds(10, 39, 100, 14);
		
		panPersAdd.add(label_4);
		PersAddPrenom.setColumns(10);
		PersAddPrenom.setBounds(118, 36, 100, 20);
		
		panPersAdd.add(PersAddPrenom);
		label_5.setBounds(10, 67, 100, 14);
		
		panPersAdd.add(label_5);
		PersAddMail.setColumns(10);
		PersAddMail.setBounds(118, 64, 100, 20);
		
		panPersAdd.add(PersAddMail);
		PersAddValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.createCandidat(PersAddNom.getText(), PersAddPrenom.getText(), PersAddMail.getText(), false);
				PersListeUp();
				PersCreateUp();
			}
		});
		PersAddValider.setBounds(10, 92, 208, 23);
		
		panPersAdd.add(PersAddValider);
		
		panelCandOptions.addTab("Modifier", null, panPersMod, null);
		panPersMod.setLayout(null);
		label_6.setBounds(10, 14, 100, 14);
		
		panPersMod.add(label_6);
		PersModNom.setColumns(10);
		PersModNom.setBounds(118, 11, 100, 20);
		
		panPersMod.add(PersModNom);
		PersModPrenom.setColumns(10);
		PersModPrenom.setBounds(118, 39, 100, 20);
		
		panPersMod.add(PersModPrenom);
		label_7.setBounds(10, 42, 100, 14);
		
		panPersMod.add(label_7);
		label_8.setBounds(10, 70, 100, 14);
		
		panPersMod.add(label_8);
		PersModMail.setColumns(10);
		PersModMail.setBounds(118, 67, 100, 20);
		
		panPersMod.add(PersModMail);
		PersModValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPers().setNom(PersModNom.getText());
				getPers().setPrenom(PersModPrenom.getText());
				getPers().setMail(PersModMail.getText());
				PersListeUp();
			}
		});
		PersModValider.setEnabled(false);
		PersModValider.setBounds(10, 95, 208, 23);
		
		panPersMod.add(PersModValider);
		
		panelCandOptions.addTab("Supprimer", null, panPersSupp, null);
		panPersSupp.setLayout(null);
		PersSuppValider.setEnabled(false);
		PersSuppValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getPers()!=null)
				{
					getPers().delete();
					PersListeUp();
				}
					
			}
		});
		PersSuppValider.setBounds(10, 11, 208, 23);
		
		panPersSupp.add(PersSuppValider);
		panPersComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(getEq()!=null)
					EqCompUp();
			}
		});
		
		panelCandOptions.addTab("Comp\u00E9titions", null, panPersComp, null);
		panPersComp.setLayout(null);
		PersCompAddValider.setEnabled(false);
		
		PersCompAddValider.setBounds(10, 150, 208, 23);
		
		panPersComp.add(PersCompAddValider);
		PersCompRemoveValider.setEnabled(false);

		PersCompRemoveValider.setBounds(10, 319, 208, 23);
		
		panPersComp.add(PersCompRemoveValider);
		ListPersCompAdd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				PersCompAddValider.setEnabled(true);
			}
		});

		ListPersCompAdd.setBounds(10, 10, 208, 134);
		
		panPersComp.add(ListPersCompAdd);
		ListPersCompRemove.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				PersCompRemoveValider.setEnabled(true);
			}
		});
		ListPersCompRemove.setBounds(10, 179, 208, 134);
		
		panPersComp.add(ListPersCompRemove);
		panelEq.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				EqListeUp();
			}
		});
		
		// Equipe
		
		General.addTab("Equipe", null, panelEq, null);
		panelEq.setLayout(null);
		ListEq.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch(panel3)
				{
				case 1 :
					break;
					
				case 2 :
					break;
					
				case 4 :
					EqPersUp();
					break;
					
				case 5 :
					EqCompUp();
					break;
				}
				
			}
		});
		ListEq.setBounds(10, 10, 200, 391);
		
		panelEq.add(ListEq);
		panelEqOptions.setBounds(216, 10, 233, 391);
		
		panelEq.add(panelEqOptions);
		
		JPanel panEqAdd = new JPanel();
		panEqAdd.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent arg0) {
				panel3 = 1;
			}
		});
		panelEqOptions.addTab("Cr\u00E9er", null, panEqAdd, null);
		panEqAdd.setLayout(null);
		label_9.setBounds(10, 13, 100, 14);
		
		panEqAdd.add(label_9);
		EqAddNom.setBounds(118, 10, 100, 20);
		EqAddNom.setColumns(10);
		
		panEqAdd.add(EqAddNom);
		label_10.setBounds(10, 41, 100, 14);
		
		panEqAdd.add(label_10);
		EqAddMail.setColumns(10);
		EqAddMail.setBounds(118, 38, 100, 20);
		
		panEqAdd.add(EqAddMail);
		
		JButton EqAddValider = new JButton("Cr\u00E9er");
		EqAddValider.setBounds(10, 66, 208, 23);
		EqAddValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i.createCandidat(EqAddNom.getText(), null, EqAddMail.getText(), true);
			}
		});
		panEqAdd.add(EqAddValider);
		panEqMod.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				panel3 = 2;
			}
		});
		
		panelEqOptions.addTab("Modifier", null, panEqMod, null);
		panEqMod.setLayout(null);
		label_11.setBounds(10, 13, 100, 14);
		
		panEqMod.add(label_11);
		EqModNom.setColumns(10);
		EqModNom.setBounds(118, 10, 100, 20);
		
		panEqMod.add(EqModNom);
		EqModMail.setColumns(10);
		EqModMail.setBounds(118, 38, 100, 20);
		
		panEqMod.add(EqModMail);
		label_12.setBounds(10, 41, 100, 14);
		
		panEqMod.add(label_12);
		EqModValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEq().setNom(EqModNom.getText());
				getEq().setMail(EqModMail.getText());
			}
		});
		EqModValider.setBounds(10, 69, 208, 23);
		
		panEqMod.add(EqModValider);
		panEqSupp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				panel3 = 3;
			}
		});
		
		panelEqOptions.addTab("Supprimer", null, panEqSupp, null);
		panEqSupp.setLayout(null);
		EqSuppValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEq().delete();
			}
		});
		EqSuppValider.setBounds(10, 11, 208, 23);
		
		panEqSupp.add(EqSuppValider);
		panEqPers.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				panel3 = 4;
			}
		});
		
		panelEqOptions.addTab("Membres", null, panEqPers, null);
		panEqPers.setLayout(null);
		ListEqPersAdd.setBounds(10, 10, 208, 134);
		
		panEqPers.add(ListEqPersAdd);
		EqPersAddValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEq().add(EqPersAdd());
				EqPersUp();
			}

			private Candidat EqPersAdd() {
				Candidat cand = null;
				if(ListEqPersAdd.getSelectedIndex()>-1)
				{
					cand = Listeeqpersremove.get(ListEqPersAdd.getSelectedIndex());
				}
				return cand;
			}
		});
		EqPersAddValider.setBounds(10, 150, 208, 23);
		
		panEqPers.add(EqPersAddValider);
		ListEqPersRemove.setBounds(10, 179, 208, 134);
		
		panEqPers.add(ListEqPersRemove);
		EqPersAddRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEq().remove(EqPersRemove());
				EqPersUp();
			}

			private Candidat EqPersRemove() {
				Candidat cand = null;
				if(ListEqPersRemove.getSelectedIndex()>-1)
				{
					cand = Listeeqpers.get(ListEqPersRemove.getSelectedIndex());
				}
				return cand;
			}
		});
		EqPersAddRemove.setBounds(10, 319, 208, 23);
		
		panEqPers.add(EqPersAddRemove);
		panEqComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				panel3 = 5;
				EqCompUp();
			}
		});
		
		panelEqOptions.addTab("Comp\u00E9titions", null, panEqComp, null);
		panEqComp.setLayout(null);
		
		ListEqCompAdd.setBounds(10, 10, 208, 134);
		panEqComp.add(ListEqCompAdd);
		
		JButton EqCompAddValider = new JButton("Inscrire");
		EqCompAddValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEqAdd().add(getEq());
				EqCompUp();
			}

			private Competition getEqAdd() {
				Competition comp = null;
				if(ListEqCompAdd.getSelectedIndex()>-1)
				{
					comp = Listeeqcompremove.get(ListEqCompAdd.getSelectedIndex());
				}
				return comp;
			}
		});
		EqCompAddValider.setBounds(10, 150, 208, 23);
		panEqComp.add(EqCompAddValider);

		
		ListEqCompRemove.setBounds(10, 179, 208, 134);
		panEqComp.add(ListEqCompRemove);
		
		JButton EqCompRemoveValider = new JButton("D\u00E9sinscrire");
		EqCompRemoveValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEqRemove().remove(getEq());
				EqCompUp();
			}

			private Competition getEqRemove() {
				Competition comp = null;
				if(ListEqCompRemove.getSelectedIndex()>-1)
				{
					comp = Listeeqcomp.get(ListEqCompRemove.getSelectedIndex());
				}
				return comp;
			}
		});
		EqCompRemoveValider.setBounds(10, 319, 208, 23);
		panEqComp.add(EqCompRemoveValider);
		
		menuCompInit();
		menuCompUpdate();
		menuPersInit();
		menuPersUpdate();
		menuEqInit();
		menuEqUpdate();
	}
	
	private void menuCompInit() {
		JTabbedPane panel = panelCompOptions;
		panCreateComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				panel1 = 1;
			}
		});

		panel.addTab("Cr\u00E9er", null, panCreateComp, null);
		panCreateComp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 14, 100, 14);
		panCreateComp.add(lblNewLabel);
		
		CompAddNom = new JTextField();
		CompAddNom.setBounds(118, 11, 100, 20);
		panCreateComp.add(CompAddNom);
		CompAddNom.setColumns(10);
		
		JLabel label = new JLabel("Date");
		label.setBounds(10, 45, 100, 14);
		panCreateComp.add(label);
		
		CompAddDate = new JSpinner();
		CompAddDate.setModel(new SpinnerDateModel(new Date(1494108000000L), new Date(1494108000000L), new Date(4102354800000L), Calendar.DAY_OF_YEAR));
		CompAddDate.setBounds(118, 42, 100, 20);
		panCreateComp.add(CompAddDate);
		
		JLabel lblNewLabel_1 = new JLabel("En \u00E9quipe");
		lblNewLabel_1.setBounds(10, 70, 100, 14);
		panCreateComp.add(lblNewLabel_1);
		
		CompAddEnEquipe = new JCheckBox("");
		CompAddEnEquipe.setBounds(118, 66, 97, 23);
		panCreateComp.add(CompAddEnEquipe);
		
		JButton CompAddValider = new JButton("Cr\u00E9er");
		CompAddValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Créer une compétition
				Date date = (Date)CompAddDate.getValue();
				LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );
				i.createCompetition(CompAddNom.getText(), localDate, CompAddEnEquipe.isSelected());
			}
		});
		CompAddValider.setBounds(10, 95, 208, 23);
		panCreateComp.add(CompAddValider);
		panModComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				panel1 = 2;
			}
		});

		panel.addTab("Modifier", null, panModComp, null);
		panModComp.setLayout(null);
		label_1.setBounds(10, 14, 100, 14);
		
		panModComp.add(label_1);
		CompModNom.setColumns(10);
		CompModNom.setBounds(118, 11, 100, 20);
		
		panModComp.add(CompModNom);
		CompModDate.setModel(new SpinnerDateModel(new Date(1494108000000L), new Date(1494108000000L), new Date(4102354800000L), Calendar.DAY_OF_YEAR));
		CompModDate.setBounds(118, 42, 100, 20);
		
		panModComp.add(CompModDate);
		label_2.setBounds(10, 45, 100, 14);
		
		panModComp.add(label_2);
		label_3.setBounds(10, 70, 100, 14);
		
		panModComp.add(label_3);
		compModEnEquipe.setBounds(118, 66, 97, 23);
		
		panModComp.add(compModEnEquipe);
		CompModValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Modifier une Compétition
				if(getComp()!=null)
				{
					getComp().setNom(CompModNom.getText());
					Date date = (Date)CompModDate.getValue();
					LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );
					getComp().setDateCloture(localDate);
					getComp().setEnEquipe(compModEnEquipe.isSelected());
				}
			}
		});
		CompModValider.setBounds(10, 95, 208, 23);
		
		panModComp.add(CompModValider);
		panSuppComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			panel1 = 3;
			}
		});
		panel.addTab("Supprimer", null, panSuppComp, null);
		panSuppComp.setLayout(null);
		CompSuppValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Supprimer une Compétition
				if(getComp()!=null)
				{
					getComp().delete();
				}
			}
		});
		CompSuppValider.setBounds(10, 11, 208, 23);
		
		panSuppComp.add(CompSuppValider);
		panInscrireComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				panel1 = 4;
			}
		});

		panel.addTab("Inscrire", null, panInscrireComp, null);
		panInscrireComp.setLayout(null);
		ListCompInsc.setBounds(10, 10, 208, 297);
		
		panInscrireComp.add(ListCompInsc);
		CompInscValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Inscrire dans une Compétition
				if(getComp()!=null)
					if(getComp()!=null)
						getComp().add(getCompCand());
			}

			private Candidat getCompCand() {
				Candidat cand = null;
				cand = Listecompcand.get(ListCompInsc.getSelectedIndex());
				return cand;
			}
		});
		CompInscValider.setBounds(10, 313, 208, 23);
		
		panInscrireComp.add(CompInscValider);
		panInscritsComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			panel1 = 5;
			}
		});
		panel.addTab("Inscrits", null, panInscritsComp, null);
		panInscritsComp.setLayout(null);
		
		ListCompInscrire.setEnabled(false);
		ListCompInscrire.setBounds(10, 10, 208, 327);
		panInscritsComp.add(ListCompInscrire);
	}

	public void menuPersInit()
	{
		
	}
	
	public void menuPersUpdate()
	{
		panelPers.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				// Onglet Liste des candidats
				PersListeUp();
			}
		});
		
		PersCompAddValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getPersCompAdd()!=null)
				{
					getPersCompAdd().add(getPers());
					PersCompUp();
				}
			}

			private Competition getPersCompAdd() {
				Competition comp = null;
				if(ListPersCompAdd.getSelectedIndex()>-1)
					comp = Listecandcompremove.get(ListPersCompAdd.getSelectedIndex());
				return comp;
			}
		});
		
		PersCompRemoveValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getPersCompRemove()!=null)
				{
					getPersCompRemove().remove(getPers());
					PersCompUp();
				}
			}

			private Competition getPersCompRemove() {
				Competition comp = null;
				if(ListPersCompRemove.getSelectedIndex()>-1)
					comp = Listecandcomp.get(ListPersCompRemove.getSelectedIndex());
				return comp;
			}
		});
	}
	
	public void menuCompUpdate()
	{
		panelComp.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				// Onglet Liste des compétitions
				Listecomp.clear();
				ListComp.removeAll();
				Listecomp.addAll(i.getCompetitions());
				for(Competition c : Listecomp)
					ListComp.add(c.getNom());
			}
		});

	}
	
	public void menuEqInit()
	{
		
	}
	
	public void menuEqUpdate()
	{
		
	}
	
	public Competition getComp()
	{
		Competition comp = null;
		if(ListComp.getSelectedIndex()>-1)
			comp = Listecomp.get(ListComp.getSelectedIndex());
		return comp;
	}
	
	public Candidat getPers()
	{
		Candidat pers = null;
		if(ListPers.getSelectedIndex()>-1)
			pers = Listepers.get(ListPers.getSelectedIndex());
		return pers;
	}
	
	public Candidat getEq()
	{
		Candidat eq = null;
		if(ListEq.getSelectedIndex()>-1)
			eq = Listeeq.get(ListEq.getSelectedIndex());
		return eq;
	}
	
	// Méthodes d'update persos
	
	private void EqListeUp()
	{
		// UPD-EQ Liste des équipes
		Listeeq.clear();
		ListEq.removeAll();
		Listeeq.addAll(i.getEquipes());
		for(Candidat c : Listeeq)
			ListEq.add(c.getNom());
	}
	
	private void EqPersUp()
	{
		if(getEq()!=null)
		{
			//TODO
			Listeeqpers.clear();
			Listeeqpers.addAll(getEq().getEquipe());
			Listeeqpersremove.clear();
			Listeeqpersremove.addAll(getEq().getNonEquipe());
			ListEqPersAdd.removeAll();
			ListEqPersRemove.removeAll();
			for(Candidat c : Listeeqpers)
			{
				ListEqPersRemove.add(c.getNom()+ " "+c.getPrenom());
			}
			for(Candidat c : Listeeqpersremove)
			{
				ListEqPersAdd.add(c.getNom()+ " "+c.getPrenom());
			}
		}
	}
	
	private void EqCompUp()
	{
		// UPD-EQ Compétitions d'une équipe
		if(getEq()!=null)
		{
			Listeeqcomp.clear();
			Listeeqcomp.addAll(getEq().getCompetitions());
			Listeeqcompremove.clear();
			Listeeqcompremove.addAll(getEq().getNonCompetitions());
			ListEqCompAdd.removeAll();
			ListEqCompRemove.removeAll();
			for(Competition c : Listeeqcomp)
				ListEqCompRemove.add(c.getNom());
			for(Competition c : Listeeqcompremove)
				ListEqCompAdd.add(c.getNom());
		}
	}
	
	private void PersCompUp()
	{
		// UPD-PERS Compétitions d'un candidat
		Listecandcomp.clear();
		Listecandcomp.addAll(getEq().getCompetitions());
		Listecandcompremove.clear();
		Listecandcompremove.addAll(getEq().getNonCompetitions());
		ListPersCompAdd.removeAll();
		ListPersCompRemove.removeAll();
		for(Competition c : Listecandcomp)
			ListPersCompRemove.add(c.getNom());
		for(Competition c : Listecandcompremove)
			ListPersCompAdd.add(c.getNom());
	}
	
	private void PersCreateUp()
	{
		// UPD-PERS Créer un candidat
		PersAddNom.setText("");
		PersAddPrenom.setText("");
		PersAddMail.setText("");
	}
	
	private void PersListeUp()
	{
		// UPD-PERS Liste des personnes
		Listepers.clear();
		ListPers.removeAll();
		Listepers.addAll(i.getPersonnes());
		for(Candidat c : Listepers)
			ListPers.add(c.getNom() + " " + c.getPrenom());
	}
	
	private void CompInscritsUpdate() {
		// UPD-COMP Inscrits d'une compétition
		ListCompInscrire.removeAll();
		if(getComp()!=null)
			for(Candidat c : getComp().getCandidats())
				ListCompInscrire.add(c.getNom() + " " + c.getPrenom());
	}
	
	private void CompInscrireUpdate() {
		// UPD-COMP Inscrire dans une compétition
		Listecompcand.clear();
		ListCompInsc.removeAll();
		for(Candidat c : getComp().getNonInscrits())
		{
			Listecompcand.add(c);
			ListCompInsc.add(c.getNom());
		}
	}

	private void CompModUpdate() {
		// UPD-COMP Modifier une compétition
		Date date = java.sql.Date.valueOf(getComp().getDateCloture());
		CompModNom.setText(getComp().getNom());
		CompModDate.setValue(date);
		compModEnEquipe.setSelected(getComp().estEnEquipe());
	}

	private void CompAddUpdate() {
		// UPD-COMP Créer une compétition
		CompAddNom.setText("");
		CompAddEnEquipe.setSelected(false);
	}
}
