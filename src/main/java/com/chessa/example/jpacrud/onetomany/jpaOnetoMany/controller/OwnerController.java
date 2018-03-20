package com.chessa.example.jpacrud.onetomany.jpaOnetoMany.controller;


import com.chessa.example.jpacrud.onetomany.jpaOnetoMany.model.Owners;
import com.chessa.example.jpacrud.onetomany.jpaOnetoMany.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;
    //get all
    @GetMapping("/owners")
    public List<Owners> getAllOwners(){
        return ownerRepository.findAll();
    }
    //get one by id
    @GetMapping("/owners/{id}")
    public ResponseEntity<Owners> getOwnerById(@PathVariable(value = "id")Long ownerId){
        Owners owner = ownerRepository.findOne(ownerId);
        if (owner==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(owner);
    }
    //create new one
    @PostMapping("/owners")
    public Owners createOwner(@Valid @RequestBody Owners owner){
        return ownerRepository.save(owner);
    }
    //edit one of them
    @PutMapping("/owners/{id}")
    public ResponseEntity<Owners> updateOwner(
            @PathVariable(value = "id")Long ownerId, @Valid @RequestBody Owners ownerDetail){
        Owners owner= ownerRepository.findOne(ownerId);
        if (owner==null){
            return ResponseEntity.notFound().build();
        }
        owner.setFullname(ownerDetail.getFullname());
        owner.setAddress(ownerDetail.getAddress());
        owner.setIdentity_number(ownerDetail.getIdentity_number());
        Owners updateOwner= ownerRepository.save(owner);
        return ResponseEntity.ok(updateOwner);
    }
    //delete one of them by id
    @DeleteMapping("/owners/{id}")
    public ResponseEntity<Owners> deleteOwner(@PathVariable(value = "id")Long ownerId){
        Owners owner= ownerRepository.findOne(ownerId);
        if (owner==null){
            return ResponseEntity.notFound().build();
        }
        ownerRepository.delete(owner);
        return ResponseEntity.ok().build();
    }

}
