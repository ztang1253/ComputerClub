/*  ZTSEAddBookServlet.java
 *  Assignment 4
 * 
 *  Revision History
 *      Zhenzhen Tang, Sydney Dele Enebeli, 2016.03.26: Created
 */

package club.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test the Member class
 * @author Sydney Dele Enebeli
 */
public class ZTSEMemberTest
{
    
    public ZTSEMemberTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getFullName method, of class Member.
     */
    @Test
    public void testGetFullName()
    {        
        System.out.println("getFullName");
        Member instance = new Member();
        String expResult = "John";
        instance.setFullName(expResult);
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFullName method, of class Member.
     */
//    @Test
//    public void testSetFullName()
//    {
//        System.out.println("setFullName");
//        String fullName = "";
//        Member instance = new Member();
//        instance.setFullName(fullName);
//    }

    /**
     * Test of getEmailAddress method, of class Member.
     */
    @Test
    public void testGetEmailAddress()
    {
        System.out.println("getEmailAddress");
        Member instance = new Member();
        String expResult = "ztang1253@conestogac.on.ca";
        instance.setEmailAddress(expResult);
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmailAddress method, of class Member.
     */
//    @Test
//    public void testSetEmailAddress()
//    {
//        System.out.println("setEmailAddress");
//        String emailAddress = "";
//        Member instance = new Member();
//        instance.setEmailAddress(emailAddress);
//    }

    /**
     * Test of getPhoneNumber method, of class Member.
     */
    @Test
    public void testGetPhoneNumber()
    {
        System.out.println("getPhoneNumber");
        Member instance = new Member();
        String expResult = "123-123-1234";
        instance.setPhoneNumber(expResult);
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNumber method, of class Member.
     */
//    @Test
//    public void testSetPhoneNumber()
//    {
//        System.out.println("setPhoneNumber");
//        String phoneNumber = "";
//        Member instance = new Member();
//        instance.setPhoneNumber(phoneNumber);
//    }

    /**
     * Test of getProgramName method, of class Member.
     */
    @Test
    public void testGetProgramName()
    {
        System.out.println("getProgramName");
        Member instance = new Member();
        String expResult = "CPA";
        instance.setProgramName(expResult);
        String result = instance.getProgramName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProgramName method, of class Member.
     */
//    @Test
//    public void testSetProgramName()
//    {
//        System.out.println("setProgramName");
//        String programName = "";
//        Member instance = new Member();
//        instance.setProgramName(programName);
//    }

    /**
     * Test of getYearLevel method, of class Member.
     */
    @Test
    public void testGetYearLevel()
    {
        System.out.println("getYearLevel");
        Member instance = new Member();
        int expResult = 2;
        instance.setYearLevel(expResult);
        int result = instance.getYearLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setYearLevel method, of class Member.
     */
//    @Test
//    public void testSetYearLevel()
//    {
//        System.out.println("setYearLevel");
//        int yearLevel = 0;
//        Member instance = new Member();
//        instance.setYearLevel(yearLevel);
//    }
    
    /**
     * Test of isValid method, of class Member.
     */
    @Test
    public void testValidPositive()
    {
        System.out.println("isValid");
        Member instance = 
                new Member("ztang1253", "ztang1253@conestogac.on.ca");        
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, of class Member.
     */
    @Test
    public void testValidNegative()
    {
        System.out.println("isValid");
        Member instance = new Member();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }    
}
