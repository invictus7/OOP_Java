package GraspPatterns.UnitTest;
import GraspPatterns.Register;
import static org.junit.Assert.*;

import GraspPatterns.SalesDepartment.Sale;
import GraspPatterns.SalesDepartment.SalesLineItem;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;


public class TestClass {

private  Register reg;

@Before
public void init(){
List<Sale> saleList = Collections.singletonList(new Sale());
reg = new Register(saleList);



}
@Test
public void testMakePayment(){

  //  boolean test1 = reg.makePaymentDel();
}



}
