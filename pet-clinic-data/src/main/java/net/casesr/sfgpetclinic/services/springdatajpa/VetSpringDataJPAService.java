package net.casesr.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.casesr.sfgpetclinic.model.Vet;
import net.casesr.sfgpetclinic.repositories.VetRepository;
import net.casesr.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSpringDataJPAService implements VetService {
	
	private final VetRepository vetRepository;
	
	public VetSpringDataJPAService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vetSet = new HashSet<>();
		vetRepository.findAll().iterator().forEachRemaining(vetSet::add);
		
		return vetSet;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
