public class ClubAffiliation {

    Club club;
    Player player;
    int preMonth;
    int  conclusionContractYear;

    public ClubAffiliation(Club club, Player player, int preMonth, int conclusionContractYear) {
        this.club = club;
        this.player = player;
        this.preMonth = preMonth;
        this.conclusionContractYear = conclusionContractYear;
    }

    public Club getClub() {
        return club;
    }


    public Player getPlayer() {
        return player;
    }

    public int getConclusionContractYear() {
        return conclusionContractYear;
    }


    public boolean wasIConnectedInThisYear(int year){
            int start = this.getConclusionContractYear();
            int preYears = (preMonth/12);
            return  year>=start && year<=(start+preYears);
    }

}
