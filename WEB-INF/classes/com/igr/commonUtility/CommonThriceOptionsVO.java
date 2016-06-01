/**
 * Class Name  : OptionsVO
 * Description : Can Store the Options in a Drop down List
 * Created by  : TCS/Sabyasachi Bhattacharya
 * Created on  : 7-SEP-04
 * Modified    : [Who , When , What]
 */
package com.igr.commonUtility;

import java.io.Serializable;


public class CommonThriceOptionsVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeCode;
	private String typeDesc;
    private String typeCodeDesc;

	public CommonThriceOptionsVO(String code, String desc,String typeCodeDesc) {
		setTypeCode(code);
		setTypeDesc(desc);
		setTypeCodeDesc(typeCodeDesc);
	}

		/**
	 * @return
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @return
	 */
	public String getTypeDesc() {
		return typeDesc;
	}

	/**
	 * @param string
	 */
	public void setTypeCode(String string) {
		typeCode = string;
	}

	/**
	 * @param string
	 */
	public void setTypeDesc(String string) {
		typeDesc = string;
	}

	public String getTypeCodeDesc() {
		return typeCodeDesc;
	}

	public void setTypeCodeDesc(String typeCodeDesc) {
		this.typeCodeDesc = typeCodeDesc;
	}

	
	


}
