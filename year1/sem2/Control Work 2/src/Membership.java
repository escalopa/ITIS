public class Membership {

    User user;
    Group group;

    public Membership(User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }
}
