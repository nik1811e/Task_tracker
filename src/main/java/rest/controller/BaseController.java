package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import rest.service.Service;

import java.util.List;

abstract class BaseController<T> implements Controller<T> {

    @Autowired
    private Service<T> service;

    @Override
    public ResponseEntity create(@RequestBody T entity) {
        try {
            T createdEntity = service.create(entity);
            return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ResponseEntity update(T entity) {
        try {
            T updatedEntity = service.update(entity);
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ResponseEntity delete (Class<T> clazz,Long id){
        T deletedEntity = service.delete(clazz,id);
        return new ResponseEntity<>(deletedEntity,HttpStatus.OK);
    }

    @Override
    public ResponseEntity getById(Class<T> clazz, Long id){
        T entity = service.getById(clazz,id);
        return new ResponseEntity<>(entity,HttpStatus.OK);
    }

    @Override
    public List<T> getAll(Class<T> clazz) {
        List<T> list = service.getAll(clazz);
        return list;
    }

    @Override
    public ResponseEntity addProject(T entity) {
        return null;
    }
    
}
