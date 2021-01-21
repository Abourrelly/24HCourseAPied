package fr.course.bo;

public class Participant {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String sexe;
    private int nDossard;
    private int nbTours;
    private String equipe;

    //Constructeur
    public Participant(String nom, String prenom, int age, String sexe, int nDossard) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.nDossard = nDossard;
    }

    public Participant(int id, String nom, String prenom, int age, String sexe, int nDossard) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.nDossard = nDossard;
    }
    public Participant(int id, String nom, String prenom, int age, String sexe, int nDossard, int nbTours) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.nDossard = nDossard;
        this.nbTours = nbTours;
    }

    //Getter & Setter


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getnDossard() {
        return nDossard;
    }

    public void setnDossard(int nDossard) {
        this.nDossard = nDossard;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
}
