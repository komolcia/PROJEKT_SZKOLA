package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.Term;
import net.javaguides.springboot.repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermServiceImpl implements TermService {
    @Autowired
    private TermRepository termRepository;

    @Override
    public List<Term> getAllTerms() {
        return termRepository.findAll();
    }

    @Override
    public void saveTerm(Term term) {
        termRepository.save(term);
    }

    @Override
    public Term getTermById(long id) {
        return termRepository.getOne(id);
    }

    @Override
    public void deleteTermById(long id) {
        termRepository.deleteById(id);
    }

    @Override
    public Page<Term> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.termRepository.findAll(pageable);
    }
}
