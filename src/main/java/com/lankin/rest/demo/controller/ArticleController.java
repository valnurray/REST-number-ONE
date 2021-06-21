package com.lankin.rest.demo.controller;

import com.lankin.rest.demo.exception.ArticleNotFoundException;
import com.lankin.rest.demo.model.Article;
import com.lankin.rest.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    // Получить все записи
    @GetMapping("/articles")
    public List getAllNotes() {
        return articleRepository.findAll();
    }

    // Создать запись
    @PostMapping("/articles")
    public Article createNote(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    // Получить запись по id
    @GetMapping("/articles/{id}")
    public Article getNoteById(@PathVariable(value = "id") Long articleId) throws ArticleNotFoundException {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
    }

    // Удалить запись по id
    @DeleteMapping("/articles/{id}")
    public ResponseEntity deleteArticle(@PathVariable(value = "id") Long articleId) throws ArticleNotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));

        articleRepository.delete(article);
        return ResponseEntity.ok().build();
    }

}
