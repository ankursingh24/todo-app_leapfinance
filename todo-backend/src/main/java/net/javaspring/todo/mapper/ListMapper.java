package net.javaspring.todo.mapper;


import net.javaspring.todo.dto.ListDto;
import net.javaspring.todo.entitiy.List;

public class ListMapper {

    public static ListDto mapToListDto (List list) {
        return new ListDto(
                list.getId(),
                list.getTask(),
                list.getDescription(),
                list.getStatus()



        );
    }
    public static List mapToList(ListDto listDto){
        return new List(
                listDto.getId(),
                listDto.getTask(),
                listDto.getDescription(),
                listDto.getStatus()

        );
    }
}
