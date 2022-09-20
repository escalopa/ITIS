public class Participant {

    Film film;
    Actor actor;
    String characterName;

    public Participant(Film film, Actor actor, String characterName) {
        this.film = film;
        this.actor = actor;
        this.characterName = characterName;
    }

    public Film getFilm() {
        return film;
    }

    public Actor getActor() {
        return actor;
    }

    public String getCharacterName() {
        return characterName;
    }
}
