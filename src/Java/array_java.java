package Java;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

public class array_java extends Application {
    private StackPane root;
    private GridPane quizContainer;

    private int currentQuestionIndex = 0;

    private String[] questions = {
        "1.What is the primary purpose of an array in Java?",
        "2.In Java, how do you access an element within an array?",
        "3.What is the index of the first element in a Java array?",
        "4.Which statement creates an array of integers in Java?",
        "5.In Java, what is the size of an array determined by?",
        "6.Which statement can be used to find the length of an array in Java?",
        "7.What is an array index out of bounds exception in Java?",
        "8.What is the default initial value for elements in an array of integers in Java?",
        "9.In Java, which data structure can dynamically resize itself to accommodate more elements?",
        "10.Which method can be used to sort an array in Java?"
    };

    private String[][] options = {
        {"Create objects","Define a class","Store multiple values of the same type","Store a single value"},
        {"By using the 'new' keyword","By specifying the array index","By declaring a new variable","Using a for loop"},
        {"The length of the array","-1"," 1","0"},
        {"int[] myArray = int[10];"," int[] myArray = new int[10];","int[] myArray = new int[];","int myArray = new int[10];"},
        {"The maximum value specified","The initial value of the elements","The data type of the elements","The number of elements it holds"},
        {"array.getSize()","array.length","array.count","array.size()"},
        {"A built-in method to check array size"," A message indicating a successful array operation"," A warning about an array with too many elements","An error when trying to access an element outside the array's bounds"},
        {"-1","null"," 1","0"},
        {"Set","Queue"," List","Array"},
        {"shuffle()","arrange()","sort()","order()"}
    };

    private String[] correctAnswers = {
        "Store multiple values of the same type",
        "By specifying the array index",
        "0",
        " int[] myArray = new int[10];",
        "The number of elements it holds",
        "array.length",
        "An error when trying to access an element outside the array's bounds",
        "0",
        " List",
        "sort()"
    };

    private RadioButton[] optionButtons; // RadioButtons array to store answer choices

    private List<String> selectedOptions = new ArrayList<>();

    private boolean quizCompleted = false; // Track if the quiz is completed
    private int userScore = 0;

    // Define styles for correct and incorrect options
    private static final String CORRECT_OPTION_STYLE = "-fx-text-fill: green; -fx-font-size: 18px;";
    private static final String INCORRECT_OPTION_STYLE = "-fx-text-fill: red; -fx-font-size: 18px;";

