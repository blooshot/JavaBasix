package org.basix.Library;

import java.util.ArrayList;
import org.joda.time.DateTime;


public class Books{
    private long id = 1l;
    private String title;
    private String author;
    private double price;
    private boolean status;
    private ArrayList<String> tags;

    private String created_at;


    /*public Books(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
//        this.tags = ;
        this.status = true;
        getCreated_at();
    }*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getCreated_at() {
        created_at = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }

 /*   @Override
    public boolean create(){

    }

    @Override
    public String read(String objType) {
        return null;
    }

    @Override
    public boolean delete(Integer id, Object objType) {
        return false;
    }*/

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", existance=" + status +
                ", tags=" + tags +
                ", created_at='" + created_at + '\'' +
                '}';
    }
   /* public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }*/
}
