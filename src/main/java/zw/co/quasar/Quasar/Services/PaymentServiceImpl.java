/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import zw.co.quasar.Quasar.POJOS.PaymentMethod;
import zw.co.quasar.Quasar.POJOS.PaymentOptions;

/**
 *
 * @author Mabhena
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public List<PaymentMethod> getPaymentMethods(){
        List<PaymentMethod> list = new ArrayList<>();
        list.add(getPaynow());
        list.add(getCOD());
        return list;
    }
    
    @Override
    public PaymentOptions getPaymentOptions(){
        PaymentOptions po = new PaymentOptions();
        po.setPaymentOptions(getPaymentMethods());
        return po;
    }
    
    private PaymentMethod getPaynow(){
        PaymentMethod pm = new PaymentMethod();
        pm.setId("pnw");
        pm.setName("Paynow");
        pm.setDescription("Paynow Zimbabwe");
        return pm;
    }
    
    private PaymentMethod getCOD(){
        PaymentMethod pm = new PaymentMethod();
        pm.setId("cod");
        pm.setName("Cash-on-Delivery");
        pm.setDescription("Pay on delivery");
        return pm;
    }
}
