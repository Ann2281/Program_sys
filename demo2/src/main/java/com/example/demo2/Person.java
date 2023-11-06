package com.example.demo2;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Класс-модель для адресата (Person).
 *
 */
public class Person {


    private final StringProperty Name;
    private final StringProperty Rank;
    private final StringProperty Degree;
    private final StringProperty post;
    private final StringProperty lesson;
    private final StringProperty lesson_type;
    /**
     * Конструктор по умолчанию.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Конструктор с некоторыми начальными данными.
     *
     * @param Name
     * @param Rank
     */
    public Person(String Name, String Rank) {
        this.Name = new SimpleStringProperty(Name);
        this.Rank = new SimpleStringProperty(Rank);

        // Какие-то фиктивные начальные данные для удобства тестирования.
        this.Degree = new SimpleStringProperty("какое ученое звание");
        this.post = new SimpleStringProperty("какая ученая степень");
        this.lesson = new SimpleStringProperty("какой урок");
        this.lesson_type = new SimpleStringProperty("какой тип урока");
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public StringProperty NameProperty() {
        return Name;
    }

    public String getRank() {
        return Rank.get();
    }

    public void setRank(String Rank) {
        this.Rank.set(Rank);
    }

    public StringProperty RankProperty() {
        return Rank;
    }

    public String getDegree() {
        return Degree.get();
    }

    public void setDegree(String Degree) {
        this.Degree.set(Degree);
    }

    public StringProperty DegreeProperty() {
        return Degree;
    }

    public String getPost() {
        return post.get();
    }

    public void setPost(String post) {
        this.post.set(post);
    }

    public StringProperty postalCodeProperty() {
        return post;
    }

    public String getlesson() {
        return lesson.get();
    }

    public void setlesson(String lesson) {
        this.lesson.set(lesson);
    }

    public StringProperty lessonProperty() {
        return lesson;
    }

    public String getlesson_type() {
        return lesson_type.get();
    }

    public void setlesson_type(String lesson_type) {
        this.lesson_type.set(lesson_type);
    }

    public StringProperty lesson_typeProperty() {
        return lesson_type;
    }
}
