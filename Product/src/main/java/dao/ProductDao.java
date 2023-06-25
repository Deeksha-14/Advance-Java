package dao;


import java.sql.SQLException;
import java.util.List;

import pojos.product;

public interface ProductDao {
	
	List<product> fetchAllProduct() throws SQLException;
	
}
