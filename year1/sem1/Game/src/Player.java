public class Player {


    protected String name;
    protected float player_health=10;
    protected float player_dmg=1;

    public float get_health(){
        return player_health;
    }

    public float dmg_dealt(){
        return  player_dmg;
    }

    public String get_name(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer_dmg(float player_dmg) {
        this.player_dmg = player_dmg;
    }

    public void setPlayer_health(float player_health) {
        this.player_health = player_health;
    }

    public void resetStatus(){
       setPlayer_dmg(1);
       setPlayer_health(100);
    }
}
