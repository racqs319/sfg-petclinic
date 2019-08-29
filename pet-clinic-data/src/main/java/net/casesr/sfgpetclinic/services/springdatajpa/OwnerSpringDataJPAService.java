package net.casesr.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import net.casesr.sfgpetclinic.model.Owner;
import net.casesr.sfgpetclinic.repositories.OwnerRepository;
import net.casesr.sfgpetclinic.repositories.PetRepository;
import net.casesr.sfgpetclinic.repositories.PetTypeRepository;
import net.casesr.sfgpetclinic.services.OwnerService;

public class OwnerSpringDataJPAService implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	public OwnerSpringDataJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> ownerSet = new HashSet<>();
		ownerRepository.findAll().iterator().forEachRemaining(ownerSet::add);
		
		return ownerSet;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastNane) {
		return ownerRepository.findByLastName(lastNane);
	}

}
