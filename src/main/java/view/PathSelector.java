package view;

import helper.Helper;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class PathSelector {
    public static String pathSelector(Component parent){
        JFileChooser fileChooser = fileChooser("All Files", JFileChooser.FILES_AND_DIRECTORIES, "pdf");

        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file path
            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        else{
            Helper.showMessage("Couldn't get the path!");
            return null;
        }
    }

    private static JFileChooser fileChooser(String descriotion, int selectionMode, String... extensions){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(descriotion, extensions));
        fileChooser.setFileSelectionMode(selectionMode);
        return fileChooser;
    }
}
