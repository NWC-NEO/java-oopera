package mytheatre.entity.show;

import mytheatre.entity.person.Actor;
import mytheatre.entity.person.Director;
import mytheatre.entity.person.MusicAuthor;

import java.util.ArrayList;
import java.util.Objects;

public class MusicalShow extends Show {
    protected MusicAuthor musicAuthor;
    protected String librettoText;

    public MusicalShow(
            String title,
            int duration,
            Director director,
            ArrayList<Actor> listOfActors,
            MusicAuthor musicAuthor,
            String librettoText
    ) {
        super(title, duration, director, listOfActors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public MusicAuthor getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(MusicAuthor musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }

    public void setLibrettoText(String librettoText) {
        this.librettoText = librettoText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MusicalShow that = (MusicalShow) o;
        return Objects.equals(musicAuthor, that.musicAuthor) && Objects.equals(librettoText, that.librettoText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), musicAuthor, librettoText);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + getFieldsAsString() + '}';
    }

    @Override
    protected String getFieldsAsString() {
        int librettoTextLength = librettoText != null ? librettoText.length() : 0;
        return super.getFieldsAsString() +
                ", musicAuthor=" + musicAuthor +
                ", librettoText='" + librettoTextLength;
    }

    public void printLibretto() {
        System.out.println(librettoText);
    }
}
