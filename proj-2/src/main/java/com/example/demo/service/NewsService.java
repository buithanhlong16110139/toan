package com.example.demo.service;

import java.util.List;

import com.example.demo.model.News;

public interface NewsService {
	
	 public List<News> getAll();
	 
	 public News getNewsById(int id);
	 
	 public void saveOrUpdate(News news);
	 
	 public void deleteNews(int id);
}
