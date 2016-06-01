var typeRankMapping = {
	agentTypes : [
		{typeCode : "", typeName : "-Please Select-",
			ranks : [
				{rankCode : "", rankName : "-Please Select-"}
			]		
		},
		{typeCode : "E", typeName : "18-Tier",
			ranks : [
				{rankCode : "", rankName : "-Please Select-"},
				{rankCode : 1, rankName : "Agent"},
				{rankCode : 2, rankName : "Special Agent"}
			]		
		},
		{typeCode : "A", typeName : "5-Tier",
			ranks : [
				{rankCode : "", rankName : "-Please Select-"},
				{rankCode : 1, rankName : "TMR"},
				{rankCode : 2, rankName : "JMR"},
				{rankCode : 3, rankName : "AMR"},
				{rankCode : 4, rankName : "DMC"}
			]
		},
		{typeCode : "D", typeName : "Daily Deposit",
			ranks : [
				{rankCode : "", rankName : "-Please Select-"},
				{rankCode : 1, rankName : "Agent"},
				{rankCode : 2, rankName : "Introducer"}
			]		
		},
		{typeCode : "B", typeName : "Broker House",
			ranks : [
				{rankCode : "", rankName : "-Please Select-"},
				{rankCode : 1, rankName : "Agent"}
			]		
		}
	],
	/*
	Populates the list box with 
	*/
	populateListBoxWithOptions : function(typeListBox) {
		var selectedType = typeListBox.value;
		var rankListBox =  document.getElementsByName("agentRank")[0];
		//alert("Type value selected = "+selectedType);
		//alert("Rank List = "+rankListBox);
		for (var j=0;j<this.agentTypes.length;j++) {
			var type = this.agentTypes[j];
//			alert("Agent Type : " + type);
			if (type.typeCode!=selectedType) continue;
			//Remove the current options from list
			var rankListBoxLength = rankListBox.length;
			for (var i=0; i < rankListBoxLength;i++) {
				rankListBox.remove(rankListBox.selectedIndex);
			}
			for (var k=0;k<type.ranks.length;k++) {
				var rank = type.ranks[k];
				var option = document.createElement('option');
				option.text = rank.rankName;
				option.value = rank.rankCode;
				//alert ("adding option "+option.text+","+option.value);
				try {
					rankListBox.add(option,null);
				}catch(e) {
					rankListBox.add(option);
				}
			}
			break;
		}
	} 	
}
var formHandler = {
	handleExit: function() {
		var appContent = document.getElementById('appContent');
		appContent.innerHTML="";
		appContent.style.height="480px";
	}
}
function submitonce(theform){
	//if IE 4+ or NS 6+
	if (document.all||document.getElementById){
		//screen thru every element in the form, and hunt down "submit" and "reset"
		for (i=0;i<theform.length;i++){
			var tempobj=theform.elements[i]
			if(tempobj.type.toLowerCase()=="submit"||tempobj.type.toLowerCase()=="reset")
			//disable em
			tempobj.disabled=true
		}
	}
}

function openReport(targetString) {
	var name;
	for (var elems=0; elems<document.forms[0].length;elems++){
		name = document.forms[0].elements[elems].name;
    	if (name != "" && name!="button"){
    		if (elems>0) targetString += "&";
    		else targetString += "?";
        	targetString += document.forms[0].elements[elems].name + "=" +
         	document.forms[0].elements[elems].value;
      	}
    }
    alert("URL="+targetString);
    window.open(targetString,"","");
}
function checkOneItem(field,property){
	var n=0;
	var i=0;
	var checkBoxField; 
	
	while(true){
		checkBoxField= document.getElementsByName(field+"["+i+"]."+property)[0];
		if(typeof(checkBoxField)=='undefined'){
			break;
		}else{
			if(checkBoxField.checked==true){
				n++;
			  }
			}
		 i++;	
	}
	
	if(n==0){
		alert('Please Select One Agent Or Exit');
		return false;
	}
}
function checkNoOfClicks(button)
{
/*	if(noOfClicks == 0)
	{
		noOfClicks = 1;
		return true;
	}
	else 
	{
		alert("You are tring to save the page more than once");
		return false;
	} */
	alert('button :' + button.value);
	button.disabled = true;
//	button.value = 'Please Wait...';
	return true;
}

