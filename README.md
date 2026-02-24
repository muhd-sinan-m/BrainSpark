 🧠 BrainSpark — Java Swing Quiz Application

**BrainSpark** is a desktop-based quiz management and assessment system developed using **Java Swing** and **JDBC**.

The application allows users to attempt quizzes, manage questions, review answers, and interact with a **MySQL database** through an intuitive graphical interface.

This project demonstrates practical implementation of:

* Object-Oriented Programming (OOP)
* Event-Driven Programming
* GUI Development using Swing
* Database Connectivity using JDBC
* Modular Java Application Design

---

 ✨ Features

 🎯 Quiz Module

* Topic-based quiz selection
* Multiple-choice questions
* Timer-based question system
* Automatic question switching on timeout
* Answer tracking and evaluation

---

 📊 Review Module

* Detailed answer review screen displaying:

  * Question
  * User Answer
  * Correct Answer
  * Correct / Wrong status
* Scrollable formatted review panel

---

 🛠 Question Management

* View questions using `JTable`
* Topic filtering via `JComboBox`
* Delete selected questions
* Dynamic refresh of question list
* Database-driven table loading

---

 🎨 UI Enhancements

* Custom button styling utility
* Hover effects using `MouseAdapter`
* Clean Swing layouts
* Scrollable panels and tables

---

 🧰 Technologies Used

| Technology | Purpose                   |
| ---------- | ------------------------- |
| Java       | Core Programming          |
| Swing      | GUI Development           |
| AWT        | Event Handling & Graphics |
| JDBC       | Database Connectivity     |
| MySQL      | Database                  |
| OOP        | Application Architecture  |

---

 🏗️ Application Architecture

```
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
```

---

 📁 Project Structure

```
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
```

---

 ⚙️ Setup Instructions

 1️⃣ Clone Repository

```bash
git clone https://github.com/muhd-sinan-m/BrainSpark.git
cd BrainSpark
```

---

 2️⃣ Setup Database

Create database:

```sql
CREATE DATABASE mcq_quiz_system;
USE mcq_quiz_system;
```

Import SQL file:

```sql
SOURCE database.sql;
```

---

 📦 Requirements

* Java JDK **17+**
* MySQL Server
* MySQL Connector/J (JDBC Driver)

JDBC driver included at:

```
lib/mysql-connector-j.jar
```

---

 🛠 Compile the Project

 ✅ Windows

```bash
javac -cp "lib/mysql-connector-j.jar;src" src/*.java
```

 ✅ Linux / macOS

```bash
javac -cp "lib/mysql-connector-j.jar:src" src/*.java
```

---

 ▶️ Run the Application

 Windows

```bash
java -cp "lib/mysql-connector-j.jar;src" MainMenu
```

 Linux / macOS

```bash
java -cp "lib/mysql-connector-j.jar:src" MainMenu
```

---

 ⚠️ Important Notes

* MySQL server must be running
* JDBC driver must be included in classpath
* Update database credentials in:

```
src/DBConnection.java
```

Example:

```java
String password = "YOUR_PASSWORD";
```

---

 🧠 Why JDBC Driver is Needed?

```
Java Application
        ↓
JDBC Driver (mysql-connector-j.jar)
        ↓
MySQL Database
```

The JDBC driver acts as a bridge allowing Java to communicate with MySQL.

---

 🎧 Event Listeners Used

| Listener                     | Usage                         |
| ---------------------------- | ----------------------------- |
| ActionListener               | Button clicks & Timer events  |
| ItemListener                 | Topic selection (`JComboBox`) |
| MouseListener (MouseAdapter) | Button hover styling          |

---

 ⏱ Timer Logic

* Swing Timer runs every **1 second**
* Countdown displayed on UI
* Marks unanswered questions automatically
* Moves to next question
* Ends quiz after last question

---

## 🧩 Key Classes

🔹 Question

Stores question data, options, and user answers.

🔹 QuizUI

Controls quiz flow and timer functionality.

 🔹 ManageQuestionsUI

Admin interface to manage database questions.

 🔹 ReviewUI

Displays formatted answer review.

 🔹 ButtonStyleUtil

Reusable button styling utility using `AbstractButton`.

 🔹 DBConnection

Handles MySQL database connection.

---

🎓 Concepts Demonstrated

* Java Swing GUI
* Event Delegation Model
* Interfaces & Adapters
* `JTable` + `DefaultTableModel`
* JDBC `PreparedStatement`
* Timer Events
* Modular Utility Classes

---

 👨‍💻 Authors

* **Muhammed Sinan M**
* **Daniel George VM**

---

 📜 License

This project is created for **educational and learning purposes**.

---

⭐ Future Improvements

* User login system
* Edit question feature
* Score analytics dashboard
* Dark mode UI
* Export results to PDF

---

