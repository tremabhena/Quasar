/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import zw.co.quasar.Quasar.POJOS.Image;

/**
 *
 * @author Mabhena
 */
public class ImageDAImpl implements ImageDA{
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Image> getProductImages(Long productId){
        List<Image> images = jdbcTemplate.query("SELECT id, url, width, height FROM qzw_product_image WHERE product = ?",
        (resultSet, rowNum) ->{
            Image image = new Image();
            image.setId(resultSet.getLong("id"));
            image.setHeight(resultSet.getShort("height"));
            image.setWidth(resultSet.getShort("width"));
            image.setUrl(resultSet.getString("url"));
            
            return image;
        }, productId);
        
        return images;
    }
}
