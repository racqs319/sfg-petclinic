package net.casesr.sfgpetclinic.services;

import net.casesr.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastNane);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
