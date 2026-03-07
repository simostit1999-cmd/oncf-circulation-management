@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document save(Document doc){
        return documentRepository.save(doc);
    }

    public List<Document> getAll(){
        return documentRepository.findAll();
    }

    public void delete(Long id){
        documentRepository.deleteById(id);
    }
}
