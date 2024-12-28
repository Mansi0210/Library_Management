package Service;

import Model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    ArrayList<Book> booklist = new ArrayList<>();

    public boolean addBook(Book book){
        boolean isvalid = validate(book);
        if(isvalid){
            booklist.add(book);
            return true;
        }else{
            return false;
        }
    }

    public boolean validate(Book book){
        return true;
    }

    public boolean borrowBook(String isbn) throws Exception {
        boolean bookFound = false;
        for(int i=0; i< booklist.size();i++){
            Book b = booklist.get(i);
            if(b.getIsbn().equals(isbn)){
                b.setAvailable(false);
                booklist.set(i,b);
                bookFound = true;
                break;
            }
        }
        if(bookFound == false) {
            throw new Exception("Book Not Found");
        }
        return bookFound;
    }

    public boolean returnBook(String isbn){
        return false;
    }

    public List<Book> ViewAvailableBook(){
        return booklist.stream().filter(b -> b.isAvailable() == true).collect(Collectors.toList());
    }
}
