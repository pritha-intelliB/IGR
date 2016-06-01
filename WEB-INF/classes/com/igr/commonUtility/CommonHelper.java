package com.igr.commonUtility;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.log4j.Logger;
public class CommonHelper {
	private static final Logger log = Logger.getLogger(CommonHelper.class);


	public List<CommonOptionsVO> extractThriceData(String compareString,
			List<CommonThriceOptionsVO> itaratorList) {
		
		List<CommonOptionsVO> returnList = new ArrayList<CommonOptionsVO>();
		ListIterator<CommonThriceOptionsVO> listItr = itaratorList.listIterator();
		while (listItr.hasNext()) {
			CommonThriceOptionsVO optionVO = (CommonThriceOptionsVO) listItr.next();
			if (optionVO.getTypeCode().trim()
					.equalsIgnoreCase(compareString.trim())) {
				CommonOptionsVO commonVO1 = new CommonOptionsVO(optionVO.getTypeDesc(), optionVO.getTypeCodeDesc());
				returnList.add(commonVO1);
			}
		}
		return returnList;
	}
	
	
public String[] cheekUserValidity(String userName,String password,String language)
{
	
	
	Connection con = null;
	ResultSet rs = null;
	 String[] returnMap = new String[7];

	
	try{
	con = Datasource.getDataSource();
    String USERSql= "select a.user_id ,a.dsr_location ,a.user_type from user_info a where a.user_name='"+userName+ "' and a.user_password='"+password+"' and a.isactive=true";
	rs = con.prepareStatement(USERSql).executeQuery();
		if (rs.next()) {
			
			returnMap[0]=rs.getString("user_id");
			returnMap[1]=rs.getString("dsr_location");
			returnMap[2]=rs.getString("user_type");
			returnMap[3]=language;
			returnMap[4]=rs.getString("user_id");
			returnMap[5]="Test";
		
	}
		else{
			returnMap[0]="99999XXXXXX";
		}
		
		
		
	}catch(Exception e){
		
		e.printStackTrace();
		log.fatal("User can't validate due to database error ", e);
	}finally {

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				log.fatal("Cannot close Resultset after validate User " , e);
			}

		if (null != con)
			try {
				con.close();
			} catch (SQLException e) {
				log.fatal(
						"Cannot close connection after validate User ",
						e);
			}
	
	}
	
	
	
	return returnMap;
}
	

}
