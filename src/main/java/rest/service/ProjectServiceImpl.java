package rest.service;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rest.entity.Project;

@Repository
@Transactional
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ProjectServiceImpl  extends BaseService<Project> {

}
