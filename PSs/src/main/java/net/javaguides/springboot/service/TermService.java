package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Professor;
import net.javaguides.springboot.model.Term;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TermService {
    List<Term> getAllTerms();
    void saveTerm(Term term);
    Term getTermById(long id);
    void deleteTermById(long id);
    Page<Term> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
