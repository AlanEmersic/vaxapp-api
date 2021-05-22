package hr.tvz.emersic.vaxapp.repository;

import hr.tvz.emersic.vaxapp.model.Vaccine;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class JdbcVaccineRepository implements VaccineRepository {
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert vaccineInserter;

    public JdbcVaccineRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.vaccineInserter = new SimpleJdbcInsert(jdbc).
                withTableName("vaccine").usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Vaccine> findAll() {
        return jdbc.query("select id, manufacturer_name, research_name, number_of_shots, " +
                "available_doses, type from Vaccine", this::mapRowToVaccine);
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String researchName) {
        try {
            return Optional.ofNullable(jdbc.queryForObject("select id, manufacturer_name, research_name," +
                    " number_of_shots, " + "available_doses, type from Vaccine" +
                    " where research_name = ?", this::mapRowToVaccine, researchName));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Vaccine> findVaccinesByResearchName(String query) {
        try {
            return jdbc.query("select id, manufacturer_name, research_name, number_of_shots, " +
                    "available_doses, type from Vaccine where LOWER(research_name) like ?", this::mapRowToVaccine, query.toLowerCase() + "%");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Vaccine> findVaccineByNumberOfShots(boolean isOneShot) {
        return null;
    }

    @Override
    public Optional<Vaccine> save(Vaccine vaccine) {
        try {
            vaccine.setId(saveVaccineDetails(vaccine));
            return Optional.of(vaccine);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Vaccine> update(String researchName, Vaccine updateVaccine) {
        int executed = jdbc.update("update vaccine set " +
                        "manufacturer_name = ?, " +
                        "number_of_shots = ?, " +
                        "available_doses = ? " +
                        "type = ? " +
                        "where research_name = ?",
                updateVaccine.getManufacturerName(),
                updateVaccine.getNumberOfShots(),
                updateVaccine.getAvailableDoses(),
                updateVaccine.getType(),
                updateVaccine.getResearchName()
        );

        if (executed > 0) {
            return Optional.of(updateVaccine);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Vaccine> updateNumberOfDoses(String researchName, Vaccine updateVaccine) {
        return Optional.empty();
    }

    @Override
    public Optional<Vaccine> updateNumberOfDoses(String researchName, int numberOfDoses) {
        return Optional.empty();
    }

    @Override
    public void deleteByResearchName(String researchName) {
        jdbc.update("delete from vaccine where research_name = ?", researchName);
    }

    private Vaccine mapRowToVaccine(ResultSet rs, int rowNum) throws SQLException {
        return new Vaccine(
                rs.getLong("id"),
                rs.getString("manufacturer_name"),
                rs.getString("research_name"),
                rs.getInt("number_of_shots"),
                rs.getInt("available_doses"),
                Vaccine.Type.valueOf(rs.getString("type"))
        );
    }

    private long saveVaccineDetails(Vaccine vaccine) {
        Map<String, Object> values = new HashMap<>();

        values.put("manufacturer_name", vaccine.getManufacturerName());
        values.put("research_name", vaccine.getResearchName());
        values.put("number_of_shots", vaccine.getNumberOfShots());
        values.put("available_doses", vaccine.getAvailableDoses());
        values.put("type", vaccine.getType());

        return vaccineInserter.executeAndReturnKey(values).longValue();
    }
}
