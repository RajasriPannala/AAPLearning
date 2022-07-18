package com.bourntec.aaplearning.modules.inventorymanagement.v1.response;

import java.util.List;

import com.bourntec.aaplearning.entity.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponseDTO {

	private List<Inventory> sort;

    private int totalPages;
    private int pageNumber;
    private int pageSize;
}
