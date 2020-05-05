package liulin.mybatis.demo;

import com.liulin.mybatis.bean.Blog;
import org.junit.Test;

import java.io.IOException;
import java.sql.*;

/**
 * Create by DbL on 2020/5/4 0004
 */
public class JdbcTest {
    @Test
    public void testJdbc() throws IOException {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatisdemo", "mybatistest", "123456");
            // 执行查询
            stmt = conn.createStatement();
            String sql = "SELECT bid, name, author_id FROM blog where bid = 1";
            ResultSet rs = stmt.executeQuery(sql);
            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
