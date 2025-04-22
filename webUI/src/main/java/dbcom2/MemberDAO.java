package dbcom2;

import java.sql.*;

public class MemberDAO {

	String driver 	= "oracle.jdbc.driver.OracleDriver";
	String url 		= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user 	= "scott";
	String pass 	= "tiger";
	
	public MemberDAO() throws Exception {	
		
		// 1. 드라이버를 메모리 로딩
		Class.forName(driver);
	}
		public void insert(MemberVO vo) throws Exception {

			Connection con = null;
			PreparedStatement ps = null;
		
			try {
				// 2. 연결객체 얻어오기
				con = DriverManager.getConnection(url, user, pass);
				
				// 3. sql 문장
				String sql = "INSERT INTO USERS "
						+ " values(USERS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";

				// 4. 전송 객체
				ps = con.prepareStatement(sql);
				ps.setString(1, vo.getUserid());
				ps.setString(2, vo.getPassword());
				ps.setString(3, vo.getName());
				ps.setString(4, vo.getEmail());
				ps.setString(5, vo.getAddress());
				ps.setString(6, vo.getBirth());
				ps.setString(7, vo.getGender());
				ps.setString(8, vo.getComments());

				// 5. 전송
				int result = ps.executeUpdate();
				
				System.out.println(result + "행이 추가 되었습니다.");


			} catch (Exception ex) {
				System.out.println("실패:" + ex.getMessage());
				ex.printStackTrace();

			} finally {
				try {
					if (ps != null)
						ps.close();
					if (con != null)
						con.close();
					// Connection 객체를 닫는다. 사용된 리소스같은것들을 colse메소드가 해제해줌
				} catch (Exception e) {
					System.out.println("con.close() 에러");
				}
			}	
		
	}

}
