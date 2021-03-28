import Domain.Nota;
import Domain.Student;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.AbstractXMLService;
import Service.XMLFileService.StudentXMLService;
import Validator.IValidator;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Repository.XMLFileRepository.StudentXMLRepo;
import Validator.TemaLabValidator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestApp {
    final IValidator<Student> studentValidator = new StudentValidator();
    final IValidator<Nota> notaValidator = new NotaValidator();
    final IValidator<TemaLab> temaValidator = new TemaLabValidator();
    final StudentXMLRepo studentRepo = new StudentXMLRepo((StudentValidator) studentValidator, "test-studenti.xml");
    final NotaXMLRepo notaRepo = new NotaXMLRepo((NotaValidator) notaValidator, "test-nota.xml");
    final TemaLabXMLRepo temaRepo = new TemaLabXMLRepo((TemaLabValidator) temaValidator,"tema-test.xml");
    final AbstractXMLService service = new StudentXMLService(studentRepo);
    String maxString;
    String max_minusString;
    String max_plusString;


    public TestApp() {
        char[] fill = new char [Integer.MAX_VALUE / 1000];
        char[] fill2 = new char [Integer.MAX_VALUE / 1000 -1];
        char[] fill3 = new char [Integer.MAX_VALUE / 1000+1];
        Arrays.fill(fill, 'a');
        Arrays.fill(fill2,'b');
        Arrays.fill(fill3,'c');
        maxString = new String(fill);
        max_minusString = new String(fill2);
        max_plusString = new String(fill3);
    }

    @Test
    public void TestCase1() throws ValidatorException {
        tc1();tc2();tc3();tc4();tc5();tc6();tc7();tc8();tc9();tc10();tc11();tc12();tc13();tc14();tc15();tc16();tc17();
    }

    @Test
    public void TestCase2() throws ValidatorException {
        tc18();tc19();tc20();tc21();tc22();tc23();tc24();tc25();tc26();tc27();tc28();tc29();tc30();tc31();tc32();tc33();
    }

    @Test
    public void tc1() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"2","bobo","932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc2() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {null, "bobo", "932", "a@stud.com", "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
           // assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }
    @Test
    public void tc3() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {"", "bobo", "932", "a@stud.com", "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }

    @Test
    public void tc4() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {"6", "", "932", "a@stud.com", "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }
    @Test
    public void tc5() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {"6", null, "932", "a@stud.com", "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }
    @Test
    public void tc6() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {"6", "bobo", "0", "a@stud.com", "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }
    @Test
    public void tc7() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {"6", "bobo", String.valueOf(Integer.MAX_VALUE+1), "a@stud.com", "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }
    @Test
    public void tc8() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {"6", "bobo", "44", null, "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }
    @Test
    public void tc9() throws ValidatorException {
        int size1 = service.getSize();
        String[] params = {"6", "bobo", "44", "", "Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }

    @Test
    public void tc10() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"9","Ab","932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc11() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={maxString,"Ab","932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc12() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"12","Ab","932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc13() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={max_minusString,"Ab","932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc14() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={max_plusString,"Ab","932","a@stud.com","Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc15() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"21","A","932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc16() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"22",maxString,"932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc17() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"23",max_minusString,"932","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc18() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"24",max_plusString,"932","a@stud.com","Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc19() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"25","Ab","1","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc20() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"26","Ab", String.valueOf(Integer.MAX_VALUE),"a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc21() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"27","Ab", "2","a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc22() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"28","Ab", String.valueOf(Integer.MAX_VALUE-1),"a@stud.com","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc23() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"29","Ab", "345","a","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc24() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"30","Ab", "345",maxString,"Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc25() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"31","Ab", "345","ab","Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc26() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"32","Ab", "345",max_minusString,"Iulia"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc27() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"33","bobo","932",max_plusString,"Iulia"};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc28() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"34","Ab", "345","a","b"};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc29() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"35","Ab", "345","a",maxString};
        service.add(params);
        int size2 = service.getSize();

        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc30() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"36","Ab", "345","a", ""};
        //corectare cod add validare intrumator
        try{
            service.add(params);
        }
        catch (Exception e){}

        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1);
    }
    @Test
    public void tc31() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"37","Ab", "345","a", "bb"};

        service.add(params);

        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1+1);
    }

    @Test
    public void tc32() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"38","Ab", "345","a", max_minusString};

        service.add(params);

        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1+1);
    }
    @Test
    public void tc33() throws ValidatorException {
        int size1 = service.getSize();
        String[] params={"39","bobo","932","dd",max_plusString};
        try {
            service.add(params);
        }
        catch(Exception e) {
            //assertTrue(true);
        }
        int size2 = service.getSize();
        TestCase.assertEquals(size2, size1+1);
    }



}
