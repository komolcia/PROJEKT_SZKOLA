package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Group1;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GroupService {
    List<Group1> getAllGroups();
    void saveGroup(Group1 Group1);
    Group1 getGroupById(long id);
    void deleteGroupById(long id);
    Page<Group1> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
