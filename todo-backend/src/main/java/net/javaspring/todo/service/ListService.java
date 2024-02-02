package net.javaspring.todo.service;

import net.javaspring.todo.dto.ListDto;

import java.util.List;

public interface ListService {
    ListDto createList(ListDto listDto);
    ListDto getListById(Long listId);

    List<ListDto> getAllLists();
    /* type of value return type */

    ListDto updateList(Long listId,ListDto updatedList );

    void deleteList(Long listId);
}
