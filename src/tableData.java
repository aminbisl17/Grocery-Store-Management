import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class tableData {

   public int id, shitja;
   public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getShitja() {
    return shitja;
  }

  public void setShitja(int shitja) {
    this.shitja = shitja;
  }

  public float price;
   public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String product;

        public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

        public Object[][] data = {{0,0,0,0}};

        public String[] columns = {"ID", "Produkti", "Shitjet", "Qmimi"};

        DefaultTableModel model = new DefaultTableModel(data, columns);
        public  JTable table = new JTable(model);

        public void addRowOnTable(java.awt.event.ActionEvent e){
       model = (DefaultTableModel) table.getModel();
       model.addRow(new Object[]{getId(), getProduct(), getShitja(), getPrice()});
       System.out.println(getProduct());
          }

          tableData(){

          }
}
