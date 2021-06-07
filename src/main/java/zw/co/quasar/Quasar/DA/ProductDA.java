/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import java.util.List;
import zw.co.quasar.Quasar.POJOS.Product;

/**
 *
 * @author Mabhena
 */
public interface ProductDA {
    Product getProduct(Long id);
    List<Product> getProducts(Integer page, Integer limit, String sortBy, String direction);
    /*List<Product> searchProduct();
    Boolean addProduct();
    Boolean removeProduct();
    Boolean updateProduct();
    Boolean activateProduct();
    Boolean deactivateProduct();*/
}