    @Override
    public void start(Stage primaryStage) {
        // Create a StackPane as the main container
        root = new StackPane();

        // Set the background color of the StackPane to light blue
        root.setStyle("-fx-background-color: lightblue;");

        // Create a Rectangle with light yellow background as the card
        Rectangle cardBackground = new Rectangle(800, 500);
        cardBackground.setFill(Color.LIGHTYELLOW);

        // Add the card background to the StackPane
        root.getChildren().add(cardBackground);

        // Create a GridPane to hold the content
        quizContainer = new GridPane();
        quizContainer.setAlignment(Pos.CENTER);
        quizContainer.setPadding(new Insets(20));
        quizContainer.setHgap(10);
        quizContainer.setVgap(10);

        // Add the card content to the StackPane
        root.getChildren().add(quizContainer);

        // Create a Scene with the StackPane as the root node
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Welcome to the Quiz World");
        primaryStage.setScene(scene);

        // Call the method to set up the quiz elements
        setUpQuiz(quizContainer);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setUpQuiz(GridPane quizContainer) {
        // Create a label for the title
        Label titleLabel = new Label("Welcome to the Quiz World");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        quizContainer.add(titleLabel, 0, 0, 2, 1);
        GridPane.setMargin(titleLabel, new Insets(-100, 0, 10, 0));
        Label scoreLabel = new Label("Score: " + userScore);
        scoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        quizContainer.add(scoreLabel, 1, 7);
        GridPane.setHalignment(scoreLabel, HPos.RIGHT);

        // Create a Text for the question with a larger font size
        Text questionText = new Text(questions[currentQuestionIndex]);
        questionText.setStyle("-fx-font-size: 24px;");
        questionText.setWrappingWidth(600);

        // Create RadioButtons for answer choices with a larger font size
        ToggleGroup toggleGroup = new ToggleGroup();

        optionButtons = new RadioButton[4]; // Initialize the RadioButtons array

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new RadioButton(options[currentQuestionIndex][i]);
            optionButtons[i].setToggleGroup(toggleGroup);
            optionButtons[i].setWrapText(true);
            optionButtons[i].setStyle("-fx-font-size: 18px;");
        }

        // Create an HBox for the "Submit," "Back," and "Next" buttons
        HBox buttonBox = new HBox(20);

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 18px;");
        backButton.setMinWidth(100);
        backButton.setMinHeight(40);

        backButton.setOnMouseEntered(event -> {
            backButton.setStyle("-fx-background-color: lightcoral; -fx-border-color: black; -fx-border-radius: 3; -fx-font-size: 18px;");
            backButton.setMinWidth(100);
            backButton.setMinHeight(40);
        });

        backButton.setOnMouseExited(event -> {
            backButton.setStyle("-fx-font-size: 18px;");
            backButton.setMinWidth(100);
            backButton.setMinHeight(40);
        });

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 18px;");
        submitButton.setMinWidth(100);
        submitButton.setMinHeight(40);

        submitButton.setOnMouseEntered(event -> {
            submitButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-radius: 3; -fx-font-size: 18px;");
            submitButton.setMinWidth(100);
            submitButton.setMinHeight(40);
        });

        submitButton.setOnMouseExited(event -> {
            submitButton.setStyle("-fx-font-size: 18px;");
            submitButton.setMinWidth(100);
            submitButton.setMinHeight(40);
        });

        Button nextButton = new Button("Next");
        nextButton.setStyle("-fx-font-size: 18px;");
        nextButton.setMinWidth(100);
        nextButton.setMinHeight(40);

        nextButton.setOnMouseEntered(event -> {
            nextButton.setStyle("-fx-background-color: lightcoral; -fx-border-color: black; -fx-border-radius: 3; -fx-font-size: 18px;");
            nextButton.setMinWidth(100);
            nextButton.setMinHeight(40);
        });

        nextButton.setOnMouseExited(event -> {
            nextButton.setStyle("-fx-font-size: 18px;");
            nextButton.setMinWidth(100);
            nextButton.setMinHeight(40);
        });

        HBox.setMargin(backButton, new Insets(20, 10, 0, 0));
        HBox.setMargin(submitButton, new Insets(20, 0, 0, 0));
        HBox.setMargin(nextButton, new Insets(20, 0, 0, 0));

        buttonBox.getChildren().addAll(backButton, submitButton, nextButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add elements to the GridPane
        quizContainer.add(questionText, 0, 1, 2, 1);
        for (int i = 0; i < 4; i++) {
            quizContainer.add(optionButtons[i], 0, i + 2, 2, 1);
        }
        quizContainer.add(buttonBox, 1, 6);

        // Initialize selectedOptions ArrayList
        for (int i = 0; i < questions.length; i++) {
            selectedOptions.add("");
        }

        // Create an event handler for the "Back" button
        backButton.setOnAction(event -> {
            if (currentQuestionIndex > 0) {
                RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
                if (selectedOption != null) {
                    selectedOptions.set(currentQuestionIndex, selectedOption.getText());
                }
                currentQuestionIndex--;
                questionText.setText(questions[currentQuestionIndex]);

                // Update answer options based on the current question
                for (int i = 0; i < 4; i++) {
                    optionButtons[i].setText(options[currentQuestionIndex][i]);
                    optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                }

                toggleGroup.selectToggle(getSelectedOptionForCurrentQuestion());

                if (currentQuestionIndex < questions.length - 1) {
                    // Allow navigation to the next question if we're not on the last question
                    quizCompleted = false;
                }

                // Highlight the selected answer for the current question
                RadioButton currentSelectedOption = getSelectedOptionForCurrentQuestion();
                if (currentSelectedOption != null) {
                    if (selectedOptions.get(currentQuestionIndex).equals(correctAnswers[currentQuestionIndex])) {
                        currentSelectedOption.setStyle(CORRECT_OPTION_STYLE);
                    } else {
                        currentSelectedOption.setStyle(INCORRECT_OPTION_STYLE);
                    }
                }
            }
        });

        // Create an event handler for the "Next" button
        nextButton.setOnAction(event -> {
            if (currentQuestionIndex < questions.length - 1 && !quizCompleted) {
                RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
                if (selectedOption != null) {
                    selectedOptions.set(currentQuestionIndex, selectedOption.getText());
                }
                currentQuestionIndex++;
                questionText.setText(questions[currentQuestionIndex]);

                // Update answer options based on the current question
                for (int i = 0; i < 4; i++) {
                    optionButtons[i].setText(options[currentQuestionIndex][i]);
                    optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                }

                toggleGroup.selectToggle(getSelectedOptionForCurrentQuestion());

                // Highlight the selected answer for the current question
                RadioButton currentSelectedOption = getSelectedOptionForCurrentQuestion();
                if (currentSelectedOption != null) {
                    if (selectedOptions.get(currentQuestionIndex).equals(correctAnswers[currentQuestionIndex])) {
                        currentSelectedOption.setStyle(CORRECT_OPTION_STYLE);
                    } else {
                        currentSelectedOption.setStyle(INCORRECT_OPTION_STYLE);
                    }
                }
            }
        });

        // Create an event handler for the submit button
        submitButton.setOnAction(event -> {
            if (!quizCompleted) {
                RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
                if (selectedOption != null) {
                    selectedOptions.set(currentQuestionIndex, selectedOption.getText());
        
                    // Highlight the selected answer as correct (green) or incorrect (red)
                    if (selectedOption.getText().equals(correctAnswers[currentQuestionIndex])) {
                        for (int i = 0; i < 4; i++) {
                            optionButtons[i].setText(options[currentQuestionIndex][i]);
                            optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                        }
                        selectedOption.setStyle(CORRECT_OPTION_STYLE);
                    } else {
                        for (int i = 0; i < 4; i++) {
                            optionButtons[i].setText(options[currentQuestionIndex][i]);
                            optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                        }
                        selectedOption.setStyle(INCORRECT_OPTION_STYLE);
                    }
        
                    if (selectedOption.getText().equals(correctAnswers[currentQuestionIndex])) {
                        userScore++; // Increase the user's score for a correct answer
                    }
                }
        
                if (currentQuestionIndex == questions.length - 1) {
                    quizCompleted = true;
                    scoreLabel.setText("Total Score: " + userScore); // Update the score label with the total score
                } else {
                    nextButton.fire(); // Automatically move to the next question
                }
            }
        });
    }


    private RadioButton getSelectedOptionForCurrentQuestion() {
        String selectedOptionText = selectedOptions.get(currentQuestionIndex);
        for (RadioButton option : optionButtons) {
            if (option.getText().equals(selectedOptionText)) {
                return option;
            }
        }
        return null;
    }
}
