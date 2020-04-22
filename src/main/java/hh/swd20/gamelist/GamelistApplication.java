package hh.swd20.gamelist;

import hh.swd20.gamelist.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//Security disabled for testing
@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class GamelistApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamelistApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository categoryrepo, GameRepository gamerepo, UserRepository userepo){
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

			Game g1 = new Game("Trials of Mana", "Modern revival of the 3rd game in the seminal Mana series", "18.3.2020", c5);
			Game g2 = new Game("The Last of Us Part II", "5 years after their adventure, Ellie and Jackson continue their journey", "29.5.2020", c5);
			Game g3 = new Game("Cyberpunk 2077", "Next big open world RPG of the dark future", "17.9.2020", c5);
			Game g4 = new Game("Minecraft Dungeons", "Minecraft mixed with classic dungeon crawlers", "26.5.2020", c4);

			//username:user password:user
			User user1 = new User("admin", "$2y$10$5.o7WjCrUH9wRDvWHTYGjeOII7EFUQDXRSDswOg6eD4qIzpYd7UVe", "ADMIN");
			//username:moderator password:moderator
			User user2 = new User("moderator", "$2y$10$ZoONKguJ.aZWtUYhAZSomeWn6cuuqGCPcNd7tDnjk2A/IrWfIakxK", "MODERATOR");

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
			gamerepo.save(g4);

			userepo.save(user1);
			userepo.save(user2);
		};
	}

}
