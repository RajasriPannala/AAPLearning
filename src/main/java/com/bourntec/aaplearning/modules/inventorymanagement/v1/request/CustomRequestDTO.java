package com.bourntec.aaplearning.modules.inventorymanagement.v1.request;

import java.util.List;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.entity.SortList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomRequestDTO extends InventoryRequestDTO
{
    private List<Inventory> inventory;
    private List<SortList> sort;
    private Integer page;
    private Integer size;
 
    
}
