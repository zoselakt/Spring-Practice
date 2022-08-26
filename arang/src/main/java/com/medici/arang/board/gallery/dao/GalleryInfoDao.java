package com.medici.arang.board.gallery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.gallery.command.GalleryInfoCommand;
import com.medici.arang.board.gallery.command.GalleryPageCommand;
/**
 * 
 * @author Administrator
 * galleryCode는 galleryInfo에 있는 값
 * code는 gallery에 있는 값
 * 
 * galleryCommand에는 galleryCode가 없다 그래서 code로 써야한다. (조인 시 command사용)
 */
@Repository
public class GalleryInfoDao {
	private JdbcTemplate jdbcTemplate;
	
	public GalleryInfoDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long insertGalleryInfo(GalleryInfoCommand infoCommand) {
		String sql = "INSERT INTO GalleryInfo (galleryCode, description, "
				+ "infoImgPath) VALUES(?, ?, ?)";
		return jdbcTemplate.update(sql, infoCommand.getGalleryCode(), 
				infoCommand.getDescription(), infoCommand.getInfoImgPath());
	}
	
	public long deleteGalleryInfo(long galleryCode) {
		String sql = "DELETE FROM GalleryInfo where galleryCode = ?";
		return jdbcTemplate.update(sql, galleryCode);
	}
	
	// 갤러리 모두찾기
	public List<GalleryPageCommand> allFindGallery(){
		String sql = "SELECT a.code, a.galleristEmail, a.galleryName_kor, a.galleryName_eng,"
				+ " a.address, a.galleryEmail, a.galleryPhone, a.since, a.area,"
				+ " a.openClose, a.representer, a.representerNum, a.galleryImgPath, "
				+ " b.description, b.infoImgPath "
				+ " FROM GalleryInfo b LEFT JOIN Gallery a "
				+ " ON a.code = b.galleryCode";
		return jdbcTemplate.query(sql, new RowMapper<GalleryPageCommand>() {
			
			public GalleryPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				GalleryPageCommand artistInfo = new GalleryPageCommand(
						rs.getLong("code"), rs.getString("galleristEmail"), rs.getString("galleryName_kor"),
						rs.getString("galleryName_eng"), rs.getString("address"), rs.getString("galleryEmail"), 
						rs.getString("galleryPhone"), rs.getString("since"), rs.getString("area"), 
						rs.getString("openClose"), rs.getString("representer"), 
						rs.getString("representerNum"), rs.getString("galleryImgPath"), 
						rs.getString("description"), rs.getString("infoImgPath"));
				return artistInfo;
			}
		});
	} 
	
	// 갤리러 상세페이지
	public List<GalleryPageCommand> findGalleryByID(long code){
		String sql = "SELECT a.code, a.galleristEmail, a.galleryName_kor, a.galleryName_eng, "
				+ " a.address, a.galleryEmail, a.galleryPhone, a.since, a.area, "
				+ " a.openClose, a.representer, a.representerNum, a.galleryImgPath,"
				+ " b.description, b.infoImgPath "
				+ " FROM GalleryInfo b LEFT JOIN Gallery a "
				+ " ON a.code = b.galleryCode WHERE a.code = ?";
		return jdbcTemplate.query(sql, new RowMapper<GalleryPageCommand>() {
			
			public GalleryPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				GalleryPageCommand artistInfo = new GalleryPageCommand(
						rs.getLong("code"), rs.getString("galleristEmail"), rs.getString("galleryName_kor"),
						rs.getString("galleryName_eng"), rs.getString("address"), rs.getString("galleryEmail"), 
						rs.getString("galleryPhone"), rs.getString("since"), rs.getString("area"), 
						rs.getString("openClose"), rs.getString("representer"), 
						rs.getString("representerNum"), rs.getString("galleryImgPath"), 
						rs.getString("description"), rs.getString("infoImgPath"));
				return artistInfo;
			}
		}, code);
	}
	
	// 페이징 찾기
	public Page<GalleryPageCommand> allFindGalleryPage(Pageable pageable){
		Order order = pageable.getSort().isEmpty()
				? Order.by("code")
				: pageable.getSort().toList().get(0);
		String sql = "SELECT a.code, a.galleristEmail, a.galleryName_kor, a.galleryName_eng,"
				+ " a.address, a.galleryEmail, a.galleryPhone, a.since, a.area, "
				+ " a.openClose, a.representer, a.representerNum, a.galleryImgPath, "
				+ " b.description, b.infoImgPath "
				+ " FROM GalleryInfo b LEFT JOIN Gallery a "
				+ "ON a.code = b.galleryCode "
				+ " ORDER BY " + order.getProperty() + " " + order.getDirection().name()
				+ " LIMIT  " + pageable.getPageSize()
				+ " OFFSET " + pageable.getOffset();
		return new PageImpl<GalleryPageCommand> (
				jdbcTemplate.query(sql, new RowMapper<GalleryPageCommand>() {
			@Override
			public GalleryPageCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
				GalleryPageCommand artistInfo = new GalleryPageCommand(
						rs.getLong("code"), rs.getString("galleristEmail"), rs.getString("galleryName_kor"),
						rs.getString("galleryName_eng"), rs.getString("address"), rs.getString("galleryEmail"),
						rs.getString("galleryPhone"), rs.getString("since"), rs.getString("area"), 
						rs.getString("openClose"), rs.getString("representer"), 
						rs.getString("representerNum"), rs.getString("galleryImgPath"), 
						rs.getString("description"), rs.getString("infoImgPath"));
				return artistInfo;
			}
		}),
				pageable, getCount());
	}
	
	public long getCount() {
		String sql = "SELECT count(*) FROM Gallery";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}