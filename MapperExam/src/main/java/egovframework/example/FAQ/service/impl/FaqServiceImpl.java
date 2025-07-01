package egovframework.example.FAQ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.FAQ.service.FaqService;
import egovframework.example.common.Criteria;

@Service
public class FaqServiceImpl implements FaqService{
	@Autowired
	private FaqMapper faqMapper;

	@Override
	public List<?> selectFaqList(Criteria criteria) {
		// TODO Auto-generated method stub
		return faqMapper.selectFaqList(criteria);
	}
	
	
}
