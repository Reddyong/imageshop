package imagebook.imageshop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
@Getter @Setter
public class Image extends Item{

    private String animal;
    private String lifeAge;
}
