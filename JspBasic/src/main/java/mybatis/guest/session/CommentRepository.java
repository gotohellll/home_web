package mybatis.guest.session;

import java.io.*;
import java.util.*;

import mybatis.guest.model.Comment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class CommentRepository 
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() { //객체를 만들어주는 공장 역할 : Factory 
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	/* 중요 ***
	 *  JDBC 	: Connection
	 *  Mybatis : SqlSession
	 */
	public List<Comment> selectComment(){
		//이미 연결된 연결객체를 얻어오기
		SqlSession sess = getSqlSessionFactory().openSession(); //이미 열결된 커넥션을 열기만 함 
		
		try {
			//CommentMapper의 selectComment를 실행(sql문장)해 result에 저장
			List<Comment> result = sess.selectList("CommentMapper.selectComment");
			
			return result;
		}finally{
			sess.close(); //연결객체를 반납 (닫기x) 
			
		}
	}
	/*
	 * SqlSession을 통해 mapper를 찾는데
	 * 
	 * 		- selectList 	:전체검색
	 * 		- selectOne 	:PK검색
	 * 		- insert 
	 * 		- update
	 * 		- delete
	 */
	
	/*********
	 * 	JDBC 	: 기본값이 auto commit 
	 * 	Mybatis : auto commit 아님 
	 */
	public void insertComment(Comment c) {
		SqlSession sess = getSqlSessionFactory().openSession(); 
		try {
			int result = sess.insert("CommentMapper.insertComment", c); //, c => parameter 넘겨주기 ***
			if( result == 1) sess.commit();
		}finally {
			sess.close();
		}
	}
	
	public Comment selectCommentByPK(long commentNo) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			//범용적으로 사용하기 위해 HashMap 입력
			HashMap map = new HashMap();
			map.put("commentNo", commentNo);
			
			Comment result = sess.selectOne("CommentMapper.selectComment",map);
			return result;
		}finally {
			sess.close();
		}
	}
	
	public void deleteComment(long commentNo) {
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			sess.delete("CommentMapper.deleteComment", commentNo);
			sess.commit();
		}finally {
			sess.close();
		}
	}
	
	  public void modifyComment(Comment c) { 
		  SqlSession sess = getSqlSessionFactory().openSession(); 
		  try { 
			  sess.update("CommentMapper.modifyComment", c);
			  sess.commit();
		  }finally { 
			  sess.close(); 
		  } 
	}
	 
}
