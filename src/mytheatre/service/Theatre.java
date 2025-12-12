package mytheatre.service;

import mytheatre.entity.person.*;
import mytheatre.entity.show.*;

import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Name1", "Surname1", Gender.FEMALE, 170);
        Actor actor2 = new Actor("Name2", "Surname2", Gender.MALE, 180);
        Actor actor3 = new Actor("Name3", "Surname3", Gender.FEMALE, 190);

        Director director1 = new Director("Name4", "Surname4", Gender.MALE, 10);
        Director director2 = new Director("Name5", "Surname5", Gender.FEMALE, 20);

        MusicAuthor author1 = new MusicAuthor("Name6", "Surname6", Gender.MALE);

        Choreographer choreographer1 = new Choreographer("Name7", "Surname7", Gender.FEMALE);

        ArrayList<Actor> listActors1 = new ArrayList<>();
        ArrayList<Actor> listActors2 = new ArrayList<>();
        ArrayList<Actor> listActors3 = new ArrayList<>();

        Show show = new Show("TitleShow", 50, director1, listActors1);
        Opera opera = new Opera("TitleOpera", 100, director2, listActors2, author1, "Libretto1", 10);
        Ballet ballet = new Ballet("TitleBallet", 75, director1, listActors3, author1, "Libretto2", choreographer1);

        show.addActor(actor1);
        show.addActor(actor2);
        show.addActor(actor3);

        opera.addActor(actor1);
        opera.addActor(actor2);

        ballet.addActor(actor2);
        ballet.addActor(actor3);

        show.printListOfActors();
        opera.printListOfActors();
        ballet.printListOfActors();

        opera.changeActor(actor3, "Surname2");
        opera.printListOfActors();

        ballet.changeActor(actor1, "Surname4");

        opera.printLibretto();
        ballet.printLibretto();
    }
}
