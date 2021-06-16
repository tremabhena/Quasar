/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import zw.co.quasar.Quasar.DbTables;
import zw.co.quasar.Quasar.POJOS.Category;

/**
 *
 * @author Mabhena
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private final RowMapper<Category> rowMapper = (resultSet, rowNum)->{
                    Category newCategory = new Category();
                    newCategory.setId(resultSet.getInt(DbTables.Category.COLUMN_ID));
                    newCategory.setDescription(resultSet.getString(DbTables.Category.COLUMN_DESCRIPTION));
                    newCategory.setName(resultSet.getString(DbTables.Category.COLUMN_NAME));
                    
                    return newCategory;
                };
    
    @Override
    public Category getCategory(long categoryId){
        String query = "SELECT * FROM " + DbTables.Category.TABLE_NAME + " WHERE " + DbTables.Category.COLUMN_ID + " = ?";
        Category category = jdbcTemplate.queryForObject(query,
                rowMapper
                , categoryId);
        return category;
    }
    
    @Override
    public List<Category> getCategories(int page, int limit, String sortBy, String direction){
        if(!(direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc"))) direction = "";
        if(!(sortBy.equalsIgnoreCase("price")||sortBy.equalsIgnoreCase("name")||sortBy.equalsIgnoreCase("category"))) sortBy = "id";
        
        List<Category> categories = jdbcTemplate.query("SELECT * FROM " + DbTables.Category.TABLE_NAME + " ORDER BY ? ? LIMIT ?,?",
                rowMapper
                ,sortBy, direction, page, limit);
        
        return categories;
    }
}
