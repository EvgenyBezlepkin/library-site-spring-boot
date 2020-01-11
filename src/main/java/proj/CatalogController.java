package proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    PublishRepository publishRepository;
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/item")
    public String main3(Model model, @RequestParam(name = "id") String id) {
        Book b = bookRepository.findById(Long.parseLong(id));
        model.addAttribute("bookForId", b);
        return "item";
    }

    @PostMapping("/catalog")
    public String search(Book book, Model model) {
        Iterable<Book> b = null;
        b = bookRepository.findByNameContaining(book.getName());
        model.addAttribute("foundBook", b);
        model.addAttribute("findBook", new Book());
        return "catalog";
    }

    @GetMapping("/catalog")
    public String a(Model model) {
//        Iterable<Book> b = null;
//        b = bookRepository.findAll();
//        model.addAttribute("foundBook", b);
        model.addAttribute("findBook", new Book());
        return "catalog";
    }
}
