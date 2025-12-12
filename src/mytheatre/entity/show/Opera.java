package mytheatre.entity.show;

import mytheatre.entity.person.Actor;
import mytheatre.entity.person.Director;
import mytheatre.entity.person.MusicAuthor;

import java.util.ArrayList;
import java.util.Objects;

public class Opera extends MusicalShow {
    protected int choirSize;

    public Opera(
            String title,
            int duration,
            Director director,
            ArrayList<Actor> listOfActors,
            MusicAuthor musicAuthor,
            String librettoText,
            int choirSize
    ) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }

    public void setChoirSize(int choirSize) {
        this.choirSize = choirSize;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Opera opera = (Opera) o;
        return choirSize == opera.choirSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), choirSize);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + getFieldsAsString() + '}';
    }

    @Override
    public String getFieldsAsString() {
        return super.getFieldsAsString() + ", choirSize=" + choirSize;
    }
}
