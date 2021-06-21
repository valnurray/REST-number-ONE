package com.lankin.rest.demo.exception;

public class ArticleNotFoundException extends Exception{
    private Long articleId;

    public ArticleNotFoundException(long articleId) {
        super(String.format("Book is not found with id : '%s'", articleId));
    }
}
