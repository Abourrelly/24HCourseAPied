package fr.course.ihm;

/*
Le monsieur ici appelle UNIQUEMENT le CourseManager et envoie les données au Model
 */


import fr.course.bll.CourseManager;
import fr.course.bll.CourseManagerSing;
import fr.course.bll.ParticipantManagerException;
import fr.course.bo.Participant;

import java.util.ArrayList;
import java.util.List;

public class RunnerController {

    private List<RunnerView> observersListe = new ArrayList<>();
    private RunnerModel model = new RunnerModel();
    private CourseManager manager = CourseManagerSing.getInstance();

    private static RunnerController instance;

    public synchronized static RunnerController getInstance() {
        if (instance == null) {
            instance = new RunnerController();
        }
        return instance;
    }

    public RunnerController(){

    }

    public void startApp(){
    }

    public void ajouterParticipant(String nom, String prenom, String equipe, String sexe, int age, int nDossard) throws ParticipantManagerException {
        manager.addParticipant(new Participant(0, nom, prenom, age, sexe, nDossard));
    }


    public void addObserver(RunnerView observer) throws ParticipantManagerException {
        observersListe.add(observer);
        updateAll();
    }

    public void removeObserver(RunnerView observer) throws ParticipantManagerException {
        observersListe.remove(observer);
        updateAll();
    }

    public void updateAll() throws ParticipantManagerException {
        for (RunnerView observer:observersListe){
            model.update(observer);
        }
    }
}
