package net.javaspring.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ListDto {
    private Long id;
    private String task;
    private String description;
    private Boolean status;

}
