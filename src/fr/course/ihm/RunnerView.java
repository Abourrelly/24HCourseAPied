package fr.course.ihm;

import fr.course.bll.*;
import fr.course.dal.*;
import fr.course.bo.*;
import fr.course.dal.dao.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
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
    private JTable ParticipantTable;


    public RunnerView() throws ParticipantManagerException {
        this.setTitle("24H Marathon");
        this.setSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        RunnerController.getInstance().addObserver(this);

        initIHM();
    }

    private void initIHM() throws ParticipantManagerException {
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
        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 10; }
            public int getRowCount() { return 10;}
            public Object getValueAt(int row, int col) { return new Integer(row*col); }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        List<Participant> listparticipant = CourseManagerSing.getInstance().getAllParticipants();
        Object[][] aze = new Object[listparticipant.size()][8];
        int index = 0;
        for(Participant participant : listparticipant){
            aze[index][0] = participant.getId();
            aze[index][1] = participant.getNom();
            aze[index][2] = participant.getPrenom();
            aze[index][3] = participant.getAge();
            aze[index][4] = participant.getSexe();
            aze[index][5] = participant.getnDossard();
            aze[index][6] = participant.getEquipe();
            aze[index][7] = participant.getNbTours();
            index++;
        }
        String[] header = { "ID", "NOM", "PRENOM", "AGE", "SEXE", "NUMÉRO DOSSARD", "EQUIPE", "NB TOURS"};
        ParticipantTable = new JTable(aze, header);
        panel.add(new JScrollPane(ParticipantTable));
        frame.add(panel);
        frame.setSize(550, 400);
        frame.setVisible(true);
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
        //ParticipantListe.setListData(listeParticipant.toArray());
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
