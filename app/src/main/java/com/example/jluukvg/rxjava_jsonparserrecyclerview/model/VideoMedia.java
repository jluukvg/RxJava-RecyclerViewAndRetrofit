package com.example.jluukvg.rxjava_jsonparserrecyclerview.model;

/**
 * Created by jluukvg on 3/23/2017.
 *
 */

public class VideoMedia {

    public final int mid;
    public final String title;
    public final int created;
    public final int changed;
    public final int duration;
    private final String video_url;
    public final String text;
    public final String hls;
    public final String video_id;
    public final String video_type;
    public final DrupalImage image;

    public VideoMedia(int mid, String title, int created, int changed, int duration, String video_url, String text, String video_type, String hls, String video_id, DrupalImage image) {
        this.mid = mid;
        this.title = title;
        this.created = created;
        this.changed = changed;
        this.duration = duration;
        this.video_url = video_url;
        this.text = text;
        this.hls = hls;
        this.video_id = video_id;
        this.video_type = video_type;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoMedia that = (VideoMedia) o;

        if (mid != that.mid) return false;
        if (created != that.created) return false;
        if (changed != that.changed) return false;
        if (duration != that.duration) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (video_url != null ? !video_url.equals(that.video_url) : that.video_url != null)
            return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (hls != null ? !hls.equals(that.hls) : that.hls != null) return false;
        if (video_id != null ? !video_id.equals(that.video_id) : that.video_id != null)
            return false;
        if (video_type != null ? !video_type.equals(that.video_type) : that.video_type != null)
            return false;
        return image != null ? image.equals(that.image) : that.image == null;
    }

    @Override
    public int hashCode() {
        int result = mid;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + created;
        result = 31 * result + changed;
        result = 31 * result + duration;
        result = 31 * result + (video_url != null ? video_url.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (hls != null ? hls.hashCode() : 0);
        result = 31 * result + (video_id != null ? video_id.hashCode() : 0);
        result = 31 * result + (video_type != null ? video_type.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VideoMedia{" +
                "mid=" + mid +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", changed=" + changed +
                ", duration=" + duration +
                ", video_url='" + video_url + '\'' +
                ", text='" + text + '\'' +
                ", hls='" + hls + '\'' +
                ", video_id='" + video_id + '\'' +
                ", video_type='" + video_type + '\'' +
                ", image=" + image +
                '}';
    }
}
