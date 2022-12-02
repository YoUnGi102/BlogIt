package com.gres.tomas.businesstier.repositories;

import com.gres.tomas.businesstier.domain.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {}
