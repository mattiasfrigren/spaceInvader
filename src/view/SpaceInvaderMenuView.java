package view;

import controller.SpaceInvaderButtonListener;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Constants;

import java.util.ArrayList;

public class SpaceInvaderMenuView implements IViewState {
    private ArrayList<Button> buttonArrayList = new ArrayList<>();
    private Button button;
    private SubScene currentSubScene;


    private static Scene menuScene;
    private static AnchorPane menuPane;

    private static SpaceInvaderMenuView spaceInvaderMenuView;

    public static Scene getMenuScene() {
        return menuScene;
    }

    public static SpaceInvaderMenuView getSpaceInvaderMenuView() {
        if (spaceInvaderMenuView == null) {
            spaceInvaderMenuView = new SpaceInvaderMenuView();
        }
        return spaceInvaderMenuView;
    }

    private SpaceInvaderMenuView() {
        menuPane = new AnchorPane();
        menuScene = new Scene(menuPane, Constants.SCREENWIDTH, Constants.SCREENHEIGHT);

        BackgroundImage bootImage = new BackgroundImage(new Image(Constants.GameBootSceneBackGround, Constants.SCREENWIDTH, Constants.SCREENHEIGHT, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);

        menuPane.setBackground(new Background(bootImage));

        Text bootGameText = new Text("Game menu");
        bootGameText.setX(Constants.SCREENWIDTH / 2);
        bootGameText.setY(Constants.SCREENHEIGHT * 0.1);
        bootGameText.setFont(Font.font("verdana", 40));
        bootGameText.setFill(Color.GREENYELLOW);
        menuPane.getChildren().add(bootGameText);
        createButtonToList();
        initializeButtonListerners();
    }

    private void createButtonToList() {
        String[] buttonList = {"Play", "Highscore", "Setting", "Help", "Credits", "Exit"};
        for (int i = 1; i < buttonList.length + 1; i++) {
            createButton(buttonList[i - 1], Constants.menuButtonStartingXPos, Constants.menuButtonStartingYPos * (i * 0.2));
        }
        menuPane.getChildren().addAll(buttonArrayList);
    }

    public void initializeHighScoreSubScene() {

        if (currentSubScene != null) {
            menuPane.getChildren().remove(currentSubScene);
        }

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.GameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Highscore");
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }

    public void initializeCreditsSubScene() {

        if (currentSubScene != null) {
            menuPane.getChildren().remove(currentSubScene);
        }

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.GameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Credits");
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }

    public void initializeSettingsSubScene() {

        if (currentSubScene != null) {
            menuPane.getChildren().remove(currentSubScene);
        }

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.GameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Settings");
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }

    public void initializeHelpSubScene() {

        if (currentSubScene != null) {
            menuPane.getChildren().remove(currentSubScene);
        }

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.GameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Help");
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }

    //give the user options to either exit the game or return to the menu
    public void initializeExitSubScene(){
        if (currentSubScene != null) {
            menuPane.getChildren().remove(currentSubScene);
        }

        AnchorPane exitAnchor = new AnchorPane();
        currentSubScene = new SubScene(exitAnchor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.GameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        exitAnchor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text exitText = new Text("Are you sure you want to quit?");
        exitAnchor.getChildren().add(exitText);

        createButton("yes", Constants.menuButtonStartingXPos, Constants.menuButtonStartingYPos);
        createButton("no", Constants.menuButtonStartingXPos, Constants.menuButtonStartingYPos);

        menuPane.getChildren().add(currentSubScene);
    }
    
    

    private void createButton(String buttonText, double x, double y) {
        button = new Button(buttonText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setFont(Font.font("Verdana", 20));
        button.setPrefWidth(Constants.menuButtonWidth);
        //button.setPrefHeight(buttonHight);
        buttonArrayList.add(button);
    }

    private void initializeButtonListerners() {
        buttonArrayList.get(0).addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().startGame);
        buttonArrayList.get(1).addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().showHighScore);
        buttonArrayList.get(2).addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().showSettings);
        buttonArrayList.get(3).addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().showHelp);
        buttonArrayList.get(4).addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().showCredits);
        buttonArrayList.get(5).addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().exit);
        for (Button button : buttonArrayList) {
            {
                button.setOnMousePressed(e -> {
                    if (e.getButton().equals(MouseButton.PRIMARY)) {
                        button.setStyle(Constants.buttonBgClickedURL);
                        button.setFont(Font.font("Verdana", 18));
                        button.setLayoutY(button.getLayoutY()+4);
                    }
                });
                button.setOnMouseEntered(e->{button.setEffect(new DropShadow());
                });
                button.setOnMouseExited(e->{button.setEffect(null);
                });
                button.setOnMouseReleased(e->{
                    if (e.getButton().equals(MouseButton.PRIMARY)){
                        button.setStyle(Constants.buttonBgURL);
                        button.setFont(Font.font("Verdana", 20));
                        button.setLayoutY(button.getLayoutY()-4);
                    }
                });


            }


        }


    }
}