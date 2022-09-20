public class Message<T,L,S,K,Q> {

    private final T id;
    private final L text;
    private final User<T,L,S,K,Q> author;

    public Message(T id, L text, User<T,L,S,K,Q> author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public T getId() {
        return id;
    }

    public L getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }
}
