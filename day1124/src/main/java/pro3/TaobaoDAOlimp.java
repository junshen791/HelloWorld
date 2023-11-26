package pro3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @date 2023/11/24 16:13
 */
public class TaobaoDAOlimp implements TaobaoDAO{
    @Override
    public List<String> list(String receive) {
        List<String> response = new ArrayList<>();
        String sql = "select response from reply where receive=?";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,receive);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               Taobao taobao = new Taobao();
                response.add( rs.getString("response")) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(response.get(response.size()-1));
        return response.isEmpty()?null:response;
    }

}
