package net.javaguides.springboot.controller;

import javax.validation.Valid;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import net.javaguides.springboot.service.AdressService;
        import net.javaguides.springboot.model.Adress;
        import net.javaguides.springboot.model.domain.Degree;

@Controller
public class AdressController {

    private final AdressService adressService;

    public AdressController(@Autowired AdressService adressService) {
        this.adressService = adressService;
    }

    @GetMapping("/adress")
    public String adresss(Model model) {
        model.addAttribute("allAdresssFromDB", adressService.getAllAdresss());

        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "indexadress";
    }

    @PostMapping("/addAdress")
    public String addAdress(@ModelAttribute("adress") @Valid Adress adress, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation error found!");
            return "new_adress";
        }
        adressService.addAdress(adress);
        return "redirect:/adress";
    }

    @GetMapping("/showNewAdressForm")
    public String showNewAdressForm(Model model) {
        // create model attribute to bind form data
        Adress adress = new Adress();
        model.addAttribute("adress", adress);

        return "new_adress";
    }

    @GetMapping("/deleteAdress/{id}")
    public String deleteAdress(@PathVariable long id) {
        adressService.deleteAdress(id);
        return "redirect:/adress";
    }

    @GetMapping("/showFormForUpdateAdress/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Adress adress = adressService.getAdressById(id);
        model.addAttribute("adress", adress);

        return "update_adress";
    }

    @PostMapping("/updateAdress")
    public String updateAdress(@ModelAttribute("adress") Adress adress) {

        adressService.updateAdress(adress);
        return "redirect:/adress";
    }
}
