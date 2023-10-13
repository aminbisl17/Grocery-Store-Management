import javax.swing.table.DefaultTableModel;

class tableData {

        public Object[][] data = {
        {1,"Fanta",14, 1.00f},
        {2, "Schweppess", 10, 0.70f},
        {3, "CocaCola", 4, 0.70f},
        {4, "dsjfjd", 2, 3.0f}};

     public String[] Column = {
            "Id",
            "Produkti",
            "Numri i shitjes",
            "Qmimi"};

      public  DefaultTableModel model = new DefaultTableModel(data, Column);
}
