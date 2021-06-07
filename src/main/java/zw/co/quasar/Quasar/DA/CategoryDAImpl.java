/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import zw.co.quasar.Quasar.POJOS.Category;

/**
 *
 * @author Mabhena
 */
public class CategoryDAImpl implements CategoryDA {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Category> rowMapper = (resultSet, rowNum)->{
                    Category newCategory = new Category();
                    newCategory.setId(resultSet.getLong("id"));
                    newCategory.setDescription(resultSet.getString("description"));
                    newCategory.setName(resultSet.getString("name"));
                    
                    return newCategory;
                };
    
    @Override
    public Category getCategory(Long categoryId){
        String query = "SELECT id, name, description FROM qzw_category WHERE id = ?";
        Category category = jdbcTemplate.queryForObject(query,
                rowMapper
                ,categoryId);
        return category;
    }
    
    @Override
    public List<Category> getCategories(Integer page, Integer limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Category> categories = jdbcTemplate.query("SELECT id, name, description FROM qzw_category ORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,sortBy, direction, page, limit);
        
        return categories;
    }
}
