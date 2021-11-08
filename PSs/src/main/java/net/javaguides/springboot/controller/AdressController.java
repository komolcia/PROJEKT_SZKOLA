package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Adress;
import net.javaguides.springboot.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdressController {

    @Autowired
    private AdressService adressService;

    // display list of adresss
    @GetMapping("/adress")
    public String viewHomePage(Model model) {
        return findPaginated(1, "city", "asc", model);
    }

    @GetMapping("/showNewAdressForm")
    public String showNewAdressForm(Model model) {
        // create model attribute to bind form data
        Adress adress = new Adress();
        model.addAttribute("adress", adress);
        return "new_adress";
    }

    @PostMapping("/saveAdress")
    public String saveAdress(@ModelAttribute("adress") Adress adress) {
        // save adress to database
        adressService.saveAdress(adress);
        return "redirect:/adress";
    }

    @GetMapping("/showFormForUpdateAdress/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get adress from the service
        Adress adress = adressService.getAdressById(id);

        // set adress as a model attribute to pre-populate the form
        model.addAttribute("adress", adress);
        return "update_adress";
    }

    @GetMapping("/deleteAdress/{id}")
    public String deleteAdress(@PathVariable (value = "id") long id) {

        // call delete adress method 
        this.adressService.deleteAdressById(id);
        return "redirect:/adress";
    }


    @GetMapping("/pageAdress/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Adress> page = adressService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Adress> listAdresss = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listAdresss", listAdresss);
        return "indexadress";
    }
}
