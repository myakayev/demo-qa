import config.ConfigProvider;
import model.BookTableRow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.BooksStorePage;

import java.util.List;

public class BookStoreTest {
    private WebDriver browser;
    private BooksStorePage page;

    @BeforeEach
    public void setUp() {
        browser = ConfigProvider.getDriver();
        page = new BooksStorePage(browser);
        page.openPage();
    }
    @AfterEach
    public void tearDown(){
        browser.quit();
    }

    @Test
    public void getAllBookTest() {
        BookTableRow expectedBook = new BookTableRow();
        expectedBook.setTitle("Git Pocket Guide");
        expectedBook.setAuthor("Richard E. Silverman");
        expectedBook.setPublisher("O'Reilly Media");

        List<BookTableRow> books = page.getBooks();
        System.out.println(books);

        Assertions.assertTrue(books.contains(expectedBook)); // перевіряємо, що книжка, яку вказано в expectedBook є в нашому списку книжок
        Assertions.assertEquals(8, books.size()); // перевіряємо, що список книжок складається з 8-ми елементів
    }
}
