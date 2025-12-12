package mytheatre.entity.show;

import mytheatre.entity.person.Actor;
import mytheatre.entity.person.Director;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Actor> getListOfActors() {
        //даём копию списка, что бы не было возможности изменить оригинал
        return listOfActors != null ? new ArrayList<>(listOfActors) : null;
    }

    public void setListOfActors(ArrayList<Actor> listOfActors) {
        this.listOfActors = listOfActors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return duration == show.duration &&
                Objects.equals(title, show.title) &&
                Objects.equals(director, show.director) &&
                isEqualslistOfActors(listOfActors, show.listOfActors);
    }

    //Сравниваем списки актёров без учёта порядка элементов
    private boolean isEqualslistOfActors(ArrayList<Actor> list1, ArrayList<Actor> list2) {
        if (list1 == null && list2 == null) return true;
        if (list1 == null || list2 == null) return false;
        if (list1.size() != list2.size()) return false;
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }

    @Override
    public int hashCode() {
        HashSet<Actor> listOfActorsSet = listOfActors != null ? new HashSet<>(listOfActors) : null; //не учитываем порядок элементов
        return Objects.hash(title, duration, director, listOfActorsSet);
    }

    @Override
    public String toString() {
        //getClass().getSimpleName() возвращает имя класса без названия пакета
        return getClass().getSimpleName() + "{" + getFieldsAsString() + '}';
    }

    //Получаем заготовку для toString без названия класса
    protected String getFieldsAsString() {
        int listOfActorsLength = listOfActors != null ? listOfActors.size() : 0;
        return "title='" + title + '\'' +
                ", duration=" + duration +
                ", director=" + director +
                ", listOfActorsLength=" + listOfActorsLength;
    }

    //выводим список актёров согласно условию (не стал toString у Person портить)
    public void printListOfActors() {
        if (listOfActors != null) {
            for (Actor actor : listOfActors) {
                System.out.println(actor.getName() + " " + actor.getSurname() + " (" + actor.getHeight() + ")");
            }
            System.out.println();
        }
    }

    //добавляем актёра в список
    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Такой актёр уже есть \n");
            return;
        }

        listOfActors.add(actor);
    }

    public void changeActor(Actor actor, String surnameToFind) {
        boolean isActorFound = false;

        if (listOfActors != null && !listOfActors.isEmpty()) {
            for (int i = 0; i < listOfActors.size(); i++) {
                if (listOfActors.get(i).getSurname().equals(surnameToFind)) {
                    listOfActors.set(i, actor);
                    isActorFound = true;
                    break;
                }
            }
        }
        if (!isActorFound) {
            System.out.println("Такого актёра нет \n");
        }
    }
}
