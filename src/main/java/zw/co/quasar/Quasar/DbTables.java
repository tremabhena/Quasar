/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar;

/**
 *
 * @author Mabhena
 */
public class DbTables {
    public static final String MYSQL_ENGINE = "ENGINE=InnoDB;";
    public static final String CS = ", ";
    
    class HasId{
        public static final String COLUMN_ID = "`id`";
        static final String ID_DEF = COLUMN_ID + " INT AUTO_INCREMENT PRIMARY KEY";
    }
    
    class HasPrice extends HasId{
        public static final String COLUMN_USD_PRICE = "usd_price";
        static final String USD_PRICE_DEF = COLUMN_USD_PRICE + " DECIMAL(9,2) NOT NULL";
    }
    public class Product extends HasPrice{
        public static final String TABLE_NAME = "qzw_product";
        
        public static final String COLUMN_NAME = "`name`";
        static final String NAME_DEF = COLUMN_NAME + " VARCHAR(30) NOT NULL";
        
        public static final String COLUMN_CATEGORY = "`category`";
        static final String CATEGORY_DEF = COLUMN_CATEGORY + " INT";
        
        public static final String COLUMN_DESCRIPTION = "`description`";
        static final String DESCRIPTION_DEF = COLUMN_DESCRIPTION + " TEXT";
        
        public static final String COLUMN_QUANTITY = "`quantity`";
        static final String QUANTITY_DEF = COLUMN_QUANTITY + " INT NOT NULL DEFAULT 1";
        
        public static final String COLUMN_ACTIVE = "`active`";
        static final String ACTIVE_DEF = COLUMN_ACTIVE + " BOOLEAN NOT NULL DEFAULT TRUE";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + NAME_DEF + CS + USD_PRICE_DEF + CS + CATEGORY_DEF + CS + DESCRIPTION_DEF + CS + QUANTITY_DEF + CS + ACTIVE_DEF + ") " + MYSQL_ENGINE;
    }
    public class Category extends HasId{
        public static final String TABLE_NAME = "qzw_category";
        
        public static final String COLUMN_NAME = "`name`";
        static final String NAME_DEF = COLUMN_NAME + " VARCHAR(30) NOT NULL";
        
        public static final String COLUMN_DESCRIPTION = "`description`";
        static final String DESCRIPTION_DEF = COLUMN_DESCRIPTION + " TEXT";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + NAME_DEF + CS + DESCRIPTION_DEF +") "+ MYSQL_ENGINE;
    }
    public class Currency extends HasId{
        public static final String TABLE_NAME = "qzw_currency";
        
        public static final String COLUMN_ISO_CODE = "`iso_code`";
        static final String ISO_CODE_DEF = COLUMN_ISO_CODE + " CHAR(3) NOT NULL";
        
        public static final String COLUMN_SYMBOL = "`symbol`";
        static final String SYMBOL_DEF = COLUMN_SYMBOL + " INT";
        
        public static final String COLUMN_NAME = "`name`";
        static final String NAME_DEF = COLUMN_NAME + " VARCHAR(30) NOT NULL";
        
        public static final String COLUMN_RATE = "`rate`";
        static final String RATE_DEF = COLUMN_RATE + " FLOAT NOT NULL DEFAULT 1";
        