var typeMapping = {
	stateTypes : [
		{typeCode : "", typeName : "-Please Select-",
			district : [
				{districtCode : "", districtName : "-Please Select-"}
			]		
		},
		{typeCode : "AN", typeName : "Andaman and Nicobar",
			district : [
				{districtCode : "", districtName : "-Please Select-"},
				{districtCode : "NI", districtName : "Nicobar"},
				{districtCode : "AN", districtName : "Andaman"}
			]		
		},
		{typeCode : "AP", typeName : "Andhra Pradesh",
			district : [
				{districtCode : "", districtName : "-Please Select-"},
				{districtCode : "AN", districtName : "Anantapur"},
				{districtCode : "CH", districtName : "Chittoor"},
				{districtCode : "EG", districtName : "East Godavari"},
				{districtCode : "GU", districtName : "Guntur"},
				{districtCode : "HY", districtName : "Hyderabad"},
				{districtCode : "CU", districtName : "Kadapa"},
				{districtCode : "KA", districtName : "Karimnagar"},
				{districtCode : "KH", districtName : "Khammam"},
				{districtCode : "WA", districtName : "Warangal"},
				{districtCode : "KU", districtName : "Kurnool"},
				{districtCode : "MA", districtName : "Mahbubnagar"},
				{districtCode : "ME", districtName : "Medak"},
				{districtCode : "NA", districtName : "Nalgonda"},
				{districtCode : "NE", districtName : "Nellore"},
				{districtCode : "NI", districtName : "Nizamabad"},
				{districtCode : "PR", districtName : "Prakasam"},
				{districtCode : "RA", districtName : "Rangareddi"},
				{districtCode : "SR", districtName : "Srikakulam"},
				{districtCode : "VS", districtName : "Vishakhapatnam"},
				{districtCode : "VZ", districtName : "Vizianagaram"},
				{districtCode : "AD", districtName : "Adilabad"},
				{districtCode : "WG", districtName : "West Godavari"},
				{districtCode : "KR", districtName : "Krishna"}
				
			]
		},
		{typeCode : "AR", typeName : "Arunachal Pradesh",
			district : [
		    	{districtCode : "", districtName : "-Please Select-"},
				{districtCode : "EK",districtName :"East Kameng"},       
				{districtCode : "WK",districtName :"West Kameng"},       
				{districtCode : "UB",districtName :"Upper Subansiri"},   
				{districtCode : "UD",districtName :"Dibang Valley"},     
				{districtCode : "TI",districtName :"Tirap"},             
				{districtCode : "PA",districtName :"Papum Pare"},        
				{districtCode : "LB",districtName :"Lower Subansiri"},   
				{districtCode : "EL",districtName :"Lohit"},             
				{districtCode : "CH",districtName :"Changlang"},         
				{districtCode : "AN",districtName :"Anjaw"}             

			]		
		},
		{typeCode : "AS", typeName : "Assam",
			district : [
			  	{districtCode : "", districtName : "-Please Select-"}, 
				{districtCode : "SO",districtName :"Sonitpur"},           
				{districtCode : "KM",districtName :"Kamrup"},             
				{districtCode : "BO",districtName :"Bongaigaon"},         
				{districtCode : "CA",districtName :"Cachar"},             
				{districtCode : "DA",districtName :"Darrang"},            
				{districtCode : "DM",districtName :"Dhemaji"},            
				{districtCode : "DB",districtName :"Dhubri"},             
				{districtCode : "DI",districtName :"Dibrugarh"},          
				{districtCode : "GP",districtName :"Goalpara"},           
				{districtCode : "GG",districtName :"Golaghat"},           
				{districtCode : "HA",districtName :"Hailakandi"},         
				{districtCode : "JO",districtName :"Jorhat"},             
				{districtCode : "KA",districtName :"Karbi Anglong"},      
				{districtCode : "SI",districtName :"Sibsagar"},           
				{districtCode : "NC",districtName :"North Cachar Hills"}, 
				{districtCode : "NL",districtName :"Nalbari"},            
				{districtCode : "NG",districtName :"Nagaon"},             
				{districtCode : "MA",districtName :"Marigaon"},           
				{districtCode : "LA",districtName :"Lakhimpur"},          
				{districtCode : "TI",districtName :"Tinsukia"},           
				{districtCode : "KK",districtName :"Kokrajhar"},          
				{districtCode : "KR",districtName :"Karimganj"},          
				{districtCode : "BA",districtName :"Barpeta"}            

			]		
		},
		{typeCode : "BH", typeName : "Bihar",
			district : [
		    	{districtCode : "", districtName : "-Please Select-"},
				{districtCode : "AR",districtName :"Araria"},               
				{districtCode : "WC",districtName :"Pashchim Champaran"},   
				{districtCode : "BA",districtName :"Banka"},                
				{districtCode : "BE",districtName :"Begusarai"},            
				{districtCode : "BG",districtName :"Bhagalpur"},            
				{districtCode : "BJ",districtName :"Bhojpur"},              
				{districtCode : "BU",districtName :"Buxar"},                
				{districtCode : "DA",districtName :"Darbhanga"},            
				{districtCode : "EC",districtName :"Purba Champaran"},      
				{districtCode : "GA",districtName :"Gaya"},                 
				{districtCode : "GO",districtName :"Gopalganj"},            
				{districtCode : "JA",districtName :"Jamui"},                
				{districtCode : "JE",districtName :"Jehanabad"},            
				{districtCode : "KH",districtName :"Khagaria"},             
				{districtCode : "KI",districtName :"Kishanganj"},           
				{districtCode : "KM",districtName :"Kaimur"},               
				{districtCode : "KT",districtName :"Katihar"},              
				{districtCode : "LA",districtName :"Lakhisarai"},           
				{districtCode : "MB",districtName :"Madhubani"},            
				{districtCode : "MG",districtName :"Munger"},               
				{districtCode : "MP",districtName :"Madhepura"},            
				{districtCode : "MZ",districtName :"Muzaffarpur"},          
				{districtCode : "NL",districtName :"Nalanda"},              
				{districtCode : "NW",districtName :"Nawada"},               
				{districtCode : "PA",districtName :"Patna"},                
				{districtCode : "PU",districtName :"Purnia"},               
				{districtCode : "RO",districtName :"Rohtas"},               
				{districtCode : "SH",districtName :"Saharsa"},              
				{districtCode : "SM",districtName :"Samastipur"},           
				{districtCode : "SO",districtName :"Sheohar"},              
				{districtCode : "SP",districtName :"Sheikhpura"},           
				{districtCode : "SR",districtName :"Saran"},                
				{districtCode : "ST",districtName :"Sitamarhi"},            
				{districtCode : "SU",districtName :"Supaul"},               
				{districtCode : "SW",districtName :"Siwan"},                
				{districtCode : "VA",districtName :"Vaishali"},             
				{districtCode : "AU",districtName :"Aurangabad"}           
	]		
		},
		{typeCode : "GR", typeName : "Gujarat",
			district : [
		    	{districtCode : "", districtName : "-Please Select-"},
				{districtCode : "RA",districtName :"Rajkot"},          
				{districtCode : "SK",districtName :"Sabarkantha"},     
				{districtCode : "SN",districtName :"Surendranagar"},   
				{districtCode : "ST",districtName :"Surat"},           
				{districtCode : "VD",districtName :"Vadodara"},        
				{districtCode : "AM",districtName :"Amreli District"}, 
				{districtCode : "AH",districtName :"Ahmedabad"},       
				{districtCode : "KA",districtName :"Kutch"}           
       			]		
		},
		{typeCode : "HP", typeName : "Himachal Pradesh",
			district : [
		       	    {districtCode : "", districtName : "-Please Select-"},
	       			{districtCode : "SO",districtName :"Solan"},              
					{districtCode : "SI",districtName :"Sirmaur"},            
					{districtCode : "SH",districtName :"Shimla"},             
					{districtCode : "MA",districtName :"Mandi"},              
					{districtCode : "LS",districtName :"Lahaul and Spiti"},   
					{districtCode : "UNA",districtName :"Una"},               
					{districtCode : "KI",districtName :"Kinnaur"},            
					{districtCode : "KA",districtName :"Kangra"},             
					{districtCode : "HA",districtName :"Hamirpur"},           
					{districtCode : "CH",districtName :"Chamba"},             
					{districtCode : "BI",districtName :"Bilaspur"},           
					{districtCode : "KU",districtName :"Kulu"}               
     
       			]		
		},
		{typeCode : "CH", typeName : "Chhattisgarh",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
		       	    {districtCode : "BA",districtName :"Bastar"},         
					{districtCode : "SU",districtName :"Surguja"},        
					{districtCode : "BI",districtName :"Bilaspur"},       
					{districtCode : "DA",districtName :"Dantewada"},      
					{districtCode : "DH",districtName :"Dhamtari"},       
					{districtCode : "DU",districtName :"Durg"},           
					{districtCode : "JA",districtName :"Jashpur"},        
					{districtCode : "JC",districtName :"Janjgir-Champa"}, 
					{districtCode : "KB",districtName :"Korba"},          
					{districtCode : "KJ",districtName :"Koriya"},         
					{districtCode : "KK",districtName :"Kanker"},         
					{districtCode : "KW",districtName :"Kawardha"},       
					{districtCode : "MA",districtName :"Mahasamund"},     
					{districtCode : "RG",districtName :"Raigarh"},        
					{districtCode : "RN",districtName :"Rajnandgaon"},    
					{districtCode : "RP",districtName :"Raipur"}         
            
     
       			]		
		},
			{typeCode : "CN", typeName : "Chandigarh",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
		       	    {districtCode : "CH",districtName :"Chandigarh"}         
            
     
       			]		
		},
		{typeCode : "DA", typeName : "Dadra and Nagar Haveli",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
		       	    {districtCode : "DN",districtName :"Dadra and Nagar Haveli"}
       			]		
		},
		{typeCode : "DD", typeName : "Daman and Diu",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
		       	    {districtCode : "DA",districtName :"Daman"}, 
                    {districtCode : "DI",districtName :"Diu"}   
       			]		
		},
		{typeCode : "DL", typeName : "Delhi",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
		       	    {districtCode : "NO",districtName :"North Delhi"},        
					{districtCode : "NE",districtName :"North East Delhi"},   
					{districtCode : "NW",districtName :"North West Delhi"},   
					{districtCode : "SD",districtName :"South Delhi"},        
					{districtCode : "SW",districtName :"South West Delhi"},   
					{districtCode : "WD",districtName :"West Delhi"},         
					{districtCode : "ED",districtName :"East Delhi"},        
					{districtCode : "CD",districtName :"Central Delhi"},      
					{districtCode : "ND",districtName :"New Delhi"}          

       			]		
		},
		{typeCode : "GO", typeName : "Goa",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
		       	    {districtCode : "SG",districtName :"South Goa"},
                    {districtCode : "NG",districtName :"North Goa"}
		       	       
       			]		
		},
		{typeCode : "HR", typeName : "Haryana",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
		       	    {districtCode : "PK",districtName :"Panchkula"},      
					{districtCode : "PP",districtName :"Panipat"},        
					{districtCode : "RE",districtName :"Rewari"},         
					{districtCode : "RO",districtName :"Rohtak"},         
					{districtCode : "SI",districtName :"Sirsa"},          
					{districtCode : "SO",districtName :"Sonepat"},        
					{districtCode : "YN",districtName :"Yamuna Nagar"},   
					{districtCode : "PW",districtName :"Palwal District"},
					{districtCode : "MW",districtName :"Mewat"},          
					{districtCode : "MA",districtName :"Mahendragarh"},   
					{districtCode : "KU",districtName :"Kurukshetra"},    
					{districtCode : "KT",districtName :"Kaithal"},        
					{districtCode : "KR",districtName :"Karnal"},         
					{districtCode : "JI",districtName :"Jind"},           
					{districtCode : "JH",districtName :"Jhajjar"},        
					{districtCode : "HI",districtName :"Hissar"},         
					{districtCode : "GU",districtName :"Gurgaon"},        
					{districtCode : "FT",districtName :"Fatehabad"},      
					{districtCode : "FR",districtName :"Faridabad"},      
					{districtCode : "AM",districtName :"Ambala"},         
					{districtCode : "BH",districtName :"Bhiwani"}        
		        	       
       			]		
		},
		{typeCode : "JK", typeName : "Jammu and Kashmir",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
			        {districtCode : "BPR",districtName :"Bandipore"},
					{districtCode : "BR",districtName :"Baramula"},  
					{districtCode : "AN",districtName :"Anantnag"},  
					{districtCode : "UD",districtName :"Udhampur"},  
					{districtCode : "SR",districtName :"Srinagar"},  
					{districtCode : "RA",districtName :"Rajauri"},   
					{districtCode : "PU",districtName :"Pulwama"},   
					{districtCode : "PO",districtName :"Poonch"},    
					{districtCode : "LE",districtName :"Leh"},       
					{districtCode : "KU",districtName :"Kupwara"},   
					{districtCode : "KT",districtName :"Kathua"},    
					{districtCode : "KR",districtName :"Kargil"},    
					{districtCode : "JA",districtName :"Jammu"},     
					{districtCode : "DO",districtName :"Doda"},      
					{districtCode : "BD",districtName :"Badgam"}  
		    	       
       			]		
		},
		{typeCode : "JR", typeName : "Jharkhand",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
			        {districtCode : "RA",districtName :"Ranchi"},             
					{districtCode : "SA",districtName :"Sahibganj"},          
					{districtCode : "WS",districtName :"Pashchim Singhbhum"}, 
					{districtCode : "PL",districtName :"Palamu"},             
					{districtCode : "PK",districtName :"Pakur"},              
					{districtCode : "LO",districtName :"Lohardaga"},          
					{districtCode : "KO",districtName :"Koderma"},            
					{districtCode : "HA",districtName :"Hazaribagh"},         
					{districtCode : "GU",districtName :"Gumla"},              
					{districtCode : "GO",districtName :"Godda"},              
					{districtCode : "GI",districtName :"Giridih"},            
					{districtCode : "GA",districtName :"Garhwa"},             
					{districtCode : "ES",districtName :"Purba Singhbhum"},    
					{districtCode : "DU",districtName :"Dumka"},              
					{districtCode : "DH",districtName :"Dhanbad"},            
					{districtCode : "DE",districtName :"Deoghar"},            
					{districtCode : "RM",districtName :"Ramgarh District"},   
					{districtCode : "BO",districtName :"Bokaro"},             
					{districtCode : "CH",districtName :"Chatra"}             
			           
       			]		
		},
		{typeCode : "KA", typeName : "Karnataka",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
			        {districtCode : "BD",districtName :"Bidar District"},           
					{districtCode : "CB",districtName :"Chikballapur District"},    
					{districtCode : "BJ",districtName :"Bijapur District"},         
					{districtCode : "BK",districtName :"Bagalkot District"},        
					{districtCode : "BL",districtName :"Bellary District"},         
					{districtCode : "BR",districtName :"Bangalore Rural District"}, 
					{districtCode : "BN",districtName :"Bangalore Urban district"}, 
					{districtCode : "CJ",districtName :"Chamarajnagar District"},   
					{districtCode : "CK",districtName :"Chikmagalur District"},     
					{districtCode : "CT",districtName :"Chitradurga District"},     
					{districtCode : "DA",districtName :"Davanagere District"},      
					{districtCode : "DH",districtName :"Dharwad District"},         
					{districtCode : "DK",districtName :"Dakshina Kannada"},         
					{districtCode : "GA",districtName :"Gadag District"},           
					{districtCode : "GU",districtName :"Gulbarga District"},        
					{districtCode : "HS",districtName :"Hassan District"},          
					{districtCode : "HV",districtName :"Haveri District"},          
					{districtCode : "KD",districtName :"Kodagu"},                   
					{districtCode : "KL",districtName :"Kolar District"},           
					{districtCode : "KP",districtName :"Koppal District"},          
					{districtCode : "MA",districtName :"Mandya District"},          
					{districtCode : "MY",districtName :"Mysore District"},          
					{districtCode : "RA",districtName :"Raichur District"},         
					{districtCode : "SH",districtName :"Shimoga District"},         
					{districtCode : "TU",districtName :"Tumkur District"},          
					{districtCode : "UD",districtName :"Udupi District"},           
					{districtCode : "UK",districtName :"Uttara Kannada"},           
					{districtCode : "RM",districtName :"Ramanagara District"},      
					{districtCode : "BG",districtName :"Belgaum District"}         
			           
       			]		
		},
		{typeCode : "KR", typeName : "Kerala",
			district : [
			        {districtCode : "", districtName : "-Please Select-"}, 
			        {districtCode : "PT",districtName :"Pathanamthitta"},    
					{districtCode : "TS",districtName :"Thrissur"},          
					{districtCode : "TV",districtName :"Thiruvananthapuram"},
					{districtCode : "WA",districtName :"Wayanad"},           
					{districtCode : "AL",districtName :"Alappuzha"},         
					{districtCode : "ER",districtName :"Ernakulam"},         
					{districtCode : "ID",districtName :"Idukki"},            
					{districtCode : "KL",districtName :"Kollam"},            
					{districtCode : "KN",districtName :"Kannur"},            
					{districtCode : "KS",districtName :"Kasaragod"},         
					{districtCode : "KT",districtName :"Kottayam"},          
					{districtCode : "KZ",districtName :"Kozhikode"},         
					{districtCode : "MA",districtName :"Malappuram"},        
					{districtCode : "PL",districtName :"Palakkad"}          
			           
       			]		
		},
		{typeCode : "LD", typeName : "Lakshadweep",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "LA",districtName :"Lakshadweep"} 
			                 	           
       			]		
		},
		{typeCode : "MG", typeName : "Meghalaya",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "EG",districtName :"East Garo Hills"}, 
					{districtCode : "EK",districtName :"East Khasi Hills"},
					{districtCode : "JH",districtName :"Jaintia Hills"},   
					{districtCode : "WK",districtName :"West Khasi Hills"},
					{districtCode : "SG",districtName :"South Garo Hills"},
					{districtCode : "WG",districtName :"West Garo Hills"}, 
					{districtCode : "RB",districtName :"Ri-Bhoi"}         
		          	           
       			]		
		},
		{typeCode : "MH", typeName : "Maharashtra",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "ND",districtName :"Nanded"},          
					{districtCode : "NG",districtName :"Nagpur"},          
					{districtCode : "NS",districtName :"Nashik"},          
					{districtCode : "OS",districtName :"Osmanabad"},       
					{districtCode : "PA",districtName :"Parbhani"},        
					{districtCode : "PU",districtName :"Pune"},            
					{districtCode : "RG",districtName :"Raigad"},          
					{districtCode : "RT",districtName :"Ratnagiri"},       
					{districtCode : "SI",districtName :"Sindhudurg"},      
					{districtCode : "SN",districtName :"Sangli"},          
					{districtCode : "SO",districtName :"Solapur"},         
					{districtCode : "ST",districtName :"Satara"},          
					{districtCode : "TH",districtName :"Thane"},           
					{districtCode : "WR",districtName :"Wardha"},          
					{districtCode : "WS",districtName :"Washim"},          
					{districtCode : "YA",districtName :"Yavatmal"},        
					{districtCode : "AH",districtName :"Ahmednagar"},      
					{districtCode : "AK",districtName :"Akola"},           
					{districtCode : "AM",districtName :"Amrawati"},        
					{districtCode : "AU",districtName :"Aurangabad"},      
					{districtCode : "BH",districtName :"Bhandara"},        
					{districtCode : "BI",districtName :"Beed"},            
					{districtCode : "BU",districtName :"Buldhana"},        
					{districtCode : "CH",districtName :"Chandrapur"},      
					{districtCode : "DH",districtName :"Dhule"},           
					{districtCode : "GA",districtName :"Gadchiroli"},      
					{districtCode : "GO",districtName :"Gondiya"},         
					{districtCode : "HI",districtName :"Hingoli"},         
					{districtCode : "JG",districtName :"Jalgaon"},         
					{districtCode : "JN",districtName :"Jalna"},           
					{districtCode : "KO",districtName :"Kolhapur"},        
					{districtCode : "LA",districtName :"Latur"},           
					{districtCode : "MC",districtName :"Mumbai City"},     
					{districtCode : "MU",districtName :"Mumbai suburban"}, 
					{districtCode : "NB",districtName :"Nandurbar"}       
			      	           
       			]		
		},
		{typeCode : "MN", typeName : "Manipur",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "BI",districtName :"Bishnupur"},      
					{districtCode : "CC",districtName :"Churachandpur"},  
					{districtCode : "CD",districtName :"Chandel"},        
					{districtCode : "EI",districtName :"Imphal East"},    
					{districtCode : "WI",districtName :"Imphal West"},    
					{districtCode : "TA",districtName :"Tamenglong"},     
					{districtCode : "TH",districtName :"Thoubal"},        
					{districtCode : "UK",districtName :"Ukhrul"},         
					{districtCode : "SE",districtName :"Senapati"}       
			                   
       			]		
		},
		{typeCode : "MP", typeName : "Madhya Pradesh",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "GW",districtName :"Gwalior"},               
					{districtCode : "UM",districtName :"Umaria"},                
					{districtCode : "UJ",districtName :"Ujjain"},                
					{districtCode : "TI",districtName :"Tikamgarh"},             
					{districtCode : "SI",districtName :"Sidhi"},                 
					{districtCode : "SV",districtName :"Shivpuri"},              
					{districtCode : "SP",districtName :"Sheopur"},               
					{districtCode : "SJ",districtName :"Shajapur"},              
					{districtCode : "BL",districtName :"Balaghat"},              
					{districtCode : "BR",districtName :"Barwani"},               
					{districtCode : "BE",districtName :"Betul"},                 
					{districtCode : "BD",districtName :"Bhind"},                 
					{districtCode : "BP",districtName :"Bhopal"},                
					{districtCode : "CT",districtName :"Chhatarpur"},            
					{districtCode : "CN",districtName :"Chhindwara"},            
					{districtCode : "DM",districtName :"Damoh"},                 
					{districtCode : "DT",districtName :"Datia"},                 
					{districtCode : "DE",districtName :"Dewas"},                 
					{districtCode : "DH",districtName :"Dhar"},                  
					{districtCode : "DI",districtName :"Dindori"},               
					{districtCode : "GU",districtName :"Guna"},                  
					{districtCode : "VI",districtName :"Vidisha"},               
					{districtCode : "HA",districtName :"Harda"},                 
					{districtCode : "HO",districtName :"Hoshangabad"},           
					{districtCode : "IN",districtName :"Indore"},                
					{districtCode : "JA",districtName :"Jabalpur"},              
					{districtCode : "JH",districtName :"Jhabua"},                
					{districtCode : "KA",districtName :"Katni"},                 
					{districtCode : "EN",districtName :"Khandwa (East Nimar)"},  
					{districtCode : "WN",districtName :"Khargone (West Nimar)"}, 
					{districtCode : "ML",districtName :"Mandla"},                
					{districtCode : "MS",districtName :"Mandsaur"},              
					{districtCode : "MO",districtName :"Morena"},                
					{districtCode : "NA",districtName :"Narsinghpur"},           
					{districtCode : "NE",districtName :"Neemuch"},               
					{districtCode : "PA",districtName :"Panna"},                 
					{districtCode : "RE",districtName :"Rewa"},                  
					{districtCode : "RG",districtName :"Rajgarh"},               
					{districtCode : "RL",districtName :"Ratlam"},                
					{districtCode : "RS",districtName :"Raisen"},                
					{districtCode : "SG",districtName :"Sagar"},                 
					{districtCode : "ST",districtName :"Satna"},                 
					{districtCode : "SR",districtName :"Sehore"},                
					{districtCode : "SO",districtName :"Seoni"},                
					{districtCode : "SH",districtName :"Shahdol"}               
			        
       			]		
		},
		{typeCode : "MZ", typeName : "Mizoram",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "SE",districtName :"Serchhip"},   
					{districtCode : "SA",districtName :"Saiha"},      
					{districtCode : "MA",districtName :"Mamit"},      
					{districtCode : "LU",districtName :"Lunglei"},    
					{districtCode : "LA",districtName :"Lawngtlai"},  
					{districtCode : "KO",districtName :"Kolasib"},    
					{districtCode : "CH",districtName :"Champhai"},   
					{districtCode : "AI",districtName :"Aizawl"}     
			                   
       			]		
		},
		{typeCode : "NL", typeName : "Nagaland",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "DI",districtName :"Dimapur"},    
					{districtCode : "KO",districtName :"Kohima"},     
					{districtCode : "MK",districtName :"Mokokchung"}, 
					{districtCode : "ZU",districtName :"Zunheboto"},  
					{districtCode : "PH",districtName :"Phek"},       
					{districtCode : "TU",districtName :"Tuensang"},   
					{districtCode : "WO",districtName :"Wokha"},      
					{districtCode : "MN",districtName :"Mon"}        
			                   
       			]		
		},
		{typeCode : "OR", typeName : "Orissa",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "AN",districtName :"Angul"},                   
					{districtCode : "SU",districtName :"Sundargarh (Sundergarh)"}, 
					{districtCode : "BH",districtName :"Bhadrak"},                 
					{districtCode : "BL",districtName :"Bolangir (Balangir)"},     
					{districtCode : "BR",districtName :"Bargarh (Baragarh)"},      
					{districtCode : "BW",districtName :"Baleswar (Balasore)"},     
					{districtCode : "CU",districtName :"Cuttack"},                 
					{districtCode : "DE",districtName :"Debagarh (Deogarh)"},      
					{districtCode : "DH",districtName :"Dhenkanal"},               
					{districtCode : "GN",districtName :"Ganjam"},                  
					{districtCode : "GP",districtName :"Gajapati"},                
					{districtCode : "JH",districtName :"Jharsuguda"},              
					{districtCode : "JP",districtName :"Jajapur (Jajpur)"},        
					{districtCode : "JS",districtName :"Jagatsinghpur"},           
					{districtCode : "KH",districtName :"Khordha"},                 
					{districtCode : "KJ",districtName :"Kendujhar (Keonjhar)"},    
					{districtCode : "KL",districtName :"Kalahandi"},               
					{districtCode : "KN",districtName :"Kandhamal"},               
					{districtCode : "KO",districtName :"Koraput"},                 
					{districtCode : "KP",districtName :"Kendrapara"},              
					{districtCode : "ML",districtName :"Malkangiri"},              
					{districtCode : "MY",districtName :"Mayurbhanj"},              
					{districtCode : "NB",districtName :"Nabarangpur"},             
					{districtCode : "NU",districtName :"Nuapada"},                 
					{districtCode : "NY",districtName :"Nayagarh"},                
					{districtCode : "PU",districtName :"Puri"},                    
					{districtCode : "RA",districtName :"Rayagada"},                
					{districtCode : "SA",districtName :"Sambalpur"},               
					{districtCode : "SO",districtName :"Subarnapur (Sonepur)"},    
					{districtCode : "BD",districtName :"Boudh (Bauda)"}           
			                   
       			]		
		},
		{typeCode : "PD", typeName : "Puducherry",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "YA",districtName :"Yanam"},      
					{districtCode : "PO",districtName :"Puducherry"}, 
					{districtCode : "MA",districtName :"Mahe"},       
					{districtCode : "KA",districtName :"Karaikal"}   
			                   
       			]		
		},
		{typeCode : "PJ", typeName : "Punjab",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "FT",districtName :"Fatehgarh Sahib"}, 
					{districtCode : "GU",districtName :"Gurdaspur"},       
					{districtCode : "SA",districtName :"Sangrur"},         
					{districtCode : "JA",districtName :"Jalandhar"},       
					{districtCode : "KA",districtName :"Kapurthala"},      
					{districtCode : "LU",districtName :"Ludhiana"},        
					{districtCode : "MA",districtName :"Mansa"},           
					{districtCode : "MO",districtName :"Moga"},            
					{districtCode : "MU",districtName :"Mukatsar"},        
					{districtCode : "NS",districtName :"Nawan Shehar"},    
					{districtCode : "PA",districtName :"Patiala"},         
					{districtCode : "RU",districtName :"Rupnagar"},        
					{districtCode : "FR",districtName :"Faridkot"},        
					{districtCode : "FI",districtName :"Firozpur"},        
					{districtCode : "BA",districtName :"Bathinda"},        
					{districtCode : "AM",districtName :"Amritsar"},        
					{districtCode : "HO",districtName :"Hoshiarpur"}      
			                   
       			]		
		},
		{typeCode : "RJ", typeName : "Rajasthan",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "AJ",districtName :"Ajmer"},          
					{districtCode : "UD",districtName :"Udaipur"},        
					{districtCode : "BI",districtName :"Bikaner"},        
					{districtCode : "BM",districtName :"Barmer"},         
					{districtCode : "BN",districtName :"Banswara"},       
					{districtCode : "BP",districtName :"Bharatpur"},      
					{districtCode : "BR",districtName :"Baran"},          
					{districtCode : "BU",districtName :"Bundi"},          
					{districtCode : "BW",districtName :"Bhilwara"},       
					{districtCode : "CR",districtName :"Churu"},          
					{districtCode : "CT",districtName :"Chittorgarh"},    
					{districtCode : "DA",districtName :"Dausa"},          
					{districtCode : "DH",districtName :"Dholpur"},        
					{districtCode : "DU",districtName :"Dungapur"},       
					{districtCode : "GA",districtName :"Ganganagar"},     
					{districtCode : "HA",districtName :"Hanumangarh"},    
					{districtCode : "JJ",districtName :"Juhnjhunun"},     
					{districtCode : "JL",districtName :"Jalore"},         
					{districtCode : "JO",districtName :"Jodhpur"},        
					{districtCode : "JP",districtName :"Jaipur"},         
					{districtCode : "JS",districtName :"Jaisalmer"},      
					{districtCode : "JW",districtName :"Jhalawar"},       
					{districtCode : "KA",districtName :"Karauli"},        
					{districtCode : "KO",districtName :"Kota"},           
					{districtCode : "NA",districtName :"Nagaur"},         
					{districtCode : "PA",districtName :"Pali"},           
					{districtCode : "RA",districtName :"Rajsamand"},      
					{districtCode : "SK",districtName :"Sikar"},          
					{districtCode : "SM",districtName :"Sawai Madhopur"}, 
					{districtCode : "SR",districtName :"Sirohi"},         
					{districtCode : "TO",districtName :"Tonk"},           
					{districtCode : "AL",districtName :"Alwar"}          
			                   
       			]		
		},
		{typeCode : "SK", typeName : "Sikkim",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "ES",districtName :"East Sikkim"},   
					{districtCode : "WS",districtName :"West Sikkim"},   
					{districtCode : "SS",districtName :"South Sikkim"},  
					{districtCode : "NS",districtName :"North Sikkim"}  
			                   
       			]		
		},
		{typeCode : "TN", typeName : "Tamil Nadu",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "AY",districtName :"Ariyalur"},        
					{districtCode : "CH",districtName :"Chennai"},         
					{districtCode : "VR",districtName :"Virudhunagar"},    
					{districtCode : "VL",districtName :"Villupuram"},      
					{districtCode : "VE",districtName :"Vellore"},         
					{districtCode : "CO",districtName :"Coimbatore"},      
					{districtCode : "CU",districtName :"Cuddalore"},       
					{districtCode : "DH",districtName :"Dharmapuri"},      
					{districtCode : "DI",districtName :"Dindigul"},        
					{districtCode : "ER",districtName :"Erode"},           
					{districtCode : "KC",districtName :"Kanchipuram"},     
					{districtCode : "KK",districtName :"Kanyakumari"},     
					{districtCode : "KR",districtName :"Karur"},           
					{districtCode : "MA",districtName :"Madurai"},         
					{districtCode : "NG",districtName :"Nagapattinam"},    
					{districtCode : "NI",districtName :"The Nilgiris"},    
					{districtCode : "NM",districtName :"Namakkal"},        
					{districtCode : "PE",districtName :"Perambalur"},      
					{districtCode : "PU",districtName :"Pudukkottai"},     
					{districtCode : "RA",districtName :"Ramanathapuram"},  
					{districtCode : "SA",districtName :"Salem"},           
					{districtCode : "SI",districtName :"Sivaganga"},       
					{districtCode : "TC",districtName :"Tiruchirappalli"}, 
					{districtCode : "TH",districtName :"Theni"},           
					{districtCode : "TI",districtName :"Tirunelveli"},     
					{districtCode : "TJ",districtName :"Tanjore"},         
					{districtCode : "TK",districtName :"Thoothukudi"},     
					{districtCode : "TL",districtName :"Thiruvallur"},     
					{districtCode : "TR",districtName :"Thiruvarur"},      
					{districtCode : "TP",districtName :"Tirupur"},         
					{districtCode : "TV",districtName :"Tiruvannamalai"}  
			                   
       			]		
		},
		{typeCode : "TP", typeName : "Tripura",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "DH",districtName :"Dhalai"},        
					{districtCode : "ST",districtName :"South Tripura"}, 
					{districtCode : "NT",districtName :"North Tripura"}, 
					{districtCode : "WT",districtName :"West Tripura"}  
			                   
       			]		
		},
		{typeCode : "UK", typeName : "Uttarakhand",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "AL",districtName :"Almora"},            
					{districtCode : "BA",districtName :"Bageshwar"},         
					{districtCode : "CL",districtName :"Chamoli"},           
					{districtCode : "CP",districtName :"Champawat"},         
					{districtCode : "DD",districtName :"Dehradun"},          
					{districtCode : "HA",districtName :"Haridwar"},          
					{districtCode : "UT",districtName :"Uttarkashi"},        
					{districtCode : "PG",districtName :"Pauri Garhwal"},     
					{districtCode : "PI",districtName :"Pithoragharh"},      
					{districtCode : "RP",districtName :"Rudraprayag"},       
					{districtCode : "TG",districtName :"Tehri Garhwal"},     
					{districtCode : "US",districtName :"Udham Singh Nagar"}, 
					{districtCode : "NA",districtName :"Nainital"}          
			                   
       			]		
		},
		{typeCode : "UP", typeName : "Uttar Pradesh",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "MO",districtName :"Moradabad"},                   
					{districtCode : "MP",districtName :"Mainpuri"},                    
					{districtCode : "MT",districtName :"Mathura"},                     
					{districtCode : "MU",districtName :"Muzaffarnagar"},               
					{districtCode : "PI",districtName :"Pilibhit"},                    
					{districtCode : "PR",districtName :"Pratapgarh"},                  
					{districtCode : "RA",districtName :"Rampur"},                      
					{districtCode : "RB",districtName :"Rae Bareli"},                  
					{districtCode : "SA",districtName :"Saharanpur"},                  
					{districtCode : "SI",districtName :"Sitapur"},                     
					{districtCode : "SJ",districtName :"Shahjahanpur"},                
					{districtCode : "SK",districtName :"Sant Kabir Nagar"},            
					{districtCode : "SN",districtName :"Siddharthnagar"},              
					{districtCode : "SO",districtName :"Sonbhadra"},                   
					{districtCode : "SR",districtName :"Sant Ravidas Nagar"},          
					{districtCode : "SU",districtName :"Sultanpur"},                   
					{districtCode : "SV",districtName :"Shravasti"},                   
					{districtCode : "UN",districtName :"Unnao"},                       
					{districtCode : "VA",districtName :"Varanasi"},                    
					{districtCode : "AG",districtName :"Agra"},                        
					{districtCode : "AH",districtName :"Allahabad"},                   
					{districtCode : "AL",districtName :"Aligarh"},                     
					{districtCode : "AN",districtName :"Ambedkar Nagar"},              
					{districtCode : "AU",districtName :"Auraiya"},                     
					{districtCode : "AZ",districtName :"Azamgarh"},                    
					{districtCode : "BB",districtName :"Barabanki"},                   
					{districtCode : "BD",districtName :"Badaun"},                      
					{districtCode : "BG",districtName :"Bagpat"},                      
					{districtCode : "BH",districtName :"Bahraich"},                    
					{districtCode : "BI",districtName :"Bijnor"},                      
					{districtCode : "BL",districtName :"Ballia"},                      
					{districtCode : "BN",districtName :"Banda District"},              
					{districtCode : "BP",districtName :"Balrampur"},                   
					{districtCode : "BR",districtName :"Bareilly"},                    
					{districtCode : "BS",districtName :"Basti"},                       
					{districtCode : "BU",districtName :"Bulandshahr"},                 
					{districtCode : "CD",districtName :"Chandauli"},                   
					{districtCode : "CT",districtName :"Chitrakoot"},                  
					{districtCode : "DE",districtName :"Deoria"},                      
					{districtCode : "ET",districtName :"Etah"},                        
					{districtCode : "EW",districtName :"Etawah"},                      
					{districtCode : "FI",districtName :"Firozabad"},                   
					{districtCode : "FR",districtName :"Farrukhabad"},                 
					{districtCode : "FT",districtName :"Fatehpur"},                    
					{districtCode : "FZ",districtName :"Faizabad"},                    
					{districtCode : "GB",districtName :"Gautam Buddha Nagar"},         
					{districtCode : "GN",districtName :"Gonda"},                       
					{districtCode : "GP",districtName :"Ghazipur"},                    
					{districtCode : "GR",districtName :"Gorkakhpur"},                  
					{districtCode : "GZ",districtName :"Ghaziabad"},                   
					{districtCode : "HM",districtName :"Hamirpur"},                    
					{districtCode : "HR",districtName :"Hardoi"},                      
					{districtCode : "HT",districtName :"Mahamaya Nagar"},              
					{districtCode : "JH",districtName :"Jhansi"},                      
					{districtCode : "JL",districtName :"Jalaun"},                      
					{districtCode : "JP",districtName :"Jyotiba Phule Nagar"},         
					{districtCode : "JU",districtName :"Jaunpur District"},            
					{districtCode : "KD",districtName :"Kanpur Dehat"},                
					{districtCode : "KJ",districtName :"Kannauj"},                     
					{districtCode : "KN",districtName :"Kanpur Nagar"},                
					{districtCode : "KS",districtName :"Kaushambi"},                   
					{districtCode : "KU",districtName :"Kushinagar"},                  
					{districtCode : "LA",districtName :"Lalitpur"},                    
					{districtCode : "LK",districtName :"Lakhimpur Kheri"},             
					{districtCode : "LU",districtName :"Lucknow"},                     
					{districtCode : "MB",districtName :"Mau"},                         
					{districtCode : "ME",districtName :"Meerut"},                      
					{districtCode : "MG",districtName :"Maharajganj"},                 
					{districtCode : "MH",districtName :"Mahoba"},                      
					{districtCode : "MI",districtName :"Mirzapur"}                   
			                   
       			]		
		},
		{typeCode : "WB", typeName : "West Bengal",
			district : [
			        {districtCode : "", districtName : "-Please Select-"},
			        {districtCode : "BI",districtName :"Birbhum"},           
					{districtCode : "UD",districtName :"Uttar Dinajpur"},    
					{districtCode : "BR",districtName :"Bardhaman"},         
					{districtCode : "DA",districtName :"Darjeeling"},        
					{districtCode : "DD",districtName :"Dakshin Dinajpur"},  
					{districtCode : "HG",districtName :"Hooghly"},           
					{districtCode : "HR",districtName :"Howrah"},            
					{districtCode : "JA",districtName :"Jalpaiguri"},        
					{districtCode : "KB",districtName :"Cooch Behar"},       
					{districtCode : "KO",districtName :"Kolkata"},           
					{districtCode : "MA",districtName :"Malda"},             
					{districtCode : "MW",districtName :"Midnapore West"},    
					{districtCode : "ME",districtName :"Midnapore East"},    
					{districtCode : "MU",districtName :"Murshidabad"},       
					{districtCode : "NA",districtName :"Nadia"},             
					{districtCode : "PN",districtName :"North 24 Parganas"}, 
					{districtCode : "PS",districtName :"South 24 Parganas"}, 
					{districtCode : "PU",districtName :"Purulia"},           
					{districtCode : "BN",districtName :"Bankura"}           
			                   
       			]		
		}
		
		
	],
	/*
	Populates the list box with 
	*/
	populateListBoxWithOptions : function(typeListBox) {
		var selectedType = typeListBox.value;
		var rankListBox =  document.getElementsByName("districtCode")[0];
	//	alert("Type value selected = "+selectedType);
	//	alert("Rank List = "+rankListBox);
		for (var j=0;j<this.stateTypes.length;j++) {
			var type = this.stateTypes[j];
	//		alert("Agent Type : " + type);
			if (type.typeCode!=selectedType) continue;
			var rankListBoxLength = rankListBox.length;
			for (var i=0; i < rankListBoxLength;i++) {
				rankListBox.remove(rankListBox.selectedIndex);
			}
			for (var k=0;k<type.district.length;k++) {
				var district = type.district[k];
				var option = document.createElement('option');
				option.text = district.districtName;
				option.value = district.districtCode;
		//		alert ("adding option "+option.text+","+option.value);
				try {
					rankListBox.add(option,null);
				}catch(e) {
					rankListBox.add(option);
				}
			}
			break;
		}
	} 	
}

function openWindowForApplet(targetString){
	window.open(targetString,"","width=700, height=600,menubar=0,location=1,status=1,resizable=0,scrollbars=yes");
}

function search(hyperLink) {

  	var w = 600;
	var h = 500;
	searchWin = window.open(hyperLink,"searchWin", "toolbar=1,location=1,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width="+w+",height="+h);
    searchWin.moveTo((screen.center), (screen.center));
    searchWin.opener = self;
    searchWin.focus();
}