package domain.models.book.bookEntities;

import domain.models.book.BookType;
import domain.models.book.Genre;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Description {
    private final BookType type;
    private final String title;
    private final List<Genre> genres;
    private final Year publicationsYear;
    private final String pages;

    public Description(BookType type, String title, List<Genre> genres, Year publicationsYear, String pages) {
        this.type = type;
        this.title = title;
        this.genres = genres;
        this.publicationsYear = publicationsYear;
        this.pages = pages;
    }

    public BookType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public List<Genre> getGenres() {
        return new ArrayList<>(genres);
    }

    public Year getPublicationsYear() {
        return publicationsYear;
    }

    public String getPages() {
        return pages;
    }
}
