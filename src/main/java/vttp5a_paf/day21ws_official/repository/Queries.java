package vttp5a_paf.day21ws_official.repository;

public class Queries {
    public static String SQL_GET_ALL_CUSTOMERS = """
            select * from customers
                limit ?
                offset ?;
            """;

    public static String SQL_GET_CUSTOMER_BY_ID = """
            select * from customers
	            where id = ?;
            """;

    public static String SQL_GET_CUSTOMER_ORDERS = """
            select * from orders
	            where customer_id = ?;
            """;
}
