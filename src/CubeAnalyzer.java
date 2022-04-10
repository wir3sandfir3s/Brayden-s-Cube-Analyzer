import cube.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import util.Observer;

import java.util.HashMap;

public class CubeAnalyzer extends Application implements Observer<Cube, String> {

    private static final HashMap<Colors, Background> colors = new HashMap<>() {

        {

            put(Colors.GREEN, new Background(new BackgroundFill(Color.GREEN, null, null)));
            put(Colors.BLUE, new Background(new BackgroundFill(Color.BLUE, null, null)));
            put(Colors.RED, new Background(new BackgroundFill(Color.RED, null, null)));
            put(Colors.WHITE, new Background(new BackgroundFill(Color.WHITE, null, null)));
            put(Colors.ORANGE, new Background(new BackgroundFill(Color.ORANGE, null, null)));
            put(Colors.YELLOW, new Background(new BackgroundFill(Color.YELLOW, null, null)));

        }

    };

    Cube cube;

    private BorderPane window;
    private GridPane buttons;
    private GridPane faces;

    public void init(){

        this.cube = new Cube();
        this.cube.addObserver(this);

    }

    private GridPane makeFaces(){

        GridPane output = new GridPane();
        HashMap<Character, Colors[][]> colorMap = this.cube.makeColorMap();

        for(int c = 0; c < 3; c++){

            for(int r = 0; r < 3; r++){

                Button panel = new Button();
                panel.setBackground(colors.get(colorMap.get('U')[c][r]));
                output.add(panel, c + 3, r);

            }

        }

        for(int c = 0; c < 3; c++){

            for(int r = 0; r < 3; r++){

                Button panel = new Button();
                panel.setBackground(colors.get(colorMap.get('L')[c][r]));
                output.add(panel, c, r + 3);

            }

        }

        for(int c = 0; c < 3; c++){

            for(int r = 0; r < 3; r++){

                Button panel = new Button();
                panel.setBackground(colors.get(colorMap.get('F')[c][r]));
                output.add(panel, c + 3, r + 3);

            }

        }

        for(int c = 0; c < 3; c++){

            for(int r = 0; r < 3; r++){

                Button panel = new Button();
                panel.setBackground(colors.get(colorMap.get('R')[c][r]));
                output.add(panel, c + 6, r + 3);

            }

        }

        for(int c = 0; c < 3; c++){

            for(int r = 0; r < 3; r++){

                Button panel = new Button();
                panel.setBackground(colors.get(colorMap.get('B')[c][r]));
                output.add(panel, c + 9, r + 3);

            }

        }

        for(int c = 0; c < 3; c++){

            for(int r = 0; r < 3; r++){

                Button panel = new Button();
                panel.setBackground(colors.get(colorMap.get('D')[c][r]));
                output.add(panel, c + 3, r + 6);

            }

        }

        return output;

    }

    private GridPane makeButtons(){

        GridPane output = new GridPane();

        Button button = new Button("R");
        button.setOnAction(e -> {
            try {
                this.cube.turn("R");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 0, 0);

        button = new Button("U");
        button.setOnAction(e -> {
            try {
                this.cube.turn("U");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 1, 0);

        button = new Button("F");
        button.setOnAction(e -> {
            try {
                this.cube.turn("F");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 2, 0);

        button = new Button("L");
        button.setOnAction(e -> {
            try {
                this.cube.turn("L");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 3, 0);

        button = new Button("D");
        button.setOnAction(e -> {
            try {
                this.cube.turn("D");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 4, 0);

        button = new Button("B");
        button.setOnAction(e -> {
            try {
                this.cube.turn("B");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 5, 0);

        button = new Button("R'");
        button.setOnAction(e -> {
            try {
                this.cube.turn("R'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 0, 1);

        button = new Button("U'");
        button.setOnAction(e -> {
            try {
                this.cube.turn("U'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 1, 1);

        button = new Button("F'");
        button.setOnAction(e -> {
            try {
                this.cube.turn("F'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 2, 1);

        button = new Button("L'");
        button.setOnAction(e -> {
            try {
                this.cube.turn("L'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 3, 1);

        button = new Button("D'");
        button.setOnAction(e -> {
            try {
                this.cube.turn("D'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 4, 1);

        button = new Button("B'");
        button.setOnAction(e -> {
            try {
                this.cube.turn("B'");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        output.add(button, 5, 1);

        return output;

    }

    public void start(Stage mainStage){

        this.window = new BorderPane();
        this.buttons = makeButtons();

        this.window.setCenter(makeFaces());
        this.window.setBottom(this.buttons);

        Scene scene = new Scene(this.window);
        mainStage.setScene(scene);
        mainStage.setTitle("Brayden's Cube Analyzer");
        mainStage.setWidth(400);
        mainStage.setHeight(400);
        mainStage.show();

    }

    public void update(Cube cube, String message){

        System.out.println(message);

        this.window.setCenter(makeFaces());

    }

    public static void main(String[] args){

        Application.launch();

    }

}
