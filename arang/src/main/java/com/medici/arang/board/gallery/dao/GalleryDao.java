package com.medici.arang.board.gallery.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.domain.GalleryRowMapper;
import com.medici.arang.user.command.GalleristCommend;
import com.medici.arang.user.domain.GalleristRowMapper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Repository
public class GalleryDao {
	private JdbcTemplate jdbcTemplate;
	
	public GalleryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//갤러리스트가 신규 갤러리 글 추가
	public long insertGallery(GalleryCommand galleryCommand) {
		String sql = "INSERT INTO Gallery (galleristEmail, galleryName_kor, galleryName_eng, "
				+ " address, galleryEmail, galleryPhone, since, area, "
				+ " openClose, representer, representerNum, galleryImgPath) "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		return jdbcTemplate.update(sql,galleryCommand.getGalleristEmail() ,galleryCommand.getGalleryName_kor(),
				galleryCommand.getGalleryName_eng(), galleryCommand.getAddress(), 
				galleryCommand.getGalleryEmail(), galleryCommand.getGalleryPhone(), 
				galleryCommand.getSince(), galleryCommand.getArea(), 
				galleryCommand.getOpenClose(), galleryCommand.getRepresenter(), 
				galleryCommand.getRepresenterNum(), galleryCommand.getGalleryImgPath());
	}
	
	//등록된 갤러리 수정
	public long updateGallery(GalleryCommand galleryCommand, long code) {
		String sql = " UPDATE Gallery SET galleryName_kor = ?, galleryName_eng = ?, "
				+ " address = ?, galleryEmail = ?, galleryPhone = ?, since = ?, area = ?, "
				+ " openClose = ?, representer = ?, representerNum = ?, galleryImgPath = ? "
				+ " WHERE code = ?";
		return jdbcTemplate.update(sql ,galleryCommand.getGalleryName_kor(),
				galleryCommand.getGalleryName_eng(), galleryCommand.getAddress(), 
				galleryCommand.getGalleryEmail(), galleryCommand.getGalleryPhone(), 
				galleryCommand.getSince(), galleryCommand.getArea(), 
				galleryCommand.getOpenClose(), galleryCommand.getRepresenter(), 
				galleryCommand.getRepresenterNum(), galleryCommand.getGalleryImgPath(), code);
	}
	
	//등록된 갤러리 삭제
	public long deleteGallery(long code) {
		String sql = "DELETE FROM Gallery WHERE code = ? ";
		return jdbcTemplate.update(sql, code);
	}
	
	public GalleryCommand findAllGalleryByRepresenterNum(String num){
		String sql = "SELECT * FROM Gallery WHERE representerNum = ?";
		return jdbcTemplate.queryForObject(sql, new GalleryRowMapper(), num);
	}
	
	public long getGalleryCount() {
		String sql = "SELECT count(*) FROM Gallery";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	
	//모든 등록 갤러리찾기
	public List<GalleryCommand> findAllGalleryInfo(){
		String sql = "SELECT * FROM Gallery";
		return jdbcTemplate.query(sql, new GalleryRowMapper());
	}
	public GalleristCommend GalleristbyEmail(String email){
		String sql = "select * from Gallerist where email = ?";
		return jdbcTemplate.queryForObject(sql, new GalleristRowMapper(), email);
	}
	
	public List<GalleryCommand> findImgPath(){
		String sql = "SELECT imgPath FROM Gallery";
		return jdbcTemplate.query(sql, new GalleryRowMapper());
	}
	
	//해당 코드의 갤러리 하나 찾기
	public List<GalleryCommand> findOneGallery(long code){
		String sql = "SELECT * FROM Gallery where code = ?";
		return jdbcTemplate.query(sql, new GalleryRowMapper(), code);
	}
	
}
