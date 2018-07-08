package egovframework.let.camp.service;

import java.util.Date;

public class CampVO {

	private static final long serialVersionUID = 1L;

	// 일련번호
	private Integer no;
	
	// 야영장구분일련번호
	private Integer campTypeNo;
	
	// 야영장이름
	private String campName;
	
	// 도로명주소
	private String addressRoad;
	
	// 지번주소
	private String addressJibun;
	
	// 야영장 전화번호
	private String campTel;
	
	// 위도
	private Double latitude;
	
	// 경도
	private Double longitude;
	
	// 관리기관 전화번호
	private String manAgencyTel;
	
	// 관리기관명
	private String manAgencyName;
		
	// 등록자id
	private int registeredId;

	// 수정자id
	private int updatedId;
	
	// 등록일시
	private Date registeredAt;
	
	// 수정일시
	private Date updatedAt;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getCampTypeNo() {
		return campTypeNo;
	}

	public void setCampTypeNo(Integer campTypeNo) {
		this.campTypeNo = campTypeNo;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getAddressRoad() {
		return addressRoad;
	}

	public void setAddressRoad(String addressRoad) {
		this.addressRoad = addressRoad;
	}

	public String getAddressJibun() {
		return addressJibun;
	}

	public void setAddressJibun(String addressJibun) {
		this.addressJibun = addressJibun;
	}

	public String getCampTel() {
		return campTel;
	}

	public void setCampTel(String campTel) {
		this.campTel = campTel;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getManAgencyTel() {
		return manAgencyTel;
	}

	public void setManAgencyTel(String manAgencyTel) {
		this.manAgencyTel = manAgencyTel;
	}

	public String getManAgencyName() {
		return manAgencyName;
	}

	public void setManAgencyName(String manAgencyName) {
		this.manAgencyName = manAgencyName;
	}

	public int getRegisteredId() {
		return registeredId;
	}

	public void setRegisteredId(int registeredId) {
		this.registeredId = registeredId;
	}

	public int getUpdatedId() {
		return updatedId;
	}

	public void setUpdatedId(int updatedId) {
		this.updatedId = updatedId;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
}







