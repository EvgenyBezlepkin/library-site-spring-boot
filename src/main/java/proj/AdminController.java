package proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    PublishRepository publishRepository;
    @Autowired
    AuthorRepository authorRepository;


    @GetMapping("/admin")
    public String a(Model model) {

        getGenres(model);
        getAuthors(model);
        getPublishers(model);

        model.addAttribute("addBook", new Book());
        model.addAttribute("addGenre", new Genre());
        model.addAttribute("addAuthor", new Author());
        model.addAttribute("addPublisher", new Publisher());
        return "admin";
    }

    @PostMapping("/admin")
    public String b(Genre genre, Author author, Publisher publish, @ModelAttribute Book book, Model model,
                    @RequestParam(value = "param") String param) {

        if (param.equals("saveBook")) {
            bookRepository.save(book);
        }
        if (param.equals("saveAuthor")) {
            authorRepository.save(author);
        }
        if (param.equals("saveGenre")) {
            genreRepository.save(genre);
        }
        if (param.equals("savePublisher")) {
            publishRepository.save(publish);
        }

        getGenres(model);
        getAuthors(model);
        getPublishers(model);

        model.addAttribute("addBook", new Book());
        model.addAttribute("addGenre", new Genre());
        model.addAttribute("addAuthor", new Author());
        model.addAttribute("addPublisher", new Publisher());

        return "admin";
    }

    public void getGenres(Model model) {
        Iterable<Genre> list;
        list = genreRepository.findAll();
        if (list != null) {
            model.addAttribute("genres", list);
        }
    }

    public void getAuthors(Model model) {
        Iterable<Author> list;
        list = authorRepository.findAll();
        if (list != null) {
            model.addAttribute("authors", list);
        }
    }

    public void getPublishers(Model model) {
        Iterable<Publisher> list;
        list = publishRepository.findAll();
        if (list != null) {
            model.addAttribute("publishers", list);
        }
    }
}
