import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop {
    private ArrayList<Gadget> gadgets = new ArrayList<>();

    public GadgetShop() {
        JFrame frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(13, 2));

        JLabel modelLabel = new JLabel("Model:");
        JTextField modelField = new JTextField();
        panel.add(modelLabel);
        panel.add(modelField);

        JLabel priceLabel = new JLabel("Price (£):");
        JTextField priceField = new JTextField();
        panel.add(priceLabel);
        panel.add(priceField);

        JLabel weightLabel = new JLabel("Weight (g):");
        JTextField weightField = new JTextField();
        panel.add(weightLabel);
        panel.add(weightField);

        JLabel sizeLabel = new JLabel("Size:");
        JTextField sizeField = new JTextField();
        panel.add(sizeLabel);
        panel.add(sizeField);

        JLabel extraLabel = new JLabel("Credit/Memory:");
        JTextField extraField = new JTextField();
        panel.add(extraLabel);
        panel.add(extraField);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JTextField phoneNumberField = new JTextField();
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);

        JLabel durationLabel = new JLabel("Call Duration (minutes):");
        JTextField durationField = new JTextField();
        panel.add(durationLabel);
        panel.add(durationField);

        JLabel downloadSizeLabel = new JLabel("Download Size (MB):");
        JTextField downloadSizeField = new JTextField();
        panel.add(downloadSizeLabel);
        panel.add(downloadSizeField);

        JLabel displayNumberLabel = new JLabel("Display Number:");
        JTextField displayNumberField = new JTextField();
        panel.add(displayNumberLabel);
        panel.add(displayNumberField);

        JButton addMobileButton = new JButton("Add Mobile");
        JButton addMP3Button = new JButton("Add MP3");
        JButton displayButton = new JButton("Display All Gadgets");
        JButton makeCallButton = new JButton("Make Call");
        JButton downloadMusicButton = new JButton("Download Music");
        JButton clearButton = new JButton("Clear");

        panel.add(addMobileButton);
        panel.add(addMP3Button);
        panel.add(displayButton);
        panel.add(makeCallButton);
        panel.add(downloadMusicButton);
        panel.add(clearButton);

        addMobileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String model = modelField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    int weight = Integer.parseInt(weightField.getText());
                    String size = sizeField.getText();
                    int credit = Integer.parseInt(extraField.getText());
                    Mobile mobile = new Mobile(model, price, weight, size, credit);
                    gadgets.add(mobile);
                    JOptionPane.showMessageDialog(frame, "Mobile added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid details.");
                }
            }
        });

        addMP3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String model = modelField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    int weight = Integer.parseInt(weightField.getText());
                    String size = sizeField.getText();
                    int memory = Integer.parseInt(extraField.getText());
                    MP3 mp3 = new MP3(model, price, weight, size, memory);
                    gadgets.add(mp3);
                    JOptionPane.showMessageDialog(frame, "MP3 added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid details.");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder displayText = new StringBuilder();
                for (int i = 0; i < gadgets.size(); i++) {
                    Gadget gadget = gadgets.get(i);
                    displayText.append("Gadget #").append(i).append(":\n");
                    gadget.display();
                    displayText.append("\n");
                }
                JTextArea textArea = new JTextArea(displayText.toString());
                textArea.setEditable(false);
                JOptionPane.showMessageDialog(frame, new JScrollPane(textArea), "Gadget Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        makeCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(displayNumberField.getText());
                    if (index >= 0 && index < gadgets.size() && gadgets.get(index) instanceof Mobile) {
                        String phoneNumber = phoneNumberField.getText();
                        int duration = Integer.parseInt(durationField.getText());
                        Mobile mobile = (Mobile) gadgets.get(index);
                        mobile.makeCall(phoneNumber, duration);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid index for a Mobile gadget.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid details.");
                }
            }
        });

        downloadMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(displayNumberField.getText());
                    if (index >= 0 && index < gadgets.size() && gadgets.get(index) instanceof MP3) {
                        int downloadSize = Integer.parseInt(downloadSizeField.getText());
                        MP3 mp3 = (MP3) gadgets.get(index);
                        mp3.downloadMusic(downloadSize);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid index for an MP3 gadget.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid details.");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelField.setText("");
                priceField.setText("");
                weightField.setText("");
                sizeField.setText("");
                extraField.setText("");
                phoneNumberField.setText("");
                durationField.setText("");
                downloadSizeField.setText("");
                displayNumberField.setText("");
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}
