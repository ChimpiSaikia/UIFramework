package tests;

import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class AnnotationTest {

    @BeforeClass
    public void test1(){
        System.out.println("Before Class Test1");
    }

    @BeforeTest
    public void test2(){
        System.out.println(" Before Test Test2");
    }
    @BeforeMethod
    public void test3(){
        System.out.println("Before Method  Test3");

    }
    @Test
    public void test4() {
        System.out.println("Executing Test4");
        assertTrue(false);
        System.out.println("Executing Test4");
    }

    @Test
    public void test5(){
        System.out.println("Executing Test5");
        assertTrue(false);
        System.out.println("Executing Test5");
    }
    @AfterMethod
    public void test6(){
        System.out.println("After Method Test6");
    }

    @AfterTest
    public void test7(){
        System.out.println(" After Test Test7");
    }
    @AfterClass
    public void test8() {
        System.out.println("After class Test8");

    }
}
