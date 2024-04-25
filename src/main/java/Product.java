import java.util.Map;

public class Product {

        String name ;
        double   price ;
        public Product (String name,double price ){
            this.name =name ;
            this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public class Sepet {
        private Map<Product,Integer>items;

    }

}

