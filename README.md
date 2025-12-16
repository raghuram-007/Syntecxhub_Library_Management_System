
# 📚 Library Management System

This is a **Java CLI-based Library Management System** developed for the **Syntecxhub Internship**.  

It allows users to **add, remove, search, and view books** in a library. The program uses **file handling** to store book data persistently and includes **input validation** and **error handling**.

---

## ✨ Features

- ➕ Add new books with unique Book ID, Title, and Author.  
- ❌ Remove books by Book ID.  
- 🔍 Search for books by Book ID or Title.  
- 📝 View all books in a neatly formatted table.  
- 💾 Persistent storage using `books.dat` file.  
- ⚠️ Handles invalid inputs gracefully.

---

## 🗂 Project Structure

```

Syntecxhub_LibraryManagementSystem/
│
├── Book.java                  # Book class (Serializable)
├── LibraryManagementSystem.java # Main program (CLI)
└── books.dat                  # Auto-generated storage file (binary)

````

---

## ▶️ How to Run

1. Open terminal/PowerShell and navigate to the project folder.  
2. Compile the program:

```bash
javac *.java
````

3. Run the program:

```bash
java LibraryManagementSystem
```

4. Follow the menu prompts in the console.

---

## 🖥 Sample Output

```
=== Library Management System ===
1. Add Book
2. Remove Book
3. Search Book
4. View All Books
5. Exit
Enter your choice: 4

--- All Books ---
| Book ID  | Title                               | Author              |
--------------------------------------------------------------------------
| B001     | Java Basics                         | Raghuram            |
| B005     | Web design basics                   | alan                |
| b003     | Backend Developer should must know...| Garfield roosum     |
--------------------------------------------------------------------------
```

---

## 👤 Author

**Raghu Ram**
Intern at Syntecxhub

---

## 📝 Notes

* This is a **console-based CLI application**, no GUI required.
* `books.dat` file is automatically created and managed by the program.
* Long titles/authors are truncated for table formatting.


