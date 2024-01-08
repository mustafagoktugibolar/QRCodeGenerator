package view;

import generators.QRCode;
import generators.QRCodeGenerator;
import helper.Helper;
import javax.swing.*;
import java.awt.*;

public class QRCodeGeneratorView extends JFrame{
    private JLabel dataLabel;
    private JTextField dataTextField;
    private JButton submitDataButton;
    private JLabel selectPathLabel;
    private JButton selectPathButton;
    private JButton generateQRButton;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JButton nameButton;
    private String selectedPath;
    private String data;
    private String fileName;
    public QRCodeGeneratorView() {
        super("QR Code Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        addGuiComponents();
    }

    private void addGuiComponents(){
        // Name Label
        nameLabel = new JLabel("File Name");
        nameLabel.setBounds(50, 20, 300, 20);
        nameLabel.setFont(new Font("DialogInput", Font.PLAIN, 14));
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(nameLabel);

        //Name Text Field
        nameTextField = new JTextField();
        nameTextField.setBounds(50, 50, 300, 25);
        nameTextField.setFont(new Font("DialogInput", Font.PLAIN, 14));
        add(nameTextField);

        // Name Button
        nameButton = new JButton("submit");
        nameButton.setBounds(50, 80, 300, 25);
        nameButton.setFont(new Font("DialogInput", Font.BOLD, 14));
        nameButton.addActionListener(e -> {
            if(!Helper.isFieldEmpty(nameTextField)){
                fileName = nameTextField.getText();
                nameLabel.setText("File Name : " + fileName);
                Helper.showMessage("done");
            }
            else{
                Helper.showMessage("error");
            }
        });
        add(nameButton);

        // Enter Data Label
        dataLabel = new JLabel("Enter Your Data");
        dataLabel.setBounds(50,120, 300,20);
        dataLabel.setFont(new Font("DialogInput", Font.PLAIN, 14));
        dataLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(dataLabel);

        // Enter Data Text Field
        dataTextField = new JTextField();
        dataTextField.setBounds(50, 150,300, 25);
        dataTextField.setFont(new Font("DialogInput", Font.PLAIN, 14));
        add(dataTextField);

        // Enter Data Button
        submitDataButton = new JButton("submit");
        submitDataButton.setBounds(45, 180, 310, 25);
        submitDataButton.setFont(new Font("DialogInput", Font.BOLD, 14));
        submitDataButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        submitDataButton.addActionListener(e -> {
            if(!Helper.isFieldEmpty(dataTextField)){
                this.data = dataTextField.getText();
                Helper.showMessage("done");
            }else{
                Helper.showMessage("Couldn't get the data!");
            }
        });
        add(submitDataButton);

        // Select Path Label
        selectPathLabel = new JLabel("Path: (Click Button to Choose) ");
        selectPathLabel.setBounds(50, 215, 300, 20);
        selectPathLabel.setFont(new Font("DialogInput", Font.PLAIN, 14));
        selectPathLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(selectPathLabel);

        // Select Path Button
        selectPathButton = new JButton("select path");
        selectPathButton.setBounds(45, 245, 310, 25);
        selectPathButton.setFont(new Font("DialogInput", Font.BOLD, 14));
        selectPathButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        selectPathButton.addActionListener(e -> {
            this.selectedPath = PathSelector.pathSelector(QRCodeGeneratorView.this);
            //Change Path Text
            selectPathLabel.setText("Path: " + selectedPath);

        });
        add(selectPathButton);

        // Generate QR Button (Show this when all the parameters are entered)
        generateQRButton = new JButton("generate");
        generateQRButton.setBounds(125, 300, 150, 25);
        generateQRButton.setFont(new Font("DialogInput", Font.BOLD, 14));
        generateQRButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        generateQRButton.addActionListener(e -> {
            if(QRCodeGenerator.generate(QRCode.createQR(data, selectedPath + "/" + fileName + ".jpg"))){
                Helper.showMessage("done");
            }else{
                Helper.showMessage("something wrong!");
            }

        });
        add(generateQRButton);

    }
}
