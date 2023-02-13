package com.Wipro.Items.Controller;

import com.Wipro.Items.Entity.Items;
import com.Wipro.Items.Service.ItemService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    //create
    @PostMapping("/createItem")
    public ResponseEntity<Items> createItem(@RequestBody Items item){

        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(item));
    }

    //getAll
    @GetMapping("/allItems")
    public ResponseEntity <List<Items>> getAllItems(){

        return ResponseEntity.ok(itemService.getAll());
    }


    //getByid
    @GetMapping("/{itemId}")
    public ResponseEntity<Items> getById(@PathVariable String itemId){

        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.getById(itemId));

    }


    @GetMapping("/delete/{itemId}")
    public void deleteItem(@PathVariable String itemId, Principal principal){

        itemService.deleteItem(itemId);

    }

    @PutMapping("/update/{itemId}")
    public void updateItem(@RequestBody Items item, @PathVariable String itemId){
        itemService.updateItems(item,itemId);
    }

}
