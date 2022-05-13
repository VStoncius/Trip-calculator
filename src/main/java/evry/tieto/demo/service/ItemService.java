package evry.tieto.demo.service;

import evry.tieto.demo.model.CreateItemRequest;
import evry.tieto.demo.model.Item;

import java.util.List;

public interface ItemService {
    public Item saveItem(CreateItemRequest request);

    public Item getItemByName(String name);

    public List<Item> getAllItems();

    public void deleteItem(String name);

    public List<Item> getAllItemsForSeason(String season);
}
