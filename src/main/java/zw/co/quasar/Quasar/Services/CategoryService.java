/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import zw.co.quasar.Quasar.POJOS.Category;
import java.util.List;

/**
 *
 * @author Mabhena
 */
public interface CategoryService {
    Category getCategory(long categoryId);
    List<Category> getCategories(int page, int limit, String sortBy, String direction);
    /*Boolean addCategory();
    Boolean removeCategory();
    Boolean updateCategory();*/
}
