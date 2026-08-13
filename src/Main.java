import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

void main() throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<Product> list = new ArrayList<>();

    System.out.print("Enter the number of products: ");
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
        System.out.println();

        System.out.println("Product #" + i + " data:");

        System.out.print("Common, used or imported (c/u/i)? ");
        char type = sc.next().charAt(0);

        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();


        System.out.print("Price: ");
        double price = sc.nextDouble();

        if (type == 'i') {
            System.out.print("Custom fee: ");
            double customFee = sc.nextDouble();

            list.add(new ImportedProduct(name, price, customFee));
        } else if (type == 'u') {
            System.out.print("Manufacture date (DD/MM/YYYY): ");
            String dateString = sc.next();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date manufactureDate = sdf.parse(dateString);

            list.add(new UsedProduct(name, price, manufactureDate));
        } else {
            list.add(new Product(name, price));
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product product : list) {
            System.out.println(product.priceTag());
        }
    }
}