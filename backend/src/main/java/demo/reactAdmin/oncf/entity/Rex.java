package demo.reactAdmin.oncf.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rex")
public class Rex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateEvenement;

    private String nature;

    private String gravite;

    @Column(length = 1000)
    private String causes;

    @Column(length = 1000)
    private String actionsDecidees;

    private String fichierJoint; // chemin PDF / photo

    public Rex() {}

    // Getters et Setters
    public Long getId() { return id; }

    public Date getDateEvenement() { return dateEvenement; }
    public void setDateEvenement(Date dateEvenement) { this.dateEvenement = dateEvenement; }

    public String getNature() { return nature; }
    public void setNature(String nature) { this.nature = nature; }

    public String getGravite() { return gravite; }
    public void setGravite(String gravite) { this.gravite = gravite; }

    public String getCauses() { return causes; }
    public void setCauses(String causes) { this.causes = causes; }

    public String getActionsDecidees() { return actionsDecidees; }
    public void setActionsDecidees(String actionsDecidees) { this.actionsDecidees = actionsDecidees; }

    public String getFichierJoint() { return fichierJoint; }
    public void setFichierJoint(String fichierJoint) { this.fichierJoint = fichierJoint; }
}
