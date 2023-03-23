// Class that catches the new exception I am preventing the program to have
class InvalidLineFormatException extends Exception {
    public InvalidLineFormatException(String line, Throwable cause) {
        super("Invalid format in line: " + line, cause);
    }
}
