package net.casesr.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.casesr.sfgpetclinic.model.Pet;
import net.casesr.sfgpetclinic.repositories.PetRepository;
import net.casesr.sfgpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSpringDataJPAService implements PetService {
	
	private final PetRepository petRepository;
	
	public PetSpringDataJPAService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> petSet = new HashSet<>();
		petRepository.findAll().iterator().forEachRemaining(petSet::add);
		
		return petSet;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
