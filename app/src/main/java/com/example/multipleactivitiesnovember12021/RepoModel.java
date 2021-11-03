package com.example.multipleactivitiesnovember12021;

public class RepoModel {
    String name;
    String url;

    public RepoModel() {
    }

    public RepoModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "RepoModel{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
