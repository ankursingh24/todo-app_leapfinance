package net.javaspring.todo.controller;

import lombok.AllArgsConstructor;
import net.javaspring.todo.dto.ListDto;
import net.javaspring.todo.service.ListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor //instead to create constructor manually
@RestController
//class is capable to make http request
@RequestMapping("/api/lists")
//to define base url for all https
public class ListController {
    //inject dependencies
    private ListService listService;

    //Build add list RestApi
    @PostMapping
    public ResponseEntity<ListDto> createList(@RequestBody ListDto listDto) {
        //rd extracts json from http request and convert it into listdto
        ListDto savedList = listService.createList(listDto);
        return new ResponseEntity<>(savedList, HttpStatus.CREATED);
    }


//build Get list RestApi
//we just need to create a method and then convert that method into rest api by spring annotations

    @GetMapping("{id}")
//map incoming http  get request to this method
    public ResponseEntity<ListDto> getListById(@PathVariable("id") Long listId) {
        ListDto listDto = listService.getListById(listId);
        return ResponseEntity.ok(listDto);



    }


    //Build GetAll List RestApi
    @GetMapping
    public  ResponseEntity<List<ListDto>> getALlLists(){
        List<ListDto> lists=listService.getAllLists();
        return ResponseEntity.ok(lists);
    }

    //Build Update List RestApi

    @PutMapping("{id}")
    //make this method as http by spring annotations
    public ResponseEntity<ListDto> updateList(@PathVariable("id") Long listId,
                                              @RequestBody ListDto updatedList){
        //pv- bind the ui template variable to method arg,rb-extract the updated json from req and convert  int a java object
        ListDto listDto=listService.updateList(listId,  updatedList);
        return ResponseEntity.ok(listDto);
    }


    //  build Delete  List
    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteList(@PathVariable("id") Long listID){
        listService.deleteList(listID);
        return ResponseEntity.ok("Task deleted  successfully!");

    }
}
