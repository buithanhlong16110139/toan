package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;
@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	@Autowired
    private NewsRepository newsRepository;

	 @Override
	 public List<News> getAll() 
	 {
	  return (List<News>) newsRepository.findAll();
	 }
	 
	 @Override
	 public News getNewsById(int id) {
	  return newsRepository.findById(id).get();
	 }

	 @Override
	 public void saveOrUpdate(News news) 
	 {
		 newsRepository.save(news);
	 }

	 @Override
	 public void deleteNews(int id) {
		 newsRepository.deleteById(id);
	 }
}	
