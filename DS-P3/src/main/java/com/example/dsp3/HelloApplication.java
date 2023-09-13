package com.example.dsp3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloApplication extends Application {
    String LabelStyle = "-fx-font-size: 18; -fx-font-weight: bold;";
    DLinkedList Dl2 = new DLinkedList();
    AVL SeatNumberAVL = new AVL();
    AVL AverageAVL = new AVL();
    TextField ARTextField;
    TextField STextField;
    TextField STextField3;
    int isClicked;

    @Override
    public void start(Stage stage) {


        Image Science = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P3\\src\\main\\java\\Photos\\science.png");
        ImageView ScienceView = new ImageView(Science);
        Image Lit = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P3\\src\\main\\java\\Photos\\literary.png");
        ImageView LiteraryView = new ImageView(Lit);
        //--------------------------------------------

        Label Welcome = new Label("Choose The Stream");
        Welcome.setStyle(LabelStyle);
        Button Scientific = new Button("Scientific", ScienceView);
        Button Literary = new Button("Literary", LiteraryView);

        Scientific.setStyle("-fx-min-width: 100; -fx-border-color: red; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        Literary.setStyle("-fx-min-width: 100; -fx-border-color: purple; -fx-text-fill: purple; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        Scientific.setPrefSize(200, 100);
        Literary.setPrefSize(200, 100);
        ScienceView.setFitHeight(80);
        ScienceView.setFitWidth(80);
        LiteraryView.setFitHeight(80);
        LiteraryView.setFitWidth(80);


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(1, 1, 10, 1));


        GridPane gridPane = new GridPane();
        gridPane.add(vBox, 0, 0);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        Group group = new Group(gridPane);
        BorderPane borderPane = new BorderPane(group);
        borderPane.setCenter(group);
        borderPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0), Insets.EMPTY)));
        Scene scene = new Scene(borderPane, 800, 700, Color.SKYBLUE);
        stage.setScene(scene);

        Button Load = new Button("Load");
        TextField fileName = new TextField();
        fileName.setPrefSize(200, 25);


        VBox vBox1 = new VBox(10);
        VBox vBox2 = new VBox(10);
        VBox vBox3 = new VBox(10);
        GridPane gridPane1 = new GridPane();
        Group group1 = new Group(gridPane1);
        gridPane1.add(vBox1, 0, 1);
        gridPane1.add(vBox2, 1, 1);
        gridPane1.add(vBox3, 2, 1);

        gridPane1.setAlignment(Pos.BOTTOM_CENTER);
        BorderPane borderPane1 = new BorderPane(group1);
        borderPane1.setCenter(group1);
        Scene scene1 = new Scene(borderPane1, 1000, 800);
        borderPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0), Insets.EMPTY)));

        //These two buttons will share the same interface(the difference will be what will be read from the file


        vBox1.setPadding(new Insets(1, 1, 10, 1));
        vBox2.setPadding(new Insets(1, 1, 10, 1));
        vBox3.setPadding(new Insets(1, 1, 10, 1));
//00000000000000000000000000000000000Images
        Image Main = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P1\\src\\Photos\\PS ministry.png");
        ImageView MainImage = new ImageView(Main);
        Image Update = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P3\\src\\main\\java\\Photos\\update.png");
        ImageView UpdateView = new ImageView(Update);
        Image AddStu = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P1\\src\\Photos\\add-user.png");
        ImageView AddStuImage = new ImageView(AddStu);
        Image DeleteStu = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P1\\src\\Photos\\delete-friend.png");
        ImageView DeleteStuImage = new ImageView(DeleteStu);
        Image SearchStu = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P1\\src\\Photos\\search-engine.png");
        ImageView SearchStuImage = new ImageView(SearchStu);
        Image Mean = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P1\\src\\Photos\\average.png");
        ImageView MeanImage = new ImageView(Mean);
        Image Exit = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\Data_Stcture_Project1\\src\\Images\\exit.png");
        ImageView ExitImage = new ImageView(Exit);
        Image Back = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P3\\src\\main\\java\\Photos\\return.png");
        ImageView BackImage = new ImageView(Back);
        Image Print = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P3\\src\\main\\java\\Photos\\printer.png");
        ImageView PrintImage = new ImageView(Print);
