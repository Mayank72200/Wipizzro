package com.Wipro.Items.Repository;

import com.Wipro.Items.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items,String> {

    //Implement custom methods or queries

}
