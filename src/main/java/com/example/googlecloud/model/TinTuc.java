package com.example.googlecloud.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name ="tintuc")
public class TinTuc implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idloai")
	private LoaiTin loaitin;
	
	
	@Column(name = "tieude")
	private String tieuDe;
	
	@Column(name = "noidung")
	private String noiDung;
	
	@Column(name = "hinhanh")
	private String hinhAnh;

	public TinTuc() {
		super();
	}

	public TinTuc(int id, LoaiTin loaitin, String tieuDe, String noiDung, String hinhAnh) {
		super();
		this.id = id;
		this.loaitin = loaitin;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the loaitin
	 */
	public LoaiTin getLoaitin() {
		return loaitin;
	}

	/**
	 * @param loaitin the loaitin to set
	 */
	public void setLoaitin(LoaiTin loaitin) {
		this.loaitin = loaitin;
	}

	/**
	 * @return the tieuDe
	 */
	public String getTieuDe() {
		return tieuDe;
	}

	/**
	 * @param tieuDe the tieuDe to set
	 */
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	/**
	 * @return the noiDung
	 */
	public String getNoiDung() {
		return noiDung;
	}

	/**
	 * @param noiDung the noiDung to set
	 */
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	/**
	 * @return the hinhAnh
	 */
	public String getHinhAnh() {
		return hinhAnh;
	}

	/**
	 * @param hinhAnh the hinhAnh to set
	 */
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @return the mutipartFile
	 */
	
	
}
