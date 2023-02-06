package com.Wipro.Items.Service.Impl;

import com.Wipro.Items.Entity.Items;
import com.Wipro.Items.Exceptions.ResourceNotFoundException;
import com.Wipro.Items.Repository.ItemsRepository;
import com.Wipro.Items.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsRepository itemRepo;

    @Override
    public Items create(Items item) {
        String itemId = UUID.randomUUID().toString();
        item.setItemId(itemId);
        return itemRepo.save(item);
    }

    @Override
    public List<Items> getAll() {
        return itemRepo.findAll();
    }

    @Override
    public Items getById(String itemId) {
        return itemRepo.findById(itemId).orElseThrow(() ->new ResourceNotFoundException("Item not found !"));
    }

    @Override
    public Items deleteItem(String itemId) {
        Items item = itemRepo.findById(itemId).get();
        itemRepo.deleteById(itemId);
        return item;
    }

    @Override
    public Items updateItems(Items item, String itemId) {
        itemRepo.save(item);
        Items itemup=itemRepo.getById(itemId);
        return itemup;

    }
}
