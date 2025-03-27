package com.example.demo.Controller;

import com.example.demo.dto.ToDoDto;
import com.example.demo.exception.NotFoundToDo;
import com.example.demo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping("/todo")
    public ResponseEntity<ToDoDto> saveToDo(@RequestBody ToDoDto toDoDto) {
        toDoService.save(toDoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoDto);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<?> getToDo(@PathVariable Long id) {
        try {
            ToDoDto toDoDto = toDoService.findToDo(id);
            return ResponseEntity.status(HttpStatus.OK).body(toDoDto);
        } catch (NotFoundToDo notFoundToDo) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", notFoundToDo.getMessage()));
        }
    }
}
