package com.example.collegeconnect;

public class SearchData {
    private String heading;
    private String description;
    private Integer image;

    public SearchData(String heading, String description, Integer image) {
        this.heading = heading;
        this.description = description;
        this.image = image;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
