package pc_repair;

import java.io.*;
import java.util.ArrayList;
import jess.*;

/**
 *
 * @author ahmed
 */
public class Jess_Functions {

    Rete engine;

    public Jess_Functions() {

    }

    public void run() {
        try {

            engine = new Rete();
            engine.executeCommand("(printout t \"hello\" crlf)");
            engine.executeCommand("(clear)");
            engine.executeCommand("(watch all)");
            engine.executeCommand("(reset)");
            engine.executeCommand("(batch pc_repair.clp)");
        } catch (JessException ex) {
            System.out.println("file jess not exist");
        }
    }

    public ArrayList<String> Problems(String name_file) throws IOException {
        ArrayList<String> arr_problems = new ArrayList<String>();
        try {
            File file = new File(name_file);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String txt;
            while ((txt = br.readLine()) != null) {
                arr_problems.add(txt);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return arr_problems;
    }

    public String get_solution(String problem) throws JessException {

        engine.executeCommand("(assert (issues (issue \"" + problem + "\")))");
        Value result = engine.executeCommand("(run)");
        System.out.println(result.toString());

        String result_line = result.factValue(engine.getGlobalContext()).toString();
        String temp = "";
        int x = 0;

        for (int i = 0; i < result_line.length(); i++) {
            if (result_line.charAt(i) == '"') {
                x += 1;
            } else if (x == 1) {
                temp += result_line.charAt(i);
            }
        }
        return temp;

    }

    public void insert(String problem, String reason, String solution) throws FileNotFoundException, IOException {
        System.out.println("insert");
        String num_rule = "";

        ArrayList<String> temp_list = new ArrayList<String>();

        File file = new File("pc_repair.clp");
        BufferedReader br = new BufferedReader(new FileReader(file));

        //we do this step just to know number of lines in the file 
        String txt;
        while ((txt = br.readLine()) != null) {
            temp_list.add(txt);
        }

        br.close();
        txt = temp_list.get(temp_list.size() - 1);

        num_rule = txt.substring(13, 16);

        String rule1 = "(defrule rule" + (Integer.parseInt(num_rule) + 1)
                + "(issues {issue == \"" + problem + "\"})"
                + " => (assert (reasons (reason \"" + reason + "\"))))";
        String rule2 = "(defrule rule" + (Integer.parseInt(num_rule) + 2)
                + "(reasons {reason == \"" + reason + "\"})"
                + " => (assert (solutions (solution \"" + solution + "\"))))";
        String rule3 = "(defrule rule" + (Integer.parseInt(num_rule) + 3)
                + "(solutions {solution == \"" + solution + "\"})"
                + " => (printout t \"" + solution + "\" crlf))";

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        int i = 0;
        while (i < temp_list.size()) {
            bw.append(temp_list.get(i) + "\n");
            i++;
        }

        bw.append(rule1 + "\n");
        bw.append(rule2 + "\n");
        bw.append(rule3);
        bw.close();

        upgrade_file(problem, reason, solution);

    }

    private void upgrade_file(String problem, String reason, String solution) throws FileNotFoundException, IOException {
        File file1 = new File("problems.txt");
        File file2 = new File("reasons.txt");
        File file3 = new File("solutions.txt");

        ArrayList<String> arr_temp = new ArrayList<String>();
        String temp = "";

        // read file1
        BufferedReader DF_read = new BufferedReader(new FileReader(file1));
        while ((temp = DF_read.readLine()) != null) {
            arr_temp.add(temp);
        }
        DF_read.close();

        //rewrite to file1
        BufferedWriter DW_write = new BufferedWriter(new FileWriter(file1));
        int i = 0;
        while (i < arr_temp.size()) {
            DW_write.append(arr_temp.get(i) + "\n");
            i++;
        }
        DW_write.append(problem + "\n");
        DW_write.close();

        // empty arraylist
        if (arr_temp.removeAll(arr_temp) == true) {
            System.out.println("array list empty");
        }

        //read file2
        DF_read = new BufferedReader(new FileReader(file2));
        while ((temp = DF_read.readLine()) != null) {
            arr_temp.add(temp);
        }
        DF_read.close();

        //rewrite to file2
        DW_write = new BufferedWriter(new FileWriter(file2));
        i = 0;
        while (i < arr_temp.size()) {
            DW_write.append(arr_temp.get(i) + "\n");
            i++;
        }
        DW_write.append(reason + "\n");
        DW_write.close();

        // empty arraylist
        if (arr_temp.removeAll(arr_temp) == true) {
            System.out.println("array list empty");
        }

        //read file3
        DF_read = new BufferedReader(new FileReader(file3));
        while ((temp = DF_read.readLine()) != null) {
            arr_temp.add(temp);
        }
        DF_read.close();

        //rewrite to file2
        DW_write = new BufferedWriter(new FileWriter(file3));
        i = 0;
        while (i < arr_temp.size()) {
            DW_write.append(arr_temp.get(i) + "\n");
            i++;
        }
        DW_write.append(solution + "\n");
        DW_write.close();

        // empty arraylist
        if (arr_temp.removeAll(arr_temp) == true) {
            System.out.println("array list empty");
        }

    }

    
    
    public void delete(String problem, String reason, String solution) throws FileNotFoundException, IOException{
        System.out.println("deleted");
        delete_row_file(problem, reason, solution);
        
        File file  = new File("pc_repair.clp");
        
        BufferedReader BF_read = new BufferedReader(new FileReader(file));
        ArrayList<String> temp_rules = new ArrayList<>(); 
        String temp;
        
        while ((temp = BF_read.readLine()) != null) {
            temp_rules.add(temp);
        }
        BF_read.close();
        
        temp = "";
        
        int ch = 0;
        int index_deleted_rules[] = new int[3];
        
        for(int i = 0; i < temp_rules.size(); i++){
            for(int x = 0; x < temp_rules.get(i).length(); x++)
                if(temp_rules.get(i).charAt(x) == '"')
                    ch ++;
                else if(ch == 1)
                    temp += temp_rules.get(i).charAt(x);
            
            if (temp.equalsIgnoreCase(problem))
                temp_rules.remove(i);
            else if(temp.equalsIgnoreCase(reason))
                temp_rules.remove(i);
            else if(temp.equalsIgnoreCase(solution))
                temp_rules.remove(i);
            temp = "";
            ch = 0;
        }
        
        
        BufferedWriter BF_write = new BufferedWriter(new FileWriter(file));
        
        int i = 0;
        while (i < temp_rules.size()) {
            BF_write.append(temp_rules.get(i) + "\n");
            i++;
        }
        BF_write.close();
        
        
        
        
        
    }
    
    public void delete_row_file(String problem, String reason, String solution) throws FileNotFoundException, IOException{
        File file1 = new File("problems.txt");
        File file2 = new File("reasons.txt");
        File file3 = new File("solutions.txt");

        ArrayList<String> arr_temp = new ArrayList<String>();
        String temp = "";

        // read file1
        BufferedReader BF_read = new BufferedReader(new FileReader(file1));
        while ((temp = BF_read.readLine()) != null)
            arr_temp.add(temp);
            
        BF_read.close();

        //rewrite to file1
        BufferedWriter BF_write = new BufferedWriter(new FileWriter(file1));
       
        arr_temp.remove(problem);
        int i = 0;
        while (i < arr_temp.size()) {
            BF_write.append(arr_temp.get(i) + "\n");
            i++;
        }
        BF_write.append(problem + "\n");
        BF_write.close();

        // empty arraylist
        if (arr_temp.removeAll(arr_temp) == true) {
            System.out.println("array list empty");
        }

        //read file2
        BF_read = new BufferedReader(new FileReader(file2));
        while ((temp = BF_read.readLine()) != null)
                arr_temp.add(temp);
        
        BF_read.close();

        //rewrite to file2
        BF_write = new BufferedWriter(new FileWriter(file2));
        
        arr_temp.remove(reason);
        i = 0;
        while (i < arr_temp.size()) {
            BF_write.append(arr_temp.get(i) + "\n");
            i++;
        }
        BF_write.append(reason + "\n");
        BF_write.close();

        // empty arraylist
        if (arr_temp.removeAll(arr_temp) == true) {
            System.out.println("array list empty");
        }

        //read file3
        BF_read = new BufferedReader(new FileReader(file3));
        while ((temp = BF_read.readLine()) != null)
                arr_temp.add(temp);
        
        BF_read.close();

        //rewrite to file2
        BF_write = new BufferedWriter(new FileWriter(file3));
        
        System.out.println(arr_temp.remove(solution));
        i = 0;
        while (i < arr_temp.size()) {
            BF_write.append(arr_temp.get(i) + "\n");
            i++;
        }
        BF_write.append(solution + "\n");
        BF_write.close();

        // empty arraylist
        if (arr_temp.removeAll(arr_temp) == true) {
            System.out.println("array list empty");
        }
    }
    
    public void Update_rule(String[] old_rule, String[] new_rule) throws FileNotFoundException, IOException{
        System.out.println("updated");
        
        File file  = new File("pc_repair.clp");
        
        BufferedReader BF_read = new BufferedReader(new FileReader(file));
        ArrayList<String> temp_rules = new ArrayList<>(); 
        String temp;
        
        while ((temp = BF_read.readLine()) != null) {
            temp_rules.add(temp);
        }
        BF_read.close();
        
        temp = "";
        
        int ch = 0;
        int index_deleted_rules[] = new int[3];
        
        for(int i = 0; i < temp_rules.size(); i++){
            for(int x = 0; x < temp_rules.get(i).length(); x++)
                if(temp_rules.get(i).charAt(x) == '"')
                    ch ++;
                else if(ch == 1)
                    temp += temp_rules.get(i).charAt(x);
            
            if (temp.equalsIgnoreCase(old_rule[0]))
                temp_rules.remove(i);
            else if(temp.equalsIgnoreCase(old_rule[1]))
                temp_rules.remove(i);
            else if(temp.equalsIgnoreCase(old_rule[2]))
                temp_rules.remove(i);
            temp = "";
            ch = 0;
        }
        
        BufferedWriter BF_write = new BufferedWriter(new FileWriter(file));
        
        int i = 0;
        while (i < temp_rules.size()) {
            BF_write.append(temp_rules.get(i) + "\n");
            i++;
        }
        BF_write.close();
        
        insert(new_rule[0], new_rule[1], new_rule[2]);
        delete(new_rule[0], new_rule[1], new_rule[2]);
    }
}
