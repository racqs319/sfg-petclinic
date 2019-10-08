package net.casesr.sfgpetclinic.controllers;

import net.casesr.sfgpetclinic.model.Pet;
import net.casesr.sfgpetclinic.model.Visit;
import net.casesr.sfgpetclinic.services.PetService;
import net.casesr.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VisitController {

    private static final String VIEWS_VISITS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";

    private final PetService petService;
    private final VisitService visitService;

    public VisitController(PetService petService, VisitService visitService) {
        this.petService = petService;
        this.visitService = visitService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        Visit visit = Visit.builder().build();
        pet.addVisit(visit);
        model.addAttribute("pet", pet);

        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Model model) {
        return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
        } else {
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }

}
