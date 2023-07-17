package imagebook.imageshop.web;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ImageForm {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String animal;
    private String lifeAge;
}
