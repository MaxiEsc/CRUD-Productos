package com.maxsoft.crud.controlller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxsoft.crud.model.Producto;
import com.maxsoft.crud.repository.ProductoRepository;

@Controller
@RequestMapping("/productos") //Se accese a http://localhost:8080/productos, para acceder al controlador
public class ProductoController {

	//private final Logger logg = LoggerFactory.getLogger(Producto.class);
	
	@Autowired //le inyectamos al controlador este objeto
	private ProductoRepository productoRepository;
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("productos", productoRepository.findAll());
		
		
		return "home";
	}
	
	@GetMapping("/create")
	public String create(){
		
		return "create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		
		
		//logg.info("Informacion del producto, {}",producto);
		
		productoRepository.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto p = productoRepository.getOne(id);
		model.addAttribute("producto", p);
		
		return "edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		Producto p = productoRepository.getOne(id);
		productoRepository.delete(p);
		return "redirect:/productos";
	}
}













