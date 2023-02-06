package com.Wipro.Items.Service;

import com.Wipro.Items.Entity.Items;

import java.util.List;

public interface ItemService {

    // Method for creating the item or product
    Items create (Items item);

    // Method to get or display all the items on one go
    List<Items> getAll ();

    // Method to get any item by ID
    Items getById(String itemId);

    Items deleteItem(String itemId);

    Items updateItems(Items item, String itemId);


}
