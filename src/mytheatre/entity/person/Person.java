package mytheatre.entity.person;

import java.util.Objects;

public class Person {
    protected String name;
    protected String surname;
    protected Gender gender;

    public Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender);
    }

    @Override
    public String toString() {
        //getClass().getSimpleName() возвращает имя класса без названия пакета
        return getClass().getSimpleName() + "{" + getFieldsAsString() + '}';
    }

    //Получаем заготовку для toString без названия класса
    protected String getFieldsAsString() {
        return "name='" + name + '\'' + ", surname='" + surname + '\'' + ", gender=" + gender;
    }
}
