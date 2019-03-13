package com.postgresqlrest.rest.persistence.repository;

import com.postgresqlrest.rest.persistence.entity.Author;
import com.postgresqlrest.rest.persistence.entity.Authorship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

@Transactional
public interface AuthorshipRepository extends JpaRepository<Authorship,String>{
void deleteAuthorshipsByBookId(Long id);
boolean existsAuthorshipByAuthorIdAndBookId(Long aid,Long bid);
int countAuthorshipByBookId(Long id);
}
