package jp.co.internous.espoir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.espoir.model.domain.MstProduct;
import jp.co.internous.espoir.model.mapper.MstProductMapper;
import jp.co.internous.espoir.model.session.LoginSession;

@Controller
@RequestMapping("/espoir/product")
public class ProductController {
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;

	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {
		MstProduct product = productMapper.findById(id);
		m.addAttribute("product", product);
		m.addAttribute("loginSession",loginSession);
		return "product_detail";
	}
}