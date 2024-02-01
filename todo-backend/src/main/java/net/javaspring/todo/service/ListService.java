package net.javaspring.todo.service;

import net.javaspring.todo.dto.ListDto;

public interface ListService {
    ListDto createList(ListDto listDto);
}
