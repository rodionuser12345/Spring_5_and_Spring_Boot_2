package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.controller;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService registrationService) {
        this.service = registrationService;
    }

    @GetMapping
    public List<Registration> allRegistrations() {
        return service.allRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable int id) {
        return service.getRegistration(id);
    }

    @PostMapping
    public Registration addRegistration(@RequestBody Registration registration) {
        return service.addRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable int id) {
        service.deleteRegistration(id);
    }
}
