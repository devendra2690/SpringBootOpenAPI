package io.reflectoring.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ARMAUser", schema = "dbo")
@Data
public class ARMAUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "loginName")
	private String loginName;

	@Column(name = "userNumber")
	private String userNumber;

	@Column(name = "fullName")
	private String fullName;

	@Column(name = "kulanzId")
	private Integer kulzanId;

	@Column(name = "maximumApprovalAmount")
	private BigDecimal maximumApprovalAmount;

	@Column(name = "maximumPaymentAmount")
	private BigDecimal maximumPaymentAmount;

	@Column(name = "verificatorLoginName")
	private String verificatorLoginName;

	@Column(name = "verificatorUserNumber")
	private String verificatorUserNumber;

	@Column(name = "archiveAcceptedOn")
	private Date archiveAcceptedOn;

	@Column(name = "archivingEnabled")
	private boolean archivingEnabled;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Groups> groups;

	public List<Groups> getGroups() {
		return groups;
	}

	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getVerificatorLoginName() {
		return verificatorLoginName;
	}

	public void setVerificatorLoginName(String verificatorLoginName) {
		this.verificatorLoginName = verificatorLoginName;
	}

	public String getVerificatorUserNumber() {
		return verificatorUserNumber;
	}

	public void setVerificatorUserNumber(String verificatorUserNumber) {
		this.verificatorUserNumber = verificatorUserNumber;
	}

	public Date getArchiveAcceptedOn() {
		return archiveAcceptedOn;
	}

	@Column(name = "archiveAcceptedOn")
	public void setArchiveAcceptedOn(Date archiveAcceptedOn) {
		this.archiveAcceptedOn = archiveAcceptedOn;
	}

	public Integer getKulzanId() {
		return kulzanId;
	}

	public void setKulzanId(Integer kulzanId) {
		this.kulzanId = kulzanId;
	}

	public BigDecimal getMaximumApprovalAmount() {
		return maximumApprovalAmount;
	}

	public void setMaximumApprovalAmount(BigDecimal maximumApprovalAmount) {
		this.maximumApprovalAmount = maximumApprovalAmount;
	}

	public BigDecimal getMaximumPaymentAmount() {
		return maximumPaymentAmount;
	}

	public void setMaximumPaymentAmount(BigDecimal maximumPaymentAmount) {
		this.maximumPaymentAmount = maximumPaymentAmount;
	}

	public boolean isArchivingEnabled() {
		return archivingEnabled;
	}

	public void setArchivingEnabled(boolean archivingEnabled) {
		this.archivingEnabled = archivingEnabled;
	}

}
