package page;

import model.BookTableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BooksStorePage extends AbstractPage {
    @FindBy(id = "searchBox")
    private WebElement searchInput;
    @FindBy(xpath = "//*[(contains(@class,'rt-tr-group')) and *[not(contains(@class, 'padRow'))]]")
    private List<WebElement> tableRow;
    public BooksStorePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        openPage(Path.BOOK_STORE_URI);
    }

    public void fillSearchInput(String searchText) {
        searchInput.sendKeys(searchText);
    }

    public List<BookTableRow> getBooks() {
        List<BookTableRow> bookTableRows = new ArrayList<>();
        for(WebElement row: tableRow) {
            BookTableRow bookTableRow = new BookTableRow();
        }

       return bookTableRows;
    }
}
