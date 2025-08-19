package ru.baskakov;

import java.util.Objects;

public abstract class Publication {
    public static int publicationCount = 0;

    private String title;
    private String author;
    private int year;

    Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Публикация: " +
                "---Название: " + title + '\'' +
                "---Автор: " + author + '\'' +
                "---Год выпуска: " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Publication that)) return false;
        return year == that.year && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public static int getPublicationCount() {
        return publicationCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
