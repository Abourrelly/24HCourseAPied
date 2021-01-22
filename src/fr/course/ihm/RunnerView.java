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
    private JLabel ParticipantListe;
    private JSpinner ageText;
    private JLabel lbAge;
    private JSpinner dossardText;
    private JLabel lbDossard;
    private JLabel lbPrenom;
    private JLabel lbEquipe;
    private JLabel lbSexxe;
    private JLabel lbNom;
    private JScrollPane listeParticipantPanel;
    private JScrollPane TablePanel;


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

        this.setContentPane(mainPanel);
    }


    //Pas de setter, la méthode update remplit cette fonction

    public void update(RunnerModel model) {
        String tmp = null;
        for (Participant participant : model.getListeParticipant()) {
            tmp += participant.getNom() + " " + participant.getPrenom() + " " + participant.getEquipe() + " " + participant.getSexe();
        }
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

    public JScrollPane getTablePanel() {
        return TablePanel;
    }

}
