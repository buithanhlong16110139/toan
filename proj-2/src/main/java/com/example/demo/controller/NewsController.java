package com.example.demo.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.News;

import com.example.demo.service.NewsService;
@Controller
public class NewsController 
{
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/news")
	public String index(Model model) 
	{
		model.addAttribute("newses", newsService.getAll());
		return "list";
	}
	@GetMapping("/news/create")
	public String create(Model model) {
		
		model.addAttribute("news", new News());
		return "form";
	}
	@GetMapping("/news/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("news",newsService.getNewsById(id));
		return "form";
	}
	@PostMapping("/news/save")
	public String save(@Valid News news, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		newsService.saveOrUpdate(news);
		redirect.addFlashAttribute("success", "Saved news successfully!");
		return "redirect:/news";
	}
	@GetMapping("/news/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		newsService.deleteNews(id);
		redirect.addFlashAttribute("success", "Deleted news successfully!");
		return "redirect:/news";
	}
}
