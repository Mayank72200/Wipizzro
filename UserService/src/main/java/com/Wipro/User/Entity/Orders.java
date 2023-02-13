package com.Wipro.User.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    private String orderId;
    private String userId;
    private String Type;
    private String Time;
    private String itemId;

    private List<Items> items = new ArrayList<>();


}
