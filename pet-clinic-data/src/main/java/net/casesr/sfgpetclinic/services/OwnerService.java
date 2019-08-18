package net.casesr.sfgpetclinic.services;

import net.casesr.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastNane);

}
