package ma.gemadec.ecom.configuration;

import ma.gemadec.ecom.models.Product;
import ma.gemadec.ecom.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class ProductConfiguration {
    private final ProductService productService;

    public ProductConfiguration(ProductService productService) {
        this.productService = productService;
    }

    //@Bean
    CommandLineRunner initProduct(){
        return args -> {
            productService.create(new Product(
                    null,
                    null,
                    "canapé en velours bleu",
                    "Deco EXPRESS",
                    "https://cdn.conforama.fr/prod/product/image/2cc7/G_CNF_D21586846_B.jpeg",
                    "Assise profonde Accoudoirs capitonnés Velours doux au toucher Intemporelle, notre gamme Bjorn s’intégrera parfaitement chez vous. Sa conception maîtrisée rend sa construction solide par nature, ses pieds en bois massifs lui apportent un côté chaleureux. Il deviendra très vite un incontournable dans votre intérieur",
                    "france",
                    270000,
                    new Date()
                    ));
            Thread.sleep(2000); //je me base sur le timestamp pour travailler avec les produit, j'ai besoin donc d'obserserver un temps d'attente sinon certains produits auront le meme timestamp
            productService.create(new Product(
                    null,
                    null,
                    "salon coloré",
                    "Marie Claire Maison",
                    "https://cache.marieclaire.fr/data/photo/w1000_ci/65/salon-colore-design.jpg",
                    "Chic et cosy, ce salon n'est autre que celui de la décoratrice star Sarah Lavoine. Elle y mixe avec intelligence un canapé vert “Sarah” en tissu velours et un canapé jaune “Yasmine” en accompagnant le tout d'un grand mur repeint en bleu et d'une petit niche bibliothèque redécorée en vert.",
                    "france",
                    422000,
                    new Date()
            ));
            Thread.sleep(2000);

            productService.create(new Product(
                    null,
                    null,
                    "écran blue ray",
                    "AMAZON",
                    "https://s3-eu-west-1.amazonaws.com/lacablerie-web-prod/help/cest-quoi-un-indice-de-fluidite-tv/tv-4kuhd.jpg",
                    "Le Blu-ray permet, grâce à la finesse de son rayon de stocker 5 fois plus d'informations que sur un DVD et près de 40 fois plus que sur un CD. Il est donc le format idéal pour stocker un film en haute définition (1920 x 1080 pixels) et les bonus qui l'accompagnent.",
                    "usa",
                    287000,
                    new Date()
            ));
            Thread.sleep(2000);

            productService.create(new Product(
                    null,
                    null,
                    "meuble salon",
                    "Marie claire maison",
                    "https://cache.marieclaire.fr/data/photo/w1000_ci/6h/meuble-de-salon-pas-cher.jpg",
                    "Canapé et fauteuils pas chers, meuble salon complet pas cher, meuble de rangement salon pas cher, petit meuble de salon pas cher ou meuble de salon en bois pas cher, découvrez notre sélection à prix très doux. ",
                    "france",
                    362000,
                    new Date()
            ));
            Thread.sleep(2000);

            productService.create(new Product(
                    null,
                    null,
                    "Iphone 14 pro max",
                    "Apple",
                    "https://imageio.forbes.com/specials-images/imageserve/6321aca5df0a9fa9eee9950b/0x0.jpg",
                    "Cameras: Rear 48 megapixel wide, 12 megapixel ultra wide, 12 megapixel telephoto; front 12 megapixel | Processor: Apple A 16 Bionic | Display: 6.1-inch OLED, 120Hz display 2,556 x 1,179 pixels, 460 pixels per inch| Storage: 128GB (up to 1TB) | Battery: Up to 22 hours video playback | Dimensions: 5.8 x 2.8 x 0.3 inches | Weight: 7.3 ounces",
                    "Senegal,dakar",
                    500000,
                    new Date()
            ));
            Thread.sleep(2000);

            productService.create(new Product(
                    null,
                    null,
                    "Apple watch series 8",
                    "Apple",
                    "https://www.rollingstone.com/wp-content/uploads/2022/09/apple-watch-series-8-feature-image.jpg",
                    "The Apple Watch Series 8 has a pretty similar design to that of the Series 7, including an almost bezel-less display and larger screen compared to its predecessors. If you haven’t upgraded your Apple Watch in a few years, you’ll definitely notice the larger screen (now available in 41mm or 45m) and crisp always-on display. ",
                    "Senegal,dakar",
                    271000,
                    new Date()
            ));
        };
    }
}

