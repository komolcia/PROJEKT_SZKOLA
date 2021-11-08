package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Group;
import net.javaguides.springboot.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;


    // display list of admins
    @GetMapping("/group")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewGroupForm")
    public String showNewGroupForm(Model model) {
        // create model attribute to bind form data
        Group Group = new Group();
        model.addAttribute("group", Group);
        return "new_group";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/group";
    }

    @GetMapping("/showFormForUpdateGroup/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get admin from the service
        Group group = groupService.getGroupById(id);

        // set admin as a model attribute to pre-populate the form
        model.addAttribute("group", group);
        return "update_group";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable(value = "id") long id) {

        // call delete admin method
        this.groupService.deleteGroupById(id);
        return "redirect:/group";
    }


    @GetMapping("/pageGroup/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Group> page = groupService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Group> listGroups = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listGroups", listGroups);
        return "indexGroup";
    }
}
