package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Group1;
import net.javaguides.springboot.repository.GroupRepository;
import net.javaguides.springboot.service.GroupService;
import net.javaguides.springboot.service.ProfessorService;
import net.javaguides.springboot.service.TermService;
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
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private TermService termService;

    @Autowired public GroupRepository groupRepository;
    @GetMapping("/group")
    public String groups(Model model){
        model.addAttribute("allGroupsFromDB", groupService.getAllGroups());

        if(groupRepository.count()==0) {
            model.addAttribute("message",groupService.getAllGroups());
        }
        // Kolejny widok do reenderowania, identifkator logiczny widoku do renderowania
        return "indexgroup";
    }

    @GetMapping("/showNewGroupForm")
    public String showNewGroupForm(Model model) {
        // create model attribute to bind form data
        Group1 Group = new Group1();
        model.addAttribute("group", Group);
        model.addAttribute("professors", professorService.getAllProfessors());
        model.addAttribute("terms", termService.getAllTerms());
        return "new_group";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group1 group) {
        groupService.saveGroup(group);
        return "redirect:/group";
    }

    @GetMapping("/showFormForUpdateGroup/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get group from the service
        Group1 group = groupService.getGroupById(id);

        // set group as a model attribute to pre-populate the form
        model.addAttribute("group", group);
        return "update_group";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable(value = "id") long id) {

        // call delete group method
        this.groupService.deleteGroupById(id);
        return "redirect:/group";
    }


    @GetMapping("/pageGroup/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Group1> page = groupService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Group1> listGroups = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listGroups", listGroups);
        return "indexgroup";
    }
}
