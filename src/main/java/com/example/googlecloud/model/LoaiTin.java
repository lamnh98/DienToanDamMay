package com.example.googlecloud.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loaitin")
public class LoaiTin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "tenloai", nullable = false)
	private String tenloai;

	
	public LoaiTin() {
		super();
	}


	public LoaiTin(int id, String tenloai) {
		super();
		this.id = id;
		this.tenloai = tenloai;
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
	 * @return the tenloai
	 */
	public String getTenloai() {
		return tenloai;
	}


	/**
	 * @param tenloai the tenloai to set
	 */
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	
	@OneToMany(mappedBy = "loaitin")
	private Collection<TinTuc> tintuc;


	/**
	 * @return the tintuc
	 */
	public Collection<TinTuc> getTintuc() {
		return tintuc;
	}


	/**
	 * @param tintuc the tintuc to set
	 */
	public void setTintuc(Collection<TinTuc> tintuc) {
		this.tintuc = tintuc;
	}
	 
	
	

}
