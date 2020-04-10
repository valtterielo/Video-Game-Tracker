package hh.swd20.gamelist.web;

import hh.swd20.gamelist.domain.CategoryRepository;
import hh.swd20.gamelist.domain.Game;
import hh.swd20.gamelist.domain.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private CategoryRepository crepository;

    @Autowired
    private GameRepository grepository;

    @RequestMapping(value = {"/", "/index"})
    public String gameList(Model model){
        model.addAttribute("games", grepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/add")
    public String addGame(Model model){
        model.addAttribute("game", new Game());
        model.addAttribute("categories", crepository.findAll());
        return "addgame";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Game game) {
        grepository.save(game);
        return "redirect:index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteGame(@PathVariable("id") Long gameId, Model model) {
        grepository.deleteById(gameId);
        return "redirect:../index";
    }

    //REST Get all games
    @RequestMapping(value="/games")
    public @ResponseBody List<Game> gameListRest() {
        return (List<Game>) grepository.findAll();
    }

}
