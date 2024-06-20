package com.kb.shop.repository;

import com.kb.shop.domain.Seller;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SellerRepository {

    private final JdbcTemplate jdbcTemplate;

    public SellerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Seller selectSellerInfo(Long id) {
        String sql = "SELECT * FROM seller WHERE id = ?";
//        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
//            Seller seller = new Seller();
//            seller.setId(rs.getLong("id"));
//            seller.setSellerName(rs.getString("sellerName"));
//            seller.setSellerGrade(rs.getse("sellerGrade"));
//            seller.setMargin(rs.getDouble("margin"));
//            seller.setPolicy(rs.getString("sellerPolicy"));
//            seller.setCategory(rs.getString("sellerCategory"));
//            return seller;
//        });

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Seller.class));
    }

    public void deleteSellerInfo(Long id) {
        String sql = "DELETE seller WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void setSellerInfo(Seller seller) {
        String sql = "INSERT INTO seller (seller_name, seller_grade, margin, policy, category) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, seller.getSellerName(), seller.getSellerGrade().toString(), seller.getMargin(), seller.getPolicy(), seller.getCategory());
    }
}
