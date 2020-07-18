package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositry;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final AuthorRepositry authorRepositry;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public bootStrapData(AuthorRepositry authorRepositry, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepositry = authorRepositry;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in bootStrapData");

        Publisher publisher = new Publisher();
        publisher.setAddressLine1("asdad");
        publisher.setCity("Delhi");
        publisher.setName("publisher1");
        publisher.setState("Delhi");
        publisher.setZip(234234L);

        Author peter = new Author("Peter" , "Mularien");
        Book b1 = new Book("Spring Security" , "342424");
        peter.getBooks().add(b1);
        b1.getAuthors().add(peter);
        b1.setPublisher(publisher);

        authorRepositry.save(peter);
        publisherRepository.save(publisher);
        bookRepository.save(b1);


        Author john = new Author("John","Cena");
        Book b2 = new Book("Spring MVC","234234");
        john.getBooks().add(b2);
        b2.getAuthors().add(john);
        b2.setPublisher(publisher);

        authorRepositry.save(john);
        bookRepository.save(b2);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books : " + bookRepository.count());




    }
}
