/*
package ma.gemadec.ecom.configuration;

import ma.gemadec.ecom.models.Product;
import ma.gemadec.ecom.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class ProductConfiguration {
    private final ProductService productService;

    public ProductConfiguration(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    CommandLineRunner initProduct(){
        return args -> {
            productService.create(new Product(
                    System.currentTimeMillis(),
                    "canapé en velours bleu",
                    "Deco EXPRESS",
                    "https://cdn.conforama.fr/prod/product/image/2cc7/G_CNF_D21586846_B.jpeg",
                    "Assise profonde Accoudoirs capitonnés Velours doux au toucher Intemporelle, notre gamme Bjorn s’intégrera parfaitement chez vous. Sa conception maîtrisée rend sa construction solide par nature, ses pieds en bois massifs lui apportent un côté chaleureux. Il deviendra très vite un incontournable dans votre intérieur",
                    "france",
                    new Date()
                    ));

            productService.create(new Product(
                    System.currentTimeMillis(),
                    "salon coloré",
                    "Marie Claire Maison",
                    "https://cache.marieclaire.fr/data/photo/w1000_ci/65/salon-colore-design.jpg",
                    "Chic et cosy, ce salon n'est autre que celui de la décoratrice star Sarah Lavoine. Elle y mixe avec intelligence un canapé vert “Sarah” en tissu velours et un canapé jaune “Yasmine” en accompagnant le tout d'un grand mur repeint en bleu et d'une petit niche bibliothèque redécorée en vert.",
                    "france",
                    new Date()
            ));

            productService.create(new Product(
                    System.currentTimeMillis(),
                    "écran blue ray",
                    "AMAZON",
                    "https://s3-eu-west-1.amazonaws.com/lacablerie-web-prod/help/cest-quoi-un-indice-de-fluidite-tv/tv-4kuhd.jpg",
                    "Le Blu-ray permet, grâce à la finesse de son rayon de stocker 5 fois plus d'informations que sur un DVD et près de 40 fois plus que sur un CD. Il est donc le format idéal pour stocker un film en haute définition (1920 x 1080 pixels) et les bonus qui l'accompagnent.",
                    "usa",
                    new Date()
            ));

            productService.create(new Product(
                    System.currentTimeMillis(),
                    "meuble salon",
                    "Marie claire maison",
                    "https://cache.marieclaire.fr/data/photo/w1000_ci/6h/meuble-de-salon-pas-cher.jpg",
                    "Canapé et fauteuils pas chers, meuble salon complet pas cher, meuble de rangement salon pas cher, petit meuble de salon pas cher ou meuble de salon en bois pas cher, découvrez notre sélection à prix très doux. ",
                    "france",
                    new Date()
            ));
        };
    }
}
*/