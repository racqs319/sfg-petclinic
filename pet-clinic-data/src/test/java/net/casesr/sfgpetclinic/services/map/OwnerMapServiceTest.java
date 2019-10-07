package net.casesr.sfgpetclinic.services.map;

import net.casesr.sfgpetclinic.model.Owner;
import net.casesr.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerService;

    final Long ownerId =1L;

    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerService.save(Owner.builder().id(ownerId).lastName(lastName).pets(new HashSet<Pet>()).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner = Owner.builder().id(id).pets(new HashSet<Pet>()).build();

        Owner savedOwner = ownerService.save(owner);

        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerService.save(Owner.builder().pets(new HashSet<Pet>()).build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerId));

        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);

        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerService.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerService.findByLastName("foo");

        assertNull(owner);
    }
}