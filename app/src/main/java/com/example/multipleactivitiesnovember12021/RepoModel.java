package com.example.multipleactivitiesnovember12021;

public class RepoModel {
    String name;
    String url;
    Integer forks;
    Integer watchers;
    Integer issues;

    public RepoModel() {
    }

    public RepoModel(String name, String url, Integer forks, Integer watchers, Integer issues) {
        this.name = name;
        this.url = url;
        this.forks = forks;
        this.watchers = watchers;
        this.issues = issues;
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

    public Integer getForks() {
        return forks;
    }

    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public Integer getWatchers() {
        return watchers;
    }

    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }

    public Integer getIssues() {
        return issues;
    }

    public void setIssues(Integer issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "RepoModel{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", forks=" + forks +
                ", watchers=" + watchers +
                ", branches=" + issues +
                '}';
    }
}
