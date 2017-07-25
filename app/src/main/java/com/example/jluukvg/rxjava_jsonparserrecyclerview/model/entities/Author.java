package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities;

/**
 * Created by jluukvg on 4/6/2017.
 *
 */

public class Author {
    public String name;
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return (name != null ? name.equals(author.name) : author.name == null) &&
                (image != null ? image.equals(author.image) : author.image == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
