package application3;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PortfolioWebsite {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JLabel titleLabel;

    // Define color constants
    private Color backgroundColor = Color.WHITE;
    private Color titleColor = Color.BLACK; // Dark black
    private Color buttonColor = new Color(144, 238, 144); // Light green
    private Color textColor = new Color(0, 0, 102); // Dark blue (adjust color as per preference)
    private Color aboutBackgroundColor = new Color(245, 245, 245); // Light gray
    private Color aboutTextColor = Color.BLACK; // Dark gray

    public PortfolioWebsite() {
        frame = new JFrame("Portfolio Website");
        frame.setSize(800, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(backgroundColor);

        titleLabel = new JLabel("Welcome to My Portfolio Website");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(titleColor);
        titleLabel.setBorder(new EmptyBorder(35, 20, 35, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel menuPanel = createMenuPanel();
        mainPanel.add(menuPanel, BorderLayout.WEST);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(backgroundColor);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new GridLayout(3, 1, 0, 20));
        menuPanel.setBackground(backgroundColor);
        menuPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JButton projectsButton = createMenuButton("PROJECTS");
        projectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayProjects();
            }
        });
        menuPanel.add(projectsButton);

        JButton aboutButton = createMenuButton("About Me");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAboutMe();
            }
        });
        menuPanel.add(aboutButton);

        JButton contactButton = createMenuButton("CONTACT");
        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayContact();
            }
        });
        menuPanel.add(contactButton);

        return menuPanel;
    }

    private JButton createMenuButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setBackground(buttonColor);
        button.setForeground(textColor);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 80)); // Set button size
        return button;
    }

    private void displayProjects() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());

        JPanel projectsPanel = new JPanel(new GridBagLayout());
        projectsPanel.setBackground(Color.WHITE);

        JLabel projectsLabel = new JLabel("MY PROJECTS");
        projectsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        projectsLabel.setForeground(titleColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 20, 0);
        projectsPanel.add(projectsLabel, gbc);

        // Replace with your image path
        ImageIcon projectImage = new ImageIcon("path_to_your_image.jpg");
        JLabel imageLabel = new JLabel(projectImage);
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        projectsPanel.add(imageLabel, gbc);

        JTextArea projectsTextArea = new JTextArea();
        projectsTextArea.setText(
                "Percentage Calculator\n" +
                        "Quiz Application\n" +
                        "Portfolio Website Creation"
        );
        projectsTextArea.setEditable(false);
        projectsTextArea.setBackground(Color.WHITE);
        projectsTextArea.setForeground(textColor);
        projectsTextArea.setFont(new Font("Arial", Font.BOLD, 16));
        projectsTextArea.setMargin(new Insets(10, 10, 10, 10));
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        projectsPanel.add(new JScrollPane(projectsTextArea), gbc);

        contentPanel.add(projectsPanel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }

    private void displayAboutMe() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());

        JLabel aboutLabel = new JLabel("ABOUT ME");
        aboutLabel.setFont(new Font("Arial", Font.BOLD, 30));
        aboutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aboutLabel.setForeground(Color.BLACK); // Set text color to black
        aboutLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        contentPanel.add(aboutLabel, BorderLayout.NORTH);

        JTextArea aboutTextArea = new JTextArea();
        aboutTextArea.setText(
                "Greetings all.\n" +
                        "I'm Kanagaprabha CS, a 3rd-year CSE student with a passion for coding in Java.\n" +
                        "I enjoy solving problems and learning new technologies.\n" +
                        "Currently pursuing my degree, I am eager to explore opportunities where I can apply my skills and grow as a developer."
        );
        aboutTextArea.setEditable(false);
        aboutTextArea.setBackground(aboutBackgroundColor);
        aboutTextArea.setForeground(Color.BLACK); // Set text color to black
        aboutTextArea.setFont(new Font("Arial", Font.BOLD, 16));
        aboutTextArea.setMargin(new Insets(10, 10, 10, 50));
        contentPanel.add(new JScrollPane(aboutTextArea), BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }

    private void displayContact() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());

        JLabel contactLabel = new JLabel("CONTACT ME:");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 30));
        contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contactLabel.setForeground(Color.BLACK); // Set text color to black
        contactLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        contentPanel.add(contactLabel, BorderLayout.NORTH);

        JTextArea contactTextArea = new JTextArea();
        contactTextArea.setText(

                        "EMAIL: kanagaprabhacs@gmail.com"
        );
        contactTextArea.setEditable(false);
        contactTextArea.setBackground(Color.WHITE);
        contactTextArea.setForeground(textColor); // Use the dark blue text color
        contactTextArea.setFont(new Font("Arial", Font.BOLD, 16));
        contactTextArea.setMargin(new Insets(10, 50, 10, 10));
        contentPanel.add(new JScrollPane(contactTextArea), BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PortfolioWebsite();
            }
        });
    }
}