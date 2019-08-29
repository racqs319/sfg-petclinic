package net.casesr.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import net.casesr.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
