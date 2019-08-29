package net.casesr.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import net.casesr.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
