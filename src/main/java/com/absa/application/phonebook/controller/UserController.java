package com.absa.application.phonebook.controller;

import com.absa.application.phonebook.model.PhoneBook;
import com.absa.application.phonebook.model.PhoneBookDTO;
import com.absa.application.phonebook.model.User;
import com.absa.application.phonebook.repository.PhoneBookRepository;
import com.absa.application.phonebook.repository.UserRepository;
import com.absa.application.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneBook")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @GetMapping
    public List<PhoneBook> getAll() {
        List<PhoneBook> users = phoneBookRepository.findAll();
        return users;
    }

    @GetMapping("/byPhoneBook")
    public PhoneBook getByPhoneBook(@RequestParam String phonebook) {
        PhoneBook phoneBook =new PhoneBook();
        for(PhoneBook pb:phoneBookRepository.findAll()){
            if(pb.getName().equals(phonebook)){
                return pb;
            }
        }
        return phoneBook;
    }


    @GetMapping("/create")
    public String createUserForm(User user) {
        return "createUser";
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "User Saved";
    }

    @PostMapping("/addPhoneBook")
    public String createPhoneBook(@RequestBody PhoneBookDTO record){
        phoneBookRepository.save(record.getPhoneBook());
        return "Phone Book added";
    }

}
