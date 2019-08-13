package com.jamith.absd.posangularspringboot.contoller;

import com.jamith.absd.posangularspringboot.dto.ItemDTO;
import com.jamith.absd.posangularspringboot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/get-all")
    @ResponseBody
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }

    @PostMapping("/save")
    public boolean saveItem(@RequestBody ItemDTO itemDTO){
        return itemService.saveItem(itemDTO);
    }

    @PostMapping("/update")
    public boolean updateItem(@RequestBody ItemDTO itemDTO){
        return itemService.updateItem(itemDTO);
    }

    @PostMapping("/delete")
    public boolean deleteItem(@RequestBody String code){
        return itemService.deleteItem(code);
    }
}
