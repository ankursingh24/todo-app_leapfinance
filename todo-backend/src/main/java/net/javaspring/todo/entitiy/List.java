package net.javaspring.todo.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //
@Table(name="lists")


public class List {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="Task",nullable=false)
    private String task;

    @Column(name="Description")
    private String description;

    @Column(name="Status")
    private Boolean status;

}
