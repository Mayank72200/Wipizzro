package com.Wipro.Items.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItems {

    @Id
    private String OrderId;
    @ManyToMany
    private List<Items> orderItemsId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
