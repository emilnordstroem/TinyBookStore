package domain.models.book.bookEntities;

import domain.models.book.BookType;

import java.time.Year;

public class Description {
    private final BookType type;
    private final String title;
    private final Year publicationsYear;
    private final String pages;

    public Description(BookType type, String title, Year publicationsYear, String pages) {
        this.type = type;
        this.title = title;
        this.publicationsYear = publicationsYear;
        this.pages = pages;
    }

    public BookType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public Year getPublicationsYear() {
        return publicationsYear;
    }

    public String getPages() {
        return pages;
    }
}
