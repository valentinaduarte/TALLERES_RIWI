package entity;

public class Book{
    private int id;

    private String title;

    private String publication_year;

    private Double price;

    private int author_id;

    //Método constructor
    public Book(int id, String title, String publication_year, Double price, int author_id) {
        this.id = id;
        this.title = title;
        this.publication_year = publication_year;
        this.price = price;
        this.author_id = author_id;
    }

    public Book() {

    }

    //Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    //To String

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publication_year='" + publication_year + '\'' +
                ", price=" + price +
                ", author_id=" + author_id +
                '}';
    }
}
