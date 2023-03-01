package mg.ando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mg.ando.dao.HibernateDao;
import mg.ando.model.DetailsScene;
import mg.ando.model.Film;
import mg.ando.model.Scene;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    HibernateDao dao;

    @GetMapping("/test")
    public String test() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/agenda")
    public String agenda(Model model) {
        model.addAttribute("page", "components/agenda");
        return "index";
    }

    @GetMapping("/films")
    public String films(Model model) {
        model.addAttribute("films", dao.findAll(Film.class));
        model.addAttribute("page", "components/films");
        return "index";
    }

    @GetMapping("/organiser")
    public String organiser(Model model) {
        model.addAttribute("page", "components/organiser");
        return "index";
    }

    @GetMapping("/scenes")
    public String scenes(Model model, @RequestParam int idFilm) throws Exception {
        model.addAttribute("scenes", dao.selectSceneFilm(Scene.class, idFilm));
        model.addAttribute("page", "components/scenes");
        return "index";
    }

    @GetMapping("/detailsScene")
    public String detailsScene(Model model, @RequestParam int idScene) throws Exception {
        model.addAttribute("detailsScene", dao.selectSceneDetail(DetailsScene.class, idScene));
        model.addAttribute("page", "components/detailsScene");
        return "index";
    }

}
