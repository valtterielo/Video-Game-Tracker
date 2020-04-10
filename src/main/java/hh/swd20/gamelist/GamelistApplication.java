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
			Category c1 = new Category("fps");
			Category c2 = new Category("jrpg");
			Game g1 = new Game("Planetside 2", "Guns. Space. Pew Pew. Wow!", "released", c1);
			Game g2 = new Game("Paper Mario", "Finally coming", "tba", c2);
			Game g3 = new Game("Valorant", "Competitive shooter", "2020", c1);

			categoryrepo.save(c1);
			categoryrepo.save(c2);
			gamerepo.save(g1);
			gamerepo.save(g2);
			gamerepo.save(g3);
		};
	}

}
