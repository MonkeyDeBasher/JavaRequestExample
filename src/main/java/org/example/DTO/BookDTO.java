package org.example.DTO;

public class BookDTO {
    private String title;
    private String author;
    private String description;
    private String category;
    private Integer price;
    private String UrlImg;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setUrlImg(String urlImg) {
        UrlImg = urlImg;
    }
}

