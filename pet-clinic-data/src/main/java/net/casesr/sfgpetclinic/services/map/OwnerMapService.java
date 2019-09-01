package net.casesr.sfgpetclinic.services.map;

import net.casesr.sfgpetclinic.model.Owner;
import net.casesr.sfgpetclinic.model.Pet;
import net.casesr.sfgpetclinic.services.OwnerService;
import net.casesr.sfgpetclinic.services.PetService;
import net.casesr.sfgpetclinic.services.PetTypeService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long>
        implements OwnerService {
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
    	
    	if (owner != null) {
    		if (owner.getPets().size() > 0) {
    			owner.getPets().forEach(pet -> {
    				if (pet.getPetType() != null) {
    					if (pet.getPetType().getId() == null) {
    						pet.setPetType(petTypeService.save(pet.getPetType()));
    					}
    				} else {
    					throw new RuntimeException("Pet Type is required");
    				}
    				
    				if (pet.getId() == null) {
    					Pet savedPet = petService.save(pet);
    					pet.setId(savedPet.getId());
    				}
    			});
    		}
    		
    		return super.save(owner);
    	} else {
    		return null;
    	}
        
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
				.stream()
				.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.orElse(null);
    }
}
