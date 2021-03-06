package com.ktds.framework.sample.angular.grid;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("angular_gridDao")
public class Angular_gridDaoImpl implements Angular_gridDao{
    protected final Logger logger = LoggerFactory.getLogger(Angular_gridDaoImpl.class);
    
	@Autowired
	@Qualifier("mybatisSqlSession")
	private SqlSession sqlSession;
	
    // select
	@Override
    public List<Angular_gridVO> select(Angular_gridVO vo, HashMap param) {
        logger.info("select(obj, param) invoked...");
        
        return sqlSession.selectList("com.sample.common.grid." + param.get("mapperInfo"), vo);
        
    }
    @Override
    public List<Angular_gridVO> select(Angular_gridVO vo) {
        logger.info("select(obj) invoked...");
        
        return sqlSession.selectList("com.sample.common.grid.selectList", vo);
        
    }
    // insert
    @Override
    public Integer insert(Angular_gridVO vo) {
        logger.info("insert(obj) invoked...");
        
        return sqlSession.update("com.sample.common.grid.insert", vo);
        
    }
    @Override
    public Integer insert(Angular_gridVO vo, HashMap param) {
        logger.info("insert(obj, param) invoked...");
        
        return sqlSession.update("com.sample.common.grid." + param.get("mapperInfo"), vo);
        
    }
    
    // update
    @Override
    public Integer update(Angular_gridVO vo) {
        logger.info("update(obj) invoked...");
        
        return sqlSession.update("com.sample.common.grid.update", vo);
        
    }
    @Override
    public Integer update(Angular_gridVO vo, HashMap param) {
        logger.info("update(obj, param) invoked...");
        return sqlSession.update("com.sample.common.grid." + param.get("mapperInfo"), vo);
        
    }
    @Override
    // delete
    public Integer delete(Angular_gridVO vo) {
        logger.info("delete(obj) invoked...");
        
        return sqlSession.update("com.sample.common.grid.delete", vo);
        
    }
}
