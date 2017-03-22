package Utils;

import java.sql.*;

/*
 * Created by aditya.mullela on 16/02/17.
 */
public class GetDataFromDBs {

    public String getData(String rawRequestId) {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

        // para - 10.85.46.237
        // pre prod - 10.85.40.234
    String url = "jdbc:mysql://10.85.40.234/raw_request_store";
    String user = "root_user";  //para , pre prod  -root_user
    String password = "root_pwd"; // para , pre prod - root_pwd
        String response = null;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        rs = st.executeQuery("SELECT response_body FROM raw_requests WHERE raw_request_id ="+rawRequestId);

        if (rs.next()) {//get first result
            response = rs.getString(1);
            System.out.println(response);//coloumn 1
        }

    } catch (SQLException ex) {

        ex.printStackTrace();

    } catch (ClassNotFoundException e) {

        e.printStackTrace();

    } finally {

        try {

            if (rs != null) {
                rs.close();

            }
            if (st != null) {
                st.close();

            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        return response;
}}

