# 📚 Library Management App

## 📋 Overview
This library management app was developed as part of the Advanced Object-Oriented Programming course during the second semester of the second year at the Faculty of Mathematics and Computer Science, University of Bucharest.


## 💻 Key Features
### 📖 Book Management:

Add, remove, or edit book details.
Keep track of book formats (Hardcover, Paperback, Audiobook, Ebook) and statuses (Available, Borrowed, Lost).

### 👩‍💻 Account Management:

Register new accounts with a unique username and password.
Cancel membership for accounts.
Distinguish between members and librarians.

### 📑 Library Operations:

Check-out and return books seamlessly.
Monitor due dates for borrowed books.

### 🔎 Search Functionality:

Efficiently search for members and books.


## 🌐 Object Types

- Person
  - Manage basic personal information.
- Account
  - Extend Person with username, password, and account status.
- LibraryCard
  - Generate library cards with unique numbers and activation status.
- Member
  - Keep track of membership details, including the date of membership and total books checked out.
- Librarian:
  - Specialized account type for librarians.
- Review:
  - Capture book reviews, including ratings and optional reviewer information.
- Book:
  - Store comprehensive book details, including ISBN, title, publisher, genres, price, and more.
- BookCopy:
  - Extend Book with specific copy details like barcode, format, and status.
