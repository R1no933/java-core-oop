package ru.baskakov;

import java.util.Scanner;

public class Main {
    private static final String START_MENU = """
            ================================================================
            Добро пожаловать в программу: "Библиотечный каталог."
            Выебрите дальнейшее действие указав цифру нужного пункта меню:
            1. Добавить публикацию.
            2. Показать все публикации.
            3. Поиск публикаций по автору.
            4. Вывести общее количество публикаций.
            5. Удалить публикацию по названию.
            0. Завершение работы программы.
            ================================================================
            Укажите цифру пункта меню:
            """;
    private static final String ADD_PUB_MENU = """
            ================================================================
            Выберите тип публикации, который хотите добавить:
            1. Книга.
            2. Журнал.
            3. Новостная газета.
            ================================================================
            Укажите цифру пункта меню
            """;
    private static final String INCORRECT_INPUT = "Некорректный ввод! Введите только цифру!";

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println(START_MENU);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1 -> {
                        System.out.println(ADD_PUB_MENU);
                        if (scanner.hasNextInt()) {
                            int choicePubType = scanner.nextInt();
                            scanner.nextLine();
                            Publication publication = null;
                            switch (choicePubType) {
                                case 1 -> {
                                    System.out.println("Введите название книги:");
                                    String title = scanner.nextLine().trim();
                                    System.out.println("Введите автора книги:");
                                    String author = scanner.nextLine().trim();
                                    System.out.println("Введите год издания книги:");
                                    int year = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Введите ISBN книги:");
                                    String isbn = scanner.nextLine().trim();
                                    publication = new Book(title, author, year, isbn);
                                }
                                case 2 -> {
                                    System.out.println("Введите название журнала:");
                                    String title = scanner.nextLine().trim();
                                    System.out.println("Введите автора журнала:");
                                    String author = scanner.nextLine().trim();
                                    System.out.println("Введите год издания журнала:");
                                    int year = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Введите номер выпуска журнала:");
                                    int issueNumber = scanner.nextInt();
                                    publication = new Magazine(title, author, year, issueNumber);
                                }
                                case 3 -> {
                                    System.out.println("Введите название новостной газеты:");
                                    String title = scanner.nextLine().trim();
                                    System.out.println("Введите автора новостной газеты:");
                                    String author = scanner.nextLine().trim();
                                    System.out.println("Введите год издания новостной газеты:");
                                    int year = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Введите день недели публикации новостной газеты:");
                                    String publicationDay = scanner.nextLine().trim();
                                    publication = new Newspaper(title, author, year, publicationDay);
                                }
                                default -> System.out.println(INCORRECT_INPUT);
                            }
                            if (publication != null) {
                                library.addPublication(publication);
                                System.out.println("Вы успешно добавили публикацию.");
                            }
                        } else {
                            System.out.println(INCORRECT_INPUT);
                            scanner.next();
                        }
                    }

                    case 2 -> {
                        library.listAllPublications();
                    }

                    case 3 -> {
                        System.out.println("Введите автора для поиска публикации:");
                        String author = scanner.nextLine();
                        library.searchPublicationByAuthor(author);
                    }

                    case 4 -> {
                        if (Publication.getPublicationCount() == 0) {
                            System.out.println("Список публикаций пуст!");
                        } else {
                            System.out.println("Всего публикаций: " + Publication.getPublicationCount());
                        }
                    }

                    case 5 -> {
                        System.out.println("Введите название публикации, которую хотите удалить:");
                        String title = scanner.nextLine();
                        library.deletePublicationByTitle(title);
                    }

                    case 0 -> {
                        quit = true;
                    }

                    default -> {
                        System.out.println(INCORRECT_INPUT);
                    }
                }
            } else {
                System.out.println(INCORRECT_INPUT);
                scanner.next();
            }
        }
        scanner.close();
    }
}