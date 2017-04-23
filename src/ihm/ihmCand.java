package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inscriptions.Candidat;
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
import java.awt.Button;

public class ihmCand extends JFrame {

	private JPanel contentPane;

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
		
		List listCandEstInsc = new List();
		listCandEstInsc.setBounds(10, 10, 199, 338);
		panCandEstInsc.add(listCandEstInsc);
		
		//Inscrire un candidat ŕ une compétition
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
		buttonCandSuppr.setBounds(10, 10, 199, 22);
		panCandSuppr.add(buttonCandSuppr);
		
		//Liste des candidats
		List listCand = new List();
		listCand.setBounds(10, 11, 219, 403);
		panCand.add(listCand);
	}
}
