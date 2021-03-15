package ssvv.noIdea.Service.TxtFileService;
import ssvv.noIdea.Domain.*;
import ssvv.noIdea.Repository.TxtFileRepository.StudentFileRepo;

public class StudentService extends AbstractService<String,Student> {
    //StudentFileRepo stdRepo;
    public StudentService(StudentFileRepo stdRepo){
        super(stdRepo);
    }
    /*
    @Override
    public Student extractEntity(String[] info){
        return new Student("","",2,"","");
    }
    */
}


