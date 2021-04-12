package ssvv.noIdea;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ssvv.noIdea.Exceptions.ValidatorException;
import ssvv.noIdea.Repository.XMLFileRepository.NotaXMLRepo;
import ssvv.noIdea.Repository.XMLFileRepository.StudentXMLRepo;
import ssvv.noIdea.Repository.XMLFileRepository.TemaLabXMLRepo;
import ssvv.noIdea.Service.XMLFileService.NotaXMLService;
import ssvv.noIdea.Service.XMLFileService.StudentXMLService;
import ssvv.noIdea.Service.XMLFileService.TemaLabXMLService;
import ssvv.noIdea.Validator.NotaValidator;
import ssvv.noIdea.Validator.StudentValidator;
import ssvv.noIdea.Validator.TemaLabValidator;

public class Lab4Tests {

    String id = "1", nume = "Nume", grupa = "12", email = "email@email.com", prof = "Prof";
    StudentValidator vs = new StudentValidator();
    StudentXMLRepo strepo = new StudentXMLRepo(vs, "StudentiXML.xml");
    StudentXMLService stsrv = new StudentXMLService(strepo);
    TemaLabValidator vt = new TemaLabValidator();
    TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
    TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
    NotaValidator vn=new NotaValidator();
    NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
    NotaXMLService ntsrv=new NotaXMLService(ntrepo);
    String descr = "descr", saptLim = "5", temenLim = "6";
    int max_int = Integer.MAX_VALUE;
    long max_plus_1 = ((long) max_int) + 1;

    @Before
    public void setup()
    {
        ntsrv.remove(Integer.parseInt(id));
        tmsrv.remove(Integer.parseInt(id));
        stsrv.remove(id);
    }

    @Test
    public void TestAddAssig() {
        String[] params1 = {id, descr, saptLim, temenLim};
        try {
            tmsrv.add(params1);
            assert (true);
        } catch (Exception ex) {
            assert (false);
        }
    }

    @Test
    public void TestAddStudent() {
        String[] params2 = {id, nume, grupa, email, prof};
        try {
            stsrv.add(params2);
            assert (true);
        } catch (ValidatorException ex) {
            assert (false);
        }
    }

    @Test
    public void TestAddGrade()
    {
        String[] params={id,id,id,"8","2018-11-02T12:00"};
        try
        {
            ntsrv.add(params);
            assert(true);
        }
        catch (Exception ex) {
            assert (false);
        }
    }

    @Test
    public void TestAll()
    {
        TestAddAssig();
        TestAddStudent();
        TestAddGrade();
    }

    @After
    public void teardown()
    {
        ntsrv.remove(Integer.parseInt(id));
        tmsrv.remove(Integer.parseInt(id));
        stsrv.remove(id);
    }
}
