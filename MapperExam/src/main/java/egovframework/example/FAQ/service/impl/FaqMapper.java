package egovframework.example.FAQ.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;

@Mapper
public interface FaqMapper {
	public List<?> selectFaqList(Criteria criteria);
}
