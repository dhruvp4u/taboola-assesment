-- Products Table
CREATE TABLE `products` (
    `product_id` int(11) NOT NULL AUTO_INCREMENT,
    `product_name` varchar(255) NOT NULL,
    `product_category` varchar(255) NOT NULL,
     PRIMARY KEY (`product_id`)
);

-- Product Price History Table
CREATE TABLE `product_price_history` (
     `product_price_history_id` int(11) NOT NULL AUTO_INCREMENT,
     `product_id` int(11) NOT NULL,
     `product_price` decimal(10,2) NOT NULL,
     `product_price_start_date` date NOT NULL,
     `product_price_end_date` date DEFAULT NULL,
      PRIMARY KEY (`product_price_history_id`),
      FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
)

-- To get all the price values for all the products
SELECT p.product_id, p.product_name, p.product_category, pp.product_price,
       pp.product_price_start_date, pp.product_price_end_date
FROM products AS p
INNER JOIN product_price_history AS pp
ON p.product_id = pp.product_id;

-- To get current price for all the products
SELECT p.product_id, p.product_name, p.product_category, pp.product_price,
       pp.product_price_start_date, pp.product_price_end_date
FROM products AS p
INNER JOIN product_price_history AS pp
ON p.product_id = pp.product_id
WHERE pp.product_price_end_date IS NULL;