package demo.reactAdmin.oncf.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "controls")
public class Control {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateControl;

    private String site;

    private String agent;

    private String typeControle;

    private String resultat;

    @Column(length = 1000)
    private String observations;

    @Column(length = 1000)
    private String actionMenee;

    private String fichierJoint; // chemin du PDF ou photo

    public Control() {}

    // Getters et Setters
    public Long getId() { return id; }

    public Date getDateControl() { return dateControl; }
    public void setDateControl(Date dateControl) { this.dateControl = dateControl; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

    public String getAgent() { return agent; }
    public void setAgent(String agent) { this.agent = agent; }

    public String getTypeControle() { return typeControle; }
    public void setTypeControle(String typeControle) { this.typeControle = typeControle; }

    public String getResultat() { return resultat; }
    public void setResultat(String resultat) { this.resultat = resultat; }

    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }

    public String getActionMenee() { return actionMenee; }
    public void setActionMenee(String actionMenee) { this.actionMenee = actionMenee; }

    public String getFichierJoint() { return fichierJoint; }
    public void setFichierJoint(String fichierJoint) { this.fichierJoint = fichierJoint; }
}
