package helper;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class Helper {
    //CHECK IS THE FIELD EMPTY
    public static boolean isFieldEmpty(JTextField... fields){
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return true; // At least one field is empty
            }
        }
        return false; // All fields are non-empty
    }

    public static void showMessage(String input){
        String message;
        String title;
        switch (input){
            case "fill" ->{
                message = "Fill All The Fields!";
                title = "Error!";
            }
            case "done" ->{
                message = "Process Successful";
                title = "Success!";
            }
            default -> {
                message = input;
                title = "Something Wrong!";
            }

        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
