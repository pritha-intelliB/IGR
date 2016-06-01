package com.igr.databaseOperation;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.feeStructureModel;
import com.igr.hibernate.model.partyTypeModel;
import com.igr.hibernate.model.provisionalTokenTypeModel;
import com.igr.hibernate.util.HibernateManager;
import com.igr.commonUtility.Datasource;

public class InsertOperation {

	private static final Logger log = Logger.getLogger(InsertOperation.class);
	HibernateManager manager = new HibernateManager();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public String insertFirstToken(String lang_code,String deed_type,String created_by,String applicant_name,String location) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String message = 0 + "Database Operation Failed.Contact IT.";
		String sequenceNo = "";
		provisionalTokenTypeModel TokenModel = new provisionalTokenTypeModel();
		int returnValue=0;
		try {

			con = Datasource.getDataSource();

			if (con != null) {
				con.setAutoCommit(false);
				Date currentDateValue = new Date();
				pstmt = con
						.prepareStatement(CommonSQL.GENERATE_ISSUE_FIRST_TOKEN_NO
								.toString());
				pstmt.setInt(1, Integer.parseInt(location));
				pstmt.setString(2,sdf.format(currentDateValue));

				rs = pstmt.executeQuery();
				if (rs.next()) {
					sequenceNo = rs.getString("create_dsr_token");
				}
				pstmt.close();
				TokenModel.setToken_no("P-"+sequenceNo);
				TokenModel.setLang_code(Integer.parseInt(lang_code));
				TokenModel.setDeed_type(deed_type);
				TokenModel.setCreated_by(Integer.parseInt(created_by));
				TokenModel.setCreated_datetime(currentDateValue);
				TokenModel.setApplicant_name(applicant_name);
				returnValue=manager.addFirstToken(TokenModel);
				
				
				if(returnValue==1){
					message = 1 + "Data Saved Successfully";
					con.commit();
				}
					else {
						message = 0 + "Database Operation Failed.Contact IT.";
						con.rollback();
					}	
				}

				else {
					message = 0 + "Database Operation Failed.Contact IT.";
				}

			

		} catch (Exception e) {
			e.printStackTrace();
			message = 0 + "Database Operation Failed.Contact IT.";
			try {
				con.rollback();
			} catch (SQLException e1) {
				log.fatal("Exception---", e);
			}
			message = 0 + e.getMessage();
			log.fatal(e.getStackTrace());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					Datasource.closeConnection(con);
				}
			} catch (Exception e) {
				message = 0 + e.getMessage();
				log.fatal("Exception---", e);
			}

		}

		return message;

	}
	
	
	
	
	
	
	public String insertDeedType(deedTypeModel deedType,List<partyTypeModel> model) {

		
		String message = 0 + "Database Operation Failed.Contact IT.";
		int returnValue=0;
		try {
				returnValue=manager.insertDeedTypeFeeStructure(deedType,model);
				
				if(returnValue==1){
					message = 1 + "Data Saved Successfully";
				}
					else {
						message = 0 + "Database Operation Failed.Contact IT.";
					}	
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			message = 0 + "Database Operation Failed.Contact IT.";
			
		}

		return message;

	}
	
	

	public String insertDeedCategory(deedCategoryModel deedCategory) {

		
		String message = 0 + "Database Operation Failed.Contact IT.";
		int returnValue=0;
		try {
				returnValue=manager.insertDeedCategory(deedCategory);
				
				if(returnValue==1){
					message = 1 + "Data Saved Successfully";
				}
					else {
						message = 0 + "Database Operation Failed.Contact IT.";
					}	
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			message = 0 + "Database Operation Failed.Contact IT.";
			
		}

		return message;

	}
	
	
public String insertFeeMaster(feeStructureModel feeMaster) {

		
		String message = 0 + "Database Operation Failed.Contact IT.";
		int returnValue=0;
		try {
				returnValue=manager.insertFeeMaster(feeMaster);
				
				if(returnValue==1){
					message = 1 + "Data Saved Successfully";
				}
					else {
						message = 0 + "Database Operation Failed.Contact IT.";
					}	
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			message = 0 + "Database Operation Failed.Contact IT.";
			
		}

		return message;

	}
	
	
}
