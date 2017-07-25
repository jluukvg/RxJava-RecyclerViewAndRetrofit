package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities;

/**
 * Created by miguel on 3/6/17.
 *
 */

public class Section {
    public final int tid;
    public final String name;
    private final String color;

    public Section(int tid, String name, String hexColor) {
        this.tid = tid;
        this.color = hexColor;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (tid != section.tid) return false;
        if (name != null ? !name.equals(section.name) : section.name != null) return false;
        return color != null ? color.equals(section.color) : section.color == null;
    }

    @Override
    public int hashCode() {
        int result = tid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Section{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}