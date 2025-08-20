package ru.baskakov;


import java.util.Objects;

public class Book extends Publication {
    private String ISBN;

    Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public void printDetails() {
        System.out.printf("""
                Тип публикации: %s,
                ---Назавание публикации: %s,
                ---Автор публикации: %s,
                ---Год написания публикации: %d,
                ---ISBN: %s
                """, getType(),getTitle(), getAuthor(), getYear(), ISBN);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Book: " +
                "--- ISBN:=" + ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
