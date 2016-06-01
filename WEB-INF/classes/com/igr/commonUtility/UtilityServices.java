package com.igr.commonUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

public class UtilityServices {

	private static final Logger log = Logger.getLogger(UtilityServices.class);
	
	private static final String USERSql = "SELECT EVENTCODE,USERGROUP FROM GROUPEVENTMAP ORDER BY EVENTCODE";
	private static final String TOKENTYPESql = "SELECT deed_type_id TOKENID, deed_name DEEDTYPE,lang_id LANGUAGECODE FROM deed_type ORDER BY lang_id asc,deed_type_id";
	
	
	
	

	public List<CommonOptionsVO> getUserLOV() {
	
		List<CommonOptionsVO> lovMap = new ArrayList<CommonOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(USERSql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonOptionsVO(rs.getString("USERGROUP"),
						rs.getString("EVENTCODE"));
				lovMap.add(optionsVO);
				}

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal("Cannot load key ", e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting User " , e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting User  LOV",
							e);
				}
		}
		log.fatal(" User LOV  populated as " + lovMap);
		return lovMap;
	}

	
	
	
	
	
	public List<CommonThriceOptionsVO> getTokenTypeLov() {
		log.fatal("Trying to load getTokenTypeLov....");
		List<CommonThriceOptionsVO> lovMap = new ArrayList<CommonThriceOptionsVO>();
		Connection con = null;
		ResultSet rs = null;
		CommonThriceOptionsVO optionsVO = null;
		try {
			con = Datasource.getDataSource();
			rs = con.prepareStatement(TOKENTYPESql).executeQuery();
			while (rs.next()) {
				optionsVO = new CommonThriceOptionsVO(rs.getString("LANGUAGECODE"),
						rs.getString("DEEDTYPE"),rs.getString("TOKENID"));
				lovMap.add(optionsVO);
			}
			
		} catch (Exception e) {
			log.fatal("Cannot load key " , e);
		}

		finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					log.fatal("Cannot close Resultset after getting getTokenTypeLov "
							, e);
				}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					log.fatal(
							"Cannot close connection after getting getTokenTypeLov  LOV",
							e);
				}
		}
		log.fatal("getTokenTypeLov populated as " + lovMap);
		return lovMap;
	}
	
}
