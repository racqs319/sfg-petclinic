package net.casesr.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.casesr.sfgpetclinic.model.Visit;
import net.casesr.sfgpetclinic.repositories.VisitRepository;
import net.casesr.sfgpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJPAService implements VisitService {
	
	private final VisitRepository visitRepository;
	
	public VisitSpringDataJPAService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visitSet = new HashSet<>();
		visitRepository.findAll().iterator().forEachRemaining(visitSet::add);
		
		return visitSet;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}
