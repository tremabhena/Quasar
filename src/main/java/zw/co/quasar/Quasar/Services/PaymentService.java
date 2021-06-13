/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.List;
import zw.co.quasar.Quasar.POJOS.PaymentMethod;
import zw.co.quasar.Quasar.POJOS.PaymentOptions;

/**
 *
 * @author Mabhena
 */
public interface PaymentService {
   public List<PaymentMethod> getPaymentMethods();
   public PaymentOptions getPaymentOptions();
}
