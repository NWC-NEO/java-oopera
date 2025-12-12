package mytheatre.entity.person;

import java.util.Objects;

public class Director extends Person {
    protected int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    public void setNumberOfShows(int numberOfShows) {
        this.numberOfShows = numberOfShows;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Director director = (Director) o;
        return numberOfShows == director.numberOfShows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfShows);
    }

    //добавляем собственное поле в заготовку toString
    @Override
    protected String getFieldsAsString() {
        return super.getFieldsAsString() + ", numberOfShows=" + numberOfShows;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
