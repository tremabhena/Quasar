/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import zw.co.quasar.Quasar.POJOS.Product;
import java.util.List;

/**
 *
 * @author Mabhena
 */
public interface ProductDA {
    Product getProduct();
    List<Product> getProducts();
    List<Product> searchProduct();
    Boolean addProduct();
    Boolean removeProduct();
    Boolean updateProduct();
    Boolean activateProduct();
    Boolean deactivateProduct();
}
