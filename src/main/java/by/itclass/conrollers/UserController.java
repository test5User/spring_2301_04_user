package by.itclass.conrollers;

import by.itclass.model.entities.User;
import by.itclass.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.itclass.constants.AppConstants.*;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String toIndex() {
        return INDEX_PAGE;
    }

    @GetMapping(value = ALL_USERS_URL)
    public String all(Model model) {
        var users = service.getAllUsers();
        model.addAttribute(USER_LIST_ATTR, users);
        return USERS_PAGE;
    }

    @GetMapping(value = DEL_USER_URL)
    public String del(@RequestParam(name = "id") int id) {
        service.deleteById(id);
        return INDEX_PAGE;
    }

    @GetMapping(value = ADD_USER_URL)
    public ModelAndView add() {
        return new ModelAndView(ADD_USER_PAGE, USER_ATTR, new User());
    }

    @PostMapping(value = SAVE_USER_URL)
    public String save(@ModelAttribute(name = USER_ATTR) User user) {
        service.add(user);
        return "redirect:/all";
    }

    @GetMapping(value = UPD_USER_URL)
    public ModelAndView upd(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age) {
        return new ModelAndView(UPD_USER_PAGE, USER_ATTR, new User(id, name, age));
    }

    @PostMapping(value = SAVE_UPD_USER_URL)
    public String saveUpd(@ModelAttribute(name = USER_ATTR) User user) {
        service.update(user);
        return "redirect:" + ALL_USERS_URL;
    }
}
