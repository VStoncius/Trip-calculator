package evry.tieto.demo.service.implementations;

import evry.tieto.demo.model.CreateItemRequest;
import evry.tieto.demo.model.Item;
import evry.tieto.demo.repository.ItemRepository;
import evry.tieto.demo.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepo;

    public ItemServiceImpl(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    @PostConstruct
    public void runAfterObjectCreated() { //this is used only for testing purposes
        itemRepo.save(new Item("Warm gloves", false, true, 0));
        itemRepo.save(new Item("Backpack", true, true, 10));
        itemRepo.save(new Item("Sunscreen", true, false, 0));
        itemRepo.save(new Item("Sunglasses", true, false, 0));
        itemRepo.save(new Item("Hiking boots", true, true, 15));
    }

    @Override
    @Transactional
    public Item saveItem(CreateItemRequest request){
        if (request.getTripLongerThan() < 5) {
            request.setTripLongerThan(5);
        }
        return itemRepo.save(new Item(request.getName(), request.isUsedInSummer(), request.isUsedInWinter(), request.getTripLongerThan()));
    }

    @Override
    public Item getItemByName(String name) {
        return itemRepo.findByName(name);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public void deleteItem(String name){
        itemRepo.delete(itemRepo.findByName(name)); //this will need error handling
    }

    public List<Item> getAllItemsForWinter() {
        return itemRepo.findByUsedInWinterTrue();
    }

    public List<Item> getAllItemsForSummer() {
        return itemRepo.findByUsedInSummerTrue();
    }

    @Override
    public List<Item> getAllItemsForSeason(String season) {
        List<Item> result = null;
        switch (season.toLowerCase()){
            case "summer":
                result = getAllItemsForSummer();
            case "winter":
                result = getAllItemsForWinter();
        }
        return result;
    }
}
