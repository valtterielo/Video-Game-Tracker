package hh.swd20.gamelist;

import hh.swd20.gamelist.domain.Category;
import hh.swd20.gamelist.domain.CategoryRepository;
import hh.swd20.gamelist.domain.Game;
import hh.swd20.gamelist.domain.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//Security disabled for testing
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GamelistApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamelistApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository categoryrepo, GameRepository gamerepo){
		return (args) -> {
			Category c1 = new Category("-");
			Category c2 = new Category("action");
			Category c3 = new Category("action");
			Category c4 = new Category("adventure");
			Category c5 = new Category("rpg");
			Category c6 = new Category("simulation");
			Category c12 = new Category("sandbox");
			Category c7 = new Category("strategy");
			Category c8 = new Category("shooter");
			Category c9 = new Category("sports");
			Category c10 = new Category("platformer");
			Category c11 = new Category("puzzle");
			Game g1 = new Game("Planetside 2", "Guns. Space. Pew Pew. Wow!", "released", c1);
			Game g2 = new Game("Paper Mario", "Finally coming", "tba", c2);
			Game g3 = new Game("Valorant", "Competitive shooter", "2020", c1);

			categoryrepo.save(c1);
			categoryrepo.save(c2);
			categoryrepo.save(c3);
			categoryrepo.save(c4);
			categoryrepo.save(c5);
			categoryrepo.save(c6);
			categoryrepo.save(c12);
			categoryrepo.save(c7);
			categoryrepo.save(c8);
			categoryrepo.save(c9);
			categoryrepo.save(c10);
			categoryrepo.save(c11);

			gamerepo.save(g1);
			gamerepo.save(g2);
			gamerepo.save(g3);
		};
	}

}
