package ru.baskakov;

import java.util.Objects;

public class Newspaper extends Publication{
    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType() {
        return "Новостная газета";
    }

    @Override
    public void printDetails() {
        System.out.printf("""
                Тип публикации: %s,
                Назавание публикации: %s,
                Автор публикации: %s,
                Год написания публикации: %d,
                День недели публикации:: %d
                """, getType(), getTitle(), getAuthor(), getYear(), publicationDay);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Newspaper:" +
                "--- publicationDay=" + publicationDay;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Newspaper newspaper)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }
}
