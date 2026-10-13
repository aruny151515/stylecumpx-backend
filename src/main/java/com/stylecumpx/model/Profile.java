package com.stylecumpx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String course;
    private String department;
    private String year;
    private String stylePreference;
    private String favoriteColors;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Profile() {}

    public Profile(Long id, String fullName, String course, String department, String year, String stylePreference, String favoriteColors, User user) {
        this.id = id;
        this.fullName = fullName;
        this.course = course;
        this.department = department;
        this.year = year;
        this.stylePreference = stylePreference;
        this.favoriteColors = favoriteColors;
        this.user = user;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getStylePreference() { return stylePreference; }
    public void setStylePreference(String stylePreference) { this.stylePreference = stylePreference; }

    public String getFavoriteColors() { return favoriteColors; }
    public void setFavoriteColors(String favoriteColors) { this.favoriteColors = favoriteColors; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}