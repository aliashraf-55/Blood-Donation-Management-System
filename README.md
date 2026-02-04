# Blood Donation Management System

A Java Swing-based desktop application for managing blood donation records and requests.

## Project Overview

This is a comprehensive blood donation management system developed as part of CSE215L course project. The system allows users to:
- Register as blood donors
- Search for available donors
- Request blood donations
- Manage donor information
- Track blood inventory
- Rate the service

## Team Members
- MD ALI ASHRAF
- FAIZUR RAHMAN ZUNAYED
- SHOAIB BIN HABIB

## Features

### Main Components:
1. **Welcome Screen** - Project introduction and team information
2. **User Authentication** - Login/Registration system
3. **Donor Management** - Add, update, delete donor records
4. **Blood Search** - Search donors by blood group
5. **Blood Request** - Submit blood donation requests
6. **Inventory Management** - Track blood stock levels
7. **Rating System** - User feedback and ratings

### Technical Features:
- Graphical User Interface (GUI) using Java Swing
- File-based data storage (text files)
- Date validation and processing
- Blood group compatibility checking
- User-friendly navigation between screens

## System Requirements

- **Java Version**: Java 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 512MB RAM

## How to Run

### Method 1: Using Command Line
1. Open terminal/command prompt in the project directory
2. Compile the source code:
   ```bash
   javac -source 8 -target 8 -d . src/*.java
   ```
3. Run the application:
   ```bash
   java Wellcome
   ```

### Method 2: Using IDE
1. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, NetBeans)
2. Set the source directory to `src/`
3. Run the `Wellcome.java` file as the main class

## Project Structure

```
CSE215PROJECT/
├── src/                    # Source code directory
│   ├── Wellcome.java      # Main entry point
│   ├── Reglog.java        # Login/Registration
│   ├── Register.java      # Donor registration
│   ├── AvailableDoner.java # Available donors display
│   ├── RequestForBlood.java # Blood request system
│   ├── SearchForBlood.java # Blood search functionality
│   ├── ShowInventory.java  # Blood inventory
│   ├── Doners.java        # Donor data model
│   ├── Person.java        # Base person class
│   └── ...                # Other Java files
├── *.jpg, *.jpeg          # Image resources
├── Information.text       # Donor data file
├── Rating.text           # Rating data file
├── Request.text          # Request data file
├── signupinfo.txt        # User registration data
└── README.md             # This file
```

## Data Files

The system uses text files for data storage:
- `Information.text` - Stores donor information
- `Rating.text` - Stores user ratings
- `Request.text` - Stores blood requests
- `signupinfo.txt` - Stores user account information

## Compilation Notes

Due to Java version compatibility:
- The project is compiled with Java 8 compatibility flags
- Use `javac -source 8 -target 8` for proper execution
- Image files must be in the project root directory at runtime

## Troubleshooting

### Common Issues:

1. **Java version mismatch**
   - Error: "UnsupportedClassVersionError"
   - Solution: Use Java 8 compatible compilation flags

2. **Image loading errors**
   - Error: "NullPointerException" when loading images
   - Solution: Ensure image files are in the project root directory

3. **File not found exceptions**
   - Error: Data files not found
   - Solution: Run the application from the project root directory

## Development Environment

This project was developed using:
- Java SE 8
- Java Swing for GUI
- IntelliJ IDEA/Eclipse IDE
- Windows 10 development environment

## Course Information

- **Course**: CSE215L (Object Oriented Programming Language Lab)
- **Institution**: [Your University Name]
- **Semester**: 2nd Semester

## License

This project is for educational purposes only.