package com.jamith.absd.posangularspringboot.service.impl;

import com.jamith.absd.posangularspringboot.dto.ItemDTO;
import com.jamith.absd.posangularspringboot.entity.Item;
import com.jamith.absd.posangularspringboot.repository.ItemRepository;
import com.jamith.absd.posangularspringboot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream().map(Item::getItemDTO).collect(Collectors.toList());
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) {
        try {
            Item item = new Item();
            item.setCode(itemDTO.getCode());
            item.setName(itemDTO.getName());
            item.setDescription(itemDTO.getDescription());
            item.setUnitPrice(itemDTO.getPrice());
            item.setQtyOnHand(itemDTO.getQty());
            itemRepository.save(item);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) {
        try {
            Item exists = itemRepository.findTopByCode(itemDTO.getCode());
            if (exists!=null){
                exists.setName(itemDTO.getName());
                exists.setDescription(itemDTO.getDescription());
                exists.setQtyOnHand(itemDTO.getQty());
                exists.setUnitPrice(itemDTO.getPrice());
                itemRepository.save(exists);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteItem(String code) {
        try {
            Item topByCode = itemRepository.findTopByCode(code);
            if (topByCode!=null){
                itemRepository.delete(topByCode);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
