import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class RadioButtonDemo extends JFrame implements ActionListener {
    private JRadioButton birdBtn, catBtn, dogBtn, rabbitBtn, pigBtn;
    private JLabel imageLabel;
    private ButtonGroup group;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setSize(500, 350);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        // Create radio buttons
        birdBtn = new JRadioButton("Bird");
        catBtn = new JRadioButton("Cat");
        dogBtn = new JRadioButton("Dog");
        rabbitBtn = new JRadioButton("Rabbit");
        pigBtn = new JRadioButton("Pig");

        // Group them
        group = new ButtonGroup();
        group.add(birdBtn);
        group.add(catBtn);
        group.add(dogBtn);
        group.add(rabbitBtn);
        group.add(pigBtn);

        // Add to panel
        radioPanel.add(birdBtn);
        radioPanel.add(catBtn);
        radioPanel.add(dogBtn);
        radioPanel.add(rabbitBtn);
        radioPanel.add(pigBtn);

        // Add action listeners
        birdBtn.addActionListener(this);
        catBtn.addActionListener(this);
        dogBtn.addActionListener(this);
        rabbitBtn.addActionListener(this);
        pigBtn.addActionListener(this);

        // Image display label
        imageLabel = new JLabel("Select a pet", SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(200, 200));

        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pet = "";
        String imagePath = "images/";

        if (e.getSource() == birdBtn) {
            pet = "Bird";
            imagePath += "bird.png";
        } else if (e.getSource() == catBtn) {
            pet = "Cat";
            imagePath += "cat.png";
        } else if (e.getSource() == dogBtn) {
            pet = "Dog";
            imagePath += "dog.png";
        } else if (e.getSource() == rabbitBtn) {
            pet = "Rabbit";
            imagePath += "rabbit.png";
        } else if (e.getSource() == pigBtn) {
            pet = "Pig";
            imagePath += "pig.png";
        }

        // Load image if it exists
        File imgFile = new File(imagePath);
        if (imgFile.exists()) {
            imageLabel.setIcon(new ImageIcon(imagePath));
            imageLabel.setText("");
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("Image not found!");
        }

        // Show message box
        JOptionPane.showMessageDialog(this, "You selected: " + pet);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonDemo::new);
    }
}
