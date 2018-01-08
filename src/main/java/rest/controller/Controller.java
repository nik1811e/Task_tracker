package rest.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.Project;

import java.util.List;

public interface Controller<T> {

    @RequestMapping(value = "", method = RequestMethod.POST)
    ResponseEntity create(@RequestBody T entity);

    @RequestMapping(value="",method = RequestMethod.PUT)
    ResponseEntity update (@RequestBody T entity);

    ResponseEntity delete (Class<T> clazz,@PathVariable("id") Long id);

    ResponseEntity getById (Class<T> clazz, @PathVariable("id") Long id);

    List<T> getAll (Class<T> clazz);

    ResponseEntity addProject(@RequestBody T entity);
}
