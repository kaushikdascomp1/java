package com.interview.java.designpatterns;

import com.interview.java.designpatterns.vendingmachine.VendingMachine;
import com.interview.java.designpatterns.vendingmachine.payment.Payment;
import com.interview.java.designpatterns.vendingmachine.payment.paymentstrategy.CashPayment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VendingMachineTest {

    public VendingMachine vendingMachine;

    //@Autowired
    public Payment payment;

    @BeforeEach
    public void setUp(){
        vendingMachine = new VendingMachine(12);
         payment = new CashPayment();
    }

    @Test
    public void testPurchaseItem1(){
        //given
        int itemNo = 2;
        int amount =12;

        //when
        boolean b = vendingMachine.purchaseItem(itemNo, amount);

        //then
        Assertions.assertTrue(b);
       /* 2020-04-27 21:40:58.991  INFO 39780 --- [           main] c.i.j.d.v.model.VendingMachine           : Item Id not found

        org.opentest4j.AssertionFailedError:
        Expected :true
        Actual   :false*/
    }
}
