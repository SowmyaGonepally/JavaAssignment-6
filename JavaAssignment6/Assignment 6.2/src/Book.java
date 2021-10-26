public class Book {
    int height;
    int width;
    public Book()
    {
        this(2,4);
        System.out.println("Inside constructor");
    }
    public Book(int height,int width)
    {
        this.height=height;
        this.width=width;
        System.out.println("Inside parameterized constructor");
    }
}
