package com.example.media.classes;

/**
 * Video class extending Media.
 */
public class Video extends Media {
    private String channel;
    private String category;
    private int views;

    public Video(String title, String channel, String category, int duration, int views) {
        super(title, duration);
        this.channel = channel;
        this.category = category;
        this.views = views;
    }

    public String getChannel() {
        return channel;
    }

    public String getCategory() {
        return category;
    }

    public long getViews() {
        return views;
    }

    @Override
    public String toString() {
        // TODO: Return string with title, channel, category, views
        return title + " — " + channel + " (" + category + "), " + views + " views";
    }
}
