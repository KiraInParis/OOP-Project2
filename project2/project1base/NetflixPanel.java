// Project 2 code by: Beckett Collins
// CSCI 3381
// Project 2

package project1base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;

public class NetflixPanel extends JPanel
{
	private int count;
	
	Shows allData = new Shows("allData","./project1base/netflixAllWeeksGlobalProcessed.txt");
	private JTextField weekSelection;
	private JTextField editField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public NetflixPanel() 
	{
		setBackground(Color.GRAY);
		
		count = 0;
		setLayout(null);
		setPreferredSize(new Dimension(854, 480));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setBounds(0, 0, 854, 480);
		add(tabbedPane);
		
		Panel homePage = new Panel();
		tabbedPane.addTab("Home Page", new ImageIcon(NetflixPanel.class.getResource("/project1base/TabLogo.png")), homePage, "Hello! Welcome to your very own bootleg Netflix! This home page contains the welcoming statement as well as project information.");
		homePage.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(NetflixPanel.class.getResource("/project1base/TitleText.png")));
		logo.setBounds(329, 35, 209, 72);
		homePage.add(logo);
		
		JLabel logoText = new JLabel("Bootleg");
		logoText.setForeground(Color.RED);
		logoText.setFont(new Font("Tahoma", Font.BOLD, 20));
		logoText.setBounds(386, 11, 83, 38);
		homePage.add(logoText);
		
		JLabel intro1 = new JLabel("An object oriented java project by Beckett Collins: Project 2 - CSCI 3381");
		intro1.setBounds(225, 103, 447, 72);
		homePage.add(intro1);
		
		JLabel intro2 = new JLabel("Featuring adapted code by: Chris Baugh and Mark Doderer");
		intro2.setBounds(262, 127, 372, 72);
		homePage.add(intro2);
		
		JLabel intro3 = new JLabel("Functionality and design by Beckett Collins\r\n");
		intro3.setBounds(300, 155, 372, 72);
		homePage.add(intro3);
		
		JLabel intro4 = new JLabel("Any likeness to another company, real or fake, is purely coincidental.");
		intro4.setFont(new Font("Tahoma", Font.BOLD, 11));
		intro4.setBounds(233, 249, 503, 72);
		homePage.add(intro4);
		
		JLabel ver = new JLabel("Version 0.0.1\r\n");
		ver.setFont(new Font("Tahoma", Font.BOLD, 11));
		ver.setBounds(10, 381, 503, 72);
		homePage.add(ver);
		
		JLabel lblThisIs = new JLabel("^ This is an image");
		lblThisIs.setForeground(Color.RED);
		lblThisIs.setFont(new Font("Tahoma", Font.BOLD, 8));
		lblThisIs.setBounds(386, 82, 83, 38);
		homePage.add(lblThisIs);
		
		Panel showsList = new Panel();
		tabbedPane.addTab("Shows List", new ImageIcon(NetflixPanel.class.getResource("/project1base/TabLogo.png")), showsList, null);
		showsList.setLayout(null);
		
