package fr.course.ihm;

import fr.course.bll.CourseManager;
import fr.course.bll.CourseManagerSing;
import fr.course.bll.ParticipantManagerException;
import fr.course.bo.Participant;

import java.util.ArrayList;
import java.util.List;

/*
Le monsieur envoie les données aux observers
 */

public class RunnerModel {

    private CourseManager manager = CourseManagerSing.getInstance();
    private List<Participant> listeParticipant = new ArrayList<>();

    public RunnerModel() {
    }

    public void update(RunnerView ob) throws ParticipantManagerException {
        listeParticipant = manager.getAllParticipants();
        for (Participant test:listeParticipant){
            System.out.println(test.getNom() + " " + test.getPrenom() + " " + test.getSexe() + " " + test.getEquipe());
        }
        ob.update(this);
    }

    public RunnerModel(List<Participant> listeParticipant) {
        this.listeParticipant = listeParticipant;
    }

    public List<Participant> getListeParticipant() {
        return listeParticipant;
    }

    public void setListeParticipant(List<Participant> listeParticipant) {
        this.listeParticipant = listeParticipant;
    }
}
