package entities;

import java.sql.Date;
import java.time.LocalTime;

public class Cours {
    private int id;
    private Date date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    public Cours(Professeur professeur) {
        this.professeur = professeur;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    private Professeur professeur;
    private Module module;

    


    public Module getModule() {
        return module;
    }
    public void setModule(Module module) {
        this.module = module;
    }
    public Cours(Module module) {
        this.module = module;
    }
    public Cours() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public LocalTime getHeureDebut() {
        return heureDebut;
    }
    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }
    public LocalTime getHeureFin() {
        return heureFin;
    }
    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }
    
}