		JLabel logoText_1 = new JLabel("Shows List - Data Functionality");
		logoText_1.setForeground(new Color(255, 0, 0));
		logoText_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		logoText_1.setBounds(279, 11, 378, 38);
		showsList.add(logoText_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(483, 60, 356, 359);
		showsList.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea.setText(allData.toString());
		
		JLabel listTitle = new JLabel("List:");
		listTitle.setForeground(Color.RED);
		listTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		listTitle.setBounds(638, 30, 91, 38);
		showsList.add(listTitle);
		
		JLabel movieTitle = new JLabel("Movie Title:");
		movieTitle.setForeground(Color.BLACK);
		movieTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		movieTitle.setBounds(10, 121, 188, 38);
		showsList.add(movieTitle);
		
		JLabel weekList = new JLabel("Enter Week:");
		weekList.setForeground(Color.BLACK);
		weekList.setFont(new Font("Tahoma", Font.BOLD, 11));
		weekList.setBounds(10, 60, 188, 38);
		showsList.add(weekList);
		
		weekSelection = new JTextField();
		weekSelection.setColumns(10);
		weekSelection.setBounds(10, 90, 204, 20);
		showsList.add(weekSelection);
		
		JComboBox movieSelection = new JComboBox();
		movieSelection.setBounds(10, 151, 204, 20);
		showsList.add(movieSelection);
		
		JButton btnWeekFind = new JButton("Find");
		btnWeekFind.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList<ShowWeek> week = allData.getOneWeek(weekSelection.getText());
				if (week != null && week.size() > 0);
				String [] data = new String[week.size()];
				int index = 0;
				for (ShowWeek show : week)
				{
					data[index] = show.getShowTitle();
					index++;
				}
				movieSelection.setModel(new DefaultComboBoxModel(data));
			}
		});
		btnWeekFind.setBounds(224, 89, 91, 23);
		showsList.add(btnWeekFind);
		
		JRadioButton rbWeek = new JRadioButton("Week");
		rbWeek.setSelected(true);
		buttonGroup.add(rbWeek);
		rbWeek.setBounds(10, 178, 125, 23);
		showsList.add(rbWeek);
		
		JRadioButton rbCategory = new JRadioButton("Category");
		buttonGroup.add(rbCategory);
		rbCategory.setBounds(10, 204, 125, 23);
		showsList.add(rbCategory);
		
		JRadioButton rbRank = new JRadioButton("Rank");
		buttonGroup.add(rbRank);
		rbRank.setBounds(10, 230, 125, 23);
		showsList.add(rbRank);
		
		JRadioButton rbShowTitle = new JRadioButton("Title");
		buttonGroup.add(rbShowTitle);
		rbShowTitle.setBounds(10, 256, 125, 23);
		showsList.add(rbShowTitle);
		
		JRadioButton rbHoursViewed = new JRadioButton("Hours Viewed");
		buttonGroup.add(rbHoursViewed);
		rbHoursViewed.setBounds(10, 308, 125, 23);
		showsList.add(rbHoursViewed);
		
		JRadioButton rbSeasonTitle = new JRadioButton("Season Title");
		buttonGroup.add(rbSeasonTitle);
		rbSeasonTitle.setBounds(10, 282, 125, 23);
		showsList.add(rbSeasonTitle);
		
		JRadioButton rbWeeksTop10 = new JRadioButton("Weeks At Top 10");
		buttonGroup.add(rbWeeksTop10);
		rbWeeksTop10.setBounds(10, 334, 125, 23);
		showsList.add(rbWeeksTop10);
		
		editField = new JTextField();
		editField.setColumns(10);
		editField.setBounds(10, 377, 204, 20);
		showsList.add(editField);
		
		JButton editButton = new JButton("Make Edit");
		editButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String edit = editField.getText();
				ShowWeek selection = allData.find((String)movieSelection.getSelectedItem(), weekSelection.getText());
				if (allData.purgeCheck(selection.getShowTitle()) == true)
				{
					editField.setText("Show is currently purged, can't be edited, try another show.");
					return;
				}
				if (rbWeek.isSelected())
				{
					selection.setWeek(edit);
				}
				if (rbCategory.isSelected())
				{
					selection.setCategory(edit);
				}
				if (rbRank.isSelected())
				{
					selection.setRank(edit);
				}
				if (rbShowTitle.isSelected())
				{
					selection.setShowTitle(edit);
				}
				if (rbHoursViewed.isSelected())
				{
					selection.setHrsViewed(edit);
				}
				if (rbSeasonTitle.isSelected())
				{
					selection.setSeasonTitle(edit);
				}
				if (rbWeeksTop10.isSelected())
				{
					selection.setWeeksTop10(edit);
				}
				
				ArrayList<ShowWeek> week = allData.getOneWeek(weekSelection.getText());
				if (week != null && week.size() > 0);
				String [] data = new String[week.size()];
				int index = 0;
				for (ShowWeek show : week)
				{
					data[index] = show.getShowTitle();
					index++;
				}
				movieSelection.setModel(new DefaultComboBoxModel(data));
				
				textArea.setText(allData.toString());
			}
		});
		editButton.setBounds(10, 396, 91, 23);
		showsList.add(editButton);
		
		JSlider purgeSlider = new JSlider();
		purgeSlider.setPaintTicks(true);
		purgeSlider.setSnapToTicks(true);
		purgeSlider.setMajorTickSpacing(1);
		purgeSlider.setMaximum(1);
		purgeSlider.setBounds(239, 165, 200, 13);
		showsList.add(purgeSlider);
		
		JLabel purgeLabel = new JLabel("Purge Selection:");
		purgeLabel.setForeground(Color.BLACK);
		purgeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		purgeLabel.setBounds(287, 123, 125, 38);
		showsList.add(purgeLabel);
		
		JLabel purgeLabel1 = new JLabel("Purge");
		purgeLabel1.setForeground(Color.BLACK);
		purgeLabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
		purgeLabel1.setBounds(239, 163, 71, 38);
		showsList.add(purgeLabel1);
		
		JLabel purgelabel2 = new JLabel("Unpurge");
		purgelabel2.setForeground(Color.BLACK);
		purgelabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		purgelabel2.setBounds(390, 163, 71, 38);
		showsList.add(purgelabel2);
		
		JButton purgeButton = new JButton("Take Action");
		purgeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String temp = "";
				ShowWeek selection = allData.find((String)movieSelection.getSelectedItem(), weekSelection.getText());
				
				if (purgeSlider.getValue() == 0 && allData.purgeCheck(selection.getShowTitle()) == false)
				{
					allData.purgeShow(selection.getShowTitle());
				}
				
				if (allData.purgeCheck(selection.getShowTitle()) == true)
				{
					temp = selection.getShowTitle();
					temp = temp.substring(1);
				}
				if (purgeSlider.getValue() == 1 && allData.purgeCheck(selection.getShowTitle()) == true)
				{
					allData.unPurgeShow(temp);
				}
				
				ArrayList<ShowWeek> week = allData.getOneWeek(weekSelection.getText());
				if (week != null && week.size() > 0);
				String [] data = new String[week.size()];
				int index = 0;
				for (ShowWeek show : week)
				{
					data[index] = show.getShowTitle();
					index++;
				}
				movieSelection.setModel(new DefaultComboBoxModel(data));
				
				textArea.setText(allData.toString());
				
			}
		});
		purgeButton.setBounds(289, 192, 91, 23);
		showsList.add(purgeButton);
		
		JButton saveButton = new JButton("SAVE CHANGES");
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				allData.writeFile();
			}
		});
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		saveButton.setBounds(239, 282, 200, 49);
		showsList.add(saveButton);
		
		
		Panel game = new Panel();
		tabbedPane.addTab("Mini-Game!", new ImageIcon(NetflixPanel.class.getResource("/project1base/TabLogo.png")), game, null);
		tabbedPane.setEnabledAt(2, false);
		game.setLayout(null);
		
	}
	
	public void doClose() 
	{
		allData.writeFile();
	}
	
}
