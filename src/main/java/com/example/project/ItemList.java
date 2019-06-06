package com.example.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ItemList {
    private HashMap<String, Item> items=new HashMap<>();

    public String addItems(String itemName, String description, String deadLine){
        if(this.items==null || !this.items.containsKey(itemName)){
            try {
                Item item = new Item(itemName, description,deadLine);
                this.items.put(itemName, item);
                return "TODO liste eklenmiştir";
            }catch(Exception ex){
                return "Ekleme gerçekleşmedi lütfen tekrar denyiniz";
            }
        }else{
            return "bu isim daha önce kullanılmıştır başka bir isim vermelisiniz";
        }
    }

    public String deleteItem(String itemName){
        try {
            if (this.items.containsKey(itemName)) {
                this.items.remove(itemName);
                return "silme gerçekleşti";
            }else{
                return "silme gerçekleşmedi";
            }
        }catch (Exception ex){
            return "silme gerçekleşmedi";
        }
    }

    public String updateItem(String itemName){
        try {
            if (this.items.containsKey(itemName)) {
                this.items.get(itemName).UpdateItem();
                return "status update gerçekleşti";
            }else{
                return "status update gerçekleşmedi";
            }
        }catch (Exception ex){
            return "status update gerçekleşmedi";
        }
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
}
