package pn_plate_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class New_Model_Bill_Dao {
    
    New_Bill_ModelController bill = new New_Bill_ModelController();

    // ==================================================
    // LOAD TABLE DATA BY BILL ID
    // ==================================================
    public ObservableList<New_model_table_1_pojo> table_views(int billId) throws Exception {

        ObservableList<New_model_table_1_pojo> list = FXCollections.observableArrayList();

        Class.forName(PN_Dao_Paroperty.driver);

        try (Connection con = DriverManager.getConnection(
                PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
                PN_Dao_Paroperty.user,
                PN_Dao_Paroperty.pass);

             PreparedStatement ps = con.prepareStatement(
                     "SELECT serial_number, product_name, product_model, product_size, " +
                     "qut, discount, price, amount " +
                     "FROM rr_table WHERE bill_id = ? ORDER BY serial_number")) {

            ps.setInt(1, billId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    New_model_table_1_pojo pojo =
                            new New_model_table_1_pojo(
                                    rs.getInt("serial_number"),
                                    rs.getString("product_name"),
                                    rs.getString("product_model"),
                                    rs.getString("product_size"),
                                    rs.getInt("qut"),
                                    rs.getDouble("discount"),
                                    rs.getDouble("price"),
                                    rs.getDouble("amount")
                            );

                    list.add(pojo);
                }
            }
        }

        return list;
    }
    
}
