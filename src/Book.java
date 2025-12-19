public class Book {
    private int id;
    private static int idGen=1;
    private String title;
    private String author;
    private int year;
    private boolean available;
    public Book() {
        id = idGen++;
        available = true;
    }
    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }
    public void setTitle(String title) {
        if(title==null) throw new IllegalArgumentException();
        this.title = title;
    }
    public void setAuthor(String author) {
        if(author==null) throw new IllegalArgumentException();
        this.author = author;
    }
    public void setYear(int year) {
        if(year > 2025 || year < 1500) throw new IllegalArgumentException();
        this.year = year;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public void markAsBorrowed() {
        available = false;
    }
    public void markAsReturned() {
        available = true;
    }
    public boolean isAvailable() {
        return available;
    }
    @Override
    public String toString() {
        return " Book [" + id + "] [title = " + title + ", author = " + author + ", year = " + year + "]";
    }
}
