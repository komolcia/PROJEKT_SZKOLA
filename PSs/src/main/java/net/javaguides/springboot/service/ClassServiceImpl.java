package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.model.Class;
import net.javaguides.springboot.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public void saveClass(Class aClass) {
        classRepository.save(aClass);
    }

    @Override
    public Class getClassById(long id) {
        return classRepository.getOne(id);
    }

    @Override
    public void deleteClassById(long id) {
        classRepository.deleteById(id);
    }

    @Override
    public Page<Class> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.classRepository.findAll(pageable);
    }
}
