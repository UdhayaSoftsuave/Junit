package com.example.gradleTest.gradleTest.controller;

import com.mongodb.DBObject;

import ch.lambdaj.function.convert.Converter;

public class DbObjectBookConverter implements
        Converter<DBObject, Book> {

    @Override
    public Book convert(DBObject dbObject) {

        String title = (String) dbObject.get(MongoDbBookConverter.TITLE_FIELD);
        int numberOfPages = (Integer) dbObject.get(MongoDbBookConverter.NUM_PAGES_FIELD);

        return new Book(title, numberOfPages);

    }

}
