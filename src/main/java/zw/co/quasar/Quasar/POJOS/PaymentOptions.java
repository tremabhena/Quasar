/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.POJOS;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mabhena
 */
@Setter @Getter
public class PaymentOptions {
    private List<PaymentMethod> paymentOptions;
}
