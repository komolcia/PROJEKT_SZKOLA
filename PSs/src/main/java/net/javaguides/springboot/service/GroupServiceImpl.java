package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Group1;
import net.javaguides.springboot.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository GroupRepository) {
        this.groupRepository = GroupRepository;
    }

    @Override
    public List<Group1> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void saveGroup(Group1 group) {
        groupRepository.save(group);
    }

    @Override
    public Group1 getGroupById(long id) {
        return groupRepository.getOne(id);
    }

    @Override
    public void deleteGroupById(long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Page<Group1> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.groupRepository.findAll(pageable);
    }
}
