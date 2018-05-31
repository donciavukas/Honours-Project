/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honours.project;

import java.awt.Desktop;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 *
 * @author Donatas
 */
public class FXMLDocumentController implements Initializable {
    
    //Container for N
    @FXML
    private TextField N;
    //Container for optional value a
    @FXML
    private TextField aValue;

    @FXML
    private LineChart<Number, Number> lineChart;

    @FXML
    private NumberAxis x = new NumberAxis(0, 10, 1);
    //Container for the execution time (ms)
        @FXML
    private Text timeText;
    //Table related containers
    @FXML
    private TableView<TableEntry> myTable;
    @FXML
    private TableColumn<TableEntry, Integer> clmn1;
    @FXML
    private TableColumn<TableEntry, String> clmn2;
    
    @FXML
    private Text gcdRes;
    
    @FXML
    private Text generatedNumber;
    
    @FXML
    private Text startLoc;   
    @FXML
    private Text periodLoc;
    
    @FXML
    private TabPane myPane;
    
    @FXML
    private TextField testBox;

    private ClassicalPart procedure;
    private Alert alert = new Alert(AlertType.INFORMATION);
    private PrimeCheck check = new PrimeCheck();
    private BigInteger nResult;
    private ArrayList data;
    private XYChart.Series series;

    @FXML
    private Label resultLabel;
    

    @FXML
    void handleGenerateAction(ActionEvent event) {
        BigInteger number = new BigInteger(testBox.getText());
        String nValue = "";
        //Before any calculations are made the input is tested fir empty string values
        //An error message is ouput to the user 
        if (N.getText().equals("")) {
            if(testBox.getText().equals("")){
            alert.setContentText("Cannot generate a random value without N.");
            alert.showAndWait();
            }
            else if(!check.primePow(number) && !check.isPrime(number)) {
                N.setText(testBox.getText());
            }
        }
        //A secondary check before proceeding
        //If combined with the above statement, code will not execute
        if(!check.primePow(number) && !check.isPrime(number)){
        nValue = N.getText();
        //Will always be considered as a single input command and does not need testing before contruction
        procedure = new ClassicalPart(new BigInteger(nValue));
        //Starting the procedure that will provide a tested successfull randomly generated number
        //It is done this way so the random generation cannot output incorrect values
        procedure.start();
        //The restuls are set to display to the user
        generatedNumber.setText(procedure.getA().toString());
        gcdRes.setText(procedure.getGcd().toString());
        aValue.setText(generatedNumber.getText());
        }
    }
    
        @FXML
    void handleNextAction(ActionEvent event) {
        myPane.getSelectionModel().selectNext();
    }
        @FXML
    void handleBackAction(ActionEvent event) {
        myPane.getSelectionModel().selectPrevious();
    }
        @FXML
    void handleFinishEvent(ActionEvent event) {
        //Call another execution method to avoid code duplication
        handleStartButtonAction(event);
        startLoc.setText("x = "+myTable.getColumns().get(0).getCellData(0).toString());
        periodLoc.setText("r = "+Integer.toString(procedure.getR()));
        //Switch to the next pane
        myPane.getSelectionModel().selectNext();
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        /*
        Clear all the data from the GUI, while leaving the N and a values as promt text incase the clear button was pressed on accident
         */
        lineChart.getData().clear();
        N.setPromptText(N.getText());
        N.setText("");
        aValue.setText("");
        myTable.getItems().clear();
        resultLabel.setText("");
    }
    
    @FXML
    void handleCheckButton(ActionEvent event) {
        BigInteger number = new BigInteger(testBox.getText());
        if(check.isPrime(number)){
             alert.setContentText("The value is prime and cannot be used."); 
             alert.showAndWait();
        }
        if(check.primePow(number)){
             alert.setContentText("The value is a power of a prime and cannot be used."); 
             alert.showAndWait();
        }
        if(!check.primePow(number) && !check.isPrime(number)){
             alert.setContentText("This number is Okay to use \nand has been entered in the boabelow."); 
             alert.showAndWait();
             //N is the TextField for input
             N.setText(number.toString());
        }
    }
    
