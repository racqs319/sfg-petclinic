package net.casesr.sfgpetclinic.services.map;

import net.casesr.sfgpetclinic.model.Specialty;
import net.casesr.sfgpetclinic.model.Vet;
import net.casesr.sfgpetclinic.services.SpecialtyService;
import net.casesr.sfgpetclinic.services.VetService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long>
        implements VetService {
	
	private final SpecialtyService specialtyService;
	
	public VetMapService(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	@Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        
    	if (vet != null) {
    		if (vet.getSpecialties().size() > 0) {
    			vet.getSpecialties().forEach(specialty -> {
    				if (specialty.getId() == null) {
    					Specialty savedSpecialty = specialtyService.save(specialty);
    					specialty.setId(savedSpecialty.getId());
    				}
    			});
    		}
    		return super.save(vet);
    	} else {
    		return null;
    	}
    	
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
