package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import persistance.Connect;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;

import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Choice;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ihmCand extends JFrame {
	
	static List listCand = new List();
	static ArrayList<Competition> Listecomp = new ArrayList<Competition>();
	static ArrayList<Candidat> Listecand = new ArrayList<Candidat>();
	static ArrayList<Candidat> Listeeq = new ArrayList<Candidat>();
    static ArrayList<Candidat> Listepers = new ArrayList<Candidat>();
	private JPanel contentPane;
	private Connect co = Inscriptions.getInscriptions().getConnect();
	private JTable tableCandEstInsc;
	private JTextField tFModCandNom;
	private JTextField tFModCandPrenom;
	private JTextField tFModCandMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ihmCand frame = new ihmCand();
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
	public ihmCand() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane Conteneur = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(Conteneur, BorderLayout.CENTER);
		
		menuCand(Conteneur);
	}
	
	public void menuCand(JTabbedPane tabbedPane)
	{	
		//Onglet Candidat 
		
		JPanel panCand = new JPanel();
		tabbedPane.addTab("Candidat", null, panCand, null);
		panCand.setLayout(null);
		
		JTabbedPane PaneCandIntérieur = new JTabbedPane(JTabbedPane.TOP);
		PaneCandIntérieur.setBounds(235, 11, 224, 402);
		panCand.add(PaneCandIntérieur);
		
		//Liste des inscriptions d'un candidat
		JPanel panCandEstInsc = new JPanel();
		panCandEstInsc.setBackground(UIManager.getColor("Button.light"));
		PaneCandIntérieur.addTab("Est inscrit \u00E0", null, panCandEstInsc, null);
		panCandEstInsc.setLayout(null);
		
		tableCandEstInsc = new JTable();
		tableCandEstInsc.setBounds(10, 11, 199, 336);
		panCandEstInsc.add(tableCandEstInsc);
		
		
		//Inscrire un candidat à une compétition
		JPanel panCandInscA = new JPanel();
		PaneCandIntérieur.addTab("Inscrire \u00E0", null, panCandInscA, null);
		panCandInscA.setLayout(null);
		
		Button buttonCandInscA = new Button("Enregistrer");
		buttonCandInscA.setActionCommand("Enregistrer");
		buttonCandInscA.setBounds(89, 326, 70, 22);
		panCandInscA.add(buttonCandInscA);
		
		List listCandInscA = new List();
		listCandInscA.setBounds(10, 10, 199, 310);
		panCandInscA.add(listCandInscA);
		
		//Désinscrire un candidat d'une compétition
		JPanel panCandDesisnc = new JPanel();
		PaneCandIntérieur.addTab("D\u00E9sinscrire de", null, panCandDesisnc, null);
		panCandDesisnc.setLayout(null);
		
		Button buttonCandDesinsc = new Button("Enregistrer");
		buttonCandDesinsc.setBounds(89, 326, 70, 22);
		panCandDesisnc.add(buttonCandDesinsc);
		
		List listCandDesinscDe = new List();
		listCandDesinscDe.setBounds(10, 10, 199, 310);
		panCandDesisnc.add(listCandDesinscDe);
		
		//Modifier un candidat
		JPanel panCandMod = new JPanel();
		PaneCandIntérieur.addTab("Modifier", null, panCandMod, null);
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
				listCand.removeAll();

		        for(Candidat c : Inscriptions.getInscriptions().getCandidats())
		        {
		            if(c.getSub())
		                listCand.add("Equipe \""+c.getNom()+"\"");
		            else
		                listCand.add(c.getPrenom()+" "+c.getNom());
		        }
			}
		});
		btnModCand.setBounds(10, 98, 199, 23);
		panCandMod.add(btnModCand);
		
		//Equipes auxquels appartient un candidat
		JPanel panCandAppartEq = new JPanel();
		PaneCandIntérieur.addTab("Appartient \u00E0", null, panCandAppartEq, null);
		panCandAppartEq.setLayout(null);
		
		List listCandAppartEq = new List();
		listCandAppartEq.setBounds(10, 10, 199, 338);
		panCandAppartEq.add(listCandAppartEq);
		
		//Supprimer un candidat
		JPanel panCandSuppr = new JPanel();
		PaneCandIntérieur.addTab("Supprimer", null, panCandSuppr, null);
		panCandSuppr.setLayout(null);
		
		Button buttonCandSuppr = new Button("Supprimer le candidat");
		buttonCandSuppr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				co.delCandidat(Listecand.get(listCand.getSelectedIndex()));
				
				listCand.removeAll();
				
				for(Candidat c : Inscriptions.getInscriptions().getCandidats())
				{
					listCand.add(c.getNom());
				}
			}
		});
		buttonCandSuppr.setBounds(10, 10, 199, 22);
		panCandSuppr.add(buttonCandSuppr);
		listCand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
			        
			        
			        Candidat choix = Listecand.get(listCand.getSelectedIndex());
			        tFModCandNom.setText(choix.getNom());
			        tFModCandPrenom.setText(choix.getPrenom());
					tFModCandMail.setText(choix.getMail());
				}
			}
		});
		
		
		//Liste des candidats
		
		listCand.setBounds(10, 11, 219, 403);
		panCand.add(listCand);
		
		menuCandReset(listCand);
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
	}
}
