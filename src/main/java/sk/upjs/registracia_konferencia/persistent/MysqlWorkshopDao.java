package sk.upjs.registracia_konferencia.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sk.upjs.registracia_konferencia.entities.Workshop;

public class MysqlWorkshopDao implements WorkshopDao {

	private JdbcTemplate jdbcTemplate;

	
	public MysqlWorkshopDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Workshop> getAll(){
		String sql = "SELECT id,name,start,end,price_full,price_student,price_full_late,price_student_late FROM workshop";
		return jdbcTemplate.query(sql,new RowMapper<Workshop>() {

			@Override
			public Workshop mapRow(ResultSet rs, int rowNum) throws SQLException {
				Workshop workshop = new Workshop();
				workshop.setId(rs.getLong("id"));
				workshop.setName(rs.getString("name"));
				Timestamp timestamp = rs.getTimestamp("start");
				if (timestamp!=null) {
					workshop.setStart(timestamp.toLocalDateTime().toLocalDate());
				}
				timestamp = rs.getTimestamp("end");
				if (timestamp!=null) {
					workshop.setEnd(timestamp.toLocalDateTime().toLocalDate());
				}
				workshop.setPriceFull(rs.getDouble("price_full"));
				workshop.setPriceStudent(rs.getDouble("price_student"));
				workshop.setPriceFullLate(rs.getDouble("price_full_late"));
				workshop.setPriceStudentLate(rs.getDouble("price_student_late"));
				
				return workshop;
			}
			
		});
	}
	
}
