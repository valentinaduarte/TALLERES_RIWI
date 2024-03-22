package entity;

public class Author {
    private int id;

    private String name;

    private String nationality;

    public Author() {
    }

    //Método constructor
    public Author(int id,String name,String nationality ) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    //Getter y setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
