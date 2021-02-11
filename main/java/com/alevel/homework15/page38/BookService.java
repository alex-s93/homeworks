package com.alevel.homework15.page38;

import com.alevel.homework15.Album;
import com.alevel.homework15.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    public static void main(String[] args) {
        List<Album> booksSource = new ArrayList<>();
        List<Book> booksDestination = new ArrayList<>();
        copyToBooks(booksSource, booksDestination);
    }

    private static void copyToBooks(List<? extends Book> src, List<Book> dest) {
        for (Book book: src) {
            dest.add(book);
        }
    }
}
