package com.login.loginform;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Java.*;
import c.*;
import cpp.*;
import cpp.destructor_cpp;
import os.*;
import python.abstract_class_py;
import python.array_py;
import python.control_statements_py;
import python.data_types_py;
import python.functions_py;
import python.inheritance_py;
import python.input_and_output_py;
import python.operator_py;
import python.polymorphism_py;
import python.string_py;
import python.threads_py;
import flutter.*;

public class App1 extends Application {

    @Override
    public void start(Stage stage) {
        // Create a VBox for the layout
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20); // Vertical gap between title and GridPane

        // Create a title Text and set its styling and color
        Text titleText = new Text("COURSES");
        titleText.setX(100); //x-axis
        titleText.setY(100); //y-axis
        titleText.setFont(Font.font("Times New Roman", 60));
        titleText.setFill(Color.RED); // text color
        titleText.setStroke(Color.BLACK); // text border
        titleText.setStrokeWidth(1); // border shadow
        titleText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        titleText.setStyle("-fx-fill: red;"); // Set the title color to red

        // Set a negative top margin to move the title up by 10 pixels
        VBox.setMargin(titleText, new Insets(-10, 0, 0, 0));

        // Create a GridPane for the card layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // Horizontal gap between cards
        grid.setVgap(10); // Vertical gap between cards

        // Define multiple ImageView objects with unique images
        ImageView imageView1 = new ImageView(new Image("c.png"));
        ImageView imageView2 = new ImageView(new Image("c++.png"));
        ImageView imageView3 = new ImageView(new Image("java.png"));
        ImageView imageView4 = new ImageView(new Image("python.png"));
        ImageView imageView5 = new ImageView(new Image("os.png"));
        ImageView imageView6 = new ImageView(new Image("flutter.png"));

        // Create ObservableLists for each card
        ObservableList<String> options1 = FXCollections.observableArrayList(
            "1.DataTypes & Variable",
            "2.Control Statement",
            "3.while Loop",
            "4.For Loop",
            "5.Array",
            "6.String",
            "7.fuction",
            "8.Pointer"
        );
        ObservableList<String> options2 = FXCollections.observableArrayList(
            "1.DataType and variable",
                "2.Fuction",
                "3.Classes and object",
                "4.Constructor",
                "5.Destructor",
                "6.Oprators",
                "7.Statement and Loops",
                "8.Array and pointers",
                "9.String"
        );
        ObservableList<String> options3 = FXCollections.observableArrayList(
                "1.Control Statements",
                "2.Methods(Function)",
                "3.Array",
                "4.String",
                "5.Classes and Object",
                "6.Polymorphism",
                "7.Abstract class",
                "8.Multi Threading"
        );
        ObservableList<String> options4 = FXCollections.observableArrayList(
            "1.Data Type",
            "2.Operator",
            "3.Input And Output",
            "4.Control Statement",
            "5.Array",
            "6.String",
            "7.Fuction",
            "8.Inheritance",
            "9.Polymorphism",
            "10.Abstract Class",
            "11.Threads"
        );
        ObservableList<String> options5 = FXCollections.observableArrayList(
            "1.Fuctions",
            "2.Types of OS and kernel",
            "3.Process",
            "4.Thread"
        );
        ObservableList<String> options6 = FXCollections.observableArrayList(
            "1.Data Type",
            "2.Oprator",
            "3.Control Statement",
            "4.Fuction",
            "5.Lambada",
            "6.Reccurssion",
            "7.Classes and Object"
        );

        // Create buttons for each card with styling
        Button button1 = createStyledButton("Quiz");
        Button button2 = createStyledButton("Quiz");
        Button button3 = createStyledButton("Quiz");
        Button button4 = createStyledButton("Quiz");
        Button button5 = createStyledButton("Quiz");
        Button button6 = createStyledButton("Quiz");

        // Create cards using HBox and add them to the GridPane
        HBox card1 = createCard(imageView1, "C & Data Structure", "", options1, button1);
        HBox card2 = createCard(imageView2, "C++ Programming Language", "", options2, button2);
        HBox card3 = createCard(imageView3, "Java & Data Structure", "", options3, button3);
        HBox card4 = createCard(imageView4, "Python & Machine Learning", "", options4, button4);
        HBox card5 = createCard(imageView5, "Operating System", "", options5, button5);
        HBox card6 = createCard(imageView6, "Flutter Bootcamp", "", options6, button6);

