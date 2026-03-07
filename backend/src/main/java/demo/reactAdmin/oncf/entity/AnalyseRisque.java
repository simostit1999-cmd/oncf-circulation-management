package demo.reactAdmin.oncf.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "analyses_risques")
public class AnalyseRisque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String processus;

    private String danger;

    private String gravite;

    private String probabilite;

    private String niveauRisque;

    @Column(length = 1000)
    private String mesuresMaitrise;

    private String fichierJoint; // chemin PDF / photo

    public AnalyseRisque() {}

    // Getters et Setters
    public Long getId() { return id; }

    public String getProcessus() { return processus; }
    public void setProcessus(String processus) { this.processus = processus; }

    public String getDanger() { return danger; }
    public void setDanger(String danger) { this.danger = danger; }

    public String getGravite() { return gravite; }
    public void setGravite(String gravite) { this.gravite = gravite; }

    public String getProbabilite() { return probabilite; }
    public void setProbabilite(String probabilite) { this.probabilite = probabilite; }

    public String getNiveauRisque() { return niveauRisque; }
    public void setNiveauRisque(String niveauRisque) { this.niveauRisque = niveauRisque; }

    public String getMesuresMaitrise() { return mesuresMaitrise; }
    public void setMesuresMaitrise(String mesuresMaitrise) { this.mesuresMaitrise = mesuresMaitrise; }

    public String getFichierJoint() { return fichierJoint; }
    public void setFichierJoint(String fichierJoint) { this.fichierJoint = fichierJoint; }
}
