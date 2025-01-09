package vttp5a_paf.day21ws_official.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Order {
    private int order_id;
    private int customer_id;
    private LocalDate order_date;
    private String ship_name;

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public LocalDate getOrder_date() {
        return order_date;
    }
    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }
    public String getShip_name() {
        return ship_name;
    }
    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public static Order toOrder(SqlRowSet rs){
        Order o = new Order();
        LocalDate orderDate = ((LocalDateTime)rs.getObject("order_date")).toLocalDate();
        

        o.setOrder_id(rs.getInt("id"));
        o.setCustomer_id(rs.getInt("customer_id"));
        o.setOrder_date(orderDate);
        o.setShip_name(rs.getString("ship_name"));

        return o;
    }

    public static JsonObject toJson(Order o) {

        JsonObject jObject = Json.createObjectBuilder()
                .add("order_id", o.getOrder_id())
                .add("customer_id", o.getCustomer_id())
                .add("order_date", o.getOrder_date().format(DateTimeFormatter.ISO_DATE))
                .add("ship_name", o.getShip_name())
                .build();

        return jObject;
    }
}
