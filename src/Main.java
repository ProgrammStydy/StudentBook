import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Java Basics", 1999, 300),
                new Book("Advanced Java", 2005, 450),
                new Book("Design Patterns", 2002, 500),
                new Book("Clean Code", 2008, 400),
                new Book("Effective Java", 2001, 350),
                new Book("Spring Framework", 2010, 550),
                new Book("Hibernate", 2003, 480),
                new Book("Algorithms", 1998, 600),
                new Book("Concurrency", 2007, 420),
                new Book("Refactoring", 2004, 380)
        );


        List<Student> students = Arrays.asList(
                new Student("Ivan", books.subList(0, 5)),
                new Student("Maria", books.subList(5, 10)),
                new Student("Alex", Arrays.asList(books.get(0), books.get(2), books.get(4), books.get(6), books.get(8))),
                new Student("Elena", Arrays.asList(books.get(1), books.get(3), books.get(5), books.get(7), books.get(9)))
        );


        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages).thenComparingInt(Book::getYear))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Найден год выпуска: " + year),
                        () -> System.out.println("Книга отсутствует")
                );

    }
}