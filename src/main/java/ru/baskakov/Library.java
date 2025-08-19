package ru.baskakov;

import java.util.List;

public class Library {
    private final String SPLITTER = "===============================";
    private List<Publication> publications;

    public void addPublication(Publication publication) {
        publications.add(publication);
        Publication.publicationCount++;
    }

    public void listAllPublications() {
        int idxPublication = 1;
        for (Publication publication : publications) {
            System.out.println(idxPublication + publication.toString());
            System.out.println(SPLITTER);
            idxPublication++;
        }
    }

    public void searchPublicationByAuthor(String author) {
        for (Publication publication : publications) {
            if (publication.getAuthor().equals(author)) {
                System.out.println(publication.toString());
                System.out.println(SPLITTER);
            }
        }
    }

    public void deletePublicationByAuthor(String author) {
        for (Publication publication : publications) {
            if (publication.getAuthor().equals(author)) {
                publications.remove(publication);
            }
        }
        listAllPublications();
    }
}
