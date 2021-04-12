package ssvv.noIdea;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ssvv.noIdea.Exceptions.ValidatorException;
import ssvv.noIdea.Repository.XMLFileRepository.StudentXMLRepo;
import ssvv.noIdea.Repository.XMLFileRepository.TemaLabXMLRepo;
import ssvv.noIdea.Service.XMLFileService.StudentXMLService;
import ssvv.noIdea.Service.XMLFileService.TemaLabXMLService;
import ssvv.noIdea.Validator.NotaValidator;
import ssvv.noIdea.Validator.StudentValidator;
import ssvv.noIdea.Validator.TemaLabValidator;

/**
 * Unit test for simple App.
 */
public class AppTest {

    String id = "1", nume = "Nume", grupa = "12", email = "email@email.com", prof = "Prof";
    StudentValidator vs = new StudentValidator();
    StudentXMLRepo strepo = new StudentXMLRepo(vs, "StudentiXML.xml");
    StudentXMLService stsrv = new StudentXMLService(strepo);
    TemaLabValidator vt = new TemaLabValidator();
    TemaLabXMLRepo tmrepo = new TemaLabXMLRepo(vt, "TemaLaboratorXML.xml");
    TemaLabXMLService tmsrv = new TemaLabXMLService(tmrepo);
    String descr = "descr", saptLim = "5", temenLim = "6";
    int max_int = Integer.MAX_VALUE;
    long max_plus_1 = ((long) max_int) + 1;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestAddStudentCorrect() {
        String[] params = {id, nume, grupa, email, prof};
        try {
            stsrv.add(params);
        } catch (ValidatorException ex) {
            assert (false);
        }
    }

    @Test
    public void TestIDNullAddStudent() {
        String[] params2 = {"", nume, grupa, email, prof};
        try {
            stsrv.add(params2);
            assert (false);
        } catch (ValidatorException ex) {
            assert (true);
        }
    }

    @Test
    public void TestGroupNullAddStudent() {
        String[] params3 = {id, nume, "", email, prof};
        try {
            stsrv.add(params3);
            assert (false);
        } catch (ValidatorException ex) {
            assert (true);
        }
    }

    @Test
    public void TestEmailNullAddStudent() {
        String[] params4 = {id, nume, grupa, "", prof};
        try {
            stsrv.add(params4);
            assert (false);
        } catch (ValidatorException ex) {
            assert (true);
        }
    }

    @Test
    public void TestProfNullAddStudent() {
        String[] params5 = {id, nume, grupa, email, ""};
        try {
            stsrv.add(params5);
            assert (false);
        } catch (ValidatorException ex) {
            assert (true);
        }
    }


    @Test
    public void TestIDAndGroupMaxIntAddStudent() {
        String[] params = {String.valueOf(max_int), nume, String.valueOf(max_int), email, prof};
        try {
            stsrv.add(params);
        } catch (ValidatorException ex) {
            assert (false);
        }
    }

    @Test
    public void TestMaxIntPlus1GroupAddStudent() {
        String[] params2 = {id, nume, String.valueOf(max_plus_1), email, prof};
        try {
            stsrv.add(params2);
            assert (false);
        } catch (ValidatorException ex) {
            assert (true);
        }
    }

    @Test
    public void TestMaxIntPlus1IDAddStudent() {
        String[] params3 = {String.valueOf(max_plus_1), nume, grupa, email, prof};
        try {
            stsrv.add(params3);
            assert (false);
        } catch (ValidatorException ex) {
            assert (true);
        }
    }

    @Test
    public void TestIdAddAssig() {
        String[] params1 = {"", descr, saptLim, temenLim};
        try {
            tmsrv.add(params1);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
        String[] params2 = {null, descr, saptLim, temenLim};
        try {
            tmsrv.add(params2);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
    }

    @Test
    public void TestDescAddAssig() {
        String[] params1 = {id, "", saptLim, temenLim};
        try {
            tmsrv.add(params1);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
        String[] params2 = {id, null, saptLim, temenLim};
        try {
            tmsrv.add(params2);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
    }

    @Test
    public void TestSaptPredAddAssig() {
        String[] params1 = {id, descr, "-1", temenLim};
        try {
            tmsrv.add(params1);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
        String[] params2 = {id, descr, "15", temenLim};
        try {
            tmsrv.add(params2);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
    }

    @Test
    public void TestTermenLimAddAssig() {
        String[] params1 = {id, descr, saptLim, "-1"};
        try {
            tmsrv.add(params1);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
        String[] params2 = {id, descr, saptLim, "15"};
        try {
            tmsrv.add(params2);
            assert (false);
        } catch (Exception ex) {
            assert (true);
        }
    }

    @Test
    public void TestAddAssigCorrect() {
        String[] params1 = {id, descr, saptLim, temenLim};
        try {
            tmsrv.add(params1);
        } catch (Exception ex) {
            assert (false);
        }
    }


}
