@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String type; 
    // règlement, plan technique, consigne établissement...

    private String cheminFichier;

    private LocalDate dateUpload;

    private String uploader;

}
