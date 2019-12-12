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
    private static SubScene currentSubScene;
    private Button yesButton;
    private Button noButton;


    private SubScene exitSubScene;
    private AnchorPane exitSubAnchorPane;
    BackgroundImage buttonOncklickeImg = new BackgroundImage(new Image(Constants.buttonBgClickedURL), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    Background buttonOnOnclickBackground = new Background(buttonOncklickeImg);
    BackgroundImage buttonOnReleasedImage = new BackgroundImage(new Image(Constants.buttonBgURL), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    Background buttonOnReleasedBackground = new Background(buttonOnReleasedImage);

    private static Scene menuScene;
    private static AnchorPane menuPane;

    private static SpaceInvaderMenuView spaceInvaderMenuView;

    public static Scene getMenuScene() {
        return menuScene;
    }

    public static AnchorPane getMenuPane(){
        return menuPane;
    }

    public static SubScene getCurrentSubScene(){
        return currentSubScene;
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

        BackgroundImage bootImage = new BackgroundImage(new Image(Constants.gameBootSceneBackGround, Constants.SCREENWIDTH, Constants.SCREENHEIGHT, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);

        menuPane.setBackground(new Background(bootImage));

        Text bootGameText = new Text("Game menu");
        bootGameText.setX(Constants.SCREENWIDTH / 3);
        bootGameText.setY(Constants.SCREENHEIGHT * 0.07);
        bootGameText.setFont(Font.font("verdana", 40));
        bootGameText.setFill(Color.color(0.75, 0.9, 0.9));
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

        closeCurrentSubScene();

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.gameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Highscore"); //TODO COLOR SET on text in the subscene
        text.setX(Constants.SCREENWIDTH / 3);
        text.setY(Constants.SCREENHEIGHT / 3);
        // text.setFill(Color.ORANGERED);
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }

    public void initializeCreditsSubScene() {

        closeCurrentSubScene();

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.gameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Credits"); //TODO se highScore
        text.setX(Constants.SCREENWIDTH / 3);
        text.setY(Constants.SCREENHEIGHT / 3);
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }

    public void initializeSettingsSubScene() {

        closeCurrentSubScene();

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.gameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Settings"); //TODO COLOR SET
        text.setX(Constants.SCREENWIDTH / 3);
        text.setY(Constants.SCREENHEIGHT / 3);
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }

    public void initializeHelpSubScene() {

        closeCurrentSubScene();

        AnchorPane scoreAncor = new AnchorPane();
        currentSubScene = new SubScene(scoreAncor, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45);

        BackgroundImage image = new BackgroundImage(new Image(Constants.gameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        scoreAncor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text text = new Text("Help"); //TODO COLOR SET
        text.setX(Constants.SCREENWIDTH / 3);
        text.setY(Constants.SCREENHEIGHT / 3);
        scoreAncor.getChildren().add(text);
        menuPane.getChildren().add(currentSubScene);
    }


    public void initializeExitSubScene(){
        double subSceneWidth = Constants.SCREENWIDTH * 0.45;
        double subSceneHeight = Constants.SCREENHEIGHT * 0.45;

        closeCurrentSubScene();

        AnchorPane exitAnchor = new AnchorPane();
        currentSubScene = new SubScene(exitAnchor, subSceneWidth, subSceneHeight);

        BackgroundImage image = new BackgroundImage(new Image(Constants.gameOverSubSceneBackground, Constants.SCREENWIDTH * 0.45, Constants.SCREENHEIGHT * 0.45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        exitAnchor.setBackground(new Background(image));

        currentSubScene.setLayoutX(Constants.SCREENWIDTH / 3);
        currentSubScene.setLayoutY(Constants.SCREENHEIGHT / 3);

        Text exitText = new Text("Are you sure you want to quit?");
        exitText.setX(subSceneWidth/8);
        exitText.setY(subSceneHeight/3);
        exitText.setFont(Font.font("Verdana", 20));
        exitAnchor.getChildren().add(exitText);

        yesButton = new Button("yes");
        yesButton.setLayoutX(subSceneWidth/5);
        yesButton.setLayoutY(subSceneHeight/2);
        yesButton.setFont(Font.font("Verdana", 20));
        yesButton.setPrefWidth(Constants.menuButtonWidth*0.7);
        exitAnchor.getChildren().add(yesButton);

        noButton = new Button("no");
        noButton.setLayoutX(subSceneWidth/2);
        noButton.setLayoutY(subSceneHeight/2);
        noButton.setFont(Font.font("Verdana", 20));
        noButton.setPrefWidth(Constants.menuButtonWidth*0.7);
        exitAnchor.getChildren().add(noButton);

        yesButton.addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().reallyExit);
        noButton.addEventFilter(MouseEvent.MOUSE_CLICKED, SpaceInvaderButtonListener.getButtonListener().exitToMenu);

        menuPane.getChildren().add(currentSubScene);
    }
    
    public void closeCurrentSubScene(){
        if (currentSubScene != null) {
            menuPane.getChildren().remove(currentSubScene);
        }
    }

    private void createButton(String buttonText, double x, double y) {
        button = new Button(buttonText);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setFont(Font.font("Verdana", 20));
        button.setTextFill(Color.color(0.75, 0.9, 0.9));
        button.setPrefWidth(Constants.menuButtonWidth);
        button.setBackground(buttonOnReleasedBackground);
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

                        button.setBackground(buttonOnOnclickBackground);
                        button.setFont(Font.font("Verdana", 18));
                        button.setLayoutY(button.getLayoutY()+4);
                    }
                });
                button.setOnMouseEntered(e->{button.setEffect(new DropShadow());
                });
                button.setOnMouseExited(e->{button.setEffect(null);
                });
                button.setOnMouseReleased(e -> {
                    if (e.getButton().equals(MouseButton.PRIMARY)) {
                        button.setBackground(buttonOnReleasedBackground);
                        button.setFont(Font.font("Verdana", 20));
                        button.setLayoutY(button.getLayoutY()-4);
                    }
                });


            }


        }


    }
}