package cpp;

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

public class function_cpp extends Application {
    private StackPane root;
    private GridPane quizContainer;

    private int currentQuestionIndex = 0;

    private String[] questions = {
        "1. What is a function in C++?",
        "2. How do you declare a function in C++?",
        "3. What is the purpose of a function prototype in C++?",
        "4. What is a return type in a function declaration?",
        "5. How do you define a function in C++?",
        "6. What is the scope of a local variable in a function?",
        "7. What is a parameter in a function?",
        "8. What is function overloading in C++?",
        "9. How do you call a function in C++?",
        "10. What is a recursive function in C++?"
    };
    
    private String[][] options = {
        {"A reserved keyword in C++", "A code block that performs a specific task", "A type of loop", "A type of variable"},
        {"functionType functionName(parameters);", "type functionName(parameters) { // code }", "declare functionName(parameters) { // code }", "void functionName(parameters) { // code }"},
        {"To reserve a function name for later use", "To define a function within another function", "To declare a variable with a function name", "To declare the function's return type and parameters without defining the function itself"},
        {"The data type of the function", "The data type of the function's return value", "The function's name", "The number of parameters the function takes"},
        {"By using the function declaration and providing the function definition", "By using the 'main' function", "By using the 'void' keyword", "By declaring the function inside another function"},
        {"It is accessible only within the function where it is defined", "It is accessible globally in the program", "It is accessible only in the 'main' function", "It is accessible only in the function definition"},
        {"An input to the function provided when calling the function", "A variable that is always global", "A reserved keyword in C++", "The function's return value"},
        {"Having multiple functions with the same name but different parameters", "Overloading the code within a function", "Creating an error in the program", "Defining a function with a return type"},
        {"By using its name followed by parentheses and arguments", "By using the 'int' data type", "By declaring the function inside the 'main' function", "By using the 'private' keyword"},
        {"A function that calls itself", "A function that takes no parameters", "A function with no return type", "A function with a long name"}
    };
    
    private String[] correctAnswers = {
        "A code block that performs a specific task",
        "type functionName(parameters) { // code }",
        "To declare the function's return type and parameters without defining the function itself",
        "The data type of the function's return value",
        "By using the function declaration and providing the function definition",
        "It is accessible only within the function where it is defined",
        "An input to the function provided when calling the function",
        "Having multiple functions with the same name but different parameters",
        "By using its name followed by parentheses and arguments",
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
