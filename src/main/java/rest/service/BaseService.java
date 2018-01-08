package rest.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import rest.entity.Project;

import java.util.List;

abstract class BaseService<T> implements Service<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Transactional
    @Override
    public T create(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    @Transactional
    @Override
    public T update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        return entity;
    }

    @Transactional
    @Override
    public T delete(Class<T> clazz, Long id) {
        Session session = sessionFactory.getCurrentSession();
        T item = (T) session.byId(clazz).load(id);
        session.delete(item);
        return item;
    }

    @Transactional
    @Override
    public T getById(Class<T> entity, Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (T) session.byId(entity).load(id);
    }

    @Transactional
    @Override
    public T findWithCriteria(Class clazz, Criterion[] criterionArray) {
        Session session = sessionFactory.getCurrentSession();
        final Criteria criteria = session.createCriteria(clazz);
        for (Criterion criterion : criterionArray) {
            criteria.add(criterion);
        }
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (T) criteria.uniqueResult();
    }

    @Transactional
    @Override
    public List<T> getAll(Class<T> entity) {
        Session session = sessionFactory.getCurrentSession();
        return (List<T>) session.createCriteria(entity).list();
    }

}