//00000000000000000000000000000000000000000Images

        Label label = new Label("Tawjehe Records For the Year 2023-2024");
        label.setFont(new Font("Buffalo", 15));
        label.setLayoutX(170);
        label.setLayoutY(-200);
        Button button = new Button("Update Info", UpdateView);
        Button button1 = new Button("Delete Student", DeleteStuImage);
        Button button2 = new Button("Search for Student", SearchStuImage);
        Button button3 = new Button("Get All Student According AVG", MeanImage);
        Button button4 = new Button("Insert", AddStuImage);
        Button button5 = new Button("Exit", ExitImage);
        Button button6 = new Button("Back", BackImage);
        Button button7 = new Button("Print Data", PrintImage);


        button.setPrefSize(200, 100);
        button1.setPrefSize(200, 100);
        button2.setPrefSize(200, 100);
        button3.setPrefSize(200, 100);
        button4.setPrefSize(200, 100);
        button5.setPrefSize(200, 100);
        button6.setPrefSize(200, 100);
        button7.setPrefSize(200, 100);

        button.setContentDisplay(ContentDisplay.TOP);
        button1.setContentDisplay(ContentDisplay.TOP);
        button2.setContentDisplay(ContentDisplay.TOP);
        button3.setContentDisplay(ContentDisplay.TOP);
        button4.setContentDisplay(ContentDisplay.TOP);
        button5.setContentDisplay(ContentDisplay.TOP);
        button7.setContentDisplay(ContentDisplay.TOP);

        button.setStyle("-fx-min-width: 100; -fx-border-color: purple; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        button1.setStyle("-fx-min-width: 100; -fx-border-color: purple; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        button2.setStyle("-fx-min-width: 100; -fx-border-color: green; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        button3.setStyle("-fx-min-width: 100; -fx-border-color: green; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        button4.setStyle("-fx-min-width: 100; -fx-border-color: purple; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        button5.setStyle("-fx-min-width: 100; -fx-border-color: green; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        button6.setStyle("-fx-min-width: 100; -fx-border-color: red; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");
        button7.setStyle("-fx-min-width: 100; -fx-border-color: red; -fx-text-fill: red; -fx-border-width: 3; -fx-border-radius: 5; -fx-font-weight: bold;");

        MainImage.setFitHeight(150);
        MainImage.setFitWidth(150);
        MainImage.setLayoutX(235);
        MainImage.setLayoutY(-150);

        fileName.setLayoutX(-20);
        fileName.setLayoutY(-50);

        Load.setLayoutX(180);
        Load.setLayoutY(-50);

        UpdateView.setFitHeight(80);
        UpdateView.setFitWidth(80);

        AddStuImage.setFitHeight(80);
        AddStuImage.setFitWidth(80);

        DeleteStuImage.setFitHeight(80);
        DeleteStuImage.setFitWidth(80);

        SearchStuImage.setFitHeight(80);
        SearchStuImage.setFitWidth(80);

        MeanImage.setFitHeight(80);
        MeanImage.setFitWidth(80);

        ExitImage.setFitWidth(80);
        ExitImage.setFitHeight(80);

        BackImage.setFitWidth(80);
        BackImage.setFitHeight(80);

        PrintImage.setFitHeight(80);
        PrintImage.setFitWidth(80);

        //=========Update Student info=============//
        BorderPane borderPane6 = new BorderPane();
        GridPane gridPane6 = new GridPane();
        borderPane6.setCenter(gridPane6);//Man Of The Match
        gridPane6.setAlignment(Pos.CENTER);
        Scene UpdateCustomerScene = new Scene(borderPane6, 1000, 700);
        borderPane6.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, new CornerRadii(0), Insets.EMPTY)));

        button.setOnAction(e -> stage.setScene(UpdateCustomerScene));

        gridPane6.setPadding(new Insets(10, 10, 10, 10));
        gridPane6.setHgap(10);
        gridPane6.setVgap(10);


        Label Label = new Label("Student Seat Number");
        Label Label0 = new Label("Update the info u want, all the fields are optional");
        Label Label1 = new Label("Seat Number");
        Label Label2 = new Label("Branch");
        Label Label3 = new Label("Average");
        TextField UTextField = new TextField();
        TextField UTextField1 = new TextField();
        TextField UTextField2 = new TextField();
        TextField UTextField3 = new TextField();
        Button UButton1 = new Button("Update Information");
        Button UButton2 = new Button("Back");
        UButton2.setOnAction(e -> stage.setScene(scene1));
        gridPane6.add(Label, 0, 0);
        gridPane6.add(Label0, 1, 1);
        gridPane6.add(Label1, 0, 2);
        gridPane6.add(Label2, 0, 3);
        gridPane6.add(Label3, 0, 4);
        gridPane6.add(UTextField, 1, 0);
        gridPane6.add(UTextField1, 1, 2);
        gridPane6.add(UTextField2, 1, 3);
        gridPane6.add(UTextField3, 1, 4);
        gridPane6.add(UButton1, 1, 5);
        gridPane6.add(UButton2, 2, 5);

        borderPane6.getChildren().addAll(Label, Label1, Label2, Label3);
        borderPane6.getChildren().addAll(UTextField, UTextField1, UTextField2, UTextField3);
        borderPane6.getChildren().addAll(UButton1, UButton2);
        gridPane6.getChildren().addAll(Label, Label1, Label2, Label3);
        gridPane6.getChildren().addAll(UTextField, UTextField1, UTextField2, UTextField3);
        gridPane6.getChildren().addAll(UButton1, UButton2);

        UButton1.setOnAction(e -> {
            Student updateStudent;
            updateStudent = Dl2.Searchh(Integer.parseInt(UTextField.getText()));
            Dl2.Update(updateStudent, Integer.parseInt(UTextField1.getText()), UTextField2.getText(), Double.parseDouble(UTextField3.getText()));
            Dl2.traverse();
//            SeatNumberAVL.UpdateAVL(SeatNumberAVL.Search(Integer.parseInt(UTextField1.getText())), Integer.parseInt(UTextField1.getText()), UTextField2.getText(), Double.parseDouble(UTextField3.getText()));
//            SeatNumberAVL.inorderSeatNumber();
        });


        //=========Add New Student==============
        GridPane gridPane2 = new GridPane();
        BorderPane borderPane2 = new BorderPane();
        gridPane2.setAlignment(Pos.CENTER);
        borderPane2.setCenter(gridPane2);
        Scene scene2 = new Scene(borderPane2, 800, 700);
        borderPane2.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0), Insets.EMPTY)));
        Label ARLabel = new Label("Seat Number");
        Label ARLabel1 = new Label("Branch");
        Label ARLabel2 = new Label("Average");
        ARTextField = new TextField();
        TextField ARTextField1 = new TextField();
        TextField ARTextField2 = new TextField();
        Button ARButton = new Button("Add");
        Button ARButton2 = new Button("Back");


        ARButton2.setOnAction(e -> stage.setScene(scene1));

        gridPane2.add(ARLabel, 0, 0);
        gridPane2.add(ARLabel1, 0, 1);
        gridPane2.add(ARLabel2, 0, 2);
        gridPane2.add(ARTextField, 1, 0);
        gridPane2.add(ARTextField1, 1, 1);
        gridPane2.add(ARTextField2, 1, 2);
        gridPane2.add(ARButton, 1, 3);
        gridPane2.add(ARButton2, 3, 3);
        button4.setOnAction(e -> stage.setScene(scene2));

        ARButton.setOnAction(e -> {
            if (IsExisted())
                System.out.println("\n\nThis Student is already existed!");
            else {
                Dl2.addFirst(Integer.parseInt(ARTextField.getText()), ARTextField1.getText(), Double.parseDouble(ARTextField2.getText()));
                SeatNumberAVL.insertAVL1(new Student(Integer.parseInt(ARTextField.getText()), ARTextField1.getText(), Double.parseDouble(ARTextField2.getText())));
                AverageAVL.insertAVL2(Integer.parseInt(ARTextField2.getText()));
                Dl2.traverse();
                System.out.println("=======================================================================");
                SeatNumberAVL.inorderSeatNumber();
                System.out.println("\n=======================================================================\n");
                AverageAVL.inorderAvg();
            }
        });


        //Delete Delete Student
        GridPane gridPane3 = new GridPane();
        BorderPane borderPane3 = new BorderPane();
        gridPane3.setAlignment(Pos.CENTER);
        borderPane3.setCenter(gridPane3);
        Scene scene3 = new Scene(borderPane3, 1000, 800);
        borderPane3.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(0), Insets.EMPTY)));
        Label DRLabel = new Label("Seat Number");
        TextField DRTextField = new TextField();
        Button DRButton = new Button("Delete");
        Button DRButton2 = new Button("Back");
        button1.setOnAction(e -> stage.setScene(scene3));
        gridPane3.add(DRLabel, 0, 0);
        gridPane3.add(DRTextField, 1, 0);
        gridPane3.add(DRButton, 1, 1);
        gridPane3.add(DRButton2, 3, 1);
        DRButton2.setOnAction(e -> stage.setScene(scene1));
        DRButton.setOnAction(e -> {
            Dl2.Delete(Dl2.SearchPOS(Integer.parseInt(DRTextField.getText())));
            Dl2.traverse();
//            AverageAVL.deleteNode(AverageAVL.rootNode, )
//            SeatNumberAVL.deleteNode()
        });


        //==========Search Student=========
        Image nextt = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P3\\src\\main\\java\\Photos\\next-button.png");
        ImageView nextImage = new ImageView(nextt);
        Image previous = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\DS-P3\\src\\main\\java\\Photos\\previous (1).png");
        ImageView previousImage = new ImageView(previous);
        GridPane gridPane4 = new GridPane();
        BorderPane borderPane4 = new BorderPane();
        gridPane4.setAlignment(Pos.CENTER);
        borderPane4.setCenter(gridPane4);
        Scene scene4 = new Scene(borderPane4, 1000, 800);
        borderPane4.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0), Insets.EMPTY)));
        Label SLabel = new Label("Seat Number");
        STextField = new TextField();
        STextField3 = new TextField();
        STextField3.setEditable(false);
        STextField3.setPrefSize(350, 50);
        Button SButton = new Button("Search");
        Button SButton2 = new Button("Back");
        Button next = new Button("Next", nextImage);
        Button prev = new Button("Prev", previousImage);
        next.setContentDisplay(ContentDisplay.TOP);
        prev.setContentDisplay(ContentDisplay.TOP);
        next.setPrefSize(50, 20);
        prev.setPrefSize(50, 20);
        nextImage.setFitWidth(20);
        nextImage.setFitHeight(20);
        previousImage.setFitWidth(20);
        previousImage.setFitHeight(20);
        SButton2.setOnAction(e -> stage.setScene(scene1));
        gridPane4.add(SLabel, 0, 0);
        gridPane4.add(STextField, 1, 0);
        gridPane4.add(SButton, 1, 1);
        gridPane4.add(SButton2, 2, 1);
        gridPane4.add(STextField3, 1, 2);
        gridPane4.add(next, 2, 3);
        gridPane4.add(prev, 1, 3);


        button2.setOnAction(e -> stage.setScene(scene4));
        SButton.setOnAction(e -> {
            STextField3.setText(Dl2.Searchh(Integer.parseInt(STextField.getText())) + "");
        });

        next.setOnAction(event -> {
            STextField3.setText(Dl2.NextStudent(Dl2.Searchh(Integer.parseInt(STextField.getText()))) + "");
            int Seatnum = Dl2.NextStudentSeatNumber(Dl2.Searchh(Integer.parseInt(STextField.getText())));
            STextField.setText(Seatnum + "");
        });

        prev.setOnAction(e -> {
            STextField3.setText(Dl2.prevStudent(Dl2.Searchh(Integer.parseInt(STextField.getText()))) + "");
            int SeatNum = Dl2.prevStudentseatNumber(Dl2.Searchh(Integer.parseInt(STextField.getText())));
            STextField.setText(SeatNum + "");//دبي اعمل فنكشن يرجع السيت نمبر تاع البريفيس
        });




        //-----------get all according to the grade-------------
        GridPane gridPane5 = new GridPane();
        BorderPane borderPane5 = new BorderPane();
        gridPane5.setAlignment(Pos.CENTER);
        borderPane5.setCenter(gridPane5);
        Scene scene5 = new Scene(borderPane5, 1000, 800);
        borderPane5.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0), Insets.EMPTY)));
        Label numLabel = new Label("Please Enter a Specific Score to Print All The Students Who Scored this Average ");
        TextArea numTextArea = new TextArea();
        numTextArea.setPrefSize(50, 100);
        numTextArea.setEditable(false);
        TextField numTextField1 = new TextField();
        Button numButton = new Button("Print");
        Button numButton3 = new Button("Back");
        numButton3.setOnAction(e -> stage.setScene(scene1));
        gridPane5.add(numLabel, 1, 0);
        gridPane5.add(numTextField1, 1, 1);
        gridPane5.add(numTextArea, 1, 2);
        gridPane5.add(numButton, 1, 3);
        gridPane5.add(numButton3, 2, 3);
        button3.setOnAction(e -> stage.setScene(scene5));
        numButton.setOnAction(e -> {
            numTextArea.setText(Dl2.getStudentsAccordingToAVG(Double.parseDouble(numTextField1.getText())));

        });


        //===========Print the DLinkedList || AVL1 || AVL2================//
        GridPane gridPane7 = new GridPane();
        BorderPane borderPane7 = new BorderPane();
        gridPane7.setAlignment(Pos.CENTER);
        borderPane7.setCenter(gridPane7);
        Scene scene6 = new Scene(borderPane7, 1000, 800);
        borderPane7.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0), Insets.EMPTY)));
        Label DisLabel = new Label("Please Choose a Specific Data To Print");
        DisLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        TextArea textArea = new TextArea();
        textArea.setPrefSize(500, 400);
        Button DisButton = new Button("Double LinkedList");
        Button DisButton1 = new Button("Seat Number AVL");
        Button DisButton2 = new Button("Average AVL");
        Button DisButton3 = new Button("AVL1 Height");
        Button DisButton5 = new Button("AVL2 Height");
        Button DisButton4 = new Button("Back");
        DisButton4.setOnAction(e -> stage.setScene(scene1));
        gridPane7.add(DisLabel, 1, 0);
        gridPane7.add(textArea, 1, 1);
        gridPane7.add(DisButton, 0, 2);
        gridPane7.add(DisButton1, 1, 2);
        gridPane7.add(DisButton2, 2, 2);
        gridPane7.add(DisButton3, 0, 3);
        gridPane7.add(DisButton5, 1, 3);
        gridPane7.add(DisButton4, 2, 3);
        button7.setOnAction(e -> stage.setScene(scene6));
        DisButton.setOnAction(e -> textArea.setText(Dl2.toString()));

        DisButton1.setOnAction(e -> {
            textArea.setText(SeatNumberAVL.PrintAVL1());
//        System.out.println(SeatNumberAVL.Print());
        });
        DisButton2.setOnAction(e -> textArea.setText(AverageAVL.PrintAVL2()));

        DisButton3.setOnAction(e -> {
            AVLNode node = SeatNumberAVL.rootNode;
            textArea.setText(SeatNumberAVL.getheight(node) + "");
        });


        //=======Close||Exit===============
        button5.setOnAction(e -> stage.close());

        //=======Back Button===============
        button6.setOnAction(e -> stage.setScene(scene));

        isClicked = 0;
        Scientific.setOnAction(e -> {
            stage.setScene(scene1);
            isClicked = 1;
        });


        Literary.setOnAction(e -> {
            stage.setScene(scene1);
            isClicked=2;
        });

        Load.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File fileselected = fileChooser.showOpenDialog(stage);
            fileName.setText(fileselected.getPath());
            fileName.setEditable(false);
            if (isClicked == 1)
                ReadSciData(fileselected, Dl2, SeatNumberAVL, AverageAVL);
            else
                ReadLitData(fileselected, Dl2, SeatNumberAVL, AverageAVL);

            Dl2.sortByAverage();
            Dl2.traverse();
            System.out.println("=======================================================================");
            SeatNumberAVL.inorderSeatNumber();
            System.out.println("\n=======================================================================\n");
            AverageAVL.inorderAvg();

        });


        // groups
        vBox.getChildren().addAll(Welcome, Scientific, Literary, button5);
        group1.getChildren().addAll(label, MainImage, fileName, Load);
        vBox1.getChildren().addAll(button, button2);
        vBox2.getChildren().addAll(button1, button3, button6);
        vBox3.getChildren().addAll(button4, button7);


        Image icon = new Image("C:\\Users\\DELL\\IdeaProjects\\demo\\Zaid Fx\\src\\Images\\letter-z.png");
        stage.getIcons().add(icon);
        stage.setTitle("Tawjehe Records System");
        stage.show();

    }

    public void ReadSciData(File filename, DLinkedList lf, AVL seatNumberAVL, AVL AverageAVL) {//to read the data of Science Stream
        try {

            Scanner input = new Scanner(filename);
            while (input.hasNext()) {
                String s = input.nextLine();
                String[] tokens = s.split(",");
                if (tokens.length == 3) {
                    int seatnum = Integer.parseInt(tokens[0]);
                    String branch = tokens[1];
                    double score = Double.parseDouble(tokens[2]);
                    if (branch.equals("Scientific")) {
                        Student student = new Student(seatnum, branch, score);
                        lf.addFirst(seatnum, branch, score);
                        seatNumberAVL.insertAVL1(student);
                        AverageAVL.insertAVL2(score);

                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public void ReadLitData(File filename, DLinkedList lf, AVL seatNumberAVL, AVL AverageAVL) {//to read the data of Literary Stream
        try {
            Scanner input = new Scanner(filename);
            while (input.hasNext()) {
                String s = input.nextLine();
                String[] tokens = s.split(",");
                if (tokens.length == 3) {
                    int seatnum = Integer.parseInt(tokens[0]);
                    String branch = tokens[1];
                    double score = Double.parseDouble(tokens[2]);
                    if (branch.equals("Literary")) {
                        Student student = new Student(seatnum, branch, score);
                        lf.addFirst(seatnum, branch, score);
                        seatNumberAVL.insertAVL1(student);
                        AverageAVL.insertAVL2(score);
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public boolean IsExisted() {
        Student s = Dl2.front;
        for (int i = 0; i < Dl2.size; i++) {
            if (s.getSeatNum() == Integer.parseInt(ARTextField.getText()))
                return true;
            else
                s = s.next;
        }
        return false;
    }

    public static void main(String[] args) {
        launch();
    }

}