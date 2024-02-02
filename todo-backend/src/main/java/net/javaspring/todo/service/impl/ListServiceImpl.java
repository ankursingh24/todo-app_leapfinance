package net.javaspring.todo.service.impl;

import lombok.AllArgsConstructor;
import net.javaspring.todo.dto.ListDto;
import net.javaspring.todo.entitiy.List;
import net.javaspring.todo.exception.ResourceNotFoundException;
import net.javaspring.todo.mapper.ListMapper;
import net.javaspring.todo.repository.ListRepository;
import net.javaspring.todo.service.ListService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
//tell spring container to create spring beam for the class
public class ListServiceImpl implements ListService {

    private ListRepository listRepository;
    //injected elr as a dependency
    @Override
    public ListDto createList(ListDto listDto) {

        //first convert list dto into list jp entity to store in db
        List list= ListMapper.mapToList(listDto);
        //save in db
         List savedList=listRepository.save(list);
         //return to client


        return ListMapper.mapToListDto(savedList);
    }

    @Override
    public ListDto getListById(Long listId) {
        List list=listRepository.findById((listId))
        .orElseThrow(()->new ResourceNotFoundException("No item present in the list :"  + listId));
        return ListMapper.mapToListDto(list);
    }

    @Override
    public java.util.List<ListDto> getAllLists() {
        java.util.List<List> lists=listRepository.findAll();
        return lists.stream().map((list)->ListMapper.mapToListDto(list))
                .collect(Collectors.toList());

    }

    @Override
    public ListDto updateList(Long listId, ListDto updatedList) {
        List list=listRepository.findById(listId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("item does not exist")
                                        );
        list.setTask(updatedList.getTask());
        list.setDescription(updatedList.getDescription());
        list.setStatus(updatedList.getStatus());

         List updateListObj=listRepository.save(list);

        return ListMapper.mapToListDto(updateListObj);
    }

    @Override
    public void deleteList(Long listId) {
        List list=listRepository.findById((listId))
                .orElseThrow(()->new ResourceNotFoundException("No item present in the list :"  + listId));
         listRepository.deleteById(listId);

    }
}
