public class Like<T,L,S,K,Q>{

    private final User<T,L,S,K,Q>  liker;
    private final Message<T,L,S,K,Q> message;

    public Like(User<T,L,S,K,Q> liker, Message<T,L,S,K,Q> message) {
        this.liker = liker;
        this.message = message;
    }

    public User<T,L,S,K,Q> getLiker() {
        return liker;
    }

    public Message<T,L,S,K,Q> getMessage() {
        return message;
    }

}
