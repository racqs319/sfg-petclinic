package net.casesr.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import net.casesr.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
