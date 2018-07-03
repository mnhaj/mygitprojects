package fyp.main;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PdfGUI extends JFrame {

	private JPanel contentPane;
	JTextArea textArea;
	String path = "F:\\Development\\Java Projects\\PdfEditor\\images\\";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PdfGUI frame = new PdfGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PdfGUI() {
		this.setTitle("PDF Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Enter Text................... ");
			}
		});
		ImageIcon img = this.setImageOnMenuItem(path + "//new.png");
		mntmNew.setIcon(img);
		mnNewMenu.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String path;
				try {
					path = open();
					PdfManager pdfManager = new PdfManager();
					pdfManager.setFilePath(path);
					textArea.setText(pdfManager.ToText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ImageIcon img1 = this.setImageOnMenuItem(path + "//open.png");
		mntmOpen.setIcon(img1);
		mnNewMenu.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save ");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("Save Option Will be implemented in 60%");
			}
		});
		ImageIcon img2 = this.setImageOnMenuItem(path + "//save.png");
		mntmSave.setIcon(img2);
		mnNewMenu.add(mntmSave);

		JMenuItem mntmExit = new JMenuItem("Exit");
		ImageIcon img3 = this.setImageOnMenuItem(path + "//exit.png");
		mntmExit.setIcon(img3);
		mnNewMenu.add(mntmExit);

		JMenu menu = new JMenu("Edit");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Cut");
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("Copy");
		menu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("Paste");
		menu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menu.add(menuItem_3);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		textArea = new JTextArea();

		// Mouse Click Function When the TextArea will be Clicket it will Remove The
		// Existing Text
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textArea.getText().toString().equalsIgnoreCase("Enter Text................... ")) {
					textArea.setText("");
				}
			}
		});
		textArea.setText("Enter Text................... ");
		JScrollPane taScroll = new JScrollPane(textArea); // Adds the scrolls when there are too much text.
		contentPane.add(taScroll);
		contentPane.setVisible(true);
	}

	ImageIcon setImageOnMenuItem(String path) {
		ImageIcon newImage = new ImageIcon(path);
		Image image = newImage.getImage(); // transform it
		Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		newImage = new ImageIcon(newimg);
		return newImage;

	}

	public String open() throws FileNotFoundException {
		File f = null;
		JFileChooser fileChooser = new JFileChooser();

		// fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		// int result = fileChooser.showOpenDialog(this);
		// if (result == JFileChooser.APPROVE_OPTION) {
		// File f = fileChooser.getSelectedFile();

		if (fileChooser.showOpenDialog(null) == fileChooser.APPROVE_OPTION) {
			f = fileChooser.getSelectedFile();
		}
		return f.getPath().toString();
	}

}
