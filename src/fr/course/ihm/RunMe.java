package fr.course.ihm;

import fr.course.bll.ParticipantManagerException;

import javax.swing.*;

public class RunMe {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                RunnerController.getInstance().startApp();

                RunnerView ecran = null;
                try {
                    ecran = new RunnerView();
                } catch (ParticipantManagerException e) {
                    e.printStackTrace();
                }
                ecran.setVisible(true);
            }

        });
    }
}
