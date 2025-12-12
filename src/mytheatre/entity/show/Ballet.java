package mytheatre.entity.show;

import mytheatre.entity.person.Actor;
import mytheatre.entity.person.Choreographer;
import mytheatre.entity.person.Director;
import mytheatre.entity.person.MusicAuthor;

import java.util.ArrayList;
import java.util.Objects;

public class Ballet extends MusicalShow {
    protected Choreographer choreographer;

    public Ballet(
            String title,
            int duration,
            Director director,
            ArrayList<Actor> listOfActors,
            MusicAuthor musicAuthor,
            String librettoText,
            Choreographer choreographer
    ) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public Choreographer getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(Choreographer choreographer) {
        this.choreographer = choreographer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ballet ballet = (Ballet) o;
        return Objects.equals(choreographer, ballet.choreographer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), choreographer);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + getFieldsAsString() + '}';
    }

    @Override
    protected String getFieldsAsString() {
        return super.getFieldsAsString() +
                ", choreographer=" + choreographer;
    }
}
