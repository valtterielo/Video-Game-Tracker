package hh.swd20.gamelist.web;

import hh.swd20.gamelist.domain.CategoryRepository;
import hh.swd20.gamelist.domain.Game;
import hh.swd20.gamelist.domain.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GameController {

    //used to keep track which html page should be loaded if validation requirements aren't filled
    public String clickedPage;

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
        clickedPage = "addpage";
        model.addAttribute("game", new Game());
        model.addAttribute("categories", crepository.findAll());
        return "addgame";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Game game, BindingResult result) {
        if(result.hasErrors()){
            if(clickedPage.equals("addpage")){
                return "addgame";
            } else if(clickedPage.equals("editpage")){
                return "editgame";
            }
        }
        grepository.save(game);
        return "redirect:index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteGame(@PathVariable("id") Long gameId, Model model) {
        grepository.deleteById(gameId);
        return "redirect:../index";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editGame(@PathVariable("id") Long gameId, Model model){
        clickedPage = "editpage";
        model.addAttribute("game", grepository.findById(gameId));
        model.addAttribute("categories", crepository.findAll());
        return "editgame";
    }

    //REST Get all games
    @RequestMapping(value="/games")
    public @ResponseBody List<Game> gameListRest() {
        return (List<Game>) grepository.findAll();
    }

}
