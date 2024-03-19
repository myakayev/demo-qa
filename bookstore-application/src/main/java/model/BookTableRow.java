package model;

import lombok.Data;
import org.openqa.selenium.support.FindBy;

@Data
public class BookTableRow { //@FindBy(xpath = "//*[contains(@id,'see-book')]")
    private String title;
    private String author;
    private String publisher;
}
