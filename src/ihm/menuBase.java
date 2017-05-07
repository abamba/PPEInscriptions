package ihm;

import java.awt.BorderLayout;
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
				CompAddUpdate();
				CompModUpdate();
				CompInscrireUpdate();
				CompInscritsUpdate();
			}

			private void CompInscritsUpdate() {
				ListCompInscrire.removeAll();
				if(getComp()!=null)
					for(Candidat c : getComp().getCandidats())
						ListCompInscrire.add(c.getNom());
			}

			private void CompInscrireUpdate() {
				Listecompcand.clear();
				ListCompInsc.removeAll();
				for(Candidat c : getComp().getNonInscrits())
				{
					Listecompcand.add(c);
					ListCompInsc.add(c.getNom());
				}
			}

			private void CompModUpdate() {
				Date date = java.sql.Date.valueOf(getComp().getDateCloture());
				CompModNom.setText(getComp().getNom());
				CompModDate.setValue(date);
				compModEnEquipe.setSelected(getComp().estEnEquipe());
			}

			private void CompAddUpdate() {
				// Onglet Créer une compétition
				CompAddNom.setText("");
				CompAddEnEquipe.setSelected(false);
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
				PersModUpdate();
				PersCompUpdate();
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
				PersAddNom.setText("");
				PersAddPrenom.setText("");
				PersAddMail.setText("");
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
		PersModValider.setBounds(10, 95, 208, 23);
		
		panPersMod.add(PersModValider);
		
		panelCandOptions.addTab("Supprimer", null, panPersSupp, null);
		panPersSupp.setLayout(null);
		PersSuppValider.setBounds(10, 11, 208, 23);
		
		panPersSupp.add(PersSuppValider);
		
		panelCandOptions.addTab("Comp\u00E9titions", null, panPersComp, null);
		panPersComp.setLayout(null);
		
		PersCompAddValider.setBounds(10, 150, 208, 23);
		
		panPersComp.add(PersCompAddValider);
		PersCompRemoveValider.setBounds(10, 319, 208, 23);
		
		panPersComp.add(PersCompRemoveValider);
		ListPersCompAdd.setBounds(10, 10, 208, 134);
		
		panPersComp.add(ListPersCompAdd);
		ListPersCompRemove.setBounds(10, 179, 208, 134);
		
		panPersComp.add(ListPersCompRemove);
		
		// Equipe
		
		General.addTab("Equipe", null, panelEq, null);
		
		menuCompInit();
		menuCompUpdate();
		menuPersInit();
		menuPersUpdate();
		menuEqInit();
		menuEqUpdate();
	}
	
	private void menuCompInit() {
		JTabbedPane panel = panelCompOptions;

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
				Listepers.clear();
				ListPers.removeAll();
				Listepers.addAll(i.getPersonnes());
				for(Candidat c : Listepers)
					ListPers.add(c.getNom() + " " + c.getPrenom());
			}
		});
		
		PersCompAddValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getPersCompAdd()!=null)
				{
					getPersCompAdd().add(getPers());
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
			}

			private Competition getPersCompAdd() {
				Competition comp = null;
				if(ListPersCompAdd.getSelectedIndex()>-1)
					comp = Listecandcompremove.get(ListPersCompAdd.getSelectedIndex());
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
}
