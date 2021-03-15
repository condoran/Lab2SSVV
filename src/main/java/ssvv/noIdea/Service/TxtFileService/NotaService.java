package ssvv.noIdea.Service.TxtFileService;
import ssvv.noIdea.Domain.*;
import ssvv.noIdea.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer,Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
