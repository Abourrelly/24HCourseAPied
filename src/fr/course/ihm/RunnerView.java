package fr.course.ihm;

import fr.course.bll.*;
import fr.course.dal.*;
import fr.course.bo.*;
import fr.course.dal.dao.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
Le monsieur ici appelle UNIQUEMENT le RunnerController
 */

public class RunnerView extends JFrame {

    private JPanel mainPanel;
    private JTextField nomText;
    private JTextField sexeText;
    private JTextField prenomText;
    private JTextField equipeText;
    private JButton listButton;
    private JButton addButton;
    //private JLabel ParticipantListe;
    private JSpinner ageText;
    private JLabel lbAge;
    private JSpinner dossardText;
    private JLabel lbDossard;
    private JLabel lbPrenom;
    private JLabel lbEquipe;
    private JLabel lbSexxe;
    private JLabel lbNom;
    private JScrollPane listeParticipantPanel = new JScrollPane();
    private JList ParticipantListe;


    public RunnerView() throws ParticipantManagerException {
        this.setTitle("24H Marathon");
        this.setSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        RunnerController.getInstance().addObserver(this);

        initIHM();
    }

    private void initIHM() {
        addButton.addActionListener(e -> {
            try {
                RunnerController.getInstance().ajouterParticipant(
                        nomText.getText(),
                        prenomText.getText(),
                        equipeText.getText(),
                        sexeText.getText(),
                        Integer.valueOf(ageText.getValue().toString()),
                        Integer.valueOf(dossardText.getValue().toString())
                );
            } catch (ParticipantManagerException participantManagerException) {
                participantManagerException.printStackTrace();
            }
        });

        Object[][] donnees = {
                {"Johnathan", "Sykes", "Color.red", "true", "tenis"},
                {"Nicolas", "Van de Kampf", "Color.black", "true", "tenis"},
                {"Damien", "Cuthbert", "Color.cyan", "true", "tenis"},
                {"Corinne", "Valance", "Color.blue", "false", "tenis"},
                {"Emilie", "Schrödinger", "Color.magenta", "false", "tenis"},
                {"Delphine", "Duke", "Color.yellow", "false", "tenis"},
                {"Eric", "Trump", "Color.pink", "true", "tenis"},
        };

        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};

        JTable tableau = new JTable(donnees, entetes);
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        pack();
    }


    //Pas de setter, la méthode update remplit cette fonction

    public void update(RunnerModel model) {
        List<String> listeParticipant = new ArrayList<>();

        for (Participant participant : model.getListeParticipant()) {
            listeParticipant.add(
                    participant.getNom() + " " +
                            participant.getPrenom() + " " +
                            participant.getEquipe() + " " +
                            participant.getSexe());
        }
        ParticipantListe.setListData(listeParticipant.toArray());
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getNomText() {
        return nomText;
    }

    public JTextField getSexeText() {
        return sexeText;
    }

    public JTextField getPrenomText() {
        return prenomText;
    }

    public JTextField getEquipeText() {
        return equipeText;
    }

    public JButton getListButton() {
        return listButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

}
