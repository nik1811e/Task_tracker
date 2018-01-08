package rest.service;

import org.hibernate.criterion.Criterion;
import rest.entity.Project;

import java.util.List;


public interface Service<T> {
    T create(T entity);
    T update(T entity);
    T delete (Class<T> clazz,Long id);
    T findWithCriteria (Class clazz, Criterion[] criterionArray);
    T getById (Class<T> clazz, Long id);
    List<T> getAll (Class<T> clazz);

}
