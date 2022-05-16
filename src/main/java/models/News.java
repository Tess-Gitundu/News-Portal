package models;

import java.util.Objects;

public class News {
    private String title;
    private String content;
    private int departmentId;
    private int id;

    public News(String title, String content, int departmentId) {
        this.title = title;
        this.content = content;
        this.departmentId = departmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return departmentId == news.departmentId && id == news.id && Objects.equals(title, news.title) && Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, departmentId, id);
    }
}
