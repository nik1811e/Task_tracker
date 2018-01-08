package rest.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.Project;


import java.util.List;

@RestController
@RequestMapping(value="/api/projects")
public class ProjectController extends BaseController<Project> {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return super.getById(Project.class, id);
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public List<Project> getAll() {
        return super.getAll(Project.class);
    }
}
