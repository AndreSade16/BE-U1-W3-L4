package andreasaderi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "soccer_games")
public class SoccerGame extends Evento {

    @Column(name = "home_team")
    private String homeTeam;
    @Column(name = "away_team")
    private String awayTeam;
    @Column(name = "winning_team")
    private String winningTeam;
    @Column(name = "home_team_goals")
    private int homeTeamGoals;
    @Column(name = "away_team_goals")
    private int awayTeamGoals;

    public SoccerGame() {

    }

    public SoccerGame(String title, LocalDate date, String description, EventType eventType, int maxPartecipants, EventLocation eventLocation, String homeTeam, String awayTeam, String winningTeam, int homeTeamGoals, int awayTeamGoals) {
        super(title, date, description, eventType, maxPartecipants, eventLocation);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winningTeam = winningTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    @Override
    public String toString() {
        return "SoccerGame{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", homeTeamGoals=" + homeTeamGoals +
                ", awayTeamGoals=" + awayTeamGoals +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxPartecipants=" + maxPartecipants +
                ", eventLocation=" + eventLocation +
                '}';
    }
}
