package hh.swd20.gamelist;

import hh.swd20.gamelist.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Date;

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
			Category c4 = new Category("adventure");
			Category c14 = new Category("MOBA");
			Category c13 = new Category("MMO");
			Category c5 = new Category("RPG");
			Category c6 = new Category("simulation");
			Category c12 = new Category("sandbox");
			Category c7 = new Category("strategy");
			Category c8 = new Category("shooter");
			Category c9 = new Category("sports");
			Category c10 = new Category("platformer");
			Category c11 = new Category("puzzle");

			Game g1 = new Game("Trials of Mana", "Modern revival of the 3rd game in the seminal Mana series", "2020-04-24", c5);
			Game g2 = new Game("The Last of Us Part II", "5 years after their adventure, Ellie and Jackson continue their journey", "2020-05-29", c5);
			Game g3 = new Game("Cyberpunk 2077", "Next big open world RPG of the dark future", "2020-09-17", c5);
			Game g4 = new Game("Minecraft Dungeons", "Minecraft mixed with classic dungeon crawlers", "2020-05-26", c4);
			Game g5 = new Game("Marvel's avengers", "Kamala Khan aims to get the Avengers back together in this action RPG", "2020-09-04", c2);

			//username:user password:user
			User user1 = new User("admin", "$2y$10$5.o7WjCrUH9wRDvWHTYGjeOII7EFUQDXRSDswOg6eD4qIzpYd7UVe", "ADMIN");
			//username:moderator password:moderator
			User user2 = new User("moderator", "$2y$10$ZoONKguJ.aZWtUYhAZSomeWn6cuuqGCPcNd7tDnjk2A/IrWfIakxK", "MODERATOR");

			categoryrepo.save(c1);
			categoryrepo.save(c2);
			categoryrepo.save(c4);
			categoryrepo.save(c14);
			categoryrepo.save(c13);
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
			gamerepo.save(g5);

			userepo.save(user1);
			userepo.save(user2);
		};
	}

}
