package com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.service;

import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.entity.Registration;
import com.rodion.educative.spring_5_and_spring_boot_2.db_relationships.many_to_many.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository repo;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.repo = registrationRepository;
    }

    public List<Registration> allRegistrations() {
        return repo.findAll();
    }

    public Registration getRegistration(int id) {
        return repo.findById(id).get();
    }

    public Registration addRegistration(Registration registration) {
        registration.setId(0);
        return repo.save(registration);
    }

    public void deleteRegistration(int id) {
        repo.deleteById(id);
    }
}
