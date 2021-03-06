package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.MaterielDao;
import com.example.demo.entity.Materiel;


@Repository("materielDao")
public class MaterielDaoImpl implements MaterielDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Materiel> getAllMateriel() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select 物料ID,物料名称 from 物料", 
				new RowMapper<Materiel>() {
			@Override
			public Materiel mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new Materiel(rs.getString(1), rs.getString(2));
			}
		});
	}
}
