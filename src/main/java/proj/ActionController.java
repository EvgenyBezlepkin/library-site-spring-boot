package proj;

import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class ActionController {

    @Autowired
    ActionsRepository actionsRepository;

    @GetMapping("/newsitem")
    public String b(Model model) {
        Iterable<Actions> actionsCollection = actionsRepository.findAll();
        model.addAttribute("actions", actionsCollection);
        return "newsitem";
    }

    @GetMapping("/action")
    public String s(Model model, @RequestParam(name = "id") String id) {
        Actions b = actionsRepository.findById(Integer.parseInt(id));
        model.addAttribute("actionForId", b);
        return "newsitem_detail";
    }
}
