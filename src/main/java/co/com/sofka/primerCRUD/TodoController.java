package co.com.sofka.primerCRUD;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return  service.list();
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != 0){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");

    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathParam("id")long id) {
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathParam("id") Long id){
        return service.get(id);
    }



}
