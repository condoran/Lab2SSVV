package ssvv.noIdea.Repository.MemoryRepository;
import ssvv.noIdea.Validator.IValidator;
import ssvv.noIdea.Domain.Student;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}