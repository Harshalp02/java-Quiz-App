package flutter;

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

public class function_flutter extends Application {
    private StackPane root;
    private GridPane quizContainer;

    private int currentQuestionIndex = 0;

    private String[] questions = {
        "1. What is a function in Flutter?",
        "2. How is a function defined in Dart, the programming language used in Flutter?",
        "3. What is a function parameter?",
        "4. What does the 'return' statement do in a function?",
        "5. How can you pass arguments to a function in Dart?",
        "6. What is the purpose of a function's name in Dart?",
        "7. What is a named parameter in Dart functions?",
        "8. What does the 'void' return type indicate in a function definition?",
        "9. How can you make a function reusable in multiple parts of your Flutter app?",
        "10. What is recursion in the context of functions?"
    };
    
    private String[][] options = {
        {"A piece of reusable code that performs a specific task", "A Flutter widget", "A variable declaration", "A loop structure"},
        {"Using the 'function' keyword", "With a code block enclosed in curly braces", "By declaring a variable", "By using the 'method' keyword"},
        {"A named function", "A value returned by the function", "An input to the function", "A function's return type"},
        {"It defines the function's name", "It indicates the end of the function", "It specifies the function's return value", "It has no significance in functions"},
        {"By placing them in square brackets", "By using the 'function' keyword", "By using curly braces", "By wrapping them in parentheses"},
        {"To make the function more readable", "To distinguish it from variables", "To specify the function's data type", "To indicate the function's return type"},
        {"Parameters that have names", "Parameters that have no names", "Optional parameters", "Positional parameters"},
        {"The function does not return any value", "The function is a constructor", "The function has no parameters", "The function is private"},
        {"By declaring it as a local function", "By using a function as a parameter", "By defining it within a class", "By using the 'await' keyword"},
        {"A function that calls itself", "A function with no return statement", "A function with multiple parameters", "A function that uses named parameters"}
    };
    
    private String[] correctAnswers = {
        "A piece of reusable code that performs a specific task",
        "With a code block enclosed in curly braces",
        "An input to the function",
        "It specifies the function's return value",
        "By wrapping them in parentheses",
        "To distinguish it from variables",
        "Parameters that have names",
        "The function does not return any value",
        "By defining it within a class",
        "A function that calls itself"
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
