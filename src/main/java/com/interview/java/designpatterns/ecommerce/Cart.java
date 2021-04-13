package com.interview.java.designpatterns.ecommerce;

import java.util.List;
import java.util.Map;

public abstract class Cart {

   Map<Product, Integer> items;


   abstract boolean createUpdateProd(Product product, int qty);
   //This will add/update the product in the map with the qty

    abstract boolean removeProduct(Product product);



}
