package co.com.rappi.restAsure.models;

import lombok.Data;

@Data
public class ResponseSingleUser {

    private Integer page;
    private Integer perPage;
    private Integer total;
    private Integer totalPages;
    private DataLstUsers data;
    private Support support;
}
