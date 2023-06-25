package dao;

import static utils.dbutils.closeConnection;
import static utils.dbutils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.product;

public class ProductDaoImpl implements ProductDao {
	private Connection cn;
	private PreparedStatement pst1;

	public ProductDaoImpl() throws SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from product");
	}

	@Override
	public List<product> fetchAllProduct() throws SQLException {
		List<product> prd = new ArrayList<product>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				prd.add(new product(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5)));
		}
		return prd;
	}
	
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up");
	}

}
