package co.com.rappi.restAsure.models;
import lombok.Data;

import java.util.List;

@Data
public class ResponseLstUsers {

    private Integer page;
    private Integer perPage;
    private Integer total;
    private Integer totalPages;
    private List<DataLstUsers> data;
    private Support support;
}