    //Several specific parts of the UI will open links to the web
    //In these methods there is a seperate method for each hyperlink
    @FXML
    void openLinkQFT(ActionEvent event) throws URISyntaxException{
       if(Desktop.isDesktopSupported())
    {
        try {
            Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Quantum_Fourier_transform"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    }
    
     @FXML
    void openLinkStates(ActionEvent event) throws URISyntaxException{
       if(Desktop.isDesktopSupported())
    {
        try {
            Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Qubit#Qubit_states"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    }
    
         @FXML
    void openLinkRoot(ActionEvent event) throws URISyntaxException{
       if(Desktop.isDesktopSupported())
    {
        try {
            Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Imaginary_unit#i_and_%E2%88%92i"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    }
    
        @FXML
    void openLinkWaves(ActionEvent event) throws URISyntaxException{
       if(Desktop.isDesktopSupported())
    {
        try {
            Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Wave_function"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }
    }

    /*
    The main method that will be called upon pressing "Finish" or "Start" buttons
    this method will initialize Shor's precedure, test and reject inputs, and call the drawChart and fillTable methods
    */   
       @FXML
    private void handleStartButtonAction(ActionEvent event) {
        String nValue = "";
          if (N.getText().equals("")) {
            alert.setContentText("The value of N cannot be empty.");
            alert.showAndWait();
        } else {
            //Get text biginteger uses strings
            nValue = N.getText();
            //Check if the number confirms to the rules of not being a prime number 3,7,13...
            //And if the number is not a power of a prime number 3^2, 3^3...
            if (!check.isPrime(new BigInteger(nValue)) && !check.primePow(new BigInteger(nValue))) {
                //If the boafor value ais empty an instance of ClassicalPart will be created with one input, and the avalue will be later generated randomly
                if (aValue.getText().equals("")) {
                    procedure = new ClassicalPart(new BigInteger(nValue));
                } else {
                    //In case of unexpected input is entered
                    try{
                    String aVal = aValue.getText();
                    procedure = new ClassicalPart(new BigInteger(nValue), new BigInteger(aVal));
                    }
                    catch (NumberFormatException e){
                    alert.setContentText("The a value box must be an integer or empty."); 
                    alert.showAndWait();
                    
                    }
                }
                //Start the calculations if everything passed without issues.
                procedure.start();                
                /*
                In case the user wishes to manually enter values of a, in some cases the results will be incorrect and unusable
                a variable is created to check if the factor's product is equal to the initially entered value N
                if not an alert message will pop up alerting the user to enter another value a
                */
                this.nResult = procedure.resultReturn()[0].multiply(procedure.resultReturn()[1]);
                aValue.setPromptText(procedure.getA().toString());
                //Execution time converted from nanoSeconds to milliSeconds
                timeText.setText((double)procedure.getTime()/1000000+"ms");
                if (!this.nResult.toString().equals(N.getText())) {
                    //Clearing the previous data from the chart and table
                    lineChart.getData().clear();
                    myTable.getItems().clear();
                    //Outputting the result factors for N
                    this.resultLabel.setText(procedure.resultReturn()[0] + " * " + procedure.resultReturn()[1] + " = " + this.nResult);
                    //This is mainly meant for double input
                    //Two messages that are slightly diferent depending on the results
                    alert.setContentText("Please choose another value for a.");
                    if (!(this.procedure.getR() % 2 == 0)) {
                        alert.setContentText("Please choose another value for a. \n The resulting period(r) was not even.");
                    }
                    //Show the current alert message
                    alert.showAndWait();
                } else {
                    //Call to the methods for generation of the graph and tableview content
                    this.drawChart();
                    this.fillTable();
                    //Outputs the results into the UI
                    this.resultLabel.setText(procedure.resultReturn()[0] + " * " + procedure.resultReturn()[1] + " = " + this.nResult);
                }
            } else {
                //Default alert message if anything unexpected happens, to be improved in the future
                alert.setContentText("This number is negative, prime or a prime power and is not allowed.");
                alert.showAndWait();
            }
            
        }
        //Fills in missing parts of the text in the Sequence graph tab, to the right of the table
        //Before any calculations are made these areas will be emtpy or set to defualt text
        startLoc.setText("x = "+myTable.getColumns().get(0).getCellData(0).toString());
        periodLoc.setText("r = "+Integer.toString(procedure.getR()));
    }
    

    private void drawChart() {
        //Clearing old data
        lineChart.getData().clear();
        series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        data = new ArrayList();
        data = procedure.dataReturn();
        //lastI is used to remeber last value location of the last period to not draw a 2nd period of the graph on the same points
        int lastI = 0;
        int extra = 0;
        /*
        Check for normalization
        Because raising any number to the power of 0, will results in results 1
        some function results will contain that value periodicaly
        checks if the function at the end of the period next value is equal to 1 or not
        once normalization requirment is affirmed
        the variable extra is assinged a value of 1.
        The check for normalization and data production from the sequence could be moved to a diferent method on its own, as it is used more than once
         */
        if (!data.get(0).equals(data.get(procedure.getR()))) {
            /*
            The extra value at 1 will provide for the first graph loop to start looping at 1 instead of 0
            If it remains at 0, no normalization needs to take place
            This only affects the way that data for the graph and the table is interpreted
            It has no effect on the actual calculations
             */
            extra = 1;
        }
        //populating series variables with the 1st period XY values
        for (int i = 0 + extra; i < procedure.getR() + extra; i++) {
            series.getData().add(new XYChart.Data(i, data.get(i)));
            //Keeping track of the index value for data duplication without overlap
            //The integer i represents the x values of the XY graph
            //While the data represents the function values f(x) = a^x mod N
            lastI++;
        }
        //2nd period XY values
        //Continues the x value where the first loop finished off(lastI)
        for (int i = 0; i < procedure.getR(); i++) {
            series2.getData().add(new XYChart.Data(i + extra + lastI, data.get(i + extra)));
        }
        //Adding the XYChart.Seires into lineChart data
        lineChart.getData().addAll(series, series2);
        //Set the legend invisible, since the graph has been modified and the legend is not representative of the data
        lineChart.setLegendVisible(false);
    }

    //Short method to name the columns and set their properties as String and Integer
    //Althouhg both values in the table are numbers, it makes seperating the data simpler, by using one value as a string
    //As the data from the table is not really used anywhere else, this should not pose any issues
    private void fillTable() {
        clmn1.setCellValueFactory(new PropertyValueFactory<TableEntry, Integer>("x"));
        clmn2.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("function"));
        myTable.getItems().setAll(getValues());
    }

    /*
    The main purpose of this method is to create an observable list of TableEntry instances
    for populating the value table
    Adding each value manually into seperate columns is too tedious and could lead to inconsitancies
     */
    public ObservableList<TableEntry> getValues() {
        ObservableList<TableEntry> values = FXCollections.observableArrayList();
        ArrayList data = new ArrayList();
        data = procedure.dataReturn();
        int lastIndex = 0;
        int extra = 0;
        /*
        Similar to the graphs, data needs to be normalized in some cases
        This enables for the data in the table to have proper values that match the graph
         */
        if (!data.get(0).equals(data.get(procedure.getR()))) {
            extra = 1;
        }
        for (int i = 0 + extra; i < procedure.getR() + extra; i++) {
            values.add(new TableEntry(i, procedure.dataReturn().get(i).toString()));
            lastIndex++;
        }
        for (int i = 0; i < procedure.getR(); i++) {
            values.add(new TableEntry(i + lastIndex + extra, procedure.dataReturn().get(i + extra).toString()));
        }
        return values;
    }

    //Default method that is created upon creating a JavaFX project, required for starting the program, no other real uses
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
