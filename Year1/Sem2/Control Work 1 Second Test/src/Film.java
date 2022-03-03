public class Film {

    String name;
    int publishDate;
    Producer producer;
    int id;

    public Film(String name, int publishDate, Producer producer, int id) {
        this.name = name;
        this.publishDate = publishDate;
        this.producer = producer;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public Producer getProducer() {
        return producer;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", publishedInDate=" + publishDate +
                ", producer=" + producer +
                ", id=" + id +
                '}';
    }
}
