package com.jamith.absd.posangularspringboot.service;

import com.jamith.absd.posangularspringboot.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    List<ItemDTO> getAllItems();

    boolean saveItem(ItemDTO itemDTO);

    boolean updateItem(ItemDTO itemDTO);

    boolean deleteItem(String code);
}
