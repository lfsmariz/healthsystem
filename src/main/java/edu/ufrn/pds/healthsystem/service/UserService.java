package edu.ufrn.pds.healthsystem.service;

import edu.ufrn.pds.healthsystem.entity.User;
import edu.ufrn.pds.healthsystem.form.SampleForm;
import edu.ufrn.pds.healthsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(SampleForm user){
        var userEntt = new User();
        userEntt.setName(user.getNome());
        userEntt.setAge(user.getIdade());
        userRepository.save(userEntt);
    }
}
