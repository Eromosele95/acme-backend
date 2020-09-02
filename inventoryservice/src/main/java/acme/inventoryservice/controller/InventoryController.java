package acme.inventoryservice.controller;


import acme.inventoryservice.models.Item;
import acme.inventoryservice.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @CrossOrigin
    @RequestMapping(value = "/AllItems", method = RequestMethod.GET)
    public ResponseEntity<?> getAllArticles() throws InvocationTargetException, IllegalAccessException {

        List<Item> itemList = this.inventoryService.getAllArticles();

        HttpStatus status = itemList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<List<Item>>(itemList,status);
    }
}
