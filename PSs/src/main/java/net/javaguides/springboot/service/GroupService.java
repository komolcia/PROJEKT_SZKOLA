package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Group;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    void saveGroup(Group Group);
    Group getGroupById(long id);
    void deleteGroupById(long id);
    Page<Group> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
