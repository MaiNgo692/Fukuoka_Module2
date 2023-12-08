public class Program {
    public static void main(String[] args) {
        Store st = new Store();
        Product p = new Product("sp01","Sp01",200000,10,0);
        Product p1 = new Product("sp02","Sp02",200000,10,0);
        Product p2 = new Product("sp03","Sp03",200000,10,0);
        st.add(p);
        st.add(p1);
        st.add(p2);
        st.sortProductList();
        st.show();
        Product findP = st.findId("sp02");
        System.out.println("\n-----------------------");
        System.out.println(findP.getName());
        System.out.println("Size: "+st.size());
        st.remove(2);
        st.show();
        System.out.println("Size: "+st.size());
    }
}