        public static final String COLUMN_ACTIVE = "`active`";
        static final String ACTIVE_DEF = COLUMN_ACTIVE + " active BOOLEAN NOT NULL DEFAULT FALSE";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" +ID_DEF + CS + ISO_CODE_DEF + CS + SYMBOL_DEF + CS + RATE_DEF + CS + ACTIVE_DEF + ") "+ MYSQL_ENGINE;
    }
    public class ProductImage extends HasId{
        public static final String TABLE_NAME = "qzw_product_image";
        
        public static final String COLUMN_URL = "`url`";
        static final String URL_DEF = COLUMN_URL + " VARCHAR(255) NOT NULL";
        
        public static final String COLUMN_HEIGHT = "`length`";
        static final String HEIGHT_DEF = COLUMN_HEIGHT + " SMALLINT UNSIGNED";
        
        public static final String COLUMN_WIDTH = "`width`";
        static final String WIDTH_DEF = COLUMN_WIDTH + " SMALLINT UNSIGNED";
        
        public static final String COLUMN_PRODUCT = "`product`";
        static final String PRODUCT_DEF = COLUMN_PRODUCT  + " INT";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + URL_DEF + CS + HEIGHT_DEF + CS + WIDTH_DEF + CS + PRODUCT_DEF + ") "+ MYSQL_ENGINE;
    }
    public class Order extends HasId{
        public static final String TABLE_NAME = "qzw_order";
        
        public static final String COLUMN_DATE_ADDED = "`date_added`";
        static final String DATE_ADDED_DEF = COLUMN_DATE_ADDED + " DATETIME NOT NULL DEFAULT NOW()";
        
        public static final String COLUMN_USER = "`user`";
        static final String USER_DEF = COLUMN_USER +  " INT";
        
        public static final String COLUMN_FULFILLED = "`fulfilled`";
        static final String FULFILLED_DEF = COLUMN_FULFILLED + " BOOLEAN";
        
        public static final String COLUMN_FULL_NAME = "`full_name`";
        static final String FULL_NAME_DEF = COLUMN_FULL_NAME + " VARCHAR(100) NOT NULL";
        
        public static final String COLUMN_PHONE = "`phone`";
        static final String PHONE_DEF = COLUMN_PHONE + " VARCHAR(20) NOT NULL";
        
        public static final String COLUMN_COUNTRY = "`country`";
        static final String COUNTRY_DEF = COLUMN_COUNTRY + " VARCHAR(50) NOT NULL";
        
        public static final String COLUMN_EMAIL = "`email`";
        static final String EMAIL_DEF = COLUMN_EMAIL + " VARCHAR(50)";
        
        public static final String COLUMN_CTP = "`country_town_province`";
        static final String CTP_DEF = COLUMN_CTP + " VARCHAR(50) NOT NULL";
        
        public static final String COLUMN_ADDRESS = "`address`";
        static final String ADDRESS_DEF = COLUMN_ADDRESS + " TEXT NOT NULL";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + FULL_NAME_DEF + CS + DATE_ADDED_DEF + CS + USER_DEF + CS + PHONE_DEF + CS + COUNTRY_DEF + CS + EMAIL_DEF + CS + CTP_DEF + CS + ADDRESS_DEF + ") "+ MYSQL_ENGINE;
    }
    public class OrderItem extends HasPrice{
        public static final String TABLE_NAME = "qzw_order_item";
        
        public static final String COLUMN_PRODUCT = "`product`";
        static final String PRODUCT_DEF = COLUMN_PRODUCT + " INT NOT NULL";
        
        public static final String COLUMN_QUANTITY = "`quantity`";
        static final String QUANTITY_DEF = COLUMN_QUANTITY + " INT NOT NULL DEFAULT 1";
        
        public static final String COLUMN_ORDER = "`order`";
        static final String ORDER_DEF = COLUMN_ORDER + " INT NOT NULL";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + PRODUCT_DEF + CS + USD_PRICE_DEF + CS +QUANTITY_DEF + CS + ORDER_DEF + ") "+ MYSQL_ENGINE;
    }
    public class Payment extends HasId{
        public static final String TABLE_NAME = "qzw_payment";
        
        public static final String COLUMN_METHOD = "`method`";
        static final String METHOD_DEF = COLUMN_METHOD + " VARCHAR(30) NOT NULL DEFAULT 'UNKNOWN'";
        
        public static final String COLUMN_CURRENCY = "`currency`";
        static final String CURRENCY_DEF = COLUMN_CURRENCY + " INT NOT NULL";
        
        public static final String COLUMN_ORDER = "`order`";
        static final String ORDER_DEF = COLUMN_ORDER + " INT NOT NULL";
        
        public static final String COLUMN_DATE_ADDED = "`date_added`";
        static final String DATE_ADDED_DEF = COLUMN_DATE_ADDED + " DATETIME NOT NULL DEFAULT NOW()";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" +ID_DEF + CS + METHOD_DEF + CS + CURRENCY_DEF + CS + ORDER_DEF + CS + DATE_ADDED_DEF + ") "+ MYSQL_ENGINE;
    }
    public class User extends HasId{
        public static final String TABLE_NAME = "qzw_user";
        
        public static final String COLUMN_FIRST_NAMES = "`first_names`";
        static final String FIRST_NAMES_DEF = COLUMN_FIRST_NAMES + " VARCHAR(50)";
        
        public static final String COLUMN_LAST_NAME = "`last_name`";
        static final String LAST_NAME_DEF = COLUMN_LAST_NAME + " VARCHAR(30)";
        
        public static final String COLUMN_PASSWORD_HASH = "`password_hash`";
        static final String PASSWORD_HASH_DEF = COLUMN_PASSWORD_HASH + " VARCHAR(255) NOT NULL";
        
        public static final String COLUMN_EMAIL = "`email`";
        static final String EMAIL_DEF = COLUMN_EMAIL + " VARCHAR(50) UNIQUE NOT NULL";
        
        public static final String COLUMN_PHONE = "`phone`";
        static final String PHONE_DEF = COLUMN_PHONE + " VARCHAR(20)";
        
        public static final String COLUMN_GENDER = "`gender`";
        static final String GENDER_DEF = " ENUM('female','male','other')";
        
        public static final String COLUMN_BIRTHDAY = "`birthday`";
        static final String BIRTHDAY_DEF = " DATE";
        
        public static final String COLUMN_COUNTRY = "`country`";
        static final String COUNTRY_DEF = COLUMN_COUNTRY + " VARCHAR(50)";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + FIRST_NAMES_DEF + CS + LAST_NAME_DEF + CS + PASSWORD_HASH_DEF + CS + EMAIL_DEF + CS + PHONE_DEF + CS + GENDER_DEF + CS + BIRTHDAY_DEF + CS + COUNTRY_DEF + ") "+ MYSQL_ENGINE;
    }
    public class PasswordRecovery extends HasId{
        public static final String TABLE_NAME = "qzw_password_recovery";
        
        public static final String COLUMN_USER = "`user`";
        static final String USER_DEF = COLUMN_USER + " INT NOT NULL";
        
        public static final String COLUMN_RECOVERY_KEY_HASH = "`recovery_key_hash`";
        static final String RECOVERY_KEY_HASH_DEF = COLUMN_RECOVERY_KEY_HASH + " VARCHAR(255) NOT NULL";
        
        public static final String COLUMN_DATE_CREATED = "`date_created`";
        static final String DATE_CREATED_DEF = COLUMN_DATE_CREATED + " DATETIME NOT NULL DEFAULT NOW()";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + USER_DEF + CS + RECOVERY_KEY_HASH_DEF + CS + DATE_CREATED_DEF + ") "+ MYSQL_ENGINE;
    }
    public class Settings extends HasId{
        public static final String TABLE_NAME = "qzw_settings";
        
        public static final String COLUMN_NAME = "`name`";
        static final String NAME_DEF = COLUMN_NAME + " VARCHAR(10) NOT NULL";
        
        public static final String COLUMN_VALUE = "`value`";
        static final String  VALUE_DEF = COLUMN_VALUE + " VARCHAR(255) NOT NULL";
        
        public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" + ID_DEF + CS + NAME_DEF + CS + VALUE_DEF + ") "+ MYSQL_ENGINE;
    }
    
    
}
