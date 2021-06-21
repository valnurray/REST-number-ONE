package com.lankin.rest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lankin.rest.demo.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>  {
}