        button1.setOnMouseClicked(e -> {
            String option = (String)((ComboBox)(((VBox)(card1.getChildren().get(1))).getChildren().get(2))).getValue();
            if(option == "1.DataTypes & Variable"){
                data_types_c data_c = new data_types_c();
                data_c.start(new Stage());
            }if(option == "2.Control Statement"){
                control_statements_c data_c = new control_statements_c();
                data_c.start(new Stage());
            }if(option == "3.while Loop"){
                while_loop_c data_c = new while_loop_c();
                data_c.start(new Stage());
            }if(option == "4.For Loop"){
                for_loop_c data_c = new for_loop_c();
                data_c.start(new Stage());
            }if(option == "5.Array"){
                array_c data_c = new array_c();
                data_c.start(new Stage());
            } if(option == "6.String"){
                string_c data_c = new string_c();
                data_c.start(new Stage());
            } if(option == "7.fuction"){
                function_c data_c = new function_c();
                data_c.start(new Stage());
            } if(option == "8.Pointer"){
                pointer_c data_c = new pointer_c();
                data_c.start(new Stage());
            }
        });

        button2.setOnMouseClicked(e -> {
            String option = (String)((ComboBox)(((VBox)(card2.getChildren().get(1))).getChildren().get(2))).getValue();
            if(option == "1.DataType and variable"){
                data_types_and_variable_cpp data_cpp = new data_types_and_variable_cpp();
                data_cpp.start(new Stage());
            }if(option == "2.Fuction"){
                function_cpp data_cpp = new function_cpp();
                data_cpp.start(new Stage());
            }if(option == "3.Classes and object"){
                classes_and_objects_cpp data_cpp = new classes_and_objects_cpp();
                data_cpp.start(new Stage());
            } if(option == "4.Constructor"){
                constructor_cpp data_cpp = new constructor_cpp();
                data_cpp.start(new Stage());
            }if(option == "5.Destructor"){
                destructor_cpp data_cpp = new destructor_cpp();
                data_cpp.start(new Stage());
            } if(option == "6.Oprators"){
                operator_cpp data_cpp = new operator_cpp();
                data_cpp.start(new Stage());
            } if(option == "7.Statement and Loops"){
                statements_and_loop_cpp data_cpp = new statements_and_loop_cpp();
                data_cpp.start(new Stage());
            }if(option == "8.Array and pointers"){
                array_and_pointers_cpp data_cpp = new array_and_pointers_cpp();
                data_cpp.start(new Stage());
            } 
        });

        button3.setOnMouseClicked(e -> {
            String option = (String)((ComboBox)(((VBox)(card3.getChildren().get(1))).getChildren().get(2))).getValue();
            if(option == "1.Control Statements"){
                control_statements_java data_java = new control_statements_java();
                data_java.start(new Stage());
            } if(option == "2.Methods(Function)"){
                methods_java data_java = new methods_java();
                data_java.start(new Stage());
            }if(option == "3.Array"){
                array_java data_java = new array_java();
                data_java.start(new Stage());
            }if(option == "4.String"){
                string_java data_java = new string_java();
                data_java.start(new Stage());
         }if(option == "5.Classes and Object"){
                classes_and_objects_java data_java = new classes_and_objects_java();
                data_java.start(new Stage());
         }if(option == "6.Polymorphism"){
                polymorphism_java data_java = new polymorphism_java();
                data_java.start(new Stage());
         }if(option == "7.Abstract class"){
                abstract_class_java data_java = new abstract_class_java();
                data_java.start(new Stage());
         }if(option == "8.Multi Threading"){
                multi_threading_java data_java = new multi_threading_java();
                data_java.start(new Stage());
         }
       });

        button4.setOnMouseClicked(e -> {
            String option = (String)((ComboBox)(((VBox)(card4.getChildren().get(1))).getChildren().get(2))).getValue();
            if(option == "1.Data Type"){
                data_types_py data_py = new data_types_py();
                data_py.start(new Stage());
            }if(option == "2.Operator"){
                operator_py data_py = new operator_py();
                data_py.start(new Stage());
            }if(option == "3.Input And Output"){
                input_and_output_py data_py= new input_and_output_py();
                data_py.start(new Stage());
            } if(option == "4.Control Statement"){
               control_statements_py data_py = new control_statements_py();
                data_py.start(new Stage());
            }if(option == "5.Array"){
                array_py data_py = new array_py();
                data_py.start(new Stage());
            }if(option == "6.String"){
                string_py data_py = new string_py();
                data_py.start(new Stage());
            }if(option == "7.Fuction"){
                functions_py data_py = new functions_py();
                data_py.start(new Stage());
            }if(option == "8.Inheritance"){
                inheritance_py data_py = new inheritance_py();
                data_py.start(new Stage());
            }if(option == "9.Polymorphism"){
                polymorphism_py data_py = new polymorphism_py();
                data_py.start(new Stage());
            }if(option == "10.Abstract Class"){
               abstract_class_py data_py = new abstract_class_py();
                data_py.start(new Stage());
            }if(option ==  "11.Threads"){
                threads_py data_py = new threads_py();
                data_py.start(new Stage());
            }
        });

