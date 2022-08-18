package com.medici.arang.board.gallery.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medici.arang.board.gallery.command.GalleryCommand;
import com.medici.arang.board.gallery.domain.GalleryRowMapper;
import com.medici.arang.board.gallery.domain.GalleryVo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Repository
public class GalleryDao {
	private JdbcTemplate jdbcTemplate;
	
	public GalleryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public long insertGallery(GalleryVo galleryVo) {
		String sql = "INSERT INTO gallery (galleryName, galleristName, address, galleryEmail, "
				+" galleryPhone, area, payment, galleryFloor,corporateRegistrationNum) "
				+ " VALUES(?, ?, ?, ?,  ?, ?, ?, ?,  ?) ";
		return jdbcTemplate.update(sql, galleryVo.getGalleryName(), galleryVo.getGalleristName(), galleryVo.getAddress(),
				galleryVo.getGalleryEmail(), galleryVo.getGalleryPhone(), galleryVo.getArea(),
				galleryVo.getPayment(), galleryVo.getGalleryFloor(), galleryVo.getCorporateRegistrationNum());
	}
	
	public long updateGallery(GalleryVo galleryVo, long code) {
		String sql = " UPDATE gallery SET galleryName = ?, galleristName = ?, address = ?, galleryEmail = ?, "
				+ " galleryPhone = ?, area = ?, payment = ?, galleryFloor = ?, corporateRegistrationNum = ? "
				+ " WHERE code = ?";
		return jdbcTemplate.update(sql, galleryVo.getGalleryName(), galleryVo.getGalleristName(), galleryVo.getAddress(),
				galleryVo.getGalleryEmail(), galleryVo.getGalleryPhone(), galleryVo.getArea(),
				galleryVo.getPayment(), galleryVo.getGalleryFloor(), galleryVo.getCorporateRegistrationNum(), code);
	}
	
	public long deleteGallery(long code) {
		String sql = "DELETE FROM gallery WHERE code = ? ";
		return jdbcTemplate.update(sql, code);
	}
	
	public List<GalleryVo> findAllGalleryInfo(){
		String sql = "SELECT * FROM gallery";
		return jdbcTemplate.query(sql, new GalleryRowMapper());
	}
	public GalleryVo findOneGalleryInfo(long code){
		String sql = "SELECT * FROM gallery where code = ?";
		return jdbcTemplate.queryForObject(sql, new GalleryRowMapper(), code);
	}

	public long insertFileUpload(GalleryVo galleryVo) {
		String sql = "INSERT INTO gallery_item (imgPath) values(?)";
		return jdbcTemplate.update(sql, galleryVo.getImgPath());
	}
}
