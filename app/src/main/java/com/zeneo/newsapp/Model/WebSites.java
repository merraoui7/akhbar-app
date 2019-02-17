package com.zeneo.newsapp.Model;

public class WebSites {

<<<<<<< HEAD
    int image;

    public WebSites( int image) {
        this.image = image;
    }

=======
    String name;
    int image;

    public WebSites(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
>>>>>>> b36c8c45a96fc4dfdcc9a0d2f1cc743e3efee5d7

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
