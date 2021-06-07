/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar.DA;

/**
 *
 * @author Mabhena
 */
public class TablesDA {
    //CREATE TABLES
    public static final String CREATE_PRODUCT_TABLE  = "CREATE TABLE qzw_product(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30) NOT NULL, category INT, description TEXT, price DECIMAL(9,2) NOT NULL, currency INT NOT NULL) ENGINE=InnoDB;";
    public static final String CREATE_CATEGORY_TABLE = "CREATE TABLE qzw_category(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30) NOT NULL, description TEXT) ENGINE=InnoDB;";
    public static final String CREATE_CURRENCY_TABLE = "CREATE TABLE qzw_currency(id INT AUTO_INCREMENT PRIMARY KEY, iso_code VARCHAR(5), symbol VARCHAR(5), name VARCHAR(30) NOT NULL, rate FLOAT NOT NULL DEFAULT 1, active BOOLEAN NOT NULL DEFAULT FALSE) ENGINE=InnoDB;";
    public static final String CREATE_PRODUCT_IMAGE_TABLE = "CREATE TABLE qzw_product_image(id INT AUTO_INCREMENT PRIMARY KEY, url VARCHAR(255) NOT NULL, length SMALLINT UNSIGNED, width SMALLINT UNSIGNED, product INT) ENGINE=InnoDB;";
    public static final String CREATE_ORDER_TABLE = "CREATE TABLE qzw_order(id INT AUTO_INCREMENT PRIMARY KEY, date_added DATETIME NOT NULL DEFAULT NOW(), user INT, phone VARCHAR(20) NOT NULL, country VARCHAR(50) NOT NULL, email VARCHAR(50), city_town_province VARCHAR(50) NOT NULL, address TEXT NOT NULL) ENGINE=InnoDB;";
    public static final String CREATE_ORDER_ITEM_TABLE = "CREATE TABLE qzw_order_item(id INT AUTO_INCREMENT PRIMARY KEY, product INT NOT NULL, quantity INT NOT NULL DEFAULT 1, price DECIMAL(9,2) NOT NULL, `order` INT NOT NULL, currency INT NOT NULL) ENGINE=InnoDB;";
    public static final String CREATE_PAYMENT_TABLE = "CREATE TABLE qzw_payment(id INT AUTO_INCREMENT PRIMARY KEY, method VARCHAR(30) NOT NULL DEFAULT 'UNKNOWN', currency INT NOT NULL, amount DECIMAL(9,2) NOT NULL, `order` INT NOT NULL, date_added DATETIME NOT NULL DEFAULT NOW()) ENGINE=InnoDB;";
    
    public static final String CREATE_USER_TABLE = "CREATE TABLE qzw_user(id INT AUTO_INCREMENT PRIMARY KEY, first_names VARCHAR(50), last_name VARCHAR(30), password_hash VARCHAR(255) NOT NULL, email VARCHAR(50) UNIQUE NOT NULL, phone VARCHAR(20), gender ENUM('female','male','other'), birth_day DATE, country VARCHAR(50)) ENGINE=InnoDB;";
    public static final String CREATE_AUTO_AUTH_TABLE = "CREATE TABLE qzw_auto_auth(id INT AUTO_INCREMENT PRIMARY KEY, user INT NOT NULL, token_hash VARCHAR(255) NOT NULL, date_created DATETIME NOT NULL DEFAULT NOW()) ENGINE=InnoDB;";
    public static final String CREATE_PASSWORD_RECOVERY_TABLE = "CREATE TABLE qzw_password_recovery(id INT AUTO_INCREMENT PRIMARY KEY, user INT NOT NULL, recovery_key_hash VARCHAR(255) NOT NULL, date_created DATETIME NOT NULL DEFAULT NOW()) ENGINE=InnoDB;";
    public static final String CREATE_SETTINGS_TABLE = "CREATE TABLE qzw_settings(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(10) NOT NULL, value VARCHAR(255) NOT NULL) ENGINE=InnoDB;";
    
}
