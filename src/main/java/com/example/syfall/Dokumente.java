package com.example.syfall;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dokumente")
public class Dokumente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@Lob
	private byte[] dokument;

	private String dokumentenTyp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	private String uploadVon;

	private String status;
	private String zugewiesen;

	private int gesehen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getUploadVon() {
		return uploadVon;
	}

	public void setUploadVon(String uploadVon) {
		this.uploadVon = uploadVon;
	}

	public int getGesehen() {
		return gesehen;
	}

	public void setGesehen(int gesehen) {
		this.gesehen = gesehen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getZugewiesen() {
		return zugewiesen;
	}

	public void setZugewiesen(String zugewiesen) {
		this.zugewiesen = zugewiesen;
	}

	public String getDokumentenTyp() {
		return dokumentenTyp;
	}

	public void setDokumentenTyp(String dokumentenTyp) {
		this.dokumentenTyp = dokumentenTyp;
	}

	public byte[] getDokument() {
		return dokument;
	}

	public void setDokument(byte[] dokument) {
		this.dokument = dokument;
	}

}