        button5.setOnMouseClicked(e -> {
            String option = (String)((ComboBox)(((VBox)(card5.getChildren().get(1))).getChildren().get(2))).getValue();
            if(option == "1.Fuctions"){
                functions_os data_os = new functions_os();
                data_os.start(new Stage());
            } if(option == "2.Types of OS and kernel"){
                types_of_os_and_kernel_os data_os = new types_of_os_and_kernel_os();
                data_os.start(new Stage());
            }if(option == "3.Process"){
                process_os data_os = new process_os();
                data_os.start(new Stage());
            }if(option == "4.Thread"){
                thread_os data_os = new thread_os();
                data_os.start(new Stage());
            }
        });
        

         button6.setOnMouseClicked(e -> {
            String option = (String)((ComboBox)(((VBox)(card6.getChildren().get(1))).getChildren().get(2))).getValue();
            if(option == "3.Control Statement"){
                control_statements_flutter data_c = new control_statements_flutter();
                data_c.start(new Stage());
            }if(option == "1.Data Type"){
                data_types_flutter data_c = new data_types_flutter();
                data_c.start(new Stage());
            }if(option == "2.Oprator"){
                operator_flutter data_c = new operator_flutter();
                data_c.start(new Stage());
            }if(option == "4.Fuction"){
                function_flutter data_c = new function_flutter();
                data_c.start(new Stage());
            }if(option == "5.Lambada"){
                lambada_flutter data_c = new lambada_flutter();
                data_c.start(new Stage());
            }if(option == "6.Reccurssion"){
                reccurssion_flutter data_c = new reccurssion_flutter();
                data_c.start(new Stage());
            }if(option == "7.Classes and Object"){
                classes_and_objects_flutter data_c = new classes_and_objects_flutter();
                data_c.start(new Stage());
            }
        });

        grid.add(card1, 0, 0);
        grid.add(card2, 1, 0);
        grid.add(card3, 0, 1);
        grid.add(card4, 1, 1);
        grid.add(card5, 0, 2);
        grid.add(card6, 1, 2);

        root.getChildren().addAll(titleText, grid);

        Scene scene = new Scene(root, 1100, 600);
        stage.setTitle("JavaFX Multiple Images Example");
        stage.setScene(scene);
        stage.show();
    }

    public void open_Quiz(MouseEvent event){
         
    }

    private HBox createCard(ImageView imageView, String titleText, String descriptionText, ObservableList<String> options, Button button) {
        HBox card = new HBox();
        card.setStyle("-fx-background-color: #ffffff;");
        card.setSpacing(10);
        card.setMaxWidth(350); // Maximum width for each card

        imageView.setFitWidth(200);
        imageView.setFitHeight(150);

        VBox textContainer = new VBox();
        textContainer.setSpacing(10);
        Text title = new Text(titleText);
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        Text description = new Text(descriptionText);
        description.setWrappingWidth(280);

        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setStyle("-fx-border-width: 0;");
        comboBox.setPrefHeight(15);
        comboBox.setPrefWidth(140); // Set the preferred width to a smaller value
        comboBox.setVisibleRowCount(3);
        VBox.setMargin(comboBox, new Insets(-25, 0, 0, 130)); // Adjust the value (20) as needed
        // comboBox.setValue(options.get(0)); // Set the default selected option
        comboBox.setValue("Chapters"); // Set the default selected option

        // Set the ListCell's width to match the ComboBox's width
        comboBox.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setPrefWidth(50); // Set the width to match the ComboBox's width
                }
            }
        });
        button.setPadding(new Insets(5, 30, 5, 30));

        textContainer.getChildren().addAll(title, description, comboBox, button);

        card.getChildren().addAll(imageView, textContainer);

        return card;
    }

    private Button createStyledButton(String label) {
        Button button = new Button(label);

        // Styling for mouse hover and padding
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: lightyellow; -fx-border-color: black; -fx-border-radius: 3;-fx-background-radius: 3;");
        });

        button.setOnMouseExited(event -> {
            button.setStyle("");
        });

        button.setPadding(new Insets(5, 30, 5, 30));
        VBox.setMargin(button, new Insets(45, 0, 0, 8)); // Adjust the top margin as needed

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
