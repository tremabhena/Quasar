/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import zw.co.quasar.Quasar.POJOS.Category;
import java.util.List;

/**
 *
 * @author Mabhena
 */
public interface CategoryDA {
    Category getCategory();
    List<Category> getCategories();
    Boolean addCategory();
    Boolean removeCategory();
    Boolean updateCategory();
}
