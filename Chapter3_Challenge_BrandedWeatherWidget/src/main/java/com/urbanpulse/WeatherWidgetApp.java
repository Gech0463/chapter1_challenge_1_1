package com.urbanpulse;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WeatherWidgetApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // BorderPane Root
        BorderPane root = new BorderPane();
        root.getStyleClass().add("main-container");

        // --- TOP: Header ---
        VBox headerBox = new VBox(10);
        headerBox.getStyleClass().add("header-container");

        Label cityLabel = new Label("NEO CITY");
        cityLabel.getStyleClass().add("city-title");

        HBox inputSearchBox = new HBox(10);
        inputSearchBox.setAlignment(Pos.CENTER);
        
        TextField cityField = new TextField();
        cityField.setPromptText("Enter City...");
        cityField.getStyleClass().add("search-field");

        Button refreshBtn = new Button("REFRESH PULSE");
        refreshBtn.getStyleClass().add("refresh-button");

        // Binding: Disable button if TextField is empty
        refreshBtn.disableProperty().bind(cityField.textProperty().isEmpty());
        
        // Action to update city name (simple demo logic)
        refreshBtn.setOnAction(e -> {
            cityLabel.setText(cityField.getText().toUpperCase());
            cityField.clear();
        });

        inputSearchBox.getChildren().addAll(cityField, refreshBtn);
        headerBox.getChildren().addAll(cityLabel, inputSearchBox);
        root.setTop(headerBox);

        // --- CENTER: Main Weather Content ---
        VBox centerBox = new VBox(15);
        centerBox.getStyleClass().add("center-container");

        // Temperature
        Text tempText = new Text("24°C");
        tempText.getStyleClass().add("temp-large");

        // Description
        Label conditionLabel = new Label("PARTLY CLOUDED / DATA STABLE");
        conditionLabel.getStyleClass().add("condition-text");

        // Company Shape: Urban Pulse Labs (City Building / Network Icon)
        SVGPath cityIcon = new SVGPath();
        cityIcon.setContent("M10 20V14H14V20H19V12H22L12 3L2 12H5V20H10Z"); // Simple House/Building SVG
        cityIcon.setScaleX(3);
        cityIcon.setScaleY(3);
        cityIcon.getStyleClass().add("city-shape");

        // Animation: Pulse Scaling for the Icon
        ScaleTransition pulse = new ScaleTransition(Duration.seconds(2), cityIcon);
        pulse.setFromX(3);
        pulse.setFromY(3);
        pulse.setToX(3.3);
        pulse.setToY(3.3);
        pulse.setCycleCount(Animation.INDEFINITE);
        pulse.setAutoReverse(true);
        pulse.play();

        // Urban Pulse Enhancements
        HBox statsBox = new HBox(20);
        statsBox.getStyleClass().add("stats-container");

        VBox commuteBox = createStatBox("COMMUTE IMPACT", "LOW - 4ms");
        VBox uvBox = createStatBox("UV INDEX", "3 (MODERATE)");
        VBox transitBox = createStatBox("METRORail", "ON TIME");

        statsBox.getChildren().addAll(commuteBox, uvBox, transitBox);

        centerBox.getChildren().addAll(cityIcon, tempText, conditionLabel, statsBox);
        root.setCenter(centerBox);

        // --- BOTTOM: Forecast ---
        HBox forecastBox = new HBox(15);
        forecastBox.getStyleClass().add("forecast-container");

        forecastBox.getChildren().addAll(
            createForecastCard("MON", "22°"),
            createForecastCard("TUE", "25°"),
            createForecastCard("WED", "21°")
        );
        root.setBottom(forecastBox);

        // --- Scene & Stage ---
        Scene scene = new Scene(root, 450, 650);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        
        primaryStage.setTitle("Urban Pulse Labs | Weather Analytics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createStatBox(String label, String value) {
        VBox box = new VBox(5);
        box.getStyleClass().add("stat-box");
        
        Label lbl = new Label(label);
        lbl.getStyleClass().add("stat-label");
        
        Label val = new Label(value);
        val.getStyleClass().add("stat-value");
        
        box.getChildren().addAll(lbl, val);
        return box;
    }

    private VBox createForecastCard(String day, String temp) {
        VBox card = new VBox(8);
        card.getStyleClass().add("forecast-card");

        Label dayLbl = new Label(day);
        dayLbl.getStyleClass().add("forecast-day");

        Label tempLbl = new Label(temp);
        tempLbl.getStyleClass().add("forecast-temp");

        card.getChildren().addAll(dayLbl, tempLbl);
        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
