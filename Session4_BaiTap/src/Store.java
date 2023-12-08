import java.util.Arrays;

public class Store {
    private Product [] products;
    private int defaultElement = 10;
    private  int index =0;

    public Store(){
        products = new Product[defaultElement];
    }
    public boolean add(Product p){
        // Bổ sung điều kiện không add các sp trùng id
        if(findId(p.getId())==null){
            if(index == defaultElement)
                products = Arrays.copyOf(products, products.length + defaultElement);
            this.products[index++] = p;
            return true;
        }
        return false;
    }
    public  void sortProductList(){
        Arrays.sort(products, (a,b) -> {
            if(a!=null && b!=null){
                return a.getName().compareTo(b.getName());
            }
            return 0;
        });
    }
    public Product findId(String id){
        if(index !=0){
            for (int i = 0; i < this.index; i++) {
                if(this.products[i].getId()== id){
                    return this.products[i];
                }
            }
        }
        return null;
    }
    public int size(){
        return index;
    }
    //xóa
    public boolean remove(int index){
        if(index<0 || index >= this.index){
            return false;
        }else {
            Product[] newProduct = new Product[this.index-1];
            for ( int j = 0 ,k =0; j < this.index; j++) {
                if (j == (index -1)) {
                    continue;
                }
                newProduct[k++] = products[j];
            }
            this.index--;
            products = newProduct;
            return true;
        }
    }
    public void show(){
        for (int i = 0; i < index; i++) {
            System.out.print("\nSản phẩm thứ "+(i+1)+": " + this.products[i].getName());
        }
    }
}
