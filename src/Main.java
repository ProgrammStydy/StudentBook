import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание книг
        Book book1 = new Book("Java Basics", 1999, 300);
        Book book2 = new Book("Advanced Java", 2005, 450);
        Book book3 = new Book("Design Patterns", 2002, 500);
        Book book4 = new Book("Clean Code", 2008, 400);
        Book book5 = new Book("Effective Java", 2001, 350);
        Book book6 = new Book("Spring Framework", 2010, 550);
        Book book7 = new Book("Hibernate", 2003, 480);
        Book book8 = new Book("Algorithms", 1998, 600);
        Book book9 = new Book("Concurrency", 2007, 420);
        Book book10 = new Book("Refactoring", 2004, 380);

        // Создание студентов с книгами
        List<Student> students = Arrays.asList(
                new Student("Ivan", Arrays.asList(book1, book2, book3, book4, book5)),
                new Student("Maria", Arrays.asList(book6, book7, book8, book9, book10)),
                new Student("Alex", Arrays.asList(book1, book3, book5, book7, book9)),
                new Student("Elena", Arrays.asList(book2, book4, book6, book8, book10))
        );

        // Обработка данных стримом
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted((b1, b2) -> {
                    int pageCompare = Integer.compare(b1.getPages(), b2.getPages());
                    if (pageCompare != 0) return pageCompare;
                    int yearCompare = Integer.compare(b1.getYear(), b2.getYear());
                    if (yearCompare != 0) return yearCompare;
                    return b1.getTitle().compareTo(b2.getTitle());
                })
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .findFirst()
                .ifPresentOrElse(
                        book -> System.out.println("Найден год выпуска: " + book.getYear()),
                        () -> System.out.println("Книга отсутствует")
                );
    }
}