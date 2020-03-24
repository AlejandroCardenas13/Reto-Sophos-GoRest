package com.sophos.gorest.models;

public class Photo {


    private String albumId;
    private String title;
    private String url;
    private String thumbnail;

    public Photo() {
        this.albumId = "";
        this.title = "";
        this.url = "";
        this.thumbnail = "";
    }

    @Override
    public String toString() {
        return "Photo{" +
                " AlbumId='" + albumId + '\'' +
                ", Title='" + title + '\'' +
                ", Url='" + url + '\'' +
                ", Thumbnail='" + thumbnail + '\'' +
                '}';
    }


    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}