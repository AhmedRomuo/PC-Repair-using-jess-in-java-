package pc_repair;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.controlsfx.control.textfield.TextFields;
import jess.*;

/**
 *
 * @author ahmed
 */
public class Pc_Repair extends Application {
    
    Scene sc_modify,sc_problem, sc_home;
    Jess_Functions js_file = new Jess_Functions();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        // the home page
        
        Button btn_problem = new Button();
        Button btn_modify = new Button();
            
        btn_problem.setText("Solve Problem");
        btn_modify.setText("Modification");
        
        btn_modify.setMaxWidth(120);
        btn_problem.setMaxWidth(120);
        
        VBox root_home = new VBox();
        root_home.setAlignment(Pos.CENTER);
        root_home.setSpacing(15);
        root_home.getChildren().addAll(btn_problem, btn_modify);
        
        sc_home = new Scene(root_home, 300, 250);
        
        ////////////////////////////////////////////////////////////////////////        
        
        // problem solve scene
        Button btn_solve = new Button();
        Button btn_back_problem = new Button();
        
        btn_back_problem.setText("back");
        btn_solve.setText("Solve");
        
        btn_back_problem.setMaxWidth(50);
        btn_solve.setMaxWidth(50);
        
       
        TextField txt_problem = new TextField();
        Label lbl_solve = new Label();
        txt_problem.setMaxWidth(200);
        TextFields.bindAutoCompletion(txt_problem, new Jess_Functions().Problems("problems.txt"));
        
        VBox root_solve_problem = new VBox();
        HBox rr = new HBox();
        
        root_solve_problem.setAlignment(Pos.CENTER);
        root_solve_problem.setSpacing(15);
        rr.setAlignment(Pos.CENTER);
        rr.setSpacing(10);
        
        rr.getChildren().addAll(btn_solve, btn_back_problem);
        root_solve_problem.getChildren().addAll(txt_problem,lbl_solve, rr);
        
        sc_problem = new Scene(root_solve_problem, 300, 250);
        
        
        ////////////////////////////////////////////////////////////////////////
        
        // modification scene
        
        Label lb_add_problem = new Label("Problem :");
        Label lb_add_reason = new Label("Reason :");
        Label lb_add_solution = new Label("Solution :");
        
        TextField txt_add_problem = new TextField();
        TextField txt_add_reason = new TextField();
        TextField txt_add_solution = new TextField();
        
        txt_add_problem.setMaxWidth(200);
        TextFields.bindAutoCompletion(txt_add_problem, new Jess_Functions().Problems("problems.txt"));
        
        txt_add_reason.setMaxWidth(200);
        TextFields.bindAutoCompletion(txt_add_reason, new Jess_Functions().Problems("reasons.txt"));
        
        txt_add_solution.setMaxWidth(200);
        TextFields.bindAutoCompletion(txt_add_solution, new Jess_Functions().Problems("solutions.txt"));
        
        Button btn_add_problem = new Button();
        Button btn_update_problem = new Button();
        Button btn_delete_problem = new Button();
        Button btn_back = new Button();
        
        btn_add_problem.setText("add");
        btn_update_problem.setText("update");
        btn_delete_problem.setText("delete");
        btn_back.setText("back");
        
        
        btn_add_problem.setMaxWidth(50);
        btn_update_problem.setMaxWidth(70);
        btn_delete_problem.setMaxWidth(70);
        btn_back.setMaxWidth(50);
        
        CheckBox ch_update = new CheckBox("Select to update");
        
        String[] arr_old_value = new String[3];
        String[] arr_new_value = new String[3];
        
        Label lb_update_message = new Label("put new Rule");
        lb_update_message.setVisible(false);
        
        GridPane gd_insert = new GridPane();
        gd_insert.setAlignment(Pos.CENTER);
        gd_insert.setHgap(10);
        
        gd_insert.addRow(0, lb_add_problem, txt_add_problem);
        gd_insert.addRow(1, lb_add_reason, txt_add_reason);
        gd_insert.addRow(2, lb_add_solution, txt_add_solution);
        
        HBox h_ii = new HBox();
        h_ii.setAlignment(Pos.CENTER);
        h_ii.setSpacing(10);
        
        h_ii.getChildren().addAll(btn_add_problem, btn_update_problem, btn_delete_problem, btn_back);
        
        VBox v_ii = new VBox();
        v_ii.setAlignment(Pos.CENTER);
        v_ii.setSpacing(15);
        
        v_ii.getChildren().addAll(gd_insert, lb_update_message, ch_update, h_ii);
        sc_modify = new Scene(v_ii, 300, 250);       
        ///////////////////////////////////////////////////////////////////////
        // actions
        
        btn_modify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("insert scene");
                primaryStage.setScene(sc_modify);
            }
        });
        
        btn_problem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("problem solve scene");
                primaryStage.setScene(sc_problem);
            }
        });
        
        btn_back_problem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("back from insert scene");
                primaryStage.setScene(sc_home);
            }
        });
        
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("back from insert scene");
                primaryStage.setScene(sc_home);
                lb_update_message.setVisible(false);
            }
        });
        
        
        // action buttons solve and modification
        
        btn_solve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    js_file.run();
                    lbl_solve.setText("solution : " + js_file.get_solution(txt_problem.getText().toLowerCase().toString()));
                } catch (JessException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        btn_add_problem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //js_file.run();
                    new Jess_Functions().insert(txt_add_problem.getText().toString(), txt_add_reason.getText().toString(), txt_add_solution.getText().toString());
                } catch (IOException ex) {
                    Logger.getLogger(Pc_Repair.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btn_delete_problem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //js_file.run();
                    new Jess_Functions().delete(txt_add_problem.getText().toString(), txt_add_reason.getText().toString(), txt_add_solution.getText().toString());
                } catch (IOException ex) {
                    Logger.getLogger(Pc_Repair.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btn_update_problem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //js_file.run();
                    arr_new_value[0] = txt_add_problem.getText().toString();
                    arr_new_value[1] = txt_add_reason.getText().toString();
                    arr_new_value[2] = txt_add_solution.getText().toString();
                    new Jess_Functions().Update_rule(arr_old_value, arr_new_value);
                    ch_update.setSelected(false);
                } catch (IOException ex) {
                    Logger.getLogger(Pc_Repair.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        ch_update.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                arr_old_value[0] = txt_add_problem.getText().toLowerCase();
                arr_old_value[1] = txt_add_reason.getText().toLowerCase();
                arr_old_value[2] = txt_add_solution.getText().toLowerCase();
                
                txt_add_problem.setText("");
                txt_add_reason.setText("");
                txt_add_solution.setText("");
                
                lb_update_message.setVisible(true);
            }
        });
        
        primaryStage.setTitle("PC Repair Assitant");
        primaryStage.setScene(sc_home);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        
          launch(args);
           
//          try {
//
//            Rete engine = new Rete();
//            engine.executeCommand("(printout t \"hello\" crlf)");
//            engine.executeCommand("(clear)");
//            engine.executeCommand("(watch all)");
//            engine.executeCommand("(reset)");
//            engine.executeCommand("(batch pc_repair.clp)");
//            engine.removeDefrule("(issues {issue == \"continue beep noise\"})=> (assert (solutions (solution \"expert engineer\")))");
//              System.out.println(engine.executeCommand("(run)").toString());
//          } catch (JessException ex) {
//            System.out.println("file jess not exist");
//        }
            
            
        
        
    }
    
}
