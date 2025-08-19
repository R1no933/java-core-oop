package ru.baskakov;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String SPLITTER = "================================================================";
    private List<Publication> publications;

    public Library() {
        publications = new ArrayList<Publication>();
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
        Publication.publicationCount++;
    }

    public void listAllPublications() {
        int idxPublication = 1;
        if (publications.size() == 0) {
            System.out.println("Список публикаций пустой.");
        } else {
            for (Publication publication : publications) {
                System.out.print(idxPublication + ". ");
                publication.printDetails();
                System.out.println(SPLITTER);
                idxPublication++;
            }
        }
        System.out.println("Всего публикаций:" + Publication.publicationCount);
        System.out.println(SPLITTER);
    }

    public void searchPublicationByAuthor(String author) {
        if (publications.size() == 0) {
            System.out.println("Список публикаций пуст! Поиск не выполнен!");
        }

        boolean found = false;
        for (Publication publication : publications) {
            if (publication.getAuthor().equals(author)) {
                found = true;
                publication.printDetails();
                System.out.println(SPLITTER);
            }
        }
        if (!found) {
            System.out.println("По вашему запросу ничего не найдено!");
        }
    }

    public void deletePublicationByTitle(String title) {
        boolean found = false;
        if (publications.size() == 0) {
            System.out.println("Список публикаций пуст! Нечего удалять!");
        }
        for (int i = 0; i < publications.size(); i++) {
            if (publications.get(i).getTitle().equals(title)) {
                found = true;
                publications.remove(i);
                Publication.publicationCount--;
            }
        }
        if (!found) {
            System.out.println("По вашему запросу нет публикаций, нечего удалять!");
        }
        listAllPublications();
    }
}
