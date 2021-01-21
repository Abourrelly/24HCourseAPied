package fr.course.bo;

public class Participant {
    private String nom;
    private String prenom;
    private int age;
    private String sexe;
    private int nDossard;
    private String equipe;

    //Constructeur
    public Participant(String nom, String prenom, int age, String sexe, int nDossard) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.nDossard = nDossard;
    }

    //Getter & Setter

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

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

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
}
