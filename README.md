🧠 BrainSpark — Java Swing Quiz Application
BrainSpark is a desktop-based quiz management and assessment system developed using Java Swing and JDBC.
The application allows users to attempt quizzes, manage questions, review answers, and interact with a MySQL database through an intuitive graphical interface.
This project demonstrates practical implementation of:
•	Object-Oriented Programming (OOP)
•	Event-Driven Programming
•	GUI Development using Swing
•	Database Connectivity using JDBC
•	Modular Java Application Design
________________________________________
✨ Features
🎯 Quiz Module
•	Topic-based quiz selection
•	Multiple-choice questions
•	Timer-based question system
•	Automatic question switching on timeout
•	Answer tracking and evaluation
________________________________________
📊 Review Module
•	Detailed answer review screen displaying:
o	Question
o	User Answer
o	Correct Answer
o	Correct / Wrong status
•	Scrollable formatted review panel
________________________________________
🛠 Question Management
•	View questions using JTable
•	Topic filtering via JComboBox
•	Delete selected questions
•	Dynamic refresh of question list
•	Database-driven table loading
________________________________________
🎨 UI Enhancements
•	Custom button styling utility
•	Hover effects using MouseAdapter
•	Clean Swing layouts
•	Scrollable panels and tables
________________________________________
🧰 Technologies Used
Technology	Purpose
Java	Core Programming
Swing	GUI Development
AWT	Event Handling & Graphics
JDBC	Database Connectivity
MySQL	Database
OOP	Application Architecture
________________________________________
🏗️ Application Architecture
User Interaction
        ↓
Swing GUI (JFrame, JTable, Buttons)
        ↓
Event Listeners
(ActionListener / ItemListener / MouseListener)
        ↓
Application Logic
        ↓
JDBC Layer
        ↓
MySQL Database
________________________________________
📁 Project Structure
BrainSpark/
│
├── lib/
│   └── mysql-connector-j.jar
│
├── src/
│   ├── MainMenu.java
│   ├── QuizUI.java
│   ├── ReviewUI.java
│   ├── ManageQuestionsUI.java
│   ├── Question.java
│   ├── ButtonStyleUtil.java
│   └── DBConnection.java
│
├── database.sql
└── README.md
________________________________________
⚙️ Setup Instructions
1️⃣ Clone Repository
git clone https://github.com/muhd-sinan-m/BrainSpark.git
cd BrainSpark
________________________________________
2️⃣ Setup Database
Create database:
CREATE DATABASE mcq_quiz_system;
USE mcq_quiz_system;
Import SQL file:
SOURCE database.sql;
________________________________________
📦 Requirements
•	Java JDK 17+
•	MySQL Server
•	MySQL Connector/J (JDBC Driver)
JDBC driver included at:
lib/mysql-connector-j.jar
________________________________________
🛠 Compile the Project
✅ Windows
javac -cp "lib/mysql-connector-j.jar;src" src/*.java
✅ Linux / macOS
javac -cp "lib/mysql-connector-j.jar:src" src/*.java
________________________________________
▶️ Run the Application
Windows
java -cp "lib/mysql-connector-j.jar;src" MainMenu
Linux / macOS
java -cp "lib/mysql-connector-j.jar:src" MainMenu
________________________________________
⚠️ Important Notes
•	MySQL server must be running
•	JDBC driver must be included in classpath
•	Update database credentials in:
src/DBConnection.java
Example:
String password = "YOUR_PASSWORD";
________________________________________
🧠 Why JDBC Driver is Needed?
Java Application
        ↓
JDBC Driver (mysql-connector-j.jar)
        ↓
MySQL Database
The JDBC driver acts as a bridge allowing Java to communicate with MySQL.
________________________________________
🎧 Event Listeners Used
Listener	Usage
ActionListener	Button clicks & Timer events
ItemListener	Topic selection (JComboBox)
MouseListener (MouseAdapter)	Button hover styling
________________________________________
⏱ Timer Logic
•	Swing Timer runs every 1 second
•	Countdown displayed on UI
•	Marks unanswered questions automatically
•	Moves to next question
•	Ends quiz after last question
________________________________________
🧩 Key Classes
🔹 Question
Stores question data, options, and user answers.
🔹 QuizUI
Controls quiz flow and timer functionality.
🔹 ManageQuestionsUI
Admin interface to manage database questions.
🔹 ReviewUI
Displays formatted answer review.
🔹 ButtonStyleUtil
Reusable button styling utility using AbstractButton.
🔹 DBConnection
Handles MySQL database connection.
________________________________________
🎓 Concepts Demonstrated
•	Java Swing GUI
•	Event Delegation Model
•	Interfaces & Adapters
•	JTable + DefaultTableModel
•	JDBC PreparedStatement
•	Timer Events
•	Modular Utility Classes
________________________________________
👨‍💻 Authors
•	Muhammed Sinan M
•	Daniel George VM
________________________________________
📜 License
This project is created for educational and learning purposes.
________________________________________
⭐ Future Improvements
•	User login system
•	Edit question feature
•	Score analytics dashboard
•	Dark mode UI
•	Export results to PDF
________________________________________

