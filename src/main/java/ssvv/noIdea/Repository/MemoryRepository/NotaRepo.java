package ssvv.noIdea.Repository.MemoryRepository;
import ssvv.noIdea.Validator.IValidator;
import ssvv.noIdea.Domain.Nota;

public class NotaRepo extends AbstractCrudRepo<Integer,Nota > {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}