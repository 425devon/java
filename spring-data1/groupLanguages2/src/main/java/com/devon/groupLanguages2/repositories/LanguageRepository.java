package com.devon.groupLanguages2.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devon.groupLanguages2.models.Language;



@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
ArrayList<Language> findAll();
}
