package pn_plate_projects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class Detials_printer_Dao {

   public ObservableList<Detials_printer_pojo> UsersDetials(List<Integer> billIds) throws Exception {

    ObservableList<Detials_printer_pojo> list = FXCollections.observableArrayList();

    if (billIds == null || billIds.isEmpty()) {
        return list;
    }

    String sql = "SELECT bill_id, total, paid_amount, balance_amount, date, time " +
                 "FROM bill_amounts " +
                 "WHERE bill_id = ANY (?)";

    try (Connection con = DriverManager.getConnection(
            PN_Dao_Paroperty.url + PN_Dao_Paroperty.db,
            PN_Dao_Paroperty.user,
            PN_Dao_Paroperty.pass);
         PreparedStatement ps = con.prepareStatement(sql)) {

        Array billArray = con.createArrayOf("integer", billIds.toArray());
        ps.setArray(1, billArray);

        try (ResultSet rs = ps.executeQuery()) {
            int count = 1;
            while (rs.next()) {

                Detials_printer_pojo p = new Detials_printer_pojo();
                p.setSerial(count++);
                p.setBillid(rs.getString("bill_id")); // or getInt if integer
                p.setTotalamount(rs.getDouble("total"));
                p.setPaidamount(rs.getDouble("paid_amount"));
                p.setBalancesamount(rs.getDouble("balance_amount"));
                p.setDate(rs.getString("date"));
                p.setTime(rs.getString("time"));

                list.add(p);
            }
        }
    }
    return list;
}
}