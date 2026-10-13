package com.stylecumpx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "occasions")
public class Occasion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
    private String suggestedStyle;

    public Occasion() {}

    public Occasion(Long id, String name, String description, String suggestedStyle) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.suggestedStyle = suggestedStyle;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSuggestedStyle() { return suggestedStyle; }
    public void setSuggestedStyle(String suggestedStyle) { this.suggestedStyle = suggestedStyle; }
}