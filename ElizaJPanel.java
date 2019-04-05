package eliza;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ElizaJPanel extends JPanel implements ActionListener{

	private JButton jbtn;
	private JButton jbtn2;
	private JButton jbtn3;
	private JButton jbtn4;
	private JButton jbtn5;
	private JButton jbtn6;
	private JLabel jlbl;
	private JTextField jtf;
	private JTextArea jta;
	private JScrollPane jsp;
	
	private String wordsInSentence[];
	private String longestWordsArr[] = new String[10];
	private String shortestWordsArr[] = new String [10];
	private String sortedLongestWords[] = new String [10];
	private String question = "";
	private String userInput = "";
	private String longestString = "";
	private String shortestString = "aaaaaaaaaaaaaaaaa";
	private int session = 1;
	private int questionNumber = 0;
	private int counter = 0;

	GridBagConstraints c = new GridBagConstraints();

	public ElizaJPanel() {
		jbtn = new JButton("Start Session"); //initializing components buttons
		jbtn2 = new JButton("View All Q & A");
		jbtn3 = new JButton("View Longest Words");
		jbtn4 = new JButton("View Longest Words Alphabetically");
		jbtn5 = new JButton("Next Question");
		jbtn6 = new JButton("Finish Session");
		jlbl = new JLabel("Welcome to the Eliza therapy session.  Start Session to begin."); //label
		jtf = new JTextField(25); //text field
		jta = new JTextArea(15,40); //text area
		jta.setEditable(false); //text area non editable
		jsp = new JScrollPane(jta); //add scroll in text area
		
		jbtn.addActionListener(this); //adding listeners to buttons
		jbtn2.addActionListener(this);
		jbtn3.addActionListener(this);
		jbtn4.addActionListener(this);
		jbtn5.addActionListener(this);
		jbtn6.addActionListener(this);
		
		setLayout(new GridBagLayout()); //layout of page will be coordinates x and y using gridbaglayout
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		add(jlbl,c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		add(jbtn,c);
	}

	public void startSession() {
		remove(jbtn); //remove button "start session"
		counter = 0;
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		add(jbtn5,c); //add button "next question"
		
		nextQuestion();
	}

	public void nextQuestion(){
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		add(jtf,c); //add text field
		
		jtaAppend();
		
		questionNumber ++;
		
		if(questionNumber == 1) {
			jlbl.setText("Session#" + session + " Q1: Which three words describe you best?");
		}
		else if(questionNumber == 2) {
			jlbl.setText("Session#" + session + " Q2: Which is your best feature?");
		}
		else if(questionNumber == 3) {
			jlbl.setText("Session#" + session + " Q3: Which common saying or phrase describes you?");
		}
		else if(questionNumber == 4) {
			jlbl.setText("Session#" + session + " Q4: What’s the best thing that’s happened to you this week?");
		}
		else if(questionNumber == 5) {
			jlbl.setText("Session#" + session + " Q5: Who was your role model when you were a child?");
		}
		else if(questionNumber == 6) {
			jlbl.setText("Session#" + session + " Q6: Who was your favorite teacher and why?");
		}
		else if(questionNumber == 7) {
			jlbl.setText("Session#" + session + " Q7: What was your favorite subject at school?");
		}
		else if(questionNumber == 8) {
			jlbl.setText("Session#" + session + " Q8: What did you want to be when you grew up?");
		}
		else if(questionNumber == 9) {
			jlbl.setText("Session#" + session + " Q9: If you could have one wish come true what would it be?");
		}
		else if(questionNumber == 10) {
			jlbl.setText("Session#" + session + " Q10: Which would you prefer — three wishes over five years or one wish right now?");
			endSession();
		}
	}

	public void endSession() {
		remove(jbtn5); //remove button "next question"
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		add(jbtn2,c); //add the 3 buttons
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		add(jbtn3,c);
		
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		add(jbtn4,c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		add(jbtn6,c); //add button "end session"
	}

	private void newSession() {
		jtaAppend();
		questionNumber = 0;
		jlbl.setText("Press 'Start Session' to begin Session #" + session + ".");
		remove(jbtn6); //remove button 'end session'
		remove(jtf); //remove text field if its on
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		add(jbtn,c);
	}

	public void jtaAppend() {
		if(questionNumber > 0) {
			question = jlbl.getText();
			userInput = jtf.getText();
			jta.append(question + "\n \t Answer:" + userInput + "\n\n");
		}
	}

	public void jtaOpen() {
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 5;
		add(jsp,c);
	}

	public void Analysis() {
		wordsInSentence = userInput.split(" ");
		longestString = "";
		shortestString = "aaaaaaaaaaaaaaaaa";
		
		for(int i = 0; i < wordsInSentence.length; i++) { //record longest word
			if(wordsInSentence[i].length() >= longestString.length()) {
				longestString = wordsInSentence[i];
			}
		}

		for(int i = 0; i < wordsInSentence.length; i++) { //record shortest word
			if(wordsInSentence[i].length() <= shortestString.length()) {
				shortestString = wordsInSentence[i];
			}
		}

		longestWordsArr[counter] = longestString;
		shortestWordsArr[counter] = shortestString;
		counter ++;
	}

	public void printAnalysis() {
		longestString = "";
		shortestString = "aaaaaaaaaaaaaaaaa";
		
		for(int i = 0; i < longestWordsArr.length;i++) {
			if(longestWordsArr[i].length() >= longestString.length()) {
				longestString = longestWordsArr[i];
			}
		}

		for(int i = 0; i < shortestWordsArr.length;i++) {
			if(shortestWordsArr[i].length() <= shortestString.length()) {
				shortestString = shortestWordsArr[i];
			}
		}

		jta.append("Analysis for Session#" + (session - 1) + ": Wow, " + longestString + " seems really important to " + shortestString + ".\n\n");
	}

	public void printLongestWords() {
		for(int i = 0; i < longestWordsArr.length; i++) {
			i++;
			jta.append("Longest word from Question#" + i + ": ");
			i--;
			jta.append(longestWordsArr[i] + "\n");
		}
		jta.append("\n");
	}

	public void sortLongestWords() {
		for(int i = 0; i < longestWordsArr.length; i++) {
			sortedLongestWords[i] = longestWordsArr[i];
		}
		Arrays.sort(sortedLongestWords);
		jta.append("Longest words alphabetically:\n");
		for(int i = 0; i < longestWordsArr.length; i++) {
			jta.append(sortedLongestWords[i] + "\n");
		}
		jta.append("\n");
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn) {
			startSession();
		}
		
		if(e.getSource()==jbtn5) {
			nextQuestion();
			Analysis();
		}

		if(e.getSource()==jbtn6) {
			session ++;
			newSession();
			Analysis();
			printAnalysis();
		}
		
		if(e.getSource()==jbtn2) {
			jtaOpen();
		}
		
		if(e.getSource()==jbtn3) {
			printLongestWords();
		}
		
		if(e.getSource()==jbtn4) {
			sortLongestWords();
		}
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(
		new Runnable(){
			public void run() {
				GUI start = new GUI();
			}
		});
	}
}
