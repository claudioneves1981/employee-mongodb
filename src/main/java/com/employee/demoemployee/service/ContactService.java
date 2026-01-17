package com.employee.demoemployee.service;

import com.employee.demoemployee.entity.ContactEntity;
import com.employee.demoemployee.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public void create(ContactEntity contact){

        contactRepository.save(contact);

    }

    public List<ContactEntity> getByEmployeeId(Long id){

        return contactRepository.findAllByEmployee_Id(id);

    }
}
