package net.casesr.sfgpetclinic.services;

import net.casesr.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastNane);

    List<Owner> findAllByLastNameLike(String lastName);

}
