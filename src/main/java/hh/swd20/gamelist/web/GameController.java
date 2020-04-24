package hh.swd20.gamelist.web;

import hh.swd20.gamelist.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    //used to keep track which html page should be saved
    public String clickedPage;

    @Autowired
    private CategoryRepository crepository;

    @Autowired
    private GameRepository grepository;

    @Autowired
    private UserRepository urepository;

    @RequestMapping(value = {"/", "/index"})
    public String gameList(Model model, String keyword){

        if(keyword!=null){
            model.addAttribute("games", grepository.findByKeyword(keyword));
        } else {
            model.addAttribute("games", grepository.sortByDate());
        }

        return "index";
    }

    @RequestMapping(value = "/add")
    public String addGame(Model model){
        clickedPage = "addpage";
        model.addAttribute("game", new Game());
        model.addAttribute("categories", crepository.findAll());
        return "addgame";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/addModerator")
    public String addModerator(Model model){
        model.addAttribute("user", new User());
        return "addmoderator";
    }

    //Save changes to Game
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Game game, BindingResult result) {
        if(result.hasErrors()){
            if(clickedPage.equals("addpage")){
                return "addgame";
            } else if(clickedPage.equals("editpage")){
                return "editgame";
            }
        }
        if(clickedPage.equals("editpage")){
            game.setReleasedate(game.getReleasedateString());
        } else if(clickedPage.equals("addpage")){
            game.setReleasedateString(game.getReleasedate().toString());
        }
        grepository.save(game);
        return "redirect:index";
    }

    //Save changes to User
    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return "addmoderator";
        }
        user.setRole("MODERATOR");
        urepository.save(user);
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
