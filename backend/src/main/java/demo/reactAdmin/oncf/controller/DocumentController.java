@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public Document upload(@RequestBody Document doc){
        return documentService.save(doc);
    }

    @GetMapping
    public List<Document> list(){
        return documentService.getAll();
    }

}
