package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;
import com.vaadin.flow.component.html.Div;

@Route("")
public class MainView extends VerticalLayout {

    private final RestTemplate restTemplate = new RestTemplate();
    private TextField matchIdField = new TextField("Enter Match ID(Enter 1 to get the data shown in Assignment)");
    private Button fetchButton = new Button("Fetch Match Stats");

    private Label dateLabel = new Label("Date: ");
    private Label team1Label = new Label("Team 1");
    private Label team2Label = new Label("Team 2");

    private Label goalsLabel = new Label("Goals:");
    private Label possessionLabel = new Label("Possession:");
    private Label passesLabel = new Label("Total Passes:");
    private Label shotsLabel = new Label("Shots:");
    private Label shotsOnTargetLabel = new Label("Shots on Target:");
    private Label cornersLabel = new Label("Corners:");

    private Label team1Goals = new Label();
    private Label team2Goals = new Label();
    private Label team1Possession = new Label();
    private Label team2Possession = new Label();
    private Label team1Passes = new Label();
    private Label team2Passes = new Label();
    private Label team1Shots = new Label();
    private Label team2Shots = new Label();
    private Label team1ShotsOnTarget = new Label();
    private Label team2ShotsOnTarget = new Label();
    private Label team1Corners = new Label();
    private Label team2Corners = new Label();

    public MainView() {
        setSpacing(true);

        fetchButton.addClickListener(event -> fetchMatchStats());

        // Create Layout
        add(matchIdField, fetchButton);

        Div tableLayout = new Div();
        tableLayout.getStyle().set("border", "1px solid black")
                .set("padding", "10px")
                .set("display", "inline-block")
                .set("text-align", "center");

        // Date Row
        Div dateRow = new Div(dateLabel);
        dateRow.getStyle().set("font-weight", "bold").set("margin-bottom", "10px");
        tableLayout.add(dateRow);

        // Headers
        HorizontalLayout headerRow = createRow("", team1Label, team2Label, true);
        tableLayout.add(headerRow);

        // Data Rows
        tableLayout.add(createRow("Goals:", team1Goals, team2Goals, false));
        tableLayout.add(createRow("Possession:", team1Possession, team2Possession, false));
        tableLayout.add(createRow("Total Passes:", team1Passes, team2Passes, false));
        tableLayout.add(createRow("Shots:", team1Shots, team2Shots, false));
        tableLayout.add(createRow("Shots on Target:", team1ShotsOnTarget, team2ShotsOnTarget, false));
        tableLayout.add(createRow("Corners:", team1Corners, team2Corners, false));

        add(tableLayout);
    }

    private HorizontalLayout createRow(String statLabel, Label team1Value, Label team2Value, boolean isHeader) {
        Label label = new Label(statLabel);
        label.getStyle().set("width", "150px").set("font-weight", isHeader ? "bold" : "normal");

        team1Value.getStyle().set("width", "100px");
        team2Value.getStyle().set("width", "100px");

        HorizontalLayout row = new HorizontalLayout(label, team1Value, team2Value);
        row.getStyle().set("border", "1px solid black").set("padding", "5px");
        return row;
    }

    private void fetchMatchStats() {
        String matchId = matchIdField.getValue();
        if (matchId.isEmpty()) {
            Notification.show("Please enter a Match ID ");
            return;
        }

        String url = "http://localhost:8080/getMatchStats?matchId=" + matchId;
        try {
            MatchStats stats = restTemplate.getForObject(url, MatchStats.class);
            if (stats != null && stats.getStats() != null) {
                TeamStats teamA = stats.getStats().get("teamA");
                TeamStats teamB = stats.getStats().get("teamB");

                dateLabel.setText("Date: " + stats.getDate());
                team1Goals.setText(teamA.getGoals());
                team2Goals.setText(teamB.getGoals());
                team1Possession.setText(teamA.getPossession());
                team2Possession.setText(teamB.getPossession());
                team1Passes.setText(teamA.getPasses());
                team2Passes.setText(teamB.getPasses());
                team1Shots.setText(teamA.getShots());
                team2Shots.setText(teamB.getShots());
                team1ShotsOnTarget.setText(teamA.getShotsOnTarget());
                team2ShotsOnTarget.setText(teamB.getShotsOnTarget());
                team1Corners.setText(teamA.getCorners());
                team2Corners.setText(teamB.getCorners());
            } else {
                Notification.show("No data found for this Match ID");
            }
        } catch (Exception e) {
            Notification.show("Error fetching data. Ensure the backend is running.");
        }
    }
}
