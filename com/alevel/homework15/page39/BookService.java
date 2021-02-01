package com.alevel.homework15.page39;

import com.alevel.homework15.Album;
import com.alevel.homework15.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    public static void main(String[] args) {
        List<Album> albumSource = new ArrayList<>();
        List<Book> booksSource = new ArrayList<>();
        List<Album> albumDestination = new ArrayList<>();
        List<Book> booksDestination = new ArrayList<>();
        copyToBooks(booksSource, booksDestination);
        copyToBooks(albumSource, booksDestination);
        copyToBooks(albumSource, albumDestination);
    }

    private static <T> void copyToBooks(List<? extends T> src, List<? super T> dest) {
        for (T book: src) {
            dest.add(book);
        }
    }
}
