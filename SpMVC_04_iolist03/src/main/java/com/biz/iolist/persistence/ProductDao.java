package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	
	
	public String getPCode(String p_code);
	public int insert(ProductDTO proDTO);
	public int delete(String p_code);
	public int update(ProductDTO proDTO);

	public String getPCode();
	public ProductDTO findByPCode(String p_code);
}
