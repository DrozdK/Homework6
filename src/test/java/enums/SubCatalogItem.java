package enums;

public enum SubCatalogItem {
    LAPTOPS_COMPUTERS_MONITORS("Ноутбуки, компьютеры, мониторы"),
    ACCESSORIES("Комплектующие"),
    DATA_STORAGE("Хранение данных"),
    NETWORK_EQUIPMENT("Сетевое оборудование");

    private final String item;

    SubCatalogItem(String item) {
        this.item = item;
    }

    public String getText() {
        return item;
    }
}
