package com.example.demo.service;

import com.example.demo.domain.ToDo;
import com.example.demo.dto.ToDoDto;
import com.example.demo.exception.NotFoundToDo;
import com.example.demo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public void save(ToDoDto toDoDto) {
        ToDo toDo = new ToDo(toDoDto.getTitle(), toDoDto.getContent());
        toDoRepository.save(toDo);
    }

    public ToDoDto findToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new NotFoundToDo("존재하는 toDo가 없습니다."));

        return new ToDoDto(toDo.getTitle(), toDo.getContent());
    }

    public boolean delete(Long id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);

        if (toDo.isPresent()) {
            toDoRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public ToDoDto update(Long id, ToDoDto toDoDto) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new NotFoundToDo("존재하는 toDo가 없습니다."));

        toDo.changeTitle(toDoDto.getTitle());
        toDo.changeContent(toDoDto.getContent());
        return new ToDoDto(toDo.getTitle(), toDo.getContent());
    }

}
