package net.javaspring.todo.entitiy;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name="Task" ,unique=true)
    @NonNull
    private String task;

    @Column(name="Description")
    private String description;

    @Column(name="Status")
    @PrePersist
    void preInsert() {
        if (this.status == null)
            this.status = "Not Completed";
    }
    private String status;

}
