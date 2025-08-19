package ru.baskakov;


import java.util.Objects;

public class Magazine extends Publication{
    int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return "Журнал";
    }

    @Override
    public void printDetails() {
        System.out.printf("""
                Тип публикации: %s,
                Назавание публикации: %s,
                Автор публикации: %s,
                Год написания публикации: %d,
                Номер выпуска: %d
                """, getType(), getTitle(), getAuthor(), getYear(), issueNumber);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Magazine:" +
                "--- issueNumber=" + issueNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Magazine magazine)) return false;
        if (!super.equals(o)) return false;
        return issueNumber == magazine.issueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueNumber);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}
