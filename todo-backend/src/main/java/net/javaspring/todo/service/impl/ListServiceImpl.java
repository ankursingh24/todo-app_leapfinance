package net.javaspring.todo.service.impl;

import lombok.AllArgsConstructor;
import net.javaspring.todo.dto.ListDto;
import net.javaspring.todo.entitiy.List;
import net.javaspring.todo.mapper.ListMapper;
import net.javaspring.todo.repository.ListRepository;
import net.javaspring.todo.service.ListService;
import org.springframework.stereotype.Service;

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
}
