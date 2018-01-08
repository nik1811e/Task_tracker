package rest.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rest.entity.User;

import java.util.List;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class UserServiceImpl extends BaseService<User>{

    @Autowired
    protected SessionFactory sessionFactory;

    public User authenticate (User user) throws Exception{
        Criterion [] criterion = new Criterion[2];
        criterion[0] = Restrictions.eq("email", user.getEmail());
        criterion[1] = Restrictions.eq("password", user.getPassword());
        User userEntity = this.findWithCriteria(User.class,criterion);
        if (userEntity == null) {
         throw new Exception("Invalid credentials");
        }
        return user;
    }
}
