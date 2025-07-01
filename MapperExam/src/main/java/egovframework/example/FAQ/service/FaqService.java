package egovframework.example.FAQ.service;

import java.util.List;

import egovframework.example.common.Criteria;

public interface FaqService {
	List<?> selectFaqList(Criteria criteria);

}
