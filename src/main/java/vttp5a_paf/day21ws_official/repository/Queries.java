package vttp5a_paf.day21ws_official.repository;

public class Queries {
    public static String SQL_GET_ALL_CUSTOMERS = """
            select * from customers
                limit ?
                offset ?;
            """;
}
