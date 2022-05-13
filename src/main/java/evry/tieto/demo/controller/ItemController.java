package evry.tieto.demo.controller;

import evry.tieto.demo.model.CreateItemRequest;
import evry.tieto.demo.model.Item;
import evry.tieto.demo.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody CreateItemRequest request) {
        return new ResponseEntity<>(itemService.saveItem(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping("/{season}")
    public ResponseEntity<List<Item>> getAllItemsForSeason(@PathVariable String season) {
        return new ResponseEntity<>(itemService.getAllItemsForSeason(season), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Item> getItem(@RequestBody String name) {
        return new ResponseEntity<>(itemService.getItemByName(name), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItem(@RequestParam String name) {
        itemService.deleteItem(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
