package imagebook.imageshop.web;

import imagebook.imageshop.domain.item.*;
import imagebook.imageshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "/books/new")
    public String createBookForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createBookForm";
    }

    @GetMapping(value = "/albums/new")
    public String createAlbumForm(Model model) {
        model.addAttribute("form", new AlbumForm());
        return "items/createAlbumForm";
    }

    @GetMapping(value = "/movies/new")
    public String createMovieForm(Model model) {
        model.addAttribute("form", new MovieForm());
        return "items/createMovieForm";
    }

    @GetMapping(value = "/images/new")
    public String createImageForm(Model model) {
        model.addAttribute("form", new ImageForm());
        return "items/createImageForm";
    }

    @PostMapping(value = "/books/new")
    public String createBook(BookForm form) {

        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }

    @PostMapping(value = "/albums/new")
    public String createAlbum(AlbumForm form) {

        Album album = new Album();
        album.setName(form.getName());
        album.setPrice(form.getPrice());
        album.setStockQuantity(form.getStockQuantity());
        album.setArtist(form.getArtist());
        album.setEtc(form.getEtc());

        itemService.saveItem(album);
        return "redirect:/items";
    }

    @PostMapping(value = "/movies/new")
    public String createMovie(MovieForm form) {

        Movie movie = new Movie();
        movie.setName(form.getName());
        movie.setPrice(form.getPrice());
        movie.setStockQuantity(form.getStockQuantity());
        movie.setDirector(form.getDirector());
        movie.setActor(form.getActor());

        itemService.saveItem(movie);
        return "redirect:/items";
    }

    @PostMapping(value = "/images/new")
    public String createImage(ImageForm form) {

        Image image = new Image();
        image.setName(form.getName());
        image.setPrice(form.getPrice());
        image.setStockQuantity(form.getStockQuantity());
        image.setAnimal(form.getAnimal());
        image.setLifeAge(form.getLifeAge());

        itemService.saveItem(image);
        return "redirect:/items";
    }

    @GetMapping(value = "/items")
    public String list(Model model) {

        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    /**
     * 상품 수정 폼
     */
    @GetMapping(value = "/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {

        Book item = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    /**
     * 상품 수정
     */
    @PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookForm form) {

        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }
}
