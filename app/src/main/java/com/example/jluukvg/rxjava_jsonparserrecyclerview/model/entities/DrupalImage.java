package com.example.jluukvg.rxjava_jsonparserrecyclerview.model.entities;

/**
 * Created by jluukvg on 3/10/2017.
 *
 */

public class DrupalImage {
    public String thumb;
    public String cover_phone;
    private String cover_tablet;
    private String photo_phone;
    private String photo_tablet;
    public String photo_full;
    private double ratio;
    public String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrupalImage that = (DrupalImage) o;

        return Double.compare(that.ratio, ratio) == 0 &&
                (thumb != null ? thumb.equals(that.thumb) : that.thumb == null) &&
                (cover_phone != null ? cover_phone.equals(that.cover_phone) : that.cover_phone == null) &&
                (cover_tablet != null ? cover_tablet.equals(that.cover_tablet) : that.cover_tablet == null) &&
                (photo_phone != null ? photo_phone.equals(that.photo_phone) : that.photo_phone == null) &&
                (photo_tablet != null ? photo_tablet.equals(that.photo_tablet) : that.photo_tablet == null) &&
                (photo_full != null ? photo_full.equals(that.photo_full) : that.photo_full == null) &&
                (text != null ? text.equals(that.text) : that.text == null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = thumb != null ? thumb.hashCode() : 0;
        result = 31 * result + (cover_phone != null ? cover_phone.hashCode() : 0);
        result = 31 * result + (cover_tablet != null ? cover_tablet.hashCode() : 0);
        result = 31 * result + (photo_phone != null ? photo_phone.hashCode() : 0);
        result = 31 * result + (photo_tablet != null ? photo_tablet.hashCode() : 0);
        result = 31 * result + (photo_full != null ? photo_full.hashCode() : 0);
        temp = Double.doubleToLongBits(ratio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DrupalImage{" +
                "thumb='" + thumb + '\'' +
                ", cover_phone='" + cover_phone + '\'' +
                ", cover_tablet='" + cover_tablet + '\'' +
                ", photo_phone='" + photo_phone + '\'' +
                ", photo_tablet='" + photo_tablet + '\'' +
                ", photo_full='" + photo_full + '\'' +
                ", ratio=" + ratio +
                ", text='" + text + '\'' +
                '}';
    }
}
