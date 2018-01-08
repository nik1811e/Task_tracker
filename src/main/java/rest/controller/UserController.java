package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.User;
import rest.service.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "api/users")
public class UserController extends BaseController<User>{

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity auth(HttpServletResponse response, @RequestBody() User user) throws Exception {
        User userEntity = userService.authenticate(user);
        response.addCookie(new Cookie("userRole", userEntity.getRole()));
        response.sendRedirect("/panel.html");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="",method = RequestMethod.DELETE)
    public ResponseEntity delete (@RequestParam("id") Long id){
        return super.delete(User.class,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return super.getById(User.class, id);
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public List<User> getAll() {
        return super.getAll(User.class);
    }
}
