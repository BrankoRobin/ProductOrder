ProductsOrder is simple Spring Boot Web Application
can be run within eclipse or the easiest way with command
java -jar ProductsOrders-0.0.1-SNAPSHOT.jar
from /target folder of project 
and run localhost:8080/ in browser

Inmemory database (H@)

2 in memmory users (no admin users)
username : red, password : red
username : blue, password : blue
 
on startup there should be 6 products imported in database

after login user is redirecet to orders page

dropdown selection for products and number imput for quantities are present for entry

Rest APi is implemented through rest controller with 3 services

GET localhost:8080/orders/products
gets a collection of all products

GET localhost:8080/orders/shopping-cart
gets a collection of shopping cart for logged user

POST localhost:8080/orders/add-new-order
saves order item to the shopping cart for logged user