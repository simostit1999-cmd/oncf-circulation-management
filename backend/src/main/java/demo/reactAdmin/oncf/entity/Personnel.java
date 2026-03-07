package demo.reactAdmin.oncf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    private String matricule;

    private String fonction;

    @Column(length = 1000)
    private String formations; // liste des formations suivies

    @Column(length = 1000)
    private String habilitations; // habilitations

    @Column(length = 1000)
    private String evaluations; // historique évaluations psy et médicales

    @Column(length = 1000)
    private String conges; // congés et repos

    public Personnel() {}

    // Getters et Setters
    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getFonction() { return fonction; }
    public void setFonction(String fonction) { this.fonction = fonction; }

    public String getFormations() { return formations; }
    public void setFormations(String formations) { this.formations = formations; }

    public String getHabilitations() { return habilitations; }
    public void setHabilitations(String habilitations) { this.habilitations = habilitations; }

    public String getEvaluations() { return evaluations; }
    public void setEvaluations(String evaluations) { this.evaluations = evaluations; }

    public String getConges() { return conges; }
    public void setConges(String conges) { this.conges = conges; }
}
