package com.faith.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.faith.bean.AssetManagement;



public class AssetManagementDao  {

	
	//mysql conn
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template){
		this.template = template;
	}

	
	//mysql statements
	private static final String INSERT="insert into amc(amcName,investmentOption,aumRate,noSchemes,updatedtill) values(?,?,?,?,?)";
	private static final String UPDATE =" update amc set amcName=?,investmentOption=?,aumRate=?,noSchemes=?,updatedtill=? where id=?";
	private static final String DELETE="delete from amc where id=?";  
	
	
	//Listing all assets details method
	public List<AssetManagement> getAllAssetDetails() {
		return template
				.query("select id,amcName,investmentOption,aumRate,noSchemes,updatedtill from amc ",
						new RowMapper<AssetManagement>(){
							public AssetManagement mapRow(ResultSet rs, int row)
									throws SQLException{
								AssetManagement objAssetManagement = new AssetManagement();
								objAssetManagement.setId(rs.getInt(1));
								objAssetManagement.setAmcName(rs.getString(2));
								objAssetManagement.setInvestmentOption(rs.getString(3));
								objAssetManagement.setAumRate(rs.getInt(4));
								objAssetManagement.setNoSchemes(rs.getInt(5));
								objAssetManagement.setUpdatedtill(rs.getDate(6));
								
								return objAssetManagement;
							}
				});
	}


	
	//Listing by id method
	public AssetManagement getAmcById(int amcId) {
		String sql ="select id,amcName,investmentOption,aumRate,noSchemes,updatedtill from amc where id=? ";
		return template.queryForObject(sql, new Object[]{amcId}, new BeanPropertyRowMapper<AssetManagement>(AssetManagement.class));
	}

	
	//Inserting asset details method
	public Boolean insertAmc(final AssetManagement amc){  
	      
		System.out.println(amc);
	    return template.execute(INSERT,new PreparedStatementCallback<Boolean>(){  
	   
	    public Boolean doInPreparedStatement(PreparedStatement statement)  
	            throws SQLException, DataAccessException {  
	              
	    	statement.setString(1,amc.getAmcName());  
	    	statement.setString(2,amc.getInvestmentOption());  
	    	statement.setInt(3,amc.getAumRate());
	    	statement.setInt(4,amc.getNoSchemes());
	    	statement.setDate(5,amc.getUpdatedtill());
	              
	        return statement.execute();  
	              
	    }  
	    });  
	}  
		
		
	//updating asset details method
	public Boolean updateAmc(final AssetManagement objAssetManagement){  
	      
	    return template.execute(UPDATE,new PreparedStatementCallback<Boolean>(){  
	   
	    public Boolean doInPreparedStatement(PreparedStatement statement)  
	            throws SQLException, DataAccessException {  
	              
	    	statement.setString(1,objAssetManagement.getAmcName());  
	    	statement.setString(2,objAssetManagement.getInvestmentOption());  
	    	statement.setInt(3,objAssetManagement.getAumRate()); 
	    	statement.setInt(4,objAssetManagement.getNoSchemes());
	    	statement.setDate(5,objAssetManagement.getUpdatedtill());
	    	statement.setInt(6,objAssetManagement.getId());
	    	
	              
	        return statement.execute();  
	              
	    }  
	    });  
	}  
		
	//Delete method
	public Boolean deleteAmc(final int ID){  
	      
	    return template.execute(DELETE,new PreparedStatementCallback<Boolean>(){  
	   
	    public Boolean doInPreparedStatement(PreparedStatement statement)  
	            throws SQLException, DataAccessException {  
	              
	    	statement.setInt(1, ID);
	              
	        return statement.execute();  
	              
	    }  
	    });  
	}
		}

