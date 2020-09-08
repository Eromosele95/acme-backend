package acme.inventoryservice.controller;


import acme.inventoryservice.models.Item;
import acme.inventoryservice.services.InventoryService;
import acme.inventoryservice.services.MailService;
import acme.inventoryservice.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    MailService mailService;

    @Autowired
    ValidationService validationservice;


    @CrossOrigin
    @RequestMapping(value = "/AllItems", method = RequestMethod.GET)
    public ResponseEntity<?> getAllArticles() throws InvocationTargetException, IllegalAccessException {

        List<Item> itemList = this.inventoryService.getAllArticles();

        HttpStatus status = itemList.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<List<Item>>(itemList,status);
    }


    @CrossOrigin
    @RequestMapping(value="/checkout", method = RequestMethod.POST)
    public HttpStatus checkout(@RequestBody Map<String, ?> body) {
        HttpStatus status = HttpStatus.BAD_REQUEST;


         if (validationservice.isEmailValid((String) body.get("email"))){

             StringBuilder stringBuilder = new StringBuilder();

             stringBuilder.append("Hello! Thank you for shopping with ACME. " +
                     "Here are your items and your receipts: \n");

             System.out.println(body.keySet());
             System.out.println(body.values());

             for(Map.Entry<String,?> entry: body.entrySet()){
                 if (!entry.getKey().equals("total_amount")&&!entry.getKey().equals("email")){
                     stringBuilder.append(" "+entry.getKey() + " " + entry.getValue() + "\n");
                 }

                 if (entry.getKey().equals("total_amount")){
                     stringBuilder.append(" And your total amount is: " +  "$"+entry.getValue());
                 }

             }



             mailService.sendSimpleMessage(((String) body.get("email")),"Your order from ACME",stringBuilder.toString());
             status=HttpStatus.OK;


         }
         return status;
    }

}
