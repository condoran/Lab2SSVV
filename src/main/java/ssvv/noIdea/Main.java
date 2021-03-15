package ssvv.noIdea;

import ssvv.noIdea.Exceptions.*;
import ssvv.noIdea.Repository.XMLFileRepository.NotaXMLRepo;
import ssvv.noIdea.Repository.XMLFileRepository.StudentXMLRepo;
import ssvv.noIdea.Repository.XMLFileRepository.TemaLabXMLRepo;
import ssvv.noIdea.Service.XMLFileService.NotaXMLService;
import ssvv.noIdea.Service.XMLFileService.StudentXMLService;
import ssvv.noIdea.Service.XMLFileService.TemaLabXMLService;
import ssvv.noIdea.Validator.*;
import ssvv.noIdea.UI.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}