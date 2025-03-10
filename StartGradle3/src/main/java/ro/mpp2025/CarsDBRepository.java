package ro.mpp2025;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarsDBRepository implements CarRepository {

    private JdbcUtils dbUtils;



    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
        logger.traceEntry("finding cars by manufacturer {} ", manufacturerN);
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM cars WHERE manufactures = ?")) {
            ps.setString(1, manufacturerN);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Car car = new Car(rs.getString("manufactures"), rs.getString("model"), rs.getInt("year"));
                    car.setId(rs.getInt("id"));
                    cars.add(car);
                }
            }
        } catch(SQLException e) {
            logger.error(e);
            System.out.println("Error DB "+e);
        }
        logger.traceExit();
        return cars;
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
        logger.traceEntry("finding cars between years {} and {}", min, max);
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement("SELECT * FROM cars WHERE year BETWEEN ? AND ?")) {
            ps.setInt(1, min);
            ps.setInt(2, max);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Car car = new Car(rs.getString("manufactures"), rs.getString("model"), rs.getInt("year"));
                    car.setId(rs.getInt("id"));
                    cars.add(car);
                }
            }
        } catch(SQLException e) {
            logger.error(e);
            System.out.println("Error DB "+e);
        }
        logger.traceExit();
        return cars;
    }

    @Override
    public void add(Car elem) {
        logger.traceEntry("saving task {} " ,elem);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("insert into cars (manufactures , model , year) values (?,?,?)")){

            preStmt.setString(1, elem.getManufacturer());
            preStmt.setString(2, elem.getModel());
            preStmt.setInt(3, elem.getYear());
            int result = preStmt.executeUpdate();
            logger.traceExit("Saved {} instances" , result);
        } catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        logger.traceExit();
    }

    @Override
    public void update(Integer integer, Car elem) {
        logger.traceEntry("updating car with id {} ", integer);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement ps = con.prepareStatement("UPDATE cars SET manufactures = ?, model = ?, year = ? WHERE id = ?")) {
            ps.setString(1, elem.getManufacturer());
            ps.setString(2, elem.getModel());
            ps.setInt(3, elem.getYear());
            ps.setInt(4, integer);
            int result = ps.executeUpdate();
            logger.trace("Updated {} instances", result);
        } catch(SQLException e) {
            logger.error(e);
            System.out.println("Error DB "+e);
        }
        logger.traceExit();
    }

    @Override
    public Iterable<Car> findAll() {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preStmt = con.prepareStatement("select * from cars")){
            try (ResultSet rs = preStmt.executeQuery()){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String manufacturer = rs.getString("manufactures");
                    String model = rs.getString("model");
                    int year = rs.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        } catch (SQLException ex){
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        logger.traceExit(cars);
        return cars;

    }
}
