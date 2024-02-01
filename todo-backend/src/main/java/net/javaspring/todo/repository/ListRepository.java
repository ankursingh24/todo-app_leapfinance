package net.javaspring.todo.repository;

import net.javaspring.todo.entitiy.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository <List,Long> {


}
