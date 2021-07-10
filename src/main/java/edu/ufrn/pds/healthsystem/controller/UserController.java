package edu.ufrn.pds.healthsystem.controller;

import edu.ufrn.pds.healthsystem.dto.SampleDTO;
import edu.ufrn.pds.healthsystem.form.SampleForm;
import edu.ufrn.pds.healthsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody @Valid SampleForm user){
        userService.createUser(user);
    }
}
