package com.jpc16tuesday.springliblaryproject.hw_library.repository;

import com.jpc16tuesday.springliblaryproject.hw_library.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Long> {
}
